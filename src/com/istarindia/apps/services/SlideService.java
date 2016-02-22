package com.istarindia.apps.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.istarindia.apps.dao.Comment;
import com.istarindia.apps.dao.OrganizationDAO;
import com.istarindia.apps.dao.Presentaion;
import com.istarindia.apps.dao.PresentaionDAO;
import com.istarindia.apps.dao.Slide;
import com.istarindia.apps.dao.SlideDAO;

public class SlideService {

	public Slide createNewSlide(int presentaionId, String slideText, String studentNotes, String teacherNotes)
			throws RuntimeException {
		Slide slide = new Slide();

		Presentaion presentaion = new PresentaionDAO().findById(presentaionId);

		slide.setPresentaion(presentaion);
		slide.setSlideText(slideText);
		slide.setStudentNotes(studentNotes);
		slide.setTeacherNotes(teacherNotes);

		SlideDAO dao = new SlideDAO();
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.save(slide);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return slide;
	}

	public Slide updateSlide(int slideId, String slideText, String studentNotes, String teacherNotes)
			throws RuntimeException {
		SlideDAO dao = new SlideDAO();
		Slide slide = dao.findById(slideId);
		
		if (slide != null) {
			slide.setSlideText(slideText);
			slide.setStudentNotes(studentNotes);
			slide.setTeacherNotes(teacherNotes);
			Session session = dao.getSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				dao.save(slide);
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		} else {
			return null;
		}
		

		return slide;
	}

	public void deleteSlide(int slideId) throws RuntimeException {
		SlideDAO dao = new SlideDAO();
		

		Slide slide = dao.findById(slideId);
		if (slide != null) {
			Session session = dao.getSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				dao.delete(slide);
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		}

		
	}


	

}
