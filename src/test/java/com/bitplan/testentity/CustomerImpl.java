/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2012-12-29 09:04 with smartGENERATOR
 */
package com.bitplan.testentity;
import com.bitplan.testentity.Customer;
import java.util.List;
import com.bitplan.testentity.Order;
import java.util.ArrayList;
	// >>>{implSection}{Customer}{Customer}
	// no implementation yet !!!
	// <<<{implSection}{Customer}{Customer}
import com.google.inject.Inject;

/**
 * Pojo Implementation for Customer
 */
public class CustomerImpl implements Customer {

	// >>>{code}{Customer}{Customer}
	// no implementation yet !!!
	// <<<{code}{Customer}{Customer}
  
  /**
   * default constructor for a CustomerImpl 
   */
  public CustomerImpl() {
	// >>>{defaultConstructor}{Customer}{Customer}
	// no implementation yet !!!
	// <<<{defaultConstructor}{Customer}{Customer}
  }
    
  /**
   * id
   */
  private String id;
  
  /**
   * name
   */
  private String name;
  
  /**
   * statusgroup
   */
  private String statusgroup;
  
  /**
   * city
   */
  private String city;
  
  /**
   * orders
   */
  private List<Order> orders=new ArrayList<Order>();
  
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
   * getter for name
   * @return the value for name
   */
  public String getName() { return name; };

  /**
   * setter for name
   * @param pname - new value for name
   */
  public void setName(String pname) { name=pname; };
 
  /**
   * getter for statusgroup
   * @return the value for statusgroup
   */
  public String getStatusgroup() { return statusgroup; };

  /**
   * setter for statusgroup
   * @param pstatusgroup - new value for statusgroup
   */
  public void setStatusgroup(String pstatusgroup) { statusgroup=pstatusgroup; };
 
  /**
   * getter for city
   * @return the value for city
   */
  public String getCity() { return city; };

  /**
   * setter for city
   * @param pcity - new value for city
   */
  public void setCity(String pcity) { city=pcity; };
 
  /**
   * getter for orders
   * @return the value for orders
   */
  public List<Order> getOrders() { return orders; };

  /**
   * setter for orders
   * @param porders - new value for orders
   */
  public void setOrders(List<Order> porders) { orders=porders; };
 

  /**
   * copy me from the given Customer
   * @param Customer - the source Object to copy from
   */
  public void copyFrom(Customer pCustomer) {
		setId(pCustomer.getId());
		setName(pCustomer.getName());
		setStatusgroup(pCustomer.getStatusgroup());
		setCity(pCustomer.getCity());
	} // copyFrom
	
} // CustomerImpl
