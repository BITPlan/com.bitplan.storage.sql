/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2012-11-28 18:31 with smartGENERATOR
 */
package com.bitplan.testentity.jpa;
import java.io.Serializable;
// JPA / Hibernate imports
import javax.persistence.*;
//import static javax.persistence.CascadeType.*;
import com.bitplan.storage.sql.JPABOImpl;
// Guice
import com.google.inject.Inject;

import com.bitplan.testentity.TypeTest;
import com.bitplan.testentity.TypeTestImpl;
	// >>>{implSection}{TypeTest}{TypeTest}
	// no implementation yet !!!
	// <<<{implSection}{TypeTest}{TypeTest}

/**
 * JPA Data access object for TypeTest
 * Entity: TypeTest for container testentity
 * Table: TypeTest
 */
@Entity(name="TypeTest")
@Table(name="TypeTest")
public class TypeTestJpaDao extends JPABOImpl<TypeTest>  implements TypeTest, Serializable{

  /**   
   * make Serializable happy ...   
   */  
  private static final long serialVersionUID = 1L;  
  /**
   * the true implementation
   */
  protected TypeTest mTypeTestImpl;
  
  /**
   * return the implementation for TypeTest
   * @return the TypeTest implementation 
   */
  public TypeTest getImpl() {
    return mTypeTestImpl;
  }
  
  /**
   * default constructor for TypeTest
   */
  public TypeTestJpaDao() {
    mTypeTestImpl=new TypeTestImpl();
    
  }
  
  /**
   * construct a TypeTest from a given Data Access Object
   * @param pTypeTest the Data Access Object to initialize this class from
   */
  public TypeTestJpaDao(TypeTest pTypeTest) {
    super();
    mTypeTestImpl=pTypeTest;
	// >>>{constructor}{TypeTestJpaDao}{TypeTest}
	// no implementation yet !!!
	// <<<{constructor}{TypeTestJpaDao}{TypeTest}
  }
  /**
   * getter for xsd:long/long id
   * @return id
   */
  @Id
  @Column(name="id")
  public long getId() { 
  	return mTypeTestImpl.getId(); 
  }

  /**
   * setter for xsd:long/long id
   * @param pid - new value for id
   */
  public void setId(long pid) { 
  	mTypeTestImpl.setId(pid); 
  }
  
  /**
   * getter for xsd:string/String tstringVal
   * @return tstringVal
   */
  @Column(name="tstringVal")
  public String getTstringVal() { 
  	return mTypeTestImpl.getTstringVal(); 
  }

  /**
   * setter for xsd:string/String tstringVal
   * @param ptstringVal - new value for tstringVal
   */
  public void setTstringVal(String ptstringVal) { 
  	mTypeTestImpl.setTstringVal(ptstringVal); 
  }
  
  /**
   * getter for xsd:boolean/boolean tbooleanVal
   * @return tbooleanVal
   */
  @Column(name="tbooleanVal")
  public boolean isTbooleanVal() { 
  	return mTypeTestImpl.isTbooleanVal(); 
  }

  /**
   * setter for xsd:boolean/boolean tbooleanVal
   * @param ptbooleanVal - new value for tbooleanVal
   */
  public void setTbooleanVal(boolean ptbooleanVal) { 
  	mTypeTestImpl.setTbooleanVal(ptbooleanVal); 
  }
  
  /**
   * getter for xsd:long/long tlongVal
   * @return tlongVal
   */
  @Column(name="tlongVal")
  public long getTlongVal() { 
  	return mTypeTestImpl.getTlongVal(); 
  }

  /**
   * setter for xsd:long/long tlongVal
   * @param ptlongVal - new value for tlongVal
   */
  public void setTlongVal(long ptlongVal) { 
  	mTypeTestImpl.setTlongVal(ptlongVal); 
  }
  
  /**
   * getter for xsd:int/int tintVal
   * @return tintVal
   */
  @Column(name="tintVal")
  public int getTintVal() { 
  	return mTypeTestImpl.getTintVal(); 
  }

  /**
   * setter for xsd:int/int tintVal
   * @param ptintVal - new value for tintVal
   */
  public void setTintVal(int ptintVal) { 
  	mTypeTestImpl.setTintVal(ptintVal); 
  }
  
  /**
   * getter for xsd:short/short tshortVal
   * @return tshortVal
   */
  @Column(name="tshortVal")
  public short getTshortVal() { 
  	return mTypeTestImpl.getTshortVal(); 
  }

  /**
   * setter for xsd:short/short tshortVal
   * @param ptshortVal - new value for tshortVal
   */
  public void setTshortVal(short ptshortVal) { 
  	mTypeTestImpl.setTshortVal(ptshortVal); 
  }
  
  /**
   * getter for xsd:decimal/long tdecimalVal
   * @return tdecimalVal
   */
  @Column(name="tdecimalVal")
  public long getTdecimalVal() { 
  	return mTypeTestImpl.getTdecimalVal(); 
  }

  /**
   * setter for xsd:decimal/long tdecimalVal
   * @param ptdecimalVal - new value for tdecimalVal
   */
  public void setTdecimalVal(long ptdecimalVal) { 
  	mTypeTestImpl.setTdecimalVal(ptdecimalVal); 
  }
  
  /**
   * getter for xsd:float/float tfloatVal
   * @return tfloatVal
   */
  @Column(name="tfloatVal")
  public float getTfloatVal() { 
  	return mTypeTestImpl.getTfloatVal(); 
  }

  /**
   * setter for xsd:float/float tfloatVal
   * @param ptfloatVal - new value for tfloatVal
   */
  public void setTfloatVal(float ptfloatVal) { 
  	mTypeTestImpl.setTfloatVal(ptfloatVal); 
  }
  
  /**
   * getter for xsd:double/double tdoubleVal
   * @return tdoubleVal
   */
  @Column(name="tdoubleVal")
  public double getTdoubleVal() { 
  	return mTypeTestImpl.getTdoubleVal(); 
  }

  /**
   * setter for xsd:double/double tdoubleVal
   * @param ptdoubleVal - new value for tdoubleVal
   */
  public void setTdoubleVal(double ptdoubleVal) { 
  	mTypeTestImpl.setTdoubleVal(ptdoubleVal); 
  }
  
  /**
   * getter for xsd:dateTime/java.util.Date tdateVal
   * @return tdateVal
   */
  @Column(name="tdateVal")
  @Temporal(TemporalType.DATE)
  public java.util.Date getTdateVal() { 
  	return mTypeTestImpl.getTdateVal(); 
  }

  /**
   * setter for xsd:dateTime/java.util.Date tdateVal
   * @param ptdateVal - new value for tdateVal
   */
  public void setTdateVal(java.util.Date ptdateVal) { 
  	mTypeTestImpl.setTdateVal(ptdateVal); 
  }
  
  /**
   * getter for xsd:dateTime/java.util.Date tdateTimeVal
   * @return tdateTimeVal
   */
  @Column(name="tdateTimeVal")
  @Temporal(TemporalType.TIMESTAMP)
  public java.util.Date getTdateTimeVal() { 
  	return mTypeTestImpl.getTdateTimeVal(); 
  }

  /**
   * setter for xsd:dateTime/java.util.Date tdateTimeVal
   * @param ptdateTimeVal - new value for tdateTimeVal
   */
  public void setTdateTimeVal(java.util.Date ptdateTimeVal) { 
  	mTypeTestImpl.setTdateTimeVal(ptdateTimeVal); 
  }
  

  /**
   * get the primary key of this business object
   */
	@Transient
  public Object getPrimaryKey() {
  	return getId();
  }
} // TypeTestJpaDao
