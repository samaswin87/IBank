package com.intec.ibank.databaseConnector.criteria;

/**
 * Copyright
 *
 */
public class GreaterThanCriteria extends SimpleCriteria{
	private static final long serialVersionUID = 1L;

	public GreaterThanCriteria(String columnName, Object value){
		super(columnName, value);
	}
	
	protected String getQueryKey(){
		return " > ";
	}
}
