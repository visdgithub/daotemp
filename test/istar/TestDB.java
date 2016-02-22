/**
 * 
 */
package istar;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.istarindia.apps.dao.Address;
import com.istarindia.apps.dao.Organization;
import com.istarindia.apps.dao.Pincode;
import com.istarindia.apps.dao.PincodeDAO;
import com.istarindia.apps.dao.IstarUser;
import com.istarindia.apps.dao.IstarUserDAO;
import com.istarindia.apps.dao.LessonDAO;
import com.istarindia.apps.services.AddressService;
import com.istarindia.apps.services.OrganizationService;
import com.istarindia.apps.services.PincodeService;
import com.istarindia.apps.services.UserService;

/**
 * @author Vaibhav
 *
 */
public class TestDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*PincodeService service = new PincodeService();
		Pincode pin = service.createPincode("Kota", "India", "Rajasthan", 324005);
		AddressService serv = new AddressService();
		Address add = serv.createAddress("Steer Add 1", "Steer Add 222", 324005);
		OrganizationService se = new OrganizationService();
		Organization organization = se.createCompany(10, "Istar India", add);
		se.createCollege(100, "MLA College", add);

		Random r = new Random();
		
		UserService s = new UserService();
		String email = r.nextInt()+ "vaibhav@istarindia.com";
		String fatherName= "Dr O P Verma";
		String motherName = "Usha Verma";
		String gender  = "Usha Verma";
		Long mobileNum = new Long("9049177768");
		String name  = "Vaibhav Verma";
		String password  = "test123";
		s.createSuperAdmin(email, gender, mobileNum, name, password, fatherName, motherName);
		System.out.println((new IstarUserDAO()).findById(1).getEmail());*/
		
		
		
	}

}
