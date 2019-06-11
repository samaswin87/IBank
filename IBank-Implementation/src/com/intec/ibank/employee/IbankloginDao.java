/**  
Copyright (c) 2012, Intecminds
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above
      copyright notice, this list of conditions and the following
      disclaimer in the documentation and/or other materials provided
      with the distribution.
    * Neither the name of the intecminds nor the names
      of its contributors may be used to endorse or promote products
      derived from this software without specific prior written
      permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
POSSIBILITY OF SUCH DAMAGE.
*@File IbankloginDao.java
*@Author Bala
*@Date Jul 3, 2012 10:43:15 AM
*@Version 1.1
 */
package com.intec.ibank.employee;

import com.intec.ibank.dao.IBankDao;
import com.intec.ibank.databaseConnector.criteria.RestrictionCriteria;
import com.intec.ibank.databaseConnector.criteria.select.SelectConstraints;
import com.intec.ibank.databaseConnector.object.dataTable.DataTable;
import com.intec.ibank.databaseConnector.object.dataTable.DataTableRow;
import com.intec.ibank.log.IBankLogger;


/**
 * @author Bala
 * @Date Jul 3, 2012  10:43:15 AM
 * @Version %I%, %G%
 */
public class IbankloginDao  extends IBankDao implements IbankloginIntfs 
{

	/**
	 * @author Bala
	 * @Date Jul 3, 2012 10:43:44 AM
	 * @param username
	 * @param password
	 * @return
	 * @see com.intec.ibank.intfs.IbankloginIntfs#checkUser(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean checkUser(String username, String password) 
	{
		try
		{ 
	
			SelectConstraints constraints = new SelectConstraints();
							 constraints.addWhereCriteria(RestrictionCriteria.equalCrit(EMPLOYEE_ID_COLUMN_NAME, username));
						     constraints.addWhereCriteria(RestrictionCriteria.equalCrit(EMPLOYEE_ACCESS_CARD_COULMN_NAME, password));
		
			DataTable dtaTable =this.retrieveRows(EMPLOYEE_TABLE_NAME, constraints);
				
			if(dtaTable != null)
			{
				DataTableRow[] rows = dtaTable.getRows();
	
				if ((rows != null) && (rows.length > 0)) 
				{
					return true;
				}
			}
		} 
		catch (Throwable ex) 
		{
			IBankLogger.log(ex);
		}
	return false;
	}
 
	
}
