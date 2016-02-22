package com.istarindia.apps.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.istarindia.apps.LessonTypes;
import com.istarindia.apps.StatusTypes;
import com.istarindia.apps.TaskItemType;
import com.istarindia.apps.TaskTypes;
import com.istarindia.apps.UserTypes;
import com.istarindia.apps.dao.Cmsession;
import com.istarindia.apps.dao.CmsessionDAO;
import com.istarindia.apps.dao.ContentAdmin;
import com.istarindia.apps.dao.ContentAdminDAO;
import com.istarindia.apps.dao.ContentCreator;
import com.istarindia.apps.dao.ContentCreatorDAO;
import com.istarindia.apps.dao.ContentReviewer;
import com.istarindia.apps.dao.ContentReviewerDAO;
import com.istarindia.apps.dao.IstarUser;
import com.istarindia.apps.dao.IstarUserDAO;
import com.istarindia.apps.dao.LearningObjective;
import com.istarindia.apps.dao.Lesson;
import com.istarindia.apps.dao.LessonDAO;
import com.istarindia.apps.dao.Presentaion;
import com.istarindia.apps.dao.Task;
import com.istarindia.apps.dao.TaskDAO;
import com.istarindia.apps.dao.TaskReviewer;
import com.istarindia.apps.dao.TaskReviewerDAO;

public class LessonService {
	
	/*lesson list
	returns the list of lessons that are in published state*/
	public List<Lesson> getPublishedLessons()
	{
		TaskDAO dao = new TaskDAO();
		List<Lesson> lessons = new ArrayList<Lesson>();
		List<Task> tasks = dao.findByStatus(StatusTypes.PUBLISHED);
		for(Task task : tasks)
		{
			if(task.getItemType().equalsIgnoreCase(TaskItemType.LESSON))
			{
				lessons.add(new LessonDAO().findById(task.getItemId()));
			}
		}
		return lessons;
	}
	
	//all lessons assigned to a particular content creator, which are in a particular status
	//status could be "CONTENT_ASSIGNED", "DRAFT", "APPROVED", "REQUEST_FOR_PUBLISH"
	public List<Lesson> getAllLessonAssignedTO_ContentCreator(int user_id, String status) 
	{
		
		TaskDAO dao = new TaskDAO();
		List<Lesson> lessons = new ArrayList<Lesson>();
		List<Task> tasks = dao.findByActorId(user_id);
		for(Task task : tasks)
		{
			if(task.getItemType().equalsIgnoreCase(TaskItemType.LESSON) && task.getStatus().equalsIgnoreCase(status))
			{
				lessons.add(new LessonDAO().findById(task.getItemId()));
			}
		}
		return lessons;
	}
	
	/* Will return all lessons assigned to content creator, 
	 * which are disapproved by at least one reviewer
	 * 
	 */		
		public List<Lesson> getAllLessonDisApprovedByReviewer(int user_id) 
		{
			
			TaskDAO dao = new TaskDAO();
			List<Lesson> lessons = new ArrayList<Lesson>();
			List<Task> tasks = dao.findByActorId(user_id);
			for(Task task : tasks)
			{
				List<TaskReviewer> list = new TaskReviewerDAO().findByProperty("task", task);
				if( list.size()>0 )
				{
					for(TaskReviewer taskreview : list)
					{
						if(taskreview.getStatus().equalsIgnoreCase(StatusTypes.DIS_APPROVED))
						{
							lessons.add(new LessonDAO().findById(task.getItemId()));
							break;
						}
					}
				}
			}
			return lessons;
		}
	
	//return all lessons assigned to a content creator
	public List<Lesson> getAllLessonAssignedTO_ContentCreator(int user_id) 
	{
		
		TaskDAO dao = new TaskDAO();
		List<Lesson> lessons = new ArrayList<Lesson>();
		List<Task> tasks = dao.findByActorId(user_id);
		for(Task task : tasks)
		{
			if(task.getItemType().equalsIgnoreCase(TaskItemType.LESSON))
			{
				lessons.add(new LessonDAO().findById(task.getItemId()));
			}
		}
		return lessons;
	}
	
/*	all lessons uploaded/assigned by content admin, and which are in particular status.
 * status can be CREATED, DRAFT, COMPLETED, CONTENT_ASSIGNED
 *  REVIEWER_NOT_ASSIGNED,REVIEW_PENDING, APPROVED, PUBLISHED, REQUEST_FOR_PUBLISH. 
*/	public List<Lesson> getAllLessonAssignedBy_ContentAdmin(int user_id, String status) 
	{
		List<Lesson> lessons = new ArrayList<Lesson>();
		if(status.equalsIgnoreCase(StatusTypes.REVIEWER_NOT_ASSIGNED))
		{
			lessons = getAllLessonsWithoutReviewerAssigned(user_id);
		}
		else if(status.equalsIgnoreCase(StatusTypes.REVIEW_PENDING))
		{
			lessons = getAllLessonsWithReviewPending( user_id);
		}	
		else
		{	
			TaskDAO dao = new TaskDAO();
			
			List<Task> tasks = dao.findByOwnerId(user_id);
			for(Task task : tasks)
			{
				if(task.getItemType().equalsIgnoreCase(TaskItemType.LESSON) && task.getStatus().equalsIgnoreCase(status))
				{
					lessons.add(new LessonDAO().findById(task.getItemId()));
				}
			}
		}
		return lessons;
	}
	
	
	
	//all lessons uploaded/assigned by content admin
	public List<Lesson> getAllLessonAssignedBy_ContentAdmin(int user_id) 
	{
		TaskDAO dao = new TaskDAO();
		List<Lesson> lessons = new ArrayList<Lesson>();
		List<Task> tasks = dao.findByOwnerId(user_id);
		for(Task task : tasks)
		{
			if(task.getItemType().equalsIgnoreCase(TaskItemType.LESSON))
			{
				lessons.add(new LessonDAO().findById(task.getItemId()));
			}
		}
		return lessons;
	}
	
	//lessons for which reviewer is not assigned
	public List<Lesson> getAllLessonsWithoutReviewerAssigned(int user_id)
	{
		List<Lesson> lessons = new ArrayList<Lesson>();
		for(Task task : new TaskDAO().findByOwnerId(user_id))
		{
			if(new TaskReviewerDAO().findByProperty("task", task).size()==0)
			{
				lessons.add(new LessonDAO().findById(task.getItemId()));
			}
		}
		return lessons;
	}
	
	//lessons for which reviewer is assigned but review is pending
	//user_id is user id of Content Admin
	public List<Lesson> getAllLessonsWithReviewPending(int user_id)
	{
		
		List<Lesson> lessons = new ArrayList<Lesson>();
		for(Task task : new TaskDAO().findByOwnerId(user_id))
		{
			if(new TaskReviewerDAO().findByProperty("task", task).size()>0)
			{
				List <TaskReviewer> taskreview = new TaskReviewerDAO().findByProperty("task", task);
				boolean reviewPending=true;
				for(TaskReviewer t: taskreview)
				{
					if(!t.getStatus().equalsIgnoreCase(StatusTypes.REVIEWER_ASSIGNED))
					{
						reviewPending=false;
					}
				}
				if(reviewPending)
				{
					lessons.add(new LessonDAO().findById(task.getItemId()));
				}
				//
			}
		}
		return lessons;
	}
	
	//all lessons assigned to reviewer for review
	public List<Lesson> getAllLessonAssignedToReviewer(int user_id)
	{
		ContentReviewer user = new ContentReviewerDAO().findById(user_id);
		List<Lesson> lessons = new ArrayList<Lesson>();
		TaskReviewerDAO dao = new TaskReviewerDAO();
		@SuppressWarnings("unchecked")
		List<Task> tasks = dao.findByProperty("contentReviewer", user);
		for(Task task : tasks)
		{
			if(task.getItemType().equalsIgnoreCase(TaskItemType.LESSON))
			{
				lessons.add(new LessonDAO().findById(task.getItemId()));
			}
		}
		return lessons;
	}
	
	/* return count of all the lessons created by content Admin */
	public int getTotalLessonCreatedByAdmin(int content_admin_id)
	{
		return getAllLessonAssignedBy_ContentAdmin(content_admin_id).size();
	}
	
	/*
	 * return count of all the lessons for which contentCreator is not assigned 
	 * */
	public int getAllLessonWithContentNotAssignedForAdmin(int content_admin_id)
	{
		return getAllLessonAssignedBy_ContentAdmin(content_admin_id, StatusTypes.CREATED).size();
	}
	
	
	/*
	 * return count of all the lessons for which content Admin of DRAFT 
	 * */
	public int getAllLessonWithContentAdminLessonDraft(int content_admin_id)
	{
		return getAllLessonAssignedBy_ContentAdmin(content_admin_id, StatusTypes.DRAFT).size();
	}
	
	/*
	 * return count of all the lessons for which content Admin of COMPLETED 
	 * */
	public int getAllLessonWithContentAdminLessonCompleted(int content_admin_id)
	{
		return getAllLessonAssignedBy_ContentAdmin(content_admin_id, StatusTypes.COMPLETED).size();
	}
	
	/*
	 * return count of all the lessons for which content Admin of  CONTENT_ASSIGNED
	 * */
	public int getAllLessonWithContentAdminLessonContentAssigned(int content_admin_id)
	{
		return getAllLessonAssignedBy_ContentAdmin(content_admin_id, StatusTypes.CONTENT_ASSIGNED).size();
	}

	/*
	 * return count of all the lessons for which content Admin of APPROVED
	 * */
	public int getAllLessonWithContentAdminLessonApproved(int content_admin_id)
	{
		return getAllLessonAssignedBy_ContentAdmin(content_admin_id, StatusTypes.APPROVED).size();
	}
	/*
	 * return count of all the lessons for which content Admin of PUBLISHED
	 * */
	public int getAllLessonWithContentAdminLessonPublished(int content_admin_id)
	{
		return getAllLessonAssignedBy_ContentAdmin(content_admin_id, StatusTypes.PUBLISHED).size();
	}
	/*
	 * return count of all the lessons for which content Admin of REQUEST_FOR_PUBLISH
	 * */
	public int getAllLessonWithContentAdminLessonRequestForPublish(int content_admin_id)
	{
		return getAllLessonAssignedBy_ContentAdmin(content_admin_id, StatusTypes.REQUEST_FOR_PUBLISH).size();
	}
/*	
	Here user_id can be id of ContentAdmin/ContentCreator.
	If user is Admin then he/she will become the owner and actore of task, and status will be "CREATED". 
	IF user is Admin_Creator then he/she will be actor only. Owner will be the uploader of session. Status will become "CONTENT_ASSIGNED"*/
	public void createLesson(Integer cmsession_id, Integer duration, String lessonType, String tags, String title, String dtype,
			Set<LearningObjective> learningObjectives, int user_id)
	{
		Lesson lesson=null;
		if(lessonType.equalsIgnoreCase(LessonTypes.PRESENTATION))
		{
			new PresentationService().createPresentation(cmsession_id, duration, tags, title, dtype, learningObjectives, user_id);
		}
		
	}
	
	public void updateLesson(int lesson_id , Integer cmsession_id, Integer duration, String lessonType, String tags, String title, String dtype,
			Set<LearningObjective> learningObjectives)
	{
		if(lessonType.equalsIgnoreCase(LessonTypes.PRESENTATION))
		{
			new PresentationService().updatePresentation(lesson_id, cmsession_id, duration, lessonType, tags, title, dtype, learningObjectives);
		}
	}
	
	public void deleteLesson(int lesson_id)
	{
		Lesson lesson=new LessonDAO().findById(lesson_id);
		LessonDAO dao = new LessonDAO();
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			dao.delete(lesson);
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