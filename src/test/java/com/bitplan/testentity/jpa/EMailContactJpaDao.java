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
package com.bitplan.testentity.jpa;
import java.io.Serializable;
// JPA / Hibernate imports
import javax.persistence.*;
//import static javax.persistence.CascadeType.*;
import com.bitplan.storage.sql.JPABOImpl;
// Guice
import com.google.inject.Inject;

import com.bitplan.testentity.EMailContact;
import com.bitplan.testentity.EMailContactImpl;
// utility imports
import java.util.Map;
import java.util.HashMap;

// restinterface
import com.bitplan.restinterface.BO;
	// >>>{implSection}{EMailContact}{EMailContact}
	// no implementation yet !!!
	// <<<{implSection}{EMailContact}{EMailContact}

/**
 * JPA Data access object for EMailContact
 * Entity: EMailContact for container testentity
 * Table: EMailContact
 */
@Entity(name="EMailContact")
@Table(name="EMailContact")
public class EMailContactJpaDao extends ContactJpaDao implements EMailContact,Serializable {

  /**   
   * make Serializable happy ...   
   */  
  private static final long serialVersionUID = 1L;  
  
  /**
   * access to my Implementation
   */
  public EMailContact getEMailContactImpl() {
     return (EMailContact)getImpl();
  }
  /**
   * default constructor for EMailContact
   */
  public EMailContactJpaDao() {
    super(new EMailContactImpl());
    mBOImpl=(EMailContact)super.getImpl();
    
  }
  
  /**
   * construct a EMailContact from a given Data Access Object
   * @param pEMailContact the Data Access Object to initialize this class from
   */
  public EMailContactJpaDao(EMailContact pEMailContact) {
    super(pEMailContact);
    mBOImpl=pEMailContact;
	// >>>{constructor}{EMailContactJpaDao}{EMailContact}
	// no implementation yet !!!
	// <<<{constructor}{EMailContactJpaDao}{EMailContact}
  }
  /**
   * getter for xsd:string/String mail
   * @return mail
   */
  @Column(name="mail")
  public String getMail() { 
  	return getEMailContactImpl().getMail(); 
  }

  /**
   * setter for xsd:string/String mail
   * @param pmail - new value for mail
   */
  public void setMail(String pmail) { 
  	getEMailContactImpl().setMail(pmail); 
  }
  
 /**
   * copy me from the given EMailContact
   * @param EMailContact - the source Object to copy from
   */
  public void copyFrom(EMailContact pEMailContact) {
    mBOImpl.copyFrom(pEMailContact);
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
    if (fieldName.equals("mail")) result=getMail();
		return result;
	} // getField

	@Override
	public Map<String, Object> toMap() {
	  Map<String, Object> result=new HashMap<String,Object>();
    result.put("mail",getMail());
		return result;
	} // toMap

	@Override
	public void fromMap(Map<String, Object> pMap) {
    if (pMap.containsKey("mail"))	setMail(getTypeConverter().getString(pMap.get("mail")));
	} // fromMap
} // EMailContactJpaDao
