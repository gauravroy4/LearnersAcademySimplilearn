<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error page</title>
</head>
<body>
Unexpected error has occoured...... <br>  
Exception= <%= exception %>  
<br/><a href="Dashboard">Click here to return to Home Page</a>
</body>
</html>