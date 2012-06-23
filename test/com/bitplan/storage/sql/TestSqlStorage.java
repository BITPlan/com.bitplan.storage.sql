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

import org.junit.Test;

import com.bitplan.testentity.Customer;
import com.bitplan.testentity.CustomerJPA;

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
 *
 */
public class TestSqlStorage {
	private static final String PERSISTENCE_UNIT_NAME = "default";
	private static EntityManagerFactory factory;

	@Test
	public void testEclipseLink() {
		Map<String,String> props=new HashMap<String,String>();
		props.put("javax.persistence.jdbc.driver","com.mysql.jdbc.Driver");
		props.put("javax.persistence.jdbc.url", "jdbc:mysql://jolo.bitplan.com:3306/test");
	// Ensure RESOURCE_LOCAL transactions is used.
	//	props.put(TRANSACTION_TYPE,  PersistenceUnitTransactionType.RESOURCE_LOCAL.name());
		/*
		props.put("eclipselink.target-database", "MySQL4" );
		props.put("eclipselink.jdbc.driver", "com.mysql.jdbc.Driver" );
		props.put("eclipselink.jdbc.url", "jdbc:mysql://jolo.bitplan.com:3306/test");
		props.put("eclipselink.jdbc.user", "root");
		props.put("eclipselink.jdbc.password", "root");*/
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME,props);
		EntityManager em = factory.createEntityManager();
		// Read the existing entries and write to console
		Query q = em.createQuery("select c from customer c");
		@SuppressWarnings("unchecked")
		List<Customer> customerList = q.getResultList();
		for (Customer customer : customerList) {
			System.out.println(customer.getId());
			System.out.println(customer.getName());
		}
		System.out.println("Size: " + customerList.size());

		// Create new Customer
		em.getTransaction().begin();
		Customer customer = new CustomerJPA();
		customer.setName("John Doe");
		em.persist(customer);
		em.getTransaction().commit();

		em.close();
	}

}
