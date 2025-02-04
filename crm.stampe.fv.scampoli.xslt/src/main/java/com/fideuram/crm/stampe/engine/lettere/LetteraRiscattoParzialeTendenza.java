package com.fideuram.crm.stampe.engine.lettere;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.fideuram.crm.stampe.engine.modello.Lettera;
import com.fideuram.crm.stampe.engine.modello.bean.Fondo;
import com.fideuram.crm.stampe.engine.modello.bean.Polizza;
import com.fideuram.crm.stampe.engine.modello.bean.RiscattoParzialeTendenza;
import com.fideuram.crm.stampe.serviceclient.bi.CodificaXML;
import com.fideuram.utils.LoggingUtils;

/**
 * Date: 13/11/2012
 * Time: 18.00
 */
public class LetteraRiscattoParzialeTendenza {
	/**
	 * @param xml
	 * @return Map
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
			RiscattoParzialeTendenza riscattoParzialeTendenza = new RiscattoParzialeTendenza();
			modello.setRiscattoParzialeTendenza(riscattoParzialeTendenza);
			if(modello.getRamoMinisteriale().equalsIgnoreCase("3")){
				modello = setDatiRamoIII(modello, doc);	
			}else{
				modello = setDatiRamoI(modello, doc);
			}
		
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

	private static Polizza setDatiRamoI(Polizza polizza, Document doc) {
		RiscattoParzialeTendenza riscatto = polizza.getRiscattoParzialeTendenza();
		try{
			NodeList nodeValoreRiscattoParzialeLordo = doc.getElementsByTagName("valoreRiscattoParzialeLordo");
			Map<String, Object> mapValoreRiscattoParzialeLordo = getTag(nodeValoreRiscattoParzialeLordo);
			if(mapValoreRiscattoParzialeLordo != null){
				riscatto.setValoreRiscattoParzialeLordo((String)mapValoreRiscattoParzialeLordo.get("value"));
				riscatto.setDescValoreRiscattoParzialeLordo((String)mapValoreRiscattoParzialeLordo.get("desc"));
			}else{
				riscatto.setValoreRiscattoParzialeLordo("");
				riscatto.setDescValoreRiscattoParzialeLordo("");			
			}
			NodeList nodeValoreRiscattoParzialeRichiesto = doc.getElementsByTagName("valoreRiscattoParzialeRichiesto");
			Map<String, Object> mapValoreRiscattoParzialeRichiesto = getTag(nodeValoreRiscattoParzialeRichiesto);
			if(mapValoreRiscattoParzialeRichiesto != null){
				riscatto.setValoreRiscattoParzialeRichiesto((String)mapValoreRiscattoParzialeRichiesto.get("value"));
				riscatto.setDescValoreRiscattoParzialeRichiesto((String)mapValoreRiscattoParzialeRichiesto.get("desc"));
			}else{
				riscatto.setValoreRiscattoParzialeRichiesto("");
				riscatto.setDescValoreRiscattoParzialeRichiesto("");			
			}
			NodeList nodeCostoOperazione = doc.getElementsByTagName("costoOperazione");
			Map<String, Object> mapCostoOperazione = getTag(nodeCostoOperazione);
			if(mapCostoOperazione != null){
				riscatto.setCostoOperazione((String)mapCostoOperazione.get("value"));
				riscatto.setDescCostoOperazione((String)mapCostoOperazione.get("desc"));
			}else{
				riscatto.setCostoOperazione("");
				riscatto.setDescCostoOperazione("");			
			}
			NodeList nodeValorePrestazioneRiscatto = doc.getElementsByTagName("valorePrestazioneRiscatto");
			Map<String, Object> mapValorePrestazioneRiscatto = getTag(nodeValorePrestazioneRiscatto);
			if(mapValorePrestazioneRiscatto != null){
				riscatto.setValorePrestazioneRiscatto((String)mapValorePrestazioneRiscatto.get("value"));
				riscatto.setDescValorePrestazioneRiscatto((String)mapValorePrestazioneRiscatto.get("desc"));
			}else{
				riscatto.setValorePrestazioneRiscatto("");
				riscatto.setDescValorePrestazioneRiscatto("");			
			}			
		}catch (Exception e) {
			LoggingUtils.error(e.getMessage());
		}
		return polizza;
	}

	private static Polizza setDatiRamoIII(Polizza polizza, Document doc) {
		RiscattoParzialeTendenza riscatto = polizza.getRiscattoParzialeTendenza();
		try{
			NodeList nodeIsRamo3 = doc.getElementsByTagName("isRamo3");
			Map<String, Object> mapIsRamo3 = getTag(nodeIsRamo3);
			if(mapIsRamo3 != null){
				riscatto.setIsRamoIII(new Boolean((String)mapIsRamo3.get("value")).booleanValue());				
			}
			NodeList nodeDataRiferimentoNav = doc.getElementsByTagName("dataRiferimentoNav");
			Map<String, Object> mapDataRiferimentoNav = getTag(nodeDataRiferimentoNav);
			if(mapDataRiferimentoNav != null){
				riscatto.setDataRiferimentoNav((String)mapDataRiferimentoNav.get("value"));				
			}else{
				riscatto.setDataRiferimentoNav("");				
			} 
			NodeList nodeValoreRiscattoParzialeRichiesto = doc.getElementsByTagName("valoreRiscattoParzialeRichiesto");
			Map<String, Object> mapValoreRiscattoParzialeRichiesto = getTag(nodeValoreRiscattoParzialeRichiesto);
			if(mapValoreRiscattoParzialeRichiesto != null){
				riscatto.setValoreRiscattoParzialeRichiesto((String)mapValoreRiscattoParzialeRichiesto.get("value"));
				riscatto.setDescValoreRiscattoParzialeRichiesto((String)mapValoreRiscattoParzialeRichiesto.get("desc"));
			}else{
				riscatto.setValoreRiscattoParzialeRichiesto("");
				riscatto.setDescValoreRiscattoParzialeRichiesto("");			
			}
			NodeList nodeFondo = doc.getElementsByTagName("fondo");
			Map<String, Object> mapFondo = getTag(nodeFondo);
			if(mapFondo != null){
				riscatto.setFondo(new Boolean((String)mapIsRamo3.get("value")).booleanValue());
				ArrayList<Fondo> listFondo = new ArrayList<Fondo>();
				Fondo fondo = null;
				//valorizzo la lista dei fondi
				NodeList listFondi = doc.getElementsByTagName("fondi");
				for(int s=0; s<listFondi.getLength() ; s++){
					org.w3c.dom.Node dati = listFondi.item(s);
					if(dati.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE){
						org.w3c.dom.Element tag = (org.w3c.dom.Element)dati;
						fondo = new Fondo();
						
						NodeList nodeFondoInternoOicr = tag.getElementsByTagName("fondoInternoOicr");
						Map<String, Object> mapFondoInternoOicr = getTag(nodeFondoInternoOicr);
						if(mapFondoInternoOicr != null){
							fondo.setFondoInternoOicr((String)mapFondoInternoOicr.get("value"));							
						}else{
							fondo.setFondoInternoOicr("");							
						}
						NodeList nodeQuote = tag.getElementsByTagName("quote");
						Map<String, Object> mapQuote = getTag(nodeQuote);
						if(mapQuote != null){
							fondo.setQuote((String)mapQuote.get("value"));							
						}else{
							fondo.setQuote("");							
						}
						NodeList nodeValoreQuota = tag.getElementsByTagName("valoreQuota");
						Map<String, Object> mapValoreQuota = getTag(nodeValoreQuota);
						if(mapValoreQuota != null){
							fondo.setValoreQuota((String)mapValoreQuota.get("value"));							
						}else{
							fondo.setValoreQuota("");							
						}
						NodeList nodeControvaloreQuoteLiquidate = tag.getElementsByTagName("controvaloreQuoteLiquidate");
						Map<String, Object> mapControvaloreQuoteLiquidate = getTag(nodeControvaloreQuoteLiquidate);
						if(mapControvaloreQuoteLiquidate != null){
							fondo.setControvaloreQuoteLiquidate((String)mapControvaloreQuoteLiquidate.get("value"));							
						}else{
							fondo.setControvaloreQuoteLiquidate("");							
						}						
						listFondo.add(fondo);
					}
				}
				riscatto.setListFondi(listFondo);
				//setto i totali
				NodeList nodeTotaleQuoteLiquidate = doc.getElementsByTagName("totaleQuoteLiquidate");
				Map<String, Object> mapTotaleQuoteLiquidate = getTag(nodeTotaleQuoteLiquidate);
				if(mapTotaleQuoteLiquidate != null){
					riscatto.setTotaleQuoteLiquidate((String)mapTotaleQuoteLiquidate.get("value"));
					riscatto.setDescTotaleQuoteLiquidate((String)mapTotaleQuoteLiquidate.get("desc"));
				}else{
					riscatto.setTotaleQuoteLiquidate("");
					riscatto.setDescTotaleQuoteLiquidate("");			
				}
				NodeList nodeTotaleControvaloreQuoteLiquidate = doc.getElementsByTagName("totaleControvaloreQuoteLiquidate");
				Map<String, Object> mapTotaleControvaloreQuoteLiquidate = getTag(nodeTotaleControvaloreQuoteLiquidate);
				if(mapTotaleControvaloreQuoteLiquidate != null){
					riscatto.setTotaleControvaloreQuoteLiquidate((String)mapTotaleControvaloreQuoteLiquidate.get("value"));
					riscatto.setDescTotaleControvaloreQuoteLiquidate((String)mapTotaleControvaloreQuoteLiquidate.get("desc"));
				}else{
					riscatto.setTotaleControvaloreQuoteLiquidate("");
					riscatto.setDescTotaleControvaloreQuoteLiquidate("");			
				}				
			}
		}catch (Exception e) {
			LoggingUtils.error(e.getMessage());
		}
		polizza.setRiscattoParzialeTendenza(riscatto);
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
}