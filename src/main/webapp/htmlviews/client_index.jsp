<%@ page contentType = "text/html; charset = UTF-8" %>
<html>
   <head>
      <title>Clients index</title>
   </head>
   <body>
      <form action="/tomcat/">
      	<input type="submit" value="Home" name="home" />
      </form>	
      <form action="/tomcat/clients/list">
      	<input type="submit" value="List clients" name="list" />
      </form>
      <form action="/tomcat/clients/create">
      	<input type="submit" value="Create client" name="create" />
      </form>
   </body>
</html>