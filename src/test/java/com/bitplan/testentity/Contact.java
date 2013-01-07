/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2013-01-07 09:08 with smartGENERATOR
 */
package com.bitplan.testentity;
import com.bitplan.testentity.Contact;
import com.bitplan.testentity.Person;
	// >>>{implSection}{Contact}{Contact}
	// no implementation yet !!!
	// <<<{implSection}{Contact}{Contact}

/**
 * interface for Contact
 */
public interface Contact {
	// >>>{interface}{Contact}{Contact}
	// no implementation yet !!!
	// <<<{interface}{Contact}{Contact}
  /**
   * getter for xsd:string/String id
   * @return id
   */
  public String getId();

  /**
   * setter for xsd:string/String id
   * @param pid - new value for id
   */
  public void setId(String pid);

  /**
   * getter for xsd:dateTime/java.util.Date timeOfContact
   * @return timeOfContact
   */
  public java.util.Date getTimeOfContact();

  /**
   * setter for xsd:dateTime/java.util.Date timeOfContact
   * @param ptimeOfContact - new value for timeOfContact
   */
  public void setTimeOfContact(java.util.Date ptimeOfContact);

  /**
   * getter for xsd:string/String why
   * @return why
   */
  public String getWhy();

  /**
   * setter for xsd:string/String why
   * @param pwhy - new value for why
   */
  public void setWhy(String pwhy);

  /**
   * getter for Person/Person person
   * @return person
   */
  public Person getPerson();

  /**
   * setter for Person/Person person
   * @param pperson - new value for person
   */
  public void setPerson(Person pperson);

 /**
   * copy me from the given Contact
   * @param Contact - the source Object to copy from
   */
  public void copyFrom(Contact pContact);
} // Contact
