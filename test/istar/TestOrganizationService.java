package istar;

import com.istarindia.apps.dao.Organization;
import com.istarindia.apps.services.OrganizationService;

public class TestOrganizationService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//new OrganizationService().createCollege(5, "college name", "line1", "line2", 546098);

	for(Organization o : new OrganizationService().getAllOrgs())
	{
		System.out.println(o.getName());
	}
	}

}
