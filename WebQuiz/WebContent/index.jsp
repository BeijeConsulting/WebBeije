<%@page import="java.io.File"%>
<%@page import="java.time.Duration"%>
<%@page import="it.beije.utils.Utils"%>
<%@page import="it.beije.bean.Domanda"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inizia il tuo Quiz OnLine</title>

<style>
body{
background: rgb(173,245,255); /* Old browsers */
background: -moz-linear-gradient(-45deg, rgb(173,245,255) 7%, rgb(219,249,227) 50%, rgb(235,253,253) 100%); /* FF3.6-15 */
background: -webkit-linear-gradient(-45deg, rgb(173,245,255) 7%,rgb(219,249,227) 50%,rgb(235,253,253) 100%); /* Chrome10-25,Safari5.1-6 */
background: linear-gradient(135deg, rgb(173,245,255) 7%,rgb(219,249,227) 50%,rgb(235,253,253) 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#adf5ff', endColorstr='#ebfdfd',GradientType=1 ); /* IE6-9 fallback on horizontal gradient */
}
</style>
</head>
<%
File f = new File("pippo");
System.out.println(f.getAbsolutePath());
List<Domanda> domande = Utils.readFileDomande("/Users/bastard-mac_sss/git/WebBeije/WebQuiz/WebContent/domande/20180311.xml");
session.putValue("elencoDomande", domande);

int tot = domande.size();
Duration duration = Duration.ofMinutes(tot * 2);
session.putValue("duration", duration);

%>

<body>

Questa è la pagina di ingresso al tuo Quiz Online<br>
<br>
Totale domande caricate : <%= tot %><br>
Tempo disponibile : <%= tot * 2 %> minuti<br>
<br>
<input type="button" value="START" onclick="location.href='./StartQuiz'">

</body>
</html>