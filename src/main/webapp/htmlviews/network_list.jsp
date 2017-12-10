<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
		<title>Network overview</title>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	</head>

	<body>
	
		<form action="/tomcat/networks" method="get">
			<input type="submit" value="Networks index" />
		</form>
		
		<table border="1">
		
			<thead>
				<tr>
					<th>Network-ID</th>
					<th>Name</th>
					<th>Delete</th>
					<th>Connected-containers</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${requestScope.networks}" var="network">
					<tr>
						<td>${network.getId()}</td>
						<td>${network.getName()}</td>
						<td><form action="/tomcat/networks/${network.getId()}/delete" method="post"><input type="submit" value="Delete"/></form></td>
						<td>
							<c:forEach items="${requestScope.connectedContainers()}" var="containers">
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			
		</table>
		
	</body>
	
</html>