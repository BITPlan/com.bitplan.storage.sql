/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2012-11-23 17:41 with smartGENERATOR
 */
package com.bitplan.testentity.jpa;
// List interface
import java.util.List;
// BO interface
import com.bitplan.restinterface.BO;
// base Entity Manager
import com.bitplan.storage.sql.JPAEntityManager;
// Entity interfaces
import com.bitplan.testentity.Order;
import com.bitplan.testentity.OrderImpl;
import com.bitplan.testentity.OrderManager;
/**
 * JPA EntityManager implementation for interface Order
 * Entity: Order for container testentity
 */
public class OrderManagerJPA extends JPAEntityManager<Order>
	implements OrderManager {
  /**
	 * set the orders
	 * @param pOrders
	 */
	@Override
	public void setOrders(List<Order> pOrders) {
		super.bolist=pOrders;
	}
	
	/**
	 * @return the orders
	 */
	@Override
	public List<Order> getOrders() {
		return super.bolist;
	}
	
	@Override
	public Order create() {
		OrderJpaDao OrderDao = new OrderJpaDao();
		OrderDao.setBOManager(this);
		Order result=new OrderImpl(OrderDao);
		return result;
	}
		
	@Override
	public void purge() {
	  super.bolist.clear();
	}
	@Override
	public Class<? extends BO<?>> getEntityType() {
		return OrderJpaDao.class;
	}
	


} // OrderManagerJPA
