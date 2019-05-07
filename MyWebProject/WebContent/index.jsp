<%@page import="java.util.Date"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Web Project</title>
</head>
<body>
CIAO SURABAYA, sono la tua prima JSP<br>
Sono le ore : <%= new Date() %>

<br><br>
<form action="rubrica" method="post">
  First name:<br>
  <input type="text" name="firstname">
  <br>
  Last name:<br>
  <input type="text" name="lastname">
  <br>
  Phone:<br>
  <input type="text" name="phone">
  <br><br>
  <input type="submit" value="INVIO">
</form>

</body>
</html>