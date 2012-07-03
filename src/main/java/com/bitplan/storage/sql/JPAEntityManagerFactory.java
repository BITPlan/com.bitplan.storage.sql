package com.bitplan.storage.sql;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bitplan.resthelper.BOManagerFactoryImpl;

/**
 * JPA EntityManager Factory 
 * @author wf
 *
 */
public class JPAEntityManagerFactory extends BOManagerFactoryImpl {
	private static final String PERSISTENCE_UNIT_NAME = "default";
	private EntityManagerFactory factory;
	private EntityManager em;

	@Override
	public void setContext(Object pContext) {
		@SuppressWarnings("rawtypes")
		Map props=(Map) pContext;
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME,
				props);
		em = factory.createEntityManager();
	}

	@Override
	public Object getContext() {
		return em;
	}

}
