/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2012-11-24 17:24 with smartGENERATOR
 */
package com.bitplan.testentity;
import com.bitplan.testentity.Order;
import com.bitplan.testentity.OrderDao;
import com.bitplan.testentity.Customer;
import com.bitplan.testentity.CustomerDao;
import com.google.inject.Inject;
	// >>>{implSection}{Order}{Order}
	// no implementation yet !!!
	// <<<{implSection}{Order}{Order}

/**
 * Pojo Implementation for Order
 */
public class OrderImpl implements Order {
 
  /**
   * the data access object
   */
  protected OrderDao mOrderDao;
  
  /**
   * return the data access object for Order
   * @return the OrderDao 
   */
  public OrderDao getDao() {
    return mOrderDao;
  }

	// >>>{code}{Order}{Order}
	// no implementation yet !!!
	// <<<{code}{Order}{Order}
  
  /**
   * default constructor for a OrderImpl 
   */
  protected OrderImpl() {
	// >>>{defaultConstructor}{Order}{Order}
	// no implementation yet !!!
	// <<<{defaultConstructor}{Order}{Order}
  }
  
  /**
   * construct a OrderImpl from a given Data Access Object
   * @param pOrderDao the Data Access Object to initialize this class from
   */
  @Inject public OrderImpl(OrderDao pOrder) {
    super();
    mOrderDao=pOrder;
	// >>>{constructor}{Order}{Order}
	// no implementation yet !!!
	// <<<{constructor}{Order}{Order}
  }

 
  /**
   * getter for id
   * @return id
   */
  public long getId() { 
  	return mOrderDao.getId(); 
  };

  /**
   * setter for id
   * @param pid - new value for id
   */
  public void setId(long pid) { 
  	mOrderDao.setId(pid); 
  }
 
  /**
   * getter for shipping address
   * @return address
   */
  public String getAddress() { 
  	return mOrderDao.getAddress(); 
  };

  /**
   * setter for shipping address
   * @param paddress - new value for shipping address
   */
  public void setAddress(String paddress) { 
  	mOrderDao.setAddress(paddress); 
  }
 
  /**
   * getter for customer
   * @return customer
   */
  public Customer getCustomer() { 
  	return mOrderDao.getCustomer(); 
  };

  /**
   * setter for customer
   * @param pcustomer - new value for customer
   */
  public void setCustomer(Customer pcustomer) { 
  	mOrderDao.setCustomer(pcustomer); 
  }

  /**
   * create a copy of the given OrderDao
   * @param OrderDao - the Data Access Object to copy from
   * @return Order - an implementation fullfilling the Order interface
   */
	public static Order createCopy(OrderDao pOrder) {
	  // FIXME need guice injection of interface here
	  Order result=new OrderImpl();
	  return result;
	} // createCopy
	
} // OrderImpl
