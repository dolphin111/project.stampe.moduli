package com.fideuram.printer;

import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.freemarker.Printer;
import com.fideuram.stampe.modello.richiestaFacta.RichiestaFacta;


/**
 * Created by FrancescoD. on 16/10/18.
 */
public class PrinterFacta extends Printer {

	
    public PrinterFacta(int richiesta) {
		super(richiesta);
	}

	public PrinterFacta(RichiestaFacta richiestaFacta, int richiesta) throws TemplateLoaderExcepion {
        super(richiesta);
        this.object = richiestaFacta;
    }
 

}
