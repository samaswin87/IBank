package com.intec.ibank.databaseConnector.criteria.select;

import java.io.Serializable;
/**
 * Copyright
 *
 */
public enum SelectOption implements Serializable {
	All ("ALL"),
    DISTINCT ("DISTINCT"),
    DISTINCTROW ("DISTINCTROW");

	private String value;
	SelectOption(String value){
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
}
