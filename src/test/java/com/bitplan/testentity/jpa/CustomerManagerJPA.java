/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2012-11-24 18:45 with smartGENERATOR
 */
package com.bitplan.testentity.jpa;
// List interface
import java.util.List;
// BO interface
import com.bitplan.restinterface.BO;
// base Entity Manager
import com.bitplan.storage.sql.JPAEntityManager;
// Entity interfaces
import com.bitplan.testentity.Customer;
import com.bitplan.testentity.CustomerImpl;
import com.bitplan.testentity.CustomerManager;
import javax.persistence.Query;

/**
 * JPA EntityManager implementation for interface Customer
 * Entity: Customer for container testentity
 */
public class CustomerManagerJPA extends JPAEntityManager<Customer>
	implements CustomerManager {
  /**
	 * set the customers
	 * @param pCustomers
	 */
	@Override
	public void setCustomers(List<Customer> pCustomers) {
		super.bolist=pCustomers;
	}
	
	/**
	 * @return the customers
	 */
	@Override
	public List<Customer> getCustomers() {
		return super.bolist;
	}
	
	@Override
	public Customer create() {
		CustomerJpaDao result = new CustomerJpaDao(new CustomerImpl());
		result.setBOManager(this);
		return result;
	}
		
	@Override
	public void purge() {
	  super.bolist.clear();
	  
	}
	
	@Override
	public Class<? extends BO<?>> getEntityType() {
		return CustomerJpaDao.class;
	}

} // CustomerManagerJPA
