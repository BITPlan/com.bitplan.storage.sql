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
   * @return the value for id
   */
  public long getId() { return id; };

  /**
   * setter for id
   * @param pid - new value for id
   */
  public void setId(long pid) { id=pid; };
 
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
   * create a copy of the given Order
   * @param Order - the source Object to copy from
   * @return Order - an implementation fullfilling the Order interface
   */
	public static Order createCopy(Order pOrder) {
	  // FIXME need guice injection of interface here
	  Order result=new OrderImpl();
	  return result;
	} // createCopy
	
} // OrderImpl
