/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2012-11-15 15:54 with smartGENERATOR
 */
package com.bitplan.testentity.jpa;
import java.io.Serializable;
// JPA / Hibernate imports
import javax.persistence.*;
//import static javax.persistence.CascadeType.*;
import com.bitplan.storage.sql.JPABOImpl;

import java.util.List;
import com.bitplan.testentity.Customer;
import com.bitplan.testentity.Order;

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
   * name
   */
  private String name;
  
  /**
   * id
   */
  private long id;
  
  /**
   * orders
   */
  private List<Order> orders;
  
  /**
   * getter for name
   * @return name
   */
  @Column(name="name")
  public String getName() { return name; };

  /**
   * setter for name
   * @param pname - new value for name
   */
  public void setName(String pname) { name=pname; };

  /**
   * getter for id
   * @return id
   */
  @Id
  @Column(name="id")
  public long getId() { return id; };

  /**
   * setter for id
   * @param pid - new value for id
   */
  public void setId(long pid) { id=pid; };

  /**
   * getter for orders
   * @return orders
   */
  @Column(name="orders")
  public List<Order> getOrders() { return orders; };

  /**
   * setter for orders
   * @param porders - new value for orders
   */
  public void setOrders(List<Order> porders) { orders=porders; };


  /**
   * get the primary key of this business object
   */
	@Transient
  public Object getPrimaryKey() {
  	return getId();
  }
} // CustomerJpaDao
