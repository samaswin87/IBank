package com.intec.ibank.provider;

import com.intec.ibank.employee.IbankloginDao;
import com.intec.ibank.employee.IbankloginIntfs;


 
/**
 * Copyright.
 * This Class is the Application Implementation Provider 
 */
public class ApplicationDaoProvider 
{

	/** The provider. */
	private static ApplicationDaoProvider provider = null;

	/** The user store dao. */
	
	private IbankloginIntfs ibanklogin;


	

 
	/**
	 * Instantiates a new application dao provider.
	 */
	private ApplicationDaoProvider() 
	{
		super();

	
		ibanklogin=new IbankloginDao();
		
	}

	

	/**
	 * Gets the single instance of ApplicationDaoProvider.
	 *
	 * @return single instance of ApplicationDaoProvider
	 */
	public static ApplicationDaoProvider getInstance() {
		if (provider == null) {
			provider = new ApplicationDaoProvider();
		}
		return provider;
	}

	
	/**
	 * @return the ibanklogin
	 */
	public IbankloginIntfs getIbanklogin() {
		return ibanklogin;
	}

	 
}
