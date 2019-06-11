package com.intec.ibank.databaseConnector.criteria.update;

import java.util.List;

import com.intec.ibank.databaseConnector.criteria.IParamCriteriaPair;
/**
 * Copyright
 *
 */
public class ParamCriteriaPair implements IParamCriteriaPair{
	private static final long serialVersionUID = 1L;

	
	private List<Object> params;
	private String criteria;
	
	public ParamCriteriaPair(String criteria, List<Object> params){
		this.params = params;
		this.criteria = criteria;
	}

	public List<Object> getParams(){
		return params;
	}
	public String getCriteria(){
		return criteria;
	}

}
