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
 * Presentaion entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.istarindia.apps.dao.Presentaion
 * @author MyEclipse Persistence Tools
 */
public class PresentaionDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(PresentaionDAO.class);
	// property constants

	public void save(Presentaion transientInstance) {
		log.debug("saving Presentaion instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Presentaion persistentInstance) {
		log.debug("deleting Presentaion instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Presentaion findById(java.lang.Integer id) {
		log.debug("getting Presentaion instance with id: " + id);
		try {
			Presentaion instance = (Presentaion) getSession().get("com.istarindia.apps.dao.Presentaion", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Presentaion> findByExample(Presentaion instance) {
		log.debug("finding Presentaion instance by example");
		try {
			List<Presentaion> results = (List<Presentaion>) getSession()
					.createCriteria("com.istarindia.apps.dao.Presentaion").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Presentaion instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Presentaion as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Presentaion instances");
		try {
			String queryString = "from Presentaion";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Presentaion merge(Presentaion detachedInstance) {
		log.debug("merging Presentaion instance");
		try {
			Presentaion result = (Presentaion) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Presentaion instance) {
		log.debug("attaching dirty Presentaion instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Presentaion instance) {
		log.debug("attaching clean Presentaion instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}