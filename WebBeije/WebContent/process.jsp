<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Process Page</title>
</head>
<body>

<jsp:useBean id="utente" class="it.beije.servlet.User" scope="session"></jsp:useBean>  
<jsp:setProperty property="nome" name="utente" />  
<jsp:setProperty property="cognome" name="utente"/>  
<jsp:setProperty property="sesso" name="utente" />  
<jsp:setProperty property="email" name="utente"/> 
<jsp:setProperty property="telefono" name="utente"/>
  
Record:<br>  
<jsp:getProperty property="nome" name="utente"/><br>  
<jsp:getProperty property="cognome" name="utente"/><br>
<jsp:getProperty property="sesso" name="utente"/><br>  
<jsp:getProperty property="email" name="utente"/><br>
<jsp:getProperty property="telefono" name="utente"/><br>    

</body>
</html>