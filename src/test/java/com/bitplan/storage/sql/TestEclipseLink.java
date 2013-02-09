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

import com.bitplan.rest.jqgrid.JqGridFilter;
import com.bitplan.rest.jqgrid.JqGridFilterImpl;
import com.bitplan.rest.jqgrid.JqGridSearch;
import com.bitplan.rest.jqgrid.JqGridFilter.GroupOp;
import com.bitplan.rest.jqgrid.JqGridFilter.Operations;
import com.bitplan.rest.jqgrid.JqGridSearch.SortOrder;
import com.bitplan.rest.jqgrid.JqGridSearchImpl;
import com.bitplan.restinterface.BOManager;
import com.bitplan.restinterface.BOManagerFactory;
import com.bitplan.testentity.Customer;
import com.bitplan.testentity.CustomerManager;
import com.bitplan.testentity.Order;
import com.bitplan.testentity.jpa.CustomerJpaDao;
import com.bitplan.testentity.jpa.CustomerManagerJPA;

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

	boolean debug = true;
	private EntityManager em;
	static BOManagerFactory boManagerFactory;

	@BeforeClass
	public static void prepareGuice() throws Exception {
		TestSqlStorage.prepareGuice();
		boManagerFactory = TestSqlStorage.boManagerFactory;
	}

	/**
	 * get the CustomerManager
	 * @return
	 * @throws Exception
	 */
	public CustomerManagerJPA getCustomerManager() throws Exception {
		BOManager<Customer> boManager = this.boManagerFactory.getBOManager(
				CustomerManager.class, Customer.class);
		assertTrue(boManager instanceof CustomerManagerJPA);
		CustomerManagerJPA customerManager = (CustomerManagerJPA) boManager;
		return customerManager;
	}

	/**
	 * add a customer
	 * 
	 * @param id
	 * @param name
	 * @return
	 */
	public Customer addCustomer(String id, String name, String city, String statusGroup) {
		Customer customer = boManagerFactory.getInstance(Customer.class);
		customer.setId(id);
		customer.setName(name);
		customer.setCity(city);
		customer.setStatusgroup(statusGroup);
		em.persist(customer);
		return customer;
	}

	@Test
	public void testEclipseLink() throws Exception {
		String[] ids = { "1", "2", "3" };
		String[] names = { "John Doe", "John Smith", "Heather Bourne" };

		em = (EntityManager) boManagerFactory.getContext();
		Customer customer1 = null;
		em.getTransaction().begin();
		for (int i = 0; i < ids.length; i++) {
			Customer customer = addCustomer(ids[i], names[i],"New York","regular");
			if (i == 0)
				customer1 = customer;
		}

		// Read the existing entries and write to console
		Query q = em.createQuery("select c from Customer c");
		@SuppressWarnings("unchecked")
		List<CustomerJpaDao> lCustomerList = q.getResultList();
		if (debug) {
			System.out.println("Size: " + lCustomerList.size());
		}
		assertEquals("There should be one customer in the list", 3,
				lCustomerList.size());
		for (CustomerJpaDao lCustomer : lCustomerList) {
			if (debug) {
				System.out.println("id: " + lCustomer.getId() + " name: "
						+ lCustomer.getName());
			}
		}

		// Create 2 orders
		Order order1 = boManagerFactory.getInstance(Order.class);
		order1.setId("100");
		order1.setAddress("123 Main St. Anytown, USA");

		Order order2 = boManagerFactory.getInstance(Order.class);
		;
		order2.setId("200");
		order2.setAddress("567 1st St. Random City, USA");

		// Associate orders with the customer.

		// Note that the association must be set on both sides of the
		// relationship: on the customer side for the orders to be persisted
		// when transaction commits, and on the order side because it is the
		// owning side:
		order1.setCustomer(customer1);
		// customer.getOrders().add(order1);
		em.persist(order1);

		order2.setCustomer(customer1);
		// customer.getOrders().add(order2);
		em.persist(order2);
		em.getTransaction().commit();
		// em.close();
	}

	@Test
	public void testMaxQuery() {
		EntityManager em = (EntityManager) boManagerFactory.getContext();
		String maxCustomerId = em.createQuery("select max(c.id) from Customer c",
				String.class).getSingleResult();
		assertEquals("3", maxCustomerId);
		String maxOrderId = em.createQuery("select max(o.id) from Order o",
				String.class).getSingleResult();
		assertEquals("200", maxOrderId);
	}

	/**
	 * get the given search
	 * 
	 * @param sortIndex
	 * @param sortOrder
	 * @param jsonFilters
	 * @param firstResult
	 * @param maxResults
	 * @return
	 * @throws Exception
	 */
	public JqGridSearch getSearch(String sortIndex, String sortOrder,
			String jsonFilters, int firstResult, int maxResults) throws Exception {
		JqGridSearch search = new JqGridSearchImpl();
		search.fromJqGrid(sortIndex, sortOrder, jsonFilters, firstResult,
				maxResults);
		return search;
	}

	/**
	 * parameterized test
	 * 
	 * @param customerManager
	 * @param sortOrder
	 * @param json
	 * @param expectedSize
	 * @param expectedFirst
	 * @param firstResult
	 * @param maxResult
	 * @throws Exception
	 */
	public void testJqGridSearch(CustomerManagerJPA customerManager,
			String sortOrder, String json, int expectedSize, String expectedFirst,
			int firstResult, int maxResult) throws Exception {
		JqGridSearch search = this.getSearch("name", sortOrder, json, firstResult,
				maxResult);
		if (debug) {
			JqGridFilter filter = search.getFilter();
			if (filter != null)
				System.out.println("filter:" + filter.asJson());
			else
				System.out.println("filter:null");
		}
		List<Customer> customers = customerManager.findByJqGridFilter(search);
		assertEquals(expectedSize, customers.size());
		if (debug)
			System.out.println(customers.size());
		for (Customer customer : customers) {
			if (debug)
				System.out.println(customer.getId() + ", " + customer.getName());
		}
		assertEquals(expectedFirst, customers.get(0).getName());
	}

	/**
	 * parameterized search
	 * 
	 * @param customerManager
	 * @param sortOrder
	 * @param searchStr
	 * @param ops
	 * @param groupOps
	 * @param more
	 * @param expectedSize
	 * @param expectedFirst
	 * @param firstResult
	 * @param maxResult
	 * @throws Exception
	 */
	public void testJqGridSearch(CustomerManagerJPA customerManager,
			String sortOrder, String searchStr, String ops, String groupOps,
			String more, int expectedSize, String expectedFirst, int firstResult,
			int maxResult) throws Exception {
		String json = "{\n" + "  \"groupOp\" : \"" + groupOps + "\",\n"
				+ "  \"rules\" : [ {\n" + "    \"field\" : \"name\",\n"
				+ "    \"op\" : \"" + ops + "\",\n" + "    \"data\" : \"" + searchStr
				+ "\"\n" + "  }" + more + " ]\n" + "}";
		this.testJqGridSearch(customerManager, sortOrder, json, expectedSize,
				expectedFirst, firstResult, maxResult);
	}

	/**
	 * test jqGrid Search
	 * @throws Exception
	 */
	@Test
	public void testJqGridSearch() throws Exception {
    CustomerManagerJPA customerManager = this.getCustomerManager();
		String ops[] = { "eq", "ne", "bw", "cn", "nc", "cn", "eq" };
		String groupOps[] = { "AND", "AND", "AND", "AND", "AND", "AND", "OR" };
		String sortOrder[] = { "desc", "desc", "desc", "desc", "desc", "desc",
				"asc" };
		String searchStr[] = { "John Doe", "John Doe", "John", "Doe", "John",
				"John", "Heather Bourne" };
		int expectedSize[] = { 1, 2, 2, 1, 1, 1, 2 };
		String expectedFirst[] = { "John Doe", "John Smith", "John Smith",
				"John Doe", "Heather Bourne", "John Doe", "Heather Bourne" };
		String more[] = { "", "", "", "", "",
				",{\"field\" : \"name\", \"op\" : \"cn\", \"data\" : \"Doe\" }",
				",{\"field\" : \"name\", \"op\" : \"cn\", \"data\" : \"Doe\" }", };
		for (int oindex = 0; oindex < ops.length; oindex++) {
			this.testJqGridSearch(customerManager, sortOrder[oindex],
					searchStr[oindex], ops[oindex], groupOps[oindex], more[oindex],
					expectedSize[oindex], expectedFirst[oindex], 0, 10);
		}
		int expectedSize2[] = { 1, 2, 1, 2, 2, 2, 1, 1, 2, 1, 1, 1, 2, 1 };
		String searchStr2[] = { "John Doe", "John Doe", "John", "John Doe", "Joh",
				"John Doe", "Heat", "Jo", "John Doe,John Smith", "John Smith,John Doe",
				"Doe", "e", "ohn", "th" };
		String expectedFirst2[] = { "John Doe", "Heather Bourne", "Heather Bourne",
				"Heather Bourne", "John Doe", "John Doe", "Heather Bourne",
				"Heather Bourne", "John Doe", "Heather Bourne", "John Doe",
				"John Smith", "John Doe", "John Doe" };

		int oindex = 0;
		for (Operations op : JqGridFilter.Operations.values()) {
			if (debug)
				System.out.println("" + (oindex) + ": name " + op.name() + " "
						+ searchStr2[oindex] + "=>" + expectedSize2[oindex] + ","
						+ expectedFirst2[oindex]);
			this.testJqGridSearch(customerManager, "asc", searchStr2[oindex],
					op.name(), "AND", "", expectedSize2[oindex], expectedFirst2[oindex],
					0, 10);
			oindex++;
		}
		this.testJqGridSearch(customerManager, "asc", null, 3, "Heather Bourne", 0,
				10);
	}

	/**
	 * test the Paging functionality
	 * @throws Exception 
	 */
	@Test
	public void testPaging() throws Exception {
		em = (EntityManager) boManagerFactory.getContext();
		em.getTransaction().begin();
		for (int i=1000;i<1100;i++) {
   			this.addCustomer(""+i, "Customer #"+i,"London","VIP");
		}
		em.getTransaction().commit();
	  CustomerManagerJPA customerManager = this.getCustomerManager();
	 	this.testJqGridSearch(customerManager, "desc","Customer #10","bw", "AND", "", 20, "Customer #1079", 20,20);

	}
}
