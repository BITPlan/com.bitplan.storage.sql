/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2012-12-31 10:14 with smartGENERATOR
 */
package com.bitplan.testentity.jpa;
import java.io.Serializable;
// JPA / Hibernate imports
import javax.persistence.*;
//import static javax.persistence.CascadeType.*;
import com.bitplan.storage.sql.JPABOImpl;
// Guice
import com.google.inject.Inject;

import com.bitplan.testentity.Contact;
import com.bitplan.testentity.ContactImpl;
// utility imports
import java.util.Map;
import java.util.HashMap;

// restinterface
import com.bitplan.restinterface.BO;
import com.bitplan.testentity.Person;
	// >>>{implSection}{Contact}{Contact}
	// no implementation yet !!!
	// <<<{implSection}{Contact}{Contact}

/**
 * JPA Data access object for Contact
 * Entity: Contact for container testentity
 * Table: Contact
 */
@Entity(name="Contact")
@Table(name="Contact")
public class ContactJpaDao extends JPABOImpl<Contact> implements Contact,Serializable {

  /**   
   * make Serializable happy ...   
   */  
  private static final long serialVersionUID = 1L;  
  
  /**
   * access to my Implementation
   */
  public Contact getContactImpl() {
     return (Contact)getImpl();
  }
  /**
   * default constructor for Contact
   */
  public ContactJpaDao() {
    mBOImpl=new ContactImpl();
    
  }
  
  /**
   * construct a Contact from a given Data Access Object
   * @param pContact the Data Access Object to initialize this class from
   */
  public ContactJpaDao(Contact pContact) {
    super();
    mBOImpl=pContact;
	// >>>{constructor}{ContactJpaDao}{Contact}
	// no implementation yet !!!
	// <<<{constructor}{ContactJpaDao}{Contact}
  }
  /**
   * getter for xsd:string/String id
   * @return id
   */
  @Id
  @Column(name="id")
  public String getId() { 
  	return getContactImpl().getId(); 
  }

  /**
   * setter for xsd:string/String id
   * @param pid - new value for id
   */
  public void setId(String pid) { 
  	getContactImpl().setId(pid); 
  }
  
  /**
   * getter for xsd:dateTime/java.util.Date when
   * @return when
   */
  @Column(name="when")
  @Temporal(TemporalType.TIMESTAMP)
  public java.util.Date getWhen() { 
  	return getContactImpl().getWhen(); 
  }

  /**
   * setter for xsd:dateTime/java.util.Date when
   * @param pwhen - new value for when
   */
  public void setWhen(java.util.Date pwhen) { 
  	getContactImpl().setWhen(pwhen); 
  }
  
  /**
   * getter for xsd:string/String why
   * @return why
   */
  @Column(name="why")
  public String getWhy() { 
  	return getContactImpl().getWhy(); 
  }

  /**
   * setter for xsd:string/String why
   * @param pwhy - new value for why
   */
  public void setWhy(String pwhy) { 
  	getContactImpl().setWhy(pwhy); 
  }
  
  /**
   * getter for Person/Person person
   * @return person
   */
  @ManyToOne(targetEntity=PersonJpaDao.class)
  public Person getPerson() { 
  	return getContactImpl().getPerson(); 
  }

  /**
   * setter for Person/Person person
   * @param pperson - new value for person
   */
  public void setPerson(Person pperson) { 
  	getContactImpl().setPerson(pperson); 
  }
  
 /**
   * copy me from the given Contact
   * @param Contact - the source Object to copy from
   */
  public void copyFrom(Contact pContact) {
    mBOImpl.copyFrom(pContact);
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
    if (fieldName.equals("when")) result=getWhen();
    if (fieldName.equals("why")) result=getWhy();
    if (fieldName.equals("person")) result=getPerson();
		return result;
	} // getField

	@Override
	public Map<String, Object> toMap() {
	  Map<String, Object> result=new HashMap<String,Object>();
    result.put("id",getId());
    result.put("when",getWhen());
    result.put("why",getWhy());
		return result;
	} // toMap

	@Override
	public void fromMap(Map<String, Object> pMap) {
    setId((String)pMap.get("id"));
    setWhen((java.util.Date)pMap.get("when"));
    setWhy((String)pMap.get("why"));
	} // fromMap
} // ContactJpaDao
