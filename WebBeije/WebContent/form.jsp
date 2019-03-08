<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questo è un form</title>
</head>
<body>

<form action = "process.jsp" method = "get">
  First Name: <input type = "text" name = "first_name">
  <br />
  Last Name: <input type = "text" name = "lastName" />
  <input type = "submit" value = "Submit" />
  <input type="checkbox" name="check1" value="valore1">check1
  <input type="checkbox" name="check2" value="valore2">check2
  <input type="checkbox" name="check3" value="valore3">check3
</form>

<%-- jsp:useBean id="utente" class="it.beije.servlet.User" scope="session"></jsp:useBean>  

FirstName : <%= utente.getFirstName() %><br>
LastName  : <%= utente.getLastName() %>
--%>
</body>
</html>