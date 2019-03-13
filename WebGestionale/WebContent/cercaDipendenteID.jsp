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
	<form action="" method="post">
		<%
			String id = request.getParameter("id");
			// 			if (id != "") {
			List<String> dipendenti = DButils.cercaDipendenteID(Integer.parseInt(id));
			
			String nome = dipendenti.get(1);
			// 			} else {
			// 				response.getWriter().append("NESSUN UTENTE TROVATO");
			// 			}
		%>

		Nome: <input type="text" name="nome" value="<%=nome%>"> <br />
		<input type="submit" value="Submit" />
<!-- 		DEVE ANCHE MODIFICARE -->
	</form>
	<br>
	<a href="dbDipendenti.jsp"> Torna al database dipendenti </a>
</body>
</html>