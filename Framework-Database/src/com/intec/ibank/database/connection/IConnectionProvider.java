 package com.intec.ibank.database.connection;
 import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
 
/**
  * Copyright.
  * 
  * Interface to be implemented for handling the Database Connection 
  */
 public interface IConnectionProvider {
 	
	 /**
	  * Sets the properties.
	  *
	  * @param props the new properties
	  * @throws SQLException the sQL exception
	  */
	 public void setProperties(Properties props) throws SQLException;
 	
	 /**
	  * Gets the connection.
	  *
	  * @return the connection
	  * @throws SQLException the sQL exception
	  */
	 public Connection getConnection() throws SQLException;
 	
	 /**
	  * Close connection.
	  *
	  * @param conn the conn
	  * @throws SQLException the sQL exception
	  */
	 public void closeConnection(Connection conn) throws SQLException;
 	
	 /**
	  * Close.
	  *
	  * @throws SQLException the sQL exception
	  */
	 public void close() throws SQLException;
}
 
 
 
 
 
 
 
