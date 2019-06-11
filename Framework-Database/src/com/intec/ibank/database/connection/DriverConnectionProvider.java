package com.intec.ibank.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.intec.ibank.utils.Utilities;

/**
 * Copyright
 * 
 * This Class is used for the Connection Provider using Driver .
 */
public class DriverConnectionProvider extends ConnectionProvider {
	
	/** The url. */
	private String url;
	
	/** The connection properties. */
	private Properties connectionProperties;

	/* (non-Javadoc)
	 * @see com.IBank.database.connection.ConnectionProvider#initialize(java.util.Properties)
	 */
	@Override
	public void initialize(Properties props) throws SQLException {
		final String DRIVER_NAME = "connection.driver";
		final String URL_NAME = "connection.url";
		final String USER_NAME = "connection.userName";
		final String PASSWORD = "connection.password";

		String driverClass = props.getProperty(DRIVER_NAME);
		if (Utilities.isEmptyValue(driverClass)) {
			System.out
					.println("no JDBC Driver class was in property "+ DRIVER_NAME);
		} else {
			try {
				
				Class.forName(driverClass);
			} catch (ClassNotFoundException cnfe) {
				System.out.println("JDBC Driver class not found: "+ driverClass);

			}
		}

		url = props.getProperty(URL_NAME);
		if (Utilities.isEmptyValue(url)) {
			System.out.println("JDBC URL was not in property "+ URL_NAME);
		} else {

			//System.out.println("using driver: " + driverClass + " at URL: "	+ url);
		}
		
		connectionProperties = new Properties();
		connectionProperties.setProperty("driver_class", driverClass);
		
		String username = props.getProperty(USER_NAME);
		if (Utilities.isEmptyValue(username)) {
			System.out.println("username was not in property "+ USER_NAME);
		} else {
			//System.out.println("using driver: " + driverClass + " at USERNAME: " + username);
			connectionProperties.put("user", username);
		}
		
		String password = props.getProperty(PASSWORD);
		if (Utilities.isEmptyValue(password)) {
			System.out.println("password was not in property "+ PASSWORD);
		} else {
			//System.out.println("using driver: " + driverClass + " at PASSWORD: " + password);
			connectionProperties.put("password", password);
		}
	}

	
	/* (non-Javadoc)
	 * @see com.IBank.database.connection.ConnectionProvider#createConnection()
	 */
	protected Connection createConnection() throws SQLException{
		Connection conn = DriverManager.getConnection(url, connectionProperties);
		return conn;
	}

}
