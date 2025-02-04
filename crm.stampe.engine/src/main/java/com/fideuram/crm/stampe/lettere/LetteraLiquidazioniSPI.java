package com.fideuram.crm.stampe.lettere;

import com.fideuram.crm.stampe.exception.StampeInfoException;
import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.crm.stampe.model.Imposta;
import com.fideuram.crm.stampe.model.Modello;
import com.fideuram.crm.stampe.model.PraticaSpiegazioneConteggi;
import com.fideuram.crm.stampe.model.spiegazioneConteggioRamoI.SpiegazioneConteggiRamoI;
import com.fideuram.crm.vo.ComunicazioneVO;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.puc.service.impl.DettaglioFiscalitaPolizzeVO;
import com.fideuram.puc.service.impl.LiquidazionePolizzaVO;
import com.fideuram.puc.service.impl.ServiceException_Exception;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.NumberUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * User: logan
 * Date: 12/05/11
 * Time: 16.04
 */
public class LetteraLiquidazioniSPI extends LetteraEngine{
    public LetteraLiquidazioniSPI(int comID) throws WebServiceClientException {
        super(comID);
    }

    public void completaPolizza(Polizza polizza)
            throws StampeInfoException, WebServiceClientException, PucException {

        LiquidazionePolizzaVO vo = null;
        try {
            vo = pucS.getLiquidazioniSPIByNumeroPolizza(new Long(polizza.getNumero()));


        polizza.setSituazionePremiQuote("NO");
        String codicePratica="";
        if (vo != null) {

            if (vo.getNumeroPratica() !=null || (!vo.getNumeroPratica().equals("")) )
                codicePratica= vo.getNumeroPratica().toString();

            if ((vo.getMessaggio()!=null)&&(!vo.getMessaggio().trim().equals(""))) {
               // throw new LiquidazioneSPIException("QUESTA POLIZZA È GIÀ STATA LIQUIDATA " + polizza.getNumero());
                throw new StampeInfoException(vo.getMessaggio());
            }

            if(vo.getNumeroPolizza()!=null){
                polizza.setNumero(vo.getNumeroPolizza().toString());
            }

            if (vo.getDivisa() != null) {
                polizza.setDivisa(vo.getDivisa());
            }else{
                polizza.setDivisa("");
            }
            if (vo.getProdotto() != null) {
                polizza.setProdotto(vo.getProdotto());
            }else{
                polizza.setProdotto("");
            }
            if (vo.getTariffa() != null) {
                polizza.setTariffa(vo.getTariffa());
            }else {
                polizza.setTariffa("");
            }

            if (vo.getDataDecorrenza() != null) {
                polizza.setDataDecorrenza(DateUtils.formatDate(vo.getDataDecorrenza().toGregorianCalendar(), Costanti.FORMATO_DATA));
            }else {
                polizza.setDataDecorrenza("");
            }

            if (vo.getDataScadenza() != null) {
                polizza.setDataScadenza(DateUtils.formatDate(vo.getDataScadenza().toGregorianCalendar(), Costanti.FORMATO_DATA));
            }else {
                polizza.setDataScadenza("");
            }

            if (vo.getDataNascitaAssicurato() != null) {
                polizza.setDataNascitaAssicurato(DateUtils.formatDate(vo.getDataNascitaAssicurato().toGregorianCalendar(), Costanti.FORMATO_DATA));
            }else {
                polizza.setDataNascitaAssicurato("");
            }

            if (vo.getSesso() != null) {
                polizza.setSesso(vo.getSesso());
            }else{
                polizza.setSesso("");
            }

            if (vo.getDataRivalutazione() != null) {
                polizza.setDataRivalutazione(DateUtils.formatDate(vo.getDataRivalutazione().toGregorianCalendar(), Costanti.FORMATO_DATA));
            }else {
                polizza.setDataRivalutazione("");
            }

            if (vo.getRenditaDaPiano() != null) {
                polizza.setRenditaDaPiano(NumberUtils.formatCurrency(
                        vo.getRenditaDaPiano(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            }else{
                polizza.setRenditaDaPiano("");
            }

            if (vo.getRenditaDaEstemporanei() != null) {
                polizza.setRenditaDaEstemporanei(NumberUtils.formatCurrency(
                        vo.getRenditaDaEstemporanei(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            }else {
                polizza.setRenditaDaEstemporanei("");
            }

            if (vo.getTassoLordoRivalutazione() != null) {
                polizza.setTassoLordoRivalutazione(NumberUtils.formatCurrency(
                        vo.getTassoLordoRivalutazione(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            }else {
                polizza.setTassoLordoRivalutazione("");
            }

            if (vo.getTassoNettoRivalutazione() != null) {
               polizza.setTassoNettoRivalutazione(NumberUtils.formatCurrency(
                        vo.getTassoNettoRivalutazione(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            }else{
               polizza.setTassoNettoRivalutazione("");
            }

            if (vo.getBonusFedelta() != null) {
                polizza.setBonusFedelta(NumberUtils.formatCurrency(
                        vo.getBonusFedelta(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            }else{
                 polizza.setBonusFedelta("");
            }

            if (vo.getBonusExtra() != null) {
                polizza.setBonusExtra(NumberUtils.formatCurrency(
                        vo.getBonusExtra(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            }else {
                polizza.setBonusExtra("");
            }

            if (vo.getTotaleRendita() != null) {
                polizza.setTotaleRendita(NumberUtils.formatCurrency(
                        vo.getTotaleRendita(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            }else {
                polizza.setTotaleRendita("");
            }

            if (vo.getCoefficienteCapitale() != null) {

                polizza.setCoefficienteCapitale(NumberUtils.format(vo.getCoefficienteCapitale(),
                                                Costanti.SEPARATORE_MIGLIAIA,Costanti.SEPARATORE_DECIMALI,5));
            }else {
                polizza.setCoefficienteCapitale("");
            }

            if (vo.getCapitaleLordoInValuta() != null) {
                polizza.setCapitaleLordoInValuta(NumberUtils.formatCurrency(
                        vo.getCapitaleLordoInValuta(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            }else {
                polizza.setCapitaleLordoInValuta("");
            }

            if (vo.getCambioInEuro() != null) {

               polizza.setCambioInEuro(NumberUtils.format(vo.getCambioInEuro(),Costanti.SEPARATORE_MIGLIAIA,Costanti.SEPARATORE_DECIMALI,4));

            }else {
                polizza.setCambioInEuro("");
            }

            if (vo.getCapitaleLordoInEuro() != null) {
                 polizza.setCapitaleLordoInEuro(NumberUtils.formatCurrency(
                        vo.getCapitaleLordoInEuro(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            }else {
                polizza.setCapitaleLordoInEuro("");
            }

            if (vo.getPremiVersatiInEuro() != null) {
                polizza.setPremiVersatiInEuro(NumberUtils.formatCurrency(
                        vo.getPremiVersatiInEuro(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            }else {
                polizza.setPremiVersatiInEuro("");
            }

            if (vo.getRenditaTrimestrale() != null) {
                polizza.setRenditaTrimestrale(NumberUtils.formatCurrency(
                        vo.getRenditaTrimestrale(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            }else{
                polizza.setRenditaTrimestrale("");
            }

            if (vo.getRenditaSemestrale() != null) {
                polizza.setRenditaSemestrale(NumberUtils.formatCurrency(
                        vo.getRenditaSemestrale(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            }else {
                polizza.setRenditaSemestrale("");
            }

            if (vo.getRenditaCerta5Anni() != null) {
                polizza.setRenditaCerta5Anni(NumberUtils.formatCurrency(
                        vo.getRenditaCerta5Anni(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            }else {
                polizza.setRenditaCerta5Anni("");
            }

            if (vo.getRenditaCerta10Anni() != null) {
                polizza.setRenditaCerta10Anni(NumberUtils.formatCurrency(
                        vo.getRenditaCerta10Anni(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            }else {
                polizza.setRenditaCerta10Anni("");
            }

            if (vo.getGuadagno() != null) {
                polizza.setGuadagno(NumberUtils.formatCurrency(
                        vo.getGuadagno(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            }else {
                polizza.setGuadagno("");
            }


            List<DettaglioFiscalitaPolizzeVO> listaDatiFiscalita=pucS.listDettaglioFiscalitaPolizzeChiuseByNumeroPratica(codicePratica);
            PraticaSpiegazioneConteggi spiegazioneConteggi= new PraticaSpiegazioneConteggi();
            ArrayList<PraticaSpiegazioneConteggi> listaSpiegazioneConteggi = new ArrayList<PraticaSpiegazioneConteggi>();
            for (int i=0; i< listaDatiFiscalita.size(); i++) {
                DettaglioFiscalitaPolizzeVO beanFiscalita= listaDatiFiscalita.get(i);
                //Tipo L sta ad indicare il Bollo
                if (beanFiscalita.getTipoImposta().equalsIgnoreCase("L")){
                    spiegazioneConteggi.setImpostaBolloFiscalita(NumberUtils.formatQuote(
                            beanFiscalita.getImposta(),
                            Costanti.SEPARATORE_MIGLIAIA,
                            Costanti.SEPARATORE_DECIMALI));
                }

                Imposta beanImposta =new Imposta();
                beanImposta.setImponibileLordoAltriInvestimentiPost2012(NumberUtils.formatQuote(
                        beanFiscalita.getImponibileLordoAltriInvestimentiPost2012(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));

                beanImposta.setImponibileLordoAltriInvestimentiPost2014(NumberUtils.formatQuote(
                        beanFiscalita.getImponibileLordoAltriInvestimentiPost2014(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));

                beanImposta.setImponibileLordoAnte2012(NumberUtils.formatQuote(
                        beanFiscalita.getImponibileLordoAnte2012(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));

                beanImposta.setImposta(NumberUtils.formatQuote(
                        beanFiscalita.getImposta(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));


                beanImposta.setImponibileLordoPost2012(NumberUtils.formatQuote(
                        beanFiscalita.getImponibileLordoPost2012(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));


                beanImposta.setImponibileLordoPost2014(NumberUtils.formatQuote(
                        beanFiscalita.getImponibileLordoPost2014(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));


                //Percentuale
                beanImposta.setPercentualeTitoliDiStatoPost2012(NumberUtils.formatQuote(
                        beanFiscalita.getPercentualeTitoliDiStatoPost2012(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
                //Percentuale
                beanImposta.setPercentualeTitoliDiStatoPost2014(NumberUtils.formatQuote(
                        beanFiscalita.getPercentualeTitoliDiStatoPost2014(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));


                beanImposta.setImponibileLordoTitoliDiStatoPost2012(NumberUtils.formatQuote(
                        beanFiscalita.getImponibileLordoTitoliDiStatoPost2012(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));

                beanImposta.setImponibileLordoTitoliDiStatoPost2014(NumberUtils.formatQuote(
                        beanFiscalita.getImponibileLordoTitoliDiStatoPost2014(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));

                beanImposta.setPercentualeVisentin(String.valueOf(beanFiscalita.getPercentualeVisentin() + "%"));


                beanImposta.setRiduzioneVisentinAnte2012(NumberUtils.formatQuote(
                        beanFiscalita.getRiduzioneVisentinAnte2012(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));



                beanImposta.setTotaleImponibileLordo(NumberUtils.formatQuote(
                        beanFiscalita.getTotaleImponibileLordo(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));

                beanImposta.setTotaleRiduzionePerPeriodo(NumberUtils.formatQuote(
                        beanFiscalita.getTotaleRiduzionePerPeriodo(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));

                beanImposta.setRiduzionePerTitoliDiStatoPost2012(NumberUtils.formatQuote(
                        beanFiscalita.getRiduzionePerTitoliDiStatoPost2012(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));

                beanImposta.setRiduzionePerTitoliDiStatoPost2014(NumberUtils.formatQuote(
                        beanFiscalita.getRiduzionePerTitoliDiStatoPost2014(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));

                beanImposta.setTotaleRiduzionePerTitoliDiStato(NumberUtils.formatQuote(
                        beanFiscalita.getTotaleRiduzionePerTitoliDiStato(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));

                beanImposta.setTotaleImponibileRidotto(NumberUtils.formatQuote(
                        beanFiscalita.getTotaleImponibileRidotto(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));




                beanImposta.setRiduzioneVisentinAnte2012(NumberUtils.formatQuote(
                        beanFiscalita.getRiduzioneVisentinAnte2012(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));


                beanImposta.setRiduzionePerTitoliDiStatoPost2012(NumberUtils.formatQuote(
                        beanFiscalita.getRiduzionePerTitoliDiStatoPost2012(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));

                beanImposta.setRiduzionePerTitoliDiStatoPost2014(NumberUtils.formatQuote(
                        beanFiscalita.getRiduzionePerTitoliDiStatoPost2014(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));

                beanImposta.setRiduzioneVisentinTitoliDiStatoPost2012(NumberUtils.formatQuote(
                        beanFiscalita.getRiduzioneVisentinTitoliDiStatoPost2012(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));


                beanImposta.setRiduzioneVisentinTitoliDiStatoPost2014(NumberUtils.formatQuote(
                        beanFiscalita.getRiduzioneVisentinTitoliDiStatoPost2014(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));

                beanImposta.setRiduzioneVisentinAltriInvestimentiPost2012(NumberUtils.formatQuote(
                        beanFiscalita.getRiduzioneVisentinAltriInvestimentiPost2012(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));


                beanImposta.setRiduzioneVisentinAltriInvestimentiPost2014(NumberUtils.formatQuote(
                        beanFiscalita.getRiduzioneVisentinAltriInvestimentiPost2014(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));


                beanImposta.setRiduzioneVisentinTitoliDiStatoPost2014(NumberUtils.formatQuote(
                        beanFiscalita.getRiduzioneVisentinTitoliDiStatoPost2014(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));




                beanImposta.setRiduzionePerPeriodoAnte2012(NumberUtils.formatQuote(
                        beanFiscalita.getRiduzionePerPeriodoAnte2012(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));



                beanImposta.setRiduzionePerPeriodoAltriInvestimentiçPost2012(NumberUtils.formatQuote(
                        beanFiscalita.getRiduzionePerPeriodoAltriInvestimentiçPost2012(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));



                beanImposta.setImponibileRidottoAltriInvestimentiPost2014(NumberUtils.formatQuote(
                        beanFiscalita.getImponibileRidottoAltriInvestimentiPost2014(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));


                beanImposta.setImponibileRidottoAltriInvestimentiPost2014(NumberUtils.formatQuote(
                        beanFiscalita.getImponibileRidottoAltriInvestimentiPost2012(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));


                beanImposta.setImponibileRidottoAnte2012(NumberUtils.formatQuote(
                        beanFiscalita.getImponibileRidottoAnte2012(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));

                beanImposta.setImponibileRidottoTitoliDiStatoPost2012(NumberUtils.formatQuote(
                        beanFiscalita.getImponibileLordoTitoliDiStatoPost2012(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));

                beanImposta.setImponibileRidottoTitoliDiStatoPost2014(NumberUtils.formatQuote(
                        beanFiscalita.getImponibileLordoTitoliDiStatoPost2014(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));


                beanImposta.setRiduzionePerTitoliDiStatoPost2012(NumberUtils.formatQuote(
                        beanFiscalita.getRiduzionePerTitoliDiStatoPost2012(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));

                beanImposta.setRiduzionePerTitoliDiStatoPost2014(NumberUtils.formatQuote(
                        beanFiscalita.getRiduzionePerTitoliDiStatoPost2014(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));

                beanImposta.setImponibileRidottoAnte2012(NumberUtils.formatQuote(
                        beanFiscalita.getImponibileRidottoAnte2012(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));

                beanImposta.setImponibileRidottoTitoliDiStatoPost2012(NumberUtils.formatQuote(
                        beanFiscalita.getImponibileRidottoTitoliDiStatoPost2012(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
                beanImposta.setImponibileRidottoAltriInvestimentiPost2012(NumberUtils.formatQuote(
                        beanFiscalita.getImponibileRidottoAltriInvestimentiPost2012(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));

                beanImposta.setImponibileRidottoTitoliDiStatoPost2014(NumberUtils.formatQuote(
                        beanFiscalita.getImponibileRidottoTitoliDiStatoPost2014(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));

                beanImposta.setImponibileRidottoAltriInvestimentiPost2014(NumberUtils.formatQuote(
                        beanFiscalita.getImponibileRidottoAltriInvestimentiPost2014(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));


                beanImposta.setTotaleRiduzioneVisentin(NumberUtils.formatQuote(
                        beanFiscalita.getTotaleRiduzioneVisentin(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));



                if (beanFiscalita.getTipoImposta().equalsIgnoreCase("7")){
                    spiegazioneConteggi.setTabellaImpostaSostitutiva(beanImposta);
                }
                if (beanFiscalita.getTipoImposta().equalsIgnoreCase("3")){
                    spiegazioneConteggi.setTabellaRitenutaImposta(beanImposta);
                }


            }
            listaSpiegazioneConteggi.add(spiegazioneConteggi);
            polizza.setListaPraticheConteggi(listaSpiegazioneConteggi);

        }
        } catch (ServiceException_Exception e) {
            throw new PucException(e.getCause());
        }

    }


}
