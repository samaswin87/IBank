package com.intec.ibank.databaseConnector.criteria;

import java.util.List;

/**
 * Copyright
 *
 */
public class InCriteria extends ListCriteria{
	private static final long serialVersionUID = 1L;
	
	public InCriteria(String columnName, List<? extends Object> value){
		super(columnName, value);
	}

	public InCriteria(String columnName, Object[] value){
		super(columnName, value);
	}

	protected String getCriteriaString(){
		return " IN ";
	}
	
}
