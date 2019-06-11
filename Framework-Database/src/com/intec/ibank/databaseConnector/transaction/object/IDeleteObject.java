package com.intec.ibank.databaseConnector.transaction.object;

import java.io.Serializable;

import com.intec.ibank.databaseConnector.criteria.QueryConstraints;

/**
 * Copyright
 *
 * The Interface IDeleteObject.
 */
public interface IDeleteObject extends Serializable, ITransactionObject {
	
	/**
	 * Gets the table name.
	 *
	 * @return the table name
	 */
	public String getTableName(); 
	
	/**
	 * Gets the constraints.
	 *
	 * @return the constraints
	 */
	QueryConstraints getConstraints();
}
