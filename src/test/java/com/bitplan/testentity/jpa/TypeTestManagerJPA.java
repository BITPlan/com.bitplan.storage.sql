/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 * 
 * generated: 2012-12-14 12:42 with smartGENERATOR
 */
package com.bitplan.testentity.jpa;
// base Entity Manager
import com.bitplan.storage.sql.JPAEntityManager;
// List
import java.util.List;
import java.util.ArrayList;

// BO interface
import com.bitplan.restinterface.BO;


// Entity interfaces
import com.bitplan.testentity.TypeTest;
import com.bitplan.testentity.TypeTestImpl;
import com.bitplan.testentity.TypeTestManager;
	// >>>{ManagerImports}{TypeTestjpa}{TypeTest}
	// no implementation yet !!!
	// <<<{ManagerImports}{TypeTestjpa}{TypeTest}
/**
 * JPA EntityManager implementation for interface TypeTest
 * Entity: TypeTest for container testentity
 */
public class TypeTestManagerJPA extends JPAEntityManager<TypeTest>
	implements TypeTestManager {
	
	public TypeTestManagerJPA() {
		this.setTableName("TypeTest");
	}
	// >>>{Managercode}{TypeTestJpaDao}{TypeTest}
	// no implementation yet !!!
	// <<<{Managercode}{TypeTestJpaDao}{TypeTest}

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
	public Class<? extends BO<?>> getEntityType() {
		return TypeTestJpaDao.class;
	}
	


} // TypeTestManagerJPA
