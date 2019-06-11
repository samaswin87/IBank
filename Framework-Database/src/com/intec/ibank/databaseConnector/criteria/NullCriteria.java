package com.intec.ibank.databaseConnector.criteria;

import java.util.ArrayList;
/**
 * Copyright
 *
 */
public class NullCriteria implements ICriteria{
	private static final long serialVersionUID = 1L;
	
	private final String columnName;

	

	public NullCriteria(String columnName){
		super();
		this.columnName = columnName;
	}
	
	private String getQueryKey(){
		return " IS NULL ";
	}
	
	public final IWhereCriteria getSubWhereCriteriaValue(){
		ArrayList<Object> params = new ArrayList<Object>();

		String nameValue = columnName + getQueryKey();
		
		return new WhereCriteria(nameValue, params);
	}

}
