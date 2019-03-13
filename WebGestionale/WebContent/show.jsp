<%@page import="it.beije.utils.CSVutils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dipendenti Azienda</title>
</head>
<body>
<p><a title = "Torna alla home" href = "start.jsp"> <input type = "submit" value = "Home Page" /></a></p>
<button  onclick="mostraDip()">Visualizza dipendenti</button>
<p id="show"></p>
<script>
function mostraDip() {
	<% String str =  CSVutils.selectFromDB().toString(); %>
	var s = "<%= str %>"
	document.getElementById("show").innerHTML = s;
}
</script>
 <br/><br/>
 <a title = "Inserisci nuovo dipendente" href = "form.jsp"> Inserisci nuovo dipendente</a>
</body>
</html>