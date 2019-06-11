package com.intec.ibank.databaseConnector.criteria;

import java.util.ArrayList;
/**
 * Copyright
 *
 */
public abstract class SimpleBetweenCriteria implements ICriteria{
	private static final long serialVersionUID = 1L;
	
	private final Object fromValue;
	private final Object toValue;
	private final String columnName;
	

	

	public SimpleBetweenCriteria(String columnName, Object fromValue, Object toValue){
		super();
		this.columnName = columnName;
		this.fromValue = fromValue;
		this.toValue = toValue;
	}
	
	protected abstract String getQueryKey();  
	
	public final IWhereCriteria getSubWhereCriteriaValue(){
		ArrayList<Object> params = new ArrayList<Object>();
		params.add(fromValue);
		params.add(toValue);

		String nameValue = columnName + getQueryKey() + IWhereCriteria.PREPARE_STATEMENT_STRING + "AND" + IWhereCriteria.PREPARE_STATEMENT_STRING;
		
		return new WhereCriteria(nameValue, params);
	}

}
