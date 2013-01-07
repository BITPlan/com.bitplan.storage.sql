/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2013-01-07 09:08 with smartGENERATOR
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
public class OrderJpaDao extends JPABOImpl<Order> implements Order,Serializable {

  /**   
   * make Serializable happy ...   
   */  
  private static final long serialVersionUID = 1L;  
  
  /**
   * access to my Implementation
   */
  public Order getOrderImpl() {
     return (Order)getImpl();
  }
  /**
   * default constructor for Order
   */
  public OrderJpaDao() {
    mBOImpl=new OrderImpl();
    
  }
  
  /**
   * construct a Order from a given Data Access Object
   * @param pOrder the Data Access Object to initialize this class from
   */
  public OrderJpaDao(Order pOrder) {
    super();
    mBOImpl=pOrder;
	// >>>{constructor}{OrderJpaDao}{Order}
	// no implementation yet !!!
	// <<<{constructor}{OrderJpaDao}{Order}
  }
  /**
   * getter for xsd:string/String id
   * @return id
   */
  @Id
  @Column(name="id")
  public String getId() { 
  	return getOrderImpl().getId(); 
  }

  /**
   * setter for xsd:string/String id
   * @param pid - new value for id
   */
  public void setId(String pid) { 
  	getOrderImpl().setId(pid); 
  }
  
  /**
   * getter for xsd:string/String shipping address
   * @return address
   */
  @Column(name="SHIPPING_ADDRESS")
  public String getAddress() { 
  	return getOrderImpl().getAddress(); 
  }

  /**
   * setter for xsd:string/String shipping address
   * @param paddress - new value for shipping address
   */
  public void setAddress(String paddress) { 
  	getOrderImpl().setAddress(paddress); 
  }
  
  /**
   * getter for Customer/Customer customer
   * @return customer
   */
  @ManyToOne(targetEntity=CustomerJpaDao.class)
  public Customer getCustomer() { 
  	return getOrderImpl().getCustomer(); 
  }

  /**
   * setter for Customer/Customer customer
   * @param pcustomer - new value for customer
   */
  public void setCustomer(Customer pcustomer) { 
  	getOrderImpl().setCustomer(pcustomer); 
  }
  
 /**
   * copy me from the given Order
   * @param Order - the source Object to copy from
   */
  public void copyFrom(Order pOrder) {
    mBOImpl.copyFrom(pOrder);
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
    if (pMap.containsKey("id"))	setId(getTypeConverter().getString(pMap.get("id")));
    if (pMap.containsKey("shipping address"))	setAddress(getTypeConverter().getString(pMap.get("shipping address")));
	} // fromMap
} // OrderJpaDao
