<%@ page contentType = "text/html; charset = UTF-8" %>
<html>
   <head>
      <title>Disconnect from a network</title>
   </head>
   
   <body>
   	  <form action="/tomcat/networks" method="get">
      	<input type="submit" value="Networks index"/>
      </form>
      <form action="/tomcat/networks/disconnect" method="post">
      	<p>Network ID 	: <input type="text" name="network" id="network"/></p>
      	<p>Container ID 	: <input type="text" name="container" id="container"/></p>
     	<p><input type="submit" value="submit"/></p>
      </form>
   </body>
</html>