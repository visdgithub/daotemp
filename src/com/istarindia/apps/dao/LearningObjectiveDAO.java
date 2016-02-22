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
 * LearningObjective entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.istarindia.apps.dao.LearningObjective
 * @author MyEclipse Persistence Tools
 */
public class LearningObjectiveDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(LearningObjectiveDAO.class);
	// property constants
	public static final String OBJ_TYPE = "objType";
	public static final String TITLE = "title";

	public void save(LearningObjective transientInstance) {
		log.debug("saving LearningObjective instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(LearningObjective persistentInstance) {
		log.debug("deleting LearningObjective instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LearningObjective findById(java.lang.Integer id) {
		log.debug("getting LearningObjective instance with id: " + id);
		try {
			LearningObjective instance = (LearningObjective) getSession()
					.get("com.istarindia.apps.dao.LearningObjective", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<LearningObjective> findByExample(LearningObjective instance) {
		log.debug("finding LearningObjective instance by example");
		try {
			List<LearningObjective> results = (List<LearningObjective>) getSession()
					.createCriteria("com.istarindia.apps.dao.LearningObjective").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding LearningObjective instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from LearningObjective as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<LearningObjective> findByObjType(Object objType) {
		return findByProperty(OBJ_TYPE, objType);
	}

	public List<LearningObjective> findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findAll() {
		log.debug("finding all LearningObjective instances");
		try {
			String queryString = "from LearningObjective";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public LearningObjective merge(LearningObjective detachedInstance) {
		log.debug("merging LearningObjective instance");
		try {
			LearningObjective result = (LearningObjective) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(LearningObjective instance) {
		log.debug("attaching dirty LearningObjective instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LearningObjective instance) {
		log.debug("attaching clean LearningObjective instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}