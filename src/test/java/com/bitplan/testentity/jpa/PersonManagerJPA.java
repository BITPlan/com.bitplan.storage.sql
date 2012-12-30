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
	public Person create() {
		PersonJpaDao result = new PersonJpaDao(new PersonImpl());
		result.setBOManager(this);
		return result;
	}
	
		
	@Override
	public Class<? extends BO<?>> getEntityType() {
		return PersonJpaDao.class;
	}
	


} // PersonManagerJPA
