/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2012-11-25 14:52 with smartGENERATOR
 */
package com.bitplan.testentity.jpa;
import java.io.Serializable;
// JPA / Hibernate imports
import javax.persistence.*;
//import static javax.persistence.CascadeType.*;
import com.bitplan.storage.sql.JPABOImpl;
// Guice
import com.google.inject.Inject;

import com.bitplan.testentity.Order;
import com.bitplan.testentity.OrderImpl;
import com.bitplan.testentity.Customer;
	// >>>{implSection}{Order}{Order}
	// no implementation yet !!!
	// <<<{implSection}{Order}{Order}

/**
 * JPA Data access object for Order
 * Entity: Order for container testentity
 * Table: order_table
 */
@Entity(name="Order")
@Table(name="order_table")
public class OrderJpaDao extends JPABOImpl<Order>  implements Order, Serializable{

  /**   
   * make Serializable happy ...   
   */  
  private static final long serialVersionUID = 1L;  
  /**
   * the true implementation
   */
  protected Order mOrderImpl;
  
  /**
   * return the implementation for Order
   * @return the Order implementation 
   */
  public Order getImpl() {
    return mOrderImpl;
  }
  
  /**
   * default constructor for Order
   */
  public OrderJpaDao() {
    mOrderImpl=new OrderImpl();
    
  }
  
  /**
   * construct a Order from a given Data Access Object
   * @param pOrder the Data Access Object to initialize this class from
   */
  public OrderJpaDao(Order pOrder) {
    super();
    mOrderImpl=pOrder;
	// >>>{constructor}{OrderJpaDao}{Order}
	// no implementation yet !!!
	// <<<{constructor}{OrderJpaDao}{Order}
  }
  /**
   * getter for id
   * @return id
   */
  @Id
  @Column(name="id")
  public long getId() { 
  	return mOrderImpl.getId(); 
  }

  /**
   * setter for id
   * @param pid - new value for id
   */
  public void setId(long pid) { 
  	mOrderImpl.setId(pid); 
  }
  
  /**
   * getter for shipping address
   * @return address
   */
  @Column(name="SHIPPING_ADDRESS")
  public String getAddress() { 
  	return mOrderImpl.getAddress(); 
  }

  /**
   * setter for shipping address
   * @param paddress - new value for shipping address
   */
  public void setAddress(String paddress) { 
  	mOrderImpl.setAddress(paddress); 
  }
  
  /**
   * getter for customer
   * @return customer
   */
  @ManyToOne(targetEntity=CustomerJpaDao.class)
  public Customer getCustomer() { 
  	return mOrderImpl.getCustomer(); 
  }

  /**
   * setter for customer
   * @param pcustomer - new value for customer
   */
  public void setCustomer(Customer pcustomer) { 
  	mOrderImpl.setCustomer(pcustomer); 
  }
  

  /**
   * get the primary key of this business object
   */
	@Transient
  public Object getPrimaryKey() {
  	return getId();
  }
} // OrderJpaDao
