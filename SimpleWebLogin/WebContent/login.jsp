<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>

<p>Inserisci le tue credenziali per continuare</p>

<form action="LoginServlet" method="post">
	USER:&nbsp;<input type="text" name="user"><br>
	PASSWORD:&nbsp;<input type="password" name="password"><br>
	<input type="submit" value="LOGIN">
</form>

</body>
</html>