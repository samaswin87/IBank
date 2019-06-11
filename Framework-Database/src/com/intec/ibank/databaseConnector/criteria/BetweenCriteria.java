package com.intec.ibank.databaseConnector.criteria;


public class BetweenCriteria extends SimpleBetweenCriteria{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new like criteria.
	 *
	 * @param columnName the column name
	 * @param value the value
	 */
	public BetweenCriteria(String columnName, Object fromValue, Object toValue){
		super(columnName, fromValue, toValue);
	}
	
	/* (non-Javadoc)
	 * @see com.IBank.databaseConnector.criteria.SimpleCriteria#getQueryKey()
	 */
	protected String getQueryKey(){
		return " BETWEEN ";
	}
}
