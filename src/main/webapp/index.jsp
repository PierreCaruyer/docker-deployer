<%@ page contentType = "text/html; charset = UTF-8" %>
<html>
   <head>
      <title>Home</title>
   </head>
   <body>
      <form action="/tomcat/clients">
      	<input type="submit" value="Clients" name="clients" />
      </form>
      <form action="/tomcat/containers">
      	<input type="submit" value="Containers" name="containers" />
      </form>
      <form action="/tomcat/images">
      	<input type="submit" value="Images" name="images" />
      </form>
   </body>
</html>