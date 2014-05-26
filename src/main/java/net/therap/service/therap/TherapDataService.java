package net.therap.service.therap;

import net.therap.db.entity.common.Client;
import net.therap.db.entity.common.Provider;
import net.therap.db.entity.medicalInfo.DiagnosisCode;
import net.therap.db.entity.medicalInfo.IndividualDiagnosis;
import net.therap.model.therap.ArClient;
import net.therap.model.therap.MigrationDataUnit;
import net.therap.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author ashraf
 * @since 5/20/14
 */
@Service
@Transactional(value = "oracleTm")
public class TherapDataService {
    private static final Logger log = LoggerFactory.getLogger(TherapDataService.class);

    @PersistenceContext(unitName = "therap")
    private EntityManager em;

    public void saveTherapIdf(MigrationDataUnit unit) {
        em.persist(unit.getClientDetail());
        em.persist(unit.getClient());
        em.persist(unit.getArClient());

        for (IndividualDiagnosis diagnosis : unit.getIndividualDiagnosisList()) {
            em.persist(diagnosis);
        }
    }

    public DiagnosisCode getIndividualDiagnosis(String code) {
        List<DiagnosisCode> diagnosisCodes = em.createQuery("SELECT dc FROM DiagnosisCode AS dc"
                + " WHERE LOWER(dc.code) = :code", DiagnosisCode.class)
                .setParameter("code", code.toLowerCase())
                .getResultList();

        return CollectionUtils.isNotEmpty(diagnosisCodes) ? diagnosisCodes.get(0) : null;
    }

    public Provider getProvider(String code){
        return em.createQuery("SELECT p FROM Provider p where p.code = :code", Provider.class)
                .setParameter("code", code)
                .getSingleResult();
    }

    public String getArClientOversightId(){

        long oversightSeqId = em.createNamedQuery("SELECT ar_oversight_id_seq.nextval FROM DUAL", BigDecimal.class)
                .getSingleResult()
                .longValue();

        return String.valueOf(oversightSeqId);
    }

}
