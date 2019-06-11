package com.intec.ibank.utils;

 
public enum Months{
	
	JANUARY ("January"),
	FEBRUARY ("February"),
	MARCH ("March"),
	APRIL ("April"),
	MAY ("May"),
	JUNE ("June"),
	JULY ("July"),
	AUGUST ("August"),
	SEPTEMBER ("September"),
	OCTOBER ("October"),
	NOVEMBER ("November"),
	DECEMBER ("December");
    
	private String value;
	
	Months(String value)
	{
		this.value = value;
	}
	public String getValue()
	{
		return this.value;
	}
	

}
