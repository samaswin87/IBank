
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="com.intec.ibank.*" %>
<%@ page import="com.intec.ibank.pojo.Ibanklogin" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="../../js/Rightclickdisable.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="../../css/style.css" />
<title>Nokia - I - Bank Login</title>
</head>

<body>
			<%
			
			HttpSession userSession = request.getSession(true);
				
			%>
			
			<div id="nokiaimg"> 
				<img src="../../images/NOL_login_image.jpg">
			</div>
			<div id="ibankhead">
			 <!-- 	<img  src="../../images/cooltext680653548.gif"> -->
			 
			 
			 <a><font class="serif">'I'-BANK</font></a>
			 
			 </div>
			 			 
			 <div id="innovation" style="position: absolute;left:380px; margin-top: 80px;">
			 <div>
					 <a><font size="6px;" class="sansserif">(Innovation Bank)</font></a>
					 
			</div>
			</div>
			 
 		<div id="innovation" style="position: absolute;left:620px; margin-top: 225px;">
			 
					<img  src="../../images/2.JPG"> 
			</div>
<%			

				if(request.getParameter("username") != null)
				{			
				Ibanklogin iObj=new Ibanklogin();
				iObj.ss(request,response);
				}
			
			%> 
<div id="newlogin">
<br><br>
<form action="sd.jsp" method="post" onsubmit="return validateForm();" >
<table align="center">
	
	<tr>
	<br>
	<tr height="40px">
	<td>
	
	<font color="#ECE5B6" class="sansserif" style="font-style: normal; font-size:15px;">Nokia Id </font></td>
	</tr>
	
	<tr align="center"> 
		
		<td> <input type="text" size="20" id="username"  title="Nokia Id" name="username"  onclick="showhide(0);" /></td>
	</tr>
	
	<tr height="30px">
	<td><font color="#ECE5B6" class="sansserif" style="font-style: normal; font-size:15px; ">Access Card Number</font></td></tr>
	<tr align="center">
		<td> <input type="password" size="20" id="password"  title="Access Card Number" name="password" onclick="showhide(1);"  /> </td> 
	</tr>
	<tr height="10px"></tr>
	<tr align="center">
		<td>
		<div id="nokiaid" style="display:none;">
			<table align="center">
			<%				
				int userdigit=1;
				for(int i=0;i<3;i++)
				{
					out.println("<tr align='center'>");
					for(int j=0;j<3;j++)
					{
						out.println("<td width='48px'><input type='button' value='"+(userdigit)+"' onclick='fun1("+(userdigit++)+")'; /></td>");
					}
					out.println("</td>");
				}
			%>
			<tr align="center">
				<td> <input type="button" value="0" onclick='fun1(0)' /> </td>
				<td colspan="2"> <input type="button" value="Clear" style="width:82px" onclick="doBackspace();"></td> 
			</table>
		</div>
		<div id="accessid" style="display:none;">
			<table align="center">
			<%				
				int userdigit1=1;
				for(int i=0;i<3;i++)
				{
					out.println("<tr align='center'>");
					for(int j=0;j<3;j++)
					{
						out.println("<td width='48px'><input type='button' value='"+(userdigit1)+"' onclick='fun2("+(userdigit1++)+")'; /></td>");
					}
					out.println("</td>");
				}
			%>
			<tr align="center">
				<td> <input type="button" value="0" onclick='fun2(0)'/> </td>
				<td colspan="2"> <input type="button" value="Clear" style="width:82px" onclick="doBackspace1();"></td> 
			</table>
		</div>
		</td>
	</tr>
	<tr height="10px"></tr>
	<tr align="center">
		 <td> 
			<input type="submit" value="Submit" style="height:32px"/>
			<input type="reset" value="Cancel"  style=" height:32px; width:72px; "/>
		 </td>
	</tr>
</table>
</form>
</div>

<div id="marqueetech" style="position:absolute; left:-20px; top:262px;  ">
		<img src="../../images/1.JPG" >
</div>

<div id="marqueestyleeforhomelogin">

	<marquee direction="up" height="300px" width="300px" scrollamount="2"ONMOUSEOVER="this.stop();" ONMOUSEOUT="this.start();"> 

			<ol><font size="5px" color="#7D053F"  class="sansserif" style="font-style: inherit;">Do you have new ideas  / thoughts /    initiatives ??</font></ol>
			<ol><font size="5px" color="#7D053F" class="sansserif"style="font-style: inherit;"> Then use 'I' Bank to share your thoughts now!!</font></ol>
			<ol><font size="5px" color="#7D053F" style="font-style: inherit;">&#2953;&#2969;&#3021;&#2965;&#2995;&#3007;&#2975;&#2990;&#3021; &#2986;&#3009;&#2980;&#3007;&#2991;   &#2965;&#2992;&#3009;&#2980;&#3021;&#2980;&#3009;&#2965;&#3021;&#2965;&#2995;&#3021; ,           &#2990;&#3009;&#2991;&#2993;&#3021;&#2970;&#3007;&#2965;&#2995;&#3021;,   &#2958;&#2979;&#3021;&#2979;&#2969;&#3021;&#2965;&#2995;&#3021; &#2951;&#2992;&#3009;&#2965;&#3021;&#2965;&#3007;&#2993;&#2980;&#3006;..?</font></ol>
			<ol><font size="5px" color="#7D053F" style="font-style: inherit;"> &#2953;&#2969;&#3021;&#2965;&#2995;&#3009;&#2975;&#3016;&#2991; &#2965;&#2992;&#3009;&#2980;&#3021;&#2980;&#3009;&#2965;&#3021;&#2965;&#2995;&#3016;   I-Bank-&#2994;&#3021; &#2986;&#2980;&#3007;&#2997;&#3009; &#2970;&#3014;&#2991;&#3021;&#2991;&#3009;&#2969;&#3021;&#2965;&#2995;&#3021;.</font></ol>
		
			<ol><font size="5px" color="#7D053F" class="sansserif"style="font-style: inherit;">About 'I' bank or Innovation Bank:</font></ol>
			<ol><font size="5px" color="#7D053F" style="font-style: inherit;">i-Bank &#2986;&#2993;&#3021;&#2993;&#3007;&#2991; &#2997;&#3007;&#2997;&#2992;&#2969;&#3021;&#2965;&#2995;&#3021;.</font></ol>
			<ol><font size="4px" color="white"class="sansserif">'I' bank is an interactive& innovative tool where you can post your ideas about process improvement, product improvement, business development, etc.,</font></ol>
			<ol><font size="4px" color="white"class="sansserif">process improvement, product improvement, business development &#2986;&#2993;&#3021;&#2993;&#3007;&#2991; &#2965;&#2992;&#3009;&#2980;&#3021;&#2980;&#3009;&#2965;&#3021;&#2965;&#2995;&#3016;  I-Bank -&#2994;&#3021; &#2986;&#2980;&#3007;&#2997;&#3009; &#2970;&#3014;&#2991;&#3021;&#2991;&#2994;&#3006;&#2990;&#3021;.,</font></ol>
			<ol><font size="4px" color="white"class="sansserif">No proper channel to share your ideas - just walk in and drop your ideas in 'I' bank.</font></ol>
			<ol><font size="4px" color="white">&#2953;&#2969;&#3021;&#2965;&#2995;&#3021; &#2965;&#2992;&#3009;&#2980;&#3021;&#2980;&#3009;&#2965;&#3021;&#2965;&#2995;&#3016; &#2986;&#2965;&#3007;&#2992;&#3021;&#2984;&#3021;&#2980;&#3009; &#2965;&#3018;&#2995;&#3021;&#2995; &#2970;&#2992;&#3007;&#2991;&#3006;&#2985;  &#2997;&#2996;&#3007;  i-Bank-&#2994;&#3021; &#2953;&#2995;&#3021;&#2995;&#2980;&#3009;.</font></ol>
			<ol><font size="4px" color="white"class="sansserif">Accepted ideas will be implemented as projects as early as possible based on business requirements and Rejected ideas will be in our database for future reference.</font></ol>
			<ol><font size="4px" color="white">Business &#2980;&#3015;&#2997;&#3016;&#2965;&#2995;&#3016; &#2986;&#3018;&#2992;&#3009;&#2980;&#3021;&#2980;&#3009; &#2959;&#2993;&#3021;&#2993;&#3009;&#2965;&#3021;&#2965;&#3018;&#2995;&#3021;&#2995;&#2986;&#3021;&#2986;&#2975;&#3021;&#2975; Idea-&#2965;&#3021;&#2965;&#2995;&#3021; &#2949;&#2990;&#2994;&#3021; &#2986;&#2975;&#3009;&#2980;&#3021;&#2980;&#2986;&#3021;&#2986;&#2975;&#3009;&#2990;&#3021;.</font></ol>
			
			<ol><font size="4px" color="white">&#2984;&#3007;&#2992;&#3006;&#2965;&#2992;&#3007;&#2965;&#3021;&#2965;&#2986;&#3021;&#2986;&#2975;&#3021;&#2975;  idea-&#2965;&#3021;&#2965;&#2995;&#3021; &#2958;&#2969;&#3021;&#2965;&#2995;&#2980;&#3009; database-&#2994;&#3021; &#2951;&#2992;&#3009;&#2965;&#3021;&#2965;&#3009;&#2990;&#3021;.</font></ol>
 			<ol><font size="4px" color="white"class="sansserif">You can view the status of your ideas in 'I' bank</font></ol>
			<ol><font size="4px" color="white">I-Bank-&#2994;&#3021; &#2953;&#2969;&#3021;&#2965;&#2995;&#3009;&#2975;&#3016;&#2991; Idea-&#2965;&#3021;&#2965;&#2995;&#3007;&#2985; &#2980;&#2993;&#3021;&#2986;&#3015;&#3006;&#2980;&#3016;&#2991; &#2984;&#3007;&#2994;&#3016;&#2991;&#3016; &#2949;&#2993;&#3007;&#2984;&#3021;&#2980;&#3009; &#2965;&#3018;&#2995;&#3021;&#2995;&#2994;&#3006;&#2990;&#3021;.</font></ol>
			<ol><font size="5px" class="sansserif"color="#7D053F" style="font-style: inherit;">It is easy to use 'I' bank!!!</font></ol>
			<ol><font size="5px" color="#7D053F" style="font-style: inherit;">I-Bank &#2953;&#2986;&#2991;&#3015;&#3006;&#2965;&#3007;&#2965;&#3021;&#2965;&#3009;&#2990;&#3021; &#2997;&#2996;&#3007; &#2990;&#3009;&#2993;&#3016;&#2965;&#2995;&#3021;.</font></ol>
			<ol><font size="5px" class="sansserif"color="white" style="font-style: inherit;">	Enter your Nokia ID</font></ol>
			<ol><font size="5px" class="sansserif"color="white" style="font-style: inherit;">Enter first four or five digits of your access card number ( back side of your access card contains 13 to 14 digit number, please enter only four or first 5 digits)</font></ol>
			<ol><font size="5px" class="sansserif"color="white" style="font-style: inherit;">Click Submit to enter into 'I' bank an innovative& interactive tool. </font></ol>
			<ol><font size="5px" color="white" style="font-style: inherit;">	Nokia-Id=&#2991;&#3016; &#2986;&#2980;&#3007;&#2997;&#3009; &#2970;&#3014;&#2991;&#3021;&#2991;&#2997;&#3009;&#2990;&#3021;</font></ol>
			
			<ol><font size="5px" color="white" style="font-style: inherit;">Access Card-&#2985;&#3021; &#2986;&#3007;&#2985;&#3021;&#2986;&#3009;&#2993;&#2990;&#3021; &#2953;&#2995;&#3021;&#2995; 4-&#2951;&#2994;&#2965;&#3021;&#2965; &#2949;&#2994;&#3021;&#2994;&#2980;&#3009; 5-&#2951;&#2994;&#2965;&#3021;&#2965; &#2958;&#2979;&#3021;&#2985;&#3016; &#2986;&#2980;&#3007;&#2997;&#3009; &#2970;&#3014;&#2991;&#3021;&#2991;&#2997;&#3009;&#2990;&#3021;</font></ol>
			
			<ol><font size="5px" color="white" style="font-style: inherit;">I-Bank-&#2985;&#3009;&#2995;&#3021; &#2984;&#3009;&#2996;&#3016; &#2997;&#2980;&#2993;&#3021;&#2965;&#3021;&#2965;&#3009; Submit button-&#2991;&#3016; &#2949;&#2996;&#3009;&#2980;&#3021;&#2980;&#2997;&#3009;&#2990;&#3021; </font></ol>
		
		</marquee>  
</div>

	<div id="alretnokiaimage"  style="position:absolute; top:340px; left:180px; display:none">
		<img src="../../images/cooltext680658504.gif" onclick="imagehide()"/> 
	</div>
	<div id="alretimage"  style="position:absolute; top:340px; left:330px; display:none">
		<img src="../../images/cooltext680655868.gif" onclick="imagehide()"/> 
	</div>
	 <div id="alretpassimage"  style="position:absolute; top:340px; left:220px; display:none">
		<img src="../../images/cooltext680656490.gif" onclick="imagehide()" /> 
	</div> 
		
	<div id="alretaccessimage"  style="position:absolute; top:660px; left:18px; display:none" >
						<!-- <img src="../../images/cooltext683488874.gif" /> -->
						
	<a ><font size="8px" style="font-family: serif; font-style: oblique;" color="#250517"> Please enter your first four digit's or five digit's of your Access Card Number</font></a>
						 
	</div>
</body>
</html>