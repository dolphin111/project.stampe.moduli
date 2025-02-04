<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.fideuram.stampe.modello.quietanza.EsitoStampaQuietanze"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<html>
<% EsitoStampaQuietanze esitoStampaQuietanze =  (EsitoStampaQuietanze)request.getAttribute("esitoStampaQuietanze"); %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Esito Quietanze</title>
<link rel="stylesheet" href="./stylesheet.css" type="text/css">
</head>
<body>
<form method="POST" action='ListaFileQuietanzeServlet' name="showall">
	<table width="600px" border="1" align="center" class="dataTable">
	  <tr>
	    <td colspan="2"><b><font size="4">Esito Quietanze</font></b></td>
	  </tr>
	  <tr><td colspan="2">&nbsp;</td></tr>
	  <tr>
	    <td width="40%">Numero Bonifici Stampati</td>
	    <td width="60%"><%=esitoStampaQuietanze.getNumeroBonificiStampati() %></td>
	  </tr>
	  <tr>
	  	<td width="40%">Numero Assegni Stampati</td>
	  	<td width="60%"><%=esitoStampaQuietanze.getNumeroAssegniStampati() %></td>
	  </tr>
	  <tr><td colspan="2">&nbsp;</td></tr>
	</table>
	  
	<table width="600px" border="1" align="center" class="dataTable">
	  <tr>
	    <td width="40%">Numero Errori</td>
	    <td width="60%"><%=esitoStampaQuietanze.getNumeroErroriStampaQuietanze() %></td>
	  </tr>
	  <%for(int i=0;i<esitoStampaQuietanze.getListaErrori().size();i++){ %>
	   <tr>
	    <td>Numero Protocollo-Nome File</td>
	    <td class="infoMessage"><%=esitoStampaQuietanze.getListaErrori().get(i) %></td>
	  </tr>
	  <%} %>
	  <tr><td colspan="2">&nbsp;</td></tr>
	  <tr><td colspan="2" align="right"><input type="submit" name="indietro" value="Indietro" class="buttonMenuLong"/> </td></tr>
	</table>
	
</form>
<br>
<div style="border: 2px;">
	<jsp:include page="/archivia.jsp"></jsp:include>
</div>
</body>
</html>