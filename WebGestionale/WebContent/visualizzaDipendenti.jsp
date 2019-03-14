<%@page import="it.beije.utils.DButils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elenco Dipendenti</title>
</head>
<body>
	Inserisci nome e/o cognome del dipendente che stai cercando: <br>
	<form action = "dipendentiTrovati.jsp" method = "post">
	Nome: <input type = "text" name="nome"><br>
	Cognome: <input type = "text" name = "cognome"><br>
  <input type = "submit" value = "Cerca dipendente"  />
</form>
	<br>
	
	Ricerca un dipendente per id e modifica: <br>
	<form action = "formModifica.jsp">
	ID: <input type = "text" name="id">
	<input type = "submit" value = "Ricerca ID">
	</form>
	<br>
	Se invece vuoi visualizzare tutti i dipendenti clicca qui:
	
  <input type = "submit" value = "Visualizza i dipendenti" name="buttonTutti" onclick="myFunction()" />
  <br>
  <p id="demo"></p>
  <script type="text/javascript">
  function myFunction()
  {
	  <% String str = DButils.visualizzaTuttiDipendenti(); %>
	   var s = "<%=str%>"; 
	   document.getElementById("demo").innerHTML = s;
  }
  
  </script>

<a href="start.jsp">Torna alla Home</a>
	
  



</body>
</html>