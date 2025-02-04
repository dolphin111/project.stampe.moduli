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
import com.fideuram.crm.stampe.engine.modello.bean.SimulazioniSPI;
import com.fideuram.crm.stampe.serviceclient.bi.CodificaXML;
import com.fideuram.utils.LoggingUtils;

public class LetteraSimulazioniSPI {
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
		SimulazioniSPI simulazioniSPI = new SimulazioniSPI();
		try{
			NodeList nodeDataRivalutazione = doc.getElementsByTagName("dataRivalutazione");
			Map<String, Object> mapDataRivalutazione = getTag(nodeDataRivalutazione);
			if(mapDataRivalutazione != null){
				simulazioniSPI.setDataRivalutazione((String)mapDataRivalutazione.get("value"));
				simulazioniSPI.setDescDataRivalutazione((String)mapDataRivalutazione.get("desc"));
			}else{
				simulazioniSPI.setDataRivalutazione("");
				simulazioniSPI.setDescDataRivalutazione("");				
			}			
			NodeList nodePrestazioneGarantitaUltimaRivalutazione = doc.getElementsByTagName("prestazioneGarantitaUltimaRivalutazione");
			Map<String, Object> mapPrestazioneGarantitaUltimaRivalutazione = getTag(nodePrestazioneGarantitaUltimaRivalutazione);
			if(mapPrestazioneGarantitaUltimaRivalutazione != null){
				simulazioniSPI.setPrestazioneGarantitaUltimaRivalutazione((String)mapPrestazioneGarantitaUltimaRivalutazione.get("value"));
				simulazioniSPI.setDescPrestazioneGarantitaUltimaRivalutazione((String)mapPrestazioneGarantitaUltimaRivalutazione.get("desc"));
			}else{
				simulazioniSPI.setPrestazioneGarantitaUltimaRivalutazione("");
				simulazioniSPI.setDescPrestazioneGarantitaUltimaRivalutazione("");				
			}			
			NodeList nodePremiVersatiOggiEuro = doc.getElementsByTagName("premiVersatiOggiEuro");
			Map<String, Object> mapPremiVersatiOggiEuro = getTag(nodePremiVersatiOggiEuro);
			if(mapPremiVersatiOggiEuro != null){
				simulazioniSPI.setPremiVersatiAdOggiInEuro((String)mapPremiVersatiOggiEuro.get("value"));
				simulazioniSPI.setDescPremiVersatiAdOggiInEuro((String)mapPremiVersatiOggiEuro.get("desc"));
			}else{
				simulazioniSPI.setPremiVersatiAdOggiInEuro("");
				simulazioniSPI.setDescPremiVersatiAdOggiInEuro("");				
			}			
			NodeList nodePremiAggiuntiviOggi = doc.getElementsByTagName("premiAggiuntiviOggi");
			Map<String, Object> mapPremiAggiuntiviOggi = getTag(nodePremiAggiuntiviOggi);
			if(mapPremiAggiuntiviOggi != null){
				simulazioniSPI.setPremiAggiuntiviVersatiAdOggi((String)mapPremiAggiuntiviOggi.get("value"));
				simulazioniSPI.setDescPremiAggiuntiviVersatiAdOggi((String)mapPremiAggiuntiviOggi.get("desc"));
			}else{
				simulazioniSPI.setPremiAggiuntiviVersatiAdOggi("");
				simulazioniSPI.setDescPremiAggiuntiviVersatiAdOggi("");			
			}			
			NodeList nodeRivalutazioneMinimaGarantita = doc.getElementsByTagName("rivalutazioneMinimaGarantita");
			Map<String, Object> mapRivalutazioneMinimaGarantita = getTag(nodeRivalutazioneMinimaGarantita);
			if(mapRivalutazioneMinimaGarantita != null){
				simulazioniSPI.setRivalutazioneMinimaGarantita((String)mapRivalutazioneMinimaGarantita.get("value"));
				simulazioniSPI.setDescRivalutazioneMinimaGarantita((String)mapRivalutazioneMinimaGarantita.get("desc"));
			}else{
				simulazioniSPI.setRivalutazioneMinimaGarantita("");
				simulazioniSPI.setDescRivalutazioneMinimaGarantita("");				
			}			
			NodeList nodeSommaPremiResiduiDaVersare = doc.getElementsByTagName("sommaPremiResiduiDaVersare");
			Map<String, Object> mapSommaPremiResiduiDaVersare = getTag(nodeSommaPremiResiduiDaVersare);
			if(mapSommaPremiResiduiDaVersare != null){
				simulazioniSPI.setSommaPremiResiduiDaVersare((String)mapSommaPremiResiduiDaVersare.get("value"));
				simulazioniSPI.setDescSommaPremiResiduiDaVersare((String)mapSommaPremiResiduiDaVersare.get("desc"));
			}else{
				simulazioniSPI.setSommaPremiResiduiDaVersare("");
				simulazioniSPI.setDescSommaPremiResiduiDaVersare("");				
			}			
			NodeList nodeStimaTotaleRenditaScadenza = doc.getElementsByTagName("stimaTotaleRenditaScadenza");
			Map<String, Object> mapStimaTotaleRenditaScadenza = getTag(nodeStimaTotaleRenditaScadenza);
			if(mapStimaTotaleRenditaScadenza != null){
				simulazioniSPI.setStimaTotaleRenditaScadenza((String)mapStimaTotaleRenditaScadenza.get("value"));
				simulazioniSPI.setDescStimaTotaleRenditaScadenza((String)mapStimaTotaleRenditaScadenza.get("desc"));
			}else{
				simulazioniSPI.setStimaTotaleRenditaScadenza("");
				simulazioniSPI.setDescStimaTotaleRenditaScadenza("");				
			}
			NodeList nodeDivisa = doc.getElementsByTagName("divisa");
			Map<String, Object> mapDivisa = getTag(nodeDivisa);
			if(mapDivisa != null){
				simulazioniSPI.setDivisa((String)mapDivisa.get("value"));
				simulazioniSPI.setDescDivisa((String)mapDivisa.get("desc"));
			}else{
				simulazioniSPI.setDivisa("");
				simulazioniSPI.setDescDivisa("");				
			}			
			/*MODIFICHE DEL 14/06/2012*/
			NodeList nodePianoCompletatoSPI = doc.getElementsByTagName("pianoCompletatoSPI");
			Map<String, Object> mapPianoCompletatoSPI = getTag(nodePianoCompletatoSPI);
			String pianoNonCompletato = "";
			if(mapPianoCompletatoSPI != null){
				pianoNonCompletato = (String)mapPianoCompletatoSPI.get("value");
			}
			if(pianoNonCompletato.equals("") || pianoNonCompletato.equals("true")){
				simulazioniSPI.setPianoNonCompletato(true);
			}else{
				simulazioniSPI.setPianoNonCompletato(false);
			}
			if(!simulazioniSPI.isPianoNonCompletato()){
				NodeList nodeStimaRenditaDaPianoAScadenza = doc.getElementsByTagName("stimaRenditaDaPianoAScadenza");
				Map<String, Object> mapStimaRenditaDaPianoAScadenza = getTag(nodeStimaRenditaDaPianoAScadenza);
				if(mapStimaRenditaDaPianoAScadenza != null){
					simulazioniSPI.setStimaRenditaDaPianoAScadenza((String)mapStimaRenditaDaPianoAScadenza.get("value"));
					simulazioniSPI.setDescStimaRenditaDaPianoAScadenza((String)mapStimaRenditaDaPianoAScadenza.get("desc"));
				}else{
					simulazioniSPI.setStimaRenditaDaPianoAScadenza("");
					simulazioniSPI.setDescStimaRenditaDaPianoAScadenza("");				
				}
				NodeList nodeStimaRenditaDaEstemporaneiAScadenza = doc.getElementsByTagName("stimaRenditaDaEstemporaneiAScadenza");
				Map<String, Object> mapStimaRenditaDaEstemporaneiAScadenza = getTag(nodeStimaRenditaDaEstemporaneiAScadenza);
				if(mapStimaRenditaDaEstemporaneiAScadenza != null){
					simulazioniSPI.setStimaRenditaDaEstemporaneiAScadenza((String)mapStimaRenditaDaEstemporaneiAScadenza.get("value"));
					simulazioniSPI.setDescStimaRenditaDaEstemporaneiAScadenza((String)mapStimaRenditaDaEstemporaneiAScadenza.get("desc"));
				}else{
					simulazioniSPI.setStimaRenditaDaEstemporaneiAScadenza("");
					simulazioniSPI.setDescStimaRenditaDaEstemporaneiAScadenza("");				
				}
				NodeList nodeRenditaTrimestrale = doc.getElementsByTagName("renditaTrimestrale");
				Map<String, Object> mapRenditaTrimestrale = getTag(nodeRenditaTrimestrale);
				if(mapRenditaTrimestrale != null){
					simulazioniSPI.setRenditaTrimestrale((String)mapRenditaTrimestrale.get("value"));
					simulazioniSPI.setDescRenditaTrimestrale((String)mapRenditaTrimestrale.get("desc"));
				}else{
					simulazioniSPI.setRenditaTrimestrale("");
					simulazioniSPI.setDescRenditaTrimestrale("");				
				}
				NodeList nodeRenditaSemestrale = doc.getElementsByTagName("renditaSemestrale");
				Map<String, Object> mapRenditaSemestrale = getTag(nodeRenditaSemestrale);
				if(mapRenditaSemestrale != null){
					simulazioniSPI.setRenditaSemestrale((String)mapRenditaSemestrale.get("value"));
					simulazioniSPI.setDescRenditaSemestrale((String)mapRenditaSemestrale.get("desc"));
				}else{
					simulazioniSPI.setRenditaSemestrale("");
					simulazioniSPI.setDescRenditaSemestrale("");				
				}
				NodeList nodeRenditaCerta5Anni = doc.getElementsByTagName("renditaCerta5Anni");
				Map<String, Object> mapRenditaCerta5Anni = getTag(nodeRenditaCerta5Anni);
				if(mapRenditaCerta5Anni != null){
					simulazioniSPI.setRenditaCerta5Anni((String)mapRenditaCerta5Anni.get("value"));
					simulazioniSPI.setDescRenditaCerta5Anni((String)mapRenditaCerta5Anni.get("desc"));
				}else{
					simulazioniSPI.setRenditaCerta5Anni("");
					simulazioniSPI.setDescRenditaCerta5Anni("");				
				}
				NodeList nodeRenditaCerta10Anni = doc.getElementsByTagName("renditaCerta10Anni");
				Map<String, Object> mapRenditaCerta10Anni = getTag(nodeRenditaCerta10Anni);
				if(mapRenditaCerta10Anni != null){
					simulazioniSPI.setRenditaCerta10Anni((String)mapRenditaCerta10Anni.get("value"));
					simulazioniSPI.setDescRenditaCerta10Anni((String)mapRenditaCerta10Anni.get("desc"));
				}else{
					simulazioniSPI.setRenditaCerta10Anni("");
					simulazioniSPI.setDescRenditaCerta10Anni("");				
				}
				NodeList nodeCapitaleLordo = doc.getElementsByTagName("capitaleLordo");
				Map<String, Object> mapCapitaleLordo = getTag(nodeCapitaleLordo);
				if(mapCapitaleLordo != null){
					simulazioniSPI.setCapitaleLordo((String)mapCapitaleLordo.get("value"));
					simulazioniSPI.setDescCapitaleLordo((String)mapCapitaleLordo.get("desc"));
				}else{
					simulazioniSPI.setCapitaleLordo("");
					simulazioniSPI.setDescCapitaleLordo("");				
				}
			}
			
			NodeList nodeStimaRenditaDaEstemporaneiAScadenza2 = doc.getElementsByTagName("stimaRenditaDaEstemporaneiAScadenza2");
			Map<String, Object> mapStimaRenditaDaEstemporaneiAScadenza2 = getTag(nodeStimaRenditaDaEstemporaneiAScadenza2);
			if(mapStimaRenditaDaEstemporaneiAScadenza2 != null){
				simulazioniSPI.setStimaRenditaDaEstemporaneiAScadenza2((String)mapStimaRenditaDaEstemporaneiAScadenza2.get("value"));
				simulazioniSPI.setDescStimaRenditaDaEstemporaneiAScadenza2((String)mapStimaRenditaDaEstemporaneiAScadenza2.get("desc"));
			}else{
				simulazioniSPI.setStimaRenditaDaEstemporaneiAScadenza2("");
				simulazioniSPI.setDescStimaRenditaDaEstemporaneiAScadenza2("");				
			}
			NodeList nodeBonusFedelta = doc.getElementsByTagName("bonusFedelta");
			Map<String, Object> mapBonusFedelta = getTag(nodeBonusFedelta);
			if(mapBonusFedelta != null){
				simulazioniSPI.setBonusFedelta((String)mapBonusFedelta.get("value"));
				simulazioniSPI.setDescBonusFedelta((String)mapBonusFedelta.get("desc"));
			}else{
				simulazioniSPI.setBonusFedelta("");
				simulazioniSPI.setDescBonusFedelta("");				
			}
			NodeList nodeBonusExtra = doc.getElementsByTagName("bonusExtra");
			Map<String, Object> mapBonusExtra = getTag(nodeBonusExtra);
			if(mapBonusExtra != null){
				simulazioniSPI.setBonusExtra((String)mapBonusExtra.get("value"));
				simulazioniSPI.setDescBonusExtra((String)mapBonusExtra.get("desc"));
			}else{
				simulazioniSPI.setBonusExtra("");
				simulazioniSPI.setDescBonusExtra("");				
			}
			NodeList nodeRenditaTrimestrale2 = doc.getElementsByTagName("renditaTrimestrale2");
			Map<String, Object> mapRenditaTrimestrale2 = getTag(nodeRenditaTrimestrale2);
			if(mapRenditaTrimestrale2 != null){
				simulazioniSPI.setRenditaTrimestrale2((String)mapRenditaTrimestrale2.get("value"));
				simulazioniSPI.setDescRenditaTrimestrale2((String)mapRenditaTrimestrale2.get("desc"));
			}else{
				simulazioniSPI.setRenditaTrimestrale2("");
				simulazioniSPI.setDescRenditaTrimestrale2("");				
			}
			NodeList nodeRenditaSemestrale2 = doc.getElementsByTagName("renditaSemestrale2");
			Map<String, Object> mapRenditaSemestrale2 = getTag(nodeRenditaSemestrale2);
			if(mapRenditaSemestrale2 != null){
				simulazioniSPI.setRenditaSemestrale2((String)mapRenditaSemestrale2.get("value"));
				simulazioniSPI.setDescRenditaSemestrale2((String)mapRenditaSemestrale2.get("desc"));
			}else{
				simulazioniSPI.setRenditaSemestrale2("");
				simulazioniSPI.setDescRenditaSemestrale2("");				
			}
			NodeList nodeRenditaCerta5Anni2 = doc.getElementsByTagName("renditaCerta5Anni2");
			Map<String, Object> mapRenditaCerta5Anni2 = getTag(nodeRenditaCerta5Anni2);
			if(mapRenditaCerta5Anni2 != null){
				simulazioniSPI.setRenditaCerta5Anni2((String)mapRenditaCerta5Anni2.get("value"));
				simulazioniSPI.setDescRenditaCerta5Anni2((String)mapRenditaCerta5Anni2.get("desc"));
			}else{
				simulazioniSPI.setRenditaCerta5Anni2("");
				simulazioniSPI.setDescRenditaCerta5Anni2("");				
			}
			NodeList nodeRenditaCerta10Anni2 = doc.getElementsByTagName("renditaCerta10Anni2");
			Map<String, Object> mapRenditaCerta10Anni2 = getTag(nodeRenditaCerta10Anni2);
			if(mapRenditaCerta10Anni2 != null){
				simulazioniSPI.setRenditaCerta10Anni2((String)mapRenditaCerta10Anni2.get("value"));
				simulazioniSPI.setDescRenditaCerta10Anni2((String)mapRenditaCerta10Anni2.get("desc"));
			}else{
				simulazioniSPI.setRenditaCerta10Anni2("");
				simulazioniSPI.setDescRenditaCerta10Anni2("");				
			}
			NodeList nodeCapitaleLordo2 = doc.getElementsByTagName("capitaleLordo2");
			Map<String, Object> mapCapitaleLordo2 = getTag(nodeCapitaleLordo2);
			if(mapCapitaleLordo2 != null){
				simulazioniSPI.setCapitaleLordo2((String)mapCapitaleLordo2.get("value"));
				simulazioniSPI.setDescCapitaleLordo2((String)mapCapitaleLordo2.get("desc"));
			}else{
				simulazioniSPI.setCapitaleLordo2("");
				simulazioniSPI.setDescCapitaleLordo2("");				
			}			
			polizza.setSimulazioniSPI(simulazioniSPI);
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