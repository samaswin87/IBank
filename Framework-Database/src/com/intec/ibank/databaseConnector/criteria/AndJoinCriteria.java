package com.intec.ibank.databaseConnector.criteria;

/**
 * Copyright
 *
 */
public class AndJoinCriteria extends JoinCriteria{
	private static final long serialVersionUID = 1L;

	public AndJoinCriteria() {
		super();
	}
	
	protected String getQueryName(){
		return "AND";
	}
}
