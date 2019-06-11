package com.intec.ibank.databaseConnector.criteria;

import java.util.List;

import com.intec.ibank.system.SystemConstants;

// TODO: Auto-generated Javadoc
/**
 * Copyright.
 */
public class RestrictionCriteria {

	/**
	 * Gets the copy rights.
	 *
	 * @return the copy rights
	 */
	public static final String getCopyRights() {
		return SystemConstants.COPYRIGHTS;
	}

	/**
	 * Instantiates a new restriction criteria.
	 */
	private RestrictionCriteria() {
		super();
	}

	/**
	 * Group expressions together By "And" (crit1 and crit2 ...)
	 *
	 * @return the and join criteria
	 */
	 
	public static AndJoinCriteria andCriteria(){
		return new AndJoinCriteria();
	}

	/**
	 * Group expressions together By "Or" (crit1 or crit2 ...)
	 *
	 * @return the or join criteria
	 */
	 
	public static OrJoinCriteria orCriteria(){
		return new OrJoinCriteria();
	}
	
	/**
	 * Apply an "null" constraint.
	 *
	 * @param columnName the column name
	 * @return the i criteria
	 */
	public static ICriteria nullCrit(String columnName){
		return new NullCriteria(columnName);
	}
	
	/**
	 * Apply an "not null" constraint.
	 *
	 * @param columnName the column name
	 * @return the i criteria
	 */
	public static ICriteria notNullCrit(String columnName){
		return new NotNullCriteria(columnName);
	}

	/**
	 * Apply an "equal" constraint.
	 *
	 * @param columnName the column name
	 * @param value the value
	 * @return the i criteria
	 */
	public static ICriteria equalCrit(String columnName, Object value){
		return new EqualCriteria(columnName, value);
	}

	/**
	 * Return the negation of a Criteria.
	 *
	 * @param criteria the criteria
	 * @return the i criteria
	 */
	public static ICriteria notCrit(ICriteria criteria){
		return new NotCriteria(criteria);
	}
     
	
	/**
	 * Like crit.
	 *
	 * @param columnName the column name
	 * @param value the value
	 * @return the i criteria
	 */
	public static ICriteria likeCrit(String columnName, Object value){
		return new LikeCriteria(columnName, value);
	}
	
	/**
	 * Apply an "in" constraint.
	 *
	 * @param columnName the column name
	 * @param value the value
	 * @return the i criteria
	 */
	public static ICriteria inCrit(String columnName, Object[] value){
		return new InCriteria(columnName, value);
	}
	
	/**
	 * Apply an "in" constraint.
	 *
	 * @param columnName the column name
	 * @param value the value
	 * @return the i criteria
	 */
	public static ICriteria inCrit(String columnName, List<? extends Object> value){
		return new InCriteria(columnName, value);
	}
	
	/**
	 * Apply an "not in" constraint.
	 *
	 * @param columnName the column name
	 * @param value the value
	 * @return the i criteria
	 */
	public static ICriteria notInCrit(String columnName, Object[] value){
		return new NotInCriteria(columnName, value);
	}
	
	/**
	 * Apply an "not in" constraint.
	 *
	 * @param columnName the column name
	 * @param value the value
	 * @return the i criteria
	 */
	public static ICriteria notInCrit(String columnName, List<? extends Object> value){
		return new NotInCriteria(columnName, value);
	}
	
	/**
	 * Apply an "Greater than" constraint.
	 *
	 * @param columnName the column name
	 * @param value the value
	 * @return the i criteria
	 */
	public static ICriteria gtCrit(String columnName, Object value){
		return new GreaterThanCriteria(columnName, value);
	}
	
	/**
	 * Apply an "Greater than or Equal" constraint.
	 *
	 * @param columnName the column name
	 * @param value the value
	 * @return the i criteria
	 */
	public static ICriteria geCrit(String columnName, Object value){
		return new GreaterThanOrEqualCriteria(columnName, value);
	}
	
	/**
	 * Apply an "Less than" constraint.
	 *
	 * @param columnName the column name
	 * @param value the value
	 * @return the i criteria
	 */
	public static ICriteria ltCrit(String columnName, Object value){
		return new LessThanCriteria(columnName, value);
	}
	
	/**
	 * Apply an "Less than or Equal" constraint.
	 *
	 * @param columnName the column name
	 * @param value the value
	 * @return the i criteria
	 */
	public static ICriteria leCrit(String columnName, Object value){
		return new LessThanOrEqualCriteria(columnName, value);
	}
	
	/**
	 * Between crit.
	 *
	 * @param columnName the column name
	 * @param fromValue the from value
	 * @param toValue the to value
	 * @return the i criteria
	 */
	public static ICriteria betweenCrit(String columnName, Object fromValue, Object toValue){
		return new BetweenCriteria(columnName, fromValue, toValue);
	}
	
	
	
	/*
	static Criterion allEq(Map propertyNameValues) 
    Apply an "equals" constraint to each property in the key set of a Map 
static LogicalExpression and(Criterion lhs, Criterion rhs) 
    Return the conjuction of two expressions 
static Criterion between(String propertyName, Object lo, Object hi) 
    Apply a "between" constraint to the named property 
static Disjunction disjunction() 
    Group expressions together in a single disjunction (A or B or C...) 
static PropertyExpression eqProperty(String propertyName, String otherPropertyName) 
    Apply an "equal" constraint to two properties 
static PropertyExpression geProperty(String propertyName, String otherPropertyName) 
    Apply a "greater than or equal" constraint to two properties 
static PropertyExpression gtProperty(String propertyName, String otherPropertyName) 
    Apply a "greater than" constraint to two properties 
static Criterion idEq(Object value) 
    Apply an "equal" constraint to the identifier property 
static Criterion ilike(String propertyName, Object value) 
    A case-insensitive "like", similar to Postgres ilike operator 
static Criterion ilike(String propertyName, String value, MatchMode matchMode) 
    A case-insensitive "like", similar to Postgres ilike operator 
static Criterion in(String propertyName, Collection values) 
    Apply an "in" constraint to the named property 
static Criterion in(String propertyName, Object[] values) 
    Apply an "in" constraint to the named property 
static Criterion isEmpty(String propertyName) 
    Constrain a collection valued property to be empty 
static Criterion isNotEmpty(String propertyName) 
    Constrain a collection valued property to be non-empty 
static Criterion isNotNull(String propertyName) 
    Apply an "is not null" constraint to the named property 
static Criterion isNull(String propertyName) 
    Apply an "is null" constraint to the named property 
static PropertyExpression leProperty(String propertyName, String otherPropertyName) 
    Apply a "less than or equal" constraint to two properties 
static SimpleExpression like(String propertyName, Object value) 
    Apply a "like" constraint to the named property 
static SimpleExpression like(String propertyName, String value, MatchMode matchMode) 
    Apply a "like" constraint to the named property 
static PropertyExpression ltProperty(String propertyName, String otherPropertyName) 
    Apply a "less than" constraint to two properties 
static NaturalIdentifier naturalId() 
      
static SimpleExpression ne(String propertyName, Object value) 
    Apply a "not equal" constraint to the named property 
static PropertyExpression neProperty(String propertyName, String otherPropertyName) 
    Apply a "not equal" constraint to two properties 
static LogicalExpression or(Criterion lhs, Criterion rhs)  
*/

}
