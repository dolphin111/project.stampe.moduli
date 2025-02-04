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
import com.fideuram.crm.stampe.engine.modello.bean.Decumulo;
import com.fideuram.crm.stampe.engine.modello.bean.Polizza;
import com.fideuram.crm.stampe.serviceclient.bi.CodificaXML;
import com.fideuram.utils.LoggingUtils;

public class LetteraDecumulo {
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
			
			modello = setDatiDecumulo(modello, doc); 			
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("polizza", modello);
			return map;
		} catch (Exception e) {
			LoggingUtils.error(e.getMessage());
		}		        
		return null;        
	}	

	private static Polizza setDatiDecumulo(Polizza polizza, Document doc) {
		Decumulo decumulo = new Decumulo();
		try{
			
			//NodeList nodeControvaloreQuote = doc.getElementsByTagName("controvaloreQuote");
			//Map<String, Object> mapControvaloreQuote = getTag(nodeControvaloreQuote);
			//if(mapControvaloreQuote != null){
			//	decumulo.setControvaloreQuote((String)mapControvaloreQuote.get("value"));
			//	decumulo.setDescControvaloreQuote((String)mapControvaloreQuote.get("desc"));
			//}

            NodeList nodeImportCVN = doc.getElementsByTagName("importoCVN");
            Map<String, Object> mapImportCVN = getTag(nodeImportCVN);
            if(mapImportCVN != null){
                decumulo.setImportoCVM((String)mapImportCVN.get("value"));
                decumulo.setDescCVN((String)mapImportCVN.get("desc"));
            }

            NodeList nodeDataCvn = doc.getElementsByTagName("dataCVN");
            Map<String, Object> mapDataCvn = getTag(nodeDataCvn);
            if(mapDataCvn != null){
            	decumulo.setDataCVN((String)mapDataCvn.get("value"));
            }

            NodeList nodePercentuale = doc.getElementsByTagName("percentuale");
			Map<String, Object> mapPercentuale = getTag(nodePercentuale);
			if(mapPercentuale != null){
				decumulo.setPercentuale((String)mapPercentuale.get("value"));
				decumulo.setDescPercentuale((String)mapPercentuale.get("desc"));
			}


			NodeList nodeTipoFrazionamento = doc.getElementsByTagName("frazionamento");
			Map<String, Object> mapTipoFrazionamento = getTag(nodeTipoFrazionamento);
			if(mapTipoFrazionamento != null){
				decumulo.setFrazionamento((String)mapTipoFrazionamento.get("value"));
			}

			NodeList nodeImportoCedola = doc.getElementsByTagName("importoCedola");
			Map<String, Object> mapImportoCedola = getTag(nodeImportoCedola);
			if(mapImportoCedola != null){
				decumulo.setImportoCedola((String)mapImportoCedola.get("value"));
				decumulo.setDescImportoCedola((String)mapImportoCedola.get("desc"));
			}


            NodeList nodeImportoDecumulo = doc.getElementsByTagName("importoDecumulo");
            Map<String, Object> mapImportoDecumulo = getTag(nodeImportoDecumulo);
            if(mapImportoDecumulo != null){
                decumulo.setImportoDecumulo((String)mapImportoDecumulo.get("value"));
                decumulo.setDescImportoDecumulo((String)mapImportoDecumulo.get("desc"));
            }

			//NodeList nodeDataNav = doc.getElementsByTagName("dataNav");
			//Map<String, Object> mapDataNav = getTag(nodeDataNav);
			//if(mapDataNav != null){
			//	decumulo.setDataNav((String)mapDataNav.get("value"));
			//}
		
			polizza.setDecumulo(decumulo);


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
	
	public static String decodeHTMLString(String s) {
        return StringEscapeUtils.unescapeHtml((s.replace("&amp;#39;", "`").replace("&apos;", "'")));
    }
}