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
	// >>>{ManagerImportSection}{EMailContact}{EMailContact}
	// no implementation yet !!!
	// <<<{ManagerImportSection}{EMailContact}{EMailContact}
/**
 * Manager for Restful access to EMailContact
 */
public interface EMailContactManager extends BOManager<EMailContact> {
	// >>>{ManagerImplSection}{EMailContact}{EMailContact}
	// no implementation yet !!!
	// <<<{ManagerImplSection}{EMailContact}{EMailContact}

	/**
	 * set the eMailContacts
	 * @param pEMailContacts
	 */
	public void setEMailContacts(List<EMailContact> pEMailContacts);
	
	/**
	 * @return the eMailContacts
	 */
	public List<EMailContact> getEMailContacts();
	
} // EMailContactManager
