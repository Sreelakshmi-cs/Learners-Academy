<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>

<style>

body {
  font-family: 'Courier New', monospace;
}
fieldset {
  align=center;
}

</style>
</head>
<body style="background-color:#FFEDDA;">
<jsp:include page="Header.jsp"></jsp:include>

<h2>Admin Homepage</h2><br/><br/>

<fieldset>
1.<a href="readsubjectServlet">Manage Subjects</a><br/>
<br/>
2.<a href="readteacherServlet">Manage Teachers</a><br/>
<br/>
3.<a href="readclassServlet">Manage Classes</a><br/>
<br/>
4.<a href="readstudentServlet">Manage Students</a><br/>
<br/>
5.<a href="SelectClass.jsp">Class Report</a>

</fieldset>


</body>
</html>