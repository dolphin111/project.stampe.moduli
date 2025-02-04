<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.fideuram.stampe.printer.EsitoStampaCorrispondenze"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.fideuram.stampe.corrispondenze.SenderMail"%>
<html>
<% EsitoStampaCorrispondenze esitoStampaCorrispondenze =  (EsitoStampaCorrispondenze)request.getAttribute("esitoStampaCorrispondenzaRendite"); 

String[] ps= (String[])request.getAttribute("sendMail");
if(esitoStampaCorrispondenze.getNumeroErroriStampaCorrispondenze()==0){
	SenderMail.sendMailBucap(ps ,"creaPdf");
}
else{
	SenderMail.sendMailBucap(ps ,"errore");
}

%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Esito Corrispondenze</title>
<link rel="stylesheet" href="./stylesheet.css" type="text/css">
</head>
<body>
<font color="black"><h2 align="center">Corrispondenza Rendite</h2></font>
<form method="POST" action='ListaFileCorrRenditeServlet' name="showall">
	<table align="center" class="dataTable1">
	  <tr style="background-color:orange">
	    <td colspan="2" align="center"><b><font color="white" size="4">Esito Corrispondenze</font></b></td>
	  </tr>
		  <tr><td colspan="2">&nbsp;</td></tr>
	  <tr> <%if(esitoStampaCorrispondenze.getListaErrori().size()==0){ %>
	    <td width="100%" align="center"><b><font size="2">Elaborazione andata a buon fine</font><b></td>
	  </tr>
	  <%} %>
	  <%if (esitoStampaCorrispondenze.getListaErrori().size()>0){ %>
	   <tr>
	    <td></td>
	     <td width="100%" align="center"><b><font size="2" color="red">Si e' verificato un errore</font><b></td>
	  </tr>
	  <%} %>
	  <tr><td colspan="2">&nbsp;</td></tr>
	  <tr><td colspan="2" align="right"><input type="submit" name="indietro" value="Indietro" class="buttonMenuLong"/> </td></tr>
	</table>
	
</form>
<br>
<div style="border: 0px;">
	<jsp:include page="/archivia.jsp"></jsp:include>
</div>
</body>
</html>