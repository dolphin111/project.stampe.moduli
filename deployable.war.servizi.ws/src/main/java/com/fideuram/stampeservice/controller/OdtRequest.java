package com.fideuram.stampeservice.controller;

import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.stampeservice.FaultBean;
import com.fideuram.stampeservice.StampeWsException;
import com.fideuram.utils.LoggingUtils;

/**
 * User: V801068
 * Date: 02/02/16
 * Time: 18.32
 */
public class OdtRequest {
    public byte[] stampa(String xml, int action) throws StampeWsException {
        try {
            return  (byte[]) new ControllerAction().elaborazioneODT(xml, action);
        } catch (DocGeneratorException e) {
        	LoggingUtils.error("Eccezione nell'elaborazione dell'ODT: " + e.getMessage());
        	throw new StampeWsException("Request PDF non trovata",new FaultBean("Request PDF non trovata") );
            
        }
    }
}
