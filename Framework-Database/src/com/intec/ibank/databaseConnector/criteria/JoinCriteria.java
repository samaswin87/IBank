package com.intec.ibank.databaseConnector.criteria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.intec.ibank.utils.Utilities;

/**
 * Copyright
 *
 */
public abstract class JoinCriteria implements ICriteria, Serializable

{
	private static final long serialVersionUID = 1L;
	private List<ICriteria> crits;
	public JoinCriteria() {
		super();
		crits = new ArrayList<ICriteria>();
	}
	
	public final void addCriteria(ICriteria crit){
		crits.add(crit);
	}
	
	protected abstract String getQueryName();
	
	public final boolean isCriteriaExists(){
		return ((crits != null) && (crits.size() > 0));
	}
	
	public IWhereCriteria getSubWhereCriteriaValue(){
		if(isCriteriaExists()){
			ArrayList<Object> params = new ArrayList<Object>();
			String queryName = getQueryName();
			StringBuffer namePart = new StringBuffer("");
			for(int index = 0;index<crits.size();index++){
				ICriteria childCrit = crits.get(index);
				IWhereCriteria childCritValues = childCrit.getSubWhereCriteriaValue();
				if(childCritValues != null){
					params.addAll(childCritValues.getParams());
					namePart.append(childCritValues.getCriteria()); 
					namePart.append(" " + queryName + " ");
				}
			}
			String nameValue =  namePart.toString();
			if(!Utilities.isEmptyValue(nameValue)){
				nameValue = " ( " + nameValue.substring(0, namePart.length() - (queryName.length() + 1)) + " ) ";
				return new WhereCriteria(nameValue, params);
			}
		}
		return null;
	}

}
