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
 * IstarUser entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.istarindia.apps.dao.IstarUser
 * @author MyEclipse Persistence Tools
 */
public class IstarUserDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(IstarUserDAO.class);
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

	public void save(IstarUser transientInstance) {
		log.debug("saving IstarUser instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(IstarUser persistentInstance) {
		log.debug("deleting IstarUser instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public IstarUser findById(java.lang.Integer id) {
		log.debug("getting IstarUser instance with id: " + id);
		try {
			IstarUser instance = (IstarUser) getSession().get("com.istarindia.apps.dao.IstarUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<IstarUser> findByExample(IstarUser instance) {
		log.debug("finding IstarUser instance by example");
		try {
			List<IstarUser> results = (List<IstarUser>) getSession().createCriteria("com.istarindia.apps.dao.IstarUser")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding IstarUser instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from IstarUser as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<IstarUser> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<IstarUser> findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	public List<IstarUser> findByIsVerified(Object isVerified) {
		return findByProperty(IS_VERIFIED, isVerified);
	}

	public List<IstarUser> findByIstarAuthorizationToken(Object istarAuthorizationToken) {
		return findByProperty(ISTAR_AUTHORIZATION_TOKEN, istarAuthorizationToken);
	}

	public List<IstarUser> findByMobile(Object mobile) {
		return findByProperty(MOBILE, mobile);
	}

	public List<IstarUser> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<IstarUser> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<IstarUser> findByTokenExpired(Object tokenExpired) {
		return findByProperty(TOKEN_EXPIRED, tokenExpired);
	}

	public List<IstarUser> findByTokenVerified(Object tokenVerified) {
		return findByProperty(TOKEN_VERIFIED, tokenVerified);
	}

	public List<IstarUser> findByUserType(Object userType) {
		return findByProperty(USER_TYPE, userType);
	}

	public List findAll() {
		log.debug("finding all IstarUser instances");
		try {
			String queryString = "from IstarUser";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public IstarUser merge(IstarUser detachedInstance) {
		log.debug("merging IstarUser instance");
		try {
			IstarUser result = (IstarUser) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(IstarUser instance) {
		log.debug("attaching dirty IstarUser instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(IstarUser instance) {
		log.debug("attaching clean IstarUser instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}