package com.fideuram.printer;

import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.freemarker.Printer;
import com.fideuram.stampe.modello.richiestaDocumentiMancantiSinistro.RichiestaDocumentiMancantiSinistro;


/**
 * Created by V801098 on 14/05/14.
 */
public class PrinterRDMS extends Printer {

	
    public PrinterRDMS(int richiesta) {
		super(richiesta);
	}

	public PrinterRDMS(RichiestaDocumentiMancantiSinistro richiestaDocumentiMancantiSinistro, int richiesta) throws TemplateLoaderExcepion {
        super(richiesta);
        this.object = richiestaDocumentiMancantiSinistro;
    }
 

}
