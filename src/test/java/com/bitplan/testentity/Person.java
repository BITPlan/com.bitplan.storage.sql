/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2013-02-13 19:29 with smartGENERATOR
 */
package com.bitplan.testentity;
import com.bitplan.testentity.Person;
import java.util.List;
import com.bitplan.testentity.Contact;
	// >>>{implSection}{Person}{Person}
	// no implementation yet !!!
	// <<<{implSection}{Person}{Person}

/**
 * interface for Person
 */
public interface Person {
	// >>>{interface}{Person}{Person}
	// no implementation yet !!!
	// <<<{interface}{Person}{Person}
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
   * getter for xsd:string/String name
   * @return name
   */
  public String getName();

  /**
   * setter for xsd:string/String name
   * @param pname - new value for name
   */
  public void setName(String pname);

  /**
   * getter for xsd:string/String SSN
   * @return sSN
   */
  public String getSSN();

  /**
   * setter for xsd:string/String SSN
   * @param psSN - new value for SSN
   */
  public void setSSN(String psSN);

  /**
   * getter for xsd:string/String EMailStatus
   * @return eMailStatus
   */
  public String getEMailStatus();

  /**
   * setter for xsd:string/String EMailStatus
   * @param peMailStatus - new value for EMailStatus
   */
  public void setEMailStatus(String peMailStatus);

  /**
   * getter for xsd:string/String xStatus
   * @return xStatus
   */
  public String getXStatus();

  /**
   * setter for xsd:string/String xStatus
   * @param pxStatus - new value for xStatus
   */
  public void setXStatus(String pxStatus);

  /**
   * getter for Contact/List<Contact> contacts
   * @return contacts
   */
  public List<Contact> getContacts();

  /**
   * setter for Contact/List<Contact> contacts
   * @param pcontacts - new value for contacts
   */
  public void setContacts(List<Contact> pcontacts);

 /**
   * copy me from the given Person
   * @param Person - the source Object to copy from
   */
  public void copyFrom(Person pPerson);
} // Person
