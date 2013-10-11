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

import org.apache.commons.beanutils.PropertyUtils;
import org.eclipse.persistence.jpa.JpaQuery;
import org.junit.runners.MethodSorters;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;

import com.bitplan.rest.jqgrid.JqGridFilter;
import com.bitplan.rest.jqgrid.JqGridSearch;
import com.bitplan.rest.jqgrid.JqGridFilter.Operations;
import com.bitplan.rest.jqgrid.JqGridSearchImpl;
import com.bitplan.resthelper.FieldHelper;
import com.bitplan.restinterface.BOManager;
import com.bitplan.restinterface.BOManagerFactory;
import com.bitplan.testentity.Customer;
import com.bitplan.testentity.CustomerManager;
import com.bitplan.testentity.Order;
import com.bitplan.testentity.OrderManager;
import com.bitplan.testentity.Person;
import com.bitplan.testentity.PersonManager;
import com.bitplan.testentity.TypeTest;
import com.bitplan.testentity.TypeTestManager;

import com.bitplan.testentity.jpa.OrderManagerJPA;
import com.bitplan.testentity.jpa.PersonManagerJPA;
import com.bitplan.testentity.jpa.CustomerJpaDao;
import com.bitplan.testentity.jpa.CustomerManagerJPA;
import com.bitplan.testentity.jpa.TypeTestManagerJPA;

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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestEclipseLink {

	boolean debug = true;
	private EntityManager em;
	static BOManagerFactory boManagerFactory;

	@BeforeClass
	public static void prepareGuice() throws Exception {
		TestSqlStorage.prepareGuice();
		boManagerFactory = TestSqlStorage.boManagerFactory;
	}
	
	@AfterClass
	public static void closeEntityManager() throws Exception {
		// OrderManagerJPA om = getOrderManager();
	  TestSqlStorage.boManagerFactory=null;
	}

	/**
	 * get the OrderManager
	 * 
	 * @return
	 * @throws Exception
	 */
	public static OrderManagerJPA getOrderManager() throws Exception {
		BOManager<Order> boManager = boManagerFactory.getBOManager(
				OrderManager.class, Order.class);
		assertTrue(boManager instanceof OrderManagerJPA);
		OrderManagerJPA OrderManager = (OrderManagerJPA) boManager;
		return OrderManager;
	}

	/**
	 * get the CustomerManager
	 * 
	 * @return
	 * @throws Exception
	 */
	public CustomerManagerJPA getCustomerManager() throws Exception {
		BOManager<Customer> boManager = boManagerFactory.getBOManager(
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
	public Customer addCustomer(String id, String name, String city,
			String statusGroup) {
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
		String[] cities = { "New York", null, "Newark, NJ" };

		em = (EntityManager) boManagerFactory.getContext();
		Customer customer1 = null;
		em.getTransaction().begin();
		for (int i = 0; i < ids.length; i++) {
			Customer customer = addCustomer(ids[i], names[i], cities[i], "regular");
			if (i == 0)
				customer1 = customer;
		}

		// Read the existing entries and write to console
		Query q = em.createQuery("select c from Customer c order by c.id");
		@SuppressWarnings("unchecked")
		List<CustomerJpaDao> lCustomerList = q.getResultList();
		if (debug) {
			System.out.println("Size: " + lCustomerList.size());
		}
		assertEquals("There should be three customers in the list", 3,
				lCustomerList.size());
		int index=0;
		for (CustomerJpaDao lCustomer : lCustomerList) {
			if (debug) {
				System.out.println("id: " + lCustomer.getId() + " name: "
						+ lCustomer.getName());
			}
			assertEquals(ids[index],lCustomer.getId());
			assertEquals(names[index],lCustomer.getName());
			assertEquals(cities[index],lCustomer.getCity());
			index++;
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
		//em.close();
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
		//em.close();
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
	 * parameterized search
	 * 
	 * @param boManager
	 * @param sortOrder
	 * @param json
	 * @param expectedTotalRowCount
	 * @param expectedResultCount
	 * @param expectedFirst
	 * @param firstResult
	 * @param maxResult
	 * @throws Exception
	 */
	public <BO_T> void testJqGridSearch(String foreignAttribute,String foreignKey,String foreignValue,JPAEntityManager<BO_T> boManager,
			String displayField, String searchField, String sortField,
			String sortOrder, String json, long expectedTotalRowCount,
			int expectedResultCount, Object expectedFirst, int firstResult,
			int maxResult) throws Exception {
		JqGridSearch search = this.getSearch(sortField, sortOrder, json,
				firstResult, maxResult);
		if (debug) {
			JqGridFilter filter = search.getFilter();
			if (filter != null)
				System.out.println("filter:" + filter.asJson());
			else
				System.out.println("filter:null");
		}
		JPAEntityManager.ForeignKey lForeignKey=new JPAEntityManager.ForeignKey(foreignAttribute,foreignKey,foreignValue);
		List<BO_T> bos = boManager.findByJqGridFilter(search,lForeignKey);
		assertEquals("totalRowCount", expectedTotalRowCount,
				search.getTotalRowCount());
		assertEquals(expectedResultCount, search.getResultRowCount());
		assertEquals(expectedResultCount, bos.size());
		if (debug)
			System.out.println("size: " + bos.size());
		for (BO_T bo : bos) {
			if (debug)
				System.out.println(PropertyUtils.getSimpleProperty(bo, displayField));
		}
		if (expectedResultCount>0)
		assertEquals("expectedFirst: ", expectedFirst,
				PropertyUtils.getSimpleProperty(bos.get(0), displayField));
	}

	/**
	 * parameterized search
	 * 
	 * @param boManager
	 * @param searchField
	 * @param sortField
	 * @param sortOrder
	 * @param searchStr
	 * @param ops
	 * @param groupOps
	 * @param more
	 * @param expectedTotalRowCount
	 * @param expectedResultRowCount
	 * @param expectedFirst
	 * @param firstResult
	 * @param maxResult
	 * @throws Exception
	 */
	public <BO_T> void testJqGridSearch(String foreignAttribute,String foreignKey,String foreignValue,JPAEntityManager<BO_T> boManager,
			String displayField, String searchField, String sortField,
			String sortOrder, String searchStr, String ops, String groupOps,
			String more, long expectedTotalRowCount, int expectedResultRowCount,
			Object expectedFirst, int firstResult, int maxResult) throws Exception {
		String json = "{\n" + "  \"groupOp\" : \"" + groupOps + "\",\n"
				+ "  \"rules\" : [ {\n" + "    \"field\" : \"" + searchField + "\",\n"
				+ "    \"op\" : \"" + ops + "\",\n" + "    \"data\" : \"" + searchStr
				+ "\"\n" + "  }" + more + " ]\n" + "}";
		this.testJqGridSearch(foreignAttribute,foreignKey,foreignValue,boManager, displayField, searchField, sortField,
				sortOrder, json, expectedTotalRowCount, expectedResultRowCount,
				expectedFirst, firstResult, maxResult);
	}

	/**
	 * test jqGrid Search
	 * 
	 * @throws Exception
	 */
	@Test
	public void testJqGridSearch() throws Exception {
		CustomerManagerJPA customerManager = this.getCustomerManager();
		String ops[] = { "eq", "ne", "bw", "cn", "nc", "cn", "eq" };
		String groupOps[] = { "AND", "AND", "AND", "AND", "AND", "AND", "OR" };
		String sortOrder[] = { "desc", "desc", "desc", "desc", "desc", "desc",
				"asc" };
		String searchField[] = { "name", "name", "name", "name", "name", "name",
				"name", "city", "city" };
		String searchStr[] = { "John Doe", "John Doe", "John", "Doe", "John",
				"John", "Heather Bourne" };
		int expectedSize[] = { 1, 2, 2, 1, 1, 1, 2 };
		String expectedFirst[] = { "John Doe", "John Smith", "John Smith",
				"John Doe", "Heather Bourne", "John Doe", "Heather Bourne" };
		String more[] = { "", "", "", "", "",
				",{\"field\" : \"name\", \"op\" : \"cn\", \"data\" : \"Doe\" }",
				",{\"field\" : \"name\", \"op\" : \"cn\", \"data\" : \"Doe\" }", };
		long expectedTotalRowCount = 3;
		for (int oindex = 0; oindex < ops.length; oindex++) {
			this.testJqGridSearch(null,null,null,customerManager, "name", "name",
					searchField[oindex], sortOrder[oindex], searchStr[oindex],
					ops[oindex], groupOps[oindex], more[oindex], expectedSize[oindex],
					expectedSize[oindex], expectedFirst[oindex], 0, 10);
		}
		int expectedSize2[] = { 1, 2, 1, 2, 2, 2, 1, 1, 2, 1, 1, 1, 2, 1, 1, 2 };
		String searchField2[] = { "name", "name", "name", "name", "name", "name",
				"name", "name", "name", "name", "name", "name", "name", "name", "city",
				"city" };
		String searchStr2[] = { "John Doe", "John Doe", "John", "John Doe", "Joh",
				"John Doe", "Heat", "Jo", "John Doe,John Smith", "John Smith,John Doe",
				"Doe", "e", "ohn", "th", null, null };
		String expectedFirst2[] = { "John Doe", "Heather Bourne", "Heather Bourne",
				"Heather Bourne", "John Doe", "John Doe", "Heather Bourne",
				"Heather Bourne", "John Doe", "Heather Bourne", "John Doe",
				"John Smith", "John Doe", "John Doe", "John Smith", "John Doe" };

		int oindex = 0;
		for (Operations op : JqGridFilter.Operations.values()) {
			if (debug)
				System.out.println("" + (oindex) + ": name " + op.name() + " "
						+ searchStr2[oindex] + "=>" + expectedSize2[oindex] + ","
						+ expectedFirst2[oindex]);
			this.testJqGridSearch(null,null,null,customerManager, "name", searchField2[oindex],
					searchField2[oindex], "asc", searchStr2[oindex], op.name(), "AND",
					"", expectedSize2[oindex], expectedSize2[oindex],
					expectedFirst2[oindex], 0, 10);
			oindex++;
		}
		this.testJqGridSearch(null,null,null,customerManager, "name", "name", "name", "asc", null,
				expectedTotalRowCount, (int) expectedTotalRowCount, "Heather Bourne",
				0, 10);
	}

	/**
	 * test the Paging functionality
	 * 
	 * @throws Exception
	 */
	@Test
	public void testPaging() throws Exception {
		em = (EntityManager) boManagerFactory.getContext();
		em.getTransaction().begin();
		for (int i = 1000; i < 1100; i++) {
			this.addCustomer("" + i, "Customer #" + i, "London", "VIP");
		}
		em.getTransaction().commit();
		CustomerManagerJPA customerManager = this.getCustomerManager();
		this.testJqGridSearch(null,null,null,customerManager, "name", "name", "name", "desc",
				"Customer #10", "bw", "AND", "", 100, 20, "Customer #1079", 20, 20);
		//em.close();
	}

	/**
	 * add a test record for the Person entity
	 * 
	 * @param i
	 * @return
	 */
	private Person addPerson(int i) {
		Person person = boManagerFactory.getInstance(Person.class);
		person.setId("id" + i);
		person.setName("person" + i);
		person.setSSN("SSN" + i);
		person.setEMailStatus("EMailStatus" + i);
		person.setXStatus("xStatus" + i);
		em.persist(person);
		return person;
	}

	/**
	 * add a TypeTest Record
	 * 
	 * @param i
	 * @return
	 */
	private TypeTest addTypeTest(int i) {
		TypeTest typeTest = boManagerFactory.getInstance(TypeTest.class);
		typeTest.setId(i);
		typeTest.setTbooleanVal(i % 2 == 0); // odd or even?
		em.persist(typeTest);
		return typeTest;
	}

	/**
	 * test the fieldName access
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFieldNames() throws Exception {
		em = (EntityManager) boManagerFactory.getContext();
		em.getTransaction().begin();
		for (int i = 0; i <= 15; i++) {
			this.addPerson(i);
		}
		em.getTransaction().commit();
		BOManager<Person> boManager = boManagerFactory.getBOManager(
				PersonManager.class, Person.class);
		assertTrue(boManager instanceof PersonManagerJPA);
		PersonManagerJPA personManager = (PersonManagerJPA) boManager;
		this.testJqGridSearch(null,null,null,personManager, "name", "SSN", "SSN", "desc", "SSN1",
				"bw", "AND", "", 7, 7, "person15", 0, 20);
		this.testJqGridSearch(null,null,null,personManager, "SSN", "EMailStatus", "EMailStatus",
				"asc", "EMailStatus1", "bn", "AND", "", 9, 9, "SSN0", 0, 20);
		this.testJqGridSearch(null,null,null,personManager, "XStatus", "XStatus", "XStatus",
				"asc", "xStatus1", "bn", "AND", "", 9, 9, "xStatus0", 0, 20);
		// em.close();
	}

	@Test
	public void testTypes() throws Exception {
		em = (EntityManager) boManagerFactory.getContext();
		em.getTransaction().begin();
		// do not use "0" as index so start at 2
		// to avoid Null or zero primary key encountered in unit of work clone [com.bitplan.testentity.jpa.TypeTestJpaDao@666a5ddb], primary key [0]. Set descriptors IdValidation or the "eclipselink.id-validation" property.
		for (int i = 2; i < 17; i++) {
			this.addTypeTest(i);
		}
		em.getTransaction().commit();
		BOManager<TypeTest> boManager = boManagerFactory.getBOManager(
				TypeTestManager.class, TypeTest.class);
		assertTrue(boManager instanceof TypeTestManagerJPA);
		TypeTestManagerJPA typeTestManager = (TypeTestManagerJPA) boManager;
		// odd search
		this.testJqGridSearch(null,null,null,typeTestManager, "id", "TbooleanVal", "id", "desc",
				"0", "eq", "AND", "", 7, 7, 15l, 0, 20);
		// even search
		this.testJqGridSearch(null,null,null,typeTestManager, "id", "TbooleanVal", "id", "desc",
				"1", "eq", "AND", "", 8, 8, 16l, 0, 20);
		// em.close();
	}

	@Test
	public void testDecapitalize() throws Exception {
		// http://docs.oracle.com/javase/6/docs/api/java/beans/Introspector.html#decapitalize%28java.lang.String%29
		String names[] = { "SSN", "EMailStatus", "XStatus" };
		for (String name : names) {
			String result1=FieldHelper.firstToUpper(name);
			String result2=java.beans.Introspector.decapitalize(name);
			System.out.println(result1 + ":"
					+ result2);
			assertEquals(result1,result2);
		}
	}

	/**
	 * test join
	 * 
	 * @throws Exception
	 */
	@Test
	public void testJoin() throws Exception {
		// see
		// http://stackoverflow.com/questions/9025196/how-to-use-jpa-criteria-api-when-joining-many-tables
		// http://en.wikibooks.org/wiki/Java_Persistence/JPQL#JOIN
		em = (EntityManager) boManagerFactory.getContext();
		// em.createQuery("select * from Customer c");
		//CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		//CriteriaQuery<Object> select = criteriaBuilder.createQuery();
		//Root<OrderJpaDao> fromOrder = select.from(OrderJpaDao.class);
		//Path<Object> path = fromOrder.join("customer").get("id");
		// select.where(criteriaBuilder.equal(path, "1"));
		// Join<CustomerJpaDao,OrderJpaDao> orders=customerRoot.join("orders");
		// TypedQuery<Object>
		Query query = em.createQuery("select o from Order o join o.customer c");
		@SuppressWarnings("unchecked")
		List<Object> results = query.getResultList();
		assertEquals(2,results.size());
		for (Object obj : results) {
			assertTrue(obj instanceof Order);
			Order order = (Order) obj;
			System.out
					.println(order.getCustomer().getId() + ":" + order.getAddress());
			assertEquals("1",order.getCustomer().getId());
		}
		if (debug) {
			String sql = query.unwrap(JpaQuery.class).getDatabaseQuery()
					.getSQLString();
			System.out.println(sql);
		}
	}
	
	/**
	 * test JqGridSearch with foreignKey constraint
	 * 
	 * @throws Exception
	 */
	@Test
	public void testJqGridSearchWithForeignKey() throws Exception {
		int[] expectedTotalRowCount = { 2, 0 };
		String customerId[] = { "1", "2" };
		OrderManagerJPA orderManager = TestEclipseLink.getOrderManager();
		for (int i = 0; i < expectedTotalRowCount.length; i++) {
			this.testJqGridSearch("customer","id",customerId[i],orderManager,"id", "id", "id", "asc", null,
					expectedTotalRowCount[i], expectedTotalRowCount[i], "100",
					0, 10);
		}

	}

}
