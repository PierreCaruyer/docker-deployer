<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
	<title>Container overview</title>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>

	<body>
		<form action="/tomcat/containers" method="get">
			<input type="submit" value="Containers index" />
		</form>
		<table border="1">
			<thead>
				<tr>
					<th>Container-ID</th>
					<th>Image</th>
					<th>Status</th>
					<th>Delete</th>
					<th>Commit</th>
					<th>Start/Stop</th>
					<th>Pause/Resume</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.containers}" var="container">
					<tr>
						<td>${container.getId()}</td>
						<td>${container.getImage()}</td>
						<td>${container.getStatus()}</td>
						<td><form action="/tomcat/containers/${container.getId()}/delete" method="post"><input type="submit" value="Delete"/></form></td>
						<td><form action="/tomcat/containers/${container.getId()}/commit" method="post"><input type="submit" value="Commit"/></form></td>
						<c:choose>
							<c:when test="${container.getStatus().startsWith('Up')}">
								<td><form action="/tomcat/containers/${container.getId()}/stop" method="post"><input type="submit" value="Stop"/></form></td>
							</c:when>
							<c:otherwise>
								<td><form action="/tomcat/containers/${container.getId()}/start" method="post"><input type="submit" value="Start"/></form></td>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${container.getStatus().contains('Paused')}">
								<td><form action="/tomcat/containers/${container.getId()}/resume" method="post"><input type="submit" value="Resume"/></form></td>
							</c:when>
							<c:otherwise>
								<td><form action="/tomcat/containers/${container.getId()}/pause" method="post"><input type="submit" value="Pause"/></form></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>