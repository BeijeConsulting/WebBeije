<%@page import="it.beije.utils.DButils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Avvenuta modifica</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		String nomeMod = request.getParameter("nome");
		String cognomeMod = request.getParameter("cognome");
		String dataNascitaMod = request.getParameter("data_nascita");
		String luogoNascitaMod = request.getParameter("luogo_nascita");
		String sessoMod = request.getParameter("sesso");
		String codiceFiscaleMod = request.getParameter("codice_fiscale");
		String telefonoMod = request.getParameter("telefono");
		String mailMod = request.getParameter("mail");

		DButils.modificaDipendente(nomeMod, cognomeMod, dataNascitaMod, luogoNascitaMod, sessoMod, codiceFiscaleMod,
				telefonoMod, mailMod, Integer.parseInt(id));
		
		response.getWriter().append("Modifica Avvenuta!");
	%>
	<br>
	<a href="dbDipendenti.jsp"> Torna al database dipendenti </a>
</body>
</html>