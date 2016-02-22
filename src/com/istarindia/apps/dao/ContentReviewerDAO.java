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
 * ContentReviewer entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.istarindia.apps.dao.ContentReviewer
 * @author MyEclipse Persistence Tools
 */
public class ContentReviewerDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ContentReviewerDAO.class);
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

	public void save(ContentReviewer transientInstance) {
		log.debug("saving ContentReviewer instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ContentReviewer persistentInstance) {
		log.debug("deleting ContentReviewer instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ContentReviewer findById(java.lang.Integer id) {
		log.debug("getting ContentReviewer instance with id: " + id);
		try {
			ContentReviewer instance = (ContentReviewer) getSession().get("com.istarindia.apps.dao.ContentReviewer",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ContentReviewer> findByExample(ContentReviewer instance) {
		log.debug("finding ContentReviewer instance by example");
		try {
			List<ContentReviewer> results = (List<ContentReviewer>) getSession()
					.createCriteria("com.istarindia.apps.dao.ContentReviewer").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding ContentReviewer instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from ContentReviewer as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ContentReviewer> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<ContentReviewer> findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	public List<ContentReviewer> findByIsVerified(Object isVerified) {
		return findByProperty(IS_VERIFIED, isVerified);
	}

	public List<ContentReviewer> findByIstarAuthorizationToken(Object istarAuthorizationToken) {
		return findByProperty(ISTAR_AUTHORIZATION_TOKEN, istarAuthorizationToken);
	}

	public List<ContentReviewer> findByMobile(Object mobile) {
		return findByProperty(MOBILE, mobile);
	}

	public List<ContentReviewer> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<ContentReviewer> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<ContentReviewer> findByTokenExpired(Object tokenExpired) {
		return findByProperty(TOKEN_EXPIRED, tokenExpired);
	}

	public List<ContentReviewer> findByTokenVerified(Object tokenVerified) {
		return findByProperty(TOKEN_VERIFIED, tokenVerified);
	}

	public List<ContentReviewer> findByUserType(Object userType) {
		return findByProperty(USER_TYPE, userType);
	}

	public List findAll() {
		log.debug("finding all ContentReviewer instances");
		try {
			String queryString = "from ContentReviewer";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ContentReviewer merge(ContentReviewer detachedInstance) {
		log.debug("merging ContentReviewer instance");
		try {
			ContentReviewer result = (ContentReviewer) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ContentReviewer instance) {
		log.debug("attaching dirty ContentReviewer instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ContentReviewer instance) {
		log.debug("attaching clean ContentReviewer instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}