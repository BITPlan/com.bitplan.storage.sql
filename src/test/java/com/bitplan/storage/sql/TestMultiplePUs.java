/**
 * Copyright (C) 2013 BITPlan GmbH
 *
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 */
package com.bitplan.storage.sql;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

/**
 * test using Multiple Persistence Units
 */
public class TestMultiplePUs {

	public Map<String, String> getProps() {
		Map<String, String> props = JPAEntityManagerFactory.getMySQLProps("com.bitplan.testentity","mod_auth","localhost","cm", "secret",true);
		return props;
	}
	
	@Test
	public void testMultiplePus() {
		//  grant select on mod_auth.* to 'cm'@'localhost' identified by 'secret';
		String puName="com.bitplan.secondpu";
		Map<String, String> props = getProps();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(puName,
				props);
		EntityManager em = factory.createEntityManager();
		Query query = em.createNativeQuery("select count(user_name) from user;");
		Long count = (Long) query.getSingleResult();
		System.out.println(count);
	}

}