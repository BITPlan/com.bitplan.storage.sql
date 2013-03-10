/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2012-12-29 13:01 with smartGENERATOR
 */
package com.bitplan.testentity;
import com.bitplan.restinterface.BOManagerFactory;
import com.bitplan.restinterface.BOManagerFactoryConfigurationImpl;
// Domain imports
import com.bitplan.testentity.Customer;
import com.bitplan.testentity.CustomerManager;
import com.bitplan.testentity.Order;
import com.bitplan.testentity.OrderManager;
import com.bitplan.testentity.TypeTest;
import com.bitplan.testentity.TypeTestManager;
import com.bitplan.testentity.Person;
import com.bitplan.testentity.PersonManager;
import com.bitplan.testentity.Contact;
import com.bitplan.testentity.ContactManager;
import com.bitplan.testentity.PhoneContact;
import com.bitplan.testentity.PhoneContactManager;
import com.bitplan.testentity.EMailContact;
import com.bitplan.testentity.EMailContactManager;

/**
 * Guice Module for  Testentity
 */
public class  TestentityBOManagerFactoryConfiguration extends BOManagerFactoryConfigurationImpl {
  /**
   * initialize 
   * @param - factory - the factory to configure
   */
  public void init(BOManagerFactory factory) throws Exception { 
    factory.getBOManager(CustomerManager.class,Customer.class);
    factory.getBOManager(OrderManager.class,Order.class);
    factory.getBOManager(TypeTestManager.class,TypeTest.class);
    factory.getBOManager(PersonManager.class,Person.class);
    factory.getBOManager(ContactManager.class,Contact.class);
    factory.getBOManager(PhoneContactManager.class,PhoneContact.class);
    factory.getBOManager(EMailContactManager.class,EMailContact.class);
  } // init
} // TestentityBOManagerFactoryConfiguration
