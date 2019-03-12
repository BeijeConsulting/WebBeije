<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Database Dipendenti</title>
</head>
<body>
	<form action="cercaDipendente.jsp" method="get">
		<strong>Cerca dipendente</strong> <br>
		<i>Per Nome e Cognome</i> <br>
		Nome: <input type="text" name="nome"> <br>
		Cognome: <input type="text" name="cognome"> <br>
		<input type = "submit" value = "Submit" /> <br>
	</form> <br>
	<form action="cercaDipendente.jsp" method="get">
		<i>Per id</i> <br>
		Id: <input type="text" name="id"> <br />
		<input type="submit" value="Submit" />
	</form> <br>
	<a href="inserimentoDipendenti.jsp"> Inserisci dipendente </a> <br>
	<a href="mostraDipendenti.jsp"> Lista dipendenti </a>
</body>
</html>