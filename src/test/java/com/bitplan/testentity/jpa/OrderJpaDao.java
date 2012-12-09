/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2012-12-09 14:19 with smartGENERATOR
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
// utility imports
import java.util.Map;
import java.util.HashMap;

// restinterface
import com.bitplan.restinterface.BO;
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
  @Transient
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
   * getter for xsd:long/long id
   * @return id
   */
  @Id
  @Column(name="id")
  public long getId() { 
  	return mOrderImpl.getId(); 
  }

  /**
   * setter for xsd:long/long id
   * @param pid - new value for id
   */
  public void setId(long pid) { 
  	mOrderImpl.setId(pid); 
  }
  
  /**
   * getter for xsd:string/String shipping address
   * @return address
   */
  @Column(name="SHIPPING_ADDRESS")
  public String getAddress() { 
  	return mOrderImpl.getAddress(); 
  }

  /**
   * setter for xsd:string/String shipping address
   * @param paddress - new value for shipping address
   */
  public void setAddress(String paddress) { 
  	mOrderImpl.setAddress(paddress); 
  }
  
  /**
   * getter for Customer/Customer customer
   * @return customer
   */
  @ManyToOne(targetEntity=CustomerJpaDao.class)
  public Customer getCustomer() { 
  	return mOrderImpl.getCustomer(); 
  }

  /**
   * setter for Customer/Customer customer
   * @param pcustomer - new value for customer
   */
  public void setCustomer(Customer pcustomer) { 
  	mOrderImpl.setCustomer(pcustomer); 
  }
  
 /**
   * copy me from the given Order
   * @param Order - the source Object to copy from
   */
  public void copyFrom(Order pOrder) {
    mOrderImpl.copyFrom(pOrder);
  }
  /**
   * get the primary key of this business object
   */
	@Transient
  public Object getPrimaryKey() {
  	return getId();
  } // getPrimaryKey

  @Override
	public Object getField(String fieldName) {
		Object result=null;
    if (fieldName.equals("id")) result=getId();
    if (fieldName.equals("shipping address")) result=getAddress();
    if (fieldName.equals("customer")) result=getCustomer();
		return result;
	} // getField

	@Override
	public Map<String, Object> toMap() {
	  Map<String, Object> result=new HashMap<String,Object>();
    result.put("id",getId());
    result.put("shipping address",getAddress());
		return result;
	} // toMap

	@Override
	public void fromMap(Map<String, Object> pMap) {
    setId((Long)pMap.get("id"));
    setAddress((String)pMap.get("shipping address"));
	} // fromMap
} // OrderJpaDao
