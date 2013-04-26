/**
 * Copyright (C) 2011-2013 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2013-04-26 16:28 with smartGENERATOR
 */
package com.bitplan.testentity.jpa;
import java.io.Serializable;
// JPA / Hibernate imports
import javax.persistence.*;
//import static javax.persistence.CascadeType.*;
import com.bitplan.storage.sql.JPABOImpl;
// Guice
import com.google.inject.Inject;

import com.bitplan.testentity.Customer;
import com.bitplan.testentity.CustomerImpl;
// utility imports
import java.util.Map;
import java.util.HashMap;

// restinterface
import com.bitplan.restinterface.BO;
import java.util.List;
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
	// >>>{annotation}{Customer}{Customer}
	// no implementation yet !!!
	// <<<{annotation}{Customer}{Customer}
public class CustomerJpaDao extends JPABOImpl<Customer> implements Customer,Serializable {
	// >>>{code}{CustomerJpaDao}{Customer}
	// no implementation yet !!!
	// <<<{code}{CustomerJpaDao}{Customer}
  /**   
   * make Serializable happy ...   
   */  
  private static final long serialVersionUID = 1L;  
  
  /**
   * access to my Implementation
   */
  public Customer getCustomerImpl() {
     return (Customer)getImpl();
  }
  /**
   * default constructor for Customer
   */
  public CustomerJpaDao() {
    mBOImpl=new CustomerImpl();
    
  }
  
  /**
   * construct a Customer from a given Data Access Object
   * @param pCustomer the Data Access Object to initialize this class from
   */
  public CustomerJpaDao(Customer pCustomer) {
    super();
    mBOImpl=pCustomer;
	// >>>{constructor}{CustomerJpaDao}{Customer}
	// no implementation yet !!!
	// <<<{constructor}{CustomerJpaDao}{Customer}
  }
  /**
   * getter for xsd:string/String id
   * null
   * @return id
   */
  @Id
  @Column(name="id")
  public String getId() { 
  	return getCustomerImpl().getId(); 
  }

  /**
   * setter for xsd:string/String id
   * null
   * @param pid - new value for id
   */
  public void setId(String pid) { 
  	getCustomerImpl().setId(pid); 
  }
  
  /**
   * getter for xsd:string/String name
   * null
   * @return name
   */
  @Column(name="name")
  public String getName() { 
  	return getCustomerImpl().getName(); 
  }

  /**
   * setter for xsd:string/String name
   * null
   * @param pname - new value for name
   */
  public void setName(String pname) { 
  	getCustomerImpl().setName(pname); 
  }
  
  /**
   * getter for xsd:string/String statusgroup
   * null
   * @return statusgroup
   */
  @Column(name="statusgroup")
  public String getStatusgroup() { 
  	return getCustomerImpl().getStatusgroup(); 
  }

  /**
   * setter for xsd:string/String statusgroup
   * null
   * @param pstatusgroup - new value for statusgroup
   */
  public void setStatusgroup(String pstatusgroup) { 
  	getCustomerImpl().setStatusgroup(pstatusgroup); 
  }
  
  /**
   * getter for xsd:string/String city
   * null
   * @return city
   */
  @Column(name="city")
  public String getCity() { 
  	return getCustomerImpl().getCity(); 
  }

  /**
   * setter for xsd:string/String city
   * null
   * @param pcity - new value for city
   */
  public void setCity(String pcity) { 
  	getCustomerImpl().setCity(pcity); 
  }
  
  /**
   * getter for Order/List<Order> orders
   * null
   * @return orders
   */
  @OneToMany(targetEntity=OrderJpaDao.class, cascade=CascadeType.ALL, mappedBy="customer")
  public List<Order> getOrders() { 
  	return getCustomerImpl().getOrders(); 
  }

  /**
   * setter for Order/List<Order> orders
   * null
   * @param porders - new value for orders
   */
  public void setOrders(List<Order> porders) { 
  	getCustomerImpl().setOrders(porders); 
  }
  
 /**
   * copy me from the given Customer
   * @param Customer - the source Object to copy from
   */
  public void copyFrom(Customer pCustomer) {
    mBOImpl.copyFrom(pCustomer);
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
    if (fieldName.equals("name")) result=getName();
    if (fieldName.equals("statusgroup")) result=getStatusgroup();
    if (fieldName.equals("city")) result=getCity();
    if (fieldName.equals("orders")) result=getOrders();
		return result;
	} // getField

	@Override
	public Map<String, Object> toMap() {
	  Map<String, Object> result=new HashMap<String,Object>();
    result.put("id",getId());
    result.put("name",getName());
    result.put("statusgroup",getStatusgroup());
    result.put("city",getCity());
		return result;
	} // toMap

	@Override
	public void fromMap(Map<String, Object> pMap) {
    if (pMap.containsKey("id"))	setId(getTypeConverter().getString(pMap.get("id")));
    if (pMap.containsKey("name"))	setName(getTypeConverter().getString(pMap.get("name")));
    if (pMap.containsKey("statusgroup"))	setStatusgroup(getTypeConverter().getString(pMap.get("statusgroup")));
    if (pMap.containsKey("city"))	setCity(getTypeConverter().getString(pMap.get("city")));
	} // fromMap
} // CustomerJpaDao
