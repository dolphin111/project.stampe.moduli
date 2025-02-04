package com.fideuram.printer.freemarker;

import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.freemarker.Printer;
import com.fideuram.stampe.modello.sicurezza.AreaRiservata;

/**
 * User: V801068
 * Date: 22/09/14
 * Time: 15.51
 */
@Deprecated
public class PrinterSicurezza extends Printer {
    public PrinterSicurezza(AreaRiservata previdenza, int richiesta) throws TemplateLoaderExcepion {
        super(richiesta);
        this.object = previdenza;
    }
}
