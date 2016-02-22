package com.istarindia.apps.dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Government entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.istarindia.apps.dao.Government
 * @author MyEclipse Persistence Tools
 */
public class GovernmentDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(GovernmentDAO.class);
	// property constants
	public static final String MAX_STUDENTS = "maxStudents";

	public void save(Government transientInstance) {
		log.debug("saving Government instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Government persistentInstance) {
		log.debug("deleting Government instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Government findById(java.lang.Integer id) {
		log.debug("getting Government instance with id: " + id);
		try {
			Government instance = (Government) getSession().get("com.istarindia.apps.dao.Government", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Government> findByExample(Government instance) {
		log.debug("finding Government instance by example");
		try {
			List<Government> results = (List<Government>) getSession()
					.createCriteria("com.istarindia.apps.dao.Government").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Government instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Government as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Government> findByMaxStudents(Object maxStudents) {
		return findByProperty(MAX_STUDENTS, maxStudents);
	}

	public List findAll() {
		log.debug("finding all Government instances");
		try {
			String queryString = "from Government";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Government merge(Government detachedInstance) {
		log.debug("merging Government instance");
		try {
			Government result = (Government) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Government instance) {
		log.debug("attaching dirty Government instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Government instance) {
		log.debug("attaching clean Government instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}