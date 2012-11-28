/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2012-11-28 17:58 with smartGENERATOR
 */
package com.bitplan.testentity;
// List interface
import java.util.List;

// restinterface imports
import com.bitplan.restinterface.BOManager;
	// >>>{ManagerImportSection}{TypeTest}{TypeTest}
	// no implementation yet !!!
	// <<<{ManagerImportSection}{TypeTest}{TypeTest}
/**
 * Manager for Restful access to TypeTest
 */
public interface TypeTestManager extends BOManager<TypeTest> {
	// >>>{ManagerImplSection}{TypeTest}{TypeTest}
	// no implementation yet !!!
	// <<<{ManagerImplSection}{TypeTest}{TypeTest}

	/**
	 * set the typeTests
	 * @param pTypeTests
	 */
	public void setTypeTests(List<TypeTest> pTypeTests);
	
	/**
	 * @return the typeTests
	 */
	public List<TypeTest> getTypeTests();
	
} // TypeTestManager
