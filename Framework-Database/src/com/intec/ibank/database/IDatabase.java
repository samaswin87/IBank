package com.intec.ibank.database;

import com.intec.ibank.databaseConnector.criteria.QueryConstraints;
import com.intec.ibank.databaseConnector.criteria.update.UpdateConstraints;
import com.intec.ibank.databaseConnector.object.DataRow;

/**
 * Copyright
 *
 * The Interface for Database Handling.
 */
public interface IDatabase {
	
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
}
