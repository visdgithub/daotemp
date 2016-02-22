package com.istarindia.apps.dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * LearningOutcome entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.istarindia.apps.dao.LearningOutcome
 * @author MyEclipse Persistence Tools
 */
public class LearningOutcomeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(LearningOutcomeDAO.class);
	// property constants
	public static final String TITLE = "title";

	public void save(LearningOutcome transientInstance) {
		log.debug("saving LearningOutcome instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(LearningOutcome persistentInstance) {
		log.debug("deleting LearningOutcome instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LearningOutcome findById(java.lang.Integer id) {
		log.debug("getting LearningOutcome instance with id: " + id);
		try {
			LearningOutcome instance = (LearningOutcome) getSession().get("com.istarindia.apps.dao.LearningOutcome",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<LearningOutcome> findByExample(LearningOutcome instance) {
		log.debug("finding LearningOutcome instance by example");
		try {
			List<LearningOutcome> results = (List<LearningOutcome>) getSession()
					.createCriteria("com.istarindia.apps.dao.LearningOutcome").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding LearningOutcome instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from LearningOutcome as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<LearningOutcome> findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findAll() {
		log.debug("finding all LearningOutcome instances");
		try {
			String queryString = "from LearningOutcome";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public LearningOutcome merge(LearningOutcome detachedInstance) {
		log.debug("merging LearningOutcome instance");
		try {
			LearningOutcome result = (LearningOutcome) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(LearningOutcome instance) {
		log.debug("attaching dirty LearningOutcome instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LearningOutcome instance) {
		log.debug("attaching clean LearningOutcome instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}