<%@ page import= "it.beije.utils.ReadNomeCognome" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nome e Cognome Dipendente</title>
</head>
<body>
<% out.print(ReadNomeCognome.readNomeCognome()); %>

<form action = "ReadFile.jsp" method = "get">
<br>
 <input type = "submit" value = "Visualizza Dipendenti"/>
</body>
</html>