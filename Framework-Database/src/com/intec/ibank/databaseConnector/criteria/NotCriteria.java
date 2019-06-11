package com.intec.ibank.databaseConnector.criteria;

import java.util.List;

import com.intec.ibank.system.SystemConstants;

/**
 * Copyright
 * 
 * The Class for Not Criteria.
 */
public class NotCriteria implements ICriteria{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The criteria. */
	private final ICriteria criteria;

	/**
	 * Instantiates a new not criteria.
	 *
	 * @param criteria the criteria
	 */
	public NotCriteria(ICriteria criteria){
		super();
		this.criteria = criteria;
	}
	
	/* (non-Javadoc)
	 * @see com.IBank.databaseConnector.criteria.ICriteria#getSubWhereCriteriaValue()
	 */
	public final IWhereCriteria getSubWhereCriteriaValue(){
		IWhereCriteria whereCrit = criteria.getSubWhereCriteriaValue();
		List<Object> params = whereCrit.getParams();
		String query = " Not ( " + whereCrit.getCriteria() + " ) "; 
		return new WhereCriteria(query, params);
	}

	/**
	 * Gets the copy rights.
	 *
	 * @return the copy rights
	 */
	public static final String getCopyRights() {
		return SystemConstants.COPYRIGHTS;
	}
}
