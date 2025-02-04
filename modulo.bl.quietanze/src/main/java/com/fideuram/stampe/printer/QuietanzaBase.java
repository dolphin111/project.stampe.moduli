package com.fideuram.stampe.printer;

import java.util.HashMap;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.file.io.reader.Reader;
import com.fideuram.file.manipolation.odt.OdtWriter;
import com.fideuram.pdfconverter.ConverterException;
import com.fideuram.utils.LoggingUtils;

/**
 * Created by
 * User: logan
 * Date: 18/02/13
 * Time: 15.18
 */
public class QuietanzaBase  extends Reader
{   
	private static byte templateData[];
	private static String template;
	
	
	public QuietanzaBase(){
		
	}
	
	public QuietanzaBase(String template) throws DocGeneratorException{
		boolean change = false;
		if(QuietanzaBase.template!=null && !QuietanzaBase.template.equals("")){
			if(!QuietanzaBase.template.equals(template)){
				QuietanzaBase.template = template;
				change = true;
			}
		}
		else{
			QuietanzaBase.template = template;
		}
		if(templateData==null || change)
		templateData = getTemplate(QuietanzaBase.template);
	}
	
    public byte[] generatorePdf(HashMap data, String template) throws DocGeneratorException 
    {
    	byte doc[] = null;
    	try 
    	{
			LoggingUtils.debug((new StringBuilder("template")).append(templateData.toString()).toString());
			doc = (new OdtWriter()).mergeData(templateData, data);
			//doc = ClientWsFactory.getInstance().getPdfConverterClient().odt2Pdf(doc);
			
			/*G.C.-20170419 Creato il nuovo client relativo al WS batchPdfConverter (http://fvbsappl083.fidevita.bancafideuram.it:8090/batchPdfConverter/Converter?wsdl)
			 * che verrà utilizzato solo da GEREND in fase di generazione documenti (LETTERE, BONIFICI, ETC.)
			 * */
			doc = ClientWsFactory.getInstance().getBatchPdfConverterClient().odt2Pdf(doc);
		
    	/*} catch (ConverterException e) {
			throw new DocGeneratorException(e.getMessage());*/
		} catch (WebServiceClientException e) {
			throw new DocGeneratorException(e.getMessage());
		}
		
		return doc;
	}   
}
