package com.fideuram.crm.stampe.engine.lettere;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang.StringEscapeUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.fideuram.crm.stampe.engine.modello.Lettera;
import com.fideuram.crm.stampe.engine.modello.bean.Decumulo;
import com.fideuram.crm.stampe.engine.modello.bean.Polizza;
import com.fideuram.crm.stampe.engine.modello.bean.SollecitoRipensamentoRendita;
import com.fideuram.crm.stampe.serviceclient.bi.CodificaXML;
import com.fideuram.utils.LoggingUtils;

public class LetteraSollecitoDocumentiRipensamentoRendita {
	/**
	 * @param xml
	 * @return
	 */
	public static Map<String, Object> fromXml(String xml) {
		xml = CodificaXML.replace(xml);	    	
		try {        	
			SollecitoRipensamentoRendita modello = new SollecitoRipensamentoRendita();
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

			modello = setDatiSollecito(doc); 			
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("SollecitoDocumentiRipensamentoRendita", modello);
			return map;
		} catch (Exception e) {
			LoggingUtils.error(e.getMessage());
		}		        
		return null;        
	}	

	private static SollecitoRipensamentoRendita setDatiSollecito(Document doc) {
		SollecitoRipensamentoRendita sollecito = new SollecitoRipensamentoRendita();
		try{
			
          NodeList nodeDataLettera = doc.getElementsByTagName("dataLettera");
          Map<String, Object> mapDataLettera = getTag(nodeDataLettera);
          if(mapDataLettera != null){
              sollecito.setDataLettera((String)mapDataLettera.get("value"));
          }

          NodeList nodeNumeroPolizza = doc.getElementsByTagName("numeroPolizza");
          Map<String, Object> mapNumeroPolizza = getTag(nodeNumeroPolizza);
          if(mapNumeroPolizza != null){
  			sollecito.setNumeroPolizza((String)mapNumeroPolizza.get("value"));
          }

          NodeList nodeDataRichiesta = doc.getElementsByTagName("dataRichiesta");
          Map<String, Object> mapDataRichiesta = getTag(nodeDataRichiesta);
          if(mapDataRichiesta != null){
  			sollecito.setDataRichiesta((String)mapDataRichiesta.get("value"));
          }

          NodeList nodeIntestazione = doc.getElementsByTagName("intestazione");
          Map<String, Object> mapIntestazione = getTag(nodeIntestazione);
          if(mapIntestazione != null){
  			sollecito.setIntestazione((String)mapIntestazione.get("value"));
          }

          NodeList nodeCognome = doc.getElementsByTagName("cognome");
          Map<String, Object> mapCognome = getTag(nodeCognome);
          if(mapCognome != null){
  			sollecito.setCognome((String)mapCognome.get("value"));
          }

          NodeList nodeNome = doc.getElementsByTagName("nome");
          Map<String, Object> mapNome = getTag(nodeNome);
          if(mapNome != null){
  			sollecito.setNome((String)mapNome.get("value"));
          }

          NodeList nodeVia = doc.getElementsByTagName("via");
          Map<String, Object> mapVia = getTag(nodeVia);
          if(mapVia != null){
  			sollecito.setVia((String)mapVia.get("value"));
          }

          NodeList nodeCap = doc.getElementsByTagName("cap");
          Map<String, Object> mapCap = getTag(nodeCap);
          if(mapCap != null){
  			sollecito.setCap((String)mapCap.get("value"));
          }

          NodeList nodeComune = doc.getElementsByTagName("comune");
          Map<String, Object> mapComune = getTag(nodeComune);
          if(mapComune != null){
  			sollecito.setComune((String)mapComune.get("value"));
          }

          NodeList nodeProvincia = doc.getElementsByTagName("provincia");
          Map<String, Object> mapProvincia = getTag(nodeProvincia);
          if(mapProvincia != null){
  			sollecito.setProvincia((String)mapProvincia.get("value"));
          }

          NodeList nodeDocSollecitato = doc.getElementsByTagName("docSollecitato");
          List<String> docSollecitato = new ArrayList<String>();
          Node n=null;
  		  for (int i = 0; i < nodeDocSollecitato.getLength(); i++) {
  			n= nodeDocSollecitato.item(i);   
  			docSollecitato.add(n.getChildNodes().item(0).getNodeValue());
  		  }
  		  
          NodeList nodeNota = doc.getElementsByTagName("nota");
          Map<String, Object> mapNota = getTag(nodeNota);
          if(mapNota != null){
              sollecito.setNota((String)mapNota.get("value"));
          }

  		  sollecito.setDocSollecitato(docSollecitato);

		}catch (Exception e) {
			LoggingUtils.error(e.getMessage());
		}
		
		
		return sollecito;
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
	
	public static String decodeHTMLString(String s) {
        return StringEscapeUtils.unescapeHtml((s.replace("&amp;#39;", "`").replace("&apos;", "'")));
    }
}