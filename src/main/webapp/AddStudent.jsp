<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add Student</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<form action"=addstudentServlet" method="post">
<fieldset>
<br/><br/>
		<legend>Student Form</legend> <br/>
		
Student Name:<input type="text" name="sname" id="sname"><br/><br/>
Age: <input type="text" name="age" id="age"><br/><br/>
Gender:<input type="radio" name="gender"  value="male" >Male
<input type="radio" name="gender"  value="female" >Female 
<input type="radio" name="gender"  value="other" >Other<br/><br/>
Hometown:<input type="text" name="town" id="town"><br/><br/>
Assign Class :<input type="text" name="class_id" id="class_id"><br/><br/>

<input type="submit" value="Register">
<br/>
 </fieldset>
</form>
</body>
</html>