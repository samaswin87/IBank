package com.intec.ibank.databaseConnector.object;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.intec.ibank.system.SystemConstants;
/**
 * Copyright
 *
 */
public class DataRow implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<DataColumn> columns;

	public DataRow() {
		super();
		columns = new ArrayList<DataColumn>();
	}

	public static final String getCopyRights() {
		return SystemConstants.COPYRIGHTS;
	}
	
	public void addColumn(String columnName, Object value){
		DataColumn column = new DataColumn(columnName, value);
		columns.add(column);
	}
	
	public DataColumn[] getColumns(){
		DataColumn[] cols = columns.toArray(new DataColumn[0]);
		return cols;
	}
}
