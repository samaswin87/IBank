package com.intec.ibank.dao;

import java.util.List;

import com.intec.ibank.database.IIBankDatabaseConnector;
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
 * This is used by the Dao Classes to connect with the Database
 */
public abstract class BaseIBankDao implements IIBankDatabaseConnector{

	/**
	 * Instantiates a new IBank dao.
	 */
	public BaseIBankDao() {
		super();
	}

	protected abstract IIBankDatabaseConnector getConnector();

	/* (non-Javadoc)
	 * @see com.IBank.database.IIBankDatabaseConnector#retrieveRows(java.lang.String)
	 */
	public final DataTable retrieveRows(String table) throws Throwable {
		IIBankDatabaseConnector connector = getConnector();
		if(connector == null)
			return null;
		return connector.retrieveRows(table);
	}

	/**
	 * Retrieve rows.
	 *
	 * @param table the table
	 * @param connector the connector
	 * @return the data table
	 * @throws Throwable the throwable
	 */
	public static final DataTable retrieveRows(String table, IIBankDatabaseConnector connector) throws Throwable {
		return connector.retrieveRows(table);
	}

	/* (non-Javadoc)
	 * @see com.IBank.database.IIBankDatabaseConnector#retrieveRows(java.lang.String, com.IBank.databaseConnector.criteria.QueryConstraints)
	 */
	public final DataTable retrieveRows(String table, QueryConstraints constraints) throws Throwable {
		IIBankDatabaseConnector connector = getConnector();
		if(connector == null)
			return null;
		return connector.retrieveRows(table, constraints);
	}

	@Override
	public DataTable retrieveQueryRows(String query, List<Object> params)
			throws Throwable {
		IIBankDatabaseConnector connector = getConnector();
		if(connector == null)
			return null;
		return connector.retrieveQueryRows(query, params);
	}

	/**
	 * Retrieve rows.
	 *
	 * @param table the table
	 * @param constraints the constraints
	 * @param connector the connector
	 * @return the data table
	 * @throws Throwable the throwable
	 */
	public final DataTable retrieveRows(String table, QueryConstraints constraints, IIBankDatabaseConnector connector) throws Throwable {
		return connector.retrieveRows(table, constraints);
	}

	/* (non-Javadoc)
	 * @see com.IBank.database.IIBankDatabaseConnector#retrieveRows(java.lang.String, com.IBank.databaseConnector.criteria.select.SelectConstraints)
	 */
	public final DataTable retrieveRows(String table, SelectConstraints constraints) throws Throwable {
		IIBankDatabaseConnector connector = getConnector();
		if(connector == null)
			return null;
		return connector.retrieveRows(table, constraints);
	}

	/**
	 * Retrieve rows.
	 *
	 * @param table the table
	 * @param constraints the constraints
	 * @param connector the connector
	 * @return the data table
	 * @throws Throwable the throwable
	 */
	public final DataTable retrieveRows(String table, SelectConstraints constraints, IIBankDatabaseConnector connector) throws Throwable {
		return connector.retrieveRows(table, constraints);
	}

	/* (non-Javadoc)
	 * @see com.IBank.database.IIBankDatabaseConnector#retrieveRows(com.IBank.databaseConnector.criteria.select.union.UnionConstraint)
	 */
	public final DataTable retrieveRows(UnionConstraint constraint) throws Throwable {
		IIBankDatabaseConnector connector = getConnector();
		if(connector == null)
			return null;
		return connector.retrieveRows(constraint);
	}

	/**
	 * Retrieve rows.
	 *
	 * @param constraint the constraint
	 * @param connector the connector
	 * @return the data table
	 * @throws Throwable the throwable
	 */
	public final DataTable retrieveRows(UnionConstraint constraint, IIBankDatabaseConnector connector) throws Throwable {
		return connector.retrieveRows(constraint);
	}
	
	/* (non-Javadoc)
	 * @see com.IBank.database.IIBankDatabaseConnector#createRow(java.lang.String, com.IBank.databaseConnector.object.DataRow)
	 */
	public final boolean createRow(String table, DataRow rowValue) throws Throwable {
		IIBankDatabaseConnector connector = getConnector();
		if(connector == null)
			return false;
		return connector.createRow(table, rowValue);
	}
	
	/**
	 * Creates the row.
	 *
	 * @param table the table
	 * @param rowValue the row value
	 * @param connector the connector
	 * @return true, if successful
	 * @throws Throwable the throwable
	 */
	public final boolean createRow(String table, DataRow rowValue, IIBankDatabaseConnector connector) throws Throwable {
		return connector.createRow(table, rowValue);
	}

	/* (non-Javadoc)
	 * @see com.IBank.database.IIBankDatabaseConnector#updateRows(java.lang.String, com.IBank.databaseConnector.criteria.update.UpdateConstraints)
	 */
	public final int updateRows(String table, UpdateConstraints constraints) throws Throwable {
		IIBankDatabaseConnector connector = getConnector();
		if(connector == null)
			return -1;
		return connector.updateRows(table, constraints);
	}

	/**
	 * Update rows.
	 *
	 * @param table the table
	 * @param constraints the constraints
	 * @param connector the connector
	 * @return the int
	 * @throws Throwable the throwable
	 */
	public final int updateRows(String table, UpdateConstraints constraints, IIBankDatabaseConnector connector) throws Throwable {
		return connector.updateRows(table, constraints);
	}

	/* (non-Javadoc)
	 * @see com.IBank.database.IIBankDatabaseConnector#deleteRows(java.lang.String)
	 */
	public final int deleteRows(String table) throws Throwable {
		IIBankDatabaseConnector connector = getConnector();
		if(connector == null)
			return -1;
		return connector.deleteRows(table);
	}

	/**
	 * Delete rows.
	 *
	 * @param table the table
	 * @param connector the connector
	 * @return the int
	 * @throws Throwable the throwable
	 */
	public final int deleteRows(String table, IIBankDatabaseConnector connector) throws Throwable {
		return connector.deleteRows(table);
	}

	/* (non-Javadoc)
	 * @see com.IBank.database.IIBankDatabaseConnector#deleteRows(java.lang.String, com.IBank.databaseConnector.criteria.QueryConstraints)
	 */
	public final int deleteRows(String table, QueryConstraints constraints) throws Throwable {
		IIBankDatabaseConnector connector = getConnector();
		if(connector == null)
			return -1;
		return connector.deleteRows(table, constraints);
	}

	/**
	 * Delete rows.
	 *
	 * @param table the table
	 * @param constraints the constraints
	 * @param connector the connector
	 * @return the int
	 * @throws Throwable the throwable
	 */
	public final int deleteRows(String table, QueryConstraints constraints, IIBankDatabaseConnector connector) throws Throwable {
		return connector.deleteRows(table, constraints);
	}
	
	/* (non-Javadoc)
	 * @see com.IBank.database.IIBankDatabaseConnector#store(com.IBank.databaseConnector.transaction.object.IBankTransactionObject)
	 */
	public final boolean store(ContractIQTransactionObject obj) throws Throwable {
		IIBankDatabaseConnector connector = getConnector();
		if(connector == null)
			return false;
		return connector.store(obj);
	}

}
