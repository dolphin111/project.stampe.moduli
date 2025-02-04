package com.fideuram.printer;

import com.fideuram.exception.PrinterFreemarkerException;
import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.factory.TemplateFactory;
import com.fideuram.file.io.OdtMerge;
import com.fideuram.freemarker.Printer;
import com.fideuram.stampe.modello.previdenza.Previdenza;
import com.fideuram.stampe.modello.previdenza.PrevidenzaTrasferimentoInput;
import com.fideuram.stampe.modello.previdenza.versamenti.VersamentiPrevidenza;
import com.fideuram.utils.LoggingUtils;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by V801068 on 03/06/14.
 */
public class PrinterPrevidenza extends Printer {
    public PrinterPrevidenza(Previdenza previdenza, int richiesta) throws TemplateLoaderExcepion {
        super(richiesta);
        this.object = previdenza;
    }

    public PrinterPrevidenza(VersamentiPrevidenza previdenza, int richiesta) throws TemplateLoaderExcepion {
        super(richiesta);
        this.object = previdenza;
    }

    public PrinterPrevidenza(PrevidenzaTrasferimentoInput previdenza, int richiesta) throws TemplateLoaderExcepion {
        super(richiesta);
        this.object = previdenza;
    }



    IXDocReport report;
    File odt=null;
    public byte[] start(int[] action) throws PrinterFreemarkerException {
            List <File> files= new ArrayList<File>();
            try{
                for(int i=0;i<action.length;i++){
                    byte[] template= TemplateFactory.getTemplateFromRichiesta(action[i]);
                    InputStream in= new ByteArrayInputStream(template);
                    report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Freemarker );

                    FieldsMetadata metadata = report.createFieldsMetadata();
                    metadata.addFieldAsImage( "immagine.piedino" );
                    metadata.addFieldAsImage( "immagine.firma" );

                    IContext context = report.createContext();
                    context.put( "o", object );
                    context.put( "immagine", immagini );


                    odt=new File(percorso+i+nomeFile);
                    OutputStream out = new FileOutputStream( odt );
                    report.process(context, out);
                    out.close();
                    LoggingUtils.debug("Generato >>" + percorso + nomeFile);
                    files.add(odt);
                }
                OdtMerge merger = new OdtMerge();
                return merger.mergeFileProdotti(files);
            } catch (TemplateLoaderExcepion e) {
                LoggingUtils.debug(e.getMessage());
                throw new PrinterFreemarkerException("PrinterCC.start: TemplateLoaderExcepion",e);
            } catch (FileNotFoundException e) {
                LoggingUtils.debug(e.getMessage());
                throw new PrinterFreemarkerException("Printer.start:  FileNotFoundException",e);
            } catch (XDocReportException e) {
                LoggingUtils.debug(e.getMessage());
                throw new PrinterFreemarkerException("PrinterCC.start.generateDocument: XDocReportException",e);
            } catch (IOException e) {
                LoggingUtils.debug(e.getMessage());
                throw new PrinterFreemarkerException("PrinterCC.start.generateDocument: IOException",e);
            } catch (DocGeneratorException e) {
                LoggingUtils.debug(e.getMessage());
                throw new PrinterFreemarkerException("PrinterCC.start.generateDocument: Errore durante la fase di merge",e);
            } finally {
                    try {
                        FileUtils.deleteDirectory(new File(percorso));
                    } catch (IOException e) {
                        LoggingUtils.debug(e.getMessage());
                    }
            }
    }
}
