package com.intec.ibank.databaseConnector.transaction.object;

import java.io.Serializable;
import java.util.ArrayList;

import com.intec.ibank.databaseConnector.criteria.QueryConstraints;
import com.intec.ibank.databaseConnector.criteria.update.UpdateConstraints;
import com.intec.ibank.databaseConnector.object.DataRow;
import com.intec.ibank.system.SystemConstants;

/**
 * Copyright
 *
 * The Class to hold all the objects to store in single Transaction.
 */
public class ContractIQTransactionObject implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8631348929155396746L;

    /** The transaction list. */
    private ArrayList<ITransactionObject> transactionList;

	/**
	 * Instantiates a new IBank transaction object.
	 */
	public ContractIQTransactionObject() {
		super();
		transactionList = null;
	}
    
    /**
     * The Class CreateObject.
     */
    private static class CreateObject implements ICreateObject{
		
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;
		
    	/** The table. */
	    private final String table;
    	
	    /** The row value. */
	    private final DataRow rowValue;
    	
	    /**
	     * Instantiates a new creates the object.
	     *
	     * @param table the table
	     * @param rowValue the row value
	     */
	    public CreateObject(String table, DataRow rowValue){
    		this.table = table;
    		this.rowValue = rowValue;
    	}
		
		/* (non-Javadoc)
		 * @see com.IBank.databaseConnector.transaction.object.ICreateObject#getTableName()
		 */
		public final String getTableName() {
			return table;
		}
		
		/* (non-Javadoc)
		 * @see com.IBank.databaseConnector.transaction.object.ICreateObject#getRowValue()
		 */
		public final DataRow getRowValue() {
			return rowValue;
		}
    	
    }
    
    /**
     * The Class UpdateObject.
     */
    private static class UpdateObject implements IUpdateObject{
		
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;
		
    	/** The table. */
	    private final String table;
    	
	    /** The constraints. */
	    private final UpdateConstraints constraints;
    	
	    /**
	     * Instantiates a new update object.
	     *
	     * @param table the table
	     * @param constraints the constraints
	     */
	    public UpdateObject(String table, UpdateConstraints constraints){
    		this.table = table;
    		this.constraints = constraints;
    	}
		
		/* (non-Javadoc)
		 * @see com.IBank.databaseConnector.transaction.object.IUpdateObject#getTableName()
		 */
		public final String getTableName() {
			return table;
		}
		
		/* (non-Javadoc)
		 * @see com.IBank.databaseConnector.transaction.object.IUpdateObject#getConstraints()
		 */
		public final UpdateConstraints getConstraints() {
			return constraints;
		}
    }
    
    /**
     * The Class DeleteObject.
     */
    private static class DeleteObject implements IDeleteObject{
		
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;
		
		/** The table. */
		private final String table;
    	
	    /** The constraints. */
	    private final QueryConstraints constraints;
    	
	    /**
	     * Instantiates a new delete object.
	     *
	     * @param table the table
	     * @param constraints the constraints
	     */
	    public DeleteObject(String table, QueryConstraints constraints){
    		this.table = table;
    		this.constraints = constraints;
    	}
		
		/* (non-Javadoc)
		 * @see com.IBank.databaseConnector.transaction.object.IDeleteObject#getTableName()
		 */
		public final String getTableName() {
			return table;
		}
		
		/* (non-Javadoc)
		 * @see com.IBank.databaseConnector.transaction.object.IDeleteObject#getConstraints()
		 */
		public final QueryConstraints getConstraints() {
			return constraints;
		}
    }

    /**
     * Adds the create.
     *
     * @param table the table
     * @param rowValue the row value
     */
    public final void addCreate(String table, DataRow rowValue) {
    	if(transactionList == null)
    		transactionList = new ArrayList<ITransactionObject>();
    	CreateObject obj = new CreateObject(table, rowValue);
    	transactionList.add(obj);
    }

    /**
     * Adds the update.
     *
     * @param table the table
     * @param constraints the constraints
     */
    public final void addUpdate(String table, UpdateConstraints constraints) {
    	if(transactionList == null)
    		transactionList = new ArrayList<ITransactionObject>();
    	UpdateObject obj = new UpdateObject(table, constraints);
    	transactionList.add(obj);
    }

    /**
     * Adds the delete.
     *
     * @param table the table
     * @param constraints the constraints
     */
    public final void addDelete(String table, QueryConstraints constraints) {
    	if(transactionList == null)
    		transactionList = new ArrayList<ITransactionObject>();
    	DeleteObject obj = new DeleteObject(table, constraints);
    	transactionList.add(obj);
    }

	/**
	 * Gets the transaction list.
	 *
	 * @return the transaction list
	 */
	public final ITransactionObject[] getTransactionList() {
		ITransactionObject[] values = (transactionList == null)?null:transactionList.toArray(new ITransactionObject[0]);
		return values;
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
