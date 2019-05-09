<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fine</title>
</head>
<body>
<b>HO SALVATO I DATI IN RUBRICA</b>

<jsp:useBean id="utente" class="it.beije.web.bean.User" scope="session"></jsp:useBean>

<br><br>
<jsp:getProperty property="firstName" name="utente"/><br>  
<jsp:getProperty property="lastName" name="utente"/><br> 
<jsp:getProperty property="phone" name="utente"/><br> 

</body>
</html>