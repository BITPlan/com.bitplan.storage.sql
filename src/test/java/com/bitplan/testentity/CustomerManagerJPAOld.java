package com.bitplan.testentity;

import java.util.List;
import javax.persistence.Query;

import com.bitplan.restinterface.BO;
import com.bitplan.storage.sql.JPAEntityManager;

/**
 * Customer Manager
 * 
 * @author wf
 * 
 */
public class CustomerManagerJPAOld extends JPAEntityManager<Customer> implements
		CustomerManager {

	@Override
	public List<Customer> getCustomers() {
		return bolist;
	}

	/**
	 * set the customers
	 * 
	 * @param pCustomers
	 */
	@Override
	public void setCustomers(List<Customer> pCustomers) {
		super.bolist = pCustomers;
	}

	@Override
	public Customer create() {
		Customer result = new CustomerJPAOld(); // injector.
		return result;
	}

	@Override
	public void purge() {
		Query q = getEntityManager().createQuery(
				"delete from Customer customer");
		q.executeUpdate();
	}

	@Override
	public Customer findById(Object pId) {
		long id=(Long)pId;
		Query q = getEntityManager().createQuery(
				"select c from Customer as c where c.id="+id);
		Customer result=(Customer) q.getSingleResult();
		return result;
	}

	@Override
	public Class<? extends BO<?>> getEntityType() {
		// TODO Auto-generated method stub
		return null;
	}

}
