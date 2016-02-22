package com.istarindia.apps.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Slide
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.istarindia.apps.dao.Slide
 * @author MyEclipse Persistence Tools
 */
public class SlideDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(SlideDAO.class);
	// property constants
	public static final String SLIDE_TEXT = "slideText";
	public static final String TEACHER_NOTES = "teacherNotes";
	public static final String STUDENT_NOTES = "studentNotes";

	public void save(Slide transientInstance) {
		log.debug("saving Slide instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Slide persistentInstance) {
		log.debug("deleting Slide instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Slide findById(java.lang.Integer id) {
		log.debug("getting Slide instance with id: " + id);
		try {
			Slide instance = (Slide) getSession().get("com.istarindia.apps.dao.Slide", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Slide> findByExample(Slide instance) {
		log.debug("finding Slide instance by example");
		try {
			List<Slide> results = (List<Slide>) getSession().createCriteria("com.istarindia.apps.dao.Slide")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Slide instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Slide as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Slide> findBySlideText(Object slideText) {
		return findByProperty(SLIDE_TEXT, slideText);
	}

	public List<Slide> findByTeacherNotes(Object teacherNotes) {
		return findByProperty(TEACHER_NOTES, teacherNotes);
	}

	public List<Slide> findByStudentNotes(Object studentNotes) {
		return findByProperty(STUDENT_NOTES, studentNotes);
	}

	public List findAll() {
		log.debug("finding all Slide instances");
		try {
			String queryString = "from Slide";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Slide merge(Slide detachedInstance) {
		log.debug("merging Slide instance");
		try {
			Slide result = (Slide) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Slide instance) {
		log.debug("attaching dirty Slide instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Slide instance) {
		log.debug("attaching clean Slide instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}