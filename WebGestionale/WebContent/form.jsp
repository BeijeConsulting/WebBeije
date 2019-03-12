<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci Dipendenti</title>
</head>
<body>

<form action="test" method = "post">
 
Nome:    <input type = "text" name = "nome"> <br>
Cognome: <input type="text" name= "cognome"> <br>
Data Nascita: <input type="text" name ="data_nascita"> <br>
Luogo Nascita: <input type="text" name = "luogo_nascita"> <br>
Sesso:         <input type="text" name = "sesso"> <br>
CF:           <input type="text" name = "codice_fiscale"> <br>
Cell:         <input type="text" name = "telefono"> <br>
Mail:         <input type="text" name= "mail"> <br>
<input type="submit" name = "submit" value = "Invia i dati al db">


</form>

</body>
</html>