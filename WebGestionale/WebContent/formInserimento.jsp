<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Form Dipendente</title>
	</head>
	<body>
		<form action = "inserisciDip.jsp" method = "post">
 			 Nome: <input type = "text" name = "nome">
 			 <br />
 			 Cognome: <input type = "text" name = "cognome" />
 			  <br />
  			Sesso:
 			 <input type="radio" name="sesso" value="M">M
 			 <input type="radio" name="sesso" value="F">F
 			 <br />
 			  Codice fiscale: <input type = "text" name = "codice_fiscale">
 			 <br />
 			 Data di nascita: <input type = "text" name = "data_nascita">
 			 <br />
 			 Luogo di nascita: <input type = "text" name = "luogo_nascita">
 			 <br />
 			 Mail: <input type = "text" name = "mail" />
 			 <br />
 			 Telefono: <input type = "text" name = "telefono" />
 			 <br />
  			<input type = "submit" value = "Inserisci" />
  			<br>
		<a href="home.html">Home</a>
		</form>
	</body>
</html>