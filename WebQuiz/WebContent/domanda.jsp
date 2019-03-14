<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalTime"%>
<%@page import="it.beije.utils.Utils"%>
<%@page import="it.beije.bean.Domanda"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>QUIZ</title>
</head>
<body>
<%
List<Domanda> domande = (List) session.getValue("elencoDomande");
String i = (String) request.getParameter("index");
int index = 0;
if (i != null) {
	index = Integer.parseInt(i);
}

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
LocalTime time = (LocalTime) session.getValue("time");

//System.out.println("index : " + index);
int tot = domande.size();
int secondi = tot * 2 * 60;
%>
<div id="timer" style="width: 95%; text-align: right;"><%= time.format(formatter) %></div>
<%
if (index < tot) {
	Domanda d = domande.get(index);
	String risposta = d.getRisposta().getRispostaUtente();
	if (risposta == null) risposta = "";
%>

<%--= "Book " + d.getBook() + "Chapter " + d.getChapter() + " domanda " + d.getQuestion() --%><br>
<br>
DOMANDA <%= index + 1 %> di <%= tot %><br>
<br>
<p>
<%= Utils.formattaTesto(d.getTesto()) %>
</p>
<form action = "risposta" method = "POST">
  Risposta: <input type="text" name="rispostaUtente" value="<%= risposta %>">
  <input type="hidden" name="index" value="<%= index %>">
  &nbsp;&nbsp;
  <input type = "submit" value = "Submit" />
</form>

<%
} else {
%>
DOMANDE TERMINATE
<br><br>
<a href="risposta">VEDI LE RISPOSTE</a>
<%
}
%>
<br>
<br>
<% if (index > 0) { %><a href="domanda.jsp?index=<%= index - 1 %>">&lt;&lt;Prec.</a><% } %>
&nbsp;&nbsp;&nbsp;&nbsp;
<% if (index != tot) { %><a href="domanda.jsp?index=<%= index + 1 %>">Succ.&gt;&gt;</a><% } %>

</body>

<script>
var secondi = <%= secondi - 1 %>;
var timer = setInterval(myTimer, 1000);

function myTimer() {
  document.getElementById("timer").innerHTML = secondi--;
  if (secondi < 0) {
    clearInterval(timer);
    document.getElementById("timer").innerHTML = 'TEMPO SCADUTO';
  }
}
</script>

</html>