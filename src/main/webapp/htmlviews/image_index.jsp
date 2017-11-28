<%@ page contentType = "text/html; charset = UTF-8" %>
<html>
   <head>
      <title>Containers index</title>
   </head>
   <body>
      <form action="/tomcat/">
      	<input type="submit" value="Home" name="home" />
      </form>	
      <form action="/tomcat/images/list">
      	<input type="submit" value="List images" name="list" />
      </form>
      <form action="/tomcat/images/pull">
      	<input type="submit" value="Pull image" name="pull" />
      </form>
   </body>
</html>