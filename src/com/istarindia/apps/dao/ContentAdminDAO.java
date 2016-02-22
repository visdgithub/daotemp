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
 * ContentAdmin entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.istarindia.apps.dao.ContentAdmin
 * @author MyEclipse Persistence Tools
 */
public class ContentAdminDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ContentAdminDAO.class);
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

	public void save(ContentAdmin transientInstance) {
		log.debug("saving ContentAdmin instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ContentAdmin persistentInstance) {
		log.debug("deleting ContentAdmin instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ContentAdmin findById(java.lang.Integer id) {
		log.debug("getting ContentAdmin instance with id: " + id);
		try {
			ContentAdmin instance = (ContentAdmin) getSession().get("com.istarindia.apps.dao.ContentAdmin", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ContentAdmin> findByExample(ContentAdmin instance) {
		log.debug("finding ContentAdmin instance by example");
		try {
			List<ContentAdmin> results = (List<ContentAdmin>) getSession()
					.createCriteria("com.istarindia.apps.dao.ContentAdmin").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding ContentAdmin instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from ContentAdmin as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ContentAdmin> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<ContentAdmin> findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	public List<ContentAdmin> findByIsVerified(Object isVerified) {
		return findByProperty(IS_VERIFIED, isVerified);
	}

	public List<ContentAdmin> findByIstarAuthorizationToken(Object istarAuthorizationToken) {
		return findByProperty(ISTAR_AUTHORIZATION_TOKEN, istarAuthorizationToken);
	}

	public List<ContentAdmin> findByMobile(Object mobile) {
		return findByProperty(MOBILE, mobile);
	}

	public List<ContentAdmin> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<ContentAdmin> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<ContentAdmin> findByTokenExpired(Object tokenExpired) {
		return findByProperty(TOKEN_EXPIRED, tokenExpired);
	}

	public List<ContentAdmin> findByTokenVerified(Object tokenVerified) {
		return findByProperty(TOKEN_VERIFIED, tokenVerified);
	}

	public List<ContentAdmin> findByUserType(Object userType) {
		return findByProperty(USER_TYPE, userType);
	}

	public List findAll() {
		log.debug("finding all ContentAdmin instances");
		try {
			String queryString = "from ContentAdmin";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ContentAdmin merge(ContentAdmin detachedInstance) {
		log.debug("merging ContentAdmin instance");
		try {
			ContentAdmin result = (ContentAdmin) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ContentAdmin instance) {
		log.debug("attaching dirty ContentAdmin instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ContentAdmin instance) {
		log.debug("attaching clean ContentAdmin instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}