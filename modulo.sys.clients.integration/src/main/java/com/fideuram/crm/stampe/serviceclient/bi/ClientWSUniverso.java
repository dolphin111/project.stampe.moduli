package com.fideuram.crm.stampe.serviceclient.bi;

import com.fideuram.config.CrmProperties;
import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.serviceclient.universo.ClientUniverso;
import com.fideuram.exception.ws.UniversoException;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.NumberUtils;
import com.thoughtworks.xstream.core.util.Base64Encoder;
import localhost.wssoapauth64.srvauth.AccountInfoHeader;
import localhost.wssoapauth64.srvauth.SrvAuth;
import localhost.wssoapauth64.srvauth.SrvAuthSoap;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import java.io.IOException;
import java.net.URL;
import java.util.GregorianCalendar;
import java.util.List;


/**
 * @author Giuseppe Luciani
 * @author Giorgio Desideri
 *
 */
@Deprecated
public class ClientWSUniverso extends ClientUniverso{
	
	/**
	 * Universo WS-Service
	 */
	private SrvAuthSoap serviceWS = null;
	
	/**
	 * Autenticate Header
	 */
	private AccountInfoHeader authHeader = null;
	
	
	/**
	 * Costruttore privato
	 */
	public ClientWSUniverso() {
		prepareAuthHeader();
		prepareServiceWS();
	}
	
	/**
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	private void prepareServiceWS() {
		SrvAuth ws;

		try {
			URL wsdlLocation = new URL(CrmProperties.getProperty(Costanti.BI_SERVICES_URL));


			ws = new SrvAuth(
					wsdlLocation, 
					new QName("http://localhost/WSSOAPAUTH64/SrvAuth", "SrvAuth"));
						
			// Set auth (header)body
			serviceWS = ws.getSrvAuthSoap();
			
			Binding binding = ((BindingProvider) serviceWS).getBinding();
			List<Handler> handlers = binding.getHandlerChain();

			handlers.add(new UniversoSOAPMessageHandler(authHeader));
			binding.setHandlerChain(handlers);
			
		} catch (IOException e) {
			LoggingUtils.error(e, e);
		}
	}
	
	
	/**
	 * Restituisce l'header di autenticazione.
	 *  
	 * @return
	 */
	private void prepareAuthHeader() {
		authHeader = new AccountInfoHeader();
		Base64Encoder encoder = new Base64Encoder();

		authHeader.setDomain(encoder.encode("SPVITA".getBytes()));
		authHeader.setUserName(encoder.encode("Srvacc crm".getBytes()));
		authHeader.setPassword(encoder.encode("password".getBytes()));
		authHeader.setAmbiente(encoder.encode("FIDE_PROD".getBytes()));           //BUONO
		//authHeader.setAmbiente(encoder.encode("FIDECOLLTG".getBytes()));
		//authHeader.setAmbiente(encoder.encode("FIDECOLLUS".getBytes()));        //DB COLLAUDO
	}
	
	/**
	 * Restituisce le prestazioni assicurate della polizza, riferiti alla data indicata.
	 * 
	 * TUTTI I CASI TRANNE QUELLO DI POLIZZA DI ECCEDENZA.
	 * 
	 * @param numeroPolizza			numero di polizza
	 * @param dataValutazione		data di riferimento
	 * 
	 * @return
	 * 
	 * @throws UniversoException
	 */
	public WSPrestazioniAssicurateBean getPrestazioniAssicurate(String numeroPolizza, String dataValutazione) throws UniversoException {
		WSPrestazioniAssicurateBean bean = null;
		String xml = null;
		
        try {        	
			xml = serviceWS.prestazioniAssicurate(
					authHeader.getAmbiente(), 
					"S", Long.parseLong(numeroPolizza.trim()), 
					0, dataValutazione, 0);

			bean = popolaBean(WSPrestazioniAssicurateBean.class, xml);

		} catch (Exception e) {
			LoggingUtils.error(e, e);
			throw new UniversoException(e.getMessage());
		}

		return bean;
	}

	/**
	 * Restituisce l'ipotesi di riscatto delle polizze aperte.
	 * 
	 * @param polizza					numero di polizza
	 * @param dataValutazione			data di valutazione indicata
	 * @param indicatoreTipoRisc		indicatore della tipologia di riscatto
	 * 
	 * @return
	 * 
	 * @throws UniversoException 
	 */
	public WSRiscattoBean getRiscattoPolizzeAperte(String polizza, String dataValutazione, int indicatoreTipoRisc) throws UniversoException {
		WSRiscattoBean bean = null;
		String xml = null;

		try {
			LoggingUtils.debug("Input param, dataValutazione: " + dataValutazione);
			LoggingUtils.debug("Input param, indicatore Tipo Riscatto: " + indicatoreTipoRisc);

			xml = serviceWS.ipotesiRiscattoPA(
					authHeader.getAmbiente(), "S", 
					Long.parseLong(polizza.trim()), 0, 
					dataValutazione, 0, 
					indicatoreTipoRisc);

			bean = popolaBean(WSRiscattoBean.class, xml);

			LoggingUtils.debug(" Stima Riscatto PA - valore riscatto lordo : " + bean.getValoreDiRiscattoTotaleLordo());
			LoggingUtils.debug(" Stima Riserva Matematica : " + bean.getRiservaMatematica());

		} catch (Exception e) {
			LoggingUtils.error(e, e);
			throw new UniversoException(e.getMessage());
		}

		return bean;
	}

	/**
	 * Restituisce l'ipotesi di riscatto per le polizze chiuse.
	 *  
	 * @param polizza			numero di polizza
	 * @param dataValutazione	data di valutazione
	 * 
	 * @return
	 * 
	 * @throws UniversoException
	 */
	public WSRiscattoPolizzeChiuseBean getRiscattoPolizzeChiuse(String polizza, String dataValutazione) throws UniversoException {
		WSRiscattoPolizzeChiuseBean bean = null;
		String xml = null;

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTimeInMillis(System.currentTimeMillis());

		try {
		    XMLGregorianCalendar xgcal = 
		    	DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		      
		    LoggingUtils.info(" calend : " + xgcal);
		    
			xml = serviceWS.ipotesiRiscatto(
					authHeader.getAmbiente(), "S", 
					Long.parseLong(polizza.trim()), xgcal);

			bean = popolaBean(WSRiscattoPolizzeChiuseBean.class, xml);

		} catch (Exception e) {
			LoggingUtils.error(e, e);
			throw new UniversoException(e.getMessage());
		}
		LoggingUtils.info(" Stima Riscatto PC - valore riscatto lordo : " + bean.getValoreDiRiscattoTotaleLordo());

		return bean;
	}

	/**
	 * Restituisce la conversione in idennità di rendita per la polizza passata, alla data indicata.
	 * 
	 * @param polizza			numero di polizza
	 * @param dataValutazione	data di riferimento
	 * 
	 * @return
	 * 
	 * @throws UniversoException 
	 */
	public WSConversioneinRenditaBean getConversioneInRendita(String polizza, String dataValutazione) throws UniversoException {
		WSConversioneinRenditaBean bean = null;
		String xml = null;

		try {
			xml = serviceWS.getConversioneInRendita(
					authHeader.getAmbiente(), "S",
					Long.parseLong(polizza.trim()), 0, dataValutazione, 0);

			bean = popolaBean(WSConversioneinRenditaBean.class, xml);

		} catch (Exception e) {
			LoggingUtils.error(e, e);
			throw new UniversoException(e.getMessage());
		}

		LoggingUtils.info(" Stima Conversione Rendita - valore riscatto lordo : " + bean.getValoreDiRiscattoTotaleLordo());
		LoggingUtils.info(" Stima Conversione Rendita - RenditaIniziale : " + bean.getRenditaIniziale());

		return bean;
	}

	/**
	 * Restituisce il calcolo di riduzione per la polizza indicata, alla data indicata.
	 * @param polizza
	 * @param dataValutazione
	 * @return
	 * @throws Exception 
	 */
	public WSRiduzioneBean getRiduzione(String polizza, String dataValutazione) throws UniversoException {
		WSRiduzioneBean bean = null;
		String xml = null;

		try {
			xml = serviceWS.ipotesiRiduzione(
					authHeader.getAmbiente(), "S", 
					Long.parseLong(polizza.trim()), 0, 
					dataValutazione, 0);

			bean = popolaBean(WSRiduzioneBean.class, xml);
			
		} catch (Exception e) {
			LoggingUtils.error(e, e);
			throw new UniversoException(e.getMessage());
		}
		
		LoggingUtils.info(" Stima Riduzione - casoMorteRivalutato : " + bean.getCasoMorteRivalutato());
		LoggingUtils.info(" Stima Riduzione - PrestazioneVita : " + bean.getPrestazioneVita());
		
		return bean;
	}

	/**
	 * Restituisce l'opzione di reversibilità della polizza inidcata secondo i valori indicati.
	 * 
	 * @param polizza			numero della polizza
	 * @param frazionamento		frazionamento (annuale, semestrale, mensile, ...)
	 * @param reversibilita		indice di reversibilità
	 * @param dataNascita		data di nascita del titolare della polizza
	 * @param sesso				sesso del titolare della polizza
	 * @param anticipata		valore per il calcolo di opzione anticipata o meno
	 * 
	 * @return
	 * 
	 * @throws UniversoException
	 */
	public WSOpzioniBean getOpzReversibilita(String polizza, String frazionamento, String reversibilita, 
			String dataNascita, String sesso, String anticipata) 
	throws UniversoException {
		WSOpzioniBean bean = new WSOpzioniBean();
		String xml = null;

		int reversib = Integer.parseInt(reversibilita);

		try {
			LoggingUtils.debug("Input params, frazionamento : " + frazionamento);
			LoggingUtils.debug("Input params, reversibilita : " + reversibilita);
			LoggingUtils.debug("Input params, dataNascita : " + dataNascita);
			LoggingUtils.debug("Input params, sesso : " + sesso);
			LoggingUtils.debug("Input params, anticipata : " + anticipata);

			xml = serviceWS.ipotesiOpzioneRenditaReversibile(
						authHeader.getAmbiente(), "S",
						Long.parseLong(polizza.trim()), 0, 
						frazionamento, reversib,
						dataNascita, sesso, 
						anticipata, "N");
			
			bean = popolaBean(WSOpzioniBean.class, xml);
			bean.setFrazionamento(frazionamento);
			bean.setSesso(sesso);
			
			trascodificaInput(bean);
			
			bean.setAnticipata(anticipata);
			bean.setReversibilita(reversibilita);
			bean.setDataNascita(dataNascita);

			LoggingUtils.info(" Opzione Reversibilita' - frazionamento : " + bean.getFrazionamento());
			LoggingUtils.info(" Opzione Reversibilita' - importoOpzione : " + bean.getRenditaReversibilitaMorteAssic());

		} catch (Exception e) {
			LoggingUtils.error(e, e);
			throw new UniversoException(e.getMessage());
		}

		return bean;
	}

	/**
	 * Restituisce l'opzione di certezza della polizza inidcata secondo i valori indicati.
	 * 
	 * @param polizza			numero della polizza
	 * @param frazionamento		frazionamento (annuale, semestrale, mensile, ...)
	 * @param anniRendita		valore anni di rendita
	 * @param anticipata		valore per il calcolo di opzione anticipata o meno
	 * 
	 * @return
	 * 
	 * @throws UniversoException
	 */
	public WSOpzioniBean getOpzCertezza(String polizza, String frazionamento, String anniRendita, String anticipata) throws UniversoException {
		WSOpzioniBean bean = new WSOpzioniBean();

		int anniRend = Integer.parseInt(anniRendita);

		String xml = null;
		try {
			LoggingUtils.debug("Input param, frazionamento: " + frazionamento);
			LoggingUtils.debug("Input param, anticipata: " + anticipata);
			LoggingUtils.debug("Input param, anni rendita: " +anniRendita);
	
			xml = serviceWS.ipotesiOpzioneRenditaCerta(
						authHeader.getAmbiente(), "S",
						Long.parseLong(polizza.trim()), 0, 
						frazionamento, anniRend, 
						anticipata, "N");
			
			bean = popolaBean(WSOpzioniBean.class, xml);
			bean.setFrazionamento(frazionamento);
			
			trascodificaInput(bean);
			
			bean.setAnticipata(anticipata);
			bean.setAnniRendita(anniRendita);

		} catch (Exception e) {
			LoggingUtils.error(e, e);
			throw new UniversoException(e.getMessage());
		}
		LoggingUtils.info(" Opzione Certezza - frazionamento : " + bean.getFrazionamento());
		LoggingUtils.info(" Opzione Certezza - importoOpzione : " + bean.getTotaleRenditaDiOpzioneComplessiva());
		
		return bean;
	}

	/**
	 * Restituisce l'opzione di proroga per la polizza indicata, secondo i dati passati.
	 * 
	 * @param polizza			numero di polizza
	 * @param anniProroga
	 * @param mesiProroga
	 * @param dataProroga
	 * @param polizzaProroga
	 * 
	 * @return
	 * 
	 * @throws UniversoException
	 */
	public WSOpzioniBean getOpzProroga(String polizza, String anniProroga, String mesiProroga,
			String dataProroga, String polizzaProroga) 
	throws UniversoException {

		WSOpzioniBean bean = new WSOpzioniBean();
		String xml = null;

		LoggingUtils.debug("Input params proroga - anniproroga : " + anniProroga);
		LoggingUtils.debug("Input params proroga - mesiproroga : " + mesiProroga);
		LoggingUtils.debug("Input params proroga - dataProroga : " + dataProroga);
		LoggingUtils.debug("Input params proroga - polizzaProroga : " + polizzaProroga);

		int anniPro = 0;
		int mesiPro = 0;
		int polizzaPro = 0;

		if(anniProroga != null)
			anniPro = Integer.parseInt(anniProroga);

		if(mesiProroga != null)
			mesiPro = Integer.parseInt(mesiProroga);

		if(polizzaProroga != null)
			polizzaPro = Integer.parseInt(polizzaProroga);

		try {
			xml = serviceWS.ipotesiOpzioneRenditaProrogata(
						authHeader.getAmbiente(), "S",
						Long.parseLong(polizza.trim()), 0, 
						anniPro, mesiPro, 
						dataProroga, polizzaPro, "N");
			
			bean = popolaBean(WSOpzioniBean.class, xml);
			bean.setAnniProroga(anniProroga);
			bean.setMesiProroga(mesiProroga);
			bean.setDataProroga(dataProroga);
			bean.setPolizzaProroga(polizzaProroga);

			LoggingUtils.debug(" Opzione Proroga - anniproroga : " + bean.getAnniProroga());
			LoggingUtils.debug(" Opzione Proroga - mesiproroga : " + bean.getMesiProroga());
			LoggingUtils.debug(" Opzione Proroga - importoOpzione : " + bean.getTotaleRenditaDiOpzioneComplessiva());

		} catch (Exception e) {
			LoggingUtils.error(e, e);
			throw new UniversoException(e.getMessage());
		}

		return bean;
	}

	/**
	 * Restituisce l'opzione di cambio frazionamento, sulla polizza indicata.
	 * 
	 * @param polizza			numero della polizza
	 * @param frazionamento		frazionamento (annuale, semestrale, mensile, ...)
	 *  @param anticipata		valore per il calcolo di opzione anticipata o meno
	 * 
	 * @return
	 * 
	 * @throws UniversoException
	 */                                           	public WSOpzioniBean getOpzCambioFraz(String polizza, String frazionamento, String anticipata) throws UniversoException {
		WSOpzioniBean bean = new WSOpzioniBean();

		String xml = null;

		try {
			LoggingUtils.debug("Input param, frazionamento: " + frazionamento);
			LoggingUtils.debug("Input param, anticipata: " + anticipata);
			
			xml = serviceWS.ipotesiOpzioneRenditaFrazionata(
					authHeader.getAmbiente(), "S",
					Long.parseLong(polizza.trim()), 0, 
					frazionamento, anticipata, "N");
			
			bean = popolaBean(WSOpzioniBean.class, xml);
			bean.setFrazionamento(frazionamento);
			
			trascodificaInput(bean);
			bean.setAnticipata(anticipata);

		} catch (Exception e) {
			LoggingUtils.error(e, e);
			throw new UniversoException(e.getMessage());
		}

		LoggingUtils.info(" Opzione CambioFraz - frazionamento : " + bean.getFrazionamento());
		LoggingUtils.info(" Opzione CambioFraz - anticipata : " + bean.getAnticipata());
		LoggingUtils.info(" Opzione CambioFraz - dataScadenzaPrimaRataRendita : " + bean.getDataScadenzaPrimaRataRendita());
		LoggingUtils.info(" Opzione CambioFraz - importoOpzione : " + bean.getTotaleRenditaDiOpzioneComplessiva());

		return bean;
	}

    /**
         * Esegue il fill delle variabili d'istanza dell'oggetto indicato, tramite reflection.
         *
         * @param <T>
         * @param clazz		bean da popolare per la risposta
         * @param xml		xml restituito in risposta da universo
         *
         * @return
         *
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

                        bean.setRenditaIniziale(_el.element("RENDITAINIZIALE").getText());
                        bean.setRenditaRivalutata(_el.element("RENDITARIVALUTATA").getText());
                        bean.setCapitaleCasoMorte(_el.element("CAPITALE").getText());
                        bean.setCapitaleCasoMorteUnit(_el.element("CAPITALEUNIT").getText());
                        bean.setValoreDiRiscattoTotaleLordo(_el.element("VALORERISCATTOLORDO").getText());
                        bean.setRiservaMatematica(_el.element("RISERVAMATEMATICA").getText());
                        bean.setTotalePremiRivalutatiIpotizzati(_el.element("TOTALEPREMIRIVIPOTIZZATI").getText());
                        bean.setInteressiRitardatoPagamento(_el.element("INTRITPAG").getText());
                        bean.setAppendice(_el.element("NUMAPP").getText());
                        bean.setTassoIsvap(_el.element("TASSOISVAP").getText());
                        bean.setEccedenza(_el.element("ECCEDENZA").getText());

                    } else if (rv instanceof WSRiduzioneBean) {
                        WSRiduzioneBean bean = (WSRiduzioneBean) rv;

                        Element prest = _el.element("PRESTAZIONICV");
                        bean.setPrestazioneVita(getElementValue(prest, "TOTALE"));
                        prest = _el.element("PRESTAZIONICM");
                        bean.setCasoMorteRivalutato(getElementValue(prest, "TOTALE"));

                    } else if (rv instanceof WSOpzioniBean) {
                        WSOpzioniBean bean = (WSOpzioniBean) rv;

                        bean.setDataScadenzaPrimaRataRendita(_el.element("DATASCADENZAPRIMARATARENDITA").getText());
                        bean.setDataFineDiffReversibilitaMorteAssic(_el.element("DATAFINEDIFFREVERSIBILITAMORTEASSIC").getText());
                        bean.setDifferimento(_el.element("DURATADIFFERIMENTO").getText());
                        bean.setImportoRataRenditaFrazionata(_el.element("IMPORTORATARENDITAFRAZIONATA").getText());
                        bean.setRataRenditaAnnuaVitaliziaAl75Anno(_el.element("RATARENDITAANNUAVITALIZIA75ANNO").getText());
                        bean.setRataRenditaAnnuaVitaliziaAl80Anno(_el.element("RATARENDITAANNUAVITALIZIA80ANNO").getText());
                        bean.setRataRenditaAnnuaVitaliziaAl85Anno(_el.element("RATARENDITAANNUAVITALIZIA85ANNO").getText());
                        bean.setRataRenditaReversibilitaMorteAssic(_el.element("RATARENDITAREVERSIBILITAMORTEASSIC").getText());
                        bean.setRenditaAnnuaVitaliziaAl75Anno(_el.element("RENDITAANNUAVITALIZIA75ANNO").getText());
                        bean.setRenditaAnnuaVitaliziaAl80Anno(_el.element("RENDITAANNUAVITALIZIA80ANNO").getText());
                        bean.setRenditaAnnuaVitaliziaAl85Anno(_el.element("RENDITAANNUAVITALIZIA85ANNO").getText());
                        bean.setDataRataRenditaReversibilitaMorteAssic(_el.element("DATARATARENDITAREVERSIBILITAMORTEASSIC").getText());
                        bean.setRenditaReversibilitaMorteAssic(_el.element("RENDITAREVERSIBILITAMORTEASSIC").getText());
                        bean.setRicorrenzaRenditaAl75Anno(_el.element("DATARICORRENZARENDITA75ANNO").getText());
                        bean.setRicorrenzaRenditaAl80Anno(_el.element("DATARICORRENZARENDITA80ANNO").getText());
                        bean.setRicorrenzaRenditaAl85Anno(_el.element("DATARICORRENZARENDITA85ANNO").getText());
                        bean.setTotaleRenditaDiOpzioneComplessiva(_el.element("TOTALERENDITA").getText());
                        bean.setDifferimento(_el.element("DURATADIFFERIMENTO").getText());
                        bean.setDurataCerta(_el.element("DURATACERTA").getText());

                        //trascodificaInput(bean);


                    } else if (rv instanceof WSPrestazioniAssicurateBean) {
                        WSPrestazioniAssicurateBean bean = (WSPrestazioniAssicurateBean) rv;

                        Element prest = _el.element("PRESTAZIONICV");
                        bean.setTotalePrestazioniCV(getElementValue(prest, "TOTALE"));
                        bean.setBonusCV(getElementValue(prest, "BONUS"));
                        prest = _el.element("PRESTAZIONICM");
                        bean.setTotalePrestazioniCM(getElementValue(prest, "TOTALE"));
                        bean.setBonusCM(getElementValue(prest, "BONUS"));
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
                }

            } catch (DocumentException e) {
                LoggingUtils.error(e, e);
                throw new UniversoException(e.getMessage());

            } catch (InstantiationException e) {
                LoggingUtils.error(e, e);
                throw new UniversoException(e.getMessage());

            } catch (IllegalAccessException e) {
                LoggingUtils.error(e, e);
                throw new UniversoException(e.getMessage());
            }

            return rv;
        }
         /*
         public WSRiscattoParzialeBean getRiscattoParziale(String polizza, BigDecimal importoRichiesto) throws UniversoException{
        	 return null;
         }
         */
}
