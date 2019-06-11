package com.intec.ibank.databaseConnector.criteria.select.union;

import java.io.Serializable;

import com.intec.ibank.databaseConnector.criteria.select.SelectConstraints;
/**
 * Copyright
 *
 */
public interface ISelectQuery extends Serializable {
	String getTableName();
	SelectConstraints getSelectConstraint();
}
