<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<html>
<% 
List<String> listaFileAssegni =  (ArrayList<String>)request.getAttribute("listaFileAssegni"); 
List<String> listaFileBonifici =  (ArrayList<String>)request.getAttribute("listaFileBonifici");
String showButton =  (String)request.getAttribute("showButton");  
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Generazione Stampe Quietanze</title>
<link rel="stylesheet" href="./stylesheet.css" type="text/css">

<script type="text/javascript">

/* 	G.C.-20170419 Funzione javascript necessaria ad eseguire la chiamaata asincrona alla servlet CorrispondenzaRenditeServlet */
function callServlet(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			var data = xhr.responseText;
			tempAlert("<center>Stampa dei documenti avviata. </center><center>L'operazione potrebbe richiedere alcuni minuti. </center>",5000);
		}
	}
	// link per l'ambiente di produzione
	xhr.open('POST', 'http://fvwvcrmcr0p.fidevita.bancafideuram.it:80/quietanze.web/QuietanzaServlet', true);
	// link per l'ambiente di sviluppo
	//xhr.open('POST', 'http://localhost:8080/deployable.war.quietanze.web/QuietanzaServlet', true);
	xhr.send(null);
}

function tempAlert(msg,duration)
{
	 var el = document.createElement("div");
	 el.setAttribute("style","position:absolute;top:20%;left:30%;background-color:#F7921D;");
	 el.innerHTML = msg;
	 setTimeout(function(){
	  el.parentNode.removeChild(el);
	 },duration);
	 document.body.appendChild(el);
}

</script>

</head>
<body>
<form method="POST" action='QuietanzaServlet' name="showall">
<h2 align="center">Stampa Quietanze</h2>	
<br />	
<table width="600px" border="1" align="center" class="dataTable">
      <tr>
        <td colspan="2" align="center"><b><font size="4">Lista File Bonifici</font></b></td>
      </tr>
      <tr><td colspan="2">&nbsp;</td></tr>
     
    <%for(int i=0;i<listaFileBonifici.size();i++){ int contatoreBon = i+1; %>
      <tr>
        <td><%=contatoreBon %>.</td>
        <td><%=listaFileBonifici.get(i) %></td>
      </tr>
      <%} %>
      <tr><td colspan="2">&nbsp;</td></tr>
      <tr>
      <%if(listaFileBonifici.size() == 0){ %>
             <td colspan="2" align="center">Non ci sono file PDF (lotti di bonifici) da generare</td>
        <%}else{ %>
        
        	 <%if(showButton != null && showButton.equalsIgnoreCase("true"))
              { %>
           
	             <td colspan="2" align="right">
	             <!-- input type="submit" name="function" value="Crea PDF Bonifici" class="buttonMenuLong" /-->
	              <input type="submit" name="function" value="Crea PDF Bonifici" class="buttonMenuLong" style="visibility:visible;" onClick="this.style.visibility='hidden';callServlet();"/>
	             </td>
            <%} %>
        <%} %>
      </tr>
    </table>
    <br /><br />
	<table width="600px" border="1" align="center" class="dataTable">
      <tr>
        <td colspan="2" align="center"><b><font size="4">Lista File Assegni</font></b></td>
      </tr>
      <tr><td colspan="2">&nbsp;</td></tr>
     
    <%for(int i=0;i<listaFileAssegni.size();i++){ int contatore = i+1;%>
      <tr>
        <td><%=contatore %>.</td>
        <td><%=listaFileAssegni.get(i) %></td>
      </tr>
      <%} %>
      <tr><td colspan="2">&nbsp;</td></tr>
      <tr>
      <%if(listaFileAssegni.size() == 0){ %>
             <td colspan="2" align="center">Non ci sono file PDF (lotti di assegni) da generare</td>
        <%}else{ %>
        
        	 <%if(showButton != null && showButton.equalsIgnoreCase("true"))
              { %>
       
	              <td colspan="2" align="right">
	              <!-- input type="submit" name="function" value="Crea PDF Assegni" class="buttonMenuLong"/-->
	              <input type="submit" name="function" value="Crea PDF Assegni" class="buttonMenuLong" style="visibility:visible;" onClick="this.style.visibility='hidden';callServlet();"/>
	              </td>
	         <%} %>
        <%} %>
      </tr>
    </table>
	
</form>
<br>
<div style="border: 2px;">
	<jsp:include page="/archivia.jsp"></jsp:include>
</div>
</body>
</html>