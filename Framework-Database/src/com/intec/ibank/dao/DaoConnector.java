package com.intec.ibank.dao;

import com.intec.ibank.database.IIBankDatabaseConnector;

/**
 * Copyright.
 * 
 * This is used as a connector to hold 
 * the connection resources via either Client or Direct Implementation   
 */
public final class DaoConnector implements IDaoConnector{   
	
	private IIBankDatabaseConnector connector; 

	/**
	 * Instantiates a new dao connector.
	 */
	public DaoConnector() {
	}

	/* (non-Javadoc)
	 * @see com.IBank.dao.IDaoConnector#getRetrievalConnector()
	 */
	public final IIBankDatabaseConnector getRetrievalConnector(){
		return connector;
	}

	public final void setConnector(IIBankDatabaseConnector connector) {
		this.connector = connector;
	}

	/* (non-Javadoc)
	 * @see com.IBank.dao.IDaoConnector#getCreateConnector()
	 */
	public final IIBankDatabaseConnector getCreateConnector(){
		return connector;
	}


	/* (non-Javadoc)
	 * @see com.IBank.dao.IDaoConnector#getUpdateConnector()
	 */
	public final IIBankDatabaseConnector getUpdateConnector(){
		return connector;
	}


	/* (non-Javadoc)
	 * @see com.IBank.dao.IDaoConnector#getDeleteConnector()
	 */
	public final IIBankDatabaseConnector getDeleteConnector(){
		return connector;
	}


	/* (non-Javadoc)
	 * @see com.IBank.dao.IDaoConnector#getTransactionConnector()
	 */
	public final IIBankDatabaseConnector getTransactionConnector(){
		return connector;
	}

}
