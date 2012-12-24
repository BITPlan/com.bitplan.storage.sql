/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2012-12-24 09:41 with smartGENERATOR
 */
package com.bitplan.testentity;
import com.bitplan.testentity.Customer;
import java.util.List;
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
   * getter for xsd:string/String id
   * @return id
   */
  public String getId();

  /**
   * setter for xsd:string/String id
   * @param pid - new value for id
   */
  public void setId(String pid);

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
   * getter for xsd:string/String statusgroup
   * @return statusgroup
   */
  public String getStatusgroup();

  /**
   * setter for xsd:string/String statusgroup
   * @param pstatusgroup - new value for statusgroup
   */
  public void setStatusgroup(String pstatusgroup);

  /**
   * getter for xsd:string/String city
   * @return city
   */
  public String getCity();

  /**
   * setter for xsd:string/String city
   * @param pcity - new value for city
   */
  public void setCity(String pcity);

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

 /**
   * copy me from the given Customer
   * @param Customer - the source Object to copy from
   */
  public void copyFrom(Customer pCustomer);
} // Customer
