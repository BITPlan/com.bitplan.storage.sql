/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 *
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 *
 */
package com.bitplan.storage.sql;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bitplan.resthelper.BOManagerFactoryImpl;

/**
 * JPA EntityManager Factory 
 * @author wf
 *
 */
public class JPAEntityManagerFactory extends BOManagerFactoryImpl {
	private static final String PERSISTENCE_UNIT_NAME = "default";
	private EntityManagerFactory factory;
	private EntityManager em;
	
	/**
	 * get mySQL Properties
	 * @param database
	 * @param host
	 * @param username
	 * @param password
	 * @param reCreateDatabase
	 * @return
	 */
	public static Map<String, String>  getMySQLProps(String database,String host, String username, String password, boolean reCreateDatabase) {
		/**
		 * properties
		 */
		Map<String, String> props = new HashMap<String, String>();
		props.put("eclipselink.target-database", "MYSQL");
		props.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
		props.put("javax.persistence.jdbc.url",
				"jdbc:mysql://"+host+":3306/"+database);
		props.put("javax.persistence.jdbc.user", username);
		props.put("javax.persistence.jdbc.password", password);
		//props.put("eclipselink.ddl-generation","create-tables");
		if (reCreateDatabase)
			props.put("eclipselink.ddl-generation", "drop-and-create-tables");
		// http://wiki.eclipse.org/EclipseLink/UserGuide/JPA/Advanced_JPA_Development/Schema_Generation/Appending_strings_to_CREATE_TABLE_statements
		props.put("eclipselink.ddl.default-table-suffix", "engine=InnoDB");
		// props.put("eclipselink.ddl-generation.output-mode", "database");
		props.put("eclipselink.ddl-generation.output-mode", "both");

		return props;
	}

	@Override
	public void setContext(Object pContext) {
		@SuppressWarnings("rawtypes")
		Map props=(Map) pContext;
		String puName=PERSISTENCE_UNIT_NAME;
		if (props.containsKey("persistence.unit.name")) {
			puName=(String) props.get("persistence.unit.name");
		}
		factory = Persistence.createEntityManagerFactory(puName,
				props);
		em = factory.createEntityManager();
	}

	@Override
	public Object getContext() {
		return em;
	}

}
