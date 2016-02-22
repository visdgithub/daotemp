package com.istarindia.apps.dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * SuperAdmin entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.istarindia.apps.dao.SuperAdmin
 * @author MyEclipse Persistence Tools
 */
public class SuperAdminDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(SuperAdminDAO.class);
	// property constants
	public static final String EMAIL = "email";
	public static final String GENDER = "gender";
	public static final String IS_VERIFIED = "isVerified";
	public static final String ISTAR_AUTHORIZATION_TOKEN = "istarAuthorizationToken";
	public static final String MOBILE = "mobile";
	public static final String NAME = "name";
	public static final String PASSWORD = "password";
	public static final String TOKEN_EXPIRED = "tokenExpired";
	public static final String TOKEN_VERIFIED = "tokenVerified";
	public static final String USER_TYPE = "userType";

	public void save(SuperAdmin transientInstance) {
		log.debug("saving SuperAdmin instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SuperAdmin persistentInstance) {
		log.debug("deleting SuperAdmin instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SuperAdmin findById(java.lang.Integer id) {
		log.debug("getting SuperAdmin instance with id: " + id);
		try {
			SuperAdmin instance = (SuperAdmin) getSession().get("com.istarindia.apps.dao.SuperAdmin", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<SuperAdmin> findByExample(SuperAdmin instance) {
		log.debug("finding SuperAdmin instance by example");
		try {
			List<SuperAdmin> results = (List<SuperAdmin>) getSession()
					.createCriteria("com.istarindia.apps.dao.SuperAdmin").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding SuperAdmin instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from SuperAdmin as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<SuperAdmin> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<SuperAdmin> findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	public List<SuperAdmin> findByIsVerified(Object isVerified) {
		return findByProperty(IS_VERIFIED, isVerified);
	}

	public List<SuperAdmin> findByIstarAuthorizationToken(Object istarAuthorizationToken) {
		return findByProperty(ISTAR_AUTHORIZATION_TOKEN, istarAuthorizationToken);
	}

	public List<SuperAdmin> findByMobile(Object mobile) {
		return findByProperty(MOBILE, mobile);
	}

	public List<SuperAdmin> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<SuperAdmin> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<SuperAdmin> findByTokenExpired(Object tokenExpired) {
		return findByProperty(TOKEN_EXPIRED, tokenExpired);
	}

	public List<SuperAdmin> findByTokenVerified(Object tokenVerified) {
		return findByProperty(TOKEN_VERIFIED, tokenVerified);
	}

	public List<SuperAdmin> findByUserType(Object userType) {
		return findByProperty(USER_TYPE, userType);
	}

	public List findAll() {
		log.debug("finding all SuperAdmin instances");
		try {
			String queryString = "from SuperAdmin";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SuperAdmin merge(SuperAdmin detachedInstance) {
		log.debug("merging SuperAdmin instance");
		try {
			SuperAdmin result = (SuperAdmin) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SuperAdmin instance) {
		log.debug("attaching dirty SuperAdmin instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SuperAdmin instance) {
		log.debug("attaching clean SuperAdmin instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}