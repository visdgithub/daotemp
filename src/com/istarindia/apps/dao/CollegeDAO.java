package com.istarindia.apps.dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * College entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.istarindia.apps.dao.College
 * @author MyEclipse Persistence Tools
 */
public class CollegeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(CollegeDAO.class);
	// property constants
	public static final String MAX_STUDENTS = "maxStudents";

	public void save(College transientInstance) {
		log.debug("saving College instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(College persistentInstance) {
		log.debug("deleting College instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public College findById(java.lang.Integer id) {
		log.debug("getting College instance with id: " + id);
		try {
			College instance = (College) getSession().get("com.istarindia.apps.dao.College", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<College> findByExample(College instance) {
		log.debug("finding College instance by example");
		try {
			List<College> results = (List<College>) getSession().createCriteria("com.istarindia.apps.dao.College")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding College instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from College as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<College> findByMaxStudents(Object maxStudents) {
		return findByProperty(MAX_STUDENTS, maxStudents);
	}

	public List findAll() {
		log.debug("finding all College instances");
		try {
			String queryString = "from College";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public College merge(College detachedInstance) {
		log.debug("merging College instance");
		try {
			College result = (College) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(College instance) {
		log.debug("attaching dirty College instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(College instance) {
		log.debug("attaching clean College instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}