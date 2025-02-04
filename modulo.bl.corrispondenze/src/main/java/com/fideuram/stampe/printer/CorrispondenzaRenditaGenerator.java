package com.fideuram.stampe.printer;

import java.io.File;
import java.util.HashMap;

import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.stampe.exeption.CorrispondenzaException;
import com.fideuram.stampe.modello.corrispondenza.TipoLettera;
import com.fideuram.utils.LoggingUtils;

/**
 * Created by
 * User: emrossi
 * Date: 07/04/14
 * Time: 9:02
 */
public class CorrispondenzaRenditaGenerator extends CorrispondenzaBase{
    

	
    public CorrispondenzaRenditaGenerator(String nomeTemplate) throws DocGeneratorException{
    	new CorrispondenzaBase(nomeTemplate+".odt");
    }
	
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public byte[] generateDocument(TipoLettera doc, String nomeTemplate) throws CorrispondenzaException {
        
    	byte[] lbyte =null;
        try
        {	
        	LoggingUtils.debug("Generazione TipoLettera");
        	
            HashMap map = new HashMap();
            map.put("TIPOLETTERA", doc);
            lbyte = generatorePdf(map, nomeTemplate);
            
            LoggingUtils.debug("TipoLettera prodotta");
            
        } catch (DocGeneratorException e) {
        	LoggingUtils.error(doc.getPolizza()+nomeTemplate + e.getMessage());
            LoggingUtils.error(e);
            throw new CorrispondenzaException("TipoLettera.generateDocument: TemplateLoaderExcepion",e);
		}
        return lbyte;
    }

}
