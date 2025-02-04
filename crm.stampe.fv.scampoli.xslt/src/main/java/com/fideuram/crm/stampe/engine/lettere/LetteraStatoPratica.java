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
import com.fideuram.crm.stampe.engine.modello.bean.Disinvestimento;
import com.fideuram.crm.stampe.engine.modello.bean.Pagamento;
import com.fideuram.crm.stampe.engine.modello.bean.Polizza;
import com.fideuram.crm.stampe.engine.modello.bean.Pratica;
import com.fideuram.crm.stampe.serviceclient.bi.CodificaXML;
import com.fideuram.utils.LoggingUtils;

/**
 * Date: 22/11/11
 * Time: 17.00
 */
public class LetteraStatoPratica {
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

			modello = setDatiPratica(modello, doc); 

			modello = setDatiDisinvestimento(modello, doc);

			//modello = setDatiPagamentoTest(modello, doc);

			modello = setDatiPagamento(modello, doc);

			if(modello.getContraente().getCodiceFiscale().equals(modello.getPrimoassicurato().getCodiceFiscale()))
				modello.getPrimoassicurato().setCodiceFiscale("Contraente");

			if(modello.getDisinvestimento() == null){
				modello.setControlloDisinvestimento(false);
			}else{
				modello.setControlloDisinvestimento(true);
			}
			//controllo date
			if(modello.getRamoMinisteriale() != null && modello.getRamoMinisteriale().equals("1")){
				if(modello.getPratica().getDataPresuntoPagamento() != null){
					modello.getPratica().setVisualizzatoreDate(1);
				}else{
					modello.getPratica().setVisualizzatoreDate(0);
				}
			}else if(modello.getRamoMinisteriale() != null && modello.getRamoMinisteriale().equals("3")){
				if(modello.getPratica().getDataPresuntoPagamento() != null && modello.getPratica().getDataPresuntoDisinvestimento() != null){
					modello.getPratica().setVisualizzatoreDate(3);
				}else if(modello.getPratica().getDataPresuntoPagamento() != null){
					modello.getPratica().setVisualizzatoreDate(1);
				}else if(modello.getPratica().getDataPresuntoDisinvestimento() != null){
					modello.getPratica().setVisualizzatoreDate(2);
				}else{
					modello.getPratica().setVisualizzatoreDate(0);
				}
			}
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("polizza", modello);
			return map;
		} catch (Exception e) {
			LoggingUtils.error(e.getMessage());
		}		        
		return null;        
	}

	private static Polizza setDatiPratica(Polizza polizza, org.w3c.dom.Document doc){
		Pratica pratica = new Pratica();
		try{
			NodeList listDatiPratica = doc.getElementsByTagName("datiPratica"); 
			for(int s=0; s<listDatiPratica.getLength() ; s++){
				org.w3c.dom.Node dati = listDatiPratica.item(s);
				if(dati.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE){
					org.w3c.dom.Element tag = (org.w3c.dom.Element)dati;

					NodeList nodeReteVendita = tag.getElementsByTagName("reteVendita");
					Map<String, Object> mapReteVendita = getTag(nodeReteVendita);
					if(mapReteVendita != null){
						pratica.setReteVendita((String)mapReteVendita.get("value"));
					}else{
						pratica.setReteVendita("");					
					}
					
					NodeList nodeNumeroPratica = tag.getElementsByTagName("numeroPratica");
					Map<String, Object> mapNumeroPratica = getTag(nodeNumeroPratica);
					if(mapNumeroPratica != null){
						pratica.setNumeroPratica((String)mapNumeroPratica.get("value"));
						pratica.setDescNumeroPratica((String)mapNumeroPratica.get("desc"));
					}else{
						pratica.setNumeroPratica("");
						pratica.setDescNumeroPratica("");
					}
					NodeList nodeStatoPratica = tag.getElementsByTagName("statoPratica");
					Map<String, Object> mapStatoPratica = getTag(nodeStatoPratica);
					if(mapStatoPratica != null){
						pratica.setStatoPratica((String)mapStatoPratica.get("value"));
						pratica.setDescStatoPratica((String)mapStatoPratica.get("desc"));
					}else{
						pratica.setStatoPratica("");
						pratica.setDescStatoPratica("");
					}
					NodeList nodeDescrizioneStatoPratica = tag.getElementsByTagName("descrizioneStatoPratica");
					Map<String, Object> mapDescrizioneStatoPratica = getTag(nodeDescrizioneStatoPratica);
					if(mapDescrizioneStatoPratica != null){
						pratica.setServizioDescStPratica((String)mapDescrizioneStatoPratica.get("value"));
						pratica.setDescServizioDescStPratica((String)mapDescrizioneStatoPratica.get("desc"));
					}else{
						pratica.setServizioDescStPratica("");
						pratica.setDescServizioDescStPratica("");
					}					
					NodeList nodeNoteInCalce = tag.getElementsByTagName("noteInCalce");
					Map<String, Object> mapNoteInCalce = getTag(nodeNoteInCalce);
					if(mapNoteInCalce != null){
						pratica.setNoteInCalce((String)mapNoteInCalce.get("value"));
						pratica.setDescNoteInCalce((String)mapNoteInCalce.get("desc"));
					}else{
						pratica.setNoteInCalce("");
						pratica.setDescNoteInCalce("");
					}
					NodeList nodeTipoPratica = tag.getElementsByTagName("tipoPratica");
					Map<String, Object> mapTipoPratica = getTag(nodeTipoPratica);
					if(mapTipoPratica != null){
						pratica.setTipoPratica((String)mapTipoPratica.get("value"));
						pratica.setDescTipoPratica((String)mapTipoPratica.get("desc"));
					}else{
						pratica.setTipoPratica("");
						pratica.setDescTipoPratica("");
					}
					NodeList nodeDataRichiesta = tag.getElementsByTagName("dataRichiestaCliente");
					Map<String, Object> mapDataRichiesta = getTag(nodeDataRichiesta);
					if(mapDataRichiesta != null){
						//pratica.setDataRichiesta(convertStringDataString((String)mapDataRichiesta.get("value")));
						pratica.setDataRichiesta((String)mapDataRichiesta.get("value"));
						pratica.setDescDataRichiesta((String)mapDataRichiesta.get("desc"));
					}else{
						pratica.setDataRichiesta("");
					
						pratica.setDescDataRichiesta("");
					}					
					NodeList nodeDataEffetto = tag.getElementsByTagName("dataEffetto");
					Map<String, Object> mapDataEffetto = getTag(nodeDataEffetto);
					if(mapDataEffetto != null){
						//pratica.setDataEffetto(convertStringDataString((String)mapDataEffetto.get("value")));
						pratica.setDataEffetto((String)mapDataEffetto.get("value"));
						pratica.setDescDataEffetto((String)mapDataEffetto.get("desc"));
					}else{
						pratica.setDataEffetto("");
						pratica.setDescDataEffetto("");
					}
					NodeList nodeDataPresuntoPagamento = tag.getElementsByTagName("dataPresuntaPagamento");
					Map<String, Object> mapDataPresuntoPagamento = getTag(nodeDataPresuntoPagamento);
					if(mapDataPresuntoPagamento != null){
						//pratica.setDataPresuntoPagamento(convertStringDataString((String)mapDataPresuntoPagamento.get("value")));
						pratica.setDataPresuntoPagamento((String)mapDataPresuntoPagamento.get("value"));
						pratica.setDescDataPresuntoPagamento((String)mapDataPresuntoPagamento.get("desc"));
					}else{
						pratica.setDataPresuntoPagamento(null);
						pratica.setDescDataPresuntoPagamento(null);
					}
					NodeList nodeDataPresuntoDisinvestimento = tag.getElementsByTagName("dataPresuntaDisinvestimento");
					Map<String, Object> mapDataPresuntoDisinvestimento = getTag(nodeDataPresuntoDisinvestimento);
					if(mapDataPresuntoDisinvestimento != null){
						//pratica.setDataPresuntoDisinvestimento(convertStringDataString((String)mapDataPresuntoDisinvestimento.get("value")));
						pratica.setDataPresuntoDisinvestimento((String)mapDataPresuntoDisinvestimento.get("value"));
						pratica.setDescDataPresuntoDisinvestimento((String)mapDataPresuntoDisinvestimento.get("desc"));
					}else{
						pratica.setDataPresuntoDisinvestimento(null);
						pratica.setDescDataPresuntoDisinvestimento(null);
					}
					
					polizza.setPratica(pratica);
				}
			}	    		
		}catch (Exception e) {
			LoggingUtils.error(e.getMessage());
		}
		return polizza;
	}

	private static Polizza setDatiDisinvestimento(Polizza polizza, org.w3c.dom.Document doc){
		Disinvestimento disinvestimento = new Disinvestimento();
		try{
			NodeList listDatiDisinvestimento = doc.getElementsByTagName("datiDisinvestimento"); 
			for(int s=0; s<listDatiDisinvestimento.getLength() ; s++){
				org.w3c.dom.Node dati = listDatiDisinvestimento.item(s);
				if(dati.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE){
					org.w3c.dom.Element tag = (org.w3c.dom.Element)dati;

					NodeList nodeNumeroQuote = tag.getElementsByTagName("numeroQuote");
					Map<String, Object> mapNumeroQuote = getTag(nodeNumeroQuote);
					if(mapNumeroQuote != null){
						disinvestimento.setNumeroQuote((String)mapNumeroQuote.get("value"));
						disinvestimento.setDescNumeroQuote((String)mapNumeroQuote.get("desc"));
					}else{
						disinvestimento.setNumeroQuote("");
						disinvestimento.setDescNumeroQuote("");
					}
					NodeList nodeControvaloreQuote = tag.getElementsByTagName("controvaloreQuote");
					Map<String, Object> mapControvaloreQuote = getTag(nodeControvaloreQuote);
					if(mapControvaloreQuote != null){
						disinvestimento.setControvaloreQuote((String)mapControvaloreQuote.get("value"));
						disinvestimento.setDescControvaloreQuote((String)mapControvaloreQuote.get("desc"));
					}else{
						disinvestimento.setNumeroQuote("");
						disinvestimento.setDescNumeroQuote("");
					}	    		
					NodeList nodeDataNavDisinvestimento = tag.getElementsByTagName("dataNavDisinvestimento");
					Map<String, Object> mapDataNavDisinvestimento = getTag(nodeDataNavDisinvestimento);
					if(mapDataNavDisinvestimento != null){
						//disinvestimento.setDataNavDisinvestimento(convertStringDataString((String)mapDataNavDisinvestimento.get("value")));
						disinvestimento.setDataNavDisinvestimento((String)mapDataNavDisinvestimento.get("value"));
						disinvestimento.setDescDataNavDisinvestimento((String)mapDataNavDisinvestimento.get("desc"));
					}else{
						disinvestimento.setDataNavDisinvestimento("");
						disinvestimento.setDescDataNavDisinvestimento("");
					}	    		
					polizza.setDisinvestimento(disinvestimento);
				}
			}
		}catch (Exception e) {
			LoggingUtils.error(e.getMessage());
		}
		return polizza;
	}

	private static Polizza setDatiPagamento(Polizza polizza, org.w3c.dom.Document doc){
		ArrayList<Pagamento> listPagamento = new ArrayList<Pagamento>();	    	
		try{
			NodeList listDatiPagamento = doc.getElementsByTagName("datiPagamento");
			Pagamento pagamento = null;
			for(int s=0; s<listDatiPagamento.getLength() ; s++){	    			
				org.w3c.dom.Node dati = listDatiPagamento.item(s);
				if(dati.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE){
					pagamento = new Pagamento();
					org.w3c.dom.Element tag = (org.w3c.dom.Element)dati;

					NodeList nodeImportoLordo = tag.getElementsByTagName("importoLordo");
					Map<String, Object> mapImportoLordo = getTag(nodeImportoLordo);
					if(mapImportoLordo != null){
						pagamento.setImportoLordo((String)mapImportoLordo.get("value"));
						pagamento.setDescImportoLordo((String)mapImportoLordo.get("desc"));
					}else{
						pagamento.setImportoLordo("");
						pagamento.setDescImportoLordo("");
					}
					NodeList nodeImportoNetto = tag.getElementsByTagName("importoNetto");
					Map<String, Object> mapImportoNetto = getTag(nodeImportoNetto);
					if(mapImportoNetto != null){
						pagamento.setImportoNetto((String)mapImportoNetto.get("value"));
						pagamento.setDescImportoNetto((String)mapImportoNetto.get("desc"));
					}else{
						pagamento.setImportoNetto("");
						pagamento.setDescImportoNetto("");
					}	    		
					NodeList nodeDataValuta = tag.getElementsByTagName("dataValuta");
					Map<String, Object> mapDataValuta = getTag(nodeDataValuta);
					if(mapDataValuta != null){
						//pagamento.setDataValuta(convertStringDataString((String)mapDataValuta.get("value")));
						pagamento.setDataValuta((String)mapDataValuta.get("value"));
						pagamento.setDescDataValuta((String)mapDataValuta.get("desc"));
					}else{
						pagamento.setDataValuta("");
						pagamento.setDescDataValuta("");
					}
					NodeList nodeModalitaPagamento = tag.getElementsByTagName("modalitaPagamento");
					Map<String, Object> mapModalitaPagamento = getTag(nodeModalitaPagamento);
					if(mapModalitaPagamento != null){
						pagamento.setModalitaPagamento(decodeHTMLString((String)mapModalitaPagamento.get("value")));
						pagamento.setDescModalitaPagamento((String)mapModalitaPagamento.get("desc"));
					}else{
						pagamento.setModalitaPagamento("");
						pagamento.setDescModalitaPagamento("");
					}	
					NodeList nodeIban = tag.getElementsByTagName("iban");
					Map<String, Object> mapIban = getTag(nodeIban);
					if(mapIban != null){
						pagamento.setIban((String)mapIban.get("value"));
						pagamento.setDescIban((String)mapIban.get("desc"));
					}else{
						pagamento.setIban("");
						pagamento.setDescIban("");
					}
					NodeList nodeNumeroConto = tag.getElementsByTagName("numeroConto");
					Map<String, Object> mapNumeroConto = getTag(nodeNumeroConto);
					if(mapNumeroConto != null){
						pagamento.setNumeroConto((String)mapNumeroConto.get("value"));
						pagamento.setDescNumeroConto((String)mapNumeroConto.get("desc"));
					}else{
						pagamento.setNumeroConto("");
						pagamento.setDescNumeroConto("");
					}
					NodeList nodeBeneficiatoLiquidazione = tag.getElementsByTagName("beneficiatoLiquidazione");
					Map<String, Object> mapBeneficiatoLiquidazione = getTag(nodeBeneficiatoLiquidazione);
					if(mapBeneficiatoLiquidazione != null){
						pagamento.setBeneficiarioLiquidazione(decodeHTMLString((String)mapBeneficiatoLiquidazione.get("value")));
						pagamento.setDescBeneficiarioLiquidazione((String)mapBeneficiatoLiquidazione.get("desc"));
					}else{
						pagamento.setBeneficiarioLiquidazione("");
						pagamento.setDescBeneficiarioLiquidazione("");
					}

					listPagamento.add(pagamento);
				}
			}
			polizza.setListPagamento(listPagamento);
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