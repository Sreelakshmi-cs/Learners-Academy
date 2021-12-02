<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta  http-equiv="Content-Type" content="text/html charset="ISO-8859-1">
<title>Student list</title>
</head>

<body style="background-color:#FFEDDA;">

<jsp:include page="Header.jsp"></jsp:include>

<h3 align="center"><u>Student Details</u></h3>

<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver" url="jdbc:mysql//localhost/academy" user="root" password="sreelakshmi"  var="ds"/>
					 
					 <sql:query dataSource="${ds}" var="result">
					 select * from student;
					 </sql:query>
					 
					 <table border="1" width="100%">
					 <tr> 
					 <td>Stud_ID</td>
					 <td>Name</td>
					 <td>Age</td>
					 <td>Gender</td>
					 <td>HomeTown</td>
					 <td>Class</td>
					 
					 </tr>
					 
					 <c:forEach var="row" items="${result.rows}">
					 <tr>
					 <td><c:out value="${row.id}"/></td>
					 <td><c:out value="${row.name}"/></td>
					 <td><c:out value="${row.gender}"/></td>
					 <td><c:out value="${row.hometown}"/></td>
					 <td><c:out value="${row.clas_id}"/></td>
					 
					 </tr>
					 </c:forEach>
					 
					 </table>

</body>
</html>