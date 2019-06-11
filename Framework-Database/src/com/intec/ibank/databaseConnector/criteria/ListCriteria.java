package com.intec.ibank.databaseConnector.criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright
 *
 */
public abstract class ListCriteria implements ICriteria{
	private static final long serialVersionUID = 1L;
	
	private final Object[] value;
	private final String columnName;

	public ListCriteria(String columnName, List<? extends Object> value){
		super();
		this.columnName = columnName;
		this.value = value.toArray();
	}

	public ListCriteria(String columnName, Object[] value){
		super();
		this.columnName = columnName;
		this.value = value;
	}
	
	protected abstract String getCriteriaString();
	
	public final IWhereCriteria getSubWhereCriteriaValue(){
		String separatorValue = IParamCriteriaPair.SEPARATOR_STRING;
		
		if((value == null ) || (value.length ==0))
			return null;

		ArrayList<Object> params = new ArrayList<Object>();

		String nameValue = columnName + " " + getCriteriaString() + " ( ";
		StringBuffer psString = new StringBuffer("");
		for (int index = 0; index < value.length; index++) { 
			psString.append(IWhereCriteria.PREPARE_STATEMENT_STRING);
			psString.append(separatorValue);
			params.add(value[index]);
		}
		nameValue += psString.substring(0, (psString.length() - separatorValue.length())) + " )";
		
		return new WhereCriteria(nameValue, params);
	}

}
