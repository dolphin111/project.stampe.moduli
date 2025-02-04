package com.fideuram.processo;

import com.fideuram.credenziali.controller.ControllerCredenziali;
import com.fideuram.exception.CredenzialiException;
import com.fideuram.jaxb.Converter;
import com.fideuram.stampe.modello.sicurezza.AreaRiservata;
import com.fideuram.utils.LoggingUtils;

import javax.xml.bind.JAXBException;

/**
 * User: V801068
 * Date: 01/02/16
 * Time: 12.09
 */
public class FacadeCredenziali {

    public byte[] stampa(String datiInXml, int richiesta) throws CredenzialiException {
           try{
             byte[] b= new ControllerCredenziali().elaboraProcesso(datiInXml,richiesta);
             return b;
           }catch (CredenzialiException e){
              LoggingUtils.error(e);
              throw e;
           }
    }

    private AreaRiservata parseXml2Bean(String datiInXml) throws ClassNotFoundException, InstantiationException, IllegalAccessException, JAXBException {
        AreaRiservata credenziali = new AreaRiservata();
        credenziali= (AreaRiservata) Converter.xml2Object(credenziali, datiInXml);
        return credenziali;
    }
}
