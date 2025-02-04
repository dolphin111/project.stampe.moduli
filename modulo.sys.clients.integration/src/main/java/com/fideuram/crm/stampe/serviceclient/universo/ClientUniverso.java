package com.fideuram.crm.stampe.serviceclient.universo;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.fideuram.exception.ws.UniversoException;
import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.serviceclient.bi.CodificaXML;
import com.fideuram.crm.stampe.serviceclient.bi.FondoBean;
import com.fideuram.crm.stampe.serviceclient.bi.WSConversioneinRenditaBean;
import com.fideuram.crm.stampe.serviceclient.bi.WSOpzioniBean;
import com.fideuram.crm.stampe.serviceclient.bi.WSPrestazioniAssicurateBean;
import com.fideuram.crm.stampe.serviceclient.bi.WSRiduzioneBean;
import com.fideuram.crm.stampe.serviceclient.bi.WSRiscattoBean;
import com.fideuram.crm.stampe.serviceclient.bi.WSRiscattoParzialePuntualeBean;
import com.fideuram.crm.stampe.serviceclient.bi.WSRiscattoParzialeTendenzaBean;
import com.fideuram.crm.stampe.serviceclient.bi.WSRiscattoPolizzeChiuseBean;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.NumberUtils;
import com.fideuram.utils.StringUtils;

/**
 * Created by
 * User: logan
 * Date: 02/08/11
 * Time: 13.23
 */
public abstract class ClientUniverso {

        /**
         * Restituisce le prestazioni assicurate della polizza, riferiti alla data indicata.
         * TUTTI I CASI TRANNE QUELLO DI POLIZZA DI ECCEDENZA.
         * @param numeroPolizza			numero di polizza
         * @param dataValutazione		data di riferimento
         * @return
         * @throws com.fideuram.exception.ws.UniversoException
         */
        public abstract WSPrestazioniAssicurateBean getPrestazioniAssicurate(String numeroPolizza, String dataValutazione) throws UniversoException;


        /**
         * Restituisce l'ipotesi di riscatto delle polizze aperte.
         * @param polizza					numero di polizza
         * @param dataValutazione			data di valutazione indicata
         * @param indicatoreTipoRisc		indicatore della tipologia di riscatto
         * @return
         * @throws UniversoException
         */
        public abstract WSRiscattoBean getRiscattoPolizzeAperte(String polizza, String dataValutazione, int indicatoreTipoRisc) throws UniversoException;

        /**
         * Restituisce l'ipotesi di riscatto per le polizze chiuse.
         * @param polizza			numero di polizza
         * @param dataValutazione	data di valutazione
         * @return
         * @throws UniversoException
         */
        public abstract WSRiscattoPolizzeChiuseBean getRiscattoPolizzeChiuse(String polizza, String dataValutazione) throws UniversoException ;

        /**
         * Restituisce la conversione in idennità di rendita per la polizza passata, alla data indicata.
         * @param polizza			numero di polizza
         * @param dataValutazione	data di riferimento
         * @return
         * @throws UniversoException
         */
        public abstract WSConversioneinRenditaBean getConversioneInRendita(String polizza, String dataValutazione) throws UniversoException ;

        /**
         * Restituisce il calcolo di riduzione per la polizza indicata, alla data indicata.
         * @param polizza
         * @param dataValutazione
         * @return
         * @throws Exception
         */
        public abstract WSRiduzioneBean getRiduzione(String polizza, String dataValutazione) throws UniversoException ;

        /**
         * Restituisce l'opzione di reversibilità della polizza inidcata secondo i valori indicati.
         * @param polizza			numero della polizza
         * @param frazionamento		frazionamento (annuale, semestrale, mensile, ...)
         * @param reversibilita		indice di reversibilità
         * @param dataNascita		data di nascita del titolare della polizza
         * @param sesso				sesso del titolare della polizza
         * @param anticipata		valore per il calcolo di opzione anticipata o meno
         * @return
         * @throws UniversoException
         */
        public abstract  WSOpzioniBean getOpzReversibilita(String polizza, String frazionamento, String reversibilita,
                String dataNascita, String sesso, String anticipata)
        throws UniversoException ;

        /**
         * Restituisce l'opzione di certezza della polizza inidcata secondo i valori indicati.
         * @param polizza			numero della polizza
         * @param frazionamento		frazionamento (annuale, semestrale, mensile, ...)
         * @param anniRendita		valore anni di rendita
         * @param anticipata		valore per il calcolo di opzione anticipata o meno
         * @return
         * @throws UniversoException
         */
        public abstract WSOpzioniBean getOpzCertezza(String polizza, String frazionamento, String anniRendita, String anticipata) throws UniversoException ;


        /**
         * Restituisce l'opzione di proroga per la polizza indicata, secondo i dati passati.
         * @param polizza			numero di polizza
         * @param anniProroga
         * @param mesiProroga
         * @param dataProroga
         * @param polizzaProroga
         * @return
         * @throws UniversoException
         */
        public abstract WSOpzioniBean getOpzProroga(String polizza, String anniProroga, String mesiProroga,
                String dataProroga, String polizzaProroga)
        throws UniversoException;

        /**
         * Restituisce l'opzione di cambio frazionamento, sulla polizza indicata.
         * @param polizza			numero della polizza
         * @param frazionamento		frazionamento (annuale, semestrale, mensile, ...)
         * @param anticipata		valore per il calcolo di opzione anticipata o meno
         * @return
         * @throws UniversoException
         */
        public abstract WSOpzioniBean getOpzCambioFraz(String polizza, String frazionamento, String anticipata) throws UniversoException ;

        /**
         * @param ambiente
         * @param compagnia
         * @param polizza
         * @param dataValutazione
         * @param importoRichiesto
         * @return
         * @throws UniversoException
         */
        //public abstract WSRiscattoParzialeBean getRiscattoParziale(String polizza, BigDecimal importoRichiesto) throws UniversoException;
        
        
        /**
         * Esegue il fill delle variabili d'istanza dell'oggetto indicato, tramite reflection.
         * @param <T>
         * @param clazz		bean da popolare per la risposta
         * @param xml		xml restituito in risposta da universo
         * @return
         * @throws UniversoException
         */        
        protected <T> T popolaBean(Class<T> clazz, String xml) throws UniversoException {
            T rv = null;

            if (xml == null)
                return rv;

            try {
                // effettuo la pulizia dell'xml codificando i caratteri speciali con l'escape xml
                xml = CodificaXML.replace(xml);

                Document document = DocumentHelper.parseText(xml);

                // Controllo eccezione
                UniversoException e = getException(document);

                if (e != null) {
                    throw e;

                } else {
                    rv = clazz.newInstance();

                    // elemento da controllare
                    Element _el = document.getRootElement().element("Risultati_CRM");

                    if (rv instanceof WSConversioneinRenditaBean) {
                        WSConversioneinRenditaBean bean = (WSConversioneinRenditaBean) rv;
                        bean.setRenditaIniziale(_el.element("RENDITAINIZIALE").getText());
                        bean.setValoreDiRiscattoTotaleLordo(_el.element("VALORERISCATTOLORDO").getText());

                    } else if (rv instanceof WSRiscattoPolizzeChiuseBean) {
                        WSRiscattoPolizzeChiuseBean bean = (WSRiscattoPolizzeChiuseBean) rv;

                        _el = document.getRootElement().element("RisultatiInterrogazione");

                        Element _el1 = _el.element("ValoreRiscatto");
                        Element _el2 = _el.element("SommaPremiPagati");

                        LoggingUtils.debug("<ValoreRiscatto> : " + _el1.getText());
                        LoggingUtils.debug("<SommaPremiPagati> : " + _el2.getText());

                        String _tmp1 = NumberUtils.formatGenericDouble(
                                _el1.getText(), 2,
                                Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI);

                        String _tmp2 = NumberUtils.formatGenericDouble(
                                _el1.getText(), 2,
                                Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI);

                        bean.setValoreDiRiscattoTotaleLordo(_tmp1);
                        bean.setSommaPremiPagati(_tmp2);

                    } else if (rv instanceof WSRiscattoBean) {
                        WSRiscattoBean bean = (WSRiscattoBean) rv;
                        if(_el.element("RENDITAINIZIALE")!=null){
                           bean.setRenditaIniziale(_el.element("RENDITAINIZIALE").getText());
                        }  else{
                           bean.setRenditaIniziale("");
                        }
                        if(_el.element("RENDITARIVALUTATA")!=null){
                           bean.setRenditaRivalutata(_el.element("RENDITARIVALUTATA").getText());
                        }  else{
                           bean.setRenditaRivalutata("");
                        }
                        if(_el.element("CAPITALE")!=null){
                           bean.setCapitaleCasoMorte(_el.element("CAPITALE").getText());
                        }  else{
                           bean.setCapitaleCasoMorte("");
                        }
                        if(_el.element("CAPITALEUNIT")!=null){
                           bean.setCapitaleCasoMorteUnit(_el.element("CAPITALEUNIT").getText());
                        }  else{
                           bean.setCapitaleCasoMorteUnit("");
                        }
                        if(_el.element("VALORERISCATTOLORDO")!=null){
                           bean.setValoreDiRiscattoTotaleLordo(_el.element("VALORERISCATTOLORDO").getText());
                        }  else{
                           bean.setValoreDiRiscattoTotaleLordo("");
                        }
                        if(_el.element("RISERVAMATEMATICA")!=null){
                           bean.setRiservaMatematica(_el.element("RISERVAMATEMATICA").getText());
                        }  else{
                           bean.setRiservaMatematica("");
                        }
                        if(_el.element("TOTALEPREMIRIVIPOTIZZATI")!=null){
                           bean.setTotalePremiRivalutatiIpotizzati(_el.element("TOTALEPREMIRIVIPOTIZZATI").getText());
                        }  else{
                           bean.setTotalePremiRivalutatiIpotizzati("");
                        }
                        if(_el.element("INTRITPAG")!=null){
                           bean.setInteressiRitardatoPagamento(_el.element("INTRITPAG").getText());
                        }  else{
                           bean.setInteressiRitardatoPagamento("");
                        }
                        if(_el.element("NUMAPP")!=null){
                           bean.setAppendice(_el.element("NUMAPP").getText());
                        }  else{
                           bean.setAppendice("");
                        }
                        if(_el.element("TASSOISVAP")!=null){
                           bean.setTassoIsvap(_el.element("TASSOISVAP").getText());
                        }  else{
                           bean.setTassoIsvap("");
                        }
                        if(_el.element("ECCEDENZA")!=null){
                           bean.setEccedenza(_el.element("ECCEDENZA").getText());
                        }  else{
                           bean.setEccedenza("");
                        }


                    } else if (rv instanceof WSRiduzioneBean) {
                        WSRiduzioneBean bean = (WSRiduzioneBean) rv;
                        /*
                        Element prest = _el.element("PRESTAZIONICV");
                        bean.setPrestazioneVita(getElementValue(prest, "TOTALE"));
                        prest = _el.element("PRESTAZIONICM");
                        bean.setCasoMorteRivalutato(getElementValue(prest, "TOTALE"));
                        */
                        bean.setPrestazioneVita(_el.element("PRESTAZIONICV_TOTALE").getText());
                        bean.setCasoMorteRivalutato(_el.element("PRESTAZIONICM_TOTALE").getText());


                    } else if (rv instanceof WSOpzioniBean) {
                        WSOpzioniBean bean = (WSOpzioniBean) rv;

                        if (_el.element("DATASCADENZAPRIMARATARENDITA") != null) {
                            bean.setDataScadenzaPrimaRataRendita(_el.element("DATASCADENZAPRIMARATARENDITA").getText());
                        } else {
                            bean.setDataScadenzaPrimaRataRendita("");
                        }
                        if (_el.element("DATAFINEDIFFREVERSIBILITAMORTEASSIC") != null) {
                            bean.setDataFineDiffReversibilitaMorteAssic(_el.element("DATAFINEDIFFREVERSIBILITAMORTEASSIC").getText());
                        } else {
                            bean.setDataFineDiffReversibilitaMorteAssic("");
                        }
                        if (_el.element("DURATADIFFERIMENTO") != null) {
                            bean.setDifferimento(_el.element("DURATADIFFERIMENTO").getText());
                        } else {
                            bean.setDifferimento("");
                        }
                        if (_el.element("IMPORTORATARENDITAFRAZIONATA") != null) {
                            bean.setImportoRataRenditaFrazionata(_el.element("IMPORTORATARENDITAFRAZIONATA").getText());
                        } else {
                            bean.setImportoRataRenditaFrazionata("");
                        }
                        if (_el.element("RATARENDITAANNUAVITALIZIA75ANNO") != null) {
                            bean.setRataRenditaAnnuaVitaliziaAl75Anno(_el.element("RATARENDITAANNUAVITALIZIA75ANNO").getText());
                        } else {
                            bean.setRataRenditaAnnuaVitaliziaAl75Anno("");
                        }
                        if (_el.element("RATARENDITAANNUAVITALIZIA80ANNO") != null) {
                            bean.setRataRenditaAnnuaVitaliziaAl80Anno(_el.element("RATARENDITAANNUAVITALIZIA80ANNO").getText());
                        } else {
                            bean.setRataRenditaAnnuaVitaliziaAl80Anno("");
                        }
                        if (_el.element("RATARENDITAANNUAVITALIZIA85ANNO") != null) {
                            bean.setRataRenditaAnnuaVitaliziaAl85Anno(_el.element("RATARENDITAANNUAVITALIZIA85ANNO").getText());
                        } else {
                            bean.setRataRenditaAnnuaVitaliziaAl85Anno("");
                        }
                        if (_el.element("RATARENDITAREVERSIBILITAMORTEASSIC") != null) {
                            bean.setRataRenditaReversibilitaMorteAssic(_el.element("RATARENDITAREVERSIBILITAMORTEASSIC").getText());
                        } else {
                            bean.setRataRenditaReversibilitaMorteAssic("");
                        }
                        if (_el.element("RENDITAANNUAVITALIZIA75ANNO") != null) {
                            bean.setRenditaAnnuaVitaliziaAl75Anno(_el.element("RENDITAANNUAVITALIZIA75ANNO").getText());
                        } else {
                            bean.setRenditaAnnuaVitaliziaAl75Anno("");
                        }
                        if (_el.element("RENDITAANNUAVITALIZIA80ANNO") != null) {
                            bean.setRenditaAnnuaVitaliziaAl80Anno(_el.element("RENDITAANNUAVITALIZIA80ANNO").getText());
                        } else {
                            bean.setRenditaAnnuaVitaliziaAl80Anno("");
                        }
                        if (_el.element("RENDITAANNUAVITALIZIA85ANNO") != null) {
                            bean.setRenditaAnnuaVitaliziaAl85Anno(_el.element("RENDITAANNUAVITALIZIA85ANNO").getText());
                        } else {
                            bean.setRenditaAnnuaVitaliziaAl85Anno("");
                        }
                        if (_el.element("DATARATARENDITAREVERSIBILITAMORTEASSIC") != null) {
                            bean.setDataRataRenditaReversibilitaMorteAssic(_el.element("DATARATARENDITAREVERSIBILITAMORTEASSIC").getText());
                        } else {
                            bean.setDataRataRenditaReversibilitaMorteAssic("");
                        }
                        if (_el.element("RENDITAREVERSIBILITAMORTEASSIC") != null) {
                            bean.setRenditaReversibilitaMorteAssic(_el.element("RENDITAREVERSIBILITAMORTEASSIC").getText());
                        } else {
                            bean.setRenditaReversibilitaMorteAssic("");
                        }
                        if (_el.element("DATARICORRENZARENDITA75ANNO") != null) {
                            bean.setRicorrenzaRenditaAl75Anno(_el.element("DATARICORRENZARENDITA75ANNO").getText());
                        } else {
                            bean.setRicorrenzaRenditaAl75Anno("");
                        }
                        if (_el.element("DATARICORRENZARENDITA80ANNO") != null) {
                            bean.setRicorrenzaRenditaAl80Anno(_el.element("DATARICORRENZARENDITA80ANNO").getText());
                        } else {
                            bean.setRicorrenzaRenditaAl80Anno("");
                        }
                        if (_el.element("DATARICORRENZARENDITA85ANNO") != null) {
                            bean.setRicorrenzaRenditaAl85Anno(_el.element("DATARICORRENZARENDITA85ANNO").getText());
                        } else {
                            bean.setRicorrenzaRenditaAl85Anno("");
                        }
                        if (_el.element("TOTALERENDITA") != null) {
                            bean.setTotaleRenditaDiOpzioneComplessiva(_el.element("TOTALERENDITA").getText());
                        } else {
                            bean.setTotaleRenditaDiOpzioneComplessiva("");
                        }
                        if (_el.element("DURATADIFFERIMENTO") != null) {
                            bean.setDifferimento(_el.element("DURATADIFFERIMENTO").getText());
                        } else {
                            bean.setDifferimento("");
                        }
                        if (_el.element("DURATACERTA") != null) {
                            bean.setDurataCerta(_el.element("DURATACERTA").getText());
                        } else {
                            bean.setDurataCerta("");
                        }


                        //trascodificaInput(bean);


                    } else if (rv instanceof WSPrestazioniAssicurateBean) {
                        WSPrestazioniAssicurateBean bean = (WSPrestazioniAssicurateBean) rv;

                   /*     Element prest = _el.element("PRESTAZIONICV");
                        bean.setTotalePrestazioniCV(getElementValue(prest, "TOTALE"));
                        bean.setBonusCV(getElementValue(prest, "BONUS"));
                        prest = _el.element("PRESTAZIONICM");
                        bean.setTotalePrestazioniCM(getElementValue(prest, "TOTALE"));
                        bean.setBonusCM(getElementValue(prest, "BONUS"));*/

                        bean.setTotalePrestazioniCV(_el.element("PRESTAZIONICV_TOTALE").getText());
                        bean.setBonusCV(_el.element("PRESTAZIONICV_BONUS").getText());
                        bean.setTotalePrestazioniCM(_el.element("PRESTAZIONICM_TOTALE").getText());
                        bean.setBonusCM(_el.element("PRESTAZIONICM_BONUS").getText());

                        bean.setRendita75Anno(_el.element("RENDITA75ANNO").getText());
                        bean.setRendita80Anno(_el.element("RENDITA80ANNO").getText());
                        bean.setRendita85Anno(_el.element("RENDITA85ANNO").getText());
                        bean.setCapitaleMorteInfortunio(_el.element("CAPCOMPLINFORTUNIOPRIMOASS").getText());
                        bean.setCapitaleMorteInfortunioStradale(_el.element("CAPCOMPLINCIDENTEPRIMOASS").getText());
                        bean.setCapitaleMalattiaGrave(_el.element("CAPCOMPLMALATTIAPRIMOASS").getText());
                        bean.setCapitaleSecondoDecesso(_el.element("CAPCOMPLDECESSOSECONDOASS").getText());
                        bean.setMassimaleInfortunio(_el.element("MASSASSINFORTUNIOPRIMOASS").getText());
                        bean.setMassimaleMalattia(_el.element("MASSASSMALATTIAPRIMOASS").getText());
                    }
                    else if(rv instanceof WSRiscattoParzialeTendenzaBean){
                    	WSRiscattoParzialeTendenzaBean bean = (WSRiscattoParzialeTendenzaBean) rv;
                    	
//                    	DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
//            			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
                    	
            			/** Adeguamenti Sonar e PT ********************************************************/
            		    DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
//            		    docBuilderFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
//            		    docBuilderFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
            		    DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            		/**********************************************************************************/
            			org.w3c.dom.Document doc = docBuilder.parse(new InputSource(new ByteArrayInputStream(xml.getBytes("utf-8"))));
            			
            			NodeList nodeImportoRichiesto = doc.getElementsByTagName("ImportoRichiesto");    		
                		Map<String, Object> mapImportoRichiesto = getTag(nodeImportoRichiesto);
                		if(mapImportoRichiesto != null){
                			bean.setImportoRichiesto((String)mapImportoRichiesto.get("value"));    			
                		}
                		NodeList nodeValoreRiscattoLordo = doc.getElementsByTagName("ValoreRiscattoLordo");    		
                		Map<String, Object> mapValoreRiscattoLordo = getTag(nodeValoreRiscattoLordo);
                		if(mapValoreRiscattoLordo != null){
                			bean.setValoreRiscattoLordo((String)mapValoreRiscattoLordo.get("value"));    			
                		}
                		NodeList nodeImposteRiscatto = doc.getElementsByTagName("ImposteRiscatto");    		
                		Map<String, Object> mapImposteRiscatto = getTag(nodeImposteRiscatto);
                		if(mapImposteRiscatto != null){
                			bean.setImposteRiscatto((String)mapImposteRiscatto.get("value"));    			
                		}
                		NodeList nodeCommissioniRiscatto = doc.getElementsByTagName("CommissioniRiscatto");    		
                		Map<String, Object> mapCommissioniRiscatto = getTag(nodeCommissioniRiscatto);
                		if(mapCommissioniRiscatto != null){
                			bean.setCommissioniRiscatto((String)mapCommissioniRiscatto.get("value"));    			
                		}
                		NodeList nodeCapitaleRiscatto = doc.getElementsByTagName("CapitaleRiscatto");    		
                		Map<String, Object> mapCapitaleRiscatto = getTag(nodeCapitaleRiscatto);
                		if(mapCapitaleRiscatto != null){
                			bean.setCapitaleRiscatto((String)mapCapitaleRiscatto.get("value"));    			
                		}
                		NodeList nodeValoreRiscattoNetto = doc.getElementsByTagName("ValoreRiscattoNetto");    		
                		Map<String, Object> mapValoreRiscattoNetto = getTag(nodeValoreRiscattoNetto);
                		if(mapValoreRiscattoNetto != null){
                			bean.setValoreRiscattoNetto((String)mapValoreRiscattoNetto.get("value"));    			
                		}
                    	                    	                  	
                    }else if(rv instanceof WSRiscattoParzialePuntualeBean){
                    	WSRiscattoParzialePuntualeBean bean = (WSRiscattoParzialePuntualeBean) rv;
                    	
//                    	DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
//            			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
                    	
            			/** Adeguamenti Sonar e PT ********************************************************/
            		    DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
//            		    docBuilderFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
//            		    docBuilderFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
            		    DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            		/**********************************************************************************/
            		    
            			org.w3c.dom.Document doc = docBuilder.parse(new InputSource(new ByteArrayInputStream(xml.getBytes("utf-8"))));

            			doc.getDocumentElement().normalize(); 
            			
            			NodeList nodeCAPITALE = doc.getElementsByTagName("CAPITALE");    		
                		Map<String, Object> mapCAPITALE = getTag(nodeCAPITALE);
                		if(mapCAPITALE != null){
                			bean.setCapitale((String)mapCAPITALE.get("value"));    			
                		} 
                		NodeList nodeCAPITALEUNIT = doc.getElementsByTagName("CAPITALEUNIT");
                		Map<String, Object> mapCAPITALEUNIT = getTag(nodeCAPITALEUNIT);
                		if(mapCAPITALEUNIT != null){
                			bean.setCapitaleUnit((String)mapCAPITALEUNIT.get("value"));    			
                		}
                		NodeList nodeCONTROVALOREQUOTE = doc.getElementsByTagName("CONTROVALOREQUOTE");
                		Map<String, Object> mapCONTROVALOREQUOTE = getTag(nodeCONTROVALOREQUOTE);
                		if(mapCONTROVALOREQUOTE != null){
                			bean.setControvaloreQuote((String)mapCONTROVALOREQUOTE.get("value"));    			
                		} 
                		NodeList nodeDRIFCONTROVALOREQUOTE = doc.getElementsByTagName("DRIFCONTROVALOREQUOTE");
                		Map<String, Object> mapDRIFCONTROVALOREQUOTE = getTag(nodeDRIFCONTROVALOREQUOTE);
                		if(mapDRIFCONTROVALOREQUOTE != null){
                			bean.setDrifControvaloreQuote((String)mapDRIFCONTROVALOREQUOTE.get("value"));    			
                		}
                		NodeList nodeNUMPOLIZZA = doc.getElementsByTagName("NUMPOLIZZA");
                		Map<String, Object> mapNUMPOLIZZA = getTag(nodeNUMPOLIZZA);
                		if(mapNUMPOLIZZA != null){
                			bean.setNumeroPolizza((String)mapNUMPOLIZZA.get("value"));    			
                		}
                		NodeList nodePAINCASSATI = doc.getElementsByTagName("PAINCASSATI");
                		Map<String, Object> mapPAINCASSATI = getTag(nodePAINCASSATI);
                		if(mapPAINCASSATI != null){
                			bean.setPaIncassati((String)mapPAINCASSATI.get("value"));    			
                		}
                		NodeList nodePUINCASSATI = doc.getElementsByTagName("PUINCASSATI");
                		Map<String, Object> mapPUINCASSATI = getTag(nodePUINCASSATI);
                		if(mapPUINCASSATI != null){
                			bean.setPuIncassati((String)mapPUINCASSATI.get("value"));    			
                		}
                		NodeList nodeRISCATTOANTICIPATO = doc.getElementsByTagName("RISCATTOANTICIPATO");
                		Map<String, Object> mapRISCATTOANTICIPATO = getTag(nodeRISCATTOANTICIPATO);
                		if(mapRISCATTOANTICIPATO != null){
                			bean.setRiscattoAnticipato((String)mapRISCATTOANTICIPATO.get("value"));    			
                		}
                		NodeList nodeTIPORISCATTO = doc.getElementsByTagName("TIPORISCATTO");
                		Map<String, Object> mapTIPORISCATTO = getTag(nodeTIPORISCATTO);
                		if(mapTIPORISCATTO != null){
                			bean.setTipoRiscatto((String)mapTIPORISCATTO.get("value"));    			
                		}
                		NodeList nodeVALORERISCATTOLORDO = doc.getElementsByTagName("VALORERISCATTOLORDO");
                		Map<String, Object> mapVALORERISCATTOLORDO = getTag(nodeVALORERISCATTOLORDO);
                		if(mapVALORERISCATTOLORDO != null){
                			bean.setValoreRiscattoLordo((String)mapVALORERISCATTOLORDO.get("value"));    			
                		}
                		NodeList nodeVALORERISCATTONETTO = doc.getElementsByTagName("VALORERISCATTONETTO");
                		Map<String, Object> mapVALORERISCATTONETTO = getTag(nodeVALORERISCATTONETTO);
                		if(mapVALORERISCATTONETTO != null){
                			bean.setValoreRiscattoNetto((String)mapVALORERISCATTONETTO.get("value"));    			
                		}                            
                		NodeList nodeIMPOSTE = doc.getElementsByTagName("IMPOSTE");    		
                		Map<String, Object> mapIMPOSTE = getTag(nodeIMPOSTE);
                		if(mapIMPOSTE != null){
                			bean.setImposte((String)mapIMPOSTE.get("value"));    			
                		}
                		NodeList nodeCOMMISSIONI = doc.getElementsByTagName("COMMISSIONI");    		
                		Map<String, Object> mapCOMMISSIONI = getTag(nodeCOMMISSIONI);
                		if(mapCOMMISSIONI != null){
                			bean.setCommissioni((String)mapCOMMISSIONI.get("value"));    			
                		}
                		
                		ArrayList<FondoBean> list = new ArrayList<FondoBean>();
                		FondoBean beanFondo = null;
                		NodeList listFONDO = doc.getElementsByTagName("FONDO");
            			for(int s=0; s<listFONDO.getLength() ; s++){
            				org.w3c.dom.Node dati = listFONDO.item(s);
            				if(dati.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE){
            					org.w3c.dom.Element datiFondo = (org.w3c.dom.Element)dati;
            					beanFondo = new FondoBean();
            					
            					NodeList nodeFONDOUS = datiFondo.getElementsByTagName("FONDOUS");
                				Map<String, Object> mapFONDOUS = getTag(nodeFONDOUS);    				
                	    		if(mapFONDOUS != null){
                	    			beanFondo.setFondoUs((String)mapFONDOUS.get("value"));    	    			
                	    		}                	    		
                	    		NodeList nodeFONDOCOMPAGNIA = datiFondo.getElementsByTagName("FONDOCOMPAGNIA");
                				Map<String, Object> mapFONDOCOMPAGNIA = getTag(nodeFONDOCOMPAGNIA);    				
                	    		if(mapFONDOCOMPAGNIA != null){
                	    			beanFondo.setFondoCompagnia((String)mapFONDOUS.get("value"));    	    			
                	    		}
                	    		NodeList nodeQUOTE = datiFondo.getElementsByTagName("QUOTE");
                				Map<String, Object> mapQUOTE = getTag(nodeQUOTE);    				
                	    		if(mapQUOTE != null){
                	    			beanFondo.setQuote((String)mapQUOTE.get("value"));    	    			
                	    		}
                	    		NodeList nodeCTVQUOTE = datiFondo.getElementsByTagName("CTVQUOTE");
                				Map<String, Object> mapCTVQUOTE = getTag(nodeCTVQUOTE);    				
                	    		if(mapCTVQUOTE != null){
                	    			beanFondo.setCtvQuote((String)mapCTVQUOTE.get("value"));    	    			
                	    		}
                	    		NodeList nodeVALORENAV = datiFondo.getElementsByTagName("VALORENAV");
                				Map<String, Object> mapVALORENAV = getTag(nodeVALORENAV);    				
                	    		if(mapVALORENAV != null){
                	    			beanFondo.setValoreNav((String)mapVALORENAV.get("value"));    	    			
                	    		}
                	    		NodeList nodeDATANAV = datiFondo.getElementsByTagName("DATANAV");
                				Map<String, Object> mapDATANAV = getTag(nodeDATANAV);    				
                	    		if(mapDATANAV != null){
                	    			beanFondo.setDataNav((String)mapDATANAV.get("value"));    	    			
                	    		}
                	    		NodeList nodeRISCATTOLORDO = datiFondo.getElementsByTagName("RISCATTOLORDO");
                				Map<String, Object> mapRISCATTOLORDO = getTag(nodeRISCATTOLORDO);    				
                	    		if(mapRISCATTOLORDO != null){
                	    			beanFondo.setRiscattoLordo((String)mapRISCATTOLORDO.get("value"));    	    			
                	    		}                	    		
                	    		list.add(beanFondo);					
            				}				
            			}
                    	bean.setListFondi(list);                    	
                    }
                }

            } catch (DocumentException e) {
                LoggingUtils.error(e, e);
                throw new UniversoException("Errore nel parsing del xml proveniente da Universo. l'xml è: " + xml, e);

            } catch (InstantiationException e) {
                LoggingUtils.error(e, e);
                throw new UniversoException(e.getMessage());

            } catch (IllegalAccessException e) {
                LoggingUtils.error(e, e);
                throw new UniversoException(e.getMessage());
            }catch (Exception e){
            	LoggingUtils.error(e, e);
                throw new UniversoException(e.getMessage());
            }

            return rv;
        }

        /**
         * Traduzione in human readable language dei vari valori di frazionamento utilizzati.
         * @param bean
         * @return
         */
        public WSOpzioniBean trascodificaInput(WSOpzioniBean bean) {
            LoggingUtils.debug(" bean trascodificainput: " + bean);
            LoggingUtils.debug(" bean frazionamento: " + bean.getFrazionamento());

            if ("A".equalsIgnoreCase(bean.getFrazionamento().trim())) {
                // FRAZIONAMENTO ANNUALE
                bean.setFrazionamentoSingolare("annuale");
                bean.setFrazionamentoPlurale("annuali");
            }

            if ("S".equalsIgnoreCase(bean.getFrazionamento().trim())) {
                // FRAZIONAMENTO SEMESTRALE
                bean.setFrazionamentoSingolare("semestrale");
                bean.setFrazionamentoPlurale("semestrali");
            }

            if ("Q".equalsIgnoreCase(bean.getFrazionamento().trim())) {
                // FRAZIONAMENTO QUADRIMESTRALE
                bean.setFrazionamentoSingolare("quadrimestrale");
                bean.setFrazionamentoPlurale("quadrimestrali");
            }

            if ("T".equalsIgnoreCase(bean.getFrazionamento().trim())) {
                // FRAZIONAMENTO TRIMESTRALE
                bean.setFrazionamentoSingolare("trimestrale");
                bean.setFrazionamentoPlurale("trimestrali");
            }

            if ("B".equalsIgnoreCase(bean.getFrazionamento().trim())) {
                // FRAZIONAMENTO BIMESTRALE
                bean.setFrazionamentoSingolare("bimestrale");
                bean.setFrazionamentoPlurale("bimestrali");
            }

            if ("M".equalsIgnoreCase(bean.getFrazionamento().trim())) {
                // FRAZIONAMENTO MENSILE
                bean.setFrazionamentoSingolare("mensile");
                bean.setFrazionamentoPlurale("mensili");
            }

            /*
             if ("M".equalsIgnoreCase(bean.getSesso().trim())) {
                bean.setSessoLettera("maschile");
              }else{
                bean.setSessoLettera("femminile");
             }*/


            return bean;
        }


        /**
         * Ricerca dell'eccezione all'interno del documento XML che universo restituisce in risposta.
         *
         * @param documento
         *
         * @return
         */
        public UniversoException getException(Document documento) {
            String errore = null;

            // Elementi dell'albero XML
            Element _root = documento.getRootElement();

            // Elemento NORMALE di errore
            Element _gestErrElement = _root.element("Gestione_Errori");

            // Controllo elemento
            if( _gestErrElement == null)
                // Per le polizze chiuse xml cambia
                _gestErrElement = _root.element("Descrizione_Errore");

            // Contenuto campo
            Element _codiceErr = _gestErrElement.element("Codice");

            if (_codiceErr != null) {
                errore = _codiceErr.getText();
                if (errore != null && !"".equals(errore)) {
                    String messaggio = documento.getRootElement().element("Gestione_Errori").element("Messaggio").getText();
                    return new UniversoException(messaggio);
                }
            } else {
                //GESTIONE RISCATTO ANTICIPATO
                _codiceErr = _gestErrElement.element("Codice_1");
                if (_codiceErr != null)
                    errore = _codiceErr.getText();
                if (errore != null && !"".equals(errore)) {
                    String messaggio = documento.getRootElement().element("Descrizione_Errore").element("Messaggio_1").getText();
                    return new UniversoException(messaggio);
                }
            }

            return null;
        }

        /**
         * @param padre
         * @param name
         * @return
         */
        protected String getElementValue(Element padre, String name) {
            String value = null;
            Element ele = padre.element(name);

            if (ele != null) {
                value = ele.getText();
                if (value != null && !"".equals(value.trim())) {
                    value = value.trim();
                    value = StringUtils.replaceString(value, "/n", "");
                    value = StringUtils.replaceString(value, "/r", "");
                }
            }
            return value;
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
