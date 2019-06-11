package com.intec.ibank.databaseConnector.criteria.update;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.intec.ibank.databaseConnector.criteria.ICriteria;
import com.intec.ibank.databaseConnector.criteria.IParamCriteriaPair;
import com.intec.ibank.databaseConnector.criteria.IWhereCriteria;
import com.intec.ibank.databaseConnector.criteria.QueryConstraints;
import com.intec.ibank.system.SystemConstants;

/**
 * Copyright
 *
 */
public class UpdateConstraints implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public UpdateConstraints() {
		super();
		updateCriteria = new ArrayList<ModificationDataWrapper>();
	}
	
	private List<ModificationDataWrapper> updateCriteria; 
	private QueryConstraints whereCriteria; 

	public static final String getCopyRights() {
		return SystemConstants.COPYRIGHTS;
	}
	
	public void addModificationData(String columnName, Object value){
		updateCriteria.add(new ModificationDataWrapper(columnName, value));
	}
	
	private static class ModificationDataWrapper implements Serializable {
		private static final long serialVersionUID = 1L;
		
		private final Object value;
		private final String columnName;

		private static final String EQUAL_QUERY_KEY = " = ";

		public ModificationDataWrapper(String columnName, Object value){
			super();
			this.columnName = columnName;
			this.value = value;
		}
		
		public IParamCriteriaPair getCriteriaValue(){
			ArrayList<Object> params = new ArrayList<Object>();
			params.add(value);

			String nameValue = columnName + EQUAL_QUERY_KEY + IWhereCriteria.PREPARE_STATEMENT_STRING;
			
			return new ParamCriteriaPair(nameValue, params);
		}

	}	
	
	public void addWhereCriteria(ICriteria crit){
		if(whereCriteria == null)
			whereCriteria = new QueryConstraints();
		whereCriteria.addConstraint(crit);
	}
	
	public void setWhereCriteria(QueryConstraints whereCriteria){
		this.whereCriteria = whereCriteria ;
	}
	
	public QueryConstraints getWhereCriteria(){
		return this.whereCriteria;
	}
	
	public IWhereCriteria getSubWhereCriteriaValue(){
		if(whereCriteria != null)
			return whereCriteria.getSubWhereCriteriaValue();
		return null;
	}
	
	public IParamCriteriaPair getSetValueString(){
		String separatorValue = IParamCriteriaPair.SEPARATOR_STRING;
		
		if(updateCriteria.size() > 0){
			ArrayList<Object> params = new ArrayList<Object>();
			StringBuffer criteria =  new StringBuffer("");
			for(int index = 0;index<updateCriteria.size();index++){
				IParamCriteriaPair critValue = updateCriteria.get(index).getCriteriaValue();
				criteria.append(critValue.getCriteria());
				criteria.append(separatorValue);
				params.addAll(critValue.getParams());
			}
			String critValue = criteria.substring(0, (criteria.length() - separatorValue.length()));
			return new ParamCriteriaPair(critValue, params);
		}
		return null;
	}
	
	public final boolean isCriteriaExists(){
		if ((whereCriteria != null) && (whereCriteria.isCriteriaExists()))
			return true;
		return false;
	}

}
