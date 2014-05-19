package net.therap.service;

import net.therap.db.entity.sis.SisDataFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author ashraf
 * @since 5/15/14
 */
@Service
@Transactional
public class TestService {

    @PersistenceContext
    EntityManager em;

    Logger logger = LoggerFactory.getLogger(TestService.class);

    public void test(){
        List<SisDataFile> pharmacyList = em.createQuery("select ph from SisDataFile ph").getResultList();

        for(SisDataFile ph : pharmacyList){
           logger.debug("Data File Name : " + ph.getFileName());
        }
    }

}
