package com.fideuram.crm.stampe.engine.lettere;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang.StringEscapeUtils;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.fideuram.crm.stampe.engine.modello.Lettera;
import com.fideuram.crm.stampe.engine.modello.bean.Certezza;
import com.fideuram.crm.stampe.engine.modello.bean.OpzioneFrazionamento;
import com.fideuram.crm.stampe.engine.modello.bean.Polizza;
import com.fideuram.crm.stampe.serviceclient.bi.CodificaXML;
import com.fideuram.utils.LoggingUtils;

/**
 * Date: 22/11/11
 * Time: 17.00
 */
public class LetteraIpotesiOpzione {
	private Polizza polizza;

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

			modello = setDatiFrazionamento(modello, doc); 

			modello = setDatiCertezza(modello, doc);

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
	
	private static Polizza setDatiFrazionamento(Polizza polizza, org.w3c.dom.Document doc){
		OpzioneFrazionamento opzioneFrazionamento = new OpzioneFrazionamento();
		try{
			NodeList nodeDataRiferimentoNav = doc.getElementsByTagName("dataRiferimentoNav");
			Map<String, Object> mapDataRiferimentoNav = getTag(nodeDataRiferimentoNav);
			if(mapDataRiferimentoNav != null){
				opzioneFrazionamento.setDataRiferimentoNav((String)mapDataRiferimentoNav.get("value"));				
			}else{
				opzioneFrazionamento.setDataRiferimentoNav("");				
			}   
    		
			NodeList listDatiFrazionamento = doc.getElementsByTagName("renditaOpzioneFrazionamento"); 
			for(int s=0; s<listDatiFrazionamento.getLength() ; s++){
				org.w3c.dom.Node dati = listDatiFrazionamento.item(s);
				if(dati.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE){
					org.w3c.dom.Element tag = (org.w3c.dom.Element)dati;

					NodeList nodeAnnualePosticipata = tag.getElementsByTagName("annualePosticipata");
					Map<String, Object> mapnodeAnnualePosticipata = getTag(nodeAnnualePosticipata);
					if(mapnodeAnnualePosticipata != null){
						opzioneFrazionamento.setAnnualePosticipata((String)mapnodeAnnualePosticipata.get("value"));
						opzioneFrazionamento.setDescAnnualePosticipata((String)mapnodeAnnualePosticipata.get("desc"));
					}else{
						opzioneFrazionamento.setAnnualePosticipata("");
						opzioneFrazionamento.setDescAnnualePosticipata("");
					}
					NodeList nodeSemestralePosticipata = tag.getElementsByTagName("semestralePosticipata");
					Map<String, Object> mapSemestralePosticipata = getTag(nodeSemestralePosticipata);
					if(mapSemestralePosticipata != null){
						opzioneFrazionamento.setSemestralePosticipata((String)mapSemestralePosticipata.get("value"));
						opzioneFrazionamento.setDescSemestralePosticipata((String)mapSemestralePosticipata.get("desc"));
					}else{
						opzioneFrazionamento.setSemestralePosticipata("");
						opzioneFrazionamento.setDescSemestralePosticipata("");
					}	    		
					NodeList nodeTrimestralePosticipata = tag.getElementsByTagName("trimestralePosticipata");
					Map<String, Object> mapTrimestralePosticipata = getTag(nodeTrimestralePosticipata);
					if(mapTrimestralePosticipata != null){						
						opzioneFrazionamento.setTrimestralePosticipata((String)mapTrimestralePosticipata.get("value"));
						opzioneFrazionamento.setDescTrimestralePosticipata((String)mapTrimestralePosticipata.get("desc"));
					}else{
						opzioneFrazionamento.setTrimestralePosticipata("");
						opzioneFrazionamento.setDescTrimestralePosticipata("");
					}
					NodeList nodeMensilePosticipata = tag.getElementsByTagName("mensilePosticipata");
					Map<String, Object> mapMensilePosticipata = getTag(nodeMensilePosticipata);
					if(mapMensilePosticipata != null){						
						opzioneFrazionamento.setMensilePosticipata((String)mapMensilePosticipata.get("value"));
						opzioneFrazionamento.setDescMensilePosticipata((String)mapMensilePosticipata.get("desc"));
					}else{
						opzioneFrazionamento.setMensilePosticipata("");
						opzioneFrazionamento.setDescMensilePosticipata("");
					}	
					polizza.setOpzioneFrazionamento(opzioneFrazionamento);
				}
			}
		}catch (Exception e) {
			LoggingUtils.error(e.getMessage());
		}
		return polizza;
	}
	
	private static Polizza setDatiCertezza(Polizza polizza, org.w3c.dom.Document doc){
		ArrayList<Certezza> annualePosticipata = new ArrayList<Certezza>();
		try{
			Certezza certezza = null;
			NodeList listDatiCertezza = doc.getElementsByTagName("renditaOpzioneCertezza"); 			
			for(int s=0; s<listDatiCertezza.getLength() ; s++){
								
				org.w3c.dom.Node dati = listDatiCertezza.item(s);
				if(dati.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE){
					org.w3c.dom.Element tag = (org.w3c.dom.Element)dati;
					certezza = new Certezza();

					Map<String, Object> mapnodeRenditaOpzioneCertezza = getTag(listDatiCertezza);
					if(mapnodeRenditaOpzioneCertezza != null){
						String anniCertezza = (String)mapnodeRenditaOpzioneCertezza.get("desc");
						if(anniCertezza != null && !anniCertezza.trim().equals("")){
							anniCertezza = anniCertezza.substring(0,anniCertezza.indexOf("anni"));
							certezza.setAnniCertezza(anniCertezza);
						}
					}else{
						certezza.setAnniCertezza("");					
					}
					
					NodeList nodeAnnualePosticipata = tag.getElementsByTagName("annualePosticipata");
					Map<String, Object> mapnodeAnnualePosticipata = getTag(nodeAnnualePosticipata);
					if(mapnodeAnnualePosticipata != null){
						certezza.setAnnualePosticipata((String)mapnodeAnnualePosticipata.get("value"));
						certezza.setDescAnnualePosticipata((String)mapnodeAnnualePosticipata.get("desc"));
					}else{
						certezza.setAnnualePosticipata("");
						certezza.setDescAnnualePosticipata("");
					}
					NodeList nodeSemestralePosticipata = tag.getElementsByTagName("semestralePosticipata");
					Map<String, Object> mapSemestralePosticipata = getTag(nodeSemestralePosticipata);
					if(mapSemestralePosticipata != null){
						certezza.setSemestralePosticipata((String)mapSemestralePosticipata.get("value"));
						certezza.setDescSemestralePosticipata((String)mapSemestralePosticipata.get("desc"));
					}else{
						certezza.setSemestralePosticipata("");
						certezza.setDescSemestralePosticipata("");
					}	    		
					NodeList nodeTrimestralePosticipata = tag.getElementsByTagName("trimestralePosticipata");
					Map<String, Object> mapTrimestralePosticipata = getTag(nodeTrimestralePosticipata);
					if(mapTrimestralePosticipata != null){						
						certezza.setTrimestralePosticipata((String)mapTrimestralePosticipata.get("value"));
						certezza.setDescTrimestralePosticipata((String)mapTrimestralePosticipata.get("desc"));
					}else{
						certezza.setTrimestralePosticipata("");
						certezza.setDescTrimestralePosticipata("");
					}
					NodeList nodeMensilePosticipata = tag.getElementsByTagName("mensilePosticipata");
					Map<String, Object> mapMensilePosticipata = getTag(nodeMensilePosticipata);
					if(mapMensilePosticipata != null){						
						certezza.setMensilePosticipata((String)mapMensilePosticipata.get("value"));
						certezza.setDescMensilePosticipata((String)mapMensilePosticipata.get("desc"));
					}else{
						certezza.setMensilePosticipata("");
						certezza.setDescMensilePosticipata("");
					}					
					annualePosticipata.add(certezza);															
				}
			}
			polizza.setListCertezza(annualePosticipata);
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
			if(((org.w3c.dom.Node)textNode.item(0)) != null && ((org.w3c.dom.Node)textNode.item(0)).getNodeValue() != null){				
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