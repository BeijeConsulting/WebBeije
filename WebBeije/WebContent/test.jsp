<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Date"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questo è un test</title>
</head>
<body>
<p>OGGI : </p>
<%= new Date() %>
<p>DOMANI : </p>
<%= LocalDate.now().plusDays(1) %>
<br>
<%
out.print("in sessione : <br><br>");

//out.print(Arrays.toString(session.getValueNames()));
//session.putValue("param1", request.getParameter("param1"));

		StringBuilder builder = new StringBuilder();
		Enumeration<String> paramNames = request.getParameterNames();
		String name;
		while (paramNames.hasMoreElements()) {
			name = paramNames.nextElement();
			builder.append(name).append(" : ")
			.append(request.getParameterMap().get(name)[0])
			.append("<br>");
		}
out.print(builder.toString());
%>
<br>

<%-- for (int i = 10; i < 20; i++) { %><%= i %><br><% } --%>

<br>
<br>
<img alt="" src="./img/logo_beije_simbolo.png" width="200px">
</body>
</html>