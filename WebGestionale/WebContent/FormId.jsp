<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Change data Id</title>
</head>
<body>
<jsp:useBean id="dipendente" class="it.beije.gestionale.entities.Dipendente" scope="session"></jsp:useBean> 
<form action = "" method = "post">
  Nome  : <input type = "text" name = "nome" value="<%=dipendente.getNome()%>">
  <br /><br />
  Cognome : <input type = "text" name = "cognome" value="<%=dipendente.getCognome()%>"/>
  <br/><br />
  Sesso :<% if(dipendente.getSesso() == 'M') { %> <input type="radio" name="sesso" value="M" checked>M
  <input type="radio" name="sesso" value="F">F <% } else { %> 
  <input type="radio" name="sesso" value="M">M
  <input type="radio" name="sesso" value="F" checked>F <% } %>
  <br /><br />
  Data di Nascita: <input type="text" name="data_nascita"value="<%=dipendente.getDataNascita()%>">
  <br /><br />
  Mail: <input type = "text" name = "mail" value="<%=dipendente.getMail()%>"/>
  <br/> <br />
  <input type = "submit" value = "Invio" />
</form>
</body>
</html>