<%@ page contentType = "text/html; charset = UTF-8" %>
<html>
   <head>
      <title>Sign up</title>
   </head>
   
   <body>
   	  <form action="/tomcat/clients" method="get">
      	<input type="submit" value="Users index"/>
      </form>
      <form action="/tomcat/clients/create" method="post">
      	<p>First name 	: <input type="text" name="firstname" id="firstname"/></p>
      	<p>Last name 	: <input type="text" name="lastname" id="lastame"/></p>
     	<p>password	 	: <input type="text" name="password" id="password"/></p>
     	<p><input type="submit" value="submit"/></p>
      </form>
   </body>
</html>