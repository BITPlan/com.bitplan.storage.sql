/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2012-11-25 12:53 with smartGENERATOR
 */
package com.bitplan.testentity;
// Infrastructure imports
import com.bitplan.restinterface.BOManagerFactory;
import com.bitplan.storage.sql.JPAEntityManagerFactory;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

// Domain imports
import com.bitplan.testentity.Customer;
import com.bitplan.testentity.CustomerImpl;
import com.bitplan.testentity.jpa.CustomerJpaDao;
import com.bitplan.testentity.CustomerManager;
import com.bitplan.testentity.jpa.CustomerManagerJPA;
import com.bitplan.testentity.Order;
import com.bitplan.testentity.OrderImpl;
import com.bitplan.testentity.jpa.OrderJpaDao;
import com.bitplan.testentity.OrderManager;
import com.bitplan.testentity.jpa.OrderManagerJPA;

/**
 * Guice Module for  Testentity
 */
public class  TestentityJPAModule extends AbstractModule {  
  @Override 
  protected void configure() {
    // Infrastructure bindings
    // guice binding for BOManagerFactory
    bind(BOManagerFactory.class).to(JPAEntityManagerFactory.class);
    // Domain entity bindings
    // guice binding for Customer
    bind(Customer.class).to(CustomerJpaDao.class);
    bind(CustomerManager.class).to(CustomerManagerJPA.class);
    // guice binding for Order
    bind(Order.class).to(OrderJpaDao.class);
    bind(OrderManager.class).to(OrderManagerJPA.class);
  } // configure

} // TestentityModule
