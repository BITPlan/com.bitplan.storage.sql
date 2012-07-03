package com.bitplan.storage.sql;

import javax.persistence.EntityManager;
import com.bitplan.resthelper.BOManagerImpl;

/**
 * JPA Entity Manager
 * @author wf
 *
 */
public abstract class JPAEntityManager<BO> extends BOManagerImpl<BO> implements com.bitplan.javax.persistence.EntityManager {
	// for examples
	// http://www.winstonprakash.com/articles/netbeans/JPA_Add_Update_Delete.html
	EntityManager entityManager;
	
	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @param entityManager the entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public void setContext(Object context) {
		this.setEntityManager((EntityManager) context);
		
	}

	@Override
	public void commit() {
		this.getEntityManager().getTransaction().commit();
	}

	// @Override
	public void beginTransaction() {
		this.getEntityManager().getTransaction().begin();
	}

	@Override
	public <T> T find(Class<T> entityClass, Object primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void persist(Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}


}
