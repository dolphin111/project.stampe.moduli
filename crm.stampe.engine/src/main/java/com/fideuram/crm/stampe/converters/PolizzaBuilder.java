package com.fideuram.crm.stampe.converters;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.fideuram.exception.ws.CrmException;
import com.fideuram.exception.ws.CrmStampeException;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.model.Indirizzo;
import com.fideuram.crm.stampe.model.Liquidazione;
import com.fideuram.crm.stampe.model.Persona;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.crm.stampe.model.PrivateBanker;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.crm.vo.ValoreInputVO;
import com.fideuram.stampe.bean.famiglia.Famiglia;
import com.fideuram.stampe.cache.ClientWs;
import com.fideuram.stampe.dao.DaoException;
import com.fideuram.stampe.dao.PucDao;
import com.fideuram.stampe.dao.UniversoDao;
import com.fideuram.puc.service.impl.BeneficiarioLiquidazioneVO;
import com.fideuram.puc.service.impl.DettaglioAnagraficaVO;
import com.fideuram.puc.service.impl.GetDatiSinteticiPolizza;
import com.fideuram.puc.service.impl.GetDatiSinteticiPolizzaResponse.Return;
import com.fideuram.puc.service.impl.GetDatiSinteticiPolizzaResponse.Return.AltriDati;
import com.fideuram.puc.service.impl.GetDatiSinteticiPolizzaResponse.Return.DatiTecnici;
import com.fideuram.puc.service.impl.GetDatiSinteticiPolizzaResponse.Return.FigureContrattuali;
import com.fideuram.puc.service.impl.MassimoControvaloreVO;
import com.fideuram.puc.service.impl.PolizzaTrasformataVO;
import com.fideuram.puc.service.impl.PraticaLiquidazionePolizzaVO;
import com.fideuram.puc.service.impl.QuoteCumulatePolizzaVO;
import com.fideuram.puc.service.impl.ServiceException_Exception;
import com.fideuram.puc.service.impl.StampeServiceImpl;
import com.fideuram.puc.service.impl.TitoloPolizzaVO;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.NumberUtils;
import com.fideuram.utils.StringUtils;


/**
 * @author Giuseppe Luciani
 * @author Giorgio Desideri
 *
 */
public abstract class PolizzaBuilder {

    /**
     * Costruisce la polizza.
     *
     * @param numeroPolizza
     * @param root
     * @param tripletta
     * @param scenario
     *
     * @return {@link com.fideuram.crm.stampe.model.Polizza}
     * @throws CrmException
     * @throws NumberFormatException
     *
     * @throws CrmStampeException
     */
    public static Polizza buildPolizza(String numeroPolizza,
                                       boolean root,
                                       String tripletta,
                                       String scenario,
                                       int idTemplate,
                                       String tipocomunicazione,
                                       DomandaVO domanda,Integer comunicazione) throws PucException, WebServiceClientException, NumberFormatException, CrmException {


    	StampeServiceImpl pucClient = (StampeServiceImpl) new ClientWs().getPucClient(comunicazione);
        Polizza target = (Polizza) new PucDao(comunicazione).getDatiPolizza(Long.decode(numeroPolizza));

        try {
            // Scenari
            target.setScenario(scenario);

            String durataMinima= "";
            String premioAggiuntivo="";
            List<ValoreInputVO> vi= domanda.getValoriInput();
            for(ValoreInputVO voi :vi){
                if(voi.getDatoInput().getId()==56){
                    durataMinima= voi.getValore();
                }
                if(voi.getDatoInput().getId()==57){
                    premioAggiuntivo= voi.getValore();
                }
            }
            if(durataMinima.equals("")){
                if (target.getProdotto().trim().equalsIgnoreCase("RV0U1"))
                    target.setDurataMinima("1");
                else
                    target.setDurataMinima("10");
            }
            else
                target.setDurataMinima(durataMinima);


            if(!target.getProdotto().trim().equalsIgnoreCase("RS0U1") && !target.getProdotto().trim().equalsIgnoreCase("RS0U2")
                    && !target.getProdotto().trim().equalsIgnoreCase("RM0U1") && !target.getProdotto().trim().equalsIgnoreCase("RB0U1")
                    && !target.getProdotto().trim().equalsIgnoreCase("RB0U2") && !target.getProdotto().trim().equalsIgnoreCase("RV0U1")
                    && !target.getProdotto().trim().equalsIgnoreCase("RP") && !target.getProdotto().trim().equalsIgnoreCase("RG0T2")
                    && !target.getProdotto().trim().equalsIgnoreCase("RG0T1"))
            {
                target.setDurataMinima("");
            }


            target.setPremioAggiuntivo(premioAggiuntivo);

            if(target.getProdotto().trim().equalsIgnoreCase("RG0T1"))
                target.setPremioAggiuntivo("");


            // Prestazioni assicurate - i controlli sono dentro il client
            if (!(tipocomunicazione.equals("2")) &&
                    !(tipocomunicazione.equals("8")) &&
                    !(tipocomunicazione.equals("9")) &&
                    !(tipocomunicazione.equals("A")) || target.getMacroFamiglia()==2) {
                getPrestazioniAssicurate(target, tripletta, idTemplate, tipocomunicazione);
            }

            if (root) {
                // Valore di default per data valutazione: data sistema
                target.addAttributo("dataValutazione",
                        DateUtils.formatNow(Costanti.FORMATO_DATA));

                // Gestione Polizze Trasformate
                List<PolizzaTrasformataVO> lpt = pucClient.listDatiPolizzaTrasformataByPolizza(new Long(numeroPolizza));

                if(lpt != null && !lpt.isEmpty())
                    target.setPolizzeProvenienza(new ArrayList<Polizza>());
                for(int i=0; i<lpt.size();i++){
                    Polizza polizzaTrasformante = new Polizza();
                    polizzaTrasformante.setTrasformata(true);
                    polizzaTrasformante.setDataEmissione((StringUtils.blankString(DateUtils.getNullSefeCalendar(lpt.get(i).getDataCarico()))));

                    String pa =StringUtils.blankString(NumberUtils.getNullSefeCurrency(lpt.get(i).getSommatoriaPremiAnnui()));
                    polizzaTrasformante.setPremiAnnui(pa);

                    String     pu =StringUtils.blankString(NumberUtils.getNullSefeCurrency(lpt.get(i).getSommatoriaPremiUnici()));
                    polizzaTrasformante.setPremiUnici(pu);

                    polizzaTrasformante.setNumero(lpt.get(i).getPolizzaTrasformante());
                    target.getPolizzeProvenienza().add(polizzaTrasformante);
                }

                target.setTrasformata(target.getPolizzeProvenienza() != null
                        && !target.getPolizzeProvenienza().isEmpty());

                // Separazione altri dati

                if(idTemplate!=Costanti.ID_PREVIDENZA){
                    getTitoloPolizza(pucClient, target);
                }

                if(!target.isCollettiva()){
                	//getMassimoValoreUl(pucClient, target);
                    getDatiDettaglioAnagrafica(pucClient, target);
                    getQuoteCumulate(pucClient, target);
                    //getBeneficiari(pucClient, target);
                    getDatiSintetici(pucClient, target);
                 
                }else{
                    getDatiDettaglioAnagraficaCollettive();
                }

                getPraticheLiquidazione(pucClient, target);
            }

            LoggingUtils.debug("---- FINE buildPolizza(...) ----");

            return target;

        } catch (ServiceException_Exception e) {
            throw new PucException(e.getMessage());
        }
    }

    /**
     * @param tripletta
     *
     * @throws CrmStampeException
     */
    private static void getPrestazioniAssicurate(Polizza polizza, String tripletta, int idTemplate, String tipocomunicazione) throws WebServiceClientException {
        //polizza.setPrestazioniAssicurate(false);
        // Polizza in rendita o spiegazione conteggi: nulla da fare

        if (Costanti.CODICE_SPIEGAZIONE_CONTEGGI.equalsIgnoreCase(tripletta))
            return;

        // Polizza di Eccedenza: nulla da fare!
        if(tripletta.equalsIgnoreCase(Costanti.CODICE_ECCEDENZA))
            return;

        // Tripletta G12 Premi da Fare: nulla da fare!
        if(tripletta.equalsIgnoreCase(Costanti.CODICE_PREMI_PAGATI))
            return;

        // Tripletta y1100 Premi da Fare: nulla da fare!
        if(tripletta.equalsIgnoreCase(Costanti.CODICE_LIQUIDAZIONI_SPI))
            return;

        // Tripletta b2100 Premi da Fare: nulla da fare!
        if(tripletta.equalsIgnoreCase(Costanti.CODICE_RISCATTO_A_TERMINE_SPI))
            return;

        // Tripletta e131 Premi da Fare: nulla da fare!
        if(tripletta.equalsIgnoreCase(Costanti.CODICE_AVVISI_SCADENZA_SPI))
            return;

        //Tripletta e132 Premi da Fare: nulla da fare!
        if(tripletta.equalsIgnoreCase(Costanti.CODICE_AVVISI_SCADENZA_PA))
            return;

        // Tripletta 000 Previdenza da Fare: nulla da fare!
        if(tripletta.equalsIgnoreCase(Costanti.CODICE_PREVIDENZA))
            return;

        // Polizza Chiusa?? ahi hai hai...: nulla da fare!
        if(polizza.getTipo().equalsIgnoreCase("C"))
            return;

        // TEMPLATE LETTERA GENERICA?.: nulla da fare!
        if(idTemplate==Costanti.ID_LETTERA_GENERICA)
            return;

        // SE NUOVO PRODOTTO VITA_INSIEME?.: nulla da fare!
        if(polizza.getCodiceTariffa().length()==3&&polizza.getCodiceTariffa().contains("93"))
            return;

        // Tripletta e5101 Premi da Fare: nulla da fare!
        if(tripletta.equalsIgnoreCase(Costanti.CODICE_OPZIONE_RAMO_III))
            return;

        // Tripletta b17 CODICE_RISCATTO_PARZIALE_TENDENZA : nulla da fare!
        if(tripletta.equalsIgnoreCase(Costanti.CODICE_RISCATTO_PARZIALE_TENDENZA))
            return;

        // Tripletta b118 CODICE_RISCATTO_PARZIALE_PUNTUALE: nulla da fare!
        if(tripletta.equalsIgnoreCase(Costanti.CODICE_RISCATTO_PARZIALE_PUNTUALE))
            return;

        // Tripletta B131 CODICE_DECUMULO: nulla da fare!
        if(tripletta.equalsIgnoreCase(Costanti.CODICE_DECUMULO))
            return;
        //RISCHI COMUNI PRENDE IL NOME DI Situazione polizza per contraente
        if(tripletta.equalsIgnoreCase(Costanti.CODICE_RISCHI_COMUNI)){
            Famiglia famiglia=Famiglia.getFamiglia(polizza);
            if(famiglia.getCodiceFamiglia()>0 && famiglia.getCodiceFamiglia()<2)
                return;
        }

        //reclamo
        if ((tipocomunicazione.equals("2")) ||
                (tipocomunicazione.equals("8")) ||
                (tipocomunicazione.equals("9")) ||
                (tipocomunicazione.equals("A"))) {
            return;
        }

        try {
            new UniversoDao().setPrestazioniAssicuraste(polizza,tripletta);
            polizza.setPrestazioniAssicurate(true);
        } catch (DaoException e) {
            LoggingUtils.info(e);
        }
    }

    private static void getDatiDettaglioAnagraficaCollettive(){

    }

    /**
     * @param service
     * @param targetPolizza
     * @throws CrmStampeException
     */
    
    /*
    private static void getBeneficiari(StampeServiceImpl service,
            Polizza targetPolizza) throws PucException {
    	List<BeneficiarioLiquidazioneVO> listaBeneficiari = null;
    	try {
    		listaBeneficiari = service.listBeneficiariLiquidazioneByPolizza(new Long(targetPolizza
                    .getNumero()));
        } catch (ServiceException_Exception e) {
            throw new PucException(e);
        }
    	if ((listaBeneficiari == null) || (listaBeneficiari.isEmpty()))
            return;
    	
    	targetPolizza.setBeneficiari(listaBeneficiari);
    }
    */
    
    private static void getMassimoValoreUl(StampeServiceImpl service,
            Polizza targetPolizza) throws PucException {

    	Date data = Calendar.getInstance().getTime();
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    	String dataFine = df.format(data);
    	String dataInizio = getDataInizio(dataFine);
    	MassimoControvaloreVO x; 
    	try {
    		x = service.getMassimoControvalorePolizza(2018, new Long(targetPolizza
                    .getNumero()));
        } catch (ServiceException_Exception e) {
            throw new PucException(e);
        }
    	if ((x == null))
            return;
    	
    	targetPolizza.setMassimoValoreUl(x.getControvalore());
    	//da toglere
    	//targetPolizza.setAttiva(false);
    }
    
    
    private static String getDataInizio(String dataFine) {
		int x = Integer.parseInt(dataFine.substring(0, 4))-1;
		return String.valueOf(x).concat(dataFine.substring(4,dataFine.length()));
	}

	private static void getDatiSintetici(StampeServiceImpl service,
            Polizza targetPolizza) throws PucException {
    	Return polizzaDati = null;
    	try {
    		polizzaDati = service.getDatiSinteticiPolizza(new Long(targetPolizza
                    .getNumero()));
        } catch (ServiceException_Exception e) {
            throw new PucException(e);
        }
    	if(polizzaDati.equals(null))
    		return;
    	else{
    		DatiTecnici dt = polizzaDati.getDatiTecnici();
    		AltriDati ad = polizzaDati.getAltriDati();
    		FigureContrattuali fc = polizzaDati.getFigureContrattuali();
    		
    		
    		targetPolizza.setStatoDT(dt.getStato());
    		targetPolizza.setVincolo(ad.getVincolo().isAttivo());
    		targetPolizza.setDecumuloAttivo(ad.getDecumuloCedola().isAttivo());
    		targetPolizza.setImponibileCongelamento(ad.getImponibileCongelamento());
    		targetPolizza.setImportoPianoProgrammatoVersamenti(ad.getImportoPianoProgrammatoVersamenti());
    		targetPolizza.setDetraibiltaFiscale(ad.getDetraibilitaFiscale().isStato());
    		targetPolizza.setPolizzaScudata(ad.isPolizzaScudata());
    		targetPolizza.setImpostaBolloMaturata(ad.getImpostaBolloMaturata());    	
    		targetPolizza.setIsVariazioneContrattuale(ad.isIsVariazioneContrattuale());
    		targetPolizza.setTipoClasseBonus(ad.getTipoClasseBonus());
    		targetPolizza.setRiallocazioneGuidata(ad.isIsRiallocazioneGuidata());
    		
    		targetPolizza.setBeneficiarioVita(fc.getBeneficiarioVita());
    		targetPolizza.setBeneficiarioMorte(fc.getBeneficiarioMorte());
    		
    	}
    }
    
    
    private static void getDatiDettaglioAnagrafica(StampeServiceImpl service,
                                                   Polizza targetPolizza) throws PucException {
        // Dettaglio Anagrafica
        List<DettaglioAnagraficaVO> listaAnagrafica = null;
        try {
            listaAnagrafica = service
                    .listAnagraficheConBeneficiariByPolizza(new Long(targetPolizza
                            .getNumero()));
        } catch (ServiceException_Exception e) {
            throw new PucException(e);
        }

        if ((listaAnagrafica == null) || (listaAnagrafica.isEmpty()))
            return;

        for (DettaglioAnagraficaVO anagrafica : listaAnagrafica) {
            Persona persona = new Persona();

            if ("Banker".equals(anagrafica.getRuolo())) {
                persona = new PrivateBanker();

                if ("BFI".equals(targetPolizza.getReteVendita())) {
    				((PrivateBanker) persona)
    				.setReteVendita("Fideuram - Intesa Sanpaolo Private Banking");
    			} else if ("SPI".equals(targetPolizza.getReteVendita())){
    				((PrivateBanker) persona)
    				.setReteVendita("Fideuram - Intesa Sanpaolo Private Banking");
    			} else if ("ISPB".equals(targetPolizza.getReteVendita())) {
    				((PrivateBanker) persona)
    				.setReteVendita("Intesa Sanpaolo Private Banking S.p.A.");
    			} else if ("IWB".equals(targetPolizza.getReteVendita())) {
    				((PrivateBanker) persona)
    				.setReteVendita("IW SIM S.p.A.");
    			}
            }

            String denominazione;
            
            denominazione = (anagrafica.getCognome() == null) ? ""
                    : anagrafica.getCognome().trim().toUpperCase();

            denominazione += " "
                    + ((anagrafica.getNome() == null) ? "" : anagrafica
                    .getNome().trim().toUpperCase());

            denominazione += " "
                    + ((anagrafica.getRagioneSociale() == null) ? ""
                    : anagrafica.getRagioneSociale().trim()
                    .toUpperCase());
            

            persona.setDenominazione(denominazione.trim());
            persona.setDataNascita(DateUtils.getNullSefeCalendar(anagrafica
                    .getDataNascita()));
            persona.setSesso(StringUtils.blankString(anagrafica.getSesso()));

            Indirizzo i = new Indirizzo();

            i.setCap(StringUtils.blankString(anagrafica.getCap()));
            i.setCitta(anagrafica.getComune() != null ? anagrafica
                    .getComune().toUpperCase() : "");
            i.setProvincia(anagrafica.getProvincia() != null ? anagrafica
                    .getProvincia().toUpperCase() : "");
            i.setVia(anagrafica.getIndirizzo() != null ? anagrafica
                    .getIndirizzo().toUpperCase() : "");

            persona.setIndirizzo(i);

            if ("PrimoAssicurato".equals(anagrafica.getRuolo())) {
                targetPolizza.setAssicurato(persona);

            } else if ("Contraente".equals(anagrafica.getRuolo())) {
                targetPolizza.setContraente(persona);

                
            } else if ("Banker".equals(anagrafica.getRuolo())) {
                targetPolizza.setPrivateBanker((PrivateBanker) persona);

            }
        }


    }

    /**
     * @param service
     * @param targetPolizza
     * @throws CrmStampeException
     */
    private static void getTitoloPolizza(StampeServiceImpl service,
                                         Polizza targetPolizza) throws PucException {
        // Titolo Polizza
        TitoloPolizzaVO titolo = null;
        try {
            titolo = service.getTitoliByPolizza(new Long(
                    targetPolizza.getNumero()));
        } catch (ServiceException_Exception e) {
            throw new PucException(e);
        }

        targetPolizza
                .setPremiAnnui(StringUtils.blankString(NumberUtils
                        .getNullSefeCurrency(titolo
                                .getTotalePremiAnnuiIncassati())));

        if (("0" + Costanti.SEPARATORE_DECIMALI + "00")
                .equals(targetPolizza.getPremiAnnui()))
            targetPolizza.setPremiAnnui("");

        targetPolizza
                .setPremiUnici(StringUtils.blankString(NumberUtils
                        .getNullSefeCurrency(titolo
                                .getTotalePremiUniciIncassati())));

        if (("0" + Costanti.SEPARATORE_DECIMALI + "00")
                .equals(targetPolizza.getPremiUnici()))
            targetPolizza.setPremiUnici("");

        targetPolizza.setDataPremiDaIncassare(StringUtils
                .blankString(DateUtils.getNullSefeCalendar(titolo
                        .getDataRiferimentoPremiIncassareMin())));

        if (("0" + Costanti.SEPARATORE_DECIMALI + "00")
                .equals(targetPolizza.getPremiDaIncassare()))
            targetPolizza.setPremiDaIncassare("");

        targetPolizza.setDataUltimaRataPagata(StringUtils
                .blankString(DateUtils.getNullSefeCalendar(titolo
                        .getDataUltimaRataPagata())));

    }

    /**
     * @param service
     * @param targetPolizza
     * @throws CrmStampeException
     */
    private static void getQuoteCumulate(StampeServiceImpl service,
                                         Polizza targetPolizza) throws PucException {

        QuoteCumulatePolizzaVO quoteCumulative = null;
        try {
            quoteCumulative = service.getQuoteCumulatePolizzaByPolizza(new Long(targetPolizza.getNumero()));
        } catch (ServiceException_Exception e) {
            throw new PucException(e);
        }

        if (quoteCumulative != null) {
            if(quoteCumulative.getControvaloreQuoteAttuale()!=null)
                targetPolizza.setControvaloreQuote(StringUtils
                        .blankString(NumberUtils.formatCurrency(
                                quoteCumulative.getControvaloreQuoteAttuale(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI)));

            if (("0" + Costanti.SEPARATORE_DECIMALI + "00")
                    .equals(targetPolizza.getControvaloreQuote()))
                targetPolizza.setControvaloreQuote("");

            Date date = null;

            if (quoteCumulative.getUltimaDataRiferimentoNav()!=null) {
                date = quoteCumulative.getUltimaDataRiferimentoNav()
                        .toGregorianCalendar().getTime();

                targetPolizza.setDataRiferimentoQuote(DateUtils.formatDate(
                        date, Costanti.FORMATO_DATA));
            }
        }
    }

    /**
     * @param service
     * @param targetPolizza
     * @throws CrmStampeException
     */
    private static void getPraticheLiquidazione(StampeServiceImpl service,
                                                Polizza targetPolizza) throws PucException {
        // Lista pratiche Liquidazione
        List<PraticaLiquidazionePolizzaVO> litaPraticheLiquidazione = null;
        try {
            litaPraticheLiquidazione = service
                    .listPraticheLiquidazioniByPolizza(new Long(targetPolizza
                            .getNumero()));
        } catch (ServiceException_Exception e) {
            throw new PucException(e);
        }

        if ((litaPraticheLiquidazione == null)
                || (litaPraticheLiquidazione.isEmpty()))
            return;

        Date date = null;
        targetPolizza.setLiquidazioni(new ArrayList<Liquidazione>());

        for (PraticaLiquidazionePolizzaVO praticaLiquidazione : litaPraticheLiquidazione) {
            Liquidazione liq = new Liquidazione();

            liq.setDescrizione(praticaLiquidazione.getTipoLiquidazione());
            if("5".equals(praticaLiquidazione.getCodiceTipoLiquidazione())){
                //equivale a    <tipoLiquidazione>Scadenza</tipoLiquidazione>
                liq.setPraticaScadenza(true);
            }else {
                liq.setPraticaScadenza(false);
            }
            liq.setAbi(praticaLiquidazione.getAbi());
            liq.setBic(praticaLiquidazione.getBic());
            liq.setCab(praticaLiquidazione.getCab());
            liq.setConto(praticaLiquidazione.getContocorrente());

            liq.setCosto(NumberUtils
                    .getNullSefeCurrency(praticaLiquidazione
                            .getCostoLiquidazione()));

            liq.setData(DateUtils.getNullSefeCalendar(praticaLiquidazione
                    .getDataValuta()));

            liq.setDataErogazioneRendita(DateUtils
                    .getNullSefeCalendar(praticaLiquidazione
                            .getDataErogazioneRendita()));

            liq.setDataPraticaScadenza(DateUtils
                    .getNullSefeCalendar(praticaLiquidazione
                            .getDataPraticaScadenza()));

            liq.setDivisa(praticaLiquidazione.getDivisa());

            liq.setIban(praticaLiquidazione.getIban());

            liq.setImportoPrestito(NumberUtils
                    .getNullSefeCurrency(praticaLiquidazione
                            .getImportoPrestito()));

            liq.setImposte(NumberUtils
                    .getNullSefeCurrency(praticaLiquidazione.getImposte()));

            liq.setInteressiMora(NumberUtils
                    .getNullSefeCurrency(praticaLiquidazione
                            .getInteressiMora()));

            liq.setInteressiPrestito(NumberUtils
                    .getNullSefeCurrency(praticaLiquidazione
                            .getInteressiPrestito()));

            liq.setIntRitPag(NumberUtils
                    .getNullSefeCurrency(praticaLiquidazione
                            .getInteressiRitardatoPagamento()));

            liq.setLordoMaturato(NumberUtils
                    .getNullSefeCurrency(praticaLiquidazione
                            .getImportoLordoLiquidato()));

            liq.setModalitaPagamento(praticaLiquidazione
                    .getModalitaPagamento());

            liq.setNettoPagato(NumberUtils
                    .getNullSefeCurrency(praticaLiquidazione
                            .getImportoNettoPagato()));

            liq.setPrestazioneLorda(NumberUtils
                    .getNullSefeCurrency(praticaLiquidazione
                            .getPrestazioneLorda()));

            // Per il momento non disponibile
				/*
				 * if (l.getNumeroAppendice() != null) { liq.setNumeroAppendice
				 * (l.getNumeroAppendice().toString()); }
				 */

            targetPolizza.getLiquidazioni().add(liq);
            //((Liquidazione)targetPolizza.getLiquidazioni()).getDescrizione()
            if (praticaLiquidazione.getDataLiquidazione() != null && (date==null ||date.before(praticaLiquidazione.getDataLiquidazione().toGregorianCalendar().getTime()))) {
            	
                date = praticaLiquidazione.getDataLiquidazione().toGregorianCalendar().getTime();
            }
            
        }
        targetPolizza.setPraticheAperte((litaPraticheLiquidazione.size()>0?true:false));

    }

}
