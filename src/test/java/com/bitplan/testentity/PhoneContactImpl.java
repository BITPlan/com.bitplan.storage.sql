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
import com.bitplan.testentity.PhoneContact;
	// >>>{implSection}{PhoneContact}{PhoneContact}
	// no implementation yet !!!
	// <<<{implSection}{PhoneContact}{PhoneContact}
import com.google.inject.Inject;

/**
 * Pojo Implementation for PhoneContact
 */
public class PhoneContactImpl extends ContactImpl implements PhoneContact {

	// >>>{code}{PhoneContact}{PhoneContact}
	// no implementation yet !!!
	// <<<{code}{PhoneContact}{PhoneContact}
  
  /**
   * default constructor for a PhoneContactImpl 
   */
  public PhoneContactImpl() {
	// >>>{defaultConstructor}{PhoneContact}{PhoneContact}
	// no implementation yet !!!
	// <<<{defaultConstructor}{PhoneContact}{PhoneContact}
  }
    
  /**
   * number
   */
  private String number;
  
  /**
   * getter for number
   * @return the value for number
   */
  public String getNumber() { return number; };

  /**
   * setter for number
   * @param pnumber - new value for number
   */
  public void setNumber(String pnumber) { number=pnumber; };
 

  /**
   * copy me from the given PhoneContact
   * @param PhoneContact - the source Object to copy from
   */
  public void copyFrom(PhoneContact pPhoneContact) {
		setNumber(pPhoneContact.getNumber());
	} // copyFrom
	
} // PhoneContactImpl
