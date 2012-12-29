/*
 * Copyright (C) 2012 BITPlan GmbH
 *
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 */
package com.bitplan.storage.sql;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import com.bitplan.resthelper.BOManagerFactoryImpl;
import com.bitplan.restinterface.BOManagerFactory;
import com.bitplan.storage.TestStorage;
import com.bitplan.testentity.TestentityJPAModule;
import java.util.Map;


/**
 * Test SQL storage with 
 * 
 * @author wf grant all on testsqlstorage.* to 'cm'@'localhost' identified by
 *         'secret'; see testsqlstorage.sql
 */
public class TestSqlStorage extends TestStorage {
	
  static BOManagerFactory boManagerFactory;
	
	@Override
	public com.bitplan.restinterface.BOManagerFactory getBOManagerFactory() {
		return boManagerFactory;
	}

	@BeforeClass
	public static void prepareGuice() throws Exception {
		if (boManagerFactory==null) {
		  boManagerFactory=BOManagerFactoryImpl.create(new TestentityJPAModule());
		  Map<String, String> props = JPAEntityManagerFactory.getMySQLProps("testsqlstorage","localhost","cm", "secret",true);
		  boManagerFactory.setContext(props);
			Logger.getRootLogger().setLevel(Level.ERROR);

		}
	}

}
