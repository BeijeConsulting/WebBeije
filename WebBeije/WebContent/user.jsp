<%@page import="it.beije.servlet.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Page</title>
</head>
<body>
<%--
User user = (User)session.getValue("utente");

if (user != null) { --%>

<jsp:useBean id="utente" class="it.beije.servlet.User" scope="session"></jsp:useBean>  

Nome : <%= utente.getNome() %><br>
Cognome : <%= utente.getCognome() %><br>
Sesso : <%= utente.getSesso() %><br>
eMail : <%= utente.getEmail() %><br>
Telefono : <%= utente.getTelefono() %><br>
Iscritto : <% try {	if(! utente.getIscrizione().equals(null)) out.print("Sì!");}
				catch(NullPointerException npe) { out.print("No :(");}%><br>


<%-- }
else { out.print("NESSUN UTENTE IN SESSIONE"); }
--%>
</body>
</html>