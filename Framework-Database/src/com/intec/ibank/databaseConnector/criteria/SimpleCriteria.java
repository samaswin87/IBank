package com.intec.ibank.databaseConnector.criteria;

import java.util.ArrayList;
/**
 * Copyright
 *
 */
public abstract class SimpleCriteria implements ICriteria{
	private static final long serialVersionUID = 1L;
	
	private final Object value;
	private final String columnName;

	

	public SimpleCriteria(String columnName, Object value){
		super();
		this.columnName = columnName;
		this.value = value;
	}
	
	protected abstract String getQueryKey();  
	
	public final IWhereCriteria getSubWhereCriteriaValue(){
		ArrayList<Object> params = new ArrayList<Object>();
		params.add(value);

		String nameValue = columnName + getQueryKey() + IWhereCriteria.PREPARE_STATEMENT_STRING;
		
		return new WhereCriteria(nameValue, params);
	}

}
