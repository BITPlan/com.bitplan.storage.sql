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
	// >>>{ManagerImportSection}{PhoneContact}{PhoneContact}
	// no implementation yet !!!
	// <<<{ManagerImportSection}{PhoneContact}{PhoneContact}
/**
 * Manager for Restful access to PhoneContact
 */
public interface PhoneContactManager extends BOManager<PhoneContact> {
	// >>>{ManagerImplSection}{PhoneContact}{PhoneContact}
	// no implementation yet !!!
	// <<<{ManagerImplSection}{PhoneContact}{PhoneContact}

	/**
	 * set the phonecontacts
	 * @param pPhoneContacts
	 */
	public void setPhoneContacts(List<PhoneContact> pPhoneContacts);
	
	/**
	 * @return the phonecontacts
	 */
	public List<PhoneContact> getPhoneContacts();
	
} // PhoneContactManager
