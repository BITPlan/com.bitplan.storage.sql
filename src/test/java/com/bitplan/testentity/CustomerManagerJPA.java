package com.bitplan.testentity;

import java.util.List;
import javax.persistence.Query;
import com.bitplan.storage.sql.JPAEntityManager;

/**
 * Customer Manager
 * @author wf
 *
 */
public class CustomerManagerJPA extends JPAEntityManager<Customer> implements CustomerManager  {

	@Override
	public List<Customer> getCustomers() {
		return bolist;
	}

	@Override
	public Customer create() {
		Customer result=new CustomerJPA(); // injector.
		return result;
	}

	@Override
	public void purge() {
		Query q = getEntityManager().createQuery("delete from Customer customer");
		q.executeUpdate();
	}

	@Override
	public Customer findById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

}
