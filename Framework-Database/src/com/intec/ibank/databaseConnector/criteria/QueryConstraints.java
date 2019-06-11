package com.intec.ibank.databaseConnector.criteria;

import java.io.Serializable;

import com.intec.ibank.log.IBankLogger;
import com.intec.ibank.system.SystemConstants;
import com.intec.ibank.utils.Utilities;
/**
 * Copyright
 *
 */
public class QueryConstraints implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private JoinCriteria criteria; 

	public QueryConstraints() {
		super();
	}

	public static final String getCopyRights() {
		return SystemConstants.COPYRIGHTS;
	}
	
	public void addConstraint(ICriteria crit){
		if(criteria == null)
			criteria = RestrictionCriteria.andCriteria();
		criteria.addCriteria(crit);
	}
	
	public void setCriteria(JoinCriteria criteria){
		this.criteria = criteria ;
	}
	
	public IWhereCriteria getSubWhereCriteriaValue(){
		if(criteria != null)
			return criteria.getSubWhereCriteriaValue();
		return null;
	}
	
	public final boolean isCriteriaExists(){
		if ((criteria != null) && (criteria.isCriteriaExists()))
			return true;
		return false;
	}
	
	public String getXmlString(){
		try{
			return Utilities.getXmlString(this, null);
		}catch(Exception ex){
			IBankLogger.log(ex);
		}
		return "";
	}

}
