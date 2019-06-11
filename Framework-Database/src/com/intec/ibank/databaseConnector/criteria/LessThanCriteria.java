package com.intec.ibank.databaseConnector.criteria;

/**
 * Copyright
 *
 */
public class LessThanCriteria extends SimpleCriteria{
	private static final long serialVersionUID = 1L;

	public LessThanCriteria(String columnName, Object value){
		super(columnName, value);
	}
	
	protected String getQueryKey(){
		return " < ";
	}
}
