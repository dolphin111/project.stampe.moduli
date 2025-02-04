<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
       <%@page
       	import="com.fideuram.stampe.modello.corrispondenza.*"%>
       <%@page import="java.util.List"%>
       <%@page import="java.util.ArrayList"%>
       <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
       <title>Riepilogo Corrispondenze Generate</title>
       <link rel="stylesheet" href="./stylesheet.css" type="text/css">
       <html>
       <%
       	List<String> listaFileCorrispondenzaRenditeGenerati = (ArrayList<String>) request
       			.getSession().getAttribute("listaFileCorrispondenzaRenditeGenerati");
       %>
       <%
       	List<String> listaFileCorrispondenzaRenditeArchiviare = (ArrayList<String>) request
       			.getSession().getAttribute("listaFileCorrispondenzaRenditeArchiviare");
       %>
       <%
       	String message = (String) request.getAttribute("message");
       int count= listaFileCorrispondenzaRenditeGenerati.size();
       %>
       <head>
       <script src="js/jquery-1.11.0.min.js"></script>
       
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
			xhr.open('POST', 'http://fvwvcrmcr0p.fidevita.bancafideuram.it:80/corrispondenze.web/ArchiviazioneServlet', true);
			// link per l'ambiente di sviluppo
			//xhr.open('POST', 'http://localhost:8080/deployable.war.corrispondenze.web/ArchiviazioneServlet', true);
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
       	<form method="POST" action='ArchiviazioneServlet' name="showall">
       <!-- div id="loader1" style="display:none;" class="transparent">
       	<p></p><div style=" margin-top: 15%; margin-bottom: 50%;margin-left: 36%; width: 400px; height: 150px; background: #fff;/* bottom: 100px;">
             <p></p><div margin-top="10%" align="center">Attendere...</div><p></p>
       		<p></p><div align="center"><img src="images/v3_loading.gif"></div><p></p>
            <p></p> <div align="center">L'operazione potrebbe richiedere alcuni minuti.</div>
       	</div>
       </div-->

       		<table name="contenitore" align="center" width="45%" border="0">
       			<%
       				if (message != null && !message.equals("")) {
       			%>
       			<tr>
       				<td colspan="2" class="infoMessage">ESITO: <%=message%></td>
       			</tr>
       			<%
       				}
       			%>
       			<tr>
       				<td width="50%">
       					<table name="contenuto1" width="100%" class="dataTable">
       						<tr style="background-color:orange">
       						<!-- Da archiviare -->
       							<td colspan="2"><b><font color="white" size="4">Corr./Arch.Benef</font></b></td>
       						</tr>
       						<tr>
       							<td>
       							<!-- Inserire questo path se si effettua il deploy in produzione
       								href="file://///10.100.8.173/ftpprod/VR110$PU/generati/" -->
       								<!-- Inserire questo path se si effettua il deploy in test
                                       href="file://///10.100.8.34/ftptest/VR110$PU/generati/" -->
<!--  
       							<a href="file://///10.100.8.173/ftpprod/VR110$PU/generati/"
       								target="_blank"><b><font size="2">Apri Cartella</font></b></a>
-->       
       							<a href="file:///spimi/jboss/7.3/userApps/shared/ftpprod/VR110$PU/generati/"
       								target="_blank"><b><font size="2">Apri Cartella</font></b></a>								
       							</td>
       						</tr>
       						<tr>
       							<td colspan="2">&nbsp;</td>
       						</tr>

       						<%
       							for (int i = 0; i < listaFileCorrispondenzaRenditeGenerati.size(); i++) {
       						%>

       						<tr title="Nome File">
       							<td><%=listaFileCorrispondenzaRenditeGenerati.get(i)%></td>
       							<td><input type="checkbox"  name="corrispondenzaRenditeArchiviare"
       								value="<%=listaFileCorrispondenzaRenditeGenerati.get(i)%>" ></td>
       						</tr>
       						<%
       							}
       						%>
       						<tr>
       							<td colspan="2">&nbsp;</td>
       						</tr>
       						<tr>
       							<%
       								if (listaFileCorrispondenzaRenditeGenerati.size() == 0) {
       							%>
       							<td colspan="2" align="center">Non ci sono Corrispondenze da
       								archiviare</td>
       							<%
       								} else {
       							%>

       							<td colspan="2" title="Presenti sia Polizze con Beneficiario diverso da Contrente e sia polizze con Contraente uguale Beneficiario, ma con ROL passiva, che attendono di essere postalizzate" align="right">
       							<input type="submit" id ="BArchivia" name="function" value="Archivia Corrispondenze"  />
       							</td>
       							<%
       								}
       							%>
       						</tr>
       					</table>
       				</td>
       				<td width="50%">
       					<table name="contenuto2" width="100%" class="dataTable">

       						<tr style="background-color:orange">
       						<!-- Da stampare -->
       							<td colspan="2" ><b><font color="white" size="4">Corr./Arch. Cnt/Ben</font></b></td>
       						</tr>
       						<tr>
       							<td>
       								<!-- Inserire questo path se si effettua il deploy in produzione
       								href="file://///10.100.8.173/ftpprod/VR110$PU/archiviati/" -->
<!-- 
       							<a	href="file://///10.100.8.173/ftpprod/VR110$PU/archiviati/"
       								target="_blank"><b><font size="2">Apri Cartella</font></b></a>
 -->       				
        						<a	href="file:///spimi/jboss/7.3/userApps/shared/ftpprod/VR110$PU/archiviati/"
       								target="_blank"><b><font size="2">Apri Cartella</font></b></a>				
       							</td>
       						</tr>
       						<tr>
       							<td colspan="2">&nbsp;</td>
       						</tr>

       						<%
       							for (int i = 0; i < listaFileCorrispondenzaRenditeArchiviare.size(); i++) {
       						%>
       						<tr title="Nome Cartella">
       							<td><%=listaFileCorrispondenzaRenditeArchiviare.get(i)%></td>
       							<td><input type="checkbox" name="corrispondenzaRenditeStampare" id="d_<%=i %>"
       								value="<%=listaFileCorrispondenzaRenditeArchiviare.get(i)%>" ></td>
       						</tr>
       						<%
       							}
       						%>
       						<tr>
       							<td colspan="2">&nbsp;</td>
       						</tr>
       						<tr>
       							<%
       								if (listaFileCorrispondenzaRenditeArchiviare.size() == 0) {
       							%>
       							<td colspan="2" align="center">Non ci sono Corrispondenze
       								da stampare</td>
       							<%
       								} else {
       							%>

       							<td colspan="2" align="right">
       							<!-- input type="submit" title=" Presenti le polizze con Contrente uguale a Beneficiario e con ROL attiva" name="function" value="Stampa Corrispondenze" id ="BStampa"/-->
       							<input type="submit" title=" Presenti le polizze con Contrente uguale a Beneficiario e con ROL attiva" name="function" value="Stampa Corrispondenze" id ="BStampa" style="visibility:visible;" onClick="this.style.visibility='hidden';callServlet();"/>
       							</td>

       							<%
       								}
       							%>
       						</tr>
       					</table>
       				</td>
       			</tr>
       		</table>

       	</form>

       </body>
       </html>