<%@ page contentType = "text/html; charset = UTF-8" %>
<html>
   <head>
      <title>Create a network</title>
   </head>
   
   <body>
   	  <form action="/tomcat/networks" method="get">
      	<input type="submit" value="Networks index"/>
      </form>
      <form action="/tomcat/networks/create" method="post">
      	<p>Network name 	: <input type="text" name="network" id="network"/></p>
      	<p>Network type		: <input type="text" name="driver" id="driver"/></p>
     	<p><input type="submit" value="submit"/></p>
      </form>
   </body>
</html>