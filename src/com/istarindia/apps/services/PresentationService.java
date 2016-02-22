package com.istarindia.apps.services;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.istarindia.apps.LessonTypes;
import com.istarindia.apps.StatusTypes;
import com.istarindia.apps.TaskItemType;
import com.istarindia.apps.TaskTypes;
import com.istarindia.apps.dao.CmsessionDAO;
import com.istarindia.apps.dao.ContentAdminDAO;
import com.istarindia.apps.dao.ContentCreatorDAO;
import com.istarindia.apps.dao.LearningObjective;
import com.istarindia.apps.dao.Lesson;
import com.istarindia.apps.dao.LessonDAO;
import com.istarindia.apps.dao.Presentaion;
import com.istarindia.apps.dao.PresentaionDAO;
import com.istarindia.apps.dao.Slide;
import com.istarindia.apps.dao.SlideDAO;

public class PresentationService {
	
	/*Here user_id can be id of ContentAdmin/ContentCreator.
	If user is Admin then he/she will become the owner and actore of task, and status will be "CREATED". 
	IF user is Admin_Creator then he/she will be actor only. Owner will be the uploader of session. Status will become "CONTENT_ASSIGNED"
	*/
	public Presentaion createPresentation(Integer cmsession_id, Integer duration, String tags, String title, String dtype,
			Set<LearningObjective> learningObjectives, int user_id)
	{
		Presentaion lesson = new Presentaion();
		lesson.setDuration(duration);
		lesson.setLearningObjectives(learningObjectives);
		lesson.setTitle(title);
		lesson.setTags(tags);
		lesson.setLessonType(LessonTypes.PRESENTATION);
		lesson.setDtype("dtype");
		lesson.setCmsession(new CmsessionDAO().findById(cmsession_id));
		PresentaionDAO dao = new PresentaionDAO();
		
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			dao.attachDirty(lesson);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		lesson.setId(lesson.getId());
		TaskService taskservice = new TaskService();
		if(new ContentAdminDAO().findById(user_id)!= null)
		{
			taskservice.createTask(lesson.getId(), TaskItemType.LESSON, "ALL", StatusTypes.CREATED, TaskTypes.CREATE_LESSON, user_id, user_id);
		}
		else if(new ContentCreatorDAO().findById(user_id)!=null)
		{
			taskservice.createTask(lesson.getId(),TaskItemType.LESSON, "ALL", StatusTypes.CONTENT_ASSIGNED, TaskTypes.CREATE_LESSON, user_id, new CmsessionDAO().findById(cmsession_id).getContentAdmin().getId());
		}
		return lesson;
	}
	
	public Presentaion updatePresentation(int lesson_id , Integer cmsession_id, Integer duration, String lessonType, String tags, String title, String dtype,
			Set<LearningObjective> learningObjectives)
	{
		Presentaion lesson=new PresentaionDAO().findById(lesson_id);
		
		lesson.setDuration(duration);
		lesson.setLearningObjectives(learningObjectives);
		lesson.setTitle(title);
		lesson.setTags(tags);
	
		lesson.setDtype("dtype");
		if(cmsession_id!=null)
		{	
			lesson.setCmsession(new CmsessionDAO().findById(cmsession_id));
		}
		LessonDAO dao = new LessonDAO();
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			dao.attachDirty(lesson);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return lesson;
	}
	
	public List<Slide> getAllSlidesInLesson(int presentationId) {
		SlideDAO slideDAO = new SlideDAO();
		

		List<Slide> allSlidesInThePresentation = slideDAO.findByProperty("presentaion", new PresentaionDAO().findById(presentationId));

		return allSlidesInThePresentation;
	}
	
	public String getStudentNotesForPreview(int presentation_id)
	{
		StringBuffer sb = new StringBuffer();
		for(Slide slide : getAllSlidesInLesson(presentation_id))
		{
			if(slide.getStudentNotes()!=null)
			{
				sb.append(slide.getStudentNotes());
			}	
		}
		return sb.toString();
	}
	
	public String getTeacherNotesForPreview(int presentation_id)
	{
		StringBuffer sb = new StringBuffer();
		for(Slide slide : getAllSlidesInLesson(presentation_id))
		{
			if(slide.getTeacherNotes()!=null)
			{
				sb.append(slide.getTeacherNotes());
			}	
		}
		return sb.toString();
	}
	
	public int getNumberOfSlidesInPresentation(int presentationId) {
		List<Slide> slides = this.getAllSlidesInLesson(presentationId);

		return slides.size();
	}
}
