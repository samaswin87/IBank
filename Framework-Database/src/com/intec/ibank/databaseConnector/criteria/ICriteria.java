package com.intec.ibank.databaseConnector.criteria;

import java.io.Serializable;

/**
 * Copyright
 *
 */
public interface ICriteria extends Serializable {
	public static String CRITERIA = "Criteria";
	public static String VALUE_NAME = "Value";
	public static String COLUMN_NAME = "columnName";
	
	IWhereCriteria getSubWhereCriteriaValue();
}
