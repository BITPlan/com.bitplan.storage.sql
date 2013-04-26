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
package com.bitplan.testentity;
import com.bitplan.testentity.Order;
import com.bitplan.testentity.Customer;
	// >>>{implSection}{Order}{Order}
	// no implementation yet !!!
	// <<<{implSection}{Order}{Order}
import com.google.inject.Inject;

/**
 * Pojo Implementation for Order
 */
public class OrderImpl implements Order {

	// >>>{code}{Order}{Order}
	// no implementation yet !!!
	// <<<{code}{Order}{Order}
  
  /**
   * default constructor for a OrderImpl 
   */
  public OrderImpl() {
	// >>>{defaultConstructor}{Order}{Order}
	// no implementation yet !!!
	// <<<{defaultConstructor}{Order}{Order}
  }
    
  /**
   * id
   */
  private String id;
  
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
   * @return the value for id
   */
  public String getId() { return id; };

  /**
   * setter for id
   * @param pid - new value for id
   */
  public void setId(String pid) { id=pid; };
 
  /**
   * getter for shipping address
   * @return the value for address
   */
  public String getAddress() { return address; };

  /**
   * setter for shipping address
   * @param paddress - new value for shipping address
   */
  public void setAddress(String paddress) { address=paddress; };
 
  /**
   * getter for customer
   * @return the value for customer
   */
  public Customer getCustomer() { return customer; };

  /**
   * setter for customer
   * @param pcustomer - new value for customer
   */
  public void setCustomer(Customer pcustomer) { customer=pcustomer; };
 

  /**
   * copy me from the given Order
   * @param Order - the source Object to copy from
   */
  public void copyFrom(Order pOrder) {
		setId(pOrder.getId());
		setAddress(pOrder.getAddress());
	} // copyFrom
	
} // OrderImpl
