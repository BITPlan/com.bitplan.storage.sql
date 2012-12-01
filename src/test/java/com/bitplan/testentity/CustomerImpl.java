/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2012-12-01 05:48 with smartGENERATOR
 */
package com.bitplan.testentity;
import java.util.List;
import com.bitplan.testentity.Customer;
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
  private List<Order> orders=new ArrayList<Order>();
  
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
		setName(pCustomer.getName());
		setId(pCustomer.getId());
		setOrders(pCustomer.getOrders());
	} // copyFrom
	
} // CustomerImpl
