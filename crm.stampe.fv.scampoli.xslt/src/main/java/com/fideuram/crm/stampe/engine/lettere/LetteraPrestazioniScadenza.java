package com.fideuram.crm.stampe.engine.lettere;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.fideuram.config.CrmProperties;
import com.fideuram.utils.Streamer;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.fideuram.crm.stampe.engine.modello.Lettera;
import com.fideuram.crm.stampe.engine.modello.bean.Polizza;
import com.fideuram.crm.stampe.engine.modello.bean.PrestazioniScadenza;
import com.fideuram.crm.stampe.serviceclient.bi.CodificaXML;
import com.fideuram.utils.LoggingUtils;

/**
 * Date: 22/11/11
 * Time: 10.00
 */
public class LetteraPrestazioniScadenza {
    private Polizza polizza;


    public static void main (String args[]) throws Exception {

        //Caso di test per le Prestazioni a Scadenza


        String beanTest=("<?xml version=\"1.0\" encoding=\"utf-8\"?><polizza desc=\"Risultati Simulazione\" order=\"1\"><id desc=\"Numero Polizza\" order=\"1.1\">7302054</id><dettaglio desc=\"Informazioni Generali Polizza\" order=\"1.2\">\n" +
                " <datiPolizza order=\"1.2.1\" desc=\"Dati Polizza\">\n" +
                " <numeroPolizza desc=\"Polizza n.\" order=\"1.2.1.1\">7302054</numeroPolizza>\n" +
                " <codiceConferimento desc=\"Codice Conferimento\" order=\"1.2.1.2\">54706136008</codiceConferimento>\n" +
                " <prodotto desc=\"Prodotto\" order=\"1.2.1.3\">36002 - Piano Pensione Fideuram - Previ</prodotto>\n" +
                " <tariffa desc=\"Tariffa\" order=\"1.2.1.4\">703 - Piano Pensione Fideuram- Previ</tariffa>\n" +
                " <stato desc=\"Stato\" order=\"1.2.1.5\">AT</stato>\n" +
                " <dataEmissione desc=\"Data Emissione\" order=\"1.2.1.6\">1995-01-11</dataEmissione>\n" +
                " <dataScadenza desc=\"Data Scadenza Polizza\" order=\"1.2.1.7\">2015-01-05</dataScadenza>\n" +
                " <dataRichiesta desc=\"Data Elaborazione\" order=\"1.2.1.8\">2014-01-27</dataRichiesta>\n" +
                " <premiVersati desc=\"Premi Versati\" order=\"1.2.1.11\">0.0</premiVersati>\n" +
                " <ramoMinisteriale desc=\"Ramo Ministeriale\" order=\"1.2.1.9\">1</ramoMinisteriale>\n" +
                " <tipoPrestazione desc=\"TipoPrestazione\" order=\"1.2.1.10\">R</tipoPrestazione>\n" +
                " </datiPolizza>\n" +
                " <contraente desc=\"Dati Contraente\" order=\"1.2.2\">\n" +
                " <nominativo desc=\"Nominativo\" order=\"1.2.2.1\">GIOVANNA SANZANI</nominativo>\n" +
                " <dataNascita desc=\"Data Nascita\" order=\"1.2.2.2\">01/04/1962</dataNascita>\n" +
                " <codiceFiscale desc=\"Codice Fiscale\" order=\"1.2.3.3\">SNZGNN62D41B393J</codiceFiscale>\n" +
                " </contraente>\n" +
                " <primoAssicurato desc=\"Dati Primo Assicurato\" order=\"1.2.3\">\n" +
                " <nominativo desc=\"Nominativo\" order=\"1.2.3.1\">GIOVANNA SANZANI</nominativo>\n" +
                " <dataNascita desc=\"Data Nascita\" order=\"1.2.3.2\">01/04/1962</dataNascita>\n" +
                " <codiceFiscale desc=\"Codice Fiscale\" order=\"1.2.3.3\">SNZGNN62D41B393J</codiceFiscale>\n" +
                " </primoAssicurato>\n" +
                "</dettaglio><valoreRiscattoLordo desc=\"Valore Riscatto Lordo\" order=\"1.3.1.1\">414.288,29</valoreRiscattoLordo><prestazioneTotaleDiRenditaLorda desc=\"La prestazione totale di rendita lorda è: 24.560,80\" order=\"1.3.1.2\">24.560,80</prestazioneTotaleDiRenditaLorda></polizza>\n");

        Map<String, Object> risultato= fromXml(beanTest);


    }

    /**
     * @param xml
     * @return Map
     */
    public static Map<String, Object> fromXml(String xml) {
    	xml = CodificaXML.replace(xml);
    	try {        	
    		Polizza modello = new Polizza();
//    		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
//    		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
    		
			/** Adeguamenti Sonar e PT ********************************************************/
		    DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
//		    docBuilderFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
//		    docBuilderFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
		    DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		/**********************************************************************************/
		    
    		org.w3c.dom.Document doc = docBuilder.parse(new InputSource(new ByteArrayInputStream(xml.getBytes("utf-8"))));

    		doc.getDocumentElement ().normalize();    		
    		
    		modello = Lettera.getLettera(modello,doc);
    		modello = setDatiPrestazioniScadenza(modello, doc);
    		
    		Map<String, Object> map = new HashMap<String, Object>();
    		map.put("polizza", modello);
    		return map;
    	} catch (Exception e) {
    		LoggingUtils.error(e.getMessage());
    	}		        
    	return null;        
    }
    
    private static Polizza setDatiPrestazioniScadenza(Polizza polizza, org.w3c.dom.Document doc){
    	PrestazioniScadenza prestazioniScadenza = new PrestazioniScadenza();
    	try {    		
    		NodeList nodeValoreRiscattoScadMinGar = doc.getElementsByTagName("valoreRiscattoScadenzaMinGarantito");    		
    		Map<String, Object> mapValoreRiscattoScadMinGar = getTag(nodeValoreRiscattoScadMinGar);
    		if(mapValoreRiscattoScadMinGar != null){
    			prestazioniScadenza.setValoreRiscattoScadenzaMinGarantito((String)mapValoreRiscattoScadMinGar.get("value"));
    			prestazioniScadenza.setDescValoreRiscattoScadenzaMinGarantito((String)mapValoreRiscattoScadMinGar.get("desc"));
    		}else{
    			prestazioniScadenza.setValoreRiscattoScadenzaMinGarantito("");
    			prestazioniScadenza.setDescValoreRiscattoScadenzaMinGarantito("");
    		}    		
			NodeList nodeRenditaAnnuaVitaliziaMinimaGarantita = doc.getElementsByTagName("renditaAnnuaVitaliziaMinimaGarantita");
			Map<String, Object> mapRenditaAnnuaVitaliziaMinimaGarantita = getTag(nodeRenditaAnnuaVitaliziaMinimaGarantita);
			if(mapRenditaAnnuaVitaliziaMinimaGarantita != null){
				prestazioniScadenza.setRenditaAnnuaVitaliziaMinimaGarantita((String)mapRenditaAnnuaVitaliziaMinimaGarantita.get("value"));
				prestazioniScadenza.setDescRenditaAnnuaVitaliziaMinimaGarantita((String)mapRenditaAnnuaVitaliziaMinimaGarantita.get("desc"));
			}else{
				prestazioniScadenza.setRenditaAnnuaVitaliziaMinimaGarantita("");
				prestazioniScadenza.setDescRenditaAnnuaVitaliziaMinimaGarantita("");
			}
			NodeList nodeQuote = doc.getElementsByTagName("quote");
			Map<String, Object> mapQuote = getTag(nodeQuote);
			if(mapQuote != null){
				prestazioniScadenza.setQuote((String)mapQuote.get("value"));
				prestazioniScadenza.setDescQuote((String)mapQuote.get("desc"));
			}else{
				prestazioniScadenza.setQuote("");
				prestazioniScadenza.setDescQuote("");
			}							
			NodeList nodeIpotesiControvaloreQuoteNav = doc.getElementsByTagName("ipotesiControvaloreQuoteNav");
			Map<String, Object> mapIpotesiControvaloreQuoteNav = getTag(nodeIpotesiControvaloreQuoteNav);
			if(mapIpotesiControvaloreQuoteNav != null){
				prestazioniScadenza.setIpotesiControvaloreQuoteNav((String)mapIpotesiControvaloreQuoteNav.get("value"));
				prestazioniScadenza.setDescIpotesiControvaloreQuoteNav((String)mapIpotesiControvaloreQuoteNav.get("desc"));
			}else{
				prestazioniScadenza.setIpotesiControvaloreQuoteNav("");
				prestazioniScadenza.setDescIpotesiControvaloreQuoteNav("");
			}			
			NodeList nodeValoreRiscattoScadenzaNav = doc.getElementsByTagName("valoreRiscattoScadenzaNav");
			Map<String, Object> mapValoreRiscattoScadenzaNav = getTag(nodeValoreRiscattoScadenzaNav);
			if(mapValoreRiscattoScadenzaNav != null){
				prestazioniScadenza.setValoreRiscattoScadenzaNav((String)mapValoreRiscattoScadenzaNav.get("value"));
				prestazioniScadenza.setDescValoreRiscattoScadenzaNav((String)mapValoreRiscattoScadenzaNav.get("desc"));
			}else{
				prestazioniScadenza.setValoreRiscattoScadenzaNav("");
				prestazioniScadenza.setDescValoreRiscattoScadenzaNav("");
			}				
			NodeList nodeIpotesiDiValoreRiscattoScadenza = doc.getElementsByTagName("ipotesiDiValoreRiscattoScadenza");
			Map<String, Object> mapIpotesiDiValoreRiscattoScadenza = getTag(nodeIpotesiDiValoreRiscattoScadenza);
			if(mapIpotesiDiValoreRiscattoScadenza != null){
				prestazioniScadenza.setIpotesiDiValoreRiscattoScadenza((String)mapIpotesiDiValoreRiscattoScadenza.get("value"));
				prestazioniScadenza.setDescIpotesiDiValoreRiscattoScadenza((String)mapIpotesiDiValoreRiscattoScadenza.get("desc"));
			}else{
				prestazioniScadenza.setIpotesiDiValoreRiscattoScadenza("");
				prestazioniScadenza.setDescIpotesiDiValoreRiscattoScadenza("");
			}			
			NodeList nodePremiVersatiNav = doc.getElementsByTagName("premiVersatiNav");
			Map<String, Object> mapPremiVersatiNav = getTag(nodePremiVersatiNav);
			if(mapPremiVersatiNav != null){
				prestazioniScadenza.setPremiVersatiNav((String)mapPremiVersatiNav.get("value"));
				prestazioniScadenza.setDescPremiVersatiNav((String)mapPremiVersatiNav.get("desc"));
			}else{
				prestazioniScadenza.setPremiVersatiNav("");
				prestazioniScadenza.setDescPremiVersatiNav("");
			}					
			NodeList nodeDataRiferimentoNav = doc.getElementsByTagName("dataRiferimentoNav");
			Map<String, Object> mapDataRiferimentoNav = getTag(nodeDataRiferimentoNav);
			if(mapDataRiferimentoNav != null){
				prestazioniScadenza.setDataRiferimentoNav((String)mapDataRiferimentoNav.get("value"));
				prestazioniScadenza.setDescDataRiferimentoNav((String)mapDataRiferimentoNav.get("desc"));
			}else{
				prestazioniScadenza.setDataRiferimentoNav("");
				prestazioniScadenza.setDescDataRiferimentoNav("");
			}			
			NodeList nodeValoreRiscattoLordo = doc.getElementsByTagName("valoreRiscattoLordo");
			Map<String, Object> mapValoreRiscattoLordo = getTag(nodeValoreRiscattoLordo);
			if(mapValoreRiscattoLordo != null){
				prestazioniScadenza.setValoreRiscattoLordo((String)mapValoreRiscattoLordo.get("value"));
				prestazioniScadenza.setDescValoreRiscattoLordo((String)mapValoreRiscattoLordo.get("desc"));
			}else{
				prestazioniScadenza.setValoreRiscattoLordo("");
				prestazioniScadenza.setDescValoreRiscattoLordo("");
			}			
			NodeList nodePrestazioneTotaleDiRenditaLorda = doc.getElementsByTagName("prestazioneTotaleDiRenditaLorda");
			Map<String, Object> mapPrestazioneTotaleDiRenditaLorda = getTag(nodePrestazioneTotaleDiRenditaLorda);
			if(mapPrestazioneTotaleDiRenditaLorda != null){
				prestazioniScadenza.setPrestazioneTotaleDiRenditaLorda((String)mapPrestazioneTotaleDiRenditaLorda.get("value"));
				prestazioniScadenza.setDescPrestazioneTotaleDiRenditaLorda((String)mapPrestazioneTotaleDiRenditaLorda.get("desc"));
			}else{
				prestazioniScadenza.setPrestazioneTotaleDiRenditaLorda("");	
				prestazioniScadenza.setDescPrestazioneTotaleDiRenditaLorda("");
			}
			polizza.setPrestazioniScadenza(prestazioniScadenza);
    	} catch (Exception e) {
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
}