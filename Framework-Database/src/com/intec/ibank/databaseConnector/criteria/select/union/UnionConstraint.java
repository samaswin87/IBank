package com.intec.ibank.databaseConnector.criteria.select.union;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.intec.ibank.databaseConnector.criteria.IParamCriteriaPair;
import com.intec.ibank.databaseConnector.criteria.select.OrderBy;
import com.intec.ibank.databaseConnector.criteria.select.SelectConstraints;
import com.intec.ibank.system.SystemConstants;
/**
 * Copyright
 *
 */
public abstract class UnionConstraint implements Serializable {

	private static final long serialVersionUID = -6422331817234630910L;
	
	private List<SelectQuery> constraints;
	
	/** The order by. */
	private List<OrderByExpression> orderBy; 
	
	/** The offset. */
	private int offset;
	
	/** The rows. */
	private int rows;

	public UnionConstraint() {
		super();
		constraints = new ArrayList<SelectQuery>();
		orderBy = null;
	}
	
	public final void addSelectQueryConstraint(String tableName, SelectConstraints contraint){
		if(contraint != null)
			constraints.add(new SelectQuery(tableName, contraint));
	}
	
	public final ISelectQuery[] getConstraints(){
		SelectQuery[] values = (SelectQuery[])constraints.toArray(new SelectQuery[0]);
		return values;
	}

	/**
	 * Adds the order by.
	 *
	 * @param expression the expression
	 * @param value the value
	 */
	public void addOrderBy(String expression, OrderBy value)
	{
		if(value == null)
			return;
		if(orderBy == null)
			orderBy = new ArrayList<OrderByExpression>();
		orderBy.add(new OrderByExpression(expression, value));
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
	public final void setRows(int rows) 
	{
		this.rows = rows;
	}
	
	private static class SelectQuery implements ISelectQuery
	{
		private static final long serialVersionUID = -4303860017015941665L;
		
		private final String tableName;
		private final SelectConstraints contraint;
		
		public SelectQuery(String tableName, SelectConstraints contraint){
			super();
			this.tableName = tableName;
			this.contraint = contraint;
		}

		@Override
		public SelectConstraints getSelectConstraint() {
			return contraint;
		}

		@Override
		public String getTableName() {
			return tableName;
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
	
	
	public abstract String getQueryKey();

	public static final String getCopyRights() {
		return SystemConstants.COPYRIGHTS;
	}

}
