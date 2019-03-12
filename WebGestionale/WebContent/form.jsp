<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Dipendente </title>
</head>
<body>

<form action = "servlet" method = "post">
  Nome : <input type = "text" name = "nome">
  <br />
  Cognome : <input type = "text" name = "cognome" />
  <br/>
  Data di nascita : <input type = "text" name = "data_nascita"/>
  <br/>
  Luogo di nascita : <input type = "text" name = "luogo_nascita"/>
  <br/>
  Genere : <input type = "radio" name = "genere" value = "M" />M
  		   <input type = "radio" name = "genere" value = "F" />F
  <br/>
  Telefono : <input type = "text" name = "telefono" />
  <br/>
  Email : <input type = "text" name = "email"/>
 <input type = "submit" value = "Vai"/>
  
</form>

<%-- jsp:useBean id="utente" class="it.beije.servlet.User" scope="session"></jsp:useBean>  

FirstName : <%= utente.getFirstName() %><br>
LastName  : <%= utente.getLastName() %>
--%>
</body>
</html>