<%@page import="it.beije.utils.DButils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cerca dipendente</title>
</head>
<body>
	<%
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		// 		String id = request.getParameter("id");
		// 		if (id == "") {
		String dipendente = DButils.cercaDipendenteNC(nome, cognome);
		if (dipendente != "") {
			response.getWriter().append(dipendente);
		} else {
			response.getWriter().append("NESSUN UTENTE TROVATO");
		}
		// 		} else {
		// 			response.getWriter().append(DButils.cercaDipendenteID(Integer.parseInt(id)));
		// 		}
	%>
	<br>
	<a href="dbDipendenti.jsp"> Torna al database dipendenti </a>
</body>
</html>