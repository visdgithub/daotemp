package istar;

import java.util.Set;

import com.istarindia.apps.LessonTypes;
import com.istarindia.apps.StatusTypes;
import com.istarindia.apps.dao.CmsessionDAO;
import com.istarindia.apps.dao.LearningObjective;
import com.istarindia.apps.dao.Lesson;
import com.istarindia.apps.services.LessonService;

public class TestLessonService {

	public static void main(String[] args) {
		int content_admin = 8;
		int content_creator[] = { 11,12,13,14 };
		
			// creating 10 lessons with contnt admin as 10
			// 4 as content creator
		LessonService service = new LessonService();
		/*Set<LearningObjective> learningObjectives=null;
			  for(int i=0;i<10;i++){
			  service.createLesson(1,30,LessonTypes.PRESENTATION, "sds sds sd d", "title"+i, "dtype", learningObjectives,content_admin);
			  }
			  for(int i=10;i<12;i++){
				  service.createLesson(1,30,LessonTypes.PRESENTATION, "sds sds sd d", "title"+i, "dtype", learningObjectives,content_creator[0]);
				  }
			  
			  for(int i=12;i<14;i++){
				  service.createLesson(1,30,LessonTypes.PRESENTATION, "sds sds sd d", "title"+i, "dtype", learningObjectives,content_creator[1]);
				  }
		*/

		System.out.println(new CmsessionDAO().findById(1).getTitle());


		// passing content Admin id and getting list of lessons which are Assigned by content Admin 
		System.out.println("AllLessonAssignedBy_ContentAdmin");
		//total
		System.out.println("Total lessons :" +service.getTotalLessonCreatedByAdmin(content_admin));
		//lessons in DRAFT
		System.out.println("Total lessons are in DRAFT :" +service.getAllLessonWithContentAdminLessonDraft(content_admin));
		//lessons in COMPLETED
		System.out.println("Total lessons are in Completed :" +service.getAllLessonWithContentAdminLessonCompleted(content_admin));
		
		for (Lesson lesson : service.getAllLessonAssignedBy_ContentAdmin(content_admin)) {
			System.out.println(lesson.getTitle());
		}

		
		// passing content Admin id && status and getting list of lessons which are Assigned by content Admin 
		//status="APPROVED"
		System.out.println("AllLessonAssignedBy_ContentAdmin with Status=APPROVED");
		for (Lesson lesson : service.getAllLessonAssignedBy_ContentAdmin(content_admin, StatusTypes.APPROVED)) {
			System.out.println(lesson.getTitle());
		}
		//status="COMPLETED"
		System.out.println("AllLessonAssignedBy_ContentAdmin with Status=COMPLETED");
		for (Lesson lesson : service.getAllLessonAssignedBy_ContentAdmin(content_admin, StatusTypes.COMPLETED)) {
			System.out.println(lesson.getTitle());
		}
		//status="CONTENT_ASSIGNED"
		System.out.println("AllLessonAssignedBy_ContentAdmin with Status=CONTENT_ASSIGNED");
		for (Lesson lesson : service.getAllLessonAssignedBy_ContentAdmin(content_admin, StatusTypes.CONTENT_ASSIGNED)) {
			System.out.println(lesson.getTitle());
		}
		//Status=CREATED
		System.out.println("AllLessonAssignedBy_ContentAdmin with Status=CREATED");
		for (Lesson lesson : service.getAllLessonAssignedBy_ContentAdmin(content_admin, StatusTypes.CREATED)) {
			System.out.println(lesson.getTitle());
		}
		//Status=DRAFT
		System.out.println("AllLessonAssignedBy_ContentAdmin with Status=DRAFT");
		for (Lesson lesson : service.getAllLessonAssignedBy_ContentAdmin(content_admin, StatusTypes.DRAFT)) {
			System.out.println(lesson.getTitle());
		}
		//Status=PUBLISHED
		System.out.println("AllLessonAssignedBy_ContentAdmin with Status=PUBLISHED");
		for (Lesson lesson : service.getAllLessonAssignedBy_ContentAdmin(content_admin, StatusTypes.PUBLISHED)) {
			System.out.println(lesson.getTitle());
		}
		//Status=REQUEST_FOR_PUBLISH
		System.out.println("AllLessonAssignedBy_ContentAdmin with Status=REQUEST_FOR_PUBLISH");
		for (Lesson lesson : service.getAllLessonAssignedBy_ContentAdmin(content_admin,
				StatusTypes.REQUEST_FOR_PUBLISH)) {
			System.out.println(lesson.getTitle());
		}
		
		
		//passing content Creator id and getting list of lessons which are Assigned to content Creator
		System.out.println("AllLessonAssignedto_ContentCreator");
		for (Lesson lesson : service.getAllLessonAssignedTO_ContentCreator(content_creator[0])) {
			System.out.println(lesson.getTitle());
		}

		
		
		 // passing content Creator id & status and getting list of lessons which are Assigned to content Creator 
		//status=APPROVED
		System.out.println("AllLessonAssignedto_ContentCreator with status=APPROVED");
		for (Lesson lesson : service.getAllLessonAssignedTO_ContentCreator(content_creator[0], StatusTypes.APPROVED)) {
			System.out.println(lesson.getTitle());
		}
		//status=CONTENT_ASSIGNED
		System.out.println("AllLessonAssignedto_ContentCreator with status=CONTENT_ASSIGNED");
		for (Lesson lesson : service.getAllLessonAssignedTO_ContentCreator(content_creator[0], StatusTypes.CONTENT_ASSIGNED)) {
			System.out.println(lesson.getTitle());
		}		
		//status=DRAFT
		System.out.println("AllLessonAssignedto_ContentCreator with status=DRAFT");
		for (Lesson lesson : service.getAllLessonAssignedTO_ContentCreator(content_creator[0], StatusTypes.DRAFT)) {
			System.out.println(lesson.getTitle());
		}
		//status=REQUEST_FOR_PUBLISH
		System.out.println("AllLessonAssignedto_ContentCreator with status=REQUEST_FOR_PUBLISH");
		for (Lesson lesson : service.getAllLessonAssignedTO_ContentCreator(content_creator[0], StatusTypes.REQUEST_FOR_PUBLISH)) {
			System.out.println(lesson.getTitle());
		}
		
		
		/*// passing contentReviwer id and getting list of lessons which are assigned to reviwer 
		System.out.println("AllLessons Assigned to Reviwer");
		for (Lesson lesson : service.getAllLessonAssignedToReviewer(14)){
			System.out.println(lesson.getTitle());
		}
		
		
		// passing content admin id and getting list of lessons which are pending for review 
		System.out.println("AllLessons With ReviewPending");
		for (Lesson lesson : service.getAllLessonsWithReviewPending(content_admin)){
			System.out.println(lesson.getTitle());
		}*/
   }
}