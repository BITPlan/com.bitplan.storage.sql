/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2012-11-24 17:26 with smartGENERATOR
 */
package com.bitplan.testentity.jpa;
import java.io.Serializable;
// JPA / Hibernate imports
import javax.persistence.*;
//import static javax.persistence.CascadeType.*;
import com.bitplan.storage.sql.JPABOImpl;

import com.bitplan.testentity.Order;
import com.bitplan.testentity.OrderDao;
import com.bitplan.testentity.Customer;
import com.bitplan.testentity.CustomerDao;

/**
 * JPA Data access object for Order
 * Entity: Order for container testentity
 * Table: order_table
 */
@Entity(name="Order")
@Table(name="order_table")
public class OrderJpaDao extends JPABOImpl<Order>  implements OrderDao, Serializable{

  /**   
   * make Serializable happy ...   
   */  
  private static final long serialVersionUID = 1L;  
  /**
   * id
   */
  private long id;
  
  /**
   * shipping address
   */
  private String address;
  
  /**
   * customer
   */
  private Customer customer;
  
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
   * getter for shipping address
   * @return address
   */
  @Column(name="SHIPPING_ADDRESS")
  public String getAddress() { return address; };

  /**
   * setter for shipping address
   * @param paddress - new value for shipping address
   */
  public void setAddress(String paddress) { address=paddress; };

  /**
   * getter for customer
   * @return customer
   */
  @ManyToOne(targetEntity=CustomerJpaDao.class)
  public Customer getCustomer() { return customer; };

  /**
   * setter for customer
   * @param pcustomer - new value for customer
   */
  public void setCustomer(Customer pcustomer) { customer=pcustomer; };


  /**
   * get the primary key of this business object
   */
	@Transient
  public Object getPrimaryKey() {
  	return getId();
  }
} // OrderJpaDao
