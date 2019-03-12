<%@page import="it.beije.utils.ReadFile"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dipendenti</title>
</head>
<body>
<%
	out.print(ReadFile.readFile());
%>

<form action = "form.jsp" method = "get">
<br>
 <input type = "submit" value = "Inserisci un nuovo Dipendente"/>

</form>
</body>
</html>