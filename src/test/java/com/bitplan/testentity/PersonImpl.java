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
import com.bitplan.testentity.Person;
import java.util.List;
import com.bitplan.testentity.Contact;
import java.util.ArrayList;
	// >>>{implSection}{Person}{Person}
	// no implementation yet !!!
	// <<<{implSection}{Person}{Person}
import com.google.inject.Inject;

/**
 * Pojo Implementation for Person
 */
public class PersonImpl implements Person {

	// >>>{code}{Person}{Person}
	// no implementation yet !!!
	// <<<{code}{Person}{Person}
  
  /**
   * default constructor for a PersonImpl 
   */
  public PersonImpl() {
	// >>>{defaultConstructor}{Person}{Person}
	// no implementation yet !!!
	// <<<{defaultConstructor}{Person}{Person}
  }
    
  /**
   * id
   */
  private String id;
  
  /**
   * name
   */
  private String name;
  
  /**
   * SSN
   */
  private String sSN;
  
  /**
   * EMailStatus
   */
  private String eMailStatus;
  
  /**
   * xStatus
   */
  private String xStatus;
  
  /**
   * contacts
   */
  private List<Contact> contacts=new ArrayList<Contact>();
  
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
   * getter for name
   * @return the value for name
   */
  public String getName() { return name; };

  /**
   * setter for name
   * @param pname - new value for name
   */
  public void setName(String pname) { name=pname; };
 
  /**
   * getter for SSN
   * @return the value for sSN
   */
  public String getSSN() { return sSN; };

  /**
   * setter for SSN
   * @param psSN - new value for SSN
   */
  public void setSSN(String psSN) { sSN=psSN; };
 
  /**
   * getter for EMailStatus
   * @return the value for eMailStatus
   */
  public String getEMailStatus() { return eMailStatus; };

  /**
   * setter for EMailStatus
   * @param peMailStatus - new value for EMailStatus
   */
  public void setEMailStatus(String peMailStatus) { eMailStatus=peMailStatus; };
 
  /**
   * getter for xStatus
   * @return the value for xStatus
   */
  public String getXStatus() { return xStatus; };

  /**
   * setter for xStatus
   * @param pxStatus - new value for xStatus
   */
  public void setXStatus(String pxStatus) { xStatus=pxStatus; };
 
  /**
   * getter for contacts
   * @return the value for contacts
   */
  public List<Contact> getContacts() { return contacts; };

  /**
   * setter for contacts
   * @param pcontacts - new value for contacts
   */
  public void setContacts(List<Contact> pcontacts) { contacts=pcontacts; };
 

  /**
   * copy me from the given Person
   * @param Person - the source Object to copy from
   */
  public void copyFrom(Person pPerson) {
    if (pPerson!=null) {
      setId(pPerson.getId());
      setName(pPerson.getName());
      setSSN(pPerson.getSSN());
      setEMailStatus(pPerson.getEMailStatus());
      setXStatus(pPerson.getXStatus());
    }
	} // copyFrom
	
} // PersonImpl
