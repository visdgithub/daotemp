/**
 * 
 */
package com.istarindia.apps.services;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.istarindia.apps.dao.Address;
import com.istarindia.apps.dao.AddressDAO;
import com.istarindia.apps.dao.Pincode;
import com.istarindia.apps.dao.PincodeDAO;

/**
 * @author Vaibhav
 *
 */
public class AddressService {

	public Address createAddress(String addressline1, String addressline2, Integer pincode) {
		Address address = new Address();
		
		address.setAddressline1(addressline1);
		address.setAddressline2(addressline2);
		address.setPincode((new PincodeDAO()).findByPin(pincode).get(0));
		AddressDAO dao = new AddressDAO();
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.save(address);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return address;
	}

}
