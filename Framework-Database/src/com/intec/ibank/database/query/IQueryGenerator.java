package com.intec.ibank.database.query;

import com.intec.ibank.databaseConnector.criteria.QueryConstraints;
import com.intec.ibank.databaseConnector.criteria.select.SelectConstraints;
import com.intec.ibank.databaseConnector.criteria.select.union.UnionConstraint;
import com.intec.ibank.databaseConnector.criteria.update.ParamCriteriaPair;
import com.intec.ibank.databaseConnector.criteria.update.UpdateConstraints;
import com.intec.ibank.databaseConnector.object.DataRow;

/**
 * Copyright.
 * 
 * Functionalities for Query Generation
 */
public interface IQueryGenerator {
	
	/**
	 * Gets the select query.
	 *
	 * @param table the table
	 * @return the select query
	 */
	ParamCriteriaPair getSelectQuery(String table);
	
	/**
	 * Gets the select query.
	 *
	 * @param table the table
	 * @param constraints the constraints
	 * @return the select query
	 */
	ParamCriteriaPair getSelectQuery(String table, QueryConstraints constraints);
	
	/**
	 * Gets the select query.
	 *
	 * @param table the table
	 * @param constraints the constraints
	 * @return the select query
	 */
	ParamCriteriaPair getSelectQuery(String table, SelectConstraints constraints);
	
	/**
	 * Gets the select query.
	 *
	 * @param constraints the constraints
	 * @return the select query
	 */
	ParamCriteriaPair getSelectQuery(UnionConstraint constraints);
	
	/**
	 * Gets the creates the query.
	 *
	 * @param table the table
	 * @param rowValue the row value
	 * @return the creates the query
	 */
	ParamCriteriaPair getCreateQuery(String table, DataRow rowValue);
	
	/**
	 * Gets the update query.
	 *
	 * @param table the table
	 * @param constraints the constraints
	 * @return the update query
	 */
	ParamCriteriaPair getUpdateQuery(String table, UpdateConstraints constraints);
	
	/**
	 * Gets the delete query.
	 *
	 * @param table the table
	 * @param constraints the constraints
	 * @return the delete query
	 */
	ParamCriteriaPair getDeleteQuery(String table, QueryConstraints constraints);
}
