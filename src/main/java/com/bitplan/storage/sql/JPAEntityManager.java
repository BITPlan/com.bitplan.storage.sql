/**
 * Copyright (C) 2011-2012 BITPlan GmbH
 * 
 * Pater-Delp-Str. 1
 * D-47877 Willich-Schiefbahn
 *
 * http://www.bitplan.com
 */
package com.bitplan.storage.sql;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.eclipse.persistence.jpa.JpaQuery;

import com.bitplan.rest.jqgrid.JqGridFilter;
import com.bitplan.rest.jqgrid.JqGridRule;
import com.bitplan.rest.jqgrid.JqGridSearch;
import com.bitplan.resthelper.BOManagerImpl;
import com.bitplan.resthelper.FieldHelper;
import com.bitplan.restinterface.BO;
import com.bitplan.restinterface.BOManager;

/**
 * JPA Entity Manager
 * 
 * @author wf
 * 
 */
public abstract class JPAEntityManager<BO> extends BOManagerImpl<BO> implements
		BOManager<BO> {

	public static boolean debug = true;
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
	 * @param tableName
	 *          the tableName to set
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
	 * @param entityManager
	 *          the entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void setContext(Object context) {
		assert (context != null);
		if (context == this.getFactory()) {
			context = this.getFactory().getContext();
		}
		assert (context instanceof EntityManager);
		this.setEntityManager((EntityManager) context);
	}

	@Override
	public void commit() {
		this.getEntityManager().getTransaction().commit();
	}

	@Override
	public void beginTransaction() {
		assert (this.getEntityManager().isOpen());
		this.getEntityManager().getTransaction().begin();
	}

	@Override
	public void purge() {
		bolist.clear();
		Query query = getEntityManager().createQuery(
				"DELETE FROM " + this.getEntityName());
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
		@SuppressWarnings("unchecked")
		BO result = (BO) getEntityManager().find(this.getEntityType(), id);
		return result;
	}

	@Override
	public List<BO> findBy(String attributeName, Object attributeValue,
			int maxResults) throws Exception {
		Query query = getEntityManager().createNativeQuery(
				"SELECT * FROM " + this.getTableName() + " WHERE " + attributeName
						+ "='" + attributeValue.toString() + "'", this.getEntityType());
		query.setMaxResults(maxResults);
		@SuppressWarnings("unchecked")
		List<BO> result = query.getResultList();
		return result;
	}

	@Override
	public <T> T find(Class<T> entityClass, Object primaryKey) throws Exception {
		T result = this.getEntityManager().find(entityClass, primaryKey);
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void findAll(int maxResults) {
		// http://stackoverflow.com/questions/2401129/hql-equivalent-query-to-this-sql-query
		Query query = getEntityManager().createNativeQuery(
				"SELECT * FROM " + this.getTableName(), this.getEntityType());
		query.setMaxResults(maxResults);
		bolist = query.getResultList();
	}

	/**
	 * split a comma separated in List
	 * 
	 * @param inClause
	 * @return
	 */
	public List<String> getInMemberList(String inClause) {
		List<String> inMemberList = new ArrayList<String>();
		String[] inMembers = inClause.split(",");
		for (String member : inMembers) {
			inMemberList.add(member);
		}
		return inMemberList;
	}

	/**
	 * help building Criteria Queries
	 * 
	 * @author wf
	 * 
	 */
	protected class QueryHelper {
		CriteriaBuilder builder;
		CriteriaQuery<BO> query;
		CriteriaQuery<BO> select;
		
		CriteriaQuery<Long> countQuery;
		TypedQuery<Long> countTypedQuery;

		Root<BO> from;
		Root<BO> countFrom;
		CriteriaQuery<Long> countSelect;

		@SuppressWarnings("unchecked")
		public QueryHelper() {
			builder = getEntityManager().getCriteriaBuilder();
			
			query = (CriteriaQuery<BO>) builder.createQuery(getEntityType());
			countQuery = builder.createQuery(Long.class);
			
			from = (Root<BO>) query.from(getEntityType());
			countFrom= (Root<BO>) countQuery.from(getEntityType());
			
			select = query.select(from);
			countSelect= countQuery.select(builder.count(from));
		}
		
	}
	/**
	 * find by the given JqGridFilters
	 * 
	 * @param <T>
	 * @param filters
	 * @param sortOrder
	 * @param sortIndex
	 */
	public List<BO> findByJqGridFilter(JqGridSearch search) {
		QueryHelper qh = new QueryHelper();

  	if (search.getSortIndex() != null
				&& (!search.getSortIndex().trim().equals(""))) {
			String beanField = FieldHelper.firstToLower(search.getSortIndex());
			Path<Object> sortPath = qh.from.get(beanField);
			switch (search.getSortOrder()) {
			case asc:
				qh.query.orderBy(qh.builder.asc(sortPath));
				break;
			case desc:
				qh.query.orderBy(qh.builder.desc(sortPath));
				break;
			}
		}
		JqGridFilter filter = search.getFilter();
		if (filter != null) {
			List<Predicate> predicates = new ArrayList<Predicate>();
			for (JqGridRule rule : filter.getRules()) {
				String beanField = FieldHelper.firstToLower(rule.getField());
				Path<String> beanValue = qh.from.<String> get(beanField);
				Predicate expr;
				switch (rule.getOp()) {
				case eq: // equals
					expr = qh.builder.equal(beanValue, rule.getData());
					break;
				case ne: // not equals
					expr = qh.builder.not(qh.builder.equal(qh.from.get(beanField), rule.getData()));
					break;
				case bw: // begins with
					expr = qh.builder.like(beanValue, rule.getData() + "%");
					break;
				case ew: // ends with
					expr = qh.builder.like(beanValue, "%" + rule.getData());
					break;
				case en: // does not end with
					expr = qh.builder.not(qh.builder.like(beanValue, "%" + rule.getData()));
					break;
				case bn: // does not begin with
					expr = qh.builder.not(qh.builder.like(beanValue, rule.getData() + "%"));
					break;
				case cn: // contains
					expr = qh.builder.like(beanValue, "%" + rule.getData() + "%");
					break;
				case nc: // does not contain
					expr = qh.builder.not(qh.builder.like(beanValue, "%" + rule.getData() + "%"));
					break;
				case in: // in
					expr = beanValue.in(this.getInMemberList(rule.getData()));
					break;
				case ni: // not in
					expr = qh.builder.not(beanValue.in(this.getInMemberList(rule.getData())));
					break;
				case lt: // less than
					expr = qh.builder.lessThan(beanValue, rule.getData());
					break;
				case le: // less than or equal
					expr = qh.builder.lessThanOrEqualTo(beanValue, rule.getData());
					break;
				case gt: // greater than
					expr = qh.builder.greaterThan(beanValue, rule.getData());
					break;
				case ge: // greater than or equal
					expr = qh.builder.greaterThanOrEqualTo(beanValue, rule.getData());
					break;
				default:
					throw new IllegalArgumentException("unsupported operation "
							+ rule.getOp());
				} // switch
				predicates.add(expr);
			} // for
			Predicate whereExpr = null;
			switch (filter.getGroupOp()) {
			case AND:
				whereExpr = qh.builder.conjunction();
				whereExpr = qh.builder.and(predicates.toArray(new Predicate[predicates
						.size()]));
				break;
			case OR:
				whereExpr = qh.builder.disjunction();
				whereExpr = qh.builder
						.or(predicates.toArray(new Predicate[predicates.size()]));
				break;
			} // switch
			qh.query.where(whereExpr);
			qh.countQuery.where(whereExpr);
		} // if filter
		// http://stackoverflow.com/questions/5349264/total-row-count-for-pagination-using-jpa-criteria-api
		qh.countTypedQuery=getEntityManager().createQuery(qh.countSelect);
	  search.setTotalRowCount(qh.countTypedQuery.getSingleResult());

		TypedQuery<BO> query = getEntityManager().createQuery(qh.select);
		query.setFirstResult(search.getFirstResult());
		query.setMaxResults(search.getMaxResults());
		List<BO> results = query.getResultList();		
	 	
		// set the ResultRowCount
		search.setResultRowCount(results.size());
		if (debug) {
			String sql = query.unwrap(JpaQuery.class).getDatabaseQuery()
					.getSQLString();
			String countSql = qh.countTypedQuery.unwrap(JpaQuery.class).getDatabaseQuery()
					.getSQLString();
			System.out.println(sql);
			System.out.println("\t"+countSql);
		}
		return results;
	}

}
