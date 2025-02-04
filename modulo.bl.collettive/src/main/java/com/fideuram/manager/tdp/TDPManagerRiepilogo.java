package com.fideuram.manager.tdp;

import java.io.File;
import java.io.IOException;

import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.dao.tdp.TdpDao;
import com.fideuram.exception.CollettiveFileDataReadException;
import com.fideuram.exception.StampaCollettiveException;
import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.factory.OdtFactory;
import com.fideuram.factory.PdfFactory;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.factory.TemplateFactory;
import com.fideuram.modello.tdp.Collettive;
import com.fideuram.pdfconverter.ConverterException;
import com.fideuram.processi.ProcessiCollettive;
import com.fideuram.utils.LoggingUtils;

/**
 * Created by
 * User: logan
 * Date: 10/05/13
 * Time: 12.09
 */
public class TDPManagerRiepilogo {
    public static byte[] getPdfRiepilogoTDP(File file) throws StampaCollettiveException, Exception {
        TdpDao dao = new TdpDao();
        try {
        	LoggingUtils.info("getPdfRiepilogoTDP method: file["+file+"]");
            Collettive collettive = dao.getRiepilogoTDP (file);
            byte[] template= TemplateFactory.getTemplateFromRichiesta(ProcessiCollettive.RIEPILOGO_TITOLI_DI_PERFEZIONAMENTO);
            File  doc      = OdtFactory.generateScartiTDPWithFreemarker(template, collettive);
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
            throw new Exception("OdtFactory.generateScartiTDPWithFreemarker: Exception",e);
        }
    }
}
