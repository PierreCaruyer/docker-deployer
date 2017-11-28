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
					<th>Image-ID</th>
					<th>Size</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.images}" var="image">
					<tr>
						<td>${image.getId()}</td>
						<td>${image.getSize()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>