package com.intec.ibank.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.intec.ibank.database.connection.IConnectionProvider;
import com.intec.ibank.database.query.IQueryGenerator;
import com.intec.ibank.databaseConnector.criteria.QueryConstraints;
import com.intec.ibank.databaseConnector.criteria.select.SelectConstraints;
import com.intec.ibank.databaseConnector.criteria.select.union.UnionConstraint;
import com.intec.ibank.databaseConnector.criteria.update.ParamCriteriaPair;
import com.intec.ibank.databaseConnector.criteria.update.UpdateConstraints;
import com.intec.ibank.databaseConnector.object.DataRow;
import com.intec.ibank.databaseConnector.object.dataTable.DataTable;
import com.intec.ibank.databaseConnector.object.dataTable.DataTableHeaderRow;
import com.intec.ibank.databaseConnector.object.dataTable.DataTableHeaderRowColumn;
import com.intec.ibank.databaseConnector.object.dataTable.DataTableRow;
import com.intec.ibank.databaseConnector.object.dataTable.DataTableRowColumn;
import com.intec.ibank.databaseConnector.transaction.object.ContractIQTransactionObject;
import com.intec.ibank.databaseConnector.transaction.object.ICreateObject;
import com.intec.ibank.databaseConnector.transaction.object.IDeleteObject;
import com.intec.ibank.databaseConnector.transaction.object.ITransactionObject;
import com.intec.ibank.databaseConnector.transaction.object.IUpdateObject;
import com.intec.ibank.log.IBankLogger;
import com.intec.ibank.system.SystemConstants;
import com.sun.rowset.CachedRowSetImpl;

/**
 * Copyright.
 * 
 * The Class for handling the operations for the Database 
 */
public final class IBankDatabaseConnector implements IIBankDatabaseConnector{
	
	/** The provider. */
	private IConnectionProvider provider;
	
	/** The query generator. */
	private IQueryGenerator queryGenerator;

	/**
	 * Instantiates a new IBank database connector.
	 */
	public IBankDatabaseConnector() {
		super();
		this.provider = null;
		this.queryGenerator = null;
	}

	/**
	 * Instantiates a new IBank database connector.
	 *
	 * @param provider the provider
	 * @param queryGenerator the query generator
	 */
	public IBankDatabaseConnector(IConnectionProvider provider, IQueryGenerator queryGenerator) {
		super();
		this.provider = provider;
		this.queryGenerator = queryGenerator;
	}

	/**
	 * Sets the provider.
	 *
	 * @param provider the new provider
	 */
	public final void setProvider(IConnectionProvider provider) {
		this.provider = provider;
	}

	/**
	 * Sets the query generator.
	 *
	 * @param queryGenerator the new query generator
	 */
	public final void setQueryGenerator(IQueryGenerator queryGenerator) {
		this.queryGenerator = queryGenerator;
	}
	
	/* (non-Javadoc)
	 * @see com.IBank.database.IIBankDatabaseConnector#retrieveRows(java.lang.String)
	 */
	@Override
	public final DataTable retrieveRows(String table) throws Throwable {
		if(queryGenerator == null)
			throw new SQLException("Set Query Generator First !! ");
		ParamCriteriaPair crit = queryGenerator.getSelectQuery(table);
		return this.retrieveRows(crit);
	}

	/* (non-Javadoc)
	 * @see com.IBank.database.IIBankDatabaseConnector#retrieveRows(java.lang.String, com.IBank.databaseConnector.criteria.QueryConstraints)
	 */
	@Override
	public final DataTable retrieveRows(String table, QueryConstraints constraints) throws Throwable {
		if(queryGenerator == null)
			throw new SQLException("Set Query Generator First !! ");
		ParamCriteriaPair crit = queryGenerator.getSelectQuery(table, constraints);
		return this.retrieveRows(crit);
	}
	
	@Override
	public final DataTable retrieveQueryRows(String query, List<Object> params) throws Throwable{
		ParamCriteriaPair crit = new ParamCriteriaPair(query, params); 
		return this.retrieveRows(crit);
	}


	/* (non-Javadoc)
	 * @see com.IBank.database.IIBankDatabaseConnector#retrieveRows(java.lang.String, com.IBank.databaseConnector.criteria.select.SelectConstraints)
	 */
	@Override
	public final DataTable retrieveRows(String table, SelectConstraints constraints) throws Throwable {
		if(queryGenerator == null)
			throw new SQLException("Set Query Generator First !! ");
		ParamCriteriaPair crit = queryGenerator.getSelectQuery(table, constraints);
		return this.retrieveRows(crit);
	}

	/* (non-Javadoc)
	 * @see com.IBank.database.IIBankDatabaseConnector#retrieveRows(com.IBank.databaseConnector.criteria.select.union.UnionConstraint)
	 */
	@Override
	public final DataTable retrieveRows(UnionConstraint constraint) throws Throwable {
		if(queryGenerator == null)
			throw new SQLException("Set Query Generator First !! ");
		ParamCriteriaPair crit = queryGenerator.getSelectQuery(constraint);
		return this.retrieveRows(crit);
	}

	/**
	 * Retrieve rows.
	 *
	 * @param crit the crit
	 * @return the data table
	 * @throws Throwable the throwable
	 */
	private final DataTable retrieveRows(ParamCriteriaPair crit) throws Throwable {
		if(provider == null)
			throw new SQLException("Set Connection Provider First !! ");
		String query = crit.getCriteria();
		List<Object> parameterList = crit.getParams();
		
		Connection conn = null;
		try {
			conn = provider.getConnection();
			conn.setAutoCommit(true);
	        PreparedStatement preparedStatement = conn.prepareStatement(query);

	        if (parameterList != null && parameterList.size() > 0) {
	            for (int i = 0; i < parameterList.size(); i++) {
	                preparedStatement.setObject(i + 1, parameterList.get(i));
	            }
	        }
	        ResultSet rs = preparedStatement.executeQuery();

	        CachedRowSet rsCached = new CachedRowSetImpl(); 
			rsCached.populate(rs);
	        
			rs.close();
	        preparedStatement.close();
	        
			if(conn != null){
				provider.closeConnection(conn);
				conn = null;
			}
	        
			return getDataTable(rsCached);
		} catch (Throwable e) {
			IBankLogger.log(e);  
			throw e;
		}finally{
			if(conn != null)
				provider.closeConnection(conn);
		}
	}

	/**
	 * Gets the data table.
	 *
	 * @param rs the rs
	 * @return the data table
	 * @throws Exception the exception
	 */
	private DataTable getDataTable(CachedRowSet rs) throws Exception {

		List<DataTableHeaderRowColumn> headerColumns = new ArrayList<DataTableHeaderRowColumn>();

		int columns = rs.getMetaData().getColumnCount();
		for (int colIndex = 1; colIndex <= columns; colIndex++) {
			String name = rs.getMetaData().getColumnName(colIndex); // Name
			String columnType = rs.getMetaData().getColumnTypeName(colIndex); // columnType
			DataTableHeaderRowColumn headerColumn = new DataTableHeaderRowColumn(
					name, columnType);
			headerColumns.add(headerColumn);
		}
		DataTableHeaderRow headerRow = new DataTableHeaderRow(headerColumns);

		ArrayList<DataTableRow> rowList = new ArrayList<DataTableRow>();
		while (rs.next()) {
			ArrayList<DataTableRowColumn> rowColumns = new ArrayList<DataTableRowColumn>();
			for (int colIndex = 1; colIndex <= columns; colIndex++) {
				Object dataValue = rs.getObject(colIndex);
				DataTableRowColumn rowColumn = new DataTableRowColumn(dataValue);
				rowColumns.add(rowColumn);
			}
			DataTableRow tableRow = new DataTableRow(rowColumns);
			rowList.add(tableRow);
		}
		DataTable table = new DataTable(headerRow, rowList);

		return table;
	}

	/* (non-Javadoc)
	 * @see com.IBank.database.IIBankDatabaseConnector#createRow(java.lang.String, com.IBank.databaseConnector.object.DataRow)
	 */
	@Override
	public final boolean createRow(String table, DataRow rowValue) throws Throwable {
		if(queryGenerator == null)
			throw new SQLException("Set Query Generator First !! ");
		if(provider == null)
			throw new SQLException("Set Connection Provider First !! ");

		ParamCriteriaPair crit = queryGenerator.getCreateQuery(table, rowValue);
		String query = crit.getCriteria();
		List<Object> parameterList = crit.getParams();

		Connection conn = null;
		try {
			conn = provider.getConnection();
			conn.setAutoCommit(true);
			return createRow(conn, query, parameterList);
		}catch(Throwable ex){
			throw ex;
		}finally{
			if(conn != null)
				provider.closeConnection(conn);
		}
	}
	
	/**
	 * Creates the row.
	 *
	 * @param conn the conn
	 * @param query the query
	 * @param parameterList the parameter list
	 * @return true, if successful
	 * @throws Throwable the throwable
	 */
	private final boolean createRow(Connection conn, String query, List<?> parameterList) throws Throwable {

        PreparedStatement preparedStatement = conn.prepareStatement(query);

        if (parameterList != null && parameterList.size() > 0) {
            for (int i = 0; i < parameterList.size(); i++) {
                preparedStatement.setObject(i + 1, parameterList.get(i));
            }
        }
        boolean retValue = preparedStatement.execute();
        preparedStatement.close();
        return retValue;
	}

	/* (non-Javadoc)
	 * @see com.IBank.database.IIBankDatabaseConnector#updateRows(java.lang.String, com.IBank.databaseConnector.criteria.update.UpdateConstraints)
	 */
	@Override
	public final int updateRows(String table, UpdateConstraints constraints) throws Throwable {
		if(queryGenerator == null)
			throw new SQLException("Set Query Generator First !! ");
		if(provider == null)
			throw new SQLException("Set Connection Provider First !! ");

		ParamCriteriaPair crit = queryGenerator.getUpdateQuery(table, constraints);
		String query = crit.getCriteria();
		List<Object> parameterList = crit.getParams();

		Connection conn = null;
		try {
			conn = provider.getConnection();
			conn.setAutoCommit(true);
			return updateRows(conn, query, parameterList);
		}catch(Throwable ex){
			throw ex;
		}finally{
			if(conn != null)
				provider.closeConnection(conn);
		}
	}
	
	/**
	 * Update rows.
	 *
	 * @param conn the conn
	 * @param query the query
	 * @param parameterList the parameter list
	 * @return the int
	 * @throws Throwable the throwable
	 */
	private final int updateRows(Connection conn, String query, List<?> parameterList) throws Throwable {

        PreparedStatement preparedStatement = conn.prepareStatement(query);

        if (parameterList != null && parameterList.size() > 0) {
            for (int i = 0; i < parameterList.size(); i++) {
                preparedStatement.setObject(i + 1, parameterList.get(i));
            }
        }
        int retValue = preparedStatement.executeUpdate();
        preparedStatement.close();
        return retValue;
	}

	/* (non-Javadoc)
	 * @see com.IBank.database.IIBankDatabaseConnector#deleteRows(java.lang.String)
	 */
	@Override
	public final int deleteRows(String table) throws Throwable {
		return deleteRows(table, null);
	}

	/* (non-Javadoc)
	 * @see com.IBank.database.IIBankDatabaseConnector#deleteRows(java.lang.String, com.IBank.databaseConnector.criteria.QueryConstraints)
	 */
	@Override
	public final int deleteRows(String table, QueryConstraints constraints) throws Throwable {
		if(queryGenerator == null)
			throw new SQLException("Set Query Generator First !! ");
		if(provider == null)
			throw new SQLException("Set Connection Provider First !! ");

		ParamCriteriaPair crit = queryGenerator.getDeleteQuery(table, constraints);
		String query = crit.getCriteria();
		List<Object> parameterList = crit.getParams();
		
		Connection conn = null;
		try {
			conn = provider.getConnection();
			conn.setAutoCommit(true);
			return deleteRows(conn, query, parameterList);
		}catch(Throwable ex){
			throw ex;
		}finally{
			if(conn != null)
				provider.closeConnection(conn);
		}
	}
	
	/**
	 * Delete rows.
	 *
	 * @param conn the conn
	 * @param query the query
	 * @param parameterList the parameter list
	 * @return the int
	 * @throws Throwable the throwable
	 */
	private final int deleteRows(Connection conn, String query, List<?> parameterList) throws Throwable {

        PreparedStatement preparedStatement = conn.prepareStatement(query);

        if (parameterList != null && parameterList.size() > 0) {
            for (int i = 0; i < parameterList.size(); i++) {
                preparedStatement.setObject(i + 1, parameterList.get(i));
            }
        }
        int retValue = preparedStatement.executeUpdate();
        preparedStatement.close();
        return retValue;
	}

	/* (non-Javadoc)
	 * @see com.IBank.database.IIBankDatabaseConnector#store(com.IBank.databaseConnector.transaction.object.IBankTransactionObject)
	 */
	@Override
	public final boolean store(ContractIQTransactionObject obj) throws Throwable {
		ITransactionObject[] transList = obj.getTransactionList();
		
		if((transList == null) || (transList.length == 0))
			return true;
		
		ArrayList<StoreForCriteria> criteriaList = new ArrayList<StoreForCriteria>();
		
    	for(int index = 0;index<transList.length;index++){
    		ITransactionObject transObj = transList[index];
    		StoreForCriteria criteria;
    		if(transObj instanceof ICreateObject){
    			criteria = getCreateCriteria(queryGenerator, (ICreateObject)transObj);
    		}else if(transObj instanceof IUpdateObject){
    			criteria = getUpdateCriteria(queryGenerator, (IUpdateObject)transObj);
    		}else{
    			criteria = getDeleteCriteria(queryGenerator, (IDeleteObject)transObj);
    		}
    		criteriaList.add(criteria);
    	}
		return store(criteriaList);
	}

    /**
     * Gets the creates the criteria.
     *
     * @param generator the generator
     * @param obj the obj
     * @return the creates the criteria
     */
    private final CreateForCriteria getCreateCriteria(IQueryGenerator generator, ICreateObject obj) {
    	if(obj == null)
    		return null;
   		ParamCriteriaPair crit = generator.getCreateQuery(obj.getTableName(), obj.getRowValue());
    	return new CreateForCriteria(crit);
    }

    /**
     * Gets the update criteria.
     *
     * @param generator the generator
     * @param obj the obj
     * @return the update criteria
     */
    private final UpdateForCriteria getUpdateCriteria(IQueryGenerator generator, IUpdateObject obj) {
    	if(obj == null)
    		return null;
    	ParamCriteriaPair crit = generator.getUpdateQuery(obj.getTableName(), obj.getConstraints());
    	return new UpdateForCriteria(crit);
    }

    /**
     * Gets the delete criteria.
     *
     * @param generator the generator
     * @param obj the obj
     * @return the delete criteria
     */
    private final DeleteForCriteria getDeleteCriteria(IQueryGenerator generator, IDeleteObject obj) {
    	if(obj == null)
    		return null;
    	ParamCriteriaPair crit = generator.getDeleteQuery(obj.getTableName(), obj.getConstraints());
    	return new DeleteForCriteria(crit);
    }
    
    /**
     * The Class StoreForCriteria.
     */
    private abstract class StoreForCriteria {
    	
	    /** The crit. */
	    protected final ParamCriteriaPair crit;
    	
	    /**
	     * Instantiates a new store for criteria.
	     *
	     * @param crit the crit
	     */
	    public StoreForCriteria(ParamCriteriaPair crit){
    		this.crit = crit;
    	}
    	
	    /**
	     * Store.
	     *
	     * @param conn the conn
	     * @throws Throwable the throwable
	     */
	    abstract void store(Connection conn) throws Throwable;
    }
    
    /**
     * The Class CreateForCriteria.
     */
    private class CreateForCriteria extends StoreForCriteria{
    	
	    /**
	     * Instantiates a new creates the for criteria.
	     *
	     * @param crit the crit
	     */
	    public CreateForCriteria(ParamCriteriaPair crit){
    		super(crit);
    	}
    	
	    /* (non-Javadoc)
	     * @see com.IBank.database.IBankDatabaseConnector.StoreForCriteria#store(java.sql.Connection)
	     */
	    public void store(Connection conn) throws Throwable{
			ParamCriteriaPair value = crit;
			createRow(conn, value.getCriteria(), value.getParams());
    	}
    }
    
    /**
     * The Class UpdateForCriteria.
     */
    private class UpdateForCriteria extends StoreForCriteria{
    	
	    /**
	     * Instantiates a new update for criteria.
	     *
	     * @param crit the crit
	     */
	    public UpdateForCriteria(ParamCriteriaPair crit){
    		super(crit);
    	}
    	
	    /* (non-Javadoc)
	     * @see com.IBank.database.IBankDatabaseConnector.StoreForCriteria#store(java.sql.Connection)
	     */
	    public void store(Connection conn) throws Throwable{
			ParamCriteriaPair value = crit;
			updateRows(conn, value.getCriteria(), value.getParams());
    	}
    }
    
    /**
     * The Class DeleteForCriteria.
     */
    private class DeleteForCriteria extends StoreForCriteria{
    	
	    /**
	     * Instantiates a new delete for criteria.
	     *
	     * @param crit the crit
	     */
	    public DeleteForCriteria(ParamCriteriaPair crit){
    		super(crit);
    	}
    	
	    /* (non-Javadoc)
	     * @see com.IBank.database.IBankDatabaseConnector.StoreForCriteria#store(java.sql.Connection)
	     */
	    public void store(Connection conn) throws Throwable{
			ParamCriteriaPair value = crit;
			deleteRows(conn, value.getCriteria(), value.getParams());
    	}
    }
	
	/**
	 * Store.
	 *
	 * @param criteriaList the criteria list
	 * @return true, if successful
	 * @throws Throwable the throwable
	 */
	private final boolean store(List<StoreForCriteria> criteriaList) throws Throwable{
		if((criteriaList == null) || (criteriaList.size() == 0))
			return true;
		boolean inTransaction = false;
		Savepoint point = null;
		Connection conn = null;
		try {

			/**
			 * Start Transaction
			 */
			conn = provider.getConnection();
			conn.setAutoCommit(false);
			point = conn.setSavepoint();

			/**
			 * Transaction Started. 
			 * Start do the dml operations
			 */
			inTransaction = true;

			for (int index = 0; index < criteriaList.size(); index++) {
				StoreForCriteria criteria = criteriaList.get(index);
				criteria.store(conn);
			}

			/**
			 * Commit Transaction
			 */
			conn.commit();
			conn.releaseSavepoint(point);

			inTransaction = false;
			return true;
		} catch (SQLException ex) {
			IBankLogger.log(ex);
			throw ex;
		} catch (Throwable ex) {
			IBankLogger.log(ex);
			throw ex;
		} finally {
			if (inTransaction) {
				try {
					/**
					 * Roll back partial transaction
					 */
					conn.rollback(point);
					conn.releaseSavepoint(point);
				} catch (SQLException ex) {
					IBankLogger.log(ex);
				}
			}
			/**
			 * Close Connection 
			 */
			if(conn != null)
				provider.closeConnection(conn);
		}
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
