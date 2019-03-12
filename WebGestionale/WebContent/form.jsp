<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DBInsertForm</title>
</head>
<body>

<form action = "servlet" method = "post">
  Nome  : <input type = "text" name = "nome">
  <br /><br />
  Cognome : <input type = "text" name = "cognome" />
  <br/><br />
  Sesso : <input type="radio" name="sesso" value="M">M
  <input type="radio" name="sesso" value="F">F
  <br /><br />
  Data di Nascita: <input type="text" name="data_nascita">
  <br /><br />
  Mail: <input type = "text" name = "mail" />
  <br/> <br />
  <input type = "submit" value = "Invio" />
</form>

<%-- jsp:useBean id="utente" class="it.beije.servlet.User" scope="session"></jsp:useBean>  

FirstName : <%= utente.getFirstName() %><br>
LastName  : <%= utente.getLastName() %>
--%>

<br/>
<a title = "Inserisci nuovo dipendente" href = "show.jsp"> Show employes</a>
</body>
</html>