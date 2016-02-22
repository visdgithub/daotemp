package istar;

import com.istarindia.apps.dao.Organization;
import com.istarindia.apps.services.OrganizationService;

public class TestOrganizationService {

	public static void main(String[] args) {
		
		
		new OrganizationService().UpdateOrg(2, 100, "ajjuupdate", "mmmm", "lllll", 546098, "COLLEGE");
	}
	/*	// TODO Auto-generated method stub
//new OrganizationService().createCollege(5, "college name", "line1", "line2", 546098);
		new OrganizationService().createCompany(20, "company 1", "kjfnkrj", "fjhfbjhfb", 546098);
		new OrganizationService().createGovt(100,"gov 1"
				+ "","cdcdced","cdcwed", 546098);
		

	for(Organization o : new OrganizationService().getAllOrgs())
	{
		System.out.println(o.getName());
	}
	}*/

}
