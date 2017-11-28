<%@ page contentType = "text/html; charset = UTF-8" %>
<html>
   <head>
      <title>Containers index</title>
   </head>
   <body>
      <form action="/tomcat/">
      	<input type="submit" value="Home" name="home" />
      </form>	
      <form action="/tomcat/containers/list">
      	<input type="submit" value="List containers" name="list" />
      </form>
      <form action="/tomcat/containers/create">
      	<input type="submit" value="Create container" name="create" />
      </form>
   </body>
</html>