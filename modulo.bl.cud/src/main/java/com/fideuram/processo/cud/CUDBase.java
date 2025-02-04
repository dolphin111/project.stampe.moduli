package com.fideuram.processo.cud;

import java.util.HashMap;

import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.file.io.reader.Reader;
import com.fideuram.file.manipolation.odt.OdtWriter;
import com.fideuram.pdfconverter.ConverterException;
import com.fideuram.utils.LoggingUtils;


public class CUDBase extends Reader{
	
	private static byte templateData[];
	private static String template;
	
	
	public CUDBase(){
		
	}
	
	public CUDBase(String template) throws DocGeneratorException{
		boolean change = false;
		if(CUDBase.template!=null && !CUDBase.template.equals("")){
			if(!CUDBase.template.equals(template)){
				CUDBase.template = template;
				change = true;
			}
		}
		else{
			CUDBase.template = template;
		}
		if(templateData==null || change)
		templateData = getTemplate(CUDBase.template);
	}
	
    public byte[] generatorePdf(HashMap data, String template) throws DocGeneratorException 
    {
    	byte doc[] = null;
    	try 
    	{
			LoggingUtils.debug((new StringBuilder("template")).append(templateData.toString()).toString());
			doc = (new OdtWriter()).mergeData(templateData, data);
			doc = ClientWsFactory.getInstance().getPdfConverterClient().odt2Pdf(doc);
		
    	} catch (ConverterException e) {
			throw new DocGeneratorException(e.getMessage());
		} catch (WebServiceClientException e) {
			throw new DocGeneratorException(e.getMessage());
		}
		
		return doc;
	}   

}
