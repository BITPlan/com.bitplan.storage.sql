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
// List interface
import java.util.List;

// restinterface imports
import com.bitplan.restinterface.BOManager;
	// >>>{ManagerImportSection}{Order}{Order}
	// no implementation yet !!!
	// <<<{ManagerImportSection}{Order}{Order}
/**
 * Manager for Restful access to Order
 */
public interface OrderManager extends BOManager<Order> {
	// >>>{ManagerImplSection}{Order}{Order}
	// no implementation yet !!!
	// <<<{ManagerImplSection}{Order}{Order}

	/**
	 * set the orders
	 * @param pOrders
	 */
	public void setOrders(List<Order> pOrders);
	
	/**
	 * @return the orders
	 */
	public List<Order> getOrders();
	
} // OrderManager
