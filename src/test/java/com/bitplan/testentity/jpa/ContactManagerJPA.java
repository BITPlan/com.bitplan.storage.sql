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
package com.bitplan.testentity.jpa;
// base Entity Manager
import com.bitplan.storage.sql.JPAEntityManager;
// List
import java.util.List;
import java.util.ArrayList;

// BO interface
import com.bitplan.restinterface.BO;


// Entity interfaces
import com.bitplan.testentity.Contact;
import com.bitplan.testentity.ContactImpl;
import com.bitplan.testentity.ContactManager;
	// >>>{ManagerImports}{Contactjpa}{Contact}
	// no implementation yet !!!
	// <<<{ManagerImports}{Contactjpa}{Contact}
/**
 * JPA EntityManager implementation for interface Contact
 * Entity: Contact for container testentity
 */
public class ContactManagerJPA extends JPAEntityManager<Contact>
	implements ContactManager {
	
	/**
	 * constructor
	 */
	public ContactManagerJPA() {
		this.setTableName("Contact");
	}
	// >>>{Managercode}{ContactJpaDao}{Contact}
	// no implementation yet !!!
	// <<<{Managercode}{ContactJpaDao}{Contact}

  /**
	 * set the contacts
	 * @param pContacts
	 */
	@Override
	public void setContacts(List<Contact> pContacts) {
		super.bolist=pContacts;
	}
	
	/**
	 * @return the contacts
	 */
	@Override
	public List<Contact> getContacts() {
		return super.bolist;
	}
	
	@Override
	public Contact createNew() throws Exception {
		ContactJpaDao result = new ContactJpaDao(new ContactImpl());
		result.setBOManager(this);
	// >>>{add}{ContactManagerJpaDao}{Contact}
	// no implementation yet !!!
	// <<<{add}{ContactManagerJpaDao}{Contact}
		return result;
	}
	
		
	@Override
	public Class<? extends BO<?>> getEntityType() {
		return ContactJpaDao.class;
	}
	


} // ContactManagerJPA
