<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mi prendo i dati...</title>
</head>
<body>

<%
String firstname = request.getParameter("firstname");
String lastname = request.getParameter("lastname");

System.out.print(firstname);

out.print(firstname);
%>

<%= lastname %>

</body>
</html>