/*
 * Copyright (C) 2012 BITPlan GmbH
 *
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 */
package com.bitplan.storage.sql;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import com.bitplan.restinterface.BOManagerFactory;
import com.bitplan.testentity.Customer;
import com.bitplan.testentity.Order;
import com.bitplan.testentity.jpa.CustomerJpaDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Test SQL storage with EclipseLink see e.g.
 * http://www.vogella.com/articles/JavaPersistenceAPI/article.html
 * 
 * @author wf grant all on testsqlstorage.* to 'cm'@'localhost' identified by
 *         'secret'; see testsqlstorage.sql
 */
public class TestEclipseLink {

	boolean debug = false;
	static BOManagerFactory boManagerFactory;

	@BeforeClass
	public static void prepareGuice() throws Exception {
		TestSqlStorage.prepareGuice();
	  boManagerFactory=TestSqlStorage.boManagerFactory;
	}

	@Test
	public void testEclipseLink() throws Exception {
		EntityManager em=(EntityManager) boManagerFactory.getContext();
		em.getTransaction().begin();
		Customer customer = boManagerFactory.getInstance(Customer.class);
		customer.setId(1);
		customer.setName("John Doe");
		em.persist(customer);

		// Read the existing entries and write to console
		Query q = em.createQuery("select c from Customer c");
		@SuppressWarnings("unchecked")
		List<CustomerJpaDao> lCustomerList = q.getResultList();
		if (debug) {
			System.out.println("Size: " + lCustomerList.size());
		}
		assertEquals("There should be one customer in the list", 1,
				lCustomerList.size());
		for (CustomerJpaDao lCustomer : lCustomerList) {
			if (debug) {
				System.out.println("id: " + lCustomer.getId());
				System.out.println("name: " + lCustomer.getName());
			}
		}

		// Create 2 orders
		Order order1 = boManagerFactory.getInstance(Order.class);
		order1.setId(100);
		order1.setAddress("123 Main St. Anytown, USA");

		Order order2 = boManagerFactory.getInstance(Order.class);
		;
		order2.setId(200);
		order2.setAddress("567 1st St. Random City, USA");

		// Associate orders with the customer.

		// Note that the association must be set on both sides of the
		// relationship: on the customer side for the orders to be persisted
		// when transaction commits, and on the order side because it is the
		// owning side:
		order1.setCustomer(customer);
		// customer.getOrders().add(order1);
		em.persist(order1);

		order2.setCustomer(customer);
		// customer.getOrders().add(order2);
		em.persist(order2);
		em.getTransaction().commit();
		// em.close();
	}

	
}