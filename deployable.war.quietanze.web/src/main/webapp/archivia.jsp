<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page
	import="com.fideuram.stampe.modello.quietanza.EsitoStampaQuietanze"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<html>
<%
	List<String> listaFileAssegniGenerati = (ArrayList<String>) request
			.getSession().getAttribute("listaFileAssegniGenerati");
%>
<%
	List<String> listaFileBonificiGenerati = (ArrayList<String>) request
			.getSession().getAttribute("listaFileBonificiGenerati");
%>
<%
	List<String> listaFileAssegniArchiviare = (ArrayList<String>) request
			.getSession().getAttribute("listaFileAssegniArchiviare");
%>
<%
	String message = (String) request.getAttribute("message");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Riepilogo Quietanze Generate</title>
<link rel="stylesheet" href="./stylesheet.css" type="text/css">
</head>
<body>
	<form method="POST" action='ArchiviazioneServlet' name="showall">
		<table align="center" width="600px">
			<%
				if (message != null && !message.equals("")) {
			%>
			<tr>
				<td colspan="2" class="infoMessage">ESITO ARCHIVIAZIONE: <%=message%></td>
			</tr>
			<%
				}
			%>
			<tr>
				<td width="50%">
					<table width="100%" class="dataTable">
						<tr>
							<td colspan="2"><b><font size="4">Bonifici per
										invio a BUCAP</font></b></td>
						</tr>
						<tr>
							<td><a
								href="file://///fv2k3ftpp01/ftpprod/VR114$PU/zipGeneratiBonifici/"
								target="_blank"><b><font size="2">Apri Cartella</font></b></a></td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>

						<%
							for (int i = 0; i < listaFileBonificiGenerati.size(); i++) {
						%>
						<tr title="Nome File">
							<td><%=listaFileBonificiGenerati.get(i)%></td>
							<td><input type="checkbox" name="selectedBonifici"
								value="<%=listaFileBonificiGenerati.get(i)%>"></td>
						</tr>
						<%
							}
						%>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<%
								if (listaFileBonificiGenerati.size() == 0) {
							%>
							<td colspan="2" align="center">Non ci sono Bonifici da
								archiviare</td>
							<%
								} else {
							%>

							<td colspan="2" align="right"><input type="submit"
								name="function" value="Archivia Bonifici" class="buttonMenuLong" />
							</td>
							<%
								}
							%>
						</tr>
					</table>
				</td>
				<td width="50%">
					<table width="100%" class="dataTable">
						<tr>
							<td colspan="2"><b><font size="4">Assegni da
										archiviare su Iside</font></b></td>
						</tr>
						<tr>
							<td><a
								href="file://///fv2k3ftpp01/ftpprod/VR114$PU/zipGeneratiAssegni/"
								target="_blank"><b><font size="2">Apri Cartella</font></b></a></td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>

						<%
							for (int i = 0; i < listaFileAssegniGenerati.size(); i++) {
						%>

						<tr title="Nome File">
							<td><%=listaFileAssegniGenerati.get(i)%></td>
							<td><input type="checkbox" name="selectedAssegni"
								value="<%=listaFileAssegniGenerati.get(i)%>"></td>
						</tr>
						<%
							}
						%>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<%
								if (listaFileAssegniGenerati.size() == 0) {
							%>
							<td colspan="2" align="center">Non ci sono Assegni da
								archiviare</td>
							<%
								} else {
							%>

							<td colspan="2" align="right"><input type="submit"
								name="function" value="Archivia Assegni" class="buttonMenuLong" />
							</td>
							<%
								}
							%>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td width="50%"></td>
				<td width="50%">
					<table width="100%" class="dataTable">

						<tr>
							<td colspan="2"><b><font size="4">Assegni da
										Stampare</font></b></td>
						</tr>
						<tr>
							<td><a
								href="file://///fv2k3ftpp01/ftpprod/VR114$PU/generatiAssegni/"
								target="_blank"><b><font size="2">Apri Cartella</font></b></a></td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>

						<%
							for (int i = 0; i < listaFileAssegniArchiviare.size(); i++) {
						%>
						<tr title="Nome Cartella">
							<td><%=listaFileAssegniArchiviare.get(i)%></td>
							<td><input type="checkbox" name="selectedAssegniArchiviare"
								value="<%=listaFileAssegniArchiviare.get(i)%>"></td>
						</tr>
						<%
							}
						%>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<%
								if (listaFileAssegniArchiviare.size() == 0) {
							%>
							<td colspan="2" align="center">Non ci sono lotti di assegni
								da stampare</td>
							<%
								} else {
							%>

							<td colspan="2" align="right"><input type="submit"
								name="function" value="Storicizza Assegni"
								class="buttonMenuLong" /></td>
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