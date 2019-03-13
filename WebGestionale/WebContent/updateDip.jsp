<%@page import="it.beije.utils.DButils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dipendente modificato</title>
</head>
<body>
	<% String codiceFiscale = request.getParameter("codice_fiscale");
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String sesso = request.getParameter("sesso");
		String dataNascita = request.getParameter("data_nascita");
		String luogoNascita = request.getParameter("luogo_nascita");
		String mail = request.getParameter("mail");
		String telefono = request.getParameter("telefono");
		DButils.modificaDipendente(id,codiceFiscale, nome, cognome, sesso, dataNascita, luogoNascita, mail, telefono);%>
		Dipendente modificato con successo!
		
		<br>
		<a href="home.html">Home</a>
</body>
</html>