<%@ page contentType = "text/html; charset = UTF-8" %>
<html>
   <head>
      <title>Networks index</title>
   </head>
   <body>
      <form action="/tomcat/">
      	<input type="submit" value="Home" name="home" />
      </form>	
      <form action="/tomcat/networks/list">
      	<input type="submit" value="List networks" name="list" />
      </form>
      <form action="/tomcat/networks/create">
      	<input type="submit" value="Create network" name="create" />
      </form>
      <form action="/tomcat/networks/connect">
      	<input type="submit" value="Connect a container to a network" name="connect" />
      </form>
   </body>
</html>