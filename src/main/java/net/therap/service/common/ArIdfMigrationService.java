package net.therap.service.common;

import net.therap.db.entity.common.Client;
import net.therap.db.entity.common.ClientDetail;
import net.therap.db.entity.common.Provider;
import net.therap.db.entity.medicalInfo.DiagnosisCode;
import net.therap.db.entity.medicalInfo.IndividualDiagnosis;
import net.therap.model.therap.ArClient;
import net.therap.model.therap.MigrationDataUnit;
import net.therap.service.ar.ArDataService;
import net.therap.service.therap.TherapDataService;
import net.therap.model.ar.*;
import net.therap.util.CollectionUtils;
import net.therap.util.StringUtils;
import net.therap.util.TherapDomainFactory;
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
    private static final Logger log = LoggerFactory.getLogger(ArIdfMigrationService.class);

    private Provider provider;
    @Autowired
    private ArDataService arDataService;

    @Autowired
    private TherapDataService therapDataService;

    public void processMigration() {
        provider = therapDataService.getProvider("DDD-AR");
        migrateForCMSMaster();
        migrateForDDSRoot();
    }

    public void migrateForCMSMaster() {
        long rowCount = arDataService.getCmsMasterCount();
        int firstResult = 0;

        while (firstResult <= rowCount) {
            List<CmsMaster> cmsMasters = arDataService.getCmsMasters(firstResult, MAX_ROWS);

            if (CollectionUtils.isNotEmpty(cmsMasters)) {
                for (CmsMaster master : cmsMasters) {
                    int clientId = master.getCmsPcpExemptDate();
                    DdsRoot ddsRoot = arDataService.getDdsRootByClientId(clientId);

                    migrateToTherapIdf(master, ddsRoot, clientId);
                }
            }

            firstResult = firstResult + MAX_ROWS;
        }
    }

    public void migrateForDDSRoot() {
        long rowCount = arDataService.getDbsRootCount();
        int firstResult = 0;

        while (firstResult <= rowCount) {
            List<DdsRoot> ddsRoots = arDataService.getDdsRoots(firstResult, MAX_ROWS);

            if (CollectionUtils.isNotEmpty(ddsRoots)) {
                for (DdsRoot root : ddsRoots) {
                    long clientId = root.getClientId();
                    CmsMaster cmsMaster = arDataService.getCmsMasterByClientId(clientId);

                    if (cmsMaster != null) {
                        continue;
                    }

                    migrateToTherapIdf(null, root, clientId);
                }
            }

            firstResult = firstResult + MAX_ROWS;
        }

    }

    public void migrateToTherapIdf(CmsMaster master, DdsRoot ddsRoot, long clientId) {

        DdsCmFinance finance = arDataService.getDdsCmFinanceByClientId(clientId);
        List<MedicaidDenial> denials = arDataService.getMedicaidDenialsByClientId(clientId);
        DdsField field = arDataService.getDdsFieldByClientId(clientId);

        Client client = TherapDomainFactory.createClient(master, ddsRoot, provider, therapDataService.getArClientOversightId());
        ClientDetail clientDetail = TherapDomainFactory.createClientDetail(master, ddsRoot);
        ArClient arClient = TherapDomainFactory.createArClient(master, ddsRoot, finance, denials, field);
        List<IndividualDiagnosis> individualDiagnoses = getIndividualDiagnosisList(master);

        therapDataService.saveTherapIdf(new MigrationDataUnit(client, clientDetail, arClient, individualDiagnoses));
    }

    public List<IndividualDiagnosis> getIndividualDiagnosisList(CmsMaster master) {

        List<IndividualDiagnosis> individualDiagnoses = new ArrayList<IndividualDiagnosis>();
        List<String> diagnosisCodeList = Arrays.asList(master.getCmsDiagnosis1(), master.getCmsDiagnosis2(),
                master.getCmsDiagnosis3(), master.getCmsDiagnosis4(), master.getCmsDiagnosis5(),
                master.getCmsDiagnosis5());

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
        int indexOfDot = code.startsWith("E") ? 3 : 4;

        if (code.length() > indexOfDot) {
            code = new StringBuffer(code).insert(indexOfDot, ".").toString();
        }

        return code;
    }
}
