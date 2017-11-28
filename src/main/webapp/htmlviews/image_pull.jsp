<%@ page contentType = "text/html; charset = UTF-8" %>
<html>
   <head>
      <title>Pull an image</title>
   </head>
   
   <body>
   	  <form action="/tomcat/images" method="get">
      	<input type="submit" value="Containers index"/>
      </form>
      <form action="/tomcat/images/pull" method="post">
      	<p>Image	 		: <input type="text" name="image" id="image"/></p>
     	<p><input type="submit" value="submit"/></p>
      </form>
   </body>
</html>