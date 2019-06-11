package com.intec.ibank.database.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import com.intec.ibank.utils.PropertiesHelper;

/**
 * Copyright
 * 
 * This Class is used as the base class for Connection Provider.
 */
public abstract class ConnectionProvider implements IConnectionProvider {
	
	/** The pool. */
	private final ArrayList<Connection> pool = new ArrayList<Connection>();
	
	/** The isolation. */
	private Integer isolation;
	
	
	/** The pool size. */
	private int poolSize;
	
	/** The autocommit. */
	private boolean autoCommit;

	/* (non-Javadoc)
	 * @see com.test.mysql.IConnectionProvider#configure(java.util.Properties)
	 */
	@Override
	public final void setProperties(Properties props) throws SQLException {
		final String POOL_SIZE = "connection.poolSize";
		final String AUTO_COMMIT = "connection.autoCommit";
		
		poolSize = PropertiesHelper.getInteger(POOL_SIZE, props, 0); // default pool size 20
		
		autoCommit = PropertiesHelper.getBoolean(AUTO_COMMIT, props);
		//System.out.println("autocommit mode: " + autoCommit);

		initialize(props);
		initialize();
	}
	
	/**
	 * Initialize.
	 *
	 * @param props the props
	 * @throws SQLException the sQL exception
	 */
	protected abstract void initialize(Properties props) throws SQLException;
	
	/**
	 * Gets the pool size.
	 *
	 * @return the pool size
	 */
	protected final int getPoolSize(){
		return poolSize;
	}
	
	/**
	 * Gets the isolation.
	 *
	 * @return the isolation
	 */
	protected final Integer getIsolation(){
		return isolation;
	}
	
	/**
	 * Checks if is auto commit.
	 *
	 * @return true, if is auto commit
	 */
	protected final boolean isAutoCommit(){
		return autoCommit;
	}
	
	/**
	 * Gets the provider pool size.
	 *
	 * @return the provider pool size
	 */
	private int getProviderPoolSize(){
		int poolSize = getPoolSize();
		return ((poolSize <=0 )?1:poolSize);
	}

	/**
	 * Initialize.
	 *
	 * @throws SQLException the sQL exception
	 */
	private void initialize() throws SQLException {
		synchronized (pool) {
			for(int index = 0;index<getProviderPoolSize();index++){
				Connection conn = getNewConnection();
				pool.add(conn);
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.test.mysql.IConnectionProvider#close()
	 */
	@Override
	public final void close() throws SQLException {
		Iterator<Connection> iter = pool.iterator();
		while (iter.hasNext()) {
			try {
				((Connection) iter.next()).close();
			} catch (SQLException sqle) {

			}
		}
		pool.clear();
	}

	/* (non-Javadoc)
	 * @see com.test.mysql.IConnectionProvider#closeConnection(java.sql.Connection)
	 */
	@Override
	public final void closeConnection(Connection conn) throws SQLException {
		synchronized (pool) {
			int currentSize = pool.size();
			if (currentSize < getProviderPoolSize()) {
				pool.add(conn);
				return;
			}
		}
		conn.close();
	}

	/* (non-Javadoc)
	 * @see com.test.mysql.IConnectionProvider#getConnection()
	 */
	@Override
	public final Connection getConnection() throws SQLException {
		synchronized (pool) {
			if (!pool.isEmpty()) {
				int last = pool.size() - 1;

				Connection pooled = (Connection) pool.remove(last);
				Integer isolation = getIsolation();
				if (isolation != null)
					pooled.setTransactionIsolation(isolation.intValue());
				boolean autoCommit = isAutoCommit();
				if (pooled.getAutoCommit() != autoCommit)
					pooled.setAutoCommit(autoCommit);
				return pooled;
			}
		}
		
		return getNewConnection();
	}
	
	/**
	 * Gets the new connection.
	 *
	 * @return the new connection
	 * @throws SQLException the sQL exception
	 */
	private final Connection getNewConnection() throws SQLException{
		Connection conn = createConnection();
		Integer isolation = getIsolation();
		if (isolation != null)
			conn.setTransactionIsolation(isolation);
		boolean autoCommit = isAutoCommit();
		if (conn.getAutoCommit() != autoCommit)
			conn.setAutoCommit(autoCommit);
		return conn;
	}
	
	/**
	 * Creates the connection.
	 *
	 * @return the connection
	 * @throws SQLException the sQL exception
	 */
	protected abstract Connection createConnection() throws SQLException;

}
