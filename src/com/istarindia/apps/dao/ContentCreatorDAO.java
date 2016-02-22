package com.istarindia.apps.dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * ContentCreator entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.istarindia.apps.dao.ContentCreator
 * @author MyEclipse Persistence Tools
 */
public class ContentCreatorDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ContentCreatorDAO.class);
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

	public void save(ContentCreator transientInstance) {
		log.debug("saving ContentCreator instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ContentCreator persistentInstance) {
		log.debug("deleting ContentCreator instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ContentCreator findById(java.lang.Integer id) {
		log.debug("getting ContentCreator instance with id: " + id);
		try {
			ContentCreator instance = (ContentCreator) getSession().get("com.istarindia.apps.dao.ContentCreator", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ContentCreator> findByExample(ContentCreator instance) {
		log.debug("finding ContentCreator instance by example");
		try {
			List<ContentCreator> results = (List<ContentCreator>) getSession()
					.createCriteria("com.istarindia.apps.dao.ContentCreator").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding ContentCreator instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from ContentCreator as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ContentCreator> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<ContentCreator> findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	public List<ContentCreator> findByIsVerified(Object isVerified) {
		return findByProperty(IS_VERIFIED, isVerified);
	}

	public List<ContentCreator> findByIstarAuthorizationToken(Object istarAuthorizationToken) {
		return findByProperty(ISTAR_AUTHORIZATION_TOKEN, istarAuthorizationToken);
	}

	public List<ContentCreator> findByMobile(Object mobile) {
		return findByProperty(MOBILE, mobile);
	}

	public List<ContentCreator> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<ContentCreator> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<ContentCreator> findByTokenExpired(Object tokenExpired) {
		return findByProperty(TOKEN_EXPIRED, tokenExpired);
	}

	public List<ContentCreator> findByTokenVerified(Object tokenVerified) {
		return findByProperty(TOKEN_VERIFIED, tokenVerified);
	}

	public List<ContentCreator> findByUserType(Object userType) {
		return findByProperty(USER_TYPE, userType);
	}

	public List findAll() {
		log.debug("finding all ContentCreator instances");
		try {
			String queryString = "from ContentCreator";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ContentCreator merge(ContentCreator detachedInstance) {
		log.debug("merging ContentCreator instance");
		try {
			ContentCreator result = (ContentCreator) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ContentCreator instance) {
		log.debug("attaching dirty ContentCreator instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ContentCreator instance) {
		log.debug("attaching clean ContentCreator instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}