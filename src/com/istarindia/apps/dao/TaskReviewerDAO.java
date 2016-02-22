package com.istarindia.apps.dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TaskReviewer entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.istarindia.apps.dao.TaskReviewer
 * @author MyEclipse Persistence Tools
 */
public class TaskReviewerDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TaskReviewerDAO.class);
	// property constants
	public static final String STATUS = "status";

	public void save(TaskReviewer transientInstance) {
		log.debug("saving TaskReviewer instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TaskReviewer persistentInstance) {
		log.debug("deleting TaskReviewer instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TaskReviewer findById(java.lang.Integer id) {
		log.debug("getting TaskReviewer instance with id: " + id);
		try {
			TaskReviewer instance = (TaskReviewer) getSession().get("com.istarindia.apps.dao.TaskReviewer", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TaskReviewer> findByExample(TaskReviewer instance) {
		log.debug("finding TaskReviewer instance by example");
		try {
			List<TaskReviewer> results = (List<TaskReviewer>) getSession()
					.createCriteria("com.istarindia.apps.dao.TaskReviewer").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TaskReviewer instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from TaskReviewer as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TaskReviewer> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all TaskReviewer instances");
		try {
			String queryString = "from TaskReviewer";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TaskReviewer merge(TaskReviewer detachedInstance) {
		log.debug("merging TaskReviewer instance");
		try {
			TaskReviewer result = (TaskReviewer) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TaskReviewer instance) {
		log.debug("attaching dirty TaskReviewer instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TaskReviewer instance) {
		log.debug("attaching clean TaskReviewer instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}