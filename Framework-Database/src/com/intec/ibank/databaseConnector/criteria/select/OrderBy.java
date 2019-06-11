package com.intec.ibank.databaseConnector.criteria.select;


/**
 * Copyright
 *
 */
public enum OrderBy{
	
	ASCENDING ("ASC"),
    DESCENDING ("DESC");
	private String value;
	OrderBy(String value)
	{
		this.value = value;
	}
	public String getValue()
	{
		return this.value;
	}
	

}
