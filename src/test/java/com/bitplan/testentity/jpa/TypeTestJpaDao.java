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

import com.bitplan.testentity.TypeTest;
import com.bitplan.testentity.TypeTestImpl;
// utility imports
import java.util.Map;
import java.util.HashMap;

// restinterface
import com.bitplan.restinterface.BO;
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
public class TypeTestJpaDao extends JPABOImpl<TypeTest> implements TypeTest,Serializable {

  /**   
   * make Serializable happy ...   
   */  
  private static final long serialVersionUID = 1L;  
  
  /**
   * access to my Implementation
   */
  public TypeTest getTypeTestImpl() {
     return (TypeTest)getImpl();
  }
  /**
   * default constructor for TypeTest
   */
  public TypeTestJpaDao() {
    mBOImpl=new TypeTestImpl();
    
  }
  
  /**
   * construct a TypeTest from a given Data Access Object
   * @param pTypeTest the Data Access Object to initialize this class from
   */
  public TypeTestJpaDao(TypeTest pTypeTest) {
    super();
    mBOImpl=pTypeTest;
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
  	return getTypeTestImpl().getId(); 
  }

  /**
   * setter for xsd:long/long id
   * @param pid - new value for id
   */
  public void setId(long pid) { 
  	getTypeTestImpl().setId(pid); 
  }
  
  /**
   * getter for xsd:string/String tstringVal
   * @return tstringVal
   */
  @Column(name="tstringVal")
  public String getTstringVal() { 
  	return getTypeTestImpl().getTstringVal(); 
  }

  /**
   * setter for xsd:string/String tstringVal
   * @param ptstringVal - new value for tstringVal
   */
  public void setTstringVal(String ptstringVal) { 
  	getTypeTestImpl().setTstringVal(ptstringVal); 
  }
  
  /**
   * getter for xsd:boolean/boolean tbooleanVal
   * @return tbooleanVal
   */
  @Column(name="tbooleanVal")
  public boolean isTbooleanVal() { 
  	return getTypeTestImpl().isTbooleanVal(); 
  }

  /**
   * setter for xsd:boolean/boolean tbooleanVal
   * @param ptbooleanVal - new value for tbooleanVal
   */
  public void setTbooleanVal(boolean ptbooleanVal) { 
  	getTypeTestImpl().setTbooleanVal(ptbooleanVal); 
  }
  
  /**
   * getter for xsd:long/long tlongVal
   * @return tlongVal
   */
  @Column(name="tlongVal")
  public long getTlongVal() { 
  	return getTypeTestImpl().getTlongVal(); 
  }

  /**
   * setter for xsd:long/long tlongVal
   * @param ptlongVal - new value for tlongVal
   */
  public void setTlongVal(long ptlongVal) { 
  	getTypeTestImpl().setTlongVal(ptlongVal); 
  }
  
  /**
   * getter for xsd:int/int tintVal
   * @return tintVal
   */
  @Column(name="tintVal")
  public int getTintVal() { 
  	return getTypeTestImpl().getTintVal(); 
  }

  /**
   * setter for xsd:int/int tintVal
   * @param ptintVal - new value for tintVal
   */
  public void setTintVal(int ptintVal) { 
  	getTypeTestImpl().setTintVal(ptintVal); 
  }
  
  /**
   * getter for xsd:short/short tshortVal
   * @return tshortVal
   */
  @Column(name="tshortVal")
  public short getTshortVal() { 
  	return getTypeTestImpl().getTshortVal(); 
  }

  /**
   * setter for xsd:short/short tshortVal
   * @param ptshortVal - new value for tshortVal
   */
  public void setTshortVal(short ptshortVal) { 
  	getTypeTestImpl().setTshortVal(ptshortVal); 
  }
  
  /**
   * getter for xsd:decimal/long tdecimalVal
   * @return tdecimalVal
   */
  @Column(name="tdecimalVal")
  public long getTdecimalVal() { 
  	return getTypeTestImpl().getTdecimalVal(); 
  }

  /**
   * setter for xsd:decimal/long tdecimalVal
   * @param ptdecimalVal - new value for tdecimalVal
   */
  public void setTdecimalVal(long ptdecimalVal) { 
  	getTypeTestImpl().setTdecimalVal(ptdecimalVal); 
  }
  
  /**
   * getter for xsd:float/float tfloatVal
   * @return tfloatVal
   */
  @Column(name="tfloatVal")
  public float getTfloatVal() { 
  	return getTypeTestImpl().getTfloatVal(); 
  }

  /**
   * setter for xsd:float/float tfloatVal
   * @param ptfloatVal - new value for tfloatVal
   */
  public void setTfloatVal(float ptfloatVal) { 
  	getTypeTestImpl().setTfloatVal(ptfloatVal); 
  }
  
  /**
   * getter for xsd:double/double tdoubleVal
   * @return tdoubleVal
   */
  @Column(name="tdoubleVal")
  public double getTdoubleVal() { 
  	return getTypeTestImpl().getTdoubleVal(); 
  }

  /**
   * setter for xsd:double/double tdoubleVal
   * @param ptdoubleVal - new value for tdoubleVal
   */
  public void setTdoubleVal(double ptdoubleVal) { 
  	getTypeTestImpl().setTdoubleVal(ptdoubleVal); 
  }
  
  /**
   * getter for xsd:dateTime/java.util.Date tdateVal
   * @return tdateVal
   */
  @Column(name="tdateVal")
  @Temporal(TemporalType.DATE)
  public java.util.Date getTdateVal() { 
  	return getTypeTestImpl().getTdateVal(); 
  }

  /**
   * setter for xsd:dateTime/java.util.Date tdateVal
   * @param ptdateVal - new value for tdateVal
   */
  public void setTdateVal(java.util.Date ptdateVal) { 
  	getTypeTestImpl().setTdateVal(ptdateVal); 
  }
  
  /**
   * getter for xsd:dateTime/java.util.Date tdateTimeVal
   * @return tdateTimeVal
   */
  @Column(name="tdateTimeVal")
  @Temporal(TemporalType.TIMESTAMP)
  public java.util.Date getTdateTimeVal() { 
  	return getTypeTestImpl().getTdateTimeVal(); 
  }

  /**
   * setter for xsd:dateTime/java.util.Date tdateTimeVal
   * @param ptdateTimeVal - new value for tdateTimeVal
   */
  public void setTdateTimeVal(java.util.Date ptdateTimeVal) { 
  	getTypeTestImpl().setTdateTimeVal(ptdateTimeVal); 
  }
  
 /**
   * copy me from the given TypeTest
   * @param TypeTest - the source Object to copy from
   */
  public void copyFrom(TypeTest pTypeTest) {
    mBOImpl.copyFrom(pTypeTest);
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
    if (fieldName.equals("id")) result=getId();
    if (fieldName.equals("tstringVal")) result=getTstringVal();
    if (fieldName.equals("tbooleanVal")) result=isTbooleanVal();
    if (fieldName.equals("tlongVal")) result=getTlongVal();
    if (fieldName.equals("tintVal")) result=getTintVal();
    if (fieldName.equals("tshortVal")) result=getTshortVal();
    if (fieldName.equals("tdecimalVal")) result=getTdecimalVal();
    if (fieldName.equals("tfloatVal")) result=getTfloatVal();
    if (fieldName.equals("tdoubleVal")) result=getTdoubleVal();
    if (fieldName.equals("tdateVal")) result=getTdateVal();
    if (fieldName.equals("tdateTimeVal")) result=getTdateTimeVal();
		return result;
	} // getField

	@Override
	public Map<String, Object> toMap() {
	  Map<String, Object> result=new HashMap<String,Object>();
    result.put("id",getId());
    result.put("tstringVal",getTstringVal());
    result.put("tbooleanVal",isTbooleanVal());
    result.put("tlongVal",getTlongVal());
    result.put("tintVal",getTintVal());
    result.put("tshortVal",getTshortVal());
    result.put("tdecimalVal",getTdecimalVal());
    result.put("tfloatVal",getTfloatVal());
    result.put("tdoubleVal",getTdoubleVal());
    result.put("tdateVal",getTdateVal());
    result.put("tdateTimeVal",getTdateTimeVal());
		return result;
	} // toMap

	@Override
	public void fromMap(Map<String, Object> pMap) {
    if (pMap.containsKey("id"))	setId(getTypeConverter().getLong(pMap.get("id")));
    if (pMap.containsKey("tstringVal"))	setTstringVal(getTypeConverter().getString(pMap.get("tstringVal")));
    if (pMap.containsKey("tbooleanVal"))	setTbooleanVal(getTypeConverter().getBoolean(pMap.get("tbooleanVal")));
    if (pMap.containsKey("tlongVal"))	setTlongVal(getTypeConverter().getLong(pMap.get("tlongVal")));
    if (pMap.containsKey("tintVal"))	setTintVal(getTypeConverter().getInteger(pMap.get("tintVal")));
    if (pMap.containsKey("tshortVal"))	setTshortVal(getTypeConverter().getShort(pMap.get("tshortVal")));
    if (pMap.containsKey("tdecimalVal"))	setTdecimalVal(getTypeConverter().getLong(pMap.get("tdecimalVal")));
    if (pMap.containsKey("tfloatVal"))	setTfloatVal(getTypeConverter().getFloat(pMap.get("tfloatVal")));
    if (pMap.containsKey("tdoubleVal"))	setTdoubleVal(getTypeConverter().getDouble(pMap.get("tdoubleVal")));
    if (pMap.containsKey("tdateVal"))	setTdateVal(getTypeConverter().getDate(pMap.get("tdateVal")));
    if (pMap.containsKey("tdateTimeVal"))	setTdateTimeVal(getTypeConverter().getDate(pMap.get("tdateTimeVal")));
	} // fromMap
} // TypeTestJpaDao
