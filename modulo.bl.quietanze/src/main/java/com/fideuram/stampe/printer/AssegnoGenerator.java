package com.fideuram.stampe.printer;

import java.util.HashMap;

import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.stampe.exeption.QuietanzaException;
import com.fideuram.stampe.modello.quietanza.Assegno;
import com.fideuram.stampe.modello.quietanza.ListaAssegni;
import com.fideuram.utils.LoggingUtils;

/**
 * Created by
 * User: logan
 * Date: 18/02/13
 * Time: 15.12
 */
public class AssegnoGenerator extends QuietanzaBase
{
	
	private static String ASSEGNO;
	
	public AssegnoGenerator(String nomeFile) throws DocGeneratorException{
			AssegnoGenerator.ASSEGNO = nomeFile;
	    	new QuietanzaBase(nomeFile);
	    }
	 
    public byte[] generateDocument(Assegno doc) throws QuietanzaException 
    {
    	byte[] lbyte =null;
        
    	try
        {    
        	LoggingUtils.debug("Generazione ASSEGNO");
        	
            HashMap map = new HashMap();
            map.put("assegno", doc);
            lbyte = generatorePdf(map, ASSEGNO);
            
            LoggingUtils.debug("ASSEGNO prodotto");
            
        } catch (DocGeneratorException e) {
        	LoggingUtils.debug(doc.getProtocollo()+ASSEGNO + e.getMessage());
            throw new QuietanzaException("Assegno.generateDocument: TemplateLoaderExcepion",e);
		}
        return lbyte;
    }
    public byte[] generateDocument(ListaAssegni assegniObject) throws QuietanzaException 
    {
    	byte[] lbyte =null;
        
    	try
        {    
        	LoggingUtils.debug("Generazione ASSEGNO");
        	
            HashMap map = new HashMap();
            map.put("listaAssegni", assegniObject);
            lbyte = generatorePdf(map, ASSEGNO);
            
            LoggingUtils.debug("ASSEGNO prodotto");
            
        } catch (DocGeneratorException e) {
        	LoggingUtils.debug(assegniObject.getAssegno().size()+ASSEGNO + e.getMessage());
            throw new QuietanzaException("Assegno.generateDocument: TemplateLoaderExcepion",e);
		}
        return lbyte;
    }
}
