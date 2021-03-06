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
import com.bitplan.testentity.Person;
import com.bitplan.testentity.PersonImpl;
import com.bitplan.testentity.PersonManager;
	// >>>{ManagerImports}{Personjpa}{Person}
	// no implementation yet !!!
	// <<<{ManagerImports}{Personjpa}{Person}
/**
 * JPA EntityManager implementation for interface Person
 * Entity: Person for container testentity
 */
public class PersonManagerJPA extends JPAEntityManager<Person>
	implements PersonManager {
	
	/**
	 * constructor
	 */
	public PersonManagerJPA() {
		this.setTableName("Person");
	}
	// >>>{Managercode}{PersonJpaDao}{Person}
	// no implementation yet !!!
	// <<<{Managercode}{PersonJpaDao}{Person}

  /**
	 * set the persons
	 * @param pPersons
	 */
	@Override
	public void setPersons(List<Person> pPersons) {
		super.bolist=pPersons;
	}
	
	/**
	 * @return the persons
	 */
	@Override
	public List<Person> getPersons() {
		return super.bolist;
	}
	
	@Override
	public Person createNew() throws Exception {
		PersonJpaDao result = new PersonJpaDao(new PersonImpl());
		result.setBOManager(this);
	// >>>{add}{PersonManagerJpaDao}{Person}
	// no implementation yet !!!
	// <<<{add}{PersonManagerJpaDao}{Person}
		return result;
	}
	
		
	@Override
	public Class<? extends BO<?>> getEntityType() {
		return PersonJpaDao.class;
	}
	


} // PersonManagerJPA
