/**
 * 
 */
package com.istarindia.apps.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Any;
import com.istarindia.apps.GendertTypes;
import com.istarindia.apps.StatusTypes;
import com.istarindia.apps.TaskItemType;
import com.istarindia.apps.UserTypes;
import com.istarindia.apps.dao.*;

/**
 * @author Vaibhav
 *
 */
public class UserService {

	public String login(String email, String password)
	{
		if(new IstarUserDAO().findByEmail(email).get(0)!= null)
		{
			IstarUser user = new IstarUserDAO().findByEmail(email).get(0); 
			if(user.getPassword().equals(password))
			{
				String istarAuthorizationToken=getIstarToken();
				user.setIstarAuthorizationToken(istarAuthorizationToken);
				IstarUserDAO dao = new IstarUserDAO();
				Session session = dao.getSession();
				Transaction tx = null;
				try {
					tx = session.beginTransaction();
					dao.save(user);
					tx.commit();
				} catch (HibernateException e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				} finally {
					session.close();
				}
				
				return istarAuthorizationToken;
			}
		}else
		{
			return "No user registered with this email";
		}	
		return "";
	}
	
	public IstarUser getProfile(String istarToken)
	{
		//TODO change to a way of finding valid/invalid istartoken
		if(istarToken.length() == 36){
			IstarUser user = (IstarUser)new IstarUserDAO().findByProperty("istarAuthorizationToken", istarToken).get(0);
			return user;
		}else{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<IstarUser> getAllUser()
	{
		return new IstarUserDAO().findAll();
	}
	
	public String  logout(String istarAuthorizationToken)
	{
	
		IstarUser user = (IstarUser)new IstarUserDAO().findByIstarAuthorizationToken(istarAuthorizationToken).get(0);
		if(user!=null)
		{
			user.setIstarAuthorizationToken("");
			IstarUserDAO dao = new IstarUserDAO();
			Session session = dao.getSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				dao.save(user);
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
			
			return "Successfully Logged Out";
		}
		else
		{
			return "Token Expired.";
		}
		
	}
	
	
private String getIstarToken() {
	String istarToken = UUID.randomUUID().toString();
	return istarToken;
	}


/*	excel format.
 * usertype	fullname	email	password mobile	gender	addressline1	addressline2	pincode	city	state	country	organization	fathername	mothername
*/	public String readFile(File storeFile) throws IOException {
		String errorMSG = "SUCCCESS";
		try {
			FileInputStream fileInputStream = new FileInputStream(storeFile);
			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet worksheet = workbook.getSheetAt(0);
			System.out.println(worksheet.getPhysicalNumberOfRows());
			for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
				HSSFRow row = worksheet.getRow(i);
				
				String userType = row.getCell(0).getStringCellValue();
				String name = row.getCell(1).getStringCellValue();
				String password = row.getCell(3).getStringCellValue();
				String email = row.getCell(2).getStringCellValue();
				Long  mobile = (long)row.getCell(4).getNumericCellValue();	
				String gender = row.getCell(5).getStringCellValue();
				
				
				if(userType.equalsIgnoreCase(UserTypes.STUDENT))
				{
					
					String addressLine1 = row.getCell(6).getStringCellValue();
					String addressLine2 = row.getCell(7).getStringCellValue();
					int pincode = Integer.parseInt(row.getCell(8).getStringCellValue());
						
					String org_name =  row.getCell(9).getStringCellValue();
					
					String fatherName = row.getCell(10).getStringCellValue();
					String motherName = row.getCell(11).getStringCellValue();
					createStudent(email, fatherName, motherName, gender, mobile, name, password, new OrganizationDAO().findByName(org_name).get(0).getId(), pincode, addressLine1, addressLine2);
					
				}
				else if (userType.equalsIgnoreCase(UserTypes.CONTENT_ADMIN))
				{
					createContentAdmin(email, gender, mobile, name, password);
				}	
				else if (userType.equalsIgnoreCase(UserTypes.CONTENT_CREATOR))
				{
					createContentCreator(email, gender, mobile, name, password);
				}
				else if (userType.equalsIgnoreCase(UserTypes.CREATIVE_ADMIN))
				{
					createCreativeAdmin(email, gender, mobile, name, password);
				}
				else if (userType.equalsIgnoreCase(UserTypes.CREATIVE_CREATOR))
				{
					createCreativeCreator(email, gender, mobile, name, password);
				}
				else if (userType.equalsIgnoreCase(UserTypes.CONTENT_REVIEWER))
				{
					createContentReviewer(email, gender, mobile, name, password);
				}	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorMSG = e.getMessage();
		}
		return errorMSG;
	}
	// Create student
	public Student createStudent(String email, String fatherName, String motherName, String gender, long mobileNum,
			String name, String password, int organization_id, Integer pincode, String addressline1,
			String addressline2) {
		Pincode pin = new PincodeDAO().findByPin(pincode).get(0); 
		
		Address address = new Address();
		address.setAddressline1(addressline1);
		address.setAddressline2(addressline2);
		address.setPincode(pin);
		AddressDAO adddao = new AddressDAO();
		Session addsession = adddao.getSession();
		Transaction addtx = null;
		try {
			addtx = addsession.beginTransaction();
			adddao.save(address);
			addtx.commit();
		} catch (HibernateException e) {
			if (addtx != null)
				addtx.rollback();
			e.printStackTrace();
		} finally {
			addsession.close();
		}
		address.setId(address.getId());
		
		Student student = new Student();
		student.setEmail(email);
		student.setFatherName(fatherName);
		student.setMotherName(motherName);
		student.setGender(gender);
		student.setIsVerified(true);
		student.setMobile(mobileNum);
		student.setName(name);
		student.setPassword(password);
		student.setOrganization(new OrganizationDAO().findById(organization_id));
		student.setAddress(address);
		student.setUserType(UserTypes.STUDENT);
		StudentDAO dao = new StudentDAO();
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.save(student);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return student;
	}

	// Create Super Admin
	public SuperAdmin createSuperAdmin(String email, String gender, Long mobile, String name, String password, String fatherName,
			String motherName) {
		SuperAdmin superAdmin = new SuperAdmin();
		superAdmin.setEmail(email);
		superAdmin.setGender(gender);
		superAdmin.setMobile(mobile);
		superAdmin.setName(name);
		superAdmin.setIsVerified(true);
		superAdmin.setPassword(password);
		superAdmin.setMotherName(motherName);
		superAdmin.setFatherName(fatherName);
		superAdmin.setUserType(UserTypes.SUPER_ADMIN);
		SuperAdminDAO dao = new SuperAdminDAO();
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.save(superAdmin);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return superAdmin;
	}

	// Create Content Admin
	public ContentAdmin createContentAdmin(String email, String gender, Long mobileNum, String name, String password) {
		ContentAdmin contentAdmin = new ContentAdmin();
		contentAdmin.setEmail(email);
		contentAdmin.setGender(gender);
		
		contentAdmin.setMobile(mobileNum);
		contentAdmin.setName(name);
		contentAdmin.setPassword(password);
		contentAdmin.setIsVerified(true);
		contentAdmin.setUserType(UserTypes.CONTENT_ADMIN);
		ContentAdminDAO dao = new ContentAdminDAO();
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.save(contentAdmin);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return contentAdmin;
	}

	// Create Creative Admin
	public CreativeAdmin createCreativeAdmin(String email, String gender, Long mobileNum, String name, String password) {
		CreativeAdmin creativeAdmin = new CreativeAdmin();
		creativeAdmin.setEmail(email);
		creativeAdmin.setGender(gender);
		
		creativeAdmin.setMobile(mobileNum);
		creativeAdmin.setName(name);
		creativeAdmin.setIsVerified(true);
		creativeAdmin.setPassword(password);
		creativeAdmin.setUserType(UserTypes.CREATIVE_ADMIN);
		CreativeAdminDAO dao = new CreativeAdminDAO();
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.save(creativeAdmin);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return creativeAdmin;
	}

	// Create Content Creator
	public ContentCreator createContentCreator(String email, String gender, Long mobileNum, String name, String password) {
		ContentCreator contentCreator = new ContentCreator();
		contentCreator.setEmail(email);
		contentCreator.setGender(gender);
		
		contentCreator.setMobile(mobileNum);
		contentCreator.setName(name);
		contentCreator.setIsVerified(true);
		contentCreator.setPassword(password);
		contentCreator.setUserType(UserTypes.CONTENT_CREATOR);
		ContentCreatorDAO dao = new ContentCreatorDAO();
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.save(contentCreator);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return contentCreator;
	}

	// Create Creative Creator
	public CreativeCreator createCreativeCreator(String email, String gender, Long mobileNum, String name, String password) {
		CreativeCreator creativeCreator = new CreativeCreator();
		creativeCreator.setEmail(email);
		creativeCreator.setGender(gender);
		creativeCreator.setMobile(mobileNum);
		creativeCreator.setName(name);
		creativeCreator.setPassword(password);
		creativeCreator.setIsVerified(true);
		creativeCreator.setUserType(UserTypes.CREATIVE_CREATOR);
		CreativeCreatorDAO dao = new CreativeCreatorDAO();
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.save(creativeCreator);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return creativeCreator;
	}

	// Create Content Reviewer
	public ContentReviewer createContentReviewer(String email, String gender, Long mobileNum, String name, String password) {
		ContentReviewer contentReviewer = new ContentReviewer();
		contentReviewer.setEmail(email);
		contentReviewer.setGender(gender);
		contentReviewer.setIsVerified(true);
		contentReviewer.setMobile(mobileNum);
		contentReviewer.setName(name);
		contentReviewer.setPassword(password);
		contentReviewer.setUserType(UserTypes.CONTENT_CREATOR);
		ContentReviewerDAO dao = new ContentReviewerDAO();
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.save(contentReviewer);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return contentReviewer;
	}

	// Returns list of users by user-type. If argument is NULL; then it returns
	// the list of all the users
	public List<IstarUser> getUserListByType(String userType) {
		if (userType.equalsIgnoreCase(UserTypes.CONTENT_ADMIN)) {
			return new ContentAdminDAO().findAll();
		} else if (userType.equalsIgnoreCase(UserTypes.CREATIVE_ADMIN)) {
			return new CreativeAdminDAO().findAll();
		} else if (userType.equalsIgnoreCase(UserTypes.CREATIVE_CREATOR)) {
			return new CreativeCreatorDAO().findAll();
		} else if (userType.equalsIgnoreCase(UserTypes.SUPER_ADMIN)) {
			return new SuperAdminDAO().findAll();
		} else if (userType.equalsIgnoreCase(UserTypes.STUDENT)) {
			return new StudentDAO().findAll();
		} else if (userType.equalsIgnoreCase(UserTypes.CONTENT_CREATOR)) {
			return new ContentCreatorDAO().findAll();
		}else if(userType.equalsIgnoreCase(UserTypes.CONTENT_REVIEWER)){
			return new ContentReviewerDAO().findAll();
		} else
		{	
			return new IstarUserDAO().findAll();
		}	
	}

	// Delete user record by Id
	public void deleteUser(int id) {
		IstarUser user = new IstarUserDAO().findById(id);
		IstarUserDAO dao = new IstarUserDAO();
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			dao.delete(user);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// Update records of user by id
	public void updateUser(int id, String email, String fatherName, String motherName, String gender, String mobileNum,
			String name, String password, Organization organization, Integer pincode, String addressline1,
			String addressline2, String city, String state, String country) {
		IstarUser user = new IstarUserDAO().findById(id);

		Pincode pin = new PincodeDAO().findByPin(pincode).get(0);
		Address address = new Address();
		address.setAddressline1(addressline1);
		address.setAddressline2(addressline2);
		address.setPincode(pin);

		if (user.getUserType().equalsIgnoreCase(UserTypes.STUDENT)) {
			Student user1 = new StudentDAO().findById(id);
			user1.setAddress(address);
			user = user1;
		} else if (user.getUserType().equalsIgnoreCase(UserTypes.CONTENT_ADMIN)) {
			user = new ContentAdminDAO().findById(id);
		} else if (user.getUserType().equalsIgnoreCase(UserTypes.CREATIVE_ADMIN)) {
			user = new CreativeAdminDAO().findById(id);
		} else if (user.getUserType().equalsIgnoreCase(UserTypes.CREATIVE_CREATOR)) {
			user = new CreativeCreatorDAO().findById(id);
		} else if (user.getUserType().equalsIgnoreCase(UserTypes.SUPER_ADMIN)) {
			user = new SuperAdminDAO().findById(id);
		} else if (user.getUserType().equalsIgnoreCase(UserTypes.STUDENT)) {
			user = new StudentDAO().findById(id);
		} else if (user.getUserType().equalsIgnoreCase(UserTypes.CONTENT_CREATOR)) {
			user = new ContentCreatorDAO().findById(id);
		}

		user.setOrganization(organization);
		user.setEmail(email);
		user.setGender(gender);
		Long mobile = new Long(mobileNum);
		user.setMobile(mobile);
		user.setName(name);
		user.setPassword(password);

		IstarUserDAO dao = new IstarUserDAO();
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			dao.attachDirty(user);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public String forgotPassword(String email)
	{
		IstarUser user = new IstarUserDAO().findByEmail(email).get(0);
		String istarToken = getIstarToken();
		user.setIstarAuthorizationToken(istarToken);
		IstarUserDAO dao = new IstarUserDAO();
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			dao.attachDirty(user);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return istarToken;
	}
	
	
	
}
