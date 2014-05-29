package net.therap.service.common;

import net.therap.db.entity.ar.ArClient;
import net.therap.db.entity.common.Client;
import net.therap.db.entity.common.ClientDetail;
import net.therap.db.entity.common.Provider;
import net.therap.db.entity.medicalInfo.DiagnosisCode;
import net.therap.db.entity.medicalInfo.IndividualDiagnosis;
import net.therap.model.therap.MigrationDataUnit;
import net.therap.service.ar.ArDataService;
import net.therap.service.therap.TherapDataService;
import net.therap.model.ar.*;
import net.therap.util.CollectionUtils;
import net.therap.util.StringUtils;
import net.therap.util.TherapDomainFactory;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author ashraf
 * @since 5/20/14
 */
@Service
public class ArIdfMigrationService {

    private static final int MAX_ROWS = 500;

    private static final int DEFAULT_NOW_YEAR = 2014;
    private static final int DEFAULT_NOW_MONTH = 7;
    private static final int DEFAULT_NOW_DAY = 1;

    private static final int TYPE_EC_MIN_AGE = 3;
    private static final int TYPE_EC_MAX_AGE = 5;

    private static List<String> VALID_CMS_MASTER_STATUS = Arrays.asList("A", "J", "K", "P", "X");

    private static final Logger log = LoggerFactory.getLogger(ArIdfMigrationService.class);

    @Autowired
    private Provider activeProvider;

    @Autowired
    private ArDataService arDataService;

    @Autowired
    private TherapDataService therapDataService;

    public void processMigration() {
        migrateForDDSRoot();
        migrateForCMSMaster();
    }

    public void migrateForDDSRoot() {
        long rowCount = arDataService.getDbsRootCount();
        int firstResult = 0;

        while (firstResult <= rowCount) {
            List<DdsRoot> ddsRoots = arDataService.getDdsRoots(firstResult, MAX_ROWS);

            if (CollectionUtils.isNotEmpty(ddsRoots)) {
                for (DdsRoot root : ddsRoots) {
                    if (!isValidDdsRoot(root)) {
                        log.debug("Validation failed for Dds root row. DDS ID={}", root.getClientId());
                        continue;
                    }

                    long clientId = root.getClientId();
                    CmsMaster cmsMaster = arDataService.getCmsMasterByClientId(clientId);

                    migrateToTherapIdf(cmsMaster, root, clientId);
                }
            }

            firstResult = firstResult + MAX_ROWS;
        }
    }

    public void migrateForCMSMaster() {
        long rowCount = arDataService.getCmsMasterCount();
        int firstResult = 0;

        while (firstResult <= rowCount) {
            List<CmsMaster> cmsMasters = arDataService.getCmsMasters(firstResult, MAX_ROWS);

            if (CollectionUtils.isNotEmpty(cmsMasters)) {
                for (CmsMaster master : cmsMasters) {
                    if (!isValidCmsMaster(master)) {
                        log.debug("Validation failed for Cms Master Row. CMS ID={}", master.getCmsId());
                        continue;
                    }

                    long clientId = master.getCmsPcpExemptDate();
                    DdsRoot ddsRoot = arDataService.getDdsRootByClientId(clientId);

                    if (ddsRoot != null && therapDataService.getArClient(ddsRoot.getClientId(), master.getCmsId()) != null) {
                        continue;
                    }

                    migrateToTherapIdf(master, ddsRoot, clientId);
                }
            }

            firstResult = firstResult + MAX_ROWS;
        }
    }

    public void migrateToTherapIdf(CmsMaster master, DdsRoot ddsRoot, long clientId) {

        DdsCmFinance finance = arDataService.getDdsCmFinanceByClientId(clientId);
        List<MedicaidDenial> denials = arDataService.getMedicaidDenialsByClientId(clientId);
        DdsField field = arDataService.getDdsFieldByClientId(clientId);

        Client client = TherapDomainFactory.createClient(master, ddsRoot, activeProvider, therapDataService.getArClientOversightId());
        ClientDetail clientDetail = TherapDomainFactory.createClientDetail(master, ddsRoot);
        ArClient arClient = TherapDomainFactory.createArClient(master, ddsRoot, finance, denials, field, activeProvider);
        List<IndividualDiagnosis> individualDiagnoses = getIndividualDiagnosisList(master);

        therapDataService.saveTherapIdf(new MigrationDataUnit(client, clientDetail, arClient, individualDiagnoses));
    }

    public List<IndividualDiagnosis> getIndividualDiagnosisList(CmsMaster master) {

        if (master == null) {
            return null;
        }
        List<IndividualDiagnosis> individualDiagnoses = new ArrayList<IndividualDiagnosis>();
        List<String> diagnosisCodeList = Arrays.asList(master.getCmsDiagnosis1(), master.getCmsDiagnosis2(),
                master.getCmsDiagnosis3(), master.getCmsDiagnosis4(), master.getCmsDiagnosis5(),
                master.getCmsDiagnosis6());

        for (String code : diagnosisCodeList) {
            if (StringUtils.isEmpty(code)) {
                continue;
            }

            code = formatDiagnosisCode(code);
            DiagnosisCode diagnosis = therapDataService.getIndividualDiagnosis(code);

            if (diagnosis != null) {
                IndividualDiagnosis individualDiagnosis = new IndividualDiagnosis();
                individualDiagnosis.setDiagnosisCode(diagnosis);
                individualDiagnoses.add(individualDiagnosis);
            }

        }

        return individualDiagnoses;
    }

    private String formatDiagnosisCode(String code) {

        code = code.replaceAll("\\W+", "");
        int indexOfDot = code.startsWith("E") ? 4 : 3;

        if (code.length() > indexOfDot) {
            code = new StringBuffer(code).insert(indexOfDot, ".").toString();
        }

        return code;
    }

    private boolean isValidCmsMaster(CmsMaster master) {
        String status = master.getCmsStatus();
        boolean isValid = false;

        for (String validStatus : VALID_CMS_MASTER_STATUS) {
            if (StringUtils.isNotEmpty(status) && status.equalsIgnoreCase(validStatus)) {
                isValid = true;
            }
        }

        return isValid;
    }

    private boolean isValidDdsRoot(DdsRoot root) {

        DateTime now = new DateTime(DEFAULT_NOW_YEAR, DEFAULT_NOW_MONTH, DEFAULT_NOW_DAY, 0, 0, 0, 0);

        Period period = new Period(now, new DateTime(root.getClientDateOfBirth()));
        int age = period.getYears();

        String ifspType = arDataService.getDdsIfspTypeByClientId(root.getClientId());
        boolean isDdsRootTypeEc = (age >= TYPE_EC_MIN_AGE && age <= TYPE_EC_MAX_AGE)
                && StringUtils.isNotEmpty(ifspType) && ifspType.equalsIgnoreCase("EC");

        if (isDdsRootTypeEc) {
            return true;
        } else {

            boolean isDdsRootTypeEi = arDataService.isActiveEiClientExists(root.getClientId());
            boolean isDdsRootTypeDdtcs = (!isDdsRootTypeEi && age < TYPE_EC_MIN_AGE);

            return isDdsRootTypeEi || isDdsRootTypeDdtcs;
        }
    }

}
