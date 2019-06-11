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
*@File Ibankloginimpl.java
*@Author Bala
*@Date Jul 3, 2012 10:16:30 AM
*@Version 1.1
 */
package com.intec.ibank.implementation.employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.intec.ibank.employee.IbankloginIntfs;
import com.intec.ibank.provider.ApplicationDaoProvider;

/**
 * @author Bala
 * @Date Jul 3, 2012  10:16:30 AM
 * @Version %I%, %G%
 */
public class Ibankloginimpl implements IIbanklogin
{

	
	/**
	 * @author Bala
	 * @Date Jul 3, 2012 10:18:36 AM
	 * @param request
	 * @param response
	 * @return
	 * @see com.intec.ibank.implementation.IIbanklogin#checkUser(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public boolean checkUser(HttpServletRequest request,HttpServletResponse response) 
	{
		String un=request.getParameter("username");
		String pw=request.getParameter("password");
		
		System.out.println(un);
		System.out.println(pw);
		IbankloginIntfs intfObj=ApplicationDaoProvider.getInstance().getIbanklogin();
		boolean cj=intfObj.checkUser(un, pw); 
			System.out.println(cj);
		return false;
	}
 
	
}
