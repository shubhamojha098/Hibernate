<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr><th>Id</th><th>Name</th><th>Address</th><th>Mobile</th><th>Delete</th></tr>
<c:forEach var="row" items="${ list}">
<tr>
<td>${row.id }</td>
<td>${row.empname }</td>
<td>${row.empaddress }</td>
<td>${row.empmobile }</td>
<td><a href=deleterecord?sid=${row.id}>Delete</a></td>
</tr>
</c:forEach>

</table>
</body>
</html>