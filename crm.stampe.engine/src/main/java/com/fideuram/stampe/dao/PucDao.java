package com.fideuram.stampe.dao;


import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.converters.ExPolizzaBuilder;
import com.fideuram.crm.stampe.exception.StampeInfoException;
import com.fideuram.crm.stampe.model.Decumulo;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.crm.vo.ComunicazioneVO;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.crm.vo.ValoreInputVO;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.jaxb.Converter;
import com.fideuram.puc.service.impl.*;
import com.fideuram.stampe.bean.anagrafica.Beneficiario;
import com.fideuram.stampe.bean.commissioni.CommissioniFondiEsterni;
import com.fideuram.stampe.bean.polizza.collettiva.EstrattoConto;
import com.fideuram.stampe.bean.polizza.collettiva.Premio;
import com.fideuram.stampe.bean.pratiche.SospensioneScadenza;
import com.fideuram.stampe.bean.prestito.Prestito;
import com.fideuram.stampe.bean.riscatto.Riscatto;
import com.fideuram.stampe.bean.riscatto.RiscattoParziale;
import com.fideuram.stampe.bean.riscatto.RiscattoTotale;
import com.fideuram.stampe.bean.riscatto.Scadenza;
import com.fideuram.stampe.bean.simulatori.ValoreAllaData;
import com.fideuram.stampe.cache.ClientWs;
import com.fideuram.stampe.dao.tronconi.TronconiManagaer;
import com.fideuram.stampe.dao.valoriinputs.InputsBean;
import com.fideuram.stampe.dao.valoriinputs.InputsManager;
import com.fideuram.stampe.modello.attori.Individuo;
import com.fideuram.stampe.modello.attori.Recapito;
import com.fideuram.stampe.modello.comunicazionecrm.Comunicazione;
import com.fideuram.stampe.modello.preventivi.*;
import com.fideuram.stampe.modello.preventivi.Prodotto;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.NumberUtils;

import org.apache.commons.beanutils.BeanUtils;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;


/**
 * Created with
 * User: v801068
 * Date: 27/11/13
 * Time: 14.27
 */
public class    PucDao {
    StampeServiceImpl puc = null;

    public PucDao(int comunicazione) throws WebServiceClientException {
        LoggingUtils.info("rel. 00 PUC DAO");

        puc = (StampeServiceImpl) new ClientWs().getPucClient(comunicazione);

        LoggingUtils.info("PATH PUC: " + puc);
    }

    /*public PucDao() throws WebServiceClientException {
        ClientWsFactory wsFactory = ClientWsFactory.getInstance();
        puc =wsFactory.getPucClient();
    }*/

    public ValoreAllaData getValoreAllaDataByPolizza(String numeroPolizza, DomandaVO domandaVO) throws PucException {
        InputsBean inputsBean = getInputsBean(domandaVO);
        GregorianCalendar gregorianCalendar = DateUtils.toGregorian(inputsBean.getDataRiferimento(),"yyyy-MM-dd");
        try {
            DettaglioValoreAllaDataVO _vo= puc.getValoreAllaDataByPolizzaData(numeroPolizza, DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar));
            if(_vo.getWarningTrace()!=null && _vo.getWarningTrace().size()>0){
                throw  new PucException(_vo.getWarningTrace().get(0).getTrace());
            }
            ValoreAllaData valoreAllaData=new ValoreAllaData(gregorianCalendar.getTime(),_vo.getValorePolizza());
            return valoreAllaData;
        } catch (ServiceException_Exception e) {
            throw new PucException("Errore per SimulazioneValoreAllaDataByPolizza polizza: " + numeroPolizza ,e);
        } catch (DatatypeConfigurationException e) {
            throw new PucException("Errore per SimulazioneValoreAllaDataByPolizza polizza: " + numeroPolizza ,e);
        }
    }

    /**
     * @param numeroPolizza
     * @param domanda
     * @return
     * @throws PucException
     * @throws DaoException
     */
    public Decumulo getDecumulo(String numeroPolizza, DomandaVO domanda)throws PucException, DaoException{
        Decumulo decupito=new Decumulo();
        decupito.setPercentuale(getValore(Costanti.INPUT_DECUMULO, domanda, "in INPUT_DECUMULO"));
        String frazionamento=getValore(Costanti.INPUT_FRAZIONAMENTO, domanda, "in INPUT_FRAZIONAMENTO");
        decupito.setFrazionamento(frazionamento);
        DecumuloVO pucVo = null;
        try {
            pucVo = puc.getDecumulo(numeroPolizza, decupito.getPercentuale().replaceAll(",","."),frazionamento);
        } catch (ServiceException_Exception e) {
            throw new PucException("Errore per LetteraDecumulo polizza: " + numeroPolizza  +", Il controvalore quote non può esssre 0",e);
        }
        decupito.setImportoCVN(pucVo.getImportoCVN());
        decupito.setDataCVN(pucVo.getDataCVN() != null ? DateUtils.formatDate(pucVo.getDataCVN().toGregorianCalendar(), Costanti.FORMATO_DATA) : "");
        decupito.setImportoCedola(pucVo.getImportoDecumulo());
        return decupito;
    }

    /**
     * metodo privato che ha lo scopo di restituire il valore dei dati input passati con la comunicazione. Se presenti!
     * @param tipoRicercato array dei tipologici di input ricercati ad esempio:  Costanti.INPUT_DECUMULO {41,x,x,x...}
     * @param domanda
     * @param TraceLog   Il nome di riferimento del dato di input
     * @return
     * @throws DaoException
     */
    private String getValore(int tipoRicercato[], DomandaVO domanda, String TraceLog) throws DaoException{
        for (ValoreInputVO v : domanda.getValoriInput()) {
            LoggingUtils.info("LOG DEI VALORI DI INPUT ARRIVATI: ["+domanda.getValoriInput()+"]");
            for (int tipo : tipoRicercato) {
                if (tipo == v.getDatoInput().getId()) {
                        return v.getValore();
                }
            }
        }
        throw new DaoException("DATO DI "+ TraceLog +" MANCANTE");
    }

    public  List<DettaglioFiscalitaPolizzeVO> listaDettaglioFiscalita(String numeroPolizza)  throws PucException, DaoException {
        try {
            Long polizza =new Long(numeroPolizza);
            List<DettaglioFiscalitaPolizzeVO> listaDettaglioFiscalita=puc.listDettaglioFiscalitaPolizzeAperteByNumeroPratica(numeroPolizza)  ;
             return listaDettaglioFiscalita;
        } catch (ServiceException_Exception e) {
            LoggingUtils.error(e);
            throw new PucException(e);
        }
    }


    public  DettaglioLiquidazionePrestazionePensionisticaVO  listaDettaglioSimulatoreFPA(String numeroPolizza) throws DaoException, PucException {

        try {
            Long polizza =new Long(numeroPolizza);
            Boolean valore=true;
            DettaglioLiquidazionePrestazionePensionisticaVO dettaglioLiquidazione=puc.getSimulatoriFPA(numeroPolizza,true);
            return dettaglioLiquidazione;
        } catch (Exception e) {
            LoggingUtils.error(e);
            throw new PucException(e);
        }

    }




    public SospensioneScadenza getPraticaScadenzaSospesa(String numeroPolizza, String dataScadenza) throws PucException, DaoException {
        try {
            Long polizza =new Long(numeroPolizza);

            ScadenzaSospesaVO scadenzaSospesa = puc.getPraticaScadenzaSospesaByNumeroPolizza(polizza);
            return scadenzaSospesa.getDataRichiesta()!=null? new SospensioneScadenza(DateUtils.formatDate(scadenzaSospesa.getDataRichiesta(), "dd/MM/yyyy"),dataScadenza,polizza) : new SospensioneScadenza(polizza);
        } catch (ServiceException_Exception e) {
            LoggingUtils.error(e);
            throw new PucException(e);
        } catch (ParseException e) {
            LoggingUtils.error("Errore di parsinge per la Polizza " + numeroPolizza + " " + e);
            throw new DaoException(e);
        }
    }



    public  BigDecimal getCoefficienteRiscattoFul(SospensioneScadenza praticaSospensioneScadenza) throws DaoException, PucException {
        CalcoloRiscattoTermineVO voInput = new CalcoloRiscattoTermineVO();
        voInput.setNumeroPolizza(""+praticaSospensioneScadenza.getNumeroPolizza());
        voInput.setPreavviso(String.valueOf(praticaSospensioneScadenza.isExistPratica()?praticaSospensioneScadenza.getPreavvisoInAnni():0));
        try {
            return puc.getCoefficenteRiscattoFulByNumeroPolizza(voInput);
        } catch (ServiceException_Exception e) {
            LoggingUtils.error(e);
            throw new PucException(e);
        }
    }

    public String getPreventivoConversioneRendita(ComunicazioneVO comunicazioneVO, DomandaVO dom) throws DaoException, PucException {
        Preventivo p = new Preventivo();
        Comunicazione c= new Comunicazione();
        c.setProtocollo(comunicazioneVO.getNumeroProtocollo());
        c.setCittaEmissione("Roma");
        p.setComunicazione(c);

        Prodotto prodottoPreventivato = new Prodotto();
        FamigliaProdotto famigliaProdotto=new FamigliaProdotto();

        Rateo rateo = new Rateo();
        RenditaVitalizia renditaVitalizia = new RenditaVitalizia();
        renditaVitalizia.setTronconiCrm(new TronconiManagaer().getTronconi(dom.getDescrizioneDomanda().getTemplate().getTronconi()));
        Individuo assicurato = new Individuo();
        assicurato.setNome(comunicazioneVO.getNominativoContatto());

        Recapito indirizzo = new Recapito();
        indirizzo.setCap(comunicazioneVO.getIndirizzoLettera().getCap());
        indirizzo.setComune(comunicazioneVO.getIndirizzoLettera().getComune());
        indirizzo.setProvincia(comunicazioneVO.getIndirizzoLettera().getProvincia());
        indirizzo.setVia(comunicazioneVO.getIndirizzoLettera().getIndirizzo());
        assicurato.setIndirizzo(indirizzo);

        //Carico i valori di Inputs
        //InputsBean inputsBean=new InputsManager().getValoriInput(dom.getValoriInput());
        InputsBean inputsBean=getInputsBean(dom);
        rateo.setDurataMinima(Integer.decode(inputsBean.getDurataMinima()));
        rateo.setImportoPremio(inputsBean.getPremio());
        assicurato.setSesso(inputsBean.getSesso());
        assicurato.setDataNascita(getCrmDate(inputsBean.getDataNascita()));
        rateo.setDecorrenza(getCrmDate(inputsBean.getDataDecorrenza()));
        renditaVitalizia.setImportoRendita(inputsBean.getRenditaAnnua());
        rateo.setDecumulo(Integer.decode(inputsBean.getDecumulo()));


        //Richiamo un servizio che mi restituisce tutta la famiglia  di un prodotto
        DatiProdottoVO prodottoPuc=getDatiProdotto(inputsBean.getProdotto());
        if (prodottoPuc != null) {
            prodottoPreventivato.setCodice(prodottoPuc.getCodiceProdotto());
            prodottoPreventivato.setDescrizione(prodottoPuc.getDescrizioneCommerciale());
            famigliaProdotto.setCodice(prodottoPuc.getTipoMacroFamigliaId().intValue());
            famigliaProdotto.setDescrizione(prodottoPuc.getTipoMacroFamigliaDescrizione());
            prodottoPreventivato.setFamigliaProdotto(famigliaProdotto);
        }

        DettaglioCoefficienteRenditaFrazionataVO d=null;
        try {
             d = puc.getSimulatorePreventivoConversioneRendita( inputsBean.getDurataMinima(),
                                                                inputsBean.getPremio(),
                                                                inputsBean.getSesso(),
                                                                inputsBean.getDecumulo(),
                                                                inputsBean.getDataNascita(),
                                                                inputsBean.getProdotto(),
                                                                inputsBean.getDataDecorrenza(),
                                                                inputsBean.getRenditaAnnua());
        } catch (ServiceException_Exception e) {
            LoggingUtils.error(e);
            throw new PucException(e);
        }





        // todo renditaVitalizia.setDataRiferimento(d.getDataRiferimento());
        renditaVitalizia.setRenditaAnnua(d.getRenditaAnnuale());
        p.setAssicurato(assicurato);
        renditaVitalizia.setDataRiferimento(getCrmDate(d.getDataRiferimento().toString()));
        p.setRateo(rateo);
        p.setProdotto(prodottoPreventivato);
        p.setVitalizio(renditaVitalizia);

        String xml;
        try {
            xml=Converter.objectToXml(p);
            LoggingUtils.info(xml);
        } catch (JAXBException e) {
            LoggingUtils.error(e);
            throw new DaoException(e);
        } catch (IOException e) {
            LoggingUtils.error(e);
            throw new DaoException(e);
        }

        return xml;
    }

    /**
     * Restituisce la famiglia e la descrizione del prodotto
     * @param codiceProdotto
     * @return
     * @throws PucException
     */
    private  DatiProdottoVO getDatiProdotto(String codiceProdotto)throws PucException {
        try {
            return  puc.getProdottoByID(codiceProdotto);
        } catch (ServiceException_Exception e) {
            LoggingUtils.error(e);
            throw new PucException(e);
        }

    }


    private Date getCrmDate(String TdateFromInput) throws DaoException {
        try {
            return DateUtils.getCrmDate(TdateFromInput);
        } catch (ParseException e) {
            LoggingUtils.error(e);
            throw new DaoException(e);
        }
    }


    public Object getRiscattoByPolizza(Long numeroPolizza, Boolean isTotale) throws PucException, DaoException {
        Riscatto riscatto;
        RiscattoVO puvVo;
        try {
            if (isTotale){
                //sembra una castroneria: è dovuta!! il puc  si ricava la pratica di licquidazione dal numero polizza,
                //riverificato gi-27Agosto-2015 su segnalazione rosso di castrovillari
                //questa è la queri del pic
                /*
                    select
                    tl.Descrizione,a.dataValuta, sum(isnull(b.ImportoNetto, 0)),dataPresuntoPagamento,dataNavDisinvestimento, ControvaloreDisinvestimento,
                    b.anagraficaID, a.numeroPratica
                    from puc001.PraticaLiquidazione a join pagamento b on a.numeropratica =b.numeropratica
                    join tipoliquidazione tl on tl.id = a.tipoLiquidazioneId
                    where a.PolizzaID= 7696501  and TipoLiquidazioneID = 1
                    and stato in ('I','L','P')
                    and dataEffettoPratica in (select max(dataEffettoPratica) from puc001.PraticaLiquidazione WHERE PolizzaID= 7696501 AND stato in ('I','L','P') and TipoLiquidazioneID = 1)
                    group by tl.Descrizione,a.dataValuta,dataPresuntoPagamento,dataNavDisinvestimento,ControvaloreDisinvestimento,b.anagraficaID,a.numeroPratica
                */

               puvVo= puc.getRiscattoTotaleByNumeroPratica(numeroPolizza);
               riscatto = getRiscatto(puvVo, new RiscattoTotale());
            }else{
               puvVo= puc.getRiscattoParzialeByNumeroPratica(numeroPolizza);
               riscatto = getRiscatto(puvVo,new RiscattoParziale());
            }
        } catch (ServiceException_Exception e) {
            throw new PucException(e);
        }
        return riscatto;
    }

    public Object getScadenza(Long numeroPolizza) throws PucException, DaoException {
        Scadenza scadenza;
        RiscattoVO puvVo;
        try {

            LoggingUtils.info("INIT GET SCADENZA");
            //puvVo= puc.getScadenzaByNumeroPolizza(numeroPolizza);
            puvVo= puc.getScadenzaByNumeroPolizza(numeroPolizza);
            LoggingUtils.info("POPOLATE GET SCADENZA");
            scadenza = getScadenza(puvVo, new Scadenza());
            LoggingUtils.info("END GET SCADENZA");

        } catch (ServiceException_Exception e) {
            LoggingUtils.info("Exception GET SCADENZA" + e);
            throw new PucException(e);
        }
        return scadenza;
    }

    public Object getScadenzaPeriodica(Long numeroPolizza) throws PucException, DaoException {
        Scadenza scadenza;
        RiscattoVO puvVo;
        try {

            puvVo= puc.getScadenzaPeriodicaByNumeroPolizza(numeroPolizza);
            scadenza = getScadenza(puvVo, new Scadenza());

        } catch (ServiceException_Exception e) {
            throw new PucException(e);
        }
        return scadenza;
    }

    public Object getSinistroAScadenza(Long numeroPolizza) throws PucException, DaoException {
        Scadenza scadenza;
        RiscattoVO puvVo;
        try {

            puvVo= puc.getSinistroAScadenzaByNumeroPolizza(numeroPolizza);
            scadenza = getScadenza(puvVo, new Scadenza());

        } catch (ServiceException_Exception e) {
            throw new PucException(e);
        }
        return scadenza;
    }


    public CommissioniFondiEsterni getCommissioniFondiEsperniByPolizza(Long polizzaId) throws PucException {
        try {
            CommissioniFEPolizzaVO commissioniFEPolizzaVO = puc.getCommissioniFEByPolizza(polizzaId);
            CommissioniFondiEsterni commissioniFondiEsterni = new CommissioniFondiEsterni();

            commissioniFondiEsterni.setDataInizioGestione(DateUtils.parseDate(DateUtils.getNullSefeCalendar(commissioniFEPolizzaVO.getDataInizioGestione()), Costanti.FORMATO_DATA));
            commissioniFondiEsterni.setDataInizioAnno(DateUtils.parseDate(DateUtils.getNullSefeCalendar(commissioniFEPolizzaVO.getDataInizioAnno()), Costanti.FORMATO_DATA));
            commissioniFondiEsterni.setDataInizioAccantonamento(DateUtils.parseDate(DateUtils.getNullSefeCalendar(commissioniFEPolizzaVO.getDataInizioAccantonamento()), Costanti.FORMATO_DATA));
            commissioniFondiEsterni.setQteAccantonateCG(commissioniFEPolizzaVO.getQteAccantonateCG().doubleValue());
            commissioniFondiEsterni.setQteAccantonateCG(commissioniFEPolizzaVO.getQteAccantonateCG().doubleValue());
            commissioniFondiEsterni.setQteAccantonateCM(commissioniFEPolizzaVO.getQteAccantonateCM().doubleValue());
            commissioniFondiEsterni.setQteDaInizioAnnoCG(commissioniFEPolizzaVO.getQteDaInizioAnnoCG().doubleValue());
            commissioniFondiEsterni.setQteDaInizioAnnoCM(commissioniFEPolizzaVO.getQteDaInizioAnnoCM().doubleValue());
            commissioniFondiEsterni.setQteDaInizioGestioneCG(commissioniFEPolizzaVO.getQteDaInizioGestioneCG().doubleValue());
            commissioniFondiEsterni.setQteDaInizioGestioneCM(commissioniFEPolizzaVO.getQteDaInizioGestioneCM().doubleValue());
            return commissioniFondiEsterni;
        } catch (ServiceException_Exception e) {
            throw new PucException(e);
        }
    }

    public Prestito getPresstitoByPolizza(Long polizzaId) throws PucException {
        try {
            DettaglioValorePrestitoVO vo=puc.getValorePrestitoByNumeroPolizza(polizzaId);
            //return new Prestito(0.00,0.00,"Fondo Previ");
            return new Prestito(vo.getImportoMassimoErogabile(),vo.getTassoDiRivalutazione(),vo.getTassoBase(),vo.getCodiceFondo());
        } catch (ServiceException_Exception e)  {
            throw new PucException(e);
        }
    }

    private Riscatto getRiscatto(RiscattoVO pucVo, Riscatto beanDestinazione){
        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setAnagraficaID(pucVo.getAnagraficaID());
        beneficiario.setBeneficiario(pucVo.getBeneficiario());
        beneficiario.setIban(pucVo.getIbanBeneficiario());

        beanDestinazione.setNumeroPratica(pucVo.getNumeroPratica());
        beanDestinazione.setBeneficiario(beneficiario);

        beanDestinazione.setDataPresuntoPagamento(DateUtils.parseDate(DateUtils.getNullSefeCalendar(pucVo.getDataPresuntoPagamento()),Costanti.FORMATO_DATA));
        beanDestinazione.setDataRiferimentoNAV(DateUtils.parseDate(DateUtils.getNullSefeCalendar(pucVo.getDataRiferimentoNAV()),Costanti.FORMATO_DATA));
        beanDestinazione.setDataValutaLiquidazione(DateUtils.parseDate(DateUtils.getNullSefeCalendar(pucVo.getDataValutaLiquidazione()),Costanti.FORMATO_DATA));

        beanDestinazione.setControvaloreRiscattato(pucVo.getControvaloreRiscattato());
        beanDestinazione.setImportoLiquidazioneNetta(pucVo.getImportoLiquidazioneNetta());
        return beanDestinazione;
    }

    private Scadenza getScadenza(RiscattoVO pucVo, Scadenza beanDestinazione){
        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setAnagraficaID(pucVo.getAnagraficaID());
        beneficiario.setBeneficiario(pucVo.getBeneficiario());
        beneficiario.setIban(pucVo.getIbanBeneficiario());

        beanDestinazione.setNumeroPratica(pucVo.getNumeroPratica());
        beanDestinazione.setBeneficiario(beneficiario);

        beanDestinazione.setDataPresuntoPagamento(DateUtils.parseDate(DateUtils.getNullSefeCalendar(pucVo.getDataPresuntoPagamento()),Costanti.FORMATO_DATA));
        beanDestinazione.setDataRiferimentoNAV(DateUtils.parseDate(DateUtils.getNullSefeCalendar(pucVo.getDataRiferimentoNAV()),Costanti.FORMATO_DATA));
        beanDestinazione.setDataValutaLiquidazione(DateUtils.parseDate(DateUtils.getNullSefeCalendar(pucVo.getDataValutaLiquidazione()),Costanti.FORMATO_DATA));

        beanDestinazione.setControvaloreRiscattato(pucVo.getControvaloreRiscattato());
        beanDestinazione.setImportoLiquidazioneNetta(pucVo.getImportoLiquidazioneNetta());
        beanDestinazione.setDescrizioneTipoRiscatto(pucVo.getDescrizioneTipoRiscatto());
        return beanDestinazione;
    }

    public String getAppendiceCambioContraenza(Long polizzaId) throws PucException {
        try {
            return puc.getAppendiceCambioContraenza(polizzaId);
        } catch (ServiceException_Exception e) {
            throw new PucException(e);
        }

    }



    public Object getDatiPolizza(Long numeroPolizza) throws PucException {
        Polizza target = new Polizza();
        target.setNumero(numeroPolizza+"");
        try {
            //target.setCollettiva(puc.checkPolizzaCollettiva(numeroPolizza+""));
            target.setCollettiva(puc.checkNumeroCollettiva(numeroPolizza+""));
            if(target.isCollettiva()){
                LoggingUtils.info("L'ID TROVATO APPARTIENE A UNA COLLETTIVA");
                try{
                    CollettivaVO collettiva = puc.getDatiTecniciCollettiva(numeroPolizza+"");
                    //provo ad usare ExPolizzaBuilder
                    InfoPolizzaVO polizza = new InfoPolizzaVO();
                    BeanUtils.copyProperties(polizza,collettiva);
                    return new ExPolizzaBuilder().getPolizza(target, polizza);
                }catch (NullPointerException e){
                    throw new PucException("NullPointerException in CollettivaVO restituito dal puc.getDatiTecniciCollettiva("+numeroPolizza+")",e);
                }

            }else{
                LoggingUtils.info("L'ID TROVATO APPARTIENE A UNA POLIZZA");
                InfoPolizzaVO polizza = puc.getDatiPolizzaByPolizza(numeroPolizza);
                return new ExPolizzaBuilder().getPolizza(target, polizza);
            }
        } catch (ServiceException_Exception e) {
            throw new PucException(e);
        } catch (InvocationTargetException e) {
            throw new PucException(e);
        } catch (IllegalAccessException e) {
            throw new PucException(e);
        }
    }


    public EstrattoConto getEstrattoConto(String numeroPolizza)throws PucException{
        try {
            EstrattoContoCollettiveVO estrattoPuc = puc.listEstrattoContoCollettive(numeroPolizza);

            EstrattoConto estrattoConto = new EstrattoConto();
            estrattoConto.setTotale(estrattoPuc.getSommaPremiCollettive().getTotaleSommaPremi());

            List<ElencoPremiIncassati> listaPremiPuc= estrattoPuc.getSommaPremiCollettive().getElencoPremiIncassati();
            List<Premio> premios= new ArrayList<Premio>();
            for(int i=0;i<listaPremiPuc.size();i++){
               Premio p = new Premio(listaPremiPuc.get(i).getElenco(),
                                     DateUtils.getNullSefeCalendar(listaPremiPuc.get(i).getDataInizioCopertura()),
                                     listaPremiPuc.get(i).getSommaPremi(),
                                     DateUtils.getNullSefeCalendar(listaPremiPuc.get(i).getDataIncasso()));
                premios.add(p);

            }
            estrattoConto.setPremios(premios);
            return estrattoConto;
        } catch (ServiceException_Exception e) {
            throw new PucException(e);
        }
    }

    private InputsBean  getInputsBean(DomandaVO domanda){
        return new InputsManager().getValoriInput(domanda.getValoriInput());
    }
    
    public Boolean checkSimulatoreProdotto(String polizza)throws PucException {
    	Boolean resp = false;
		try {
			resp = (Boolean)puc.checkSimulatoreProdotto(polizza);
		} catch (ServiceException_Exception e) {
			throw new PucException(e);
		}
    	return resp;
    }
}
