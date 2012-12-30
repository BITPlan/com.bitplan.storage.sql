/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2012-12-29 13:01 with smartGENERATOR
 */
package com.bitplan.testentity;
// List interface
import java.util.List;

// restinterface imports
import com.bitplan.restinterface.BOManager;
	// >>>{ManagerImportSection}{Person}{Person}
	// no implementation yet !!!
	// <<<{ManagerImportSection}{Person}{Person}
/**
 * Manager for Restful access to Person
 */
public interface PersonManager extends BOManager<Person> {
	// >>>{ManagerImplSection}{Person}{Person}
	// no implementation yet !!!
	// <<<{ManagerImplSection}{Person}{Person}

	/**
	 * set the persons
	 * @param pPersons
	 */
	public void setPersons(List<Person> pPersons);
	
	/**
	 * @return the persons
	 */
	public List<Person> getPersons();
	
} // PersonManager
