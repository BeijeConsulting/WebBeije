<%@page import="it.beije.utils.DButils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dipendente inserito</title>
</head>
<body>
	<% String codiceFiscale = request.getParameter("codice_fiscale");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String sesso = request.getParameter("sesso");
		String dataNascita = request.getParameter("data_nascita");
		String luogoNascita = request.getParameter("luogo_nascita");
		String mail = request.getParameter("mail");
		String telefono = request.getParameter("telefono");
		DButils.inserisciDipendente(codiceFiscale, nome, cognome, sesso, dataNascita, luogoNascita, mail, telefono);%>
		Dipendente inserito con successo!
		<br>
		<a href="home.html">Home</a>
</body>
</html>