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
		out.print(DButils.mostraDipendenti());
	%><br>

	<a href="javascript:attenzione();">Elimina lista dipendenti</a>
	<script type="text/javascript">
		function attenzione() {
			var answer = confirm('ATTENZIONE!!! Stai per eliminare tutti i dipendenti dalla lista!');
			if (answer)
				window.location = "eliminaListaDipendenti.jsp";
		}
	</script>
	<br>
	<a href="dbDipendenti.jsp"> Torna al database dipendenti </a>
</body>
</html>