<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Class</title>
</head>
<body >
<jsp:include page="Header.jsp"></jsp:include>
<form action="classreportServlet" >
<fieldset>
<br/>
		<br/>
		 <br/>
		 Select Class:<select name="class" id="class">
		 <option value="1">A</option>
		 <option value="2">B</option>
		  </select>
		  <br/>
		  <br/>
		  <input type="submit" value="View report">
</fieldset>
</form>
</body>
</html>