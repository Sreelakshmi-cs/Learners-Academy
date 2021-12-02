<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<h2  align="center" style="color:Tomato;"><u>  ~~~ Learner's Academy ~~~ </u></h2><br/>
<style>
fieldset {
  background-color: #eeeeee;
}
</style>
<form action="Home.jsp">
<fieldset>
		<br/>
		<br/>
		<legend>Login Form</legend> <br/>
		Username: <input type="text" name="uname" id="uname" /> <br/>
		<br/>
	    Password: <input type="password" name="password" id="password" /> <br/>
	    <br/>
		<input type="submit" value="Login" />
</fieldset>
</form>
</body>
</html>