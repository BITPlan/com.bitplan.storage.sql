/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2012-11-28 17:58 with smartGENERATOR
 */
package com.bitplan.testentity.jpa;
// List interface
import java.util.List;
// BO interface
import com.bitplan.restinterface.BO;
// base Entity Manager
import com.bitplan.storage.sql.JPAEntityManager;
// Entity interfaces
import com.bitplan.testentity.TypeTest;
import com.bitplan.testentity.TypeTestImpl;
import com.bitplan.testentity.TypeTestManager;
/**
 * JPA EntityManager implementation for interface TypeTest
 * Entity: TypeTest for container testentity
 */
public class TypeTestManagerJPA extends JPAEntityManager<TypeTest>
	implements TypeTestManager {
  /**
	 * set the typeTests
	 * @param pTypeTests
	 */
	@Override
	public void setTypeTests(List<TypeTest> pTypeTests) {
		super.bolist=pTypeTests;
	}
	
	/**
	 * @return the typeTests
	 */
	@Override
	public List<TypeTest> getTypeTests() {
		return super.bolist;
	}
	
	@Override
	public TypeTest create() {
		TypeTestJpaDao result = new TypeTestJpaDao(new TypeTestImpl());
		result.setBOManager(this);
		return result;
	}
		
	@Override
	public void purge() {
	  super.bolist.clear();
	}
	@Override
	public Class<? extends BO<?>> getEntityType() {
		return TypeTestJpaDao.class;
	}
	


} // TypeTestManagerJPA
