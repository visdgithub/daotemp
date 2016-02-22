package com.istarindia.apps.services;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.istarindia.apps.StatusTypes;
import com.istarindia.apps.dao.Cmsession;
import com.istarindia.apps.dao.CmsessionDAO;
import com.istarindia.apps.dao.CourseDAO;
import com.istarindia.apps.dao.IstarUserDAO;
import com.istarindia.apps.dao.Lesson;
import com.istarindia.apps.dao.LessonDAO;
import com.istarindia.apps.dao.Module;
import com.istarindia.apps.dao.ModuleDAO;
import com.istarindia.apps.dao.Task;
import com.istarindia.apps.dao.TaskDAO;

public class TaskService {

	
	
	public void createTask(Integer itemId, String itemType, String reviewScheme, String status, String taskName, Integer actorId,
			Integer ownerId)
	{
		TaskDAO dao = new TaskDAO();
		Task task = new Task();
		task.setItemId(itemId);
		task.setItemType(itemType);
		task.setReviewScheme(reviewScheme);
		task.setTaskName(taskName);
		task.setOwnerId(ownerId);
		task.setActorId(actorId);
		task.setStatus(status);
	
		
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			dao.attachDirty(task);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		
	}
	
	public void assignTaskToContentCreator(int task_id, int content_creator_id)
	{
		 TaskDAO dao = new TaskDAO();
		Task task =dao.findById(task_id);
		task.setActorId(content_creator_id);
		task.setStatus(StatusTypes.CONTENT_ASSIGNED);
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			dao.attachDirty(task);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
	public void assignSessionToContentCreator(int session_id, int content_creator_id)
	{
		List<Lesson> lesson_list = new LessonDAO().findByProperty("Cmsession", new CmsessionDAO().findById(session_id));
		for(Lesson lesson : lesson_list)
		{
			TaskDAO dao = new TaskDAO();
			Task task = (Task)dao.findByItemId(lesson.getId()).get(0);
			assignTaskToContentCreator(task.getId(),content_creator_id);	
		}
	}
	
	public void assignModuleToContentCreator(int module_id, int content_creator_id)
	{
		List<Cmsession> session_list = new CmsessionDAO().findByProperty("Module",new ModuleDAO().findById(module_id));
		for(Cmsession cmsession: session_list)
		{
			List<Lesson> lesson_list = new LessonDAO().findByProperty("Cmsession", new CmsessionDAO().findById(cmsession.getId()));
			for(Lesson lesson : lesson_list)
			{
				TaskDAO dao = new TaskDAO();
				Task task = (Task)dao.findByItemId(lesson.getId()).get(0);
				assignTaskToContentCreator(task.getId(),content_creator_id);	
			}
		}
		
	}
	
	public void assignCourseToContentCreator(int course_id, int content_creator_id)
	{
		List<Module> module_list =  new ModuleDAO().findByProperty("Course", new CourseDAO().findById(course_id));
		for(Module module: module_list)
		{
			List<Cmsession> session_list = new CmsessionDAO().findByProperty("Module",new ModuleDAO().findById(module.getId()));
			for(Cmsession cmsession: session_list)
			{
				List<Lesson> lesson_list = new LessonDAO().findByProperty("Cmsession", new CmsessionDAO().findById(cmsession.getId()));
				for(Lesson lesson : lesson_list)
				{
					TaskDAO dao = new TaskDAO();
					Task task = (Task)dao.findByItemId(lesson.getId()).get(0);
					assignTaskToContentCreator(task.getId(),content_creator_id);	
				}
			}
		}		
	}
	
}