package net.therap.dao.oracle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author ashraf
 * @since 5/20/14
 */
@Repository
@Transactional(value = "oracleTm")
public class TherapEntityDao {
    private static final Logger log = LoggerFactory.getLogger(TherapEntityDao.class);

    @PersistenceContext(unitName = "therap")
    private EntityManager em;
}
