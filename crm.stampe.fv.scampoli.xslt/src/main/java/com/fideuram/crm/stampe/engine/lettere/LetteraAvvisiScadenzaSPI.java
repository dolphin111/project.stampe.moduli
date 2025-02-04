package com.fideuram.crm.stampe.engine.lettere;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang.StringEscapeUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.fideuram.crm.stampe.engine.modello.Lettera;
import com.fideuram.crm.stampe.engine.modello.bean.AvvisiScadenzaSPI;
import com.fideuram.crm.stampe.engine.modello.bean.Polizza;
import com.fideuram.crm.stampe.serviceclient.bi.CodificaXML;
import com.fideuram.utils.LoggingUtils;

public class LetteraAvvisiScadenzaSPI {
	private Polizza polizza;

	/**
	 * @param xml
	 * @return
	 */
	public static Map<String, Object> fromXml(String xml) {
		xml = CodificaXML.replace(xml);	    	
		try {        	
			Polizza modello = new Polizza();
//			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			
			/** Adeguamenti Sonar e PT ********************************************************/
		    DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
//		    docBuilderFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
//		    docBuilderFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
		    DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		/**********************************************************************************/
			
			org.w3c.dom.Document doc = docBuilder.parse(new InputSource(new ByteArrayInputStream(xml.getBytes("utf-8"))));

			doc.getDocumentElement ().normalize();    		

			modello = Lettera.getLettera(modello,doc);
			
			modello = setDati(modello, doc); 			
			
			if(modello.getContraente().getCodiceFiscale().equals(modello.getPrimoassicurato().getCodiceFiscale()))
				modello.getPrimoassicurato().setCodiceFiscale("Contraente");
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("polizza", modello);
			return map;
		} catch (Exception e) {
			LoggingUtils.error(e.getMessage());
		}		        
		return null;        
	}	

	private static Polizza setDati(Polizza polizza, Document doc) {
		AvvisiScadenzaSPI avvisiScadenzaSPI = new AvvisiScadenzaSPI();
		try{
			NodeList nodeDivisa = doc.getElementsByTagName("divisa");
			Map<String, Object> mapDivisa = getTag(nodeDivisa);
			if(mapDivisa != null){
				avvisiScadenzaSPI.setDivisa((String)mapDivisa.get("value"));
				avvisiScadenzaSPI.setDescDivisa((String)mapDivisa.get("desc"));
			}else{
				avvisiScadenzaSPI.setDivisa("");
				avvisiScadenzaSPI.setDescDivisa("");			
			}
			
			NodeList nodeDataRivalutazione = doc.getElementsByTagName("dataRivalutazione");
			Map<String, Object> mapDataRivalutazione = getTag(nodeDataRivalutazione);
			if(mapDataRivalutazione != null){
				avvisiScadenzaSPI.setDataRivalutazione((String)mapDataRivalutazione.get("value"));
				avvisiScadenzaSPI.setDescDataRivalutazione((String)mapDataRivalutazione.get("desc"));
			}else{
				avvisiScadenzaSPI.setDataRivalutazione("");
				avvisiScadenzaSPI.setDescDataRivalutazione("");				
			}
			
			NodeList nodePrestazioneGarantitaUltimaRivalutazione = doc.getElementsByTagName("prestazioneGarantitaUltimaRivalutazione");
			Map<String, Object> mapPrestazioneGarantitaUltimaRivalutazione = getTag(nodePrestazioneGarantitaUltimaRivalutazione);
			if(mapPrestazioneGarantitaUltimaRivalutazione != null){
				avvisiScadenzaSPI.setPrestazioneGarantitaUltimaRivalutazione((String)mapPrestazioneGarantitaUltimaRivalutazione.get("value"));				
				avvisiScadenzaSPI.setDescPrestazioneGarantitaUltimaRivalutazione((String)mapPrestazioneGarantitaUltimaRivalutazione.get("desc"));
			}else{
				avvisiScadenzaSPI.setPrestazioneGarantitaUltimaRivalutazione("");
				avvisiScadenzaSPI.setDescPrestazioneGarantitaUltimaRivalutazione("");			
			}
			
			NodeList nodeTotaleRendita = doc.getElementsByTagName("totaleRendita");
			Map<String, Object> mapTotaleRendita = getTag(nodeTotaleRendita);
			if(mapTotaleRendita != null){
				avvisiScadenzaSPI.setTotaleRendita((String)mapTotaleRendita.get("value"));
				avvisiScadenzaSPI.setDescTotaleRendita((String)mapTotaleRendita.get("desc"));
			}else{
				avvisiScadenzaSPI.setTotaleRendita("");
				avvisiScadenzaSPI.setDescTotaleRendita("");			
			}
			
			NodeList nodeCapitaleLordo = doc.getElementsByTagName("capitaleLordo");
			Map<String, Object> mapCapitaleLordo = getTag(nodeCapitaleLordo);
			if(mapCapitaleLordo != null){
				avvisiScadenzaSPI.setCapitaleLordo((String)mapCapitaleLordo.get("value"));
				avvisiScadenzaSPI.setDescCapitaleLordo((String)mapCapitaleLordo.get("desc"));
			}else{
				avvisiScadenzaSPI.setCapitaleLordo("");
				avvisiScadenzaSPI.setDescCapitaleLordo("");			
			}
			
			NodeList nodeDataCambio = doc.getElementsByTagName("dataCambio");
			Map<String, Object> mapDataCambio = getTag(nodeDataCambio);
			if(mapDataCambio != null){
				avvisiScadenzaSPI.setDataCambio((String)mapDataCambio.get("value"));
				avvisiScadenzaSPI.setDescDataCambio((String)mapDataCambio.get("desc"));
			}else{
				avvisiScadenzaSPI.setDataCambio("");
				avvisiScadenzaSPI.setDescDataCambio("");			
			}
			
			NodeList nodeCambioInEuro = doc.getElementsByTagName("cambioInEuro");
			Map<String, Object> mapCambioInEuro = getTag(nodeCambioInEuro);
			if(mapCambioInEuro != null){
				avvisiScadenzaSPI.setCambioInEuro((String)mapCambioInEuro.get("value"));
				avvisiScadenzaSPI.setDescCambioInEuro((String)mapCambioInEuro.get("desc"));
			}else{
				avvisiScadenzaSPI.setCambioInEuro("");
				avvisiScadenzaSPI.setDescCambioInEuro("");			
			}
			
			NodeList nodePremiVersatiInEuro = doc.getElementsByTagName("premiVersatiInEuro");
			Map<String, Object> mapPremiVersatiInEuro = getTag(nodePremiVersatiInEuro);
			if(mapPremiVersatiInEuro != null){
				avvisiScadenzaSPI.setPremiVersatiInEuro((String)mapPremiVersatiInEuro.get("value"));
				avvisiScadenzaSPI.setDescPremiVersatiInEuro((String)mapPremiVersatiInEuro.get("desc"));
			}else{
				avvisiScadenzaSPI.setPremiVersatiInEuro("");
				avvisiScadenzaSPI.setDescPremiVersatiInEuro("");			
			}  		
			polizza.setAvvisiScadenzaSPI(avvisiScadenzaSPI);
		}catch (Exception e) {
			LoggingUtils.error(e.getMessage());
		}
		return polizza;
	}

	private static Map<String, Object> getTag(NodeList nodeList){
		Map<String, Object> map = null;
		org.w3c.dom.Element element = (org.w3c.dom.Element)nodeList.item(0); 
		if(element != null){
			map = new HashMap<String, Object>();
			NodeList textNode = element.getChildNodes();
			String desc = element.getAttribute("desc");
			String text = "";
			if(((org.w3c.dom.Node)textNode.item(0)) != null){				
				text = ((org.w3c.dom.Node)textNode.item(0)).getNodeValue().trim();													    
			}
			map.put("value", text);
			map.put("desc", desc);
		}
		return map;
	}

	private static String convertStringDataString_(String data){
		String dataString = "";
		String anno = "";
		String mese = "";
		String giorno = "";
		if(data != null && !data.equals("")){
			StringTokenizer dataToken = new StringTokenizer(data, "-");
			while(dataToken.hasMoreTokens()){
				anno = dataToken.nextToken();
				mese = dataToken.nextToken();
				giorno = dataToken.nextToken();
			}
			dataString = giorno+"/"+mese+"/"+anno;
		}    	
		return dataString;
	}  

	public Polizza getPolizza() {
		return polizza;
	}

	public void setPolizza(Polizza polizza) {
		this.polizza = polizza;
	}
	
	public static String decodeHTMLString(String s) {
        return StringEscapeUtils.unescapeHtml((s.replace("&amp;#39;", "`").replace("&apos;", "'")));
    }
}