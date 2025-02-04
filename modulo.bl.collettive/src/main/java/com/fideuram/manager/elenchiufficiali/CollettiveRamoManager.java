package com.fideuram.manager.elenchiufficiali;

import java.io.File;
import java.io.IOException;

import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.dao.elenchiufficiali.ElenchiUfficialiDAO;
import com.fideuram.exception.CollettiveFileDataReadException;
import com.fideuram.exception.StampaCollettiveException;
import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.factory.OdtFactory;
import com.fideuram.factory.PdfFactory;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.factory.TemplateFactory;
import com.fideuram.modello.elenchiufficiali.ElenchiUfficiali;
import com.fideuram.pdfconverter.ConverterException;
import com.fideuram.processi.ProcessiCollettive;
import com.fideuram.utils.LoggingUtils;

public class CollettiveRamoManager {

	
	  public static byte[] getPdfElenchiUfficiali(File file, boolean isRamoUno) throws StampaCollettiveException, Exception {
	    	ElenchiUfficialiDAO dao= new ElenchiUfficialiDAO();
	    	byte[] template=null;
	       
	    	try {
	        	LoggingUtils.info("getPdfMetodiPagamento method: file["+file+"]");
	        	ElenchiUfficiali elenchiUfficiali = dao.getElenchiUfficiali(file);
	        	if(isRamoUno)
	        		template= TemplateFactory.getTemplateFromRichiesta(ProcessiCollettive.ELENCHI_UFFICIALI_I);
	        	else
	        		template= TemplateFactory.getTemplateFromRichiesta(ProcessiCollettive.ELENCHI_UFFICIALI_III);
	            File  doc      = OdtFactory.generateElenchiUfficiali(template, elenchiUfficiali);
	            byte[]docstream= StreamerFactory.getStreamFromFile(doc);
	            byte[] pdf     = PdfFactory.getPdfFromOdt(docstream);
	            return pdf;
	        } catch (CollettiveFileDataReadException e) {
	            LoggingUtils.error("CollettiveFileDataReadException: "+e.getMessage());
	            throw new StampaCollettiveException(e.getMessage());
	        } catch (TemplateLoaderExcepion e) {
	            LoggingUtils.error("TemplateLoaderExcepion: "+e.getMessage());
	            throw new StampaCollettiveException(e.getMessage());
	        } catch (WebServiceClientException e) {
	            LoggingUtils.error("WebServiceClientException: "+e.getMessage());
	            throw new StampaCollettiveException(e.getMessage());
	        } catch (ConverterException e) {
	            LoggingUtils.error("ConverterException: "+e.getMessage());
	            throw new StampaCollettiveException(e.getMessage());
	        } catch (IOException e) {
	            LoggingUtils.error("IOException: "+e.getMessage());
	            throw new StampaCollettiveException(e.getMessage());
	        } catch (Exception e){
	        	LoggingUtils.error("Eccezione generica: ["+e.getMessage()+"]");
	            throw new Exception("OdtFactory.getPdfMetodiPagamento: Exception",e);
	        }
	    }
}
