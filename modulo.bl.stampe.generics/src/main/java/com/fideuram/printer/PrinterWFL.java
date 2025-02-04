package com.fideuram.printer;

import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.freemarker.Printer;
import com.fideuram.stampe.modello.workflowliquidativo.RifiutoWFL;

public class PrinterWFL  extends Printer {

    public PrinterWFL(int richiesta) {
		super(richiesta);
	}
    
    public PrinterWFL(RifiutoWFL rifiuto, int richiesta) throws TemplateLoaderExcepion {
        super(richiesta);
        this.object = rifiuto;
    }
    
 
}