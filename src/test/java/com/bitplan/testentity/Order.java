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

/**
 * interface for Order
 */
public interface Order {
	// >>>{interface}{Order}{Order}
	// no implementation yet !!!
	// <<<{interface}{Order}{Order}
  /**
   * getter for xsd:string/String id
   * null
   * @return id
   */
  public String getId();

  /**
   * setter for xsd:string/String id
   * null
   * @param pid - new value for id
   */
  public void setId(String pid);

  /**
   * getter for xsd:string/String shipping address
   * null
   * @return address
   */
  public String getAddress();

  /**
   * setter for xsd:string/String shipping address
   * null
   * @param paddress - new value for shipping address
   */
  public void setAddress(String paddress);

  /**
   * getter for Customer/Customer customer
   * null
   * @return customer
   */
  public Customer getCustomer();

  /**
   * setter for Customer/Customer customer
   * null
   * @param pcustomer - new value for customer
   */
  public void setCustomer(Customer pcustomer);

 /**
   * copy me from the given Order
   * @param Order - the source Object to copy from
   */
  public void copyFrom(Order pOrder);
} // Order
