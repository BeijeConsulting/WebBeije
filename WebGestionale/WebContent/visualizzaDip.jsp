<%@page import="it.beije.utils.DButils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Dati dipendenti</title>
	</head>
	<body>
		<%
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		
		%>
		<%= DButils.visualizzaDipendenti(nome, cognome) %>
		<br>
		<a href="home.html">Home</a>
	</body>
</html>