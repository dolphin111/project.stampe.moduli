package com.fideuram.stampe.printer;

import java.util.HashMap;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.file.io.reader.Reader;
import com.fideuram.file.manipolation.odt.OdtWriter;
import com.fideuram.pdfconverter.ConverterException;
import com.fideuram.utils.LoggingUtils;



public class MandatiPagamentoBase  extends Reader
{   
	private static byte templateData[];
	private static String template;
	
	
	public MandatiPagamentoBase(){
		
	}
	
	public MandatiPagamentoBase(String template) throws DocGeneratorException{
		boolean change = false;
		if(MandatiPagamentoBase.template!=null && !MandatiPagamentoBase.template.equals("")){
			if(!MandatiPagamentoBase.template.equals(template)){
                MandatiPagamentoBase.template = template;
				change = true;
			}
		}
		else{
            MandatiPagamentoBase.template = template;
		}
		if(templateData==null || change)
		templateData = getTemplate(MandatiPagamentoBase.template);
	}
	
    @SuppressWarnings("rawtypes")
	public byte[] generatorePdf(HashMap data, String template) throws DocGeneratorException 
    {
    	byte doc[] = null;
    	try 
    	{
		//	LoggingUtils.debug((new StringBuilder("template")).append(templateData.toString()).toString());
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
