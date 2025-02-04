package com.fideuram.controllers;

import com.fideuram.attori.bo.IPersona;
import com.fideuram.attori.bo.impl.Altro;
import com.fideuram.attori.bo.impl.Contraente;
import com.fideuram.attori.bo.impl.Destinatari;
import com.fideuram.attori.bo.impl.PrivateBanker;
import com.fideuram.attori.controller.IDestinatariLettera;
import com.fideuram.controllers.managers.DisaccoppiatoreLettera;
import com.fideuram.crm.vo.ComunicazioneVO;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.crm.vo.PolizzaVO;
import com.fideuram.exception.crm.DestinatariException;
import com.fideuram.exception.ws.CrmException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.puc.service.impl.StampeServiceImpl;
import com.fideuram.utils.LoggingUtils;

/**
 * Created by
 * User: logan
 * Date: 06/10/11
 * Time: 12.09
 */
public class DestinatariLettera implements IDestinatariLettera {
    private static String CANALE_WEB="Web";
    private DisaccoppiatoreLettera disaccoppiatoreServizi;
    private IPersona proponente;
    private IPersona richiedente;
    private IPersona altro;
    private boolean isPB=false;
    private boolean isContraente=false;
    private ComunicazioneVO comunicazioneVO;

    public DestinatariLettera(ComunicazioneVO c,StampeServiceImpl pucS) throws WebServiceClientException {
        this(pucS);
        this.comunicazioneVO=c;
    }

    public DestinatariLettera(StampeServiceImpl pucS) throws WebServiceClientException {
        disaccoppiatoreServizi = new DisaccoppiatoreLettera(pucS);
    }



    public Destinatari configuraDestinatariCollettive(String numeroCollettiva) throws DestinatariException {
       Destinatari d= new Destinatari();
       //d.setProponente(new DaoDestinatariLettera().getContranteCollettiva(numeroCollettiva));
       d.setProponente(disaccoppiatoreServizi.getContranteCollettiva(numeroCollettiva));
       return d;
    }

    public Destinatari configuraDestinatari() throws  DestinatariException {
        LoggingUtils.info("DESTINATARI COMUNICAZIONE >>>>> " + comunicazioneVO.getID());
        DomandaVO domandaVO  = comunicazioneVO.getDomande().get(0);
        try {
            setProponente(comunicazioneVO);
            setRichiedente(comunicazioneVO);
            return configuraBean(domandaVO, comunicazioneVO);
        } catch (CrmException e) {
            throw new DestinatariException(e);
        }
    }


    /**
     *
     */
    private Destinatari configuraBean(DomandaVO domandaVO, ComunicazioneVO comunicazioneVO) throws CrmException, DestinatariException {
        Destinatari destinatari = new Destinatari();
        destinatari.setProponente(proponente);

        //if(comunicazioneVO.getCanale().getDescrizione().equalsIgnoreCase(CANALE_WEB)) {
        if(needOnlyPbOrContraenteAsProponente(comunicazioneVO)){
           if(proponente instanceof PrivateBanker || proponente instanceof Contraente)
             return destinatari;
           else
             throw new CrmException("Errore: Canale WEB o domanda " + comunicazioneVO.getDomande().get(0).getDescrizioneDomandaOriginaleId() + " non corrisponde il Proponente che deve essere un PrivateBanker o il Contraente");
        }

        destinatari.setRichiedente(richiedente);
        if(isPB==false){
             if(!(proponente instanceof Contraente)||!(richiedente instanceof Altro)){
                if(isWithPolizza(comunicazioneVO))
                  destinatari.addPerConoscenza(getPrivateBanker(domandaVO.getPolizze().get(0)));
             }
        }
        if(isContraente==false){
             if ((proponente instanceof PrivateBanker)){
             }else if((proponente instanceof PrivateBanker)&&(richiedente instanceof Altro)){
             }else if((proponente instanceof PrivateBanker)&&(richiedente instanceof PrivateBanker)){
             } else{
                if(isWithPolizza(comunicazioneVO))
                  destinatari.addPerConoscenza(getContraente(domandaVO.getPolizze().get(0)));
            }
        }
        return destinatari;
    }

    private IPersona getPrivateBanker(PolizzaVO polizzaVO) throws   DestinatariException {
        return disaccoppiatoreServizi.getPrivateBankerByPolizza(polizzaVO);
    }

     private IPersona getContraente(PolizzaVO polizzaVO) throws DestinatariException {
        return disaccoppiatoreServizi.getContraenteByPolizza(polizzaVO);
    }

    /**
     * Restituisce il proponente
     *
     * @param comunicazioneVO
     * @return
     */
    private void setProponente(ComunicazioneVO comunicazioneVO) throws  DestinatariException {
        proponente = disaccoppiatoreServizi.getProponenteByComunicazione(comunicazioneVO);
        if(proponente instanceof PrivateBanker) isPB=true;
        if(proponente instanceof Contraente) isContraente=true;
    }


    /**
     *
     */
    private void setRichiedente(ComunicazioneVO comunicazioneVO) throws DestinatariException {
        richiedente = disaccoppiatoreServizi.getRichiedenteByComunicazioneDomanda(comunicazioneVO, comunicazioneVO.getDomande().get(0));
        if(richiedente instanceof PrivateBanker) isPB=true;
        if(richiedente instanceof Contraente) isContraente=true;
    }



    private boolean isWithPolizza(ComunicazioneVO comunicazioneVO){
        if((comunicazioneVO.getDomande().get(0).getPolizze()!=null)&&
          (comunicazioneVO.getDomande().get(0).getPolizze().size()>0)){
           return true;
        }
        return false;
    }

    private boolean needOnlyPbOrContraenteAsProponente(ComunicazioneVO comunicazioneVO){
        int nuovaTripletta=comunicazioneVO.getDomande().get(0).getDescrizioneDomandaOriginaleId();
        if(comunicazioneVO.getCanale().getDescrizione().equalsIgnoreCase(CANALE_WEB))
            return true;
        if(nuovaTripletta==915||nuovaTripletta==916){
            return true;
        }
        return false;
    }

}
