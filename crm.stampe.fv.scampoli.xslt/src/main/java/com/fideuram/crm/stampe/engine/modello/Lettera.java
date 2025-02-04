package com.fideuram.crm.stampe.engine.modello;

import com.fideuram.crm.stampe.engine.modello.bean.DatiPolizza;
import com.fideuram.crm.stampe.engine.modello.bean.Polizza;
import com.fideuram.stampe.modello.attori.Assicurato;
import com.fideuram.stampe.modello.attori.Contraente;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.LoggingUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.w3c.dom.NodeList;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Date: 22/11/11
 * Time: 10.00
 */
public class Lettera {
    private Polizza polizza;

    /**
     *
     * @param polizza
     * @param doc
     * @return Polizza
     */
    public static Polizza getLettera(Polizza polizza, org.w3c.dom.Document doc) {
    	try {        	
    		polizza = setDatiPolizza(polizza, doc);
    		polizza = setDatiAnagrafiche(polizza, doc);  
    		
    		//2012-11-12 aggiunta la data richiesta stampa
    		String dataStampa = DateUtils.formatNow("dd/MM/yyyy HH:mm");
    		polizza.setDataRichiestaStampa(dataStampa);
    		
    		return polizza;
    	} catch (Exception e) {
    		LoggingUtils.error(e.getMessage());
    	}		        
    	return null;        
    }
    
    private static Polizza setDatiPolizza(Polizza polizza, org.w3c.dom.Document doc){
    	DatiPolizza datiPolizza = new DatiPolizza();
    	try {
    		NodeList nodeRamoMinisteriale = doc.getElementsByTagName("ramoMinisteriale");    		
    		Map<String, Object> mapRamoMinisteriale = getTag(nodeRamoMinisteriale);
    		if(mapRamoMinisteriale != null){
    			polizza.setRamoMinisteriale((String)mapRamoMinisteriale.get("value"));    			
    		}else{
    			polizza.setRamoMinisteriale("");
    		}     		
    		    		
			NodeList nodeTipoPrestazione = doc.getElementsByTagName("tipoPrestazione");
			Map<String, Object> mapTipoPrestazione = getTag(nodeTipoPrestazione);
    		if(mapTipoPrestazione != null){
    			polizza.setTipoPrestazione((String)mapTipoPrestazione.get("value"));
    			
    		}else{
    			polizza.setTipoPrestazione("");
    		}  
    		
    		NodeList nodeReteVendita = doc.getElementsByTagName("reteVendita");
    		Map<String, Object> mapReteVendita = getTag(nodeReteVendita);
    		if(mapReteVendita != null){
    			polizza.setReteVendita((String)mapReteVendita.get("value"));			
    		}else{
    			polizza.setReteVendita("");						
    		}
			
    		NodeList listDatiPolizza = doc.getElementsByTagName("datiPolizza");    		
    		
    		for(int s=0; s<listDatiPolizza.getLength() ; s++){
    			org.w3c.dom.Node dati = listDatiPolizza.item(s);
    			if(dati.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE){
    				org.w3c.dom.Element firstPersonElement = (org.w3c.dom.Element)dati;

    				NodeList nodeNumeroPolizza = firstPersonElement.getElementsByTagName("numeroPolizza");
    				Map<String, Object> mapNumeroPolizza = getTag(nodeNumeroPolizza);
    	    		if(mapNumeroPolizza != null){
    	    			datiPolizza.setNumeroPolizza((String)mapNumeroPolizza.get("value"));
    	    			datiPolizza.setDescNumeroPolizza((String)mapNumeroPolizza.get("desc"));
    	    		}else{
    	    			datiPolizza.setNumeroPolizza("");
    	    			datiPolizza.setDescNumeroPolizza("");
    	    		} 
    	    		    				
    				NodeList nodeCodiceConferimento = firstPersonElement.getElementsByTagName("codiceConferimento");
    				Map<String, Object> mapCodiceConferimento = getTag(nodeCodiceConferimento);
    	    		if(mapCodiceConferimento != null){
    	    			datiPolizza.setCodiceConferimento((String)mapCodiceConferimento.get("value"));
    	    			datiPolizza.setDescCodiceConferimento((String)mapCodiceConferimento.get("desc"));
    	    		}else{
    	    			datiPolizza.setCodiceConferimento("");
    	    			datiPolizza.setDescCodiceConferimento("");
    	    		} 
    			    				    				
    				NodeList nodeProdotto = firstPersonElement.getElementsByTagName("prodotto");
    				Map<String, Object> mapProdotto = getTag(nodeProdotto);
    	    		if(mapProdotto != null){
    	    			datiPolizza.setProdotto(decodeHTMLString((String)mapProdotto.get("value")));
    	    			datiPolizza.setDescProdotto((String)mapProdotto.get("desc"));
    	    		}else{
    	    			datiPolizza.setProdotto("");
    	    			datiPolizza.setDescProdotto("");
    	    		}
    				
    				NodeList nodeTariffa = firstPersonElement.getElementsByTagName("tariffa");
    				Map<String, Object> mapTariffa = getTag(nodeTariffa);
    	    		if(mapTariffa != null){
    	    			datiPolizza.setTariffa(decodeHTMLString((String)mapTariffa.get("value")));
    	    			datiPolizza.setDescTariffa((String)mapTariffa.get("desc"));
    	    		}else{
    	    			datiPolizza.setTariffa("");
    	    			datiPolizza.setDescTariffa("");
    	    		}
    				    				
    				NodeList nodeStato = firstPersonElement.getElementsByTagName("stato");
    				Map<String, Object> mapStato = getTag(nodeStato);
    	    		if(mapStato != null){
    	    			datiPolizza.setStato((String)mapStato.get("value"));
    	    			datiPolizza.setDescStato((String)mapStato.get("desc"));
    	    		}else{
    	    			datiPolizza.setStato("");
    	    			datiPolizza.setDescStato("");
    	    		}
    				    				    				    				
    				NodeList nodeDataEmissione = firstPersonElement.getElementsByTagName("dataEmissione");
    				Map<String, Object> mapDataEmissione = getTag(nodeDataEmissione);
    	    		if(mapDataEmissione != null){
    	    			//datiPolizza.setDataEmissione(convertStringDataString((String)mapDataEmissione.get("value")));
    	    			datiPolizza.setDataEmissione((String)mapDataEmissione.get("value"));
    	    			datiPolizza.setDescDataEmissione((String)mapDataEmissione.get("desc"));
    	    		}else{
    	    			datiPolizza.setDataEmissione("");
    	    			datiPolizza.setDescDataEmissione("");
    	    		}
    				    				
    				NodeList nodeDataScadenza = firstPersonElement.getElementsByTagName("dataScadenza");
    				Map<String, Object> mapDataScadenza = getTag(nodeDataScadenza);
    	    		if(mapDataScadenza != null){
    	    			//datiPolizza.setDataScadenzaPolizza(convertStringDataString((String)mapDataScadenza.get("value")));
    	    			datiPolizza.setDataScadenzaPolizza((String)mapDataScadenza.get("value"));
    	    			datiPolizza.setDescDataScadenzaPolizza((String)mapDataScadenza.get("desc"));
    	    		}else{
    	    			datiPolizza.setDataScadenzaPolizza("");
    	    			datiPolizza.setDescDataScadenzaPolizza("");
    	    		}
    				    				
    				NodeList nodeDataRichiesta = firstPersonElement.getElementsByTagName("dataRichiesta");
    				Map<String, Object> mapDataRichiesta = getTag(nodeDataRichiesta);
    	    		if(mapDataRichiesta != null){
    	    			//datiPolizza.setDataElaborazione(convertStringDataString((String)mapDataRichiesta.get("value")));
    	    			datiPolizza.setDataElaborazione((String)mapDataRichiesta.get("value"));
    	    			datiPolizza.setDescDataElaborazione((String)(mapDataRichiesta.get("desc")));
    	    		}else{
    	    			datiPolizza.setDataElaborazione("");
    	    			datiPolizza.setDescDataElaborazione("");
    	    		}
    	    		NodeList nodePremiVersati = firstPersonElement.getElementsByTagName("premiVersati");
					Map<String, Object> mapPremiVersati = getTag(nodePremiVersati);
					if(mapPremiVersati != null){
						polizza.setPremiVersatiNav((String)mapPremiVersati.get("value"));
						polizza.setDescPremiVersatiNav((String)mapPremiVersati.get("desc"));						
					}else{
						polizza.setPremiVersatiNav("");
						polizza.setDescPremiVersatiNav("");
					}
    			}
    		}

    	} catch (Exception e) {
    		LoggingUtils.error(e.getMessage());    	
    	} 
    	polizza.setDatiPolizza(datiPolizza);
    	return polizza;
    }
    
    private static Polizza setDatiAnagrafiche(Polizza polizza, org.w3c.dom.Document doc){
    	Contraente c=null;
        Assicurato p1=null;
        
    	try {    		    		    		
    		NodeList listContraente = doc.getElementsByTagName("contraente");    		    		
    		for(int s=0; s<listContraente.getLength() ; s++){
    			org.w3c.dom.Node datiContraente = listContraente.item(s);
    			if(datiContraente.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE){
    				c = new Contraente();
    				org.w3c.dom.Element contraente = (org.w3c.dom.Element)datiContraente;

    				NodeList nodeNominativo = contraente.getElementsByTagName("nominativo");
    				Map<String, Object> mapNominativo = getTag(nodeNominativo);
    	    		if(mapNominativo != null){
    	    			c.setNominativo(decodeHTMLString((String)mapNominativo.get("value")));
    	    			c.setDescNominativo((String)mapNominativo.get("desc"));
    	    		}else{
    	    			c.setNominativo("");
    	    			c.setDescNominativo("");
    	    		}
    				
    				NodeList nodeDataNascita = contraente.getElementsByTagName("dataNascita");
    				Map<String, Object> mapDataNascita = getTag(nodeDataNascita);
    	    		if(mapDataNascita != null){
    	    			//c.setDataNascitaString(convertStringDataString((String)mapDataNascita.get("value")));
    	    			c.setDataNascitaString((String)mapDataNascita.get("value"));
    	    			c.setDescDataNascitaString((String)mapDataNascita.get("desc"));
    	    		}else{
    	    			c.setDataNascitaString("");
    	    			c.setDescDataNascitaString("");
    	    		}
    				
    				NodeList nodeCodiceFiscale = contraente.getElementsByTagName("codiceFiscale");
    				Map<String, Object> mapCodiceFiscale = getTag(nodeCodiceFiscale);
    	    		if(mapCodiceFiscale != null){
    	    			c.setCodiceFiscale((String)mapCodiceFiscale.get("value"));
    	    			c.setDescCodiceFiscale((String)mapCodiceFiscale.get("desc"));
    	    		}else{
    	    			c.setCodiceFiscale("");
    	    		}    				    						
    			}
    		}
    		
    		NodeList listPrimoAssicurato = doc.getElementsByTagName("primoAssicurato");    		    		
    		
    		for(int s=0; s<listPrimoAssicurato.getLength() ; s++){
    			org.w3c.dom.Node datiPrimoAssicurato = listPrimoAssicurato.item(s);
    			if(datiPrimoAssicurato.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE){
    				p1 = new Assicurato();
    				org.w3c.dom.Element primoAssicurato = (org.w3c.dom.Element)datiPrimoAssicurato;

    				NodeList nodeNominativo = primoAssicurato.getElementsByTagName("nominativo");
    				Map<String, Object> mapNominativo = getTag(nodeNominativo);
    	    		if(mapNominativo != null){
    	    			p1.setNominativo(decodeHTMLString((String)mapNominativo.get("value"))); 
    	    			p1.setDescNominativo((String)mapNominativo.get("desc"));
    	    		}else{
    	    			p1.setNominativo("");
    	    			p1.setDescNominativo("");
    	    		}    				    				    				
    				
    	    		NodeList nodeDataNascita = primoAssicurato.getElementsByTagName("dataNascita");
    				Map<String, Object> mapDataNascita = getTag(nodeDataNascita);
    	    		if(mapDataNascita != null){
    	    			//p1.setDataNascitaString(convertStringDataString((String)mapDataNascita.get("value"))); 
    	    			p1.setDataNascitaString((String)mapDataNascita.get("value"));
    	    			p1.setDescDataNascitaString((String)mapDataNascita.get("desc"));
    	    		}else{
    	    			p1.setDataNascitaString("");
    	    			p1.setDescDataNascitaString("");
    	    		}
    				
    				NodeList nodeCodiceFiscale = primoAssicurato.getElementsByTagName("codiceFiscale");
    				Map<String, Object> mapCodiceFiscale = getTag(nodeCodiceFiscale);
    	    		if(mapCodiceFiscale != null){
    	    			p1.setCodiceFiscale((String)mapCodiceFiscale.get("value"));
    	    			p1.setDescCodiceFiscale((String)mapCodiceFiscale.get("desc"));
    	    		}else{
    	    			p1.setCodiceFiscale("");
    	    			p1.setDescCodiceFiscale("");
    	    		}     				   				
    			}
    		}

    	} catch (Exception e) {
    		LoggingUtils.error(e.getMessage());
    	}     	
    	if(c!=null) polizza.setContraente(c);
        if(p1!=null) polizza.setPrimoassicurato(p1);
        
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