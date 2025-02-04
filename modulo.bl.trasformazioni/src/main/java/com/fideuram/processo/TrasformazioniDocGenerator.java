package com.fideuram.processo;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.fideuram.bean.Immagini;
import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.exception.TrasformazioneException;
import com.fideuram.factory.TemplateFactory;
import com.fideuram.modello.PolizzaTrasformabile;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.config.CrmProperties;

import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

/**
 * Created by
 * User: logan
 * Date: 25/02/13
 * Time: 18.11
 */
public class TrasformazioniDocGenerator {
    public File generateDocument(PolizzaTrasformabile polizzaTrasformabile, int template) throws TrasformazioneException {

        Immagini immagini = new Immagini();
        File polizzatrasformata=null;
        try{
            //TODO PRENDERE IL TEMPLATE DAL CONTRATTO
            //InputStream in= getTemplate(template);   //obsoleto
            InputStream in= getTemplate(polizzaTrasformabile.getOrigine().getCodiceDestinazionene());
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Freemarker );
            IContext context = report.createContext();
            FieldsMetadata metadata = report.createFieldsMetadata();
            metadata.addFieldAsImage( "immagine.piedino" );
            metadata.addFieldAsImage( "immagine.logoIndirizzoPal" );
            context.put( "immagine", immagini );
            context.put( "trasformabile", polizzaTrasformabile );
            LoggingUtils.debug("  CONTRATTO DI POLIZZA IN TRASFORMAZIONE   >>");

            polizzatrasformata=new File(CrmProperties.getProperty("crm.services.temp.path")+polizzaTrasformabile.getPolizza().getNumero()+".odt");  //todo definire una chiave uniivoca che identifichi il file
            OutputStream out = new FileOutputStream( polizzatrasformata );
            report.process( context, out );
            out.close();
            LoggingUtils.debug("CONTRATTO DI POLIZZA IN TRASFORMATO");
        } catch (FileNotFoundException e) {
            LoggingUtils.debug( e.getMessage());
            throw new TrasformazioneException("TrasformazioniDocGenerator.generateDocument: FileNotFoundException",e);
        } catch (XDocReportException e) {
            LoggingUtils.debug( e.getMessage());
            throw new TrasformazioneException("TrasformazioniDocGenerator.generateDocument: XDocReportException",e);
        } catch (IOException e) {
            LoggingUtils.debug( e.getMessage());
            throw new TrasformazioneException("TrasformazioniDocGenerator.generateDocument: IOException",e);
        } catch (TemplateLoaderExcepion e) {
            LoggingUtils.debug( e.getMessage());
            throw new TrasformazioneException("TrasformazioniDocGenerator.generateDocument: TemplateLoaderExcepion",e);
        }
        return polizzatrasformata;
    }

    protected InputStream getTemplate(int template) throws TemplateLoaderExcepion {
        return  new ByteArrayInputStream(TemplateFactory.getTemplateFromRichiesta(template));
        //return  new ByteArrayInputStream(TemplateFinder.getTemplate(templateName));
    }
}
