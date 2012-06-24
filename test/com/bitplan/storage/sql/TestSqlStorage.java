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

import org.junit.Before;
import org.junit.Test;

import com.bitplan.testentity.Customer;
import com.bitplan.testentity.Order;
import com.bitplan.testentity.TestentityJPAModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



/**
 * Test SQL storage with EclipseLink
 * see e.g.
 * http://www.vogella.com/articles/JavaPersistenceAPI/article.html
 * 
 * @author wf
 *  grant all on customers.* to 'cm'@'%.bitplan.com' identified by 'secret';
 */
public class TestSqlStorage {
	private static final String PERSISTENCE_UNIT_NAME = "default";
	private static EntityManagerFactory factory;
	private Injector injector;

	@Before
	public void prepareGuice() {
		injector = Guice.createInjector(new TestentityJPAModule());
	}
	
	@Test
	public void testEclipseLink() {
		Map<String,String> props=new HashMap<String,String>();
		props.put("eclipselink.target-database","MYSQL");
		props.put("javax.persistence.jdbc.driver","com.mysql.jdbc.Driver");
		props.put("javax.persistence.jdbc.url", "jdbc:mysql://capri.bitplan.com:3306/customers");
		props.put("javax.persistence.jdbc.user","cm");
		props.put("javax.persistence.jdbc.password", "secret");
		props.put("eclipselink.ddl-generation","drop-and-create-tables");
		// props.put("eclipselink.ddl-generation","create-tables");
		props.put("eclipselink.ddl-generation.output-mode","database");
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME,props);
		EntityManager em = factory.createEntityManager();
		// Read the existing entries and write to console
		Query q = em.createQuery("select c from Customer c");
		@SuppressWarnings("unchecked")
		List<Customer> customerList = q.getResultList();
		for (Customer customer : customerList) {
			System.out.println(customer.getId());
			System.out.println(customer.getName());
		}
		System.out.println("Size: " + customerList.size());

		// Create new Customer
		em.getTransaction().begin();
		Customer customer =injector.getInstance(Customer.class);
		customer.setId(1);
		customer.setName("John Doe");
		em.persist(customer);
	  
		// Create 2 orders
    Order order1 =injector.getInstance(Order.class);
    order1.setId(100);
    order1.setAddress("123 Main St. Anytown, USA");

    Order order2 = injector.getInstance(Order.class);;
    order2.setId(200);
    order2.setAddress("567 1st St. Random City, USA");

    // Associate orders with the customer.

    // Note that the association must be set on both sides of the relationship: on the customer side for the orders to be persisted when transaction commits, and on the order side because it is the owning side:
    order1.setCustomer(customer);
    //customer.getOrders().add(order1);
    em.persist(order1);
    
    order2.setCustomer(customer); 
    //customer.getOrders().add(order2);
    em.persist(order2);
		em.getTransaction().commit();
		em.close();
	}

}
