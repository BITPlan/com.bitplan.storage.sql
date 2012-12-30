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
   * getter for xsd:dateTime/java.util.Date when
   * @return when
   */
  public java.util.Date getWhen();

  /**
   * setter for xsd:dateTime/java.util.Date when
   * @param pwhen - new value for when
   */
  public void setWhen(java.util.Date pwhen);

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
