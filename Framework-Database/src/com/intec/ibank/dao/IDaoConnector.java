package com.intec.ibank.dao;

import com.intec.ibank.database.IIBankDatabaseConnector;

/**
 * Copyright.
 * 
 * This is used as a connector to hold 
 * the connection resources via either Client or Direct Implementation   
 */
public interface IDaoConnector {
	
	/**
	 * Gets the retrieval connector.
	 *
	 * @return the retrieval connector
	 */
	public IIBankDatabaseConnector getRetrievalConnector();
	
	/**
	 * Gets the creates the connector.
	 *
	 * @return the creates the connector
	 */
	public IIBankDatabaseConnector getCreateConnector();
	
	/**
	 * Gets the update connector.
	 *
	 * @return the update connector
	 */
	public IIBankDatabaseConnector getUpdateConnector();
	
	/**
	 * Gets the delete connector.
	 *
	 * @return the delete connector
	 */
	public IIBankDatabaseConnector getDeleteConnector();
	
	/**
	 * Gets the transaction connector.
	 *
	 * @return the transaction connector
	 */
	public IIBankDatabaseConnector getTransactionConnector();
}
