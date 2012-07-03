package com.bitplan.testentity;

import java.util.List;
import javax.persistence.Query;
import com.bitplan.storage.sql.JPAEntityManager;

/**
 * Order Manager
 * @author wf
 *
 */
public class OrderManagerJPA extends JPAEntityManager<Order> implements OrderManager  {

	@Override
	public List<Order> getOrders() {
		return bolist;
	}
	
	/**
	 * set the orders
	 * @param pOrders
	 */
	public void setOrders(List<Order> pOrders) {
		bolist=pOrders;
	}
	
	@Override
	public Order create() {
		Order result=new OrderJPA(); // injector.
		return result;
	}

	@Override
	public void purge() {
		Query q = getEntityManager().createQuery("delete from Order o");
		q.executeUpdate();
	}

	@Override
	public Order findById(Object pId) {
		long id=(Long)pId;
		Query q = getEntityManager().createQuery(
				"select c from Order as c where c.id="+id);
		Order result=(Order) q.getSingleResult();
		return result;
	}

}
