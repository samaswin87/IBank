package com.intec.ibank.database.query;

import java.util.ArrayList;
import java.util.List;

import com.intec.ibank.databaseConnector.criteria.IParamCriteriaPair;
import com.intec.ibank.databaseConnector.criteria.IWhereCriteria;
import com.intec.ibank.databaseConnector.criteria.QueryConstraints;
import com.intec.ibank.databaseConnector.criteria.WhereCriteria;
import com.intec.ibank.databaseConnector.criteria.select.union.ISelectQuery;
import com.intec.ibank.databaseConnector.criteria.select.union.UnionConstraint;
import com.intec.ibank.databaseConnector.criteria.update.ParamCriteriaPair;
import com.intec.ibank.databaseConnector.criteria.update.UpdateConstraints;
import com.intec.ibank.databaseConnector.object.DataColumn;
import com.intec.ibank.databaseConnector.object.DataRow;
import com.intec.ibank.system.SystemConstants;

/**
 * Copyright.
 * 
 * Query Generator Class
 */
public abstract class QueryGenerator implements IQueryGenerator{

	/**
	 * Gets the copy rights.
	 *
	 * @return the copy rights
	 */
	public static final String getCopyRights() {
		return SystemConstants.COPYRIGHTS;
	}
	
	/**
	 * Instantiates a new query generator.
	 */
	public QueryGenerator(){
		super();
	}
	
	/**
	 * Gets the param criteria pair.
	 *
	 * @param query the query
	 * @param params the params
	 * @return the param criteria pair
	 */
	protected final ParamCriteriaPair getParamCriteriaPair(String query, List<Object> params){
		return new ParamCriteriaPair(query, params);
	}

	/**
	 * Gets the where criteria.
	 *
	 * @param constraints the constraints
	 * @return the where criteria
	 */
	protected final IWhereCriteria getWhereCriteria(QueryConstraints constraints){
		if (constraints != null) {
			IWhereCriteria crit = constraints.getSubWhereCriteriaValue();
			if (crit != null) {
				List<Object> params = crit.getParams();
				String query = IWhereCriteria.WHERE_CONDITION
						+ crit.getCriteria();
				return new WhereCriteria(query, params);
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.IBank.database.query.IQueryGenerator#getSelectQuery(java.lang.String)
	 */
	@Override
	public final ParamCriteriaPair getSelectQuery(String table){
		return this.getSelectQuery(table, (QueryConstraints)null);
	}

	/* (non-Javadoc)
	 * @see com.IBank.database.query.IQueryGenerator#getSelectQuery(com.IBank.databaseConnector.criteria.select.union.UnionConstraint)
	 */
	@Override
	public final ParamCriteriaPair getSelectQuery(UnionConstraint constraints){
		String queryKey = constraints.getQueryKey();
		
		ISelectQuery[] selectConstraints = constraints.getConstraints();
		
		List<Object> params = new ArrayList<Object>();
		StringBuffer query = new StringBuffer(""); 
		
		if((selectConstraints != null) && (selectConstraints.length > 1)){
			for(int index = 0;index<selectConstraints.length;index++){
				ISelectQuery selectConstraint = selectConstraints[index];
				ParamCriteriaPair selectCrit = getSelectQuery(selectConstraint.getTableName(), selectConstraint.getSelectConstraint());
				if(selectCrit != null){
					params.addAll(selectCrit.getParams());
					query.append("(");
					query.append(selectCrit.getCriteria());
					query.append(")");
					query.append(queryKey);
				}
			}
			String criteria = query.substring(0, (query.length() - queryKey.length()));
			
			criteria += constraints.getOrderByValue();
			int offset = constraints.getOffset();
			int rows = constraints.getRows();
			if(rows > 0){
				if(offset < 0)
					offset = 0;
				if(offset == 0)
					criteria += " LIMIT " + rows;
				else
					criteria += " LIMIT " + offset + ", " + rows;
			}

			return getParamCriteriaPair(criteria, params);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.IBank.database.query.IQueryGenerator#getCreateQuery(java.lang.String, com.IBank.databaseConnector.object.DataRow)
	 */
	@Override
	public final ParamCriteriaPair getCreateQuery(String table, DataRow rowValue){

		StringBuffer nameStrBuffer = new StringBuffer("");
		StringBuffer valueStrBuffer = new StringBuffer("");
		ArrayList<Object> params = new ArrayList<Object>();

		DataColumn[] columns = rowValue.getColumns();

		for (int index = 0; index < columns.length; index++) {
			DataColumn column = columns[index];
			String name = column.getColumnName();
			Object value = column.getValue();
			nameStrBuffer.append(name);
			nameStrBuffer.append(IWhereCriteria.SEPARATOR_STRING);
			params.add(value);

			valueStrBuffer.append(IWhereCriteria.PREPARE_STATEMENT_STRING);
			valueStrBuffer.append(IWhereCriteria.SEPARATOR_STRING);
		}
	
		String namePart = nameStrBuffer.substring(0, nameStrBuffer.length() -1);
		String valuePart = valueStrBuffer.substring(0, valueStrBuffer.length() -1);
	
	
		String query = "insert into " + table +" (" + namePart + ") Values(" + valuePart + ")";

		return getParamCriteriaPair(query, params);
	}

	/* (non-Javadoc)
	 * @see com.IBank.database.query.IQueryGenerator#getUpdateQuery(java.lang.String, com.IBank.databaseConnector.criteria.update.UpdateConstraints)
	 */
	@Override
	public final ParamCriteriaPair getUpdateQuery(String table, UpdateConstraints constraints){
		String query = "update " + table + " set ";// + " where id = " + id;

		List<Object> params = null;

		IParamCriteriaPair setValueCrit = constraints.getSetValueString();
		params = setValueCrit.getParams();
		query += setValueCrit.getCriteria();

		IWhereCriteria crit = getWhereCriteria(constraints.getWhereCriteria());
		if (crit != null) {
			params.addAll(crit.getParams());
			query += crit.getCriteria();
		}

		return getParamCriteriaPair(query, params);
	}

	/* (non-Javadoc)
	 * @see com.IBank.database.query.IQueryGenerator#getDeleteQuery(java.lang.String, com.IBank.databaseConnector.criteria.QueryConstraints)
	 */
	@Override
	public final ParamCriteriaPair getDeleteQuery(String table, QueryConstraints constraints){
		String query = "delete from " + table;// + " where id = " + id;
		
		List<Object> params = null;
		if(constraints != null){
			IWhereCriteria crit = getWhereCriteria(constraints);
			if(crit != null){
				params = crit.getParams();
				query += crit.getCriteria();
			}
		}

		return getParamCriteriaPair(query, params);
	}
}
