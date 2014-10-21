
package com.bitplan.storage.sql;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.bitplan.javax.persistence.Query;
import com.bitplan.restinterface.BO;

/**
 * JPA specific implementation of Query (delegation)
 * @author wf
 *
 */
public class JPAQuery<BO_T> implements com.bitplan.javax.persistence.Query {

	TypedQuery<? extends BO<?>> javaxQuery;
	String name;
	
	public JPAEntityManager<BO_T> myManager;
	
	/**
	 * create a query
	 * @param pManager
	 */
	public JPAQuery(JPAEntityManager<BO_T> pManager, String pName) {
	  myManager=pManager;	
	  if (pName!=null) {
	  	setName(pName);
	  	EntityManager entityManager = myManager.getEntityManager();
	  	if (entityManager==null)
	  		throw new RuntimeException("entityManager not set for "+myManager.getEntityName());
	  	javaxQuery=entityManager.createNamedQuery(pName,pManager.getEntityType());
	  }
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public List<Object> getResultList() {
		List<? extends BO<?>> qresult = javaxQuery.getResultList();
		List<Object> result=new ArrayList<Object>();
		for (BO<?> bo:qresult) {
			result.add(bo);
		}
		return result;
	}

	@Override
	public Query setFirstResult(int startPosition) {
		javaxQuery=javaxQuery.setFirstResult(startPosition);
		return this;
	}

	@Override
	public Query setMaxResults(int maxResult) {
		javaxQuery=javaxQuery.setMaxResults(maxResult);
		return this;
	}

	@Override
	public Object getSingleResult() {
		Object result = javaxQuery.getSingleResult();
		return result;
	}

	@Override
	public void setParameter(String name, Object value) {
		javaxQuery.setParameter(name,value);
	}

}
