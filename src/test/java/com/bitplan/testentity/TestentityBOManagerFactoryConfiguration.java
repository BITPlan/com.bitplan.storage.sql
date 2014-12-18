/**
 * Copyright (C) 2011-2014 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2014-12-18 13:57 with smartGENERATOR
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
	// >>>{imports_BOManagerFactoryConfiguration}{TestentityBOManagerFactoryConfiguration}{Testentity}
	// no implementation yet !!!
	// <<<{imports_BOManagerFactoryConfiguration}{TestentityBOManagerFactoryConfiguration}{Testentity}

/**
 * BOManager Factory Configuration for  Testentity
 */
public class  TestentityBOManagerFactoryConfiguration extends BOManagerFactoryConfigurationImpl {
	// >>>{global_BOManagerFactoryConfiguration}{TestentityBOManagerFactoryConfiguration}{Testentity}
	// no implementation yet !!!
	// <<<{global_BOManagerFactoryConfiguration}{TestentityBOManagerFactoryConfiguration}{Testentity}
  /**
   * construct the BOManagerFactoryConfiguration
   * @param pName - the name
   */
  public TestentityBOManagerFactoryConfiguration(String pName) {
		super(pName);
	// >>>{constructor_BOManagerFactoryConfiguration}{TestentityBOManagerFactoryConfiguration}{Testentity}
	// no implementation yet !!!
	// <<<{constructor_BOManagerFactoryConfiguration}{TestentityBOManagerFactoryConfiguration}{Testentity}
	}

  /**
   * initialize 
   * @param - factory - the factory to configure
   */
  public void init(BOManagerFactory factory) throws Exception { 
    // first initialize the factory for this configuration
    factory.initConfiguration(this);
    // then add all BOManagers for this configuration
    factory.getBOManager(CustomerManager.class,Customer.class);
    factory.getBOManager(OrderManager.class,Order.class);
    factory.getBOManager(TypeTestManager.class,TypeTest.class);
    factory.getBOManager(PersonManager.class,Person.class);
    factory.getBOManager(ContactManager.class,Contact.class);
    factory.getBOManager(PhoneContactManager.class,PhoneContact.class);
    factory.getBOManager(EMailContactManager.class,EMailContact.class);
	// >>>{init_BOManagerFactoryConfiguration}{TestentityBOManagerFactoryConfiguration}{Testentity}
	// no implementation yet !!!
	// <<<{init_BOManagerFactoryConfiguration}{TestentityBOManagerFactoryConfiguration}{Testentity}
  } // init
} // TestentityBOManagerFactoryConfiguration
