<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
 <%@page import="it.beije.utils.DButils"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Qui puoi modificare le tue informazioni</title>
</head>
<body>

<% List listadip = DButils.visualizzadip(Integer.parseInt(request.getParameter("ID")));%>

<form action = "modificadati.jsp" method = "get">

  Nome : <input type = "text" name = "nome" value = <%= listadip.get(1)%> />
  <br />
  Cognome : <input type = "text" name = "cognome" value = <%= listadip.get(2)%> />
  <br/>
  Data di nascita : <input type = "text" name = "data_nascita" value = <%= listadip.get(3)%>/>
  <br/>
  Luogo di nascita : <input type = "text" name = "luogo_nascita" value = <%= listadip.get(4)%>/>
  <br/>
  Genere : <input type = "text" name = "genere" value = <%= listadip.get(5)%> />
  <br/>
  Telefono : <input type = "text" name = "telefono" value = <%= listadip.get(6)%> />
  <br/>
  Email : <input type = "text" name = "email" value = <%= listadip.get(7)%>/>
 <input type = "submit" value = "Vai"/>
  
</form>
</body>
</html>