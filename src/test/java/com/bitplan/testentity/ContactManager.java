/**
 * Copyright (C) 2011-2014 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2014-12-18 13:57 with smartGENERATOR
 */
package com.bitplan.testentity;
// List interface
import java.util.List;

// restinterface imports
import com.bitplan.restinterface.BOManager;
	// >>>{ManagerImportSection}{Contact}{Contact}
	// no implementation yet !!!
	// <<<{ManagerImportSection}{Contact}{Contact}
/**
 * Manager for Restful access to Contact
 */
public interface ContactManager extends BOManager<Contact> {
	// >>>{ManagerImplSection}{Contact}{Contact}
	// no implementation yet !!!
	// <<<{ManagerImplSection}{Contact}{Contact}

	/**
	 * set the contacts
	 * @param pContacts
	 */
	public void setContacts(List<Contact> pContacts);
	
	/**
	 * @return the contacts
	 */
	public List<Contact> getContacts();
	
} // ContactManager
