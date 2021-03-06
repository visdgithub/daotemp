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
 * Cmsession entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.istarindia.apps.dao.Cmsession
 * @author MyEclipse Persistence Tools
 */
public class CmsessionDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(CmsessionDAO.class);
	// property constants
	public static final String TITLE = "title";

	public void save(Cmsession transientInstance) {
		log.debug("saving Cmsession instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Cmsession persistentInstance) {
		log.debug("deleting Cmsession instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cmsession findById(java.lang.Integer id) {
		log.debug("getting Cmsession instance with id: " + id);
		try {
			Cmsession instance = (Cmsession) getSession().get("com.istarindia.apps.dao.Cmsession", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Cmsession> findByExample(Cmsession instance) {
		log.debug("finding Cmsession instance by example");
		try {
			List<Cmsession> results = (List<Cmsession>) getSession().createCriteria("com.istarindia.apps.dao.Cmsession")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Cmsession instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Cmsession as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Cmsession> findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findAll() {
		log.debug("finding all Cmsession instances");
		try {
			String queryString = "from Cmsession";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Cmsession merge(Cmsession detachedInstance) {
		log.debug("merging Cmsession instance");
		try {
			Cmsession result = (Cmsession) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Cmsession instance) {
		log.debug("attaching dirty Cmsession instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cmsession instance) {
		log.debug("attaching clean Cmsession instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}