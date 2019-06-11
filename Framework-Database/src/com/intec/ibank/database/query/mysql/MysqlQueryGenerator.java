package com.intec.ibank.database.query.mysql;

import java.util.List;

import com.intec.ibank.database.query.QueryGenerator;
import com.intec.ibank.databaseConnector.criteria.IWhereCriteria;
import com.intec.ibank.databaseConnector.criteria.QueryConstraints;
import com.intec.ibank.databaseConnector.criteria.select.SelectConstraints;
import com.intec.ibank.databaseConnector.criteria.update.ParamCriteriaPair;

/**
 * Copyright.
 * 
 * Query Generator Class for Mysql Queries
 */
public class MysqlQueryGenerator extends QueryGenerator{
	
	/**
	 * Instantiates a new mysql query generator.
	 */
	public MysqlQueryGenerator(){
		super();
	}

	/* (non-Javadoc)
	 * @see com.IBank.database.query.IQueryGenerator#getSelectQuery(java.lang.String, com.IBank.databaseConnector.criteria.QueryConstraints)
	 */
	@Override
	public final ParamCriteriaPair getSelectQuery(String table, QueryConstraints constraints){
		String query = "Select * from " + table;
		int offset = 0;
		int rows = 0;

		List<Object> params = null;
		if (constraints != null) {
			IWhereCriteria crit = getWhereCriteria(constraints);
			if (crit != null) {
				params = crit.getParams();
				query += crit.getCriteria();
			}
		}
		
		if(rows > 0){
			if(offset < 0)
				offset = 0;
			if(offset == 0)
				query += " LIMIT " + rows;
			else
				query += " LIMIT " + offset + ", " + rows;
			//query = query + " LIMIT " + offset + ", " + rows;
		}

		return getParamCriteriaPair(query, params);
	}

	/* (non-Javadoc)
	 * @see com.IBank.database.query.IQueryGenerator#getSelectQuery(java.lang.String, com.IBank.databaseConnector.criteria.select.SelectConstraints)
	 */
	@Override
	public final ParamCriteriaPair getSelectQuery(String table, SelectConstraints constraints){
		
		String query = "Select ";
		int offset;
		int rows;
		if(constraints == null){
			query += " * ";
			
			offset = 0;
			rows = 0;
		}else{
			query += constraints.getSelectOptionValue() + " ";
			query += constraints.getExpressionsValue() + " ";
			query += constraints.getSumValue() + " ";
			query += constraints.getAverageValue() + " ";
			query += constraints.getMaxValue() + " ";

			offset = constraints.getOffset();
			rows = constraints.getRows();
		}
		query += " from " + table;

		List<Object> params = null;
		if (constraints != null) {
			IWhereCriteria crit = getWhereCriteria(constraints.getWhereCriteria());
			if (crit != null) {
				params = crit.getParams();
				query += crit.getCriteria();
			}
			
			query += constraints.getGroupByValue();
			query += constraints.getOrderByValue();
			query += constraints.getGroupByHavingValue();
		}
		
		/*if(rows > 0){
			if(offset < 0)
				offset = 0;
			query = query + " LIMIT " + offset + ", " + rows;*/
		if(rows > 0){
			if(offset < 0)
				offset = 0;
			if(offset == 0)
				query += " LIMIT " + rows;
			else
				query += " LIMIT " + offset + ", " + rows;
			//query = query + " LIMIT " + offset + ", " + rows;
		}

		return getParamCriteriaPair(query, params);
	}

}
