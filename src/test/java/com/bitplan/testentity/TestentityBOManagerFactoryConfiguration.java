/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2012-12-09 14:17 with smartGENERATOR
 */
package com.bitplan.testentity;
import com.bitplan.restinterface.BOManagerFactory;
import com.bitplan.restinterface.BOManagerFactoryConfiguration;
// Domain imports
import com.bitplan.testentity.Customer;
import com.bitplan.testentity.CustomerManager;
import com.bitplan.testentity.Order;
import com.bitplan.testentity.OrderManager;
import com.bitplan.testentity.TypeTest;
import com.bitplan.testentity.TypeTestManager;

/**
 * Guice Module for  Testentity
 */
public class  TestentityBOManagerFactoryConfiguration implements BOManagerFactoryConfiguration {
  /**
   * initialize 
   * @param - factory - the factory to configure
   */
  public void init(BOManagerFactory factory) throws Exception { 
    factory.getBOManager(CustomerManager.class,Customer.class);
    factory.getBOManager(OrderManager.class,Order.class);
    factory.getBOManager(TypeTestManager.class,TypeTest.class);
  } // init
} // TestentityBOManagerFactoryConfiguration
