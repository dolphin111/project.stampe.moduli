package com.fideuram.credenziali.controller;

import com.fideuram.costanti.Errori;
import com.fideuram.credenziali.parser.PinVo2AreaRiservata;
import com.fideuram.exception.CredenzialiException;
import com.fideuram.jaxb.Converter;
import com.fideuram.printer.itext.PrinterCredenziali;
import com.fideuram.stampe.modello.sicurezza.AreaRiservata;
import com.fideuram.utils.LoggingUtils;
import com.itextpdf.text.DocumentException;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 01/02/16
 * Time: 14.22
 */
public class ControllerCredenziali {
    public byte[] elaboraProcesso(String xml,int azione) throws CredenzialiException {
        LoggingUtils.debug("ControllerActions 1.0.0 - Azione richiesta: " + azione);
        try{

             AreaRiservata areaRiservata;
             try{
                 areaRiservata = (AreaRiservata) Converter.xml2Object(new AreaRiservata(), xml);
             }catch (Exception e){
                 areaRiservata = new PinVo2AreaRiservata().getAreaRiservata(xml);
             }
             return new PrinterCredenziali(areaRiservata,azione).start();

        } catch (DocumentException e) {
            throw new CredenzialiException(Errori.ERROR_DOCUMENT);
        } catch (IOException e) {
            throw new CredenzialiException(Errori.ERROR_IO);
        }
    }
}
