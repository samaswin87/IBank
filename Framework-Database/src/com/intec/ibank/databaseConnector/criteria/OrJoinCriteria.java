package com.intec.ibank.databaseConnector.criteria;

/**
 * Copyright
 *
 */
class OrJoinCriteria extends JoinCriteria{
	private static final long serialVersionUID = 1L;

	public OrJoinCriteria() {
		super();
	}
	
	protected String getQueryName(){
		return "OR";
	}

}
