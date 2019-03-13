<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca dipendente</title>
</head>
<body>
	<form action = "visualizzaDip.jsp" method = "post">
			Non inserire nulla per visualizzare tutti i dipendenti <br><br>
 			 Nome: <input type = "text" name = "nome">
 			 <br />
 			 Cognome: <input type = "text" name = "cognome" />
 			  <br />
  			<input type = "submit" value = "Cerca" />
  			<br>
		<a href="home.html">Home</a>
		</form>
</body>
</html>