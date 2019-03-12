<%@page import="it.beije.utils.DButils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inserimento Dipendente</title>
</head>
<body>
	<form action = "inserimentoDipendenti.jsp" method = "POST">
	  Nome: <input type = "text" name = "nome">
	  <br />
	  Cognome: <input type = "text" name = "cognome" />
	  <br/>
	  Data di nascita: <input type = "text" name = "data_nascita">
	  <br/>
	  Luogo di nascita: <input type = "text" name = "luogo_nascita">
	  <br/>
	  Sesso: 
	  <input type="radio" name="sesso" value ="M"> M
	  <input type="radio" name="sesso" value = "F"> F
	  <br/>
	  Codice Fiscale: <input type = "text" name = "codice_fiscale">
	  <br/>
	  Telefono: <input type = "text" name = "telefono">
	  <br/>
	  Mail: <input type = "text" name = "mail">
	  <br/>
	  <input type = "submit" value = "Submit" />

		<%
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String dataNascita = request.getParameter("data_nascita");
			String luogoNascita = request.getParameter("luogo_nascita");
			String sesso = request.getParameter("sesso");
			String codiceFiscale = request.getParameter("codice_fiscale");
			String telefono = request.getParameter("telefono");
			String mail = request.getParameter("mail");

			DButils.inserimentoDipendente(nome, cognome, dataNascita, luogoNascita, sesso, codiceFiscale, telefono,
					mail);
		%>

	</form>
	<a href="dbDipendenti.jsp"> Torna al database dipendenti </a>
</body>
</html>