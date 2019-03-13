<%@page import="it.beije.utils.DButils"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 	<% List dip = DButils.visualizzaDipendenti(Integer.parseInt(request.getParameter("id"))); 
 		if(dip.size()!=1) {%>
	<form action = "updateDip.jsp" method = "get">
 			
 			 ID: <input type = "text" name = "id" value = <%= dip.get(0) %> readonly="readonly"> 
 			 <br>
 			 Nome: <input type = "text" name = "nome" value = <%= dip.get(1) %>>
 			 <br />
 			 Cognome: <input type = "text" name = "cognome" value = <%=  dip.get(2)  %>>
 			  <br />
  			Sesso: <input type = "text" name = "sesso" value = <%=  dip.get(6)  %>>

 			 <br />
 			  Codice fiscale: <input type = "text" name = "codice_fiscale" value = <%=  dip.get(3) %>>
 			 <br />
 			 Data di nascita: <input type = "text" name = "data_nascita" value = <%=  dip.get(4)  %>>
 			 <br />
 			 Luogo di nascita: <input type = "text" name = "luogo_nascita" value = <%=  dip.get(5)  %>>
 			 <br />
 			 Mail: <input type = "text" name = "mail" value = <%=  dip.get(8)  %>>
 			 <br />
 			 Telefono: <input type = "text" name = "telefono" value = <%=  dip.get(7)  %>>
 			 <br />
  			<input type = "submit" value = "Modifica" /> 
  			<br>
		<a href="home.html">Home</a>
		</form>
		<%}else { %>
		<%=dip.get(0) %>
		<br>
		<a href="home.html">Home</a>
		<%} %>
</body>
</html>