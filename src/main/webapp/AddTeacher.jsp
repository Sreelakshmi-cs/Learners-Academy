<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Teacher</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<form action"=addteacherServlet" method="post">
<fieldset>
<br/><br/>
		<legend>Teacher Form</legend> <br/>
		
Teacher Name:<input type="text" name="tname" id="tname"><br/><br/>
Age: <input type="text" name="tage" id="tage"><br/><br/>
Gender:<input type="radio" name="gender"  value="male" >Male
<input type="radio" name="gender"  value="female" >Female 
<input type="radio" name="gender"  value="other" >Other<br/><br/>
Subject Assign:<input type="text" name="subid" id="subid"><br/><br/>

<input type="submit" value="Register">
<br/>
 </fieldset>
</form>
</body>
</html>