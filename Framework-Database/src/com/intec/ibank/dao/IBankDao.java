package com.intec.ibank.dao;

import org.restlet.ext.spring.SpringContext;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.intec.ibank.database.IIBankDatabaseConnector;

/**
 * Copyright.
 * 
 * This is used by the Dao Classes to connect with the Database
 */
public abstract class IBankDao extends BaseIBankDao{
	
	/** The Constant connector. */
	private static final IIBankDatabaseConnector connector;

	/**
	 * Instantiates a new IBank dao.
	 */
	public IBankDao() {
		super();
	}
	
	static{
		String contextPath = "Database-Interactions.xml"; 

		SpringContext springContext = new SpringContext(null);
		XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(springContext);
		xmlReader.loadBeanDefinitions(new ClassPathResource(contextPath));
		springContext.refresh();
		connector = (IIBankDatabaseConnector)springContext.getBean("database.connector");
	}

	protected final IIBankDatabaseConnector getConnector(){
		return connector;
	}

}
