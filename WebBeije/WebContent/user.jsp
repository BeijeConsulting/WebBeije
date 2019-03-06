<%@page import="it.beije.servlet.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina dati utente</title>
</head>
<body>
<%
User user = (User)session.getValue("utente");

if (user != null) { %>
FirstName : <%= user.getFirstName() %><br>
LastName  : <%= user.getLastName() %>
<% }
else { out.print("NESSUN UTENTE IN SESSIONE"); }
%>
</body>
</html>