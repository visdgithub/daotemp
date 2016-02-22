package com.istarindia.apps.dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * CreativeCreator entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.istarindia.apps.dao.CreativeCreator
 * @author MyEclipse Persistence Tools
 */
public class CreativeCreatorDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(CreativeCreatorDAO.class);
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

	public void save(CreativeCreator transientInstance) {
		log.debug("saving CreativeCreator instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CreativeCreator persistentInstance) {
		log.debug("deleting CreativeCreator instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CreativeCreator findById(java.lang.Integer id) {
		log.debug("getting CreativeCreator instance with id: " + id);
		try {
			CreativeCreator instance = (CreativeCreator) getSession().get("com.istarindia.apps.dao.CreativeCreator",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<CreativeCreator> findByExample(CreativeCreator instance) {
		log.debug("finding CreativeCreator instance by example");
		try {
			List<CreativeCreator> results = (List<CreativeCreator>) getSession()
					.createCriteria("com.istarindia.apps.dao.CreativeCreator").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CreativeCreator instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from CreativeCreator as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<CreativeCreator> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<CreativeCreator> findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	public List<CreativeCreator> findByIsVerified(Object isVerified) {
		return findByProperty(IS_VERIFIED, isVerified);
	}

	public List<CreativeCreator> findByIstarAuthorizationToken(Object istarAuthorizationToken) {
		return findByProperty(ISTAR_AUTHORIZATION_TOKEN, istarAuthorizationToken);
	}

	public List<CreativeCreator> findByMobile(Object mobile) {
		return findByProperty(MOBILE, mobile);
	}

	public List<CreativeCreator> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<CreativeCreator> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<CreativeCreator> findByTokenExpired(Object tokenExpired) {
		return findByProperty(TOKEN_EXPIRED, tokenExpired);
	}

	public List<CreativeCreator> findByTokenVerified(Object tokenVerified) {
		return findByProperty(TOKEN_VERIFIED, tokenVerified);
	}

	public List<CreativeCreator> findByUserType(Object userType) {
		return findByProperty(USER_TYPE, userType);
	}

	public List findAll() {
		log.debug("finding all CreativeCreator instances");
		try {
			String queryString = "from CreativeCreator";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CreativeCreator merge(CreativeCreator detachedInstance) {
		log.debug("merging CreativeCreator instance");
		try {
			CreativeCreator result = (CreativeCreator) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CreativeCreator instance) {
		log.debug("attaching dirty CreativeCreator instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CreativeCreator instance) {
		log.debug("attaching clean CreativeCreator instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}