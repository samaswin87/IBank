package com.intec.ibank.databaseConnector.object;

import java.io.Serializable;

import com.intec.ibank.system.SystemConstants;
/**
 * Copyright
 *
 */
public class DataColumn implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private final Object value;
	private final String columnName;

	public DataColumn(String columnName, Object value) {
		super();
		this.columnName = columnName;
		this.value = value;
	}

	public static final String getCopyRights() {
		return SystemConstants.COPYRIGHTS;
	}

	public Object getValue() {
		return value;
	}

	public String getColumnName() {
		return columnName;
	}
}
