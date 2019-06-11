package com.intec.ibank.databaseConnector.criteria;

/**
 * Copyright
 *
 */
public class EqualCriteria extends SimpleCriteria{
	private static final long serialVersionUID = 1L;

	public EqualCriteria(String columnName, Object value){
		super(columnName, value);
	}
	
	protected String getQueryKey(){
		return " = ";
	}
}
