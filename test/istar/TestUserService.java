package istar;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.istarindia.apps.GendertTypes;
import com.istarindia.apps.services.UserService;

public class TestUserService {

	public static void main(String[] args) throws IOException {

		Random r = new Random();
		UserService s = new UserService();

		// content Reviwer -1
		String email = r.nextInt() + "Shriram@istarindia.com";
		String gender = GendertTypes.MALE;
		Long mobileNum = new Long("9049177768");
		String name = "Shriram";
		String password = "test123";
		s.createContentReviewer(email, gender, mobileNum, name, password);

		// content Reviwer -2
		email = r.nextInt() + "surga@istarindia.com";
		gender = GendertTypes.FEMALE;
		mobileNum = new Long("7694827391");
		name = "Surga";
		password = "test123";
		s.createContentReviewer(email, gender, mobileNum, name, password);

		// Content Admin -1
		email = r.nextInt() + "Archana@istarindia.com";
		gender = "female";
		mobileNum = new Long("7259846387");
		name = "Archana";
		password = "test123";
		s.createContentAdmin(email, gender, mobileNum, name, password);

		// Super Admin
		email = r.nextInt() + "Vaibhav@istarindia.com";
		gender = GendertTypes.MALE;
		mobileNum = new Long("9173869482");
		name = "Vaibhav";
		password = "test123";
		String fatherName="abc";
		String motherName="xyz";
		s.createSuperAdmin(email, gender, mobileNum, name, password, fatherName, motherName);

		// Creative Admin -1
		email = r.nextInt() + "hema@istarindia.com";
		gender = GendertTypes.FEMALE;
		mobileNum = new Long("9784868797");
		name = "Hema";
		password = "test123";
		s.createCreativeAdmin(email, gender, mobileNum, name, password);

		// Content Creator -1
		email = r.nextInt() + "tejaswini@istarindia.com";
		gender = GendertTypes.FEMALE;
		mobileNum = new Long("9123645876");
		name = "Tejaswini";
		password = "test123";
		s.createContentCreator(email, gender, mobileNum, name, password);

		// Content Creator -2
		email = r.nextInt() + "Shruthi@istarindia.com";
		gender = GendertTypes.FEMALE;
		mobileNum = new Long("9324687127");
		name = "Shruthi";
		password = "test123";
		s.createContentCreator(email, gender, mobileNum, name, password);

		// Content Creator -3
		email = r.nextInt() + "mark@istarindia.com";
		gender = GendertTypes.MALE;
		mobileNum = new Long("8472767984");
		name = "Mark";
		password = "test123";
		s.createContentCreator(email, gender, mobileNum, name, password);

		// Content Creator -4
		email = r.nextInt() + "Deepti@istarindia.com";
		gender = GendertTypes.FEMALE;
		mobileNum = new Long("9876543218");
		name = "Deepti";
		password = "test123";
		s.createContentCreator(email, gender, mobileNum, name, password);

		// Creative Creator -1
		email = r.nextInt() + "kiran@istarindia.com";
		gender = GendertTypes.MALE;
		mobileNum = new Long("9326154876");
		name = "Kiran";
		password = "test123";
		s.createCreativeCreator(email, gender, mobileNum, name, password);

		// Creative Creator -1
		email = r.nextInt() + "clevin@istarindia.com";
		gender = GendertTypes.MALE;
		mobileNum = new Long("7874963518");
		name = "Clevin";
		password = "test123";
		s.createCreativeCreator(email, gender, mobileNum, name, password);

		/*//login
		String email1 = "vaibhav@istarindia.com";
		String password1 = "test123";
		System.out.println(s.login(email1, password1));*/
/*
  		// Student -1
		email = r.nextInt() + "shivu@istarindia.com";
		gender = GendertTypes.MALE;
		mobileNum = new Long("9876543218");
		name = "Shivu";
		password = "test123";
		fatherName="abcd";
		motherName="xyz";		
		int organization_id=1;
		Integer pincode=560066;
		String addressline1="#23 shanthi nivasan";
		String addressline2="malleshwaram";
		s.createStudent(email, fatherName, motherName, gender, mobileNum, motherName, password, organization_id, pincode, addressline1, addressline2);

		// Student -2
		email = r.nextInt() + "ajith@istarindia.com";
		gender = GendertTypes.MALE;
		mobileNum = new Long("7193284697");
		name = "Ajith";
		password = "test123";
		fatherName = "mno";
		motherName = "pqr";
		organization_id=1;
		pincode=560066;
		addressline1="#73 shanthi nivasan";
		addressline2="kodihalli";
		s.createStudent(email, fatherName, motherName, gender, mobileNum, motherName, password, organization_id, pincode, addressline1, addressline2);

		// Student -3
		email = r.nextInt() + "vinay@istarindia.com";
		gender = GendertTypes.MALE;
		mobileNum = new Long("9826743816");
		name = "Vinay";
		password = "test123";
		fatherName = "abc";
		motherName = "xyz";
		organization_id=1;
		pincode=560066;
		addressline1="g1-309 sri apts";
		addressline2="telecom layout";
		s.createStudent(email, fatherName, motherName, gender, mobileNum, motherName, password, organization_id, pincode, addressline1, addressline2);

		// Student -4
		email = r.nextInt() + "shridevi@istarindia.com";
		gender = GendertTypes.FEMALE;
		mobileNum = new Long("7182932684");
		name = "Shridevi";
		password = "test123";
		fatherName = "abc";
		motherName = "xyz";
		organization_id=1;
		pincode=560066;
		addressline1="#26 hosa mane";
		addressline2="mysore road";
		s.createStudent(email, fatherName, motherName, gender, mobileNum, motherName, password, organization_id, pincode, addressline1, addressline2);

		// Student -5
		email = r.nextInt() + "sumanth@istarindia.com";
		gender = GendertTypes.MALE;
		mobileNum = new Long("7284967526");
		name = "Sumanth";
		password = "test123";
		fatherName = "abc";
		motherName = "xyz";
		organization_id=1;
		pincode=560066;
		addressline1="tuglak nagara";
		addressline2="malavalli street";
		s.createStudent(email, fatherName, motherName, gender, mobileNum, motherName, password, organization_id, pincode, addressline1, addressline2);
	*/
		String ret = s.readFile(new File("/Users/mvsuryateja/users.xls"));
		System.out.println("DONE");
	
	}
}