<%@ page contentType = "text/html; charset = UTF-8" %>
<html>
   <head>
      <title>Create a container</title>
   </head>
   
   <body>
   	  <form action="/tomcat/containers" method="get">
      	<input type="submit" value="Containers index"/>
      </form>
      <form action="/tomcat/containers/create" method="post">
      	<p>Image	 		: <input type="text" name="image" id="image"/></p>
     	<p><input type="submit" value="submit"/></p>
      </form>
   </body>
</html>