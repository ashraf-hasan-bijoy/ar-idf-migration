package net.therap.dao.ar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author ashraf
 * @since 5/20/14
 */
@Repository
@Transactional(value = "h2dbTm")
public class ArEntityDao {

    private static final Logger log = LoggerFactory.getLogger(ArEntityDao.class);

    @PersistenceContext(unitName = "ar")
    private EntityManager em;
}
