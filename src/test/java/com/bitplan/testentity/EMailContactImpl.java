/**
 * Copyright (C) 2011-2013 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2013-04-26 16:28 with smartGENERATOR
 */
package com.bitplan.testentity;
import com.bitplan.testentity.EMailContact;
	// >>>{implSection}{EMailContact}{EMailContact}
	// no implementation yet !!!
	// <<<{implSection}{EMailContact}{EMailContact}
import com.google.inject.Inject;

/**
 * Pojo Implementation for EMailContact
 */
public class EMailContactImpl extends ContactImpl implements EMailContact {

	// >>>{code}{EMailContact}{EMailContact}
	// no implementation yet !!!
	// <<<{code}{EMailContact}{EMailContact}
  
  /**
   * default constructor for a EMailContactImpl 
   */
  public EMailContactImpl() {
	// >>>{defaultConstructor}{EMailContact}{EMailContact}
	// no implementation yet !!!
	// <<<{defaultConstructor}{EMailContact}{EMailContact}
  }
    
  /**
   * mail
   */
  private String mail;
  
  /**
   * getter for mail
   * @return the value for mail
   */
  public String getMail() { return mail; };

  /**
   * setter for mail
   * @param pmail - new value for mail
   */
  public void setMail(String pmail) { mail=pmail; };
 

  /**
   * copy me from the given EMailContact
   * @param EMailContact - the source Object to copy from
   */
  public void copyFrom(EMailContact pEMailContact) {
		setMail(pEMailContact.getMail());
	} // copyFrom
	
} // EMailContactImpl
