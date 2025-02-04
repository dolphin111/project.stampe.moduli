package com.fideuram.processo.cud;

import java.util.HashMap;

import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.exception.cud.CUDException;
import com.fideuram.stampe.modello.cud.CUD;
import com.fideuram.utils.LoggingUtils;

public class Mod770 extends CUDBase{
	
private static final String mod770="Mod770.odt";
	
    public Mod770() throws DocGeneratorException{
    	new CUDBase(Mod770.mod770);
    }
	
    public byte[] generateDocument(CUD doc) throws CUDException {
        
    	byte[] lbyte =null;
        try
        {	
        	LoggingUtils.debug("Generazione Modello 770");
        	
            HashMap map = new HashMap();
            map.put("Modello 770", doc);
            lbyte = generatorePdf(map, mod770);
            
            LoggingUtils.debug("Modello 770 prodotto");
            
        } catch (DocGeneratorException e) {
        	LoggingUtils.error(mod770 + e.getMessage());
            throw new CUDException("Mod770.generateDocument: TemplateLoaderExcepion",e);
		}
        return lbyte;
    }

}
