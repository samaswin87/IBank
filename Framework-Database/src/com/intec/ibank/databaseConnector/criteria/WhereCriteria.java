package com.intec.ibank.databaseConnector.criteria;

import java.util.List;

import com.intec.ibank.system.SystemConstants;
/**
 * Copyright
 *
 */
public class WhereCriteria implements IWhereCriteria{
	private static final long serialVersionUID = 1L;
	
	private List<Object> params;
	private String criteria;
	public WhereCriteria(String criteria, List<Object> params){
		this.criteria = criteria;
		this.params = params;
	}
	public final List<Object> getParams() {
		return params;
	}
	public final String getCriteria() {
		return criteria;
	}

	public static final String getCopyRights() {
		return SystemConstants.COPYRIGHTS;
	}

}
