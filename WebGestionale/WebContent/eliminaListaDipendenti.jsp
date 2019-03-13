<%@page import="it.beije.utils.DButils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rimuovi tutti i dipendenti</title>
</head>
<body>
	<script type="text/javascript">
		alert("ATTENZIONE!!! Stai per eliminare tutti i dipendenti dalla lista!");
// 		Gia eliminato prima di alert
	</script>
	<%
		DButils.eliminaTabella();
		DButils.creaTabella();
		response.getWriter().append("Hai eliminato tutti i dipendenti dalla lista!");
	%>
	<br>
	<a href="dbDipendenti.jsp"> Torna al database dipendenti </a>
</body>
</html>