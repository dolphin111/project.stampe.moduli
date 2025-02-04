package com.fideuram.factory;

import com.fideuram.bean.Immagini;
import com.fideuram.exception.DisplayPolizzaException;
import com.fideuram.file.TempDir;
import com.fideuram.modello.polizza.Polizza;
import com.fideuram.modello.grafici.Grafico;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.config.CrmProperties;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;

import java.io.*;
import java.util.Date;

import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

/**
 * Created by
 * User: logan
 * Date: 16/04/13
 * Time: 15.08
 */
public class OdtFactory {
    private String tmpDir="";

    public File generateOdtWithFreemarker(byte[] template, Polizza polizza) throws DisplayPolizzaException {
        tmpDir= TempDir.getTmpDirByName("");
        Immagini immagini = new Immagini();
        Grafico  grafico = new Grafico(polizza,tmpDir);

        LoggingUtils.info("MI PREPARO A GENERARE IL DOC PER LA POLIZZA " + polizza.getDatiTecnici().getNumeroPolizza());
        File documento=null;
        try{
            InputStream in=  new ByteArrayInputStream(template);
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Freemarker );
            IContext context = report.createContext();

            FieldsMetadata metadata = report.createFieldsMetadata();
            metadata.addFieldAsImage( "immagine.piedino" );
            metadata.addFieldAsImage( "grafico.tortaAssetClass" );
            metadata.addFieldAsImage( "grafico.andamentoControvalore" );
            metadata.addFieldAsImage( "grafico.lineaAndamentoRendimenti" );
            metadata.addFieldAsImage( "grafico.barraRendimentiConsolidatiInizioGestione" );
            metadata.addFieldAsImage( "grafico.barraRendimentiConsolidatiInizioAnno" );
            metadata.addFieldAsImage( "grafico.barraRendimentiConsolidatiTrimestre" );
            metadata.addFieldAsImage( "grafico.tortaFondoOicr" );

            context.put( "immagine", immagini );

            context.put( "grafico", grafico );
            context.put( "polizza", polizza );

            //documento=new File(CrmProperties.getProperty("crm.services.temp.path")+new Date().getTime()); //todo sbrigati
            documento=new File(tmpDir+new Date().getTime()); //get Time è il nome del file
            OutputStream out = new FileOutputStream( documento );
            report.process(context, out);
            out.flush();
            out.close();
            LoggingUtils.info("GENERATO IL DOC PER LA POLIZZA " + polizza.getDatiTecnici().getNumeroPolizza());
            return documento;
        } catch (XDocReportException e) {
            LoggingUtils.error("<<XDocReportException>>",e);
            throw new DisplayPolizzaException("ERRORE DURANTE LA PRODUZIONE DELL'ODT: <<XDocReportException>>",e);
        } catch (IOException e) {
            LoggingUtils.error("<<IOException>>",e);
            throw new DisplayPolizzaException("ERRORE DURANTE LA PRODUZIONE DELL'ODT: <<IOException>>",e);
        }

    }



}
