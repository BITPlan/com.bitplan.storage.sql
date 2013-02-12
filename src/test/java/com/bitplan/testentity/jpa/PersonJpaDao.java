/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2013-02-11 18:40 with smartGENERATOR
 */
package com.bitplan.testentity.jpa;
import java.io.Serializable;
// JPA / Hibernate imports
import javax.persistence.*;
//import static javax.persistence.CascadeType.*;
import com.bitplan.storage.sql.JPABOImpl;
// Guice
import com.google.inject.Inject;

import com.bitplan.testentity.Person;
import com.bitplan.testentity.PersonImpl;
// utility imports
import java.util.Map;
import java.util.HashMap;

// restinterface
import com.bitplan.restinterface.BO;
import java.util.List;
import com.bitplan.testentity.Contact;
	// >>>{implSection}{Person}{Person}
	// no implementation yet !!!
	// <<<{implSection}{Person}{Person}

/**
 * JPA Data access object for Person
 * Entity: Person for container testentity
 * Table: Person
 */
@Entity(name="Person")
@Table(name="Person")
public class PersonJpaDao extends JPABOImpl<Person> implements Person,Serializable {
	// >>>{code}{PersonJpaDao}{Person}
	// no implementation yet !!!
	// <<<{code}{PersonJpaDao}{Person}
  /**   
   * make Serializable happy ...   
   */  
  private static final long serialVersionUID = 1L;  
  
  /**
   * access to my Implementation
   */
  public Person getPersonImpl() {
     return (Person)getImpl();
  }
  /**
   * default constructor for Person
   */
  public PersonJpaDao() {
    mBOImpl=new PersonImpl();
    
  }
  
  /**
   * construct a Person from a given Data Access Object
   * @param pPerson the Data Access Object to initialize this class from
   */
  public PersonJpaDao(Person pPerson) {
    super();
    mBOImpl=pPerson;
	// >>>{constructor}{PersonJpaDao}{Person}
	// no implementation yet !!!
	// <<<{constructor}{PersonJpaDao}{Person}
  }
  /**
   * getter for xsd:string/String id
   * @return id
   */
  @Id
  @Column(name="id")
  public String getId() { 
  	return getPersonImpl().getId(); 
  }

  /**
   * setter for xsd:string/String id
   * @param pid - new value for id
   */
  public void setId(String pid) { 
  	getPersonImpl().setId(pid); 
  }
  
  /**
   * getter for xsd:string/String name
   * @return name
   */
  @Column(name="name")
  public String getName() { 
  	return getPersonImpl().getName(); 
  }

  /**
   * setter for xsd:string/String name
   * @param pname - new value for name
   */
  public void setName(String pname) { 
  	getPersonImpl().setName(pname); 
  }
  
  /**
   * getter for Contact/List<Contact> contacts
   * @return contacts
   */
  @OneToMany(targetEntity=ContactJpaDao.class, cascade=CascadeType.ALL, mappedBy="person")
  public List<Contact> getContacts() { 
  	return getPersonImpl().getContacts(); 
  }

  /**
   * setter for Contact/List<Contact> contacts
   * @param pcontacts - new value for contacts
   */
  public void setContacts(List<Contact> pcontacts) { 
  	getPersonImpl().setContacts(pcontacts); 
  }
  
 /**
   * copy me from the given Person
   * @param Person - the source Object to copy from
   */
  public void copyFrom(Person pPerson) {
    mBOImpl.copyFrom(pPerson);
  }
  /**
   * get the primary key of this business object
   */
	@Transient
  public Object getPrimaryKey() {
  	return getId();
  } // getPrimaryKey

  @Override
	public Object getField(String fieldName) {
		Object result=null;
    if (fieldName.equals("id")) result=getId();
    if (fieldName.equals("name")) result=getName();
    if (fieldName.equals("contacts")) result=getContacts();
		return result;
	} // getField

	@Override
	public Map<String, Object> toMap() {
	  Map<String, Object> result=new HashMap<String,Object>();
    result.put("id",getId());
    result.put("name",getName());
		return result;
	} // toMap

	@Override
	public void fromMap(Map<String, Object> pMap) {
    if (pMap.containsKey("id"))	setId(getTypeConverter().getString(pMap.get("id")));
    if (pMap.containsKey("name"))	setName(getTypeConverter().getString(pMap.get("name")));
	} // fromMap
} // PersonJpaDao
