package com.fideuram.crm.stampe.engine.lettere;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang.StringEscapeUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.fideuram.crm.stampe.engine.modello.Lettera;
import com.fideuram.crm.stampe.engine.modello.bean.Polizza;
import com.fideuram.crm.stampe.engine.modello.bean.SpiegazioneConteggiLiqSPI;
import com.fideuram.crm.stampe.serviceclient.bi.CodificaXML;
import com.fideuram.utils.LoggingUtils;

public class LetteraSpiegazioneConteggiLiqSPI {
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
		SpiegazioneConteggiLiqSPI spiegazioneConteggiLiqSPI = new SpiegazioneConteggiLiqSPI();
		try{
			NodeList nodeDivisa = doc.getElementsByTagName("divisa");
			Map<String, Object> mapDivisa = getTag(nodeDivisa);
			if(mapDivisa != null){
				spiegazioneConteggiLiqSPI.setDivisa((String)mapDivisa.get("value"));
				spiegazioneConteggiLiqSPI.setDescDivisa((String)mapDivisa.get("desc"));
			}else{
				spiegazioneConteggiLiqSPI.setDivisa("");
				spiegazioneConteggiLiqSPI.setDescDivisa("");				
			}			
			NodeList nodeRenditaTotale = doc.getElementsByTagName("renditaTotale");
			Map<String, Object> mapRenditaTotale = getTag(nodeRenditaTotale);
			if(mapRenditaTotale != null){				
				spiegazioneConteggiLiqSPI.setRenditaTotale((String)mapRenditaTotale.get("value"));			
				spiegazioneConteggiLiqSPI.setDescRenditaTotale((String)mapRenditaTotale.get("desc"));
			}else{
				spiegazioneConteggiLiqSPI.setRenditaTotale("");
				spiegazioneConteggiLiqSPI.setDescRenditaTotale("");				
			}
			NodeList nodeCoefficenteCapitale = doc.getElementsByTagName("coefficenteCapitale");
			Map<String, Object> mapCoefficenteCapitale = getTag(nodeCoefficenteCapitale);
			if(mapCoefficenteCapitale != null){
				spiegazioneConteggiLiqSPI.setCoefficenteCapitale((String)mapCoefficenteCapitale.get("value"));
				spiegazioneConteggiLiqSPI.setDescCoefficenteCapitale((String)mapCoefficenteCapitale.get("desc"));
			}else{
				spiegazioneConteggiLiqSPI.setCoefficenteCapitale("");
				spiegazioneConteggiLiqSPI.setDescCoefficenteCapitale("");				
			}
			NodeList nodeCapitaleLordoOpzioniValuta = doc.getElementsByTagName("capitaleLordoOpzioniValuta");
			Map<String, Object> mapCapitaleLordoOpzioniValuta = getTag(nodeCapitaleLordoOpzioniValuta);
			if(mapCapitaleLordoOpzioniValuta != null){
				spiegazioneConteggiLiqSPI.setCapitaleLordoOpzioniValuta((String)mapCapitaleLordoOpzioniValuta.get("value"));				
				spiegazioneConteggiLiqSPI.setDescCapitaleLordoOpzioniValuta((String)mapCapitaleLordoOpzioniValuta.get("desc"));
			}else{
				spiegazioneConteggiLiqSPI.setCapitaleLordoOpzioniValuta("");
				spiegazioneConteggiLiqSPI.setDescCapitaleLordoOpzioniValuta("");				
			}
			NodeList nodeTassoCambio = doc.getElementsByTagName("tassoCambio");
			Map<String, Object> mapTassoCambio = getTag(nodeTassoCambio);
			if(mapTassoCambio != null){				
				spiegazioneConteggiLiqSPI.setTassoCambio((String)mapTassoCambio.get("value"));			
				spiegazioneConteggiLiqSPI.setDescTassoCambio((String)mapTassoCambio.get("desc"));
			}else{
				spiegazioneConteggiLiqSPI.setTassoCambio("");
				spiegazioneConteggiLiqSPI.setDescTassoCambio("");				
			}
			NodeList nodeCapitaleLordo = doc.getElementsByTagName("capitaleLordo");
			Map<String, Object> mapCapitaleLordo = getTag(nodeCapitaleLordo);
			if(mapCapitaleLordo != null){
				spiegazioneConteggiLiqSPI.setCapitaleLordo((String)mapCapitaleLordo.get("value"));				
				spiegazioneConteggiLiqSPI.setDescCapitaleLordo((String)mapCapitaleLordo.get("desc"));
			}else{
				spiegazioneConteggiLiqSPI.setCapitaleLordo("");
				spiegazioneConteggiLiqSPI.setDescCapitaleLordo("");				
			}
			NodeList nodeTotalePremiVersati = doc.getElementsByTagName("totalePremiVersati");
			Map<String, Object> mapTotalePremiVersati = getTag(nodeTotalePremiVersati);
			if(mapTotalePremiVersati != null){
				spiegazioneConteggiLiqSPI.setTotalePremiVersati((String)mapTotalePremiVersati.get("value"));				
				spiegazioneConteggiLiqSPI.setDescTotalePremiVersati((String)mapTotalePremiVersati.get("desc"));
			}else{
				spiegazioneConteggiLiqSPI.setTotalePremiVersati("");
				spiegazioneConteggiLiqSPI.setDescTotalePremiVersati("");				
			}
			polizza.setSpiegazioneConteggiLiqSPI(spiegazioneConteggiLiqSPI);
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