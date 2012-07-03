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

	@Override
	public Order create() {
		Order result=new OrderJPA(); // injector.
		return result;
	}

	@Override
	public void purge() {
		Query q = getEntityManager().createQuery("delete from Order Order");
		q.executeUpdate();
	}

	@Override
	public Order findById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

}
