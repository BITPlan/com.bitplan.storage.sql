package com.bitplan.testentity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Customer Manager
 * @author wf
 *
 */
public class CustomerManagerJPA implements CustomerManager {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCustomers(List<Customer> customers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void purge() {
		Query q = this.getEntityManager().createQuery("delete Customer");
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

}
