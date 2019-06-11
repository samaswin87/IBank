package com.intec.ibank.databaseConnector.criteria;

/**
 * Copyright
 *
 */
public class GreaterThanOrEqualCriteria extends SimpleCriteria{
	private static final long serialVersionUID = 1L;

	public GreaterThanOrEqualCriteria(String columnName, Object value){
		super(columnName, value);
	}
	
	protected String getQueryKey(){
		return " >= ";
	}
}
