<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CaPadaForm</title>
</head>
<body>

<form action = "servlet" method = "post">
  <strong>Nome:</strong> <input type = "text" name = "nome" />
  <br /><br />
  <strong>Cognome:</strong> <input type = "text" name = "cognome" />
  <br /><br />
  <strong>Sesso:</strong> <input type="radio" name="sesso" value="M"><strong>  <font color=blue> M </font></strong> 
  <input type="radio" name="sesso" value="F"><strong> <font color=red> F </font></strong> 
  <br /><br />
  <strong>eMail:</strong> <input type = "text" name = "email">
  <br /><br />
  <strong>Telefono:</strong> <input type = "text" name = "telefono" /><br /><br />
  <strong> Iscriviti:</strong><input type = "checkbox" name = "iscrizione"  />  <br /><br />
  <input type = "submit" value = "Invio" />
</form>

<%-- jsp:useBean id="utente" class="it.beije.servlet.User" scope="session"></jsp:useBean>  

FirstName : <%= utente.getFirstName() %><br>
LastName  : <%= utente.getLastName() %>
--%>
</body>
</html>