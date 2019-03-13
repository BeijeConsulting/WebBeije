<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="it.beije.utils.DButils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cerca dipendente</title>
</head>
<body>
		<%
			String id = request.getParameter("id");
			List<String> dipendenti = new ArrayList<>();
			if (id != "") {
				dipendenti = DButils.cercaDipendenteID(Integer.parseInt(id));
			} else {
				response.getWriter().append("NESSUN UTENTE TROVATO");
			}
			String nome = "";
			String cognome = "";
			String dataNascita = "";
			String luogoNascita = "";
			String sesso = "";
			String codiceFiscale = "";
			String telefono = "";
			String mail = "";
			if (dipendenti.size() != 0) {
				nome = dipendenti.get(1);
				cognome = dipendenti.get(2);
				dataNascita = dipendenti.get(3);
				luogoNascita = dipendenti.get(4);
				sesso = dipendenti.get(5);
				codiceFiscale = dipendenti.get(6);
				telefono = dipendenti.get(7);
				mail = dipendenti.get(8);
			%>
			<form action="modificaAvvenuta.jsp" method="post">
				<input type="hidden" name="id" value="<%=id%>">
				Nome: <input type="text" name="nome" value="<%=nome%>"> <br />
				Cognome: <input type = "text" name = "cognome" value="<%=cognome%>">
				<br/>
				Data di nascita: <input type = "text" name = "data_nascita" value="<%=dataNascita%>">
				<br/>
				Luogo di nascita: <input type = "text" name = "luogo_nascita" value="<%=luogoNascita%>">
				<br/>
				Sesso: 
				<% if(sesso == "M") { %>
					<input type="radio" name="sesso" value ="M" checked="checked"> M
					<input type="radio" name="sesso" value = "F"> F
				<% } else { %>
					<input type="radio" name="sesso" value ="M"> M
					<input type="radio" name="sesso" value = "F" checked="checked"> F
				<% } %>
				<br/>
				Codice Fiscale: <input type = "text" name = "codice_fiscale" value="<%=codiceFiscale%>">
				<br/>
				Telefono: <input type = "text" name = "telefono" value="<%=telefono%>">
				<br/>
				Mail: <input type = "text" name = "mail" value="<%=mail%>">
				<br/>
				<input type="submit" value="Submit" />
			</form>
			<% } else {
				response.getWriter().append("NESSUN UTENTE TROVATO");
			}
		%>
	<br>
	<a href="dbDipendenti.jsp"> Torna al database dipendenti </a>
</body>
</html>