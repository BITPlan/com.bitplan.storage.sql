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
package com.bitplan.testentity.jpa;
// base Entity Manager
import com.bitplan.storage.sql.JPAEntityManager;
// List
import java.util.List;
import java.util.ArrayList;

// BO interface
import com.bitplan.restinterface.BO;


// Entity interfaces
import com.bitplan.testentity.Order;
import com.bitplan.testentity.OrderImpl;
import com.bitplan.testentity.OrderManager;
	// >>>{ManagerImports}{Orderjpa}{Order}
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

	// <<<{ManagerImports}{Orderjpa}{Order}
/**
 * JPA EntityManager implementation for interface Order
 * Entity: Order for container testentity
 */
public class OrderManagerJPA extends JPAEntityManager<Order>
	implements OrderManager {
	
	/**
	 * constructor
	 */
	public OrderManagerJPA() {
		this.setTableName("order_table");
	}
	// >>>{Managercode}{OrderJpaDao}{Order}
	// no implementation yet !!!
	// <<<{Managercode}{OrderJpaDao}{Order}

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
	public Order createNew() throws Exception {
		OrderJpaDao result = new OrderJpaDao(new OrderImpl());
		result.setBOManager(this);
	// >>>{add}{OrderManagerJpaDao}{Order}
	// no implementation yet !!!
	// <<<{add}{OrderManagerJpaDao}{Order}
		return result;
	}
	
		
	@Override
	public Class<? extends BO<?>> getEntityType() {
		return OrderJpaDao.class;
	}
	


} // OrderManagerJPA
