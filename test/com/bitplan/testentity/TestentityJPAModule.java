/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 *
 * Tel. 02154 811-480
 * Fax. 02154 811-480
 * 
 * $HeadURL$
 * $LastChangedDate$
 * $LastChangedRevision$
 * $LastChangedBy$
 * $Id$
 *
 * generated: 07.01.2012 um 16:54
 */
package com.bitplan.testentity;
import com.google.inject.AbstractModule;

/**
 * Guice Module for  Testentity
 */
public class  TestentityJPAModule extends AbstractModule {  
  @Override 
  public void configure() {
    // guice binding for Customer
    bind(Customer.class).to(CustomerJPA.class);
    // guice binding for Order
    bind(Order.class).to(OrderJPA.class);
 
  }

} // TestentityJPAModule
