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
		function attenzione() {
			alert('Hai eliminato tutti i dipendenti dalla lista!');
			window.location = "dbDipendenti.jsp";
		}
		attenzione();
	</script>
	<br>
	<%
		DButils.eliminaTabella();
		DButils.creaTabella();
	%>
</body>
</html>