package com.fideuram.crm.stampe.lettere;

import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.exception.StampeInfoException;
import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.puc.service.impl.*;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.NumberUtils;

/**
 * Created by IntelliJ IDEA.
 * User: logan
 * Date: 19/05/11
 * Time: 9.27
 */
public class LetteraSimulazioniSPI extends LetteraEngine{

    public LetteraSimulazioniSPI(int comID) throws WebServiceClientException {
        super(comID);
    }

    public void completaPolizza(Polizza polizza) throws WebServiceClientException, StampeInfoException, PucException {

        SimulazioniPolizzaAScadenzaVO vo = null;
        try {
            vo = pucS.getSimulazioniSpiByNumeroPolizza(new Long(polizza.getNumero()));
        } catch (ServiceException_Exception e) {
           throw new PucException(e);
        }
        polizza.setSituazionePremiQuote("NO");


        if(vo!=null){
            if ((vo.getMessaggio()!=null)&&(!vo.getMessaggio().trim().equals(""))) {
                throw new StampeInfoException(vo.getMessaggio());
            }

            if(vo.getNumeroPolizza()!=null){
                polizza.setNumero(vo.getNumeroPolizza().toString());
            }

            if(vo.getDivisa()!=null){
                polizza.setDivisa(vo.getDivisa());
            } else {
                polizza.setDivisa("");
            }

            if(vo.getDataDecorrenza()!=null){
                polizza.setDataDecorrenza(DateUtils.formatDate(vo.getDataDecorrenza().toGregorianCalendar(), Costanti.FORMATO_DATA));
            } else {
                polizza.setDataDecorrenza("");
            }

            if(vo.getDataScadenza()!=null){
                polizza.setDataScadenza(DateUtils.formatDate(vo.getDataScadenza().toGregorianCalendar(), Costanti.FORMATO_DATA));
            } else {
                polizza.setDataScadenza("");
            }

            if(vo.getDataRivalutazione()!=null){
                polizza.setDataRivalutazione(DateUtils.formatDate(vo.getDataRivalutazione().toGregorianCalendar(), Costanti.FORMATO_DATA));
            } else {
                polizza.setDataRivalutazione("");
            }

            if(vo.getPrestazioneGarantitaAllUltimaRivalutazione()!=null){
                polizza.setPrestazioneGarantitaAllUltimaRivalutazione(NumberUtils.formatCurrency(
                        vo.getPrestazioneGarantitaAllUltimaRivalutazione(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            } else {
                polizza.setPrestazioneGarantitaAllUltimaRivalutazione("");
            }

            if(vo.getPremiVersatiAdOggiInEuro()!=null){
                polizza.setPremiVersatiAdOggiInEuro(NumberUtils.formatCurrency(
                        vo.getPremiVersatiAdOggiInEuro(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            } else {
                polizza.setPremiVersatiAdOggiInEuro("");
            }
            
            if( vo.getPremiAggiuntiviVersatiAdOggi()!=null){
                polizza.setPremiAggiuntiviVersatiAdOggi(NumberUtils.formatCurrency(
                   vo.getPremiAggiuntiviVersatiAdOggi(),
                   Costanti.SEPARATORE_MIGLIAIA,
                   Costanti.SEPARATORE_DECIMALI));
            } else {
                   polizza.setPremiAggiuntiviVersatiAdOggi("");
            }

            if(vo.getRivalutazioneMinimaGarantita()!=null){
                polizza.setRivalutazioneMinimaGarantita(NumberUtils.formatCurrency(
                        vo.getRivalutazioneMinimaGarantita(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            } else {
                polizza.setRivalutazioneMinimaGarantita("");
            }

            IpotesiPianoConRecuperoVersamentiVO voPC = vo.getIpotesiPianoCompletato();
            IpotesiPianoSenzaRecuperoVersamentiVO voSPC = vo.getIpotesiPianoNonCompletato();



            if(voSPC!=null){
                 polizza.setCompletato(false);
                 if(voPC.getStimaTotaleRenditaAScadenza()!=null){
                     polizza.setStimaTotaleRenditaAScadenza(NumberUtils.formatCurrency(
                        voPC.getStimaTotaleRenditaAScadenza(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
                 } else {
                        polizza.setStimaTotaleRenditaAScadenza("");
                 }

                 if( voSPC.getStimaTotaleRenditaAScadenza()!=null){
                     polizza.setStimaRenditaDaPianoAScadenza(NumberUtils.formatCurrency(
                        voSPC.getStimaTotaleRenditaAScadenza(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
                 } else {
                        polizza.setStimaRenditaDaPianoAScadenza("");
                 }              

                 if(voSPC.getRenditaTrimestrale()!=null){
                     polizza.setRenditaTrimestrale(NumberUtils.formatCurrency(
                        voSPC.getRenditaTrimestrale(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
                 } else {
                       polizza.setRenditaTrimestrale("");
                 }

                 if(voSPC.getRenditaSemestrale()!=null){
                     polizza.setRenditaSemestrale(NumberUtils.formatCurrency(
                        voSPC.getRenditaSemestrale(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
                 } else {
                       polizza.setRenditaSemestrale("");
                 }

                 if(voSPC.getRenditaCerta5Anni()!=null){
                     polizza.setRenditaCerta5Anni(NumberUtils.formatCurrency(
                        voSPC.getRenditaCerta5Anni(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
                 } else {
                       polizza.setRenditaCerta5Anni("");
                 }

                 if(voSPC.getRenditaCerta10Anni()!=null){
                     polizza.setRenditaCerta10Anni(NumberUtils.formatCurrency(
                        voSPC.getRenditaCerta10Anni(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
                 } else {
                       polizza.setRenditaCerta10Anni("");
                 }

                if(voSPC.getCapitaleLordo()!=null){
                     polizza.setCapitaleLordo(NumberUtils.formatCurrency(
                             voSPC.getCapitaleLordo(),
                             Costanti.SEPARATORE_MIGLIAIA,
                             Costanti.SEPARATORE_DECIMALI));
                 }else{
                	 polizza.setCapitaleLordo("");
                 }
                if(voSPC.getStimaRrenditaDaEstemporaneiAScadenza() != null){
                	polizza.setStimaRenditaDaEstemporaneiAScadenza2(NumberUtils.formatCurrency(
                			voSPC.getStimaRrenditaDaEstemporaneiAScadenza(),
                            Costanti.SEPARATORE_MIGLIAIA,
                            Costanti.SEPARATORE_DECIMALI));
                }

            }else{
            	polizza.setCompletato(true);
            }

            if(voPC.getSommaPremiResiduiDaVersare()!=null){
                polizza.setSommaPremiResiduiDaVersare(NumberUtils.formatCurrency(
                        voPC.getSommaPremiResiduiDaVersare(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            } else {
                polizza.setSommaPremiResiduiDaVersare("");
            }


            if(voPC.getStimaTotaleRenditaAScadenza()!=null){
                polizza.setStimaTotaleRenditaAScadenza(NumberUtils.formatCurrency(
                        voPC.getStimaTotaleRenditaAScadenza(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            } else {
                polizza.setStimaTotaleRenditaAScadenza("");
            }

            if(voPC.getStimaRrenditaDaEstemporaneiAScadenza()!=null){
                polizza.setStimaRenditaDaEstemporaneiAScadenza(NumberUtils.formatCurrency(
                        voPC.getStimaRrenditaDaEstemporaneiAScadenza(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            }else{
            	polizza.setStimaRenditaDaEstemporaneiAScadenza("");
            }

            if(voPC.getBonusFedelta()!=null){
                polizza.setBonusFedelta(NumberUtils.formatCurrency(
                        voPC.getBonusFedelta(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            } else {
                polizza.setBonusFedelta("");
            }

            if(voPC.getBonusExtra()!=null){
                polizza.setBonusExtra(NumberUtils.formatCurrency(
                        voPC.getBonusExtra(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            } else {
                polizza.setBonusExtra("");
            }

            if(voPC.getRenditaTrimestrale()!=null){
                polizza.setRenditaTrimestrale2(NumberUtils.formatCurrency(
                        voPC.getRenditaTrimestrale(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            } else {
                polizza.setRenditaTrimestrale2("");
            }

            if(voPC.getRenditaSemestrale()!=null){
                polizza.setRenditaSemestrale2(NumberUtils.formatCurrency(
                        voPC.getRenditaSemestrale(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            } else {
                polizza.setRenditaSemestrale2("");
            }

            if(voPC.getRenditaCerta5Anni()!=null){
                polizza.setRenditaCerta5Anni2(NumberUtils.formatCurrency(
                        voPC.getRenditaCerta5Anni(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            } else {
                polizza.setRenditaCerta5Anni2("");
            }

            if(voPC.getRenditaCerta10Anni()!=null){
                 polizza.setRenditaCerta10Anni2(NumberUtils.formatCurrency(
                        voPC.getRenditaCerta10Anni(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            }  else {
                polizza.setRenditaCerta10Anni2("");
            }

            if(voPC.getCapitaleLordo()!=null){
                polizza.setCapitaleLordo2(NumberUtils.formatCurrency(
                        voPC.getCapitaleLordo(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            }else{
            	polizza.setCapitaleLordo2("");
            }


        }else{
            LoggingUtils.error(LetteraSimulazioniSPI.class + "completaPolizza per n° polizza: " + polizza +" Ha restituito SimulazioniPolizzaAScadenzaVO==null");
        }
    }
}
