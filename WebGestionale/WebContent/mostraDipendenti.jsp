<%@page import="it.beije.utils.DButils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista Dipendenti</title>
</head>
<body>

	<strong>Lista dipendenti:</strong>
	<br>
	<%
		// response.getWriter().append(DButils.mostraDipendenti());
		out.print(DButils.mostraDipendenti());
	%><br>
	<a href="dbDipendenti.jsp"> Torna al database dipendenti </a>
</body>
</html>