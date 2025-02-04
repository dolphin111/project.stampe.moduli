<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<html>
<% 

List<String> listaFileCorrispondenzaRendite =  (ArrayList<String>)request.getAttribute("listaFileCorrispondenzaRendite"); 

String showButton =  (String)request.getAttribute("showButton"); 
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Generazione Stampe Corrispondenza Rendite</title>
<link rel="stylesheet" href="./stylesheet.css" type="text/css">
<script src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">

/*function show_hide(id){
	 var e = document.getElementById(id);
	 e.style.display = 'block';
}*/

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
	xhr.open('POST', 'http://fvwvcrmcr0p.fidevita.bancafideuram.it:80/corrispondenze.web/CorrispondenzaRenditeServlet', true);
	// link per l'ambiente di sviluppo
	//xhr.open('POST', 'http://localhost:8080/deployable.war.corrispondenze.web/CorrispondenzaRenditeServlet', true);
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
<form method="POST" action='CorrispondenzaRenditeServlet' name="showall" >
<font color="black"><h2 align="center">Corrispondenza Rendite</h2></font>	
<br />
<!-- div id="loader" style="display:none;" class="transparent">
	<p></p><div style=" margin-top: 15%; margin-bottom: 50%;margin-left: 36%; width: 400px; height: 150px; background: #fff;/* bottom: 100px;">
      <p></p><div margin-top="10%" align="center">Attendere...</div><p></p>
     		<p></p><div align="center"><img src="images/v3_loading.gif"></div><p></p>
          <p></p> <div align="center">L'operazione potrebbe richiedere alcuni minuti.</div>
	</div>
</div-->
	<table width="600px" border="0" align="center" class="dataTable1">
      <tr style="background-color:orange">
        <td colspan="2" align="center"><b><font color="white" size="4">Lista File Da Generare </font></b></td>
      </tr>
    <tr><td colspan="2">&nbsp;</td>
      </tr>
     
    <%for(int i=0;i<listaFileCorrispondenzaRendite.size();i++){ int contatore = i+1;%>
      <tr>
        <td><font size="2"><b><%=contatore %>.</b></font></td>
        <td><font size="2"><b><%=listaFileCorrispondenzaRendite.get(i) %></b></font></td>
      </tr>
      <%} %>
      <tr><td colspan="2">&nbsp;</td></tr>
      <tr>
      <%if(listaFileCorrispondenzaRendite.size() == 0){ %>
             <td colspan="2" align="center">Non ci sono file PDF da generare</td>
        <%}else{ %>
       
       		  <%if(showButton != null && showButton.equalsIgnoreCase("true"))
              { %>
	              <td colspan="2" align="right">
	              <!-- input type="submit" name="function" value="Crea PDF Rendite"  class="buttonMenuLong" style="visibility:visible;" onClick="this.style.visibility='hidden';show_hide('loader');"/-->
	              <input type="submit" name="function" value="Crea PDF Rendite"  class="buttonMenuLong" style="visibility:visible;" onClick="this.style.visibility='hidden';callServlet();"/>
	              </td>
	        <%} %>   
        <%} %>
      </tr>
    </table>
	
</form>
<br>
<div style="border: 0px;">
	<jsp:include page="/archivia.jsp"></jsp:include>
</div>
</body>
</html>