package com.intec.ibank.databaseConnector.object.dataTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.intec.ibank.system.SystemConstants;
/**
 * Copyright
 *
 */
public class DataTableHeaderRow implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private final List<DataTableHeaderRowColumn> columns;

	public DataTableHeaderRow(DataTableHeaderRowColumn[] columns) {
		super();
		this.columns = new ArrayList<DataTableHeaderRowColumn>();
		addColumns(columns);
	}

	public DataTableHeaderRow(List<DataTableHeaderRowColumn> columns) {
		super();
		this.columns = new ArrayList<DataTableHeaderRowColumn>(columns);
	}

	public static final String getCopyRights() {
		return SystemConstants.COPYRIGHTS;
	}
	
	private void addColumns(DataTableHeaderRowColumn[] columns){
		if(columns != null){
			for(int index = 0;index<columns.length;index++){
				this.columns.add(columns[index]);
			}
		}
	}

	/*
	public void addColumn(String name, String columnType){
		DataTableHeaderRowColumn column = new DataTableHeaderRowColumn(name, columnType);
		columns.add(column);
	}
	*/
	
	public DataTableHeaderRowColumn[] getColumns(){
		DataTableHeaderRowColumn[] cols = columns.toArray(new DataTableHeaderRowColumn[0]);
		return cols;
	}

}
