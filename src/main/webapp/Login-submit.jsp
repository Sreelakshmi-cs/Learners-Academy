<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login-submit</title>
</head>
<body>

<% 
	String name=request.getParameter("uname");
	String pass=request.getParameter("password");
	
	if(name==null || pass==null || pass.equals("")|| name.equals(""))
	{
		throw new ServletException(" Mandatory Parameters Seems Missing ");
	}
	else
	{
		if(name.equals("admin")&& pass.equals("admin"))
		{
			session.setAttribute("uname",name);
			RequestDispatcher re=request.getRequestDispatcher("/Home.jsp");
			re.include(request,response);			
		}
		else
		{
			throw new ServletException(":: Invalid Credentials !!! Tryagain using valid Credentials ");
			
		}
	}
%>

</body>
</html>