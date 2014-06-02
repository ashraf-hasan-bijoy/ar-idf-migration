package net.therap.service.ar;

import net.therap.model.ar.*;
import net.therap.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Arrays;

/**
 * @author ashraf
 * @since 5/20/14
 */
@Service
public class ArDataService {

    private static final Logger log = LoggerFactory.getLogger(ArDataService.class);

    @PersistenceContext(unitName = "ar")
    private EntityManager em;


    public long getDbsRootCount(boolean fetchValid) {
        String sqlForValidRoot = fetchValid ? " WHERE root.validData IN (1, 2, 3)" : "";
        return (Long) em.createQuery("SELECT COUNT(root) FROM DdsRoot root" + sqlForValidRoot)
                .getSingleResult();
    }

    public List<DdsRoot> getDdsRoots(int firstResult, int maxResult, boolean fetchValid) {
        String sqlForValidRoot = fetchValid ? " WHERE root.validData IN (1, 2, 3)" : "";
        return em.createQuery("SELECT root FROM DdsRoot root" + sqlForValidRoot, DdsRoot.class)
                .setFirstResult(firstResult)
                .setMaxResults(maxResult)
                .getResultList();
    }

    public DdsRoot getDdsRootByClientId(Long clientId) {
        List<DdsRoot> ddsRoots = em.createQuery("SELECT root FROM DdsRoot root" +
                " WHERE root.clientId = :clientId", DdsRoot.class)
                .setParameter("clientId", clientId)
                .getResultList();

        return CollectionUtils.isNotEmpty(ddsRoots) ? ddsRoots.get(0) : null;
    }


    public long getCmsMasterCount(boolean fetchValid) {
        String sqlForValidMaster = fetchValid ? " WHERE master.validData = 1" : "";
        return (Long) em.createQuery("SELECT COUNT(master) FROM CmsMaster master" + sqlForValidMaster)
                .getSingleResult();
    }

    public List<CmsMaster> getCmsMasters(int firstResult, int maxResult, boolean fetchValid) {
        String sqlForValidMaster = fetchValid ? " WHERE master.validData = 1" : "";
        return em.createQuery("SELECT master FROM CmsMaster master" + sqlForValidMaster, CmsMaster.class)
                .setFirstResult(firstResult)
                .setMaxResults(maxResult)
                .getResultList();
    }

    public CmsMaster getCmsMasterByClientId(Long clientId) {
        List<CmsMaster> cmsMasters = em.createQuery("SELECT master FROM CmsMaster master" +
                " WHERE master.cmsPcpExemptDate = :clientId", CmsMaster.class)
                .setParameter("clientId", clientId)
                .getResultList();

        return CollectionUtils.isNotEmpty(cmsMasters) ? cmsMasters.get(0) : null;
    }

    public DdsCmFinance getDdsCmFinanceByClientId(Long clientId) {
        List<DdsCmFinance> ddsCmFinances = em.createQuery("SELECT finance FROM DdsCmFinance finance" +
                " WHERE finance.ddsId = :clientId", DdsCmFinance.class)
                .setParameter("clientId", clientId)
                .getResultList();

        return CollectionUtils.isNotEmpty(ddsCmFinances) ? ddsCmFinances.get(0) : null;
    }

    public List<MedicaidDenial> getMedicaidDenialsByClientId(Long clientId) {
        return em.createQuery("SELECT med FROM MedicaidDenial med" +
                " WHERE med.clientId = :clientId", MedicaidDenial.class)
                .setParameter("clientId", clientId)
                .getResultList();
    }

    public DdsField getDdsFieldByClientId(Long clientId) {
        List<DdsField> ddsFields = em.createQuery("SELECT field FROM DdsField field" +
                " WHERE field.fieldClientId = :clientId", DdsField.class)
                .setParameter("clientId", clientId)
                .getResultList();

        return CollectionUtils.isNotEmpty(ddsFields) ? ddsFields.get(0) : null;
    }


    public DdsFinancial getDdsFinancialByClientId(Long clientId){
        List<DdsFinancial> ddsFinancialList = em.createQuery("SELECT financial FROM DdsFinancial financial" +
                " WHERE financial.clientId = :clientId", DdsFinancial.class)
                .setParameter("clientId", clientId)
                .getResultList();

        return CollectionUtils.isNotEmpty(ddsFinancialList) ? ddsFinancialList.get(0) : null;
    }

    public boolean isActiveEiClientExists(long clientId) {
        List<ActiveEiClient> activeEiClients = em.createQuery("SELECT cl FROM ActiveEiClient cl" +
                " WHERE cl.clientId = :clientId", ActiveEiClient.class)
                .setParameter("clientId", clientId)
                .getResultList();

        return CollectionUtils.isNotEmpty(activeEiClients);
    }

    public String getDdsIfspTypeByClientId(long clientId) {
        List<DdsIfspSerialized> ddsIfspSerializeds = em.createQuery("SELECT ifsp FROM DdsIfspSerialized ifsp" +
                " WHERE ifsp.clientId = :clientId", DdsIfspSerialized.class)
                .setParameter("clientId", clientId)
                .getResultList();

        return CollectionUtils.isNotEmpty(ddsIfspSerializeds) ? ddsIfspSerializeds.get(0).getType() : null;
    }

    public void updateInvalidCmsMaster(List<Long> invalidCmsMasterId) {
        em.createQuery("UPDATE CmsMaster master SET master.validData = 0" +
                " WHERE master.cmsId IN :idList").setParameter("idList", invalidCmsMasterId).executeUpdate();
    }

    public void updateInvalidDdsRoot(List<Long> invalidDdsRootIds) {
        em.createQuery("UPDATE DdsRoot root SET root.validData = 0" +
                " WHERE root.clientId IN :idList").setParameter("idList", invalidDdsRootIds).executeUpdate();
    }

}