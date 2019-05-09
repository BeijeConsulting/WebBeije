<%@page import="it.beije.web.bean.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="utente" class="it.beije.web.bean.User" scope="session"></jsp:useBean>
<%--
User utente = session.getAttribute("utente");
if (utente == null) {
	utente = new User();
	session.setAttribute("utente", utente);
}
--%>

<jsp:setProperty property="firstName" name="utente" param="firstname" /> 
<% //utente.setFirstName(request.getParameter("firstname")); %>

<jsp:setProperty property="lastName" name="utente" param="lastname"/>  
<jsp:setProperty property="phone" name="utente"/>
  
Record:<br> 
<jsp:getProperty property="firstName" name="utente"/><br>

<input type="text" name="firstname" value="<%= utente.getFirstName() %>">
<%--= utente.getFirstName() --%>

<br>
<jsp:getProperty property="lastName" name="utente"/><br> 
<jsp:getProperty property="phone" name="utente"/><br> 

</body>
</html>