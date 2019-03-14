<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="it.beije.utils.DButils"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String ID = request.getParameter("ID");
String nome = request.getParameter("nome");
String cognome = request.getParameter("cognome");
String data_nascita = request.getParameter("data_nascita");
String luogo_nascita = request.getParameter("luogo_nascita");
String genere = request.getParameter("genere");
String telefono = request.getParameter("telefono");
String email = request.getParameter("email"); %>

<% DButils.modificaDipendente(ID, nome, cognome, data_nascita, luogo_nascita, genere, telefono, email); %>

</body>
</html>