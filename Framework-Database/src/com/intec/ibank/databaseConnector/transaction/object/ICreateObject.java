package com.intec.ibank.databaseConnector.transaction.object;

import java.io.Serializable;

import com.intec.ibank.databaseConnector.object.DataRow;

/**
 * Copyright
 *
 * The Interface ICreateObject.
 */
public interface ICreateObject extends Serializable, ITransactionObject {
	
	/**
	 * Gets the table name.
	 *
	 * @return the table name
	 */
	public String getTableName(); 
	
	/**
	 * Gets the row value.
	 *
	 * @return the row value
	 */
	public DataRow getRowValue(); 
}
