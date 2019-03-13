<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<jsp:useBean id="dipendente" class="it.beije.gestionale.entities.Dipendente" scope="session"> </jsp:useBean>
<a title = "Torna alla HomePages" href = "start.jsp"> Home</a>
<form action = "servlet" method = "post">
  Nome  : <input type = "text" name = "nome" value="<%=dipendente.getNome() %>"/>
  <br /><br />
  Cognome : <input type = "text" name = "cognome" value="<%=dipendente.getCognome() %>" />
  <br/><br />
  Sesso : <input type="radio" name="sesso" value="M">M
  <input type="radio" name="sesso" value="F">F
  <br /><br />
  Data di Nascita: <input type="text" name="data_nascita" value="<%=dipendente.getDataNascita() %>"/>
  <br /><br />
  Mail: <input type = "text" name = "mail" value="<%=dipendente.getMail() %>"/>
  <br/> <br />
  <input type = "submit" value = "Invio" />
</form>
</body>
</html>