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

/**
 * interface for EMailContact
 */
public interface EMailContact extends Contact {
	// >>>{interface}{EMailContact}{EMailContact}
	// no implementation yet !!!
	// <<<{interface}{EMailContact}{EMailContact}
  /**
   * getter for xsd:string/String mail
   * null
   * @return mail
   */
  public String getMail();

  /**
   * setter for xsd:string/String mail
   * null
   * @param pmail - new value for mail
   */
  public void setMail(String pmail);

 /**
   * copy me from the given EMailContact
   * @param EMailContact - the source Object to copy from
   */
  public void copyFrom(EMailContact pEMailContact);
} // EMailContact
