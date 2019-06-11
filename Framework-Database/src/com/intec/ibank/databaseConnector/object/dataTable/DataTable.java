package com.intec.ibank.databaseConnector.object.dataTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.intec.ibank.system.SystemConstants;
/**
 * Copyright
 *
 */
public class DataTable implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private final List<DataTableRow> rows;
	private final DataTableHeaderRow headerRow;

	public DataTable(DataTableHeaderRow headerRow, DataTableRow[] rows) {
		super();
		this.headerRow = headerRow;
		this.rows = new ArrayList<DataTableRow> ();
		addRows(rows);
	}

	public DataTable(DataTableHeaderRow headerRow, List<DataTableRow> rows) {
		super();
		this.headerRow = headerRow;
		this.rows = new ArrayList<DataTableRow> (rows);
	}
	
	public DataTableHeaderRow getHeaderRow() {
		return headerRow;
	}
	
	private void addRows(DataTableRow[] rows){
		if(rows != null){
			for(int index = 0;index<rows.length;index++){
				this.rows.add(rows[index]);
			}
		}
		
	}

	public DataTableRow[] getRows(){
		DataTableRow[] tableRows = rows.toArray(new DataTableRow[0]);
		return tableRows;
	}

	public boolean isRowsAvailable(){
		return (rows.size() > 0);
	}

	public static final String getCopyRights() {
		return SystemConstants.COPYRIGHTS;
	}

}
