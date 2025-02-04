package com.fideuram.processo.cud;

import java.util.HashMap;

import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.exception.cud.CUDException;
import com.fideuram.stampe.modello.cud.CUD;
import com.fideuram.utils.LoggingUtils;

public class Mod730 extends CUDBase{
	
private static final String mod730="CUD2014.odt";
	
    public Mod730() throws DocGeneratorException{
    	new CUDBase(Mod730.mod730);
    }
	
    public byte[] generateDocument(CUD doc) throws CUDException {
        
    	byte[] lbyte =null;
        try
        {	
        	LoggingUtils.debug("Generazione CUD");
        	
            HashMap map = new HashMap();
            map.put("Mod730", doc);
            lbyte = generatorePdf(map, mod730);
            
            LoggingUtils.debug("Modello 730 prodotto");
            
        } catch (DocGeneratorException e) {
        	LoggingUtils.error(mod730 + e.getMessage());
            throw new CUDException("Mod730.generateDocument: TemplateLoaderExcepion",e);
		}
        return lbyte;
    }

}
