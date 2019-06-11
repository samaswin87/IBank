package com.intec.ibank.databaseConnector.object.dataTable;

import java.io.Serializable;

import com.intec.ibank.system.SystemConstants;

/**
 * Copyright
 *
 */
public class DataTableHeaderRowColumn implements Serializable{
	private static final long serialVersionUID = 1L;
	private final String name;
	private final String columnType;

	public DataTableHeaderRowColumn(String name, String columnType) {
		super();
		this.name = name;
		this.columnType = columnType;
	}

	public String getName() {
		return name;
	}

	public String getColumnType() {
		return columnType;
	}

	public static final String getCopyRights() {
		return SystemConstants.COPYRIGHTS;
	}

}
