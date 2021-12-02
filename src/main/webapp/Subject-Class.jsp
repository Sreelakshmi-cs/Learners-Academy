<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Subject to class</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<h3>Assign Subject-Class</h3>
<form action="Home.jsp">
<fieldset>
Enter Class : <select name="class" id="class">
		 <option value="1">A</option>
		 <option value="2">B</option>
		  </select>
		  <br/>
		  <br/>
Select Subject: <select name="sub" id="sub">
		 <option value="1">1</option>
		 <option value="2">2</option>
		 <option value="3">3</option>
		 <option value="4">4</option>	 
		  </select>
		  <br/>
		  <br/>
<input type="submit" value="Assign">
</fieldset>
</form>
</body>
</html>