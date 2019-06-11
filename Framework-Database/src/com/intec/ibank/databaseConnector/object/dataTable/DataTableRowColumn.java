package com.intec.ibank.databaseConnector.object.dataTable;

import java.io.Serializable;

import com.intec.ibank.system.SystemConstants;
/**
 * Copyright
 *
 */
public class DataTableRowColumn implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private final Object value;

	public DataTableRowColumn(Object value) {
		super();
		this.value = value;
	}

	public final Object getValue() {
		return value;
	}

	public static final String getCopyRights() {
		return SystemConstants.COPYRIGHTS;
	}

}
