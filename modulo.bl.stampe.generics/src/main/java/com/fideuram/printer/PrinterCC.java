package com.fideuram.printer;

import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.freemarker.Printer;
import com.fideuram.stampe.modello.contraenza.AppendiceCC;
import com.fideuram.stampe.modello.contraenza.CambioContraenza;
import com.fideuram.stampe.modello.contraenza.SollecitoCC;


/**
 * Created by V801068 on 14/05/14.
 */
public class PrinterCC extends Printer {

    public PrinterCC(CambioContraenza cambioContraenza, int richiesta) throws TemplateLoaderExcepion {
        super(richiesta);
        this.object = cambioContraenza;
    }

    public PrinterCC(SollecitoCC cambioContraenza, int richiesta) throws TemplateLoaderExcepion {
        super(richiesta);
        this.object = cambioContraenza;
    }

    public PrinterCC(AppendiceCC cambioContraenza, int richiesta) {
        super(richiesta);
        this.object = cambioContraenza;
    }
}
