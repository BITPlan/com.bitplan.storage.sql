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
import com.bitplan.testentity.Contact;
import com.bitplan.testentity.Person;
	// >>>{implSection}{Contact}{Contact}
	// no implementation yet !!!
	// <<<{implSection}{Contact}{Contact}
import com.google.inject.Inject;

/**
 * Pojo Implementation for Contact
 */
public class ContactImpl implements Contact {

	// >>>{code}{Contact}{Contact}
	// no implementation yet !!!
	// <<<{code}{Contact}{Contact}
  
  /**
   * default constructor for a ContactImpl 
   */
  public ContactImpl() {
	// >>>{defaultConstructor}{Contact}{Contact}
	// no implementation yet !!!
	// <<<{defaultConstructor}{Contact}{Contact}
  }
    
  /**
   * id
   */
  private String id;
  
  /**
   * when
   */
  private java.util.Date when;
  
  /**
   * why
   */
  private String why;
  
  /**
   * person
   */
  private Person person;
  
  /**
   * getter for id
   * @return the value for id
   */
  public String getId() { return id; };

  /**
   * setter for id
   * @param pid - new value for id
   */
  public void setId(String pid) { id=pid; };
 
  /**
   * getter for when
   * @return the value for when
   */
  public java.util.Date getWhen() { return when; };

  /**
   * setter for when
   * @param pwhen - new value for when
   */
  public void setWhen(java.util.Date pwhen) { when=pwhen; };
 
  /**
   * getter for why
   * @return the value for why
   */
  public String getWhy() { return why; };

  /**
   * setter for why
   * @param pwhy - new value for why
   */
  public void setWhy(String pwhy) { why=pwhy; };
 
  /**
   * getter for person
   * @return the value for person
   */
  public Person getPerson() { return person; };

  /**
   * setter for person
   * @param pperson - new value for person
   */
  public void setPerson(Person pperson) { person=pperson; };
 

  /**
   * copy me from the given Contact
   * @param Contact - the source Object to copy from
   */
  public void copyFrom(Contact pContact) {
		setId(pContact.getId());
		setWhen(pContact.getWhen());
		setWhy(pContact.getWhy());
	} // copyFrom
	
} // ContactImpl
