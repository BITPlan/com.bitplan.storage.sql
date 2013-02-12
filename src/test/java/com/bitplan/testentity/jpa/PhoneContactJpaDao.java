/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2013-02-11 18:40 with smartGENERATOR
 */
package com.bitplan.testentity.jpa;
import java.io.Serializable;
// JPA / Hibernate imports
import javax.persistence.*;
//import static javax.persistence.CascadeType.*;
import com.bitplan.storage.sql.JPABOImpl;
// Guice
import com.google.inject.Inject;

import com.bitplan.testentity.PhoneContact;
import com.bitplan.testentity.PhoneContactImpl;
// utility imports
import java.util.Map;
import java.util.HashMap;

// restinterface
import com.bitplan.restinterface.BO;
	// >>>{implSection}{PhoneContact}{PhoneContact}
	// no implementation yet !!!
	// <<<{implSection}{PhoneContact}{PhoneContact}

/**
 * JPA Data access object for PhoneContact
 * Entity: PhoneContact for container testentity
 * Table: PhoneContact
 */
@Entity(name="PhoneContact")
@Table(name="PhoneContact")
public class PhoneContactJpaDao extends ContactJpaDao implements PhoneContact,Serializable {
	// >>>{code}{PhoneContactJpaDao}{PhoneContact}
	// no implementation yet !!!
	// <<<{code}{PhoneContactJpaDao}{PhoneContact}
  /**   
   * make Serializable happy ...   
   */  
  private static final long serialVersionUID = 1L;  
  
  /**
   * access to my Implementation
   */
  public PhoneContact getPhoneContactImpl() {
     return (PhoneContact)getImpl();
  }
  /**
   * default constructor for PhoneContact
   */
  public PhoneContactJpaDao() {
    super(new PhoneContactImpl());
    mBOImpl=(PhoneContact)super.getImpl();
    
  }
  
  /**
   * construct a PhoneContact from a given Data Access Object
   * @param pPhoneContact the Data Access Object to initialize this class from
   */
  public PhoneContactJpaDao(PhoneContact pPhoneContact) {
    super(pPhoneContact);
    mBOImpl=pPhoneContact;
	// >>>{constructor}{PhoneContactJpaDao}{PhoneContact}
	// no implementation yet !!!
	// <<<{constructor}{PhoneContactJpaDao}{PhoneContact}
  }
  /**
   * getter for xsd:string/String number
   * @return number
   */
  @Column(name="number")
  public String getNumber() { 
  	return getPhoneContactImpl().getNumber(); 
  }

  /**
   * setter for xsd:string/String number
   * @param pnumber - new value for number
   */
  public void setNumber(String pnumber) { 
  	getPhoneContactImpl().setNumber(pnumber); 
  }
  
 /**
   * copy me from the given PhoneContact
   * @param PhoneContact - the source Object to copy from
   */
  public void copyFrom(PhoneContact pPhoneContact) {
    mBOImpl.copyFrom(pPhoneContact);
  }
  /**
   * get the primary key of this business object
   */
	@Transient
  public Object getPrimaryKey() {
  	return getId();
  } // getPrimaryKey

  @Override
	public Object getField(String fieldName) {
		Object result=null;
    if (fieldName.equals("number")) result=getNumber();
		return result;
	} // getField

	@Override
	public Map<String, Object> toMap() {
	  Map<String, Object> result=new HashMap<String,Object>();
    result.put("number",getNumber());
		return result;
	} // toMap

	@Override
	public void fromMap(Map<String, Object> pMap) {
    if (pMap.containsKey("number"))	setNumber(getTypeConverter().getString(pMap.get("number")));
	} // fromMap
} // PhoneContactJpaDao
