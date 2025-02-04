package com.fideuram.crm.stampe.lettere;

import com.fideuram.crm.stampe.exception.StampeInfoException;
import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.puc.service.impl.ServiceException_Exception;
import com.fideuram.puc.service.impl.SpiAvvisoScadenzaVO;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.NumberUtils;


/**
 * User: acolone
 * Date: 27/09/2011
 */
public class LetteraAvvisiScadenza extends LetteraEngine{
    public LetteraAvvisiScadenza(int comID) throws WebServiceClientException {
        super(comID);
    }

    public void completaPolizza(Polizza polizza) throws StampeInfoException, PucException, WebServiceClientException {

        SpiAvvisoScadenzaVO vo = null;
        try {
            vo = pucS.getAvvisiScadenzaSPIByNumeroPolizza(new Long(polizza.getNumero()));
        } catch (ServiceException_Exception e) {
           throw new PucException(e);
        }

        polizza.setSituazionePremiQuote("NO");
        
        if(vo != null){
        	if(vo.getPolizzaID()!=null){
                polizza.setNumero(vo.getPolizzaID().toString());
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
            
            if(vo.getRenditaDaPiano()!=null){
                polizza.setPrestazioneGarantitaAllUltimaRivalutazione(NumberUtils.formatCurrency(
                        vo.getRenditaDaPiano(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            } else {
                polizza.setPrestazioneGarantitaAllUltimaRivalutazione("");
            }
            
            if(vo.getRenditaDaPianoAScadenza()!=null){
                polizza.setStimaRenditaDaPianoAScadenza(NumberUtils.formatCurrency(
                        vo.getRenditaDaPianoAScadenza(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            } else {
                polizza.setStimaRenditaDaPianoAScadenza("");
            }
            
            if(vo.getRenditaDaEstemporaneiAScadenza()!=null){
                polizza.setStimaRenditaDaEstemporaneiAScadenza(NumberUtils.formatCurrency(
                        vo.getRenditaDaEstemporaneiAScadenza(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            }else{
            	polizza.setStimaRenditaDaEstemporaneiAScadenza("");
            }
            
            if(vo.getBonusFedelta()!=null){
                polizza.setBonusFedelta(NumberUtils.formatCurrency(
                        vo.getBonusFedelta(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            } else {
                polizza.setBonusFedelta("");
            }

            if(vo.getBonusExtra()!=null){
                polizza.setBonusExtra(NumberUtils.formatCurrency(
                        vo.getBonusExtra(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            } else {
                polizza.setBonusExtra("");
            }
            //da verificare
            polizza.setRenditaAnnuaLordaScadenza("");
            
            if(vo.getRenditaTrimestrale()!=null){
                polizza.setRenditaTrimestrale(NumberUtils.formatCurrency(
                   vo.getRenditaTrimestrale(),
                   Costanti.SEPARATORE_MIGLIAIA,
                   Costanti.SEPARATORE_DECIMALI));
            } else {
                  polizza.setRenditaTrimestrale("");
            }
            
            if(vo.getRenditaSemestrale()!=null){
                polizza.setRenditaSemestrale(NumberUtils.formatCurrency(
                   vo.getRenditaSemestrale(),
                   Costanti.SEPARATORE_MIGLIAIA,
                   Costanti.SEPARATORE_DECIMALI));
            } else {
                  polizza.setRenditaSemestrale("");
            }
            
            if(vo.getRenditaCerta5Anni()!=null){
                polizza.setRenditaCerta5Anni(NumberUtils.formatCurrency(
                   vo.getRenditaCerta5Anni(),
                   Costanti.SEPARATORE_MIGLIAIA,
                   Costanti.SEPARATORE_DECIMALI));
            } else {
                  polizza.setRenditaCerta5Anni("");
            }

            if(vo.getRenditaCerta10Anni()!=null){
                polizza.setRenditaCerta10Anni(NumberUtils.formatCurrency(
                   vo.getRenditaCerta10Anni(),
                   Costanti.SEPARATORE_MIGLIAIA,
                   Costanti.SEPARATORE_DECIMALI));
            } else {
                  polizza.setRenditaCerta10Anni("");
            }
            
            if(vo.getCoefficienteCapitale()!=null){
                polizza.setCoefficienteCapitale(NumberUtils.format(vo.getCoefficienteCapitale(),Costanti.SEPARATORE_MIGLIAIA,Costanti.SEPARATORE_DECIMALI,5));
            }else{
            	polizza.setCoefficienteCapitale("");
            }
            
            if(vo.getCapitaleLordoInValuta()!=null){
                polizza.setCapitaleLordo(NumberUtils.formatCurrency(
                        vo.getCapitaleLordoInValuta(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            }else{
           	 polizza.setCapitaleLordo("");
            }
            
            if(vo.getDataCambio()!=null){
                polizza.setDataCambio(DateUtils.formatDate(vo.getDataCambio().toGregorianCalendar(), Costanti.FORMATO_DATA));
            } else {
                polizza.setDataCambio("");
            }
            
            if(vo.getCambioInEuro()!=null){
                polizza.setCambioInEuro(NumberUtils.formatCurrency(
                        vo.getCambioInEuro(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            }else{
           	 polizza.setCambioInEuro("");
            }
            
            if(vo.getCapitaleLordoInEuro()!=null){
                polizza.setCapitaleLordoInEuro(NumberUtils.formatCurrency(
                        vo.getCapitaleLordoInEuro(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            }else{
           	 polizza.setCapitaleLordoInEuro("");
            }
            
            if( vo.getPremiVersatiInEuro()!=null){
                polizza.setPremiVersatiInEuro(NumberUtils.formatCurrency(
                   vo.getPremiVersatiInEuro(),
                   Costanti.SEPARATORE_MIGLIAIA,
                   Costanti.SEPARATORE_DECIMALI));
            } else {
                   polizza.setPremiVersatiInEuro("");
            }
            
            if(vo.getDataElaborazione()!=null){
                polizza.setDataElaborazione(DateUtils.formatDate(vo.getDataElaborazione().toGregorianCalendar(), Costanti.FORMATO_DATA));
            } else {
                polizza.setDataElaborazione("");
            } 
            
            if(vo.getTotaleRendita()!=null){
            	polizza.setTotaleRendita(NumberUtils.formatCurrency(
                        vo.getTotaleRendita(),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));
            } else {
                polizza.setTotaleRendita("");
            } 
            
        }else{
            LoggingUtils.error(LetteraAvvisiScadenza.class + "completaPolizza per n° polizza: " + polizza +" Ha restituito SimulazioniPolizzaAScadenzaVO==null");
        }
    }
}