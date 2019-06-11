package com.intec.ibank.databaseConnector.criteria;

/**
 * Copyright
 *
 * The Class LikeCriteria.
 */
public class LikeCriteria extends SimpleCriteria{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new like criteria.
	 *
	 * @param columnName the column name
	 * @param value the value
	 */
	public LikeCriteria(String columnName, Object value){
		super(columnName, value);
	}
	
	/* (non-Javadoc)
	 * @see com.IBank.databaseConnector.criteria.SimpleCriteria#getQueryKey()
	 */
	protected String getQueryKey(){
		return " LIKE ";
	}
}
