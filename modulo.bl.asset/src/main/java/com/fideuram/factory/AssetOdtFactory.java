package com.fideuram.factory;

import com.fideuram.exception.AssetException;
import com.fideuram.jaxb.Converter;
import com.fideuram.stampe.modello.asset.FondoInvestimentoGlobale;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.config.CrmProperties;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;

import java.io.*;
import java.sql.Timestamp;
import java.util.Date;

import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

import javax.xml.bind.JAXBException;

/**
 * Created by
 * User: logan
 * Date: 16/04/13
 * Time: 15.08
 */
public class AssetOdtFactory {
    public static int count=0;
    public  File generateOdtWithFreemarker(byte[] template, FondoInvestimentoGlobale fondoInvestimentoGlobale) throws AssetException {
        File documento=null;
        String nome=fondoInvestimentoGlobale.getNome();
        nome=nome.replace(" ","_");

        String nomefile= CrmProperties.getProperty("crm.services.temp.path")+fondoInvestimentoGlobale.getIdNomeFondo()+"_"+nome+"_"+new Timestamp(new Date().getTime()).getTime()+"_"+count++;
        LoggingUtils.info("File in generazione "+nomefile);


        try{
            InputStream in=  new ByteArrayInputStream(template);
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Freemarker );
            IContext context = report.createContext();
            context.put( "fondoInvestimentoGlobale", fondoInvestimentoGlobale );
            context.put( "fondoInvestimentoAnuale", fondoInvestimentoGlobale.getFondoInvestimentoAnnuales() );

            //String nomefile= CrmProperties.getProperty("crm.services.temp.path")+fondoInvestimentoGlobale.getIdNomeFondo()+"_"+new Timestamp(new Date().getTime());
            documento=new File(nomefile);

            OutputStream out = new FileOutputStream( documento );
            report.process(context, out);
            out.flush();
            out.close();
        } catch (XDocReportException e) {
            LoggingUtils.error(e.getMessage());
            logXml(fondoInvestimentoGlobale);
            throw new AssetException("Asset Exc - AssetOdtFactory.generateOdtWithFreemarker: XDocReportException",e);
        } catch (IOException e) {
            LoggingUtils.error(e.getMessage());
            logXml(fondoInvestimentoGlobale);
            throw new AssetException("Asset Exc - AssetOdtFactory.generateOdtWithFreemarker: IOException",e);
        }
        return documento;
    }

    private void logXml(FondoInvestimentoGlobale fondoInvestimentoGlobale){
        try {
            LoggingUtils.info("ALLARME ASSET:\n" + Converter.objectToXml(fondoInvestimentoGlobale));
        } catch (JAXBException e1) {
        } catch (IOException e1) {}
    }

}
