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
 * QualificationPack entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.istarindia.apps.dao.QualificationPack
 * @author MyEclipse Persistence Tools
 */
public class QualificationPackDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(QualificationPackDAO.class);
	// property constants
	public static final String JOBROLE = "jobrole";
	public static final String QP_CODE = "qpCode";

	public void save(QualificationPack transientInstance) {
		log.debug("saving QualificationPack instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(QualificationPack persistentInstance) {
		log.debug("deleting QualificationPack instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public QualificationPack findById(java.lang.Integer id) {
		log.debug("getting QualificationPack instance with id: " + id);
		try {
			QualificationPack instance = (QualificationPack) getSession()
					.get("com.istarindia.apps.dao.QualificationPack", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<QualificationPack> findByExample(QualificationPack instance) {
		log.debug("finding QualificationPack instance by example");
		try {
			List<QualificationPack> results = (List<QualificationPack>) getSession()
					.createCriteria("com.istarindia.apps.dao.QualificationPack").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding QualificationPack instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from QualificationPack as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<QualificationPack> findByJobrole(Object jobrole) {
		return findByProperty(JOBROLE, jobrole);
	}

	public List<QualificationPack> findByQpCode(Object qpCode) {
		return findByProperty(QP_CODE, qpCode);
	}

	public List findAll() {
		log.debug("finding all QualificationPack instances");
		try {
			String queryString = "from QualificationPack";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public QualificationPack merge(QualificationPack detachedInstance) {
		log.debug("merging QualificationPack instance");
		try {
			QualificationPack result = (QualificationPack) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(QualificationPack instance) {
		log.debug("attaching dirty QualificationPack instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(QualificationPack instance) {
		log.debug("attaching clean QualificationPack instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}