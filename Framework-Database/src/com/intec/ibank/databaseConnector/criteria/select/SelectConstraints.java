package com.intec.ibank.databaseConnector.criteria.select;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.intec.ibank.databaseConnector.criteria.ICriteria;
import com.intec.ibank.databaseConnector.criteria.IParamCriteriaPair;
import com.intec.ibank.databaseConnector.criteria.IWhereCriteria;
import com.intec.ibank.databaseConnector.criteria.QueryConstraints;
import com.intec.ibank.system.SystemConstants;
import com.intec.ibank.utils.Utilities;

// TODO: Auto-generated Javadoc
/**
 * Copyright
 *
 * The Class to feed Select Constraints.
 */
public class SelectConstraints implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The expressions. */
	private List<SelectExpression> expressions; 
	
	/** The where criteria. */
	private QueryConstraints whereCriteria;
	
	/** The option. */
	private SelectOption option;

	/** The group by. */
	private List<String> groupBy;
	
	/** The order by. */
	private List<OrderByExpression> orderBy; 
	
	/** The offset. */
	private int offset;
	
	/** The rows. */
	private int rows;
	
	/** The having. */
	private List<String> having;
	
	/** The sumexpression. */
	private List<String> sumexpression;
	
	/** The avgexpression. */
	private List<String> avgexpression;
	
	private List<String> max;

	/**
	 * Instantiates a new select constraints.
	 */
	public SelectConstraints() {
		super();
		expressions = null;
		whereCriteria = null;
		option = null;
		
		groupBy = null;
		orderBy = null;
		having = null;
		sumexpression = null;
		avgexpression = null;
		max = null;
	}

	/**
	 * Instantiates a new select constraints.
	 *
	 * @param option the option
	 */
	public SelectConstraints(SelectOption option) {
		this();
		this.option = option;
	}

	/**
	 * Instantiates a new select constraints.
	 *
	 * @param whereCriteria the where criteria
	 */
	public SelectConstraints(QueryConstraints whereCriteria) {
		this();
		this.whereCriteria = whereCriteria;
	}
	
	/**
	 * Gets the offset.
	 *
	 * @return the offset
	 */
	public final int getOffset() {
		return offset;
	}

	/**
	 * Sets the offset.
	 *
	 * @param offset the new offset
	 */
	public final void setOffset(int offset) {
		this.offset = offset;
	}

	/**
	 * Gets the rows.
	 *
	 * @return the rows
	 */
	public final int getRows() {
		return rows;
	}

	/**
	 * Sets the rows.
	 *
	 * @param rows the new rows
	 */
	public final void setRows(int rows) {
		this.rows = rows;
	}

	/**
	 * Adds the select expression.
	 *
	 * @param expression the expression
	 */
	public void addSelectExpression(String expression){
		addSelectExpression(expression, null);
	}
	
	/**
	 * Adds the sum select expression.
	 *
	 * @param expression the expression
	 */
	public void addSumSelectExpression(String expression){
		
		if(sumexpression == null)
			sumexpression = new ArrayList<String>();
		sumexpression.add(expression);
	}
	
	/**
	 * Adds the select average expression.
	 *
	 * @param expression the expression
	 */
	public void addSelectAverageExpression(String expression){
			
			if(avgexpression == null)
				avgexpression = new ArrayList<String>();
			avgexpression.add(expression);
	}


	/**
	 * Adds the select expression.
	 *
	 * @param expression the expression
	 * @param aliasName the alias name
	 */
	public void addSelectExpression(String expression, String aliasName){
		if(expressions == null)
			expressions = new ArrayList<SelectExpression>();
		expressions.add(new SelectExpression(expression, aliasName));
	}
	
	public void addMaxExpression(String expression){
		
		if(max == null)
			max = new ArrayList<String>();
		max.add(expression);
}

	/**
	 * Adds the group by expression.
	 *
	 * @param expression the expression
	 */
	public void addGroupByExpression(String expression){
		if(groupBy == null)
			groupBy = new ArrayList<String>();
		groupBy.add(expression);
	}
	
	/**
	 * Adds the group by having expression.
	 *
	 * @param expression the expression
	 */
	public void addGroupByHavingExpression(String expression){
		if(having == null)
			having = new ArrayList<String>();
		having.add(expression);
	}

	/**
	 * Adds the order by.
	 *
	 * @param expression the expression
	 * @param value the value
	 */
	public void addOrderBy(String expression, OrderBy value){
		if(value == null)
			return;
		if(orderBy == null)
			orderBy = new ArrayList<OrderByExpression>();
		orderBy.add(new OrderByExpression(expression, value));
	}
	
	/**
	 * The Class SelectExpression.
	 */
	private static class SelectExpression implements Serializable {
		
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;
		
		/** The alias name. */
		private final String aliasName;
		
		/** The expression. */
		private final String expression;

		/**
		 * Instantiates a new select expression.
		 *
		 * @param expression the expression
		 * @param aliasName the alias name
		 */
		public SelectExpression(String expression, String aliasName){
			super();
			this.expression = expression;
			this.aliasName = aliasName;
		}
		
		/**
		 * Gets the expression value.
		 *
		 * @return the expression value
		 */
		public String getExpressionValue(){
			String expressionValue = expression;
			if(!Utilities.isEmptyValue(aliasName))
				expressionValue += " AS "+ aliasName;
			return expressionValue;
		}

	}	
	
	/**
	 * The Class OrderByExpression.
	 */
	private static class OrderByExpression implements Serializable {
		
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;
		
		/** The value. */
		private final String value;
		
		/** The expression. */
		private final String expression;

		/**
		 * Instantiates a new order by expression.
		 *
		 * @param expression the expression
		 * @param value the value
		 */
		public OrderByExpression(String expression, OrderBy value){
			super();
			this.expression = expression;
			this.value = value.getValue();
		}
		
		/**
		 * Gets the expression value.
		 *
		 * @return the expression value
		 */
		public String getExpressionValue(){
			String expressionValue = expression + " " + value;
			return expressionValue;
		}

	}	

	/**
	 * Adds the where criteria.
	 *
	 * @param crit the crit
	 */
	public void addWhereCriteria(ICriteria crit){
		if(whereCriteria == null)
			whereCriteria = new QueryConstraints();
		whereCriteria.addConstraint(crit);
	}
	
	/**
	 * Sets the where criteria.
	 *
	 * @param whereCriteria the new where criteria
	 */
	public void setWhereCriteria(QueryConstraints whereCriteria){
		this.whereCriteria = whereCriteria ;
	}
	
	/**
	 * Gets the where criteria.
	 *
	 * @return the where criteria
	 */
	public QueryConstraints getWhereCriteria(){
		return this.whereCriteria;
	}
	
	/**
	 * Gets the sub where criteria value.
	 *
	 * @return the sub where criteria value
	 */
	public IWhereCriteria getSubWhereCriteriaValue(){
		if(whereCriteria != null)
			return whereCriteria.getSubWhereCriteriaValue();
		return null;
	}
	
	/**
	 * Gets the select option value.
	 *
	 * @return the select option value
	 */
	public String getSelectOptionValue(){
		return ((option == null)?"":option.getValue());
	}
	
	/**
	 * Gets the sum value.
	 *
	 * @return the sum value
	 */
	public String getSumValue(){
		return ((sumexpression == null)?"":getSumExpressionsValue());
	}
	
	/**
	 * Gets the average value.
	 *
	 * @return the average value
	 */
	public String getAverageValue(){
		return ((avgexpression == null)?"":getAverageExpressionsValue());
	}
	
	public String getMaxValue(){
		return ((max == null)?"":getMaxExpression());
	}
	
	
	/**
	 * Gets the expressions value.
	 *
	 * @return the expressions value
	 */
	public String getExpressionsValue(){
		
		String SeparatorValue = IParamCriteriaPair.SEPARATOR_STRING;
		
		if((expressions == null) || (expressions.size() == 0))
			return "*";
		
		StringBuffer value = new StringBuffer("");
		
		for (int index = 0; index < expressions.size(); index++) {
			String expressionValue = expressions.get(index).getExpressionValue() + SeparatorValue;
			value.append(expressionValue);
		}
		String criteria = value.toString();
		criteria = criteria.substring(0, (criteria.length() - SeparatorValue.length()));
		return criteria;
	}
	
	/**
	 * Gets the sum expressions value.
	 *
	 * @return the sum expressions value
	 */
	public String getSumExpressionsValue(){
			
			String SeparatorValue = IParamCriteriaPair.SEPARATOR_STRING;
			
			if((sumexpression == null) || (sumexpression.size() == 0))
				return "*";
			StringBuffer seperator = new StringBuffer(SeparatorValue);
			
			for (int index = 0; index < sumexpression.size(); index++) {
			 String expressionValue =  sumexpression.get(index);
			 StringBuffer value = new StringBuffer("SUM");
			value.append("(");
				value.append(expressionValue);
				value.append(")");
				value.append(SeparatorValue);
				seperator.append(value);
			}
			String criteria = seperator.toString();
			criteria = criteria.substring(0, (criteria.length() - SeparatorValue.length()));
			return criteria;
		}
	
	/**
	 * Gets the average expressions value.
	 *
	 * @return the average expressions value
	 */
	public String getAverageExpressionsValue(){
		
		String SeparatorValue = IParamCriteriaPair.SEPARATOR_STRING;
		
		if((avgexpression == null) || (avgexpression.size() == 0))
			return "*";
		StringBuffer seperator = new StringBuffer(SeparatorValue);
		StringBuffer value = new StringBuffer("AVG");
		
		 String expressionValue =  avgexpression.get(0);
		
		value.append("(");
			value.append(expressionValue);
			value.append(")");
			seperator.append(value);
		String criteria = seperator.toString();
		//criteria = criteria.substring(0, (criteria.length() - SeparatorValue.length()));
		return criteria;
	}
	
	public String getMaxExpression(){
		
		String SeparatorValue = IParamCriteriaPair.SEPARATOR_STRING;
		
		if((max == null) || (max.size() == 0))
			return "*";
		//StringBuffer seperator = new StringBuffer(SeparatorValue);
		StringBuffer value = new StringBuffer("MAX");
		
		 String expressionValue =  max.get(0);
		
		value.append("(");
			value.append(expressionValue);
			value.append(")");
			value.append(SeparatorValue);
		String criteria = value.toString();
		criteria = criteria.substring(0, (criteria.length() - SeparatorValue.length()));
		return criteria;
	}
	
	/**
	 * Gets the group by value.
	 *
	 * @return the group by value
	 */
	public String getGroupByValue(){
		
		String SeparatorValue = IParamCriteriaPair.SEPARATOR_STRING;
		
		if((groupBy == null) || (groupBy.size() == 0))
			return "";
		
		StringBuffer value = new StringBuffer(" GROUP BY ");
		
		for (int index = 0; index < groupBy.size(); index++) {
			String groupByValue = groupBy.get(index) + SeparatorValue;
			value.append(groupByValue);
		}
		String criteria = value.toString();
		criteria = criteria.substring(0, (criteria.length() - SeparatorValue.length()));
		return criteria;
	}
	
	/**
	 * Gets the group by having value.
	 *
	 * @return the group by having value
	 */
	public String getGroupByHavingValue(){
			
			//String SeparatorValue = IParamCriteriaPair.SEPARATOR_STRING;
			
			if((having == null) || (having.size() == 0))
				return "";
			
			StringBuffer value = new StringBuffer(" HAVING ");
			String nameValue = "count(*)";
			
				value.append(nameValue);
			
			String criteria = value.toString();
			
			return criteria;
		}
		
	/**
	 * Gets the order by value.
	 *
	 * @return the order by value
	 */
	public String getOrderByValue(){
		
		if((orderBy == null) || (orderBy.size() == 0))
			return "";
		
		String SeparatorValue = IParamCriteriaPair.SEPARATOR_STRING;
		
		StringBuffer value = new StringBuffer(" ORDER BY ");
		
		for (int index = 0; index < orderBy.size(); index++) {
			String expressionValue = orderBy.get(index).getExpressionValue() + SeparatorValue;
			value.append(expressionValue);
		}
		String criteria = value.toString();
		criteria = criteria.substring(0, (criteria.length() - SeparatorValue.length()));
		return criteria;
	}
	
	/**
	 * Checks if is criteria exists.
	 *
	 * @return true, if is criteria exists
	 */
	public final boolean isCriteriaExists(){
		if ((whereCriteria != null) && (whereCriteria.isCriteriaExists()))
			return true;
		return false;
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
