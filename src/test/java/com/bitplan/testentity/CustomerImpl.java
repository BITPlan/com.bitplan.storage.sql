/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2012-11-14 17:22 with smartGENERATOR
 */
package com.bitplan.testentity;
import java.util.List;
import com.bitplan.testentity.Customer;
import com.bitplan.testentity.Order;

/**
 * Pojo Implementation for Customer
 */
public class CustomerImpl implements Customer {
 
  Customer mCustomerDao;

	// >>>{code}{Customer}{Customer}
	// no implementation yet !!!
	// <<<{code}{Customer}{Customer}
  
  /**
   * default constructor for a CustomerImpl 
   */
  protected CustomerImpl() {
	// >>>{defaultConstructor}{Customer}{Customer}
	// no implementation yet !!!
	// <<<{defaultConstructor}{Customer}{Customer}
  }
  
  /**
   * construct a CustomerImpl from a given Data Access Object
   * @param pCustomer the Data Access Object to initialize this class from
   */
  public CustomerImpl(Customer pCustomer) {
    super();
    mCustomerDao=pCustomer;
	// >>>{constructor}{Customer}{Customer}
	// no implementation yet !!!
	// <<<{constructor}{Customer}{Customer}
  }

 
  /**
   * getter for name
   * @return name
   */
  public String getName() { 
  	return mCustomerDao.getName(); 
  };

  /**
   * setter for name
   * @param pname - new value for name
   */
  public void setName(String pname) { 
  	mCustomerDao.setName(pname); 
  }
 
  /**
   * getter for id
   * @return id
   */
  public long getId() { 
  	return mCustomerDao.getId(); 
  };

  /**
   * setter for id
   * @param pid - new value for id
   */
  public void setId(long pid) { 
  	mCustomerDao.setId(pid); 
  }
 
  /**
   * getter for orders
   * @return orders
   */
  public List<Order> getOrders() { 
  	return mCustomerDao.getOrders(); 
  };

  /**
   * setter for orders
   * @param porders - new value for orders
   */
  public void setOrders(List<Order> porders) { 
  	mCustomerDao.setOrders(porders); 
  }
} // CustomerImpl
