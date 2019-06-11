package com.intec.ibank.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.intec.ibank.system.SystemConstants;

/**
 *  Copyright.
 *
 *  This Class is implement Helper functions for Property .
 */
public class PropertiesHelper {

	/**
	 * Instantiates a new properties helper.
	 */
	private PropertiesHelper() {
		super();
	}

	/**
	 * Gets the boolean.
	 *
	 * @param key the key
	 * @param properties the properties
	 * @return the boolean
	 */
	public static boolean getBoolean(String key, Properties properties) {
		if(properties == null)
			return false;
		String value = properties.getProperty(key);
		return (value == null) ? false : Boolean.valueOf(value);
	}

	/**
	 * Gets the boolean.
	 *
	 * @param key the key
	 * @param properties the properties
	 * @param defaultValue the default value
	 * @return the boolean
	 */
	public static boolean getBoolean(String key, Properties properties, boolean defaultValue) {
		if(properties == null)
			return false;
		String value = properties.getProperty(key);
		return (value == null) ? defaultValue : Boolean.valueOf(value);
	}

 	/**
	  * Gets the string.
	  *
	  * @param key the key
	  * @param properties the properties
	  * @return the string
	  */
	 public static String getString(String key, Properties properties) {
		if(properties == null)
			return null;
		String value = properties.getProperty(key);
		return (value == null) ? null : value;
	}

 	/**
	  * Gets the string.
	  *
	  * @param key the key
	  * @param properties the properties
	  * @param defaultValue the default value
	  * @return the string
	  */
	 public static String getString(String key, Properties properties, String defaultValue) {
		if(properties == null)
			return null;
		String value = properties.getProperty(key);
		return (value == null) ? defaultValue : value;
	}

	/**
	 * Gets the integer.
	 *
	 * @param key the key
	 * @param properties the properties
	 * @return the integer
	 */
	public static Integer getInteger(String key, Properties properties) {
		if(properties == null)
			return null;
		String value = properties.getProperty(key);
		return (value == null) ? null : Integer.valueOf(value);
	}

	/**
	 * Gets the integer.
	 *
	 * @param key the key
	 * @param properties the properties
	 * @param defaultValue the default value
	 * @return the integer
	 */
	public static Integer getInteger(String key, Properties properties, int defaultValue) {
		if(properties == null)
			return null;
		String value = properties.getProperty(key);
		return (value == null) ? defaultValue : Integer.valueOf(value);
	}
	
	/**
	 * Gets the properies.
	 *
	 * @param propertyFileName the property file name
	 * @return the properies
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static Properties getProperies(String propertyFileName)
	throws IOException{
		Properties props = new Properties();
		FileInputStream in = new FileInputStream(Utilities.getRealFileName(propertyFileName));
		props.load(in);
		in.close();
		return props;
		
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
