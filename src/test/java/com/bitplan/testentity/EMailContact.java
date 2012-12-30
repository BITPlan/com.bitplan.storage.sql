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
   * @return mail
   */
  public String getMail();

  /**
   * setter for xsd:string/String mail
   * @param pmail - new value for mail
   */
  public void setMail(String pmail);

 /**
   * copy me from the given EMailContact
   * @param EMailContact - the source Object to copy from
   */
  public void copyFrom(EMailContact pEMailContact);
} // EMailContact
