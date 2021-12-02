<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Class</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<form action"=addclassServlet" method="post">
<fieldset>
<br/><br/>
		<legend>Class Form</legend> <br/>
		
Class Name:<input type="text" name="cname" id="cname"><br/><br/>

<input type="submit" value="ADD">
<br/>
 </fieldset>
 
</form>

</body>
</html>