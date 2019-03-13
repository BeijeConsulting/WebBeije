<%@page import="it.beije.utils.SearchNome"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca per nome</title>
</head>
<body>
<form action="cerca" method = "post">
Inserisci il nome per cercare i dati del Dipendente <br> <br>

Nome: <input type = "text" name ="nome">
<input type="submit" value = "cerca">
</form>
</body>
</html>