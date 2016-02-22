/**
 * 
 */
package com.istarindia.apps.services;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.istarindia.apps.dao.Pincode;
import com.istarindia.apps.dao.PincodeDAO;

/**
 * @author Vaibhav
 *
 */
public class PincodeService {
	public Pincode createPincode(String city, String country, String state, Integer pinode) {
		Pincode pin = new Pincode();
		pin.setCity(city);
		pin.setCountry(country);
		pin.setState(state);
		pin.setPin(pinode);
		PincodeDAO dao = new PincodeDAO();
		Session session = dao.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.save(pin);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return pin;
	}
}
