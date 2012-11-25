/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2012-11-25 12:03 with smartGENERATOR
 */
package com.bitplan.testentity;
import com.bitplan.testentity.Order;
import com.bitplan.testentity.Customer;

/**
 * interface for Order
 */
public interface Order {
	// >>>{interface}{Order}{Order}
	// no implementation yet !!!
	// <<<{interface}{Order}{Order}
  /**
   * getter for id
   * @return id
   */
  public long getId();

  /**
   * setter for id
   * @param pid - new value for id
   */
  public void setId(long pid);

  /**
   * getter for shipping address
   * @return address
   */
  public String getAddress();

  /**
   * setter for shipping address
   * @param paddress - new value for shipping address
   */
  public void setAddress(String paddress);

  /**
   * getter for customer
   * @return customer
   */
  public Customer getCustomer();

  /**
   * setter for customer
   * @param pcustomer - new value for customer
   */
  public void setCustomer(Customer pcustomer);

} // Order
