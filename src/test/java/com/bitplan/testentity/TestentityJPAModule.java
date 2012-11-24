/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2012-11-24 17:48 with smartGENERATOR
 */
package com.bitplan.testentity;
import com.bitplan.testentity.Customer;
import com.bitplan.testentity.CustomerImpl;
import com.bitplan.testentity.CustomerManager;
import com.bitplan.testentity.CustomerDao;
import com.bitplan.testentity.jpa.CustomerJpaDao;
import com.bitplan.testentity.jpa.CustomerManagerJPA;
import com.bitplan.testentity.Order;
import com.bitplan.testentity.OrderImpl;
import com.bitplan.testentity.OrderManager;
import com.bitplan.testentity.OrderDao;
import com.bitplan.testentity.jpa.OrderJpaDao;
import com.bitplan.testentity.jpa.OrderManagerJPA;
import com.google.inject.AbstractModule;

/**
 * Guice Module for  Testentity
 */
public class  TestentityJPAModule extends AbstractModule {  
  @Override 
  protected void configure() {
    // guice binding for Customer
    bind(CustomerDao.class).to(CustomerJpaDao.class);
    bind(Customer.class).to(CustomerImpl.class);
    bind(CustomerManager.class).to(CustomerManagerJPA.class);
    // guice binding for Order
    bind(OrderDao.class).to(OrderJpaDao.class);
    bind(Order.class).to(OrderImpl.class);
    bind(OrderManager.class).to(OrderManagerJPA.class);
  }

} // TestentityModule
