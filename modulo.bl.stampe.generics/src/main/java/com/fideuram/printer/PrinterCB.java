package com.fideuram.printer;

import com.fideuram.freemarker.Printer;
import com.fideuram.stampe.modello.contraenza.CambioBenficiario;
import com.fideuram.utils.LoggingUtils;

/**
 * User: V801068
 * Date: 17/06/15
 * Time: 16.47
 */
public class PrinterCB extends Printer {

    public PrinterCB(CambioBenficiario cambioBenficiario,int richiesta) {
        super(richiesta);
        LoggingUtils.info("PrinterCB - printer cambio beneficiario");
        this.object = cambioBenficiario;
    }
}
