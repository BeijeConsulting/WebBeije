<%@page import="it.beije.utils.DButils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action = "" method = "get">
 			 
 			 Nome: <input type = "text" name = "nome" value = <% DButils.visualizzaDipendenti(Integer.parseInt(request.getParameter("id"))).get(1); %>>
 			 <br />
 			 Cognome: <input type = "text" name = "cognome" value = <% DButils.visualizzaDipendenti(Integer.parseInt(request.getParameter("id"))).get(2);  %>/>
 			  <br />
  			Sesso: <input type = "text" name = "sesso" value = <% DButils.visualizzaDipendenti(Integer.parseInt(request.getParameter("id"))).get(6);  %>>
 			 
 			 <br />
 			  Codice fiscale: <input type = "text" name = "codice_fiscale" value = <% DButils.visualizzaDipendenti(Integer.parseInt(request.getParameter("id"))).get(3);  %>>
 			 <br />
 			 Data di nascita: <input type = "text" name = "data_nascita" value = <% DButils.visualizzaDipendenti(Integer.parseInt(request.getParameter("id"))).get(4);  %>>
 			 <br />
 			 Luogo di nascita: <input type = "text" name = "luogo_nascita" value = <% DButils.visualizzaDipendenti(Integer.parseInt(request.getParameter("id"))).get(5);  %>>
 			 <br />
 			 Mail: <input type = "text" name = "mail" value = <% DButils.visualizzaDipendenti(Integer.parseInt(request.getParameter("id"))).get(8);  %>/>
 			 <br />
 			 Telefono: <input type = "text" name = "telefono" value = <% DButils.visualizzaDipendenti(Integer.parseInt(request.getParameter("id"))).get(7);  %>/>
 			 <br />
  			<input type = "submit" value = "Inserisci" />
		</form>
		
</body>
</html>