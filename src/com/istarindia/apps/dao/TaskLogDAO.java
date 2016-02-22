package com.istarindia.apps.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TaskLog entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.istarindia.apps.dao.TaskLog
 * @author MyEclipse Persistence Tools
 */
public class TaskLogDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TaskLogDAO.class);
	// property constants
	public static final String TASK_ID = "taskId";
	public static final String CHANGED_STATUS = "changedStatus";
	public static final String COMMENTS = "comments";
	public static final String ACTOR_ID = "actorId";

	public void save(TaskLog transientInstance) {
		log.debug("saving TaskLog instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TaskLog persistentInstance) {
		log.debug("deleting TaskLog instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TaskLog findById(java.lang.Integer id) {
		log.debug("getting TaskLog instance with id: " + id);
		try {
			TaskLog instance = (TaskLog) getSession().get("com.istarindia.apps.dao.TaskLog", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TaskLog> findByExample(TaskLog instance) {
		log.debug("finding TaskLog instance by example");
		try {
			List<TaskLog> results = (List<TaskLog>) getSession().createCriteria("com.istarindia.apps.dao.TaskLog")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TaskLog instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from TaskLog as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TaskLog> findByTaskId(Object taskId) {
		return findByProperty(TASK_ID, taskId);
	}

	public List<TaskLog> findByChangedStatus(Object changedStatus) {
		return findByProperty(CHANGED_STATUS, changedStatus);
	}

	public List<TaskLog> findByComments(Object comments) {
		return findByProperty(COMMENTS, comments);
	}

	public List<TaskLog> findByActorId(Object actorId) {
		return findByProperty(ACTOR_ID, actorId);
	}

	public List findAll() {
		log.debug("finding all TaskLog instances");
		try {
			String queryString = "from TaskLog";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TaskLog merge(TaskLog detachedInstance) {
		log.debug("merging TaskLog instance");
		try {
			TaskLog result = (TaskLog) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TaskLog instance) {
		log.debug("attaching dirty TaskLog instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TaskLog instance) {
		log.debug("attaching clean TaskLog instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}