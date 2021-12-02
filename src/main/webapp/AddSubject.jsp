<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add subject</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<form action"=addteacherServlet" method="post">
<fieldset>

<br/><br/>
		<legend>Subject Form</legend> <br/>
		
Subject Name:<input type="text" name="name" id="name"><br/><br/>
Subject Code: <input type="text" name="code" id="code"><br/><br/>

<input type="submit" value="ADD">
<br/>

 </fieldset>
</form>
</body>
</html>