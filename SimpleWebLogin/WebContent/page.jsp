<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina principale</title>
</head>
<body>
<%
String user = (String)session.getAttribute("utente_autenticato");
if (user == null) {
%>
	<p>NON SEI UN UTENTE AUTORIZZATO!</p><br>
	<a href="login.jsp">TORNA ALLA PAGINA DI LOGIN</a>	
<%
} else {
	out.print("BENVENUTO " + user + "!!!");
}
%>

</body>
</html>