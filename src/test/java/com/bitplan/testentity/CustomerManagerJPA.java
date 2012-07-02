package com.bitplan.testentity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Customer Manager
 * @author wf
 *
 */
public class CustomerManagerJPA implements CustomerManager {
	// for examples
	// http://www.winstonprakash.com/articles/netbeans/JPA_Add_Update_Delete.html
	EntityManager entityManager;
	
	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @param entityManager the entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Customer> getCustomers() {
		ArrayList<Customer> result=new ArrayList<Customer>();
		// FIXME - need test and implementation
		return result;
	}

	@Override
	public void setCustomers(List<Customer> customers) {
		// FIXME need test and implementation
		
	}

	@Override
	public Customer create() {
		Customer result=new CustomerJPA();
		return result;
	}

	@Override
	public void purge() {
		Query q = this.getEntityManager().createQuery("delete from Customer customer");
		q.executeUpdate();
	}

	@Override
	public void setContext(Object context) {
		this.setEntityManager((EntityManager) context);
		
	}

	@Override
	public void commit() {
		this.getEntityManager().getTransaction().commit();
	}

	@Override
	public void beginTransaction() {
		this.getEntityManager().getTransaction().begin();
	}

}
