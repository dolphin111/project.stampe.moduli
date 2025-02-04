package com.fideuram.stampe.printer;

import java.io.File;
import java.util.HashMap;

import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.stampe.exeption.QuietanzaException;
import com.fideuram.stampe.modello.quietanza.Bonifico;
import com.fideuram.utils.LoggingUtils;

/**
 * Created by
 * User: logan
 * Date: 18/02/13
 * Time: 15.12
 */
public class BonificoGenerator extends QuietanzaBase{
    
	private static final String BONIFICO= "Bonifico.odt";
	
    public BonificoGenerator() throws DocGeneratorException{
    	new QuietanzaBase(BonificoGenerator.BONIFICO);
    }
	
    public byte[] generateDocument(Bonifico doc) throws QuietanzaException {
        
    	byte[] lbyte =null;
        try
        {	
        	LoggingUtils.debug("Generazione BONIFICO");
        	
            HashMap map = new HashMap();
            map.put("bonifico", doc);
            lbyte = generatorePdf(map, BONIFICO);
            
            LoggingUtils.debug("BONIFICO prodotto");
            
        } catch (DocGeneratorException e) {
        	LoggingUtils.error(doc.getProtocollo()+File.separator+BONIFICO + e.getMessage());
            throw new QuietanzaException("Bonifico.generateDocument: TemplateLoaderExcepion",e);
		}
        return lbyte;
    }

}
