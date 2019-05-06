<%@page import="java.util.Date"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Web Project</title>
</head>
<body>
CIAO SURABAYA, sono la tua prima JSP<br>
Sono le ore : <%= new Date() %>

<% 
	Date d = new Date();
%>
<%= d %>
<% d.compareTo(new Date()); %>
</body>
</html>