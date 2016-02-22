/**
 * 
 */
package com.istarindia.apps.services;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.istarindia.apps.OrganizationTypes;
import com.istarindia.apps.dao.Address;
import com.istarindia.apps.dao.AddressDAO;
import com.istarindia.apps.dao.College;
import com.istarindia.apps.dao.CollegeDAO;
import com.istarindia.apps.dao.Company;
import com.istarindia.apps.dao.CompanyDAO;
import com.istarindia.apps.dao.Government;
import com.istarindia.apps.dao.GovernmentDAO;
import com.istarindia.apps.dao.GovernmentProject;
import com.istarindia.apps.dao.Organization;
import com.istarindia.apps.dao.OrganizationDAO;
import com.istarindia.apps.dao.Pincode;
import com.istarindia.apps.dao.PincodeDAO;
import com.istarindia.apps.dao.Student;
import com.istarindia.apps.dao.StudentDAO;

/**
 * @author Vaibhav
 *
 */
public class OrganizationService {

	public Company createCompany(int maxStudents, String companyName, String addressline1, String addressline2, int pincode) {
		
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
		Company company = new Company();
		company.setMaxStudents(maxStudents);
		company.setName(companyName);
		company.setAddress(address);
		company.setOrgType(OrganizationTypes.COMPANY);
		CompanyDAO dao = new CompanyDAO();
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.save(company);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return company;
	}

	public College createCollege(int maxStudents, String companyName,  String addressline1, String addressline2, int pincode) 
		 {
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
		College company = new College();
		company.setMaxStudents(maxStudents);
		company.setName(companyName);
		company.setAddress(address);
		company.setOrgType(OrganizationTypes.COLLEGE);
		CollegeDAO dao = new CollegeDAO();
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.save(company);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return company;
		
	}
	
	public Government createGovt(int maxStudents, String companyName, String addressline1, String addressline2, int pincode) {
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
		
		Government company = new Government();
		company.setMaxStudents(maxStudents);
		company.setName(companyName);
		company.setAddress(address);
		company.setOrgType(OrganizationTypes.GOVERNMENT);
		GovernmentDAO dao = new GovernmentDAO();
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.save(company);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return company;
		
	}
	
	public List<Organization> getAllCompaniesOrgs() throws RuntimeException {
		CompanyDAO dao = new CompanyDAO();
		
	    return dao.findAll();
	}

	public void  createOrganization(int maxStudents, String companyName, String addressline1, String addressline2, int pincode, String orgtype)
	{
		if(orgtype.equalsIgnoreCase(OrganizationTypes.COLLEGE))
		{
			createCollege(maxStudents, companyName, addressline1, addressline2, pincode);
		}else if(orgtype.equalsIgnoreCase(OrganizationTypes.COMPANY))
		{
			createCompany(maxStudents, companyName, addressline1, addressline2, pincode);
		}	
		else if(orgtype.equalsIgnoreCase(OrganizationTypes.GOVERNMENT))
		{
			createGovt(maxStudents, companyName, addressline1, addressline2, pincode);
		}
	}
	
	public List<Organization> getAllCollegeOrgs() throws RuntimeException {
		CollegeDAO dao = new CollegeDAO();
		return dao.findAll();
	}

	public List<Organization> getAllGovernmentOrgs() throws RuntimeException {
		GovernmentDAO dao = new GovernmentDAO();
		return dao.findAll();
	}

	public List<Organization> getAllOrgs() throws RuntimeException {
		OrganizationDAO dao = new OrganizationDAO();
		
	    return dao.findAll();
	}

	public List<Organization> getAllOrgByOrgtype(String orgtype)
	{
		if(orgtype.equalsIgnoreCase(OrganizationTypes.COLLEGE))
		{
			return getAllCollegeOrgs();
		}
		else if(orgtype.equalsIgnoreCase(OrganizationTypes.COMPANY))
		{
			return getAllGovernmentOrgs();
		}
		else if(orgtype.equalsIgnoreCase(OrganizationTypes.GOVERNMENT))
		{
			return getAllCompaniesOrgs();
		}
		else
		{
			return getAllOrgs();
		}
	}
	
	public Organization getOrgById(int Id) {
		OrganizationDAO dao = new OrganizationDAO();		
		
		
		Organization org = dao.findById(Id);
		
		return org;	    
	}
	
	public void deleteOrgById(int id) {
		OrganizationDAO dao = new OrganizationDAO();
		Organization org = this.getOrgById(id);
		dao.delete(org);
	}
	
    public List<Student> getAllStudentsInOrganization(int organizationId){
    	StudentDAO sdao = new StudentDAO();		
		List<Student> studentsInOrg = sdao.findByProperty("organization", organizationId);		
		return studentsInOrg;    	
    }

	

}
