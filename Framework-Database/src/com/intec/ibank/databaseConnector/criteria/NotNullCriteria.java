package com.intec.ibank.databaseConnector.criteria;

import java.util.ArrayList;
/**
 * Copyright
 *
 */
public class NotNullCriteria implements ICriteria{
	private static final long serialVersionUID = 1L;
	
	private final String columnName;

	

	public NotNullCriteria(String columnName){
		super();
		this.columnName = columnName;
	}
	
	private String getQueryKey(){
		return " IS NOT NULL ";
	}
	
	public final IWhereCriteria getSubWhereCriteriaValue(){
		ArrayList<Object> params = new ArrayList<Object>();

		String nameValue = columnName + getQueryKey();
		
		return new WhereCriteria(nameValue, params);
	}

}
