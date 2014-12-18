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
import com.bitplan.testentity.PhoneContact;
	// >>>{implSection}{PhoneContact}{PhoneContact}
	// no implementation yet !!!
	// <<<{implSection}{PhoneContact}{PhoneContact}

/**
 * interface for PhoneContact
 */
public interface PhoneContact extends Contact {
	// >>>{interface}{PhoneContact}{PhoneContact}
	// no implementation yet !!!
	// <<<{interface}{PhoneContact}{PhoneContact}
  /**
   * getter for xsd:string/String number
   * null
   * @return number
   */
  public String getNumber();

  /**
   * setter for xsd:string/String number
   * null
   * @param pnumber - new value for number
   */
  public void setNumber(String pnumber);

 /**
   * copy me from the given PhoneContact
   * @param PhoneContact - the source Object to copy from
   */
  public void copyFrom(PhoneContact pPhoneContact);
} // PhoneContact
