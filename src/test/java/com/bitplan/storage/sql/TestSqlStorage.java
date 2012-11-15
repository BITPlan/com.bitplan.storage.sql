/*
 * Copyright (C) 2012 BITPlan GmbH
 *
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 */
package com.bitplan.storage.sql;

//import static org.junit.Assert.*;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.bitplan.restinterface.BOManagerFactory;
import com.bitplan.storage.TestStorage;
import com.bitplan.testentity.Customer;
import com.bitplan.testentity.Order;
import com.bitplan.testentity.TestentityJPAModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Test SQL storage with EclipseLink see e.g.
 * http://www.vogella.com/articles/JavaPersistenceAPI/article.html
 * 
 * @author wf grant all on testsqlstorage.* to 'cm'@'localhost' identified by
 *         'secret'; see testsqlstorage.sql
 */
public class TestSqlStorage {

	boolean debug = false;
	private static Injector injector;
	static BOManagerFactory boManagerFactory;

	@BeforeClass
	public static void prepareGuice() throws Exception {
		injector = Guice.createInjector(new TestentityJPAModule());
		boManagerFactory=injector.getInstance(BOManagerFactory.class);
		boManagerFactory.setInjector(injector);
		Map<String, String> props = new HashMap<String, String>();
		props.put("eclipselink.target-database", "MYSQL");
		props.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
		props.put("javax.persistence.jdbc.url",
				"jdbc:mysql://localhost:3306/testsqlstorage");
		props.put("javax.persistence.jdbc.user", "cm");
		props.put("javax.persistence.jdbc.password", "secret");
		props.put("eclipselink.ddl-generation", "drop-and-create-tables");
		// props.put("eclipselink.ddl-generation","create-tables");
		// props.put("eclipselink.ddl-generation.output-mode", "database");
		props.put("eclipselink.ddl-generation.output-mode", "both");
		boManagerFactory.setContext(props);
	}

	@Test
	public void testEclipseLink() throws Exception {
		EntityManager em=(EntityManager) boManagerFactory.getContext();
		em.getTransaction().begin();
		Customer customer = injector.getInstance(Customer.class);
		customer.setId(1);
		customer.setName("John Doe");
		em.persist(customer);

		// Read the existing entries and write to console
		Query q = em.createQuery("select c from Customer c");
		@SuppressWarnings("unchecked")
		List<Customer> lCustomerList = q.getResultList();
		if (debug) {
			System.out.println("Size: " + lCustomerList.size());
		}
		assertEquals("There should be one customer in the list", 1,
				lCustomerList.size());
		for (Customer lCustomer : lCustomerList) {
			if (debug) {
				System.out.println("id: " + lCustomer.getId());
				System.out.println("name: " + lCustomer.getName());
			}
		}

		// Create 2 orders
		Order order1 = injector.getInstance(Order.class);
		order1.setId(100);
		order1.setAddress("123 Main St. Anytown, USA");

		Order order2 = injector.getInstance(Order.class);
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

	/**
	 * test the JPA Storage
	 * @throws Exception 
	 */
	@Test
	public void testJPAStorage() throws Exception {
		TestStorage.testGenericStorage(boManagerFactory);	
	}
	
	/**
	 * test find function
	 * @throws Exception
	 */
	@Test
	public void testRead() throws Exception {
		TestStorage.testGenericRead(boManagerFactory);
	}
}
