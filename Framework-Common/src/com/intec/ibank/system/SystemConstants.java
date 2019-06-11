package com.intec.ibank.system;

/**
 * Copyright.
 * This Class is used to define the constants for the whole application using this restlet framework.
 */
public final class SystemConstants {
	
	/** The Constant COPYRIGHTS. */
	public static final String COPYRIGHTS;  

	/** The Constant TRUE_VALUE. */
	public static final String TRUE_VALUE = "1";
	
	/** The Constant FALSE_VALUE. */
	public static final String FALSE_VALUE = "0";
	
	
	public static final String XML_DECLARATION = "<?xml version='1.0' encoding='UTF-8' ?>\n";
	
	/**
	 * Instantiates a new system constants.
	 */
	private SystemConstants(){
		super();
	}
	
	static {
		COPYRIGHTS = "Copyrights ©2012 intecminds. All rights reserved.";
	}
	
	/**
	 * Gets the copy rights.
	 *
	 * @return the copy rights
	 */
	public static final String getCopyRights(){
		return SystemConstants.COPYRIGHTS;
	}

}
