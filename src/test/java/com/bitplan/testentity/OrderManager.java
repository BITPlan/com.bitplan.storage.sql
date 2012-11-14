/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2012-11-14 17:05 with smartGENERATOR
 */
package com.bitplan.testentity;
// List interface
import java.util.List;

// restinterface imports
import com.bitplan.restinterface.BOManager;

/**
 * Manager for Restful access to Order
 */
public interface OrderManager extends BOManager<Order> {
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
