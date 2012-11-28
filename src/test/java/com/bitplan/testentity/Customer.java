/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2012-11-28 18:17 with smartGENERATOR
 */
package com.bitplan.testentity;
import java.util.List;
import com.bitplan.testentity.Customer;
import com.bitplan.testentity.Order;
	// >>>{implSection}{Customer}{Customer}
	// no implementation yet !!!
	// <<<{implSection}{Customer}{Customer}

/**
 * interface for Customer
 */
public interface Customer {
	// >>>{interface}{Customer}{Customer}
	// no implementation yet !!!
	// <<<{interface}{Customer}{Customer}
  /**
   * getter for xsd:string/String name
   * @return name
   */
  public String getName();

  /**
   * setter for xsd:string/String name
   * @param pname - new value for name
   */
  public void setName(String pname);

  /**
   * getter for xsd:long/long id
   * @return id
   */
  public long getId();

  /**
   * setter for xsd:long/long id
   * @param pid - new value for id
   */
  public void setId(long pid);

  /**
   * getter for Order/List<Order> orders
   * @return orders
   */
  public List<Order> getOrders();

  /**
   * setter for Order/List<Order> orders
   * @param porders - new value for orders
   */
  public void setOrders(List<Order> porders);

} // Customer
