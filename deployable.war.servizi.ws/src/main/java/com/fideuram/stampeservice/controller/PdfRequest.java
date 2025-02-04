package com.fideuram.stampeservice.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.fideuram.config.CrmProperties;
import com.fideuram.costanti.Costanti;
import com.fideuram.costanti.TemplateSystem;
import com.fideuram.exception.CredenzialiException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.factory.PdfFactory;
import com.fideuram.pdfconverter.ConverterException;
import com.fideuram.processo.FacadeCredenziali;
import com.fideuram.stampeservice.FaultBean;
import com.fideuram.stampeservice.StampeWsException;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfReader;

/**
 * User: V801068
 * Date: 02/02/16
 * Time: 18.32
 */
public class PdfRequest {
    public byte[] stampa(String xml, int action) throws StampeWsException {
        try {
            switch (action) {
                case (16):
                case (17):
                case (18):
                case (19):
                    return new FacadeCredenziali().stampa(xml, action);
                case (21):
                    byte[] b= new OdtRequest().stampa(xml, action);
                    return odt2pdfWithAttach(b, xml);
                default:
                    b= new OdtRequest().stampa(xml, action);
                    return odt2pdf(b);
            }
        } catch (CredenzialiException e) {
            throw new StampeWsException("Request PDF non trovata", new FaultBean(e.getMessage()));
        }
    }

    private byte[] odt2pdf(byte[] odt) throws StampeWsException {
        byte[] pdf = new byte[0];
        try {
            pdf = PdfFactory.getPdfFromOdt(odt);
        } catch (WebServiceClientException e) {
            throw new StampeWsException(e.getMessage(),new FaultBean(e.getMessage()));
        } catch (ConverterException e) {
            throw new StampeWsException(e.getMessage(),new FaultBean(e.getMessage()));
        }
        return pdf;
    }

    private byte[] odt2pdfWithAttach(byte[] odt, String xml) throws StampeWsException {

        byte[] pdf = new byte[0];

        try {
        	pdf = PdfFactory.getPdfFromOdt(odt);
            
            if (xml.contains("<allegato1A>SI</allegato1A>")) {
            	pdf = aggiungiAllegato(pdf, "QAVBENEFICIARIO moduloBeneficiarioTerzo");
            }
            
            if (xml.contains("<allegato2A>SI</allegato2A>")) {
            	pdf = aggiungiAllegato(pdf, "fatca");
            }

            if (xml.contains("<allegatoQAV>SI</allegatoQAV>")) {
            	pdf = aggiungiAllegato(pdf, "QAV_RipRen");
            }
            if (xml.contains("<allegatoRR>SI</allegatoRR>")) {
            	pdf = aggiungiAllegato(pdf, "RR_RipRen");
            }
        } 
        catch (WebServiceClientException e) {
            throw new StampeWsException(e.getMessage(),new FaultBean(e.getMessage()));
        } 
        catch (ConverterException e) {
            throw new StampeWsException(e.getMessage(),new FaultBean(e.getMessage()));
		}
        
        return pdf;
    }

    
    private byte[] aggiungiAllegato(byte[] pdf, String nomeAllegato) throws StampeWsException  {
    	
    	File tempPath = new File(CrmProperties.getProperty(Costanti.CRM_SERVICES_TEMP_PATH));
        String templatePath     = CrmProperties.getProperty(TemplateSystem.LOCATION_TEMPLATE);
    	String tempo = "/"+System.currentTimeMillis()+"_";
        
    	byte[] output =  null;
    	
    	try {
    		//SALVO IL PDF DELLA LATTERA
			FileOutputStream fileOuputStream = null;
	
	        try {
	            fileOuputStream = new FileOutputStream(tempPath+"/"+tempo+"temp_lettera.pdf");
	            fileOuputStream.write(pdf);
	            
	
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (fileOuputStream != null) {
	                try {
	                    fileOuputStream.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	
	        
	        //CREO IL FILE PDF FINALE
			Document doc= new Document();
			PdfCopy pdfFinale= new PdfCopy(doc, new FileOutputStream(tempPath+"/"+tempo+"temp_lettera_allegato.pdf"));
			doc.open(); 
	
			//COPIO IL PDF DELLA LETTERA NEL FILE PDF FINALE
			PdfReader lettera=new PdfReader(tempPath+"/"+tempo+"temp_lettera.pdf");
			int n = lettera.getNumberOfPages();
			
			for (int i = 0; i < n; ) {
				pdfFinale.addPage(pdfFinale.getImportedPage(lettera, ++i));
			}
			
			//COPIO IL PDF DELL'ALLEGATO NEL FILE PDF FINALE
			PdfReader allegato = new PdfReader(templatePath+"/"+nomeAllegato+".pdf");
			for (int i = 0; i < allegato.getNumberOfPages(); ) {
				pdfFinale.addPage(pdfFinale.getImportedPage(allegato, ++i));
			}
	
			doc.close();
	    	
			new File(tempPath+"/"+tempo+"temp_lettera.pdf").delete();
			
			
			//CONVERTO IL PDF FINALE IN BYTE[]
			File file = new File(tempPath+"/"+tempo+"temp_lettera_allegato.pdf");
			FileInputStream fis = new FileInputStream(file);
			output = new byte[(int)file.length()];
			fis.read(output);
			fis.close();
			file.delete();
			
    	}
    	catch (Exception e) {
    		throw new StampeWsException(e.getMessage(),new FaultBean(e.getMessage()));
    	}
    	
    	
    	return output;
    }
    
}
