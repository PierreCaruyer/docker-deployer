<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
	<title>Client overview</title>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>

<body>

	<form action="/tomcat/clients" method="get">
		<input type="submit" value="Users index" />
	</form>
	
	<table border="1">
		<thead>
			<tr>
				<th>Client-ID</th>
				<th>First name</th>
				<th>Last name</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.clients}" var="aclient">
				<tr>
						<td>${aclient.id}</td>
						<td>${aclient.firstName}</td>
						<td><!--<a href="http://localhost:8080/tomcat/clients/${aclient.id}/display/">-->${aclient.lastName}<!--</a>--></td>
						<td><form action="/tomcat/clients/${aclient.id}/delete" method="post"><input type="submit" value="Delete"/></form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
