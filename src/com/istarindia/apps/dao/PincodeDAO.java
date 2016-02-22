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
 * Pincode entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.istarindia.apps.dao.Pincode
 * @author MyEclipse Persistence Tools
 */
public class PincodeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(PincodeDAO.class);
	// property constants
	public static final String CITY = "city";
	public static final String COUNTRY = "country";
	public static final String PIN = "pin";
	public static final String STATE = "state";

	public void save(Pincode transientInstance) {
		log.debug("saving Pincode instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Pincode persistentInstance) {
		log.debug("deleting Pincode instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Pincode findById(java.lang.Integer id) {
		log.debug("getting Pincode instance with id: " + id);
		try {
			Pincode instance = (Pincode) getSession().get("com.istarindia.apps.dao.Pincode", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Pincode> findByExample(Pincode instance) {
		log.debug("finding Pincode instance by example");
		try {
			List<Pincode> results = (List<Pincode>) getSession().createCriteria("com.istarindia.apps.dao.Pincode")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Pincode instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Pincode as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Pincode> findByCity(Object city) {
		return findByProperty(CITY, city);
	}

	public List<Pincode> findByCountry(Object country) {
		return findByProperty(COUNTRY, country);
	}

	public List<Pincode> findByPin(Object pin) {
		return findByProperty(PIN, pin);
	}

	public List<Pincode> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findAll() {
		log.debug("finding all Pincode instances");
		try {
			String queryString = "from Pincode";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Pincode merge(Pincode detachedInstance) {
		log.debug("merging Pincode instance");
		try {
			Pincode result = (Pincode) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Pincode instance) {
		log.debug("attaching dirty Pincode instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Pincode instance) {
		log.debug("attaching clean Pincode instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}