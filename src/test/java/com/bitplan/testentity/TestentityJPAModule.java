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
// Infrastructure imports

import com.bitplan.restinterface.BOManagerFactory;
import com.bitplan.restinterface.Frame;
import com.bitplan.restinterface.Configuration;
import com.bitplan.storage.sql.JPAEntityManagerFactory;
import com.google.inject.AbstractModule;
//import com.google.inject.name.Names;

// Domain imports
import com.bitplan.testentity.Customer;
import com.bitplan.testentity.jpa.CustomerJpaDao;
import com.bitplan.testentity.CustomerManager;
import com.bitplan.testentity.jpa.CustomerManagerJPA;
import com.bitplan.testentity.Order;
import com.bitplan.testentity.jpa.OrderJpaDao;
import com.bitplan.testentity.OrderManager;
import com.bitplan.testentity.jpa.OrderManagerJPA;
import com.bitplan.testentity.TypeTest;
import com.bitplan.testentity.jpa.TypeTestJpaDao;
import com.bitplan.testentity.TypeTestManager;
import com.bitplan.testentity.jpa.TypeTestManagerJPA;
import com.bitplan.testentity.Person;
import com.bitplan.testentity.jpa.PersonJpaDao;
import com.bitplan.testentity.PersonManager;
import com.bitplan.testentity.jpa.PersonManagerJPA;
import com.bitplan.testentity.Contact;
import com.bitplan.testentity.jpa.ContactJpaDao;
import com.bitplan.testentity.ContactManager;
import com.bitplan.testentity.jpa.ContactManagerJPA;
import com.bitplan.testentity.PhoneContact;
import com.bitplan.testentity.jpa.PhoneContactJpaDao;
import com.bitplan.testentity.EMailContact;
import com.bitplan.testentity.jpa.EMailContactJpaDao;
	// >>>{imports_JPAModule}{TestentityJPAModule}{Testentity}
import com.bitplan.rest.jqgrid.JqGridSearch;
import com.bitplan.rest.jqgrid.JqGridSearchImpl;
	// <<<{imports_JPAModule}{TestentityJPAModule}{Testentity}
/**
 * Guice Module for  Testentity
 */
public class  TestentityJPAModule extends AbstractModule {  
  @Override 
  protected void configure() {
	// >>>{configure_JPAModule}{TestentityJPAModule}{Testentity}
	bind(JqGridSearch.class).to(JqGridSearchImpl.class);
	// <<<{configure_JPAModule}{TestentityJPAModule}{Testentity}
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
    // guice binding for TypeTest
    bind(TypeTest.class).to(TypeTestJpaDao.class);
    bind(TypeTestManager.class).to(TypeTestManagerJPA.class);
    // guice binding for Person
    bind(Person.class).to(PersonJpaDao.class);
    bind(PersonManager.class).to(PersonManagerJPA.class);
    // guice binding for Contact
    bind(Contact.class).to(ContactJpaDao.class);
    bind(ContactManager.class).to(ContactManagerJPA.class);
    // guice binding for PhoneContact
    bind(PhoneContact.class).to(PhoneContactJpaDao.class);
    // guice binding for EMailContact
    bind(EMailContact.class).to(EMailContactJpaDao.class);
  } // configure

} // TestentityModule
