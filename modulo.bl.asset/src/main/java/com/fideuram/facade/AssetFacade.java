package com.fideuram.facade;

import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.exception.AssetException;
import com.fideuram.exception.IsideException;
import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.factory.AssetOdtFactory;
import com.fideuram.factory.PdfFactory;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.factory.TemplateFactory;
import com.fideuram.iside.Backup2Iside;
import com.fideuram.iside.IsideResponce;
import com.fideuram.pdfconverter.ConverterException;
import com.fideuram.stampe.modello.asset.FondoInvestimentoGlobale;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.xml.XmlAssetConverter;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

/**
 * Created by 
 * User: logan
 * Date: 10/04/13
 * Time: 17.15
 */
public class AssetFacade {

    public IsideResponce elaboraOdt(FondoInvestimentoGlobale fondoInvestimentoGlobale, int richiesta) throws AssetException {
        LoggingUtils.info("BL.ASSET: inizio elaborazione");
        fondoInvestimentoGlobale = new Redundance().cleaner(fondoInvestimentoGlobale);
        LoggingUtils.info("BL.ASSET: cleaner eseguito");
        try {
            byte[] template= TemplateFactory.getTemplateFromRichiesta(richiesta);
            File file = new AssetOdtFactory().generateOdtWithFreemarker(template, fondoInvestimentoGlobale);
            LoggingUtils.info("DOCUMENTO ASSET GENERATO  ");

            byte[] stream= new byte[0];
            stream = StreamerFactory.getStreamFromFile(file);
            LoggingUtils.info("RICHIESTA: " + richiesta + " - STREAM: " + stream.toString());

            byte[] pdf = PdfFactory.getPdfFromOdt(stream);
            file.delete();
            return   new Backup2Iside().saveToIside(pdf,"AS"+fondoInvestimentoGlobale.getNome(), fondoInvestimentoGlobale.getData(), fondoInvestimentoGlobale.getIdNomeFondo());
            //return new StoredFile(ir.getIdDocument(),ir.getNomeDoc(),ir.getMimetype());
        } catch (TemplateLoaderExcepion e) {
            LoggingUtils.error(e);
            throw new AssetException("Asset Exc - TemplateLoaderExcepion:"+e.getMessage(),e);
        } catch (IOException e) {
            LoggingUtils.error(e);
            throw new AssetException("Asset Exc - IOException:"+e.getMessage(),e);
        } catch (WebServiceClientException e) {
            LoggingUtils.error(e);
            throw new AssetException("Asset Exc - WebServiceClientException: "+e.getMessage(),e);
        } catch (ConverterException e) {
            LoggingUtils.error(e);
            throw new AssetException("Asset Exc - ConverterException: "+e.getMessage(),e);
        } catch (IsideException e) {
            LoggingUtils.error(e);
            throw new AssetException("Asset Exc - IsideException: "+e.getMessage(),e);
        }
    }

    /**
     * <br>Questo metodo restituisce un documento in formato Odt</br>
     * <br>relativo ai dati polizza passati in formato xml</br>
     *
     * @param xml dati polizza
     * @param richiesta  tipo template da utilizzare
     * @return  type byte[]
     */
     public IsideResponce elaboraOdt(String xml, int richiesta) throws AssetException {
        LoggingUtils.debug("ATTIVATO IL DISPLAY POLIZZA PER LA RICHIESTA" + richiesta);
        FondoInvestimentoGlobale fondoInvestimentoGlobale=null;
        byte[] template=null;
        try {
            fondoInvestimentoGlobale = XmlAssetConverter.getBeans(xml);
            return elaboraOdt(fondoInvestimentoGlobale,richiesta);
        } catch (JAXBException e) {
            LoggingUtils.error(e);
            throw new AssetException("Errore durante la fase di conversione xml2Polizza:"+e.getMessage(),e);
        } catch (ClassNotFoundException e) {
            LoggingUtils.error(e);
            throw new AssetException("Errore durante la fase di conversione xml2Polizza:"+e.getMessage(),e);
        } catch (InstantiationException e) {
            LoggingUtils.error(e);
            throw new AssetException("Errore durante la fase di conversione xml2Polizza:"+e.getMessage(),e);
        } catch (IllegalAccessException e) {
            LoggingUtils.error(e);
            throw new AssetException("Errore durante la fase di conversione xml2Polizza:"+e.getMessage(),e);
        }
    }
}
