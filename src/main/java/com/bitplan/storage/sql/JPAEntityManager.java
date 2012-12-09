package com.bitplan.storage.sql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.bitplan.resthelper.BOManagerImpl;
import com.bitplan.restinterface.BOManager;

/**
 * JPA Entity Manager
 * @author wf
 *
 */
public abstract class JPAEntityManager<BO> extends BOManagerImpl<BO>  implements BOManager<BO>{
	public static int MAX_RESULTS=100000;
	// for examples
	// http://www.winstonprakash.com/articles/netbeans/JPA_Add_Update_Delete.html
	EntityManager entityManager;
	String tableName;
	
	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

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
		assert(context!=null);
		if (context==this.getFactory()) {
			context=this.getFactory().getContext();
		}
		assert(context instanceof EntityManager);
		this.setEntityManager((EntityManager) context);			
	}

	@Override
	public void commit() {
		this.getEntityManager().getTransaction().commit();
	}

	@Override
	public void beginTransaction() {
		assert(this.getEntityManager().isOpen());
		this.getEntityManager().getTransaction().begin();
	}
	
	@Override
	public void purge() {
    bolist.clear();
    Query query = getEntityManager().createQuery("DELETE FROM "+this.getEntityName());
    query.executeUpdate();
	}

	@Override
	public void persist(BO entity) {
		this.getEntityManager().persist(entity);
	}

	@Override
	public void close() {
		this.getEntityManager().close();
	}
	
	@Override
	public BO findById(Object id) throws Exception {
		if (firstSearch) {
			this.findAll(MAX_RESULTS);
			firstSearch=false;
		}
		return super.findById(id);
	}
	
	@Override
	public <T> T find(Class<T> entityClass, Object primaryKey) throws Exception {
		T result = this.getEntityManager().find(entityClass, primaryKey);
		return result;
	}
	
	@Override
	public void findAll(int maxResults) {
		// http://stackoverflow.com/questions/2401129/hql-equivalent-query-to-this-sql-query
	  Query query = getEntityManager().createNativeQuery("SELECT * FROM "+this.getTableName(),this.getEntityType());
		query.setMaxResults(maxResults);
    bolist = query.getResultList();
	}

	
}
