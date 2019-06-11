package com.intec.ibank.databaseConnector.criteria;

import java.io.Serializable;
import java.util.List;
/**
 * Copyright
 *
 */
public interface IParamCriteriaPair extends Serializable{
	public static final String PREPARE_STATEMENT_STRING = "?";
	public static final String SEPARATOR_STRING = ",";
	
	public List<Object> getParams();
	public String getCriteria();

}
