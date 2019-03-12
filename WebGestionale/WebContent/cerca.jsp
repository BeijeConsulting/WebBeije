<%@page import="it.beije.utils.SearchID"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca per ID</title>
</head>
<body>
Inserisci l'ID per cercare i dati del Dipendente <br> <br>
<form action = "ricerca.jsp" method = "get">
ID: <input type = "text" nome ="id">
<input type="submit" value ="cerca">

</form>
</body>
</html>