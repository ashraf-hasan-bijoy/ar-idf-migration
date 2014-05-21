package net.therap.service.ar;

import net.therap.model.ar.*;
import net.therap.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author ashraf
 * @since 5/20/14
 */
@Service
public class ArDataService {

    private static final Logger log = LoggerFactory.getLogger(ArDataService.class);

    @PersistenceContext(unitName = "ar")
    private EntityManager em;


    public int getDbsRootCount(){
        return em.createQuery("SELECT COUNT(root) FROM DdsRoot root", BigDecimal.class)
                .getSingleResult().intValue();
    }

    public List<DdsRoot> getDdsRoots(int firstResult, int maxResult){
       return em.createQuery("SELECT root FROM DdsRoot root", DdsRoot.class)
               .setFirstResult(firstResult)
               .setMaxResults(maxResult)
               .getResultList();
    }

    public DdsRoot getDdsRootByClientId(int clientId){
        List<DdsRoot> ddsRoots = em.createQuery("SELECT root FROM DdsRoot root" +
                " WHERE root.clientId = :clientId", DdsRoot.class)
                .setParameter("clientId", clientId)
                .getResultList();

        return CollectionUtils.isNotEmpty(ddsRoots) ? ddsRoots.get(0) : null;
    }


    public int getCmsMasterCount(){
        return em.createQuery("SELECT COUNT(master) FROM CmsMaster master", BigDecimal.class)
                .getSingleResult().intValue();
    }

    public List<CmsMaster> getCmsMasters(int firstResult, int maxResult){
        return em.createQuery("SELECT master FROM CmsMaster master", CmsMaster.class)
                .setFirstResult(firstResult)
                .setMaxResults(maxResult)
                .getResultList();
    }

    public CmsMaster getCmsMasterByClientId(int clientId){
        List<CmsMaster> cmsMasters = em.createQuery("SELECT master FROM CmsMaster master" +
                " WHERE master.cmsPcpExemptDate = :clientId", CmsMaster.class)
                .setParameter("clientId", clientId)
                .getResultList();

        return CollectionUtils.isNotEmpty(cmsMasters) ? cmsMasters.get(0) : null;
    }

    public DdsCmFinance getDdsCmFinanceByClientId(int clientId){
        List<DdsCmFinance> ddsCmFinances = em.createQuery("SELECT finance FROM DdsCmFinance finance" +
                " WHERE finance.ddsId = :clientId", DdsCmFinance.class)
                .setParameter("clientId", clientId)
                .getResultList();

        return CollectionUtils.isNotEmpty(ddsCmFinances) ? ddsCmFinances.get(0) : null;
    }

    public MedicalDenial getMedicalDenialByClientId(int clientId) {
        List<MedicalDenial> medicalDenials = em.createQuery("SELECT med FROM MedicalDenial med" +
                " WHERE med.clientId = :clientId", MedicalDenial.class)
                .setParameter("clientId", clientId)
                .getResultList();

        return CollectionUtils.isNotEmpty(medicalDenials) ? medicalDenials.get(0) : null;
    }

    public DdsField getDdsFieldByClientId(int clientId){
        List<DdsField> ddsFields = em.createQuery("SELECT field FROM DdsField field" +
                " WHERE field.fieldClientId = :clientId", DdsField.class)
                .setParameter("clientId", clientId)
                .getResultList();

        return CollectionUtils.isNotEmpty(ddsFields) ? ddsFields.get(0) : null;
    }
}
