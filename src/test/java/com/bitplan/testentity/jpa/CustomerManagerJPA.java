/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2013-02-11 18:40 with smartGENERATOR
 */
package com.bitplan.testentity.jpa;
// base Entity Manager
import com.bitplan.storage.sql.JPAEntityManager;
// List
import java.util.List;
import java.util.ArrayList;

// BO interface
import com.bitplan.restinterface.BO;


// Entity interfaces
import com.bitplan.testentity.Customer;
import com.bitplan.testentity.CustomerImpl;
import com.bitplan.testentity.CustomerManager;
	// >>>{ManagerImports}{Customerjpa}{Customer}
	// no implementation yet !!!
	// <<<{ManagerImports}{Customerjpa}{Customer}
/**
 * JPA EntityManager implementation for interface Customer
 * Entity: Customer for container testentity
 */
public class CustomerManagerJPA extends JPAEntityManager<Customer>
	implements CustomerManager {
	
	/**
	 * constructor
	 */
	public CustomerManagerJPA() {
		this.setTableName("Customer");
	}
	// >>>{Managercode}{CustomerJpaDao}{Customer}
	// no implementation yet !!!
	// <<<{Managercode}{CustomerJpaDao}{Customer}

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
	public Class<? extends BO<?>> getEntityType() {
		return CustomerJpaDao.class;
	}
	


} // CustomerManagerJPA
