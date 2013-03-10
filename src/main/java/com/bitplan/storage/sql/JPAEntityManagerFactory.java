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
import com.bitplan.restinterface.BOManager;

/**
 * JPA EntityManager Factory 
 * @author wf
 *
 */
public class JPAEntityManagerFactory extends BOManagerFactoryImpl {
	private static final String PERSISTENCE_UNIT_NAME = "default";
	private Map<String,EntityManagerFactory> factoryMap=new HashMap<String,EntityManagerFactory>();
	private Map<String,EntityManager> emMap=new HashMap<String,EntityManager>();
	private String puName;
	
	/**
	 * get mySQL Properties
	 * @param persistenceUnitName
	 * @param database
	 * @param host
	 * @param username
	 * @param password
	 * @param reCreateDatabase
	 * @return
	 */
	public static Map<String, String>  getMySQLProps(String persistenceUnitName,String database,String host, String username, String password, boolean reCreateDatabase) {
		/**
		 * properties
		 */
		Map<String, String> props = new HashMap<String, String>();
		props.put("persistence.unit.name", persistenceUnitName);
		props.put("eclipselink.target-database", "MYSQL");
		props.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
		props.put("javax.persistence.jdbc.url",
				"jdbc:mysql://"+host+":3306/"+database);
		props.put("javax.persistence.jdbc.user", username);
		props.put("javax.persistence.jdbc.password", password);
		//props.put("eclipselink.ddl-generation","create-tables");
		// http://wiki.eclipse.org/EclipseLink/Examples/JPA/Caching
		props.put("shared-cache-mode","NONE");
		// http://wiki.eclipse.org/EclipseLink/UserGuide/JPA/Advanced_JPA_Development/Schema_Generation/Appending_strings_to_CREATE_TABLE_statements
		props.put("eclipselink.ddl.default-table-suffix", "engine=InnoDB");
		if (reCreateDatabase)
			props.put("eclipselink.ddl-generation", "drop-and-create-tables");
		// http://wiki.eclipse.org/EclipseLink/DesignDocs/368365
		//props.put("eclipselink.ddl-generation", "create-or-extend-tables");
		//props.put("eclipselink.ddl-generation.output-mode", "database");
		// props.put("eclipselink.ddl-generation.output-mode", "database");
		props.put("eclipselink.ddl-generation.output-mode", "both");

		return props;
	}

	@Override
	public void setContext(Object pContext) {
		@SuppressWarnings("rawtypes")
		Map props=(Map) pContext;
		puName=PERSISTENCE_UNIT_NAME;
		if (props.containsKey("persistence.unit.name")) {
			puName=(String) props.get("persistence.unit.name");
		}
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(puName,
				props);
		factoryMap.put(puName,factory);
		emMap.put(puName,factory.createEntityManager());
	}

	@Override
	public Object getContext() {
		return emMap.get(puName);
	}

	@Override
	public <T >void init(BOManager<T> manager) {
    JPAEntityManager<T> jpamanager=(JPAEntityManager<T>) manager;
    jpamanager.setEntityManager(emMap.get(puName));
    jpamanager.setPuName(puName);
	}


}
