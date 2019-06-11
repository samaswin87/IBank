package com.intec.ibank.database;

import java.util.List;

import com.intec.ibank.databaseConnector.criteria.QueryConstraints;
import com.intec.ibank.databaseConnector.criteria.select.SelectConstraints;
import com.intec.ibank.databaseConnector.criteria.select.union.UnionConstraint;
import com.intec.ibank.databaseConnector.criteria.update.UpdateConstraints;
import com.intec.ibank.databaseConnector.object.DataRow;
import com.intec.ibank.databaseConnector.object.dataTable.DataTable;
import com.intec.ibank.databaseConnector.transaction.object.ContractIQTransactionObject;

/**
 * Copyright.
 * 
 * The interface for handling the operations for the Database 
 */
public interface IIBankDatabaseConnector extends IDatabase{
	
	/**
	 * Retrieve rows.
	 *
	 * @param table the table
	 * @return the data table
	 * @throws Throwable the throwable
	 */
	DataTable retrieveRows(String table) throws Throwable;

	/**
	 * Retrieve query rows.
	 *
	 * @param query the query
	 * @param params the params
	 * @return the data table
	 * @throws Throwable the throwable
	 */
	DataTable retrieveQueryRows(String query, List<Object> params) throws Throwable;
	
	/**
	 * Retrieve rows.
	 *
	 * @param table the table
	 * @param constraints the constraints
	 * @return the data table
	 * @throws Throwable the throwable
	 */
	DataTable retrieveRows(String table, QueryConstraints constraints) throws Throwable;
	
	/**
	 * Retrieve rows.
	 *
	 * @param table the table
	 * @param constraints the constraints
	 * @return the data table
	 * @throws Throwable the throwable
	 */
	DataTable retrieveRows(String table, SelectConstraints constraints) throws Throwable;
	
	/**
	 * Retrieve rows.
	 *
	 * @param constraint the constraint
	 * @return the data table
	 * @throws Throwable the throwable
	 */
	DataTable retrieveRows(UnionConstraint constraint) throws Throwable;
	
	/**
	 * Creates the row.
	 *
	 * @param table the table
	 * @param rowValue the row value
	 * @return true, if successful
	 * @throws Throwable the throwable
	 */
	boolean createRow(String table, DataRow rowValue) throws Throwable;
	
	/**
	 * Update rows.
	 *
	 * @param table the table
	 * @param constraints the constraints
	 * @return the int
	 * @throws Throwable the throwable
	 */
	int updateRows(String table, UpdateConstraints constraints) throws Throwable;
	
	/**
	 * Delete rows.
	 *
	 * @param table the table
	 * @return the int
	 * @throws Throwable the throwable
	 */
	int deleteRows(String table) throws Throwable;
	
	/**
	 * Delete rows.
	 *
	 * @param table the table
	 * @param constraints the constraints
	 * @return the int
	 * @throws Throwable the throwable
	 */
	int deleteRows(String table, QueryConstraints constraints) throws Throwable;
	
	/**
	 * Store.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 * @throws Throwable the throwable
	 */
	boolean store(ContractIQTransactionObject obj) throws Throwable;
}
