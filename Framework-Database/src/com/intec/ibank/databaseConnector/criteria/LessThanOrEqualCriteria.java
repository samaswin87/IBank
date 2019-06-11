package com.intec.ibank.databaseConnector.criteria;

/**
 * Copyright
 *
 */
public class LessThanOrEqualCriteria extends SimpleCriteria{
	private static final long serialVersionUID = 1L;

	public LessThanOrEqualCriteria(String columnName, Object value){
		super(columnName, value);
	}
	
	protected String getQueryKey(){
		return " <= ";
	}
}
