package com.fideuram.stampeservice.controller;

import com.fideuram.costanti.Errori;
import com.fideuram.crm.stampe.engine.processi.IdentificatoreProcesso;
import com.fideuram.decoder.MapperProcessiCrm;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.stampeservice.FaultBean;
import com.fideuram.stampeservice.StampeWsException;
import com.fideuram.utils.LoggingUtils;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 03/02/16
 * Time: 10.35
 * To change this template use File | Settings | File Templates.
 */
public class ActionDecoder {
    public static int decode(String action) throws StampeWsException {
        LoggingUtils.info("Richiesta in input: " + action);
        Integer azione;
        try{
            azione=new Integer(action).intValue();
        }catch (Exception e){
            azione = MapperProcessiCrm.decodeProcess(action);
            if(null==azione)
                azione= IdentificatoreProcesso.getProcesso(action);
            if(null==azione)
                throw new StampeWsException(Errori.ERROR_TYPE, new FaultBean(e.getMessage()));
        }
        LoggingUtils.info("Richiesta Decodificata: " + azione);
        return azione;
    }
}
