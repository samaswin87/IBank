package com.intec.ibank.databaseConnector.object.dataTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.intec.ibank.system.SystemConstants;
/**
 * Copyright
 *
 */
public class DataTableRow implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private final List<DataTableRowColumn> columns;

	public DataTableRow(DataTableRowColumn[] columns) {
		super();
		this.columns = new ArrayList<DataTableRowColumn>();
		addColumns(columns);
	}

	public DataTableRow(List<DataTableRowColumn> columns) {
		super();
		this.columns = new ArrayList<DataTableRowColumn>(columns);
	}

	public static final String getCopyRights() {
		return SystemConstants.COPYRIGHTS;
	}
	
	private void addColumns(DataTableRowColumn[] columns){
		if(columns != null){
			for(int index = 0;index<columns.length;index++){
				this.columns.add(columns[index]);
			}
		}
	}
	
	public DataTableRowColumn[] getColumns(){
		DataTableRowColumn[] cols = columns.toArray(new DataTableRowColumn[0]);
		return cols;
	}

}
