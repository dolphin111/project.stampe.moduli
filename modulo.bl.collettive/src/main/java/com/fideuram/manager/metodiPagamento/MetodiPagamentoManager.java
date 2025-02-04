package com.fideuram.manager.metodiPagamento;

import java.io.File;
import java.io.IOException;

import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.dao.metodiPagamento.MetodiPagamentoDAO;
import com.fideuram.exception.CollettiveFileDataReadException;
import com.fideuram.exception.StampaCollettiveException;
import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.factory.OdtFactory;
import com.fideuram.factory.PdfFactory;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.factory.TemplateFactory;
import com.fideuram.modello.metodiPagamento.ListMetodiPagamento;
import com.fideuram.pdfconverter.ConverterException;
import com.fideuram.processi.ProcessiCollettive;
import com.fideuram.utils.LoggingUtils;

public class MetodiPagamentoManager {

    public static byte[] getPdfMetodiPagamento(File file) throws StampaCollettiveException, Exception {
    	MetodiPagamentoDAO dao= new MetodiPagamentoDAO();
       
    	try {
        	LoggingUtils.info("getPdfMetodiPagamento method: file["+file+"]");
        	ListMetodiPagamento listMetodi = dao.getMetodiPagamento(file);
            byte[] template= TemplateFactory.getTemplateFromRichiesta(ProcessiCollettive.METODI_PAGAMENTO);
            File  doc      = OdtFactory.generateMetodiPagamento(template, listMetodi);
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
