package com.istarindia.apps.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * NationalOccupationalStandard entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.istarindia.apps.dao.NationalOccupationalStandard
 * @author MyEclipse Persistence Tools
 */
public class NationalOccupationalStandardDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(NationalOccupationalStandardDAO.class);
	// property constants
	public static final String CODE = "code";
	public static final String TITLE = "title";

	public void save(NationalOccupationalStandard transientInstance) {
		log.debug("saving NationalOccupationalStandard instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(NationalOccupationalStandard persistentInstance) {
		log.debug("deleting NationalOccupationalStandard instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public NationalOccupationalStandard findById(java.lang.Integer id) {
		log.debug("getting NationalOccupationalStandard instance with id: " + id);
		try {
			NationalOccupationalStandard instance = (NationalOccupationalStandard) getSession()
					.get("com.istarindia.apps.dao.NationalOccupationalStandard", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<NationalOccupationalStandard> findByExample(NationalOccupationalStandard instance) {
		log.debug("finding NationalOccupationalStandard instance by example");
		try {
			List<NationalOccupationalStandard> results = (List<NationalOccupationalStandard>) getSession()
					.createCriteria("com.istarindia.apps.dao.NationalOccupationalStandard").add(create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding NationalOccupationalStandard instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from NationalOccupationalStandard as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<NationalOccupationalStandard> findByCode(Object code) {
		return findByProperty(CODE, code);
	}

	public List<NationalOccupationalStandard> findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findAll() {
		log.debug("finding all NationalOccupationalStandard instances");
		try {
			String queryString = "from NationalOccupationalStandard";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public NationalOccupationalStandard merge(NationalOccupationalStandard detachedInstance) {
		log.debug("merging NationalOccupationalStandard instance");
		try {
			NationalOccupationalStandard result = (NationalOccupationalStandard) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(NationalOccupationalStandard instance) {
		log.debug("attaching dirty NationalOccupationalStandard instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NationalOccupationalStandard instance) {
		log.debug("attaching clean NationalOccupationalStandard instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}