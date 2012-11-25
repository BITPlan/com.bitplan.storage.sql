/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2012-11-24 22:29 with smartGENERATOR
 */
package com.bitplan.testentity;
import java.util.List;
import com.bitplan.testentity.Customer;
import com.bitplan.testentity.CustomerImpl;
import com.bitplan.testentity.Order;
import com.bitplan.testentity.OrderDao;
import com.google.inject.Inject;
	// >>>{implSection}{Customer}{Customer}
	// no implementation yet !!!
	// <<<{implSection}{Customer}{Customer}

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
  private List<Order> orders;
  
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
   * create a copy of the given CustomerDao
   * @param CustomerDao - the Data Access Object to copy from
   * @return Customer - an implementation fullfilling the Customer interface
   */
	public static Customer createCopy(CustomerDao pCustomer) {
	  // FIXME need guice injection of interface here
	  Customer result=new CustomerImpl();
	  return result;
	} // createCopy
	
} // CustomerImpl
