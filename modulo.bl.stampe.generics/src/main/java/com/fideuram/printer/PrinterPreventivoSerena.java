package com.fideuram.printer;

import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.freemarker.Printer;
import com.fideuram.stampe.modello.preventivi.Preventivo;

/**
 * User: V801068
 * Date: 22/07/14
 * Time: 8.22
 */
public class PrinterPreventivoSerena  extends Printer {
    public PrinterPreventivoSerena(Preventivo preventivo, int richiesta) throws TemplateLoaderExcepion {
        super(richiesta);
        this.object = preventivo;
    }
}
