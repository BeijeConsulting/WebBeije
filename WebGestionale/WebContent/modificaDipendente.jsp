<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="it.beije.utils.DButils"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Qui puoi modificare le tue informazioni</title>
</head>
<body>
<form action = "modificaDipendente.jsp" method = "get">

  Nome : <input type = "text" name = "nome" value = <% DButils.visualizzaDipendente(Integer.parseInt(request.getParameter("ID"))).get(1);%>>
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
</body>
</html>