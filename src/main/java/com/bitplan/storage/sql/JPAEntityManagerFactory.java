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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bitplan.resthelper.BOManagerFactoryImpl;
import com.bitplan.restinterface.BOManager;

/**
 * JPA EntityManager Factory
 * 
 * @author wf
 * 
 */
public class JPAEntityManagerFactory extends BOManagerFactoryImpl {
	private static final String PERSISTENCE_UNIT_NAME = "default";
	private Map<String, EntityManagerFactory> factoryMap = new HashMap<String, EntityManagerFactory>();
	private Map<String, EntityManager> emMap = new HashMap<String, EntityManager>();
	private String puName;

	/**
	 * get properties
	 * 
	 * @param persistenceUnitName
	 * @param database
	 * @param host
	 * @param username
	 * @param password
	 * @param reCreateDatabase
	 * @return
	 */
	public static Properties getProps(String persistenceUnitName,
			String database, String host, String username, String password,
			boolean reCreateDatabase) {
		/**
		 * properties
		 */
		Properties props = new Properties();
		props.put("persistence.unit.name", persistenceUnitName);
		props.put("javax.persistence.jdbc.user", username);
		props.put("javax.persistence.jdbc.password", password);
		// props.put("eclipselink.ddl-generation","create-tables");
		// http://wiki.eclipse.org/EclipseLink/Examples/JPA/Caching
		props.put("shared-cache-mode", "NONE");
		if (reCreateDatabase)
			props.put("eclipselink.ddl-generation", "drop-and-create-tables");
		// http://wiki.eclipse.org/EclipseLink/DesignDocs/368365
		// props.put("eclipselink.ddl-generation", "create-or-extend-tables");
		// props.put("eclipselink.ddl-generation.output-mode", "database");
		// props.put("eclipselink.ddl-generation.output-mode", "database");
		props.put("eclipselink.ddl-generation.output-mode", "both");

		return props;
	}

	/**
	 * get the property File for the given persistence unit
	 * @param puname
	 * @param createPath
	 * @return
	 * @throws IOException 
	 */
	public static File getPropertyFile(String puname, boolean createPath) throws IOException {
		File propertyFile = new File(System.getProperty("user.home") + "/" + ".jpa"
				+ "/" + puname + ".xml");
		if (createPath) {
			propertyFile.getParentFile().mkdirs();
			propertyFile.createNewFile();
		}
		return propertyFile;
	}

	/**
	 * write the properties for the given pu
	 * 
	 * @param puname
	 * @param props
	 * @throws Exception
	 */
	private static void writeProperties(String puname, Properties props)
			throws Exception {
		String comment = "Properties for persistence unit " + puname;
		File propertyFile = getPropertyFile(puname,true);
		FileOutputStream fs = new FileOutputStream(propertyFile);
		props.storeToXML(fs, comment);
		fs.close();
	}

	/**
	 * read the properties for the given puname
	 * @param puname
	 * @return
	 * @throws Exception
	 */
	public static Properties readProperties(String puname) throws Exception {
		File propertyFile = getPropertyFile(puname,true);
		Properties props=new Properties();
		props.loadFromXML(new FileInputStream(propertyFile));
		return props;
	}

	/**
	 * get mySQL Properties
	 * 
	 * @param persistenceUnitName
	 * @param database
	 * @param host
	 * @param username
	 * @param password
	 * @param reCreateDatabase
	 * @return
	 */
	public static Properties getMySQLProps(String persistenceUnitName,
			String database, String host, String username, String password,
			boolean reCreateDatabase) throws Exception {
		Properties props = getProps(persistenceUnitName, database, host, username,
				password, reCreateDatabase);
		props.put("eclipselink.target-database", "MYSQL");
		props.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
		props.put("javax.persistence.jdbc.url", "jdbc:mysql://" + host + ":3306/"
				+ database);
		// http://wiki.eclipse.org/EclipseLink/UserGuide/JPA/Advanced_JPA_Development/Schema_Generation/Appending_strings_to_CREATE_TABLE_statements
		props.put("eclipselink.ddl.default-table-suffix", "engine=InnoDB");
		// FIXME - only for bootstrapping
		writeProperties(persistenceUnitName, props);
		return props;
	}

	/**
	 * get properties for Oracle database
	 * 
	 * @param persistenceUnitName
	 * @param database
	 * @param host
	 * @param username
	 * @param password
	 * @param reCreateDatabase
	 * @return
	 * @throws Exception 
	 */
	public static Properties getOracleProps(String persistenceUnitName,
			String database, String host, String username, String password,
			boolean reCreateDatabase) throws Exception {
		Properties props = getProps(persistenceUnitName, database, host, username,
				password, reCreateDatabase);
		props.put("eclipselink.target-database", "Oracle");
		props.put("javax.persistence.jdbc.driver", "oracle.jdbc.OracleDriver");
		props.put("javax.persistence.jdbc.url", "jdbc:oracle:thin:@" + host
				+ ":1521:" + database);
		// FIXME - only for bootstrapping
		writeProperties(persistenceUnitName, props);
		return props;
	}

	@Override
	public void setContext(Object pContext) {
		@SuppressWarnings("rawtypes")
		Map props = (Map) pContext;
		puName = PERSISTENCE_UNIT_NAME;
		if (props.containsKey("persistence.unit.name")) {
			puName = (String) props.get("persistence.unit.name");
		}
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(
				puName, props);
		factoryMap.put(puName, factory);
		emMap.put(puName, factory.createEntityManager());
	}

	@Override
	public Object getContext() {
		// return the least recently set context
		return emMap.get(puName);
	}

	@Override
	public <T> void init(BOManager<T> manager) {
		JPAEntityManager<T> jpamanager = (JPAEntityManager<T>) manager;
		jpamanager.setEntityManager(emMap.get(puName));
		jpamanager.setPuName(puName);
	}

}
