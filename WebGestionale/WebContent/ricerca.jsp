<%@page import="it.beije.gestionale.entities.Dipendente"%>
<%@ page import= "it.beije.utils.SearchNome" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Risultati</title>
</head>
<body>
 <% out.print(request.getParameter("nome"));
out.print(SearchNome.CercaNome(request, response));%>


</body>
</html>