package com.intec.ibank.databaseConnector.criteria;

import java.util.List;

/**
 * Copyright
 *
 */
public class NotInCriteria extends ListCriteria{
	private static final long serialVersionUID = 1L;
	
	public NotInCriteria(String columnName, List<? extends Object> value){
		super(columnName, value);
	}

	public NotInCriteria(String columnName, Object[] value){
		super(columnName, value);
	}

	protected String getCriteriaString(){
		return " NOT IN ";
	}
	
}
