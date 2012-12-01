/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2012-12-01 05:48 with smartGENERATOR
 */
package com.bitplan.testentity.jpa;
import java.io.Serializable;
// JPA / Hibernate imports
import javax.persistence.*;
//import static javax.persistence.CascadeType.*;
import com.bitplan.storage.sql.JPABOImpl;
// Guice
import com.google.inject.Inject;

import java.util.List;
import com.bitplan.testentity.Customer;
import com.bitplan.testentity.CustomerImpl;
// restinterface
import com.bitplan.restinterface.BO;
import com.bitplan.testentity.Order;
	// >>>{implSection}{Customer}{Customer}
	// no implementation yet !!!
	// <<<{implSection}{Customer}{Customer}

/**
 * JPA Data access object for Customer
 * Entity: Customer for container testentity
 * Table: Customer
 */
@Entity(name="Customer")
@Table(name="Customer")
public class CustomerJpaDao extends JPABOImpl<Customer>  implements Customer, Serializable{

  /**   
   * make Serializable happy ...   
   */  
  private static final long serialVersionUID = 1L;  
  /**
   * the true implementation
   */
  protected Customer mCustomerImpl;
  
  /**
   * return the implementation for Customer
   * @return the Customer implementation 
   */
  public Customer getImpl() {
    return mCustomerImpl;
  }
  
  /**
   * default constructor for Customer
   */
  public CustomerJpaDao() {
    mCustomerImpl=new CustomerImpl();
    
  }
  
  /**
   * construct a Customer from a given Data Access Object
   * @param pCustomer the Data Access Object to initialize this class from
   */
  public CustomerJpaDao(Customer pCustomer) {
    super();
    mCustomerImpl=pCustomer;
	// >>>{constructor}{CustomerJpaDao}{Customer}
	// no implementation yet !!!
	// <<<{constructor}{CustomerJpaDao}{Customer}
  }
  /**
   * getter for xsd:string/String name
   * @return name
   */
  @Column(name="name")
  public String getName() { 
  	return mCustomerImpl.getName(); 
  }

  /**
   * setter for xsd:string/String name
   * @param pname - new value for name
   */
  public void setName(String pname) { 
  	mCustomerImpl.setName(pname); 
  }
  
  /**
   * getter for xsd:long/long id
   * @return id
   */
  @Id
  @Column(name="id")
  public long getId() { 
  	return mCustomerImpl.getId(); 
  }

  /**
   * setter for xsd:long/long id
   * @param pid - new value for id
   */
  public void setId(long pid) { 
  	mCustomerImpl.setId(pid); 
  }
  
  /**
   * getter for Order/List<Order> orders
   * @return orders
   */
  @OneToMany(targetEntity=OrderJpaDao.class, cascade=CascadeType.ALL, mappedBy="customer")
  public List<Order> getOrders() { 
  	return mCustomerImpl.getOrders(); 
  }

  /**
   * setter for Order/List<Order> orders
   * @param porders - new value for orders
   */
  public void setOrders(List<Order> porders) { 
  	mCustomerImpl.setOrders(porders); 
  }
  
 /**
   * copy me from the given Customer
   * @param Customer - the source Object to copy from
   */
  public void copyFrom(Customer pCustomer) {
    mCustomerImpl.copyFrom(pCustomer);
  }
  /**
   * get the primary key of this business object
   */
	@Transient
  public Object getPrimaryKey() {
  	return getId();
  }
} // CustomerJpaDao
