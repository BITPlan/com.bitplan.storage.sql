/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2012-11-28 16:46 with smartGENERATOR
 */
package com.bitplan.testentity;
// List interface
import java.util.List;

// restinterface imports
import com.bitplan.restinterface.BOManager;
	// >>>{ManagerImportSection}{Customer}{Customer}
	// no implementation yet !!!
	// <<<{ManagerImportSection}{Customer}{Customer}
/**
 * Manager for Restful access to Customer
 */
public interface CustomerManager extends BOManager<Customer> {
	// >>>{ManagerImplSection}{Customer}{Customer}
	// no implementation yet !!!
	// <<<{ManagerImplSection}{Customer}{Customer}

	/**
	 * set the customers
	 * @param pCustomers
	 */
	public void setCustomers(List<Customer> pCustomers);
	
	/**
	 * @return the customers
	 */
	public List<Customer> getCustomers();
	
} // CustomerManager
