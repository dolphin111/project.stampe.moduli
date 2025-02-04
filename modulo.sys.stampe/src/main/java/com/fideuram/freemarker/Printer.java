package com.fideuram.freemarker;

import com.fideuram.bean.Immagini;
import com.fideuram.exception.PrinterFreemarkerException;
import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.factory.TemplateFactory;
import com.fideuram.processi.ProcessoBase;
import com.fideuram.utils.LoggingUtils;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import org.apache.commons.io.FileUtils;

import java.io.*;

/**
 * Created by V801068 on 20/05/14.
 */
public class Printer extends ProcessoBase {
    protected static Immagini immagini;

    protected int      richiesta;
    protected Object   object;
    protected String   nomeFile;


    /**
     * Questa classe si occupa della stampa di un documento tramite template freemarker
     * La procedura di stampa si  avvia tramite i metodi start().
     * Si possono richiede stampe di documenti che necessitano di più template start(action[]).
     * Allora perchè devo cmq indicare una richiesta al costruttore? Perchè
     * La classe printer indipendentemente dal numero di template impiegati per la stampa del doc
     * si occupa di generare un documento corrispondente ad una specifica richiesta di stampa
     * e tale richiesta va indicata al metodo costruttore.
     * @param richiesta
     */
    public Printer(int richiesta) {
        this.richiesta=richiesta;
        this.nomeFile=TemplateFactory.getNomeTemplate(""+richiesta);
        this.immagini = new Immagini();
    }


    IXDocReport report;
    File odt=null;
    public byte[] start() throws PrinterFreemarkerException {

        byte[] stream;
        try{
            byte[] template= TemplateFactory.getTemplateFromRichiesta(richiesta);
            InputStream in= new ByteArrayInputStream(template);

            report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Freemarker );

            FieldsMetadata metadata = report.createFieldsMetadata();
            metadata.addFieldAsImage( "immagine.piedino" );
            metadata.addFieldAsImage( "immagine.firma" );

            IContext context = report.createContext();
            context.put( "o", object );
            context.put( "immagine", immagini );


            odt=new File(percorso+nomeFile);
            OutputStream out = new FileOutputStream( odt );
            report.process(context, out);
            out.close();
            LoggingUtils.debug("Generato >>" + percorso + nomeFile);

            stream = StreamerFactory.getStreamFromFile(odt);
            return stream;
        } catch (TemplateLoaderExcepion e) {
            LoggingUtils.debug(e.getMessage());
            throw new PrinterFreemarkerException("Printer.start: TemplateLoaderExcepion",e);
        } catch (FileNotFoundException e) {
            LoggingUtils.debug(e.getMessage());
            throw new PrinterFreemarkerException("Printer.start:  FileNotFoundException",e);
        } catch (XDocReportException e) {
            LoggingUtils.debug(e.getMessage());
            throw new PrinterFreemarkerException("Printer.start.generateDocument: XDocReportException",e);
        } catch (IOException e) {
            LoggingUtils.debug(e.getMessage());
            throw new PrinterFreemarkerException("PrinterCC.start.generateDocument: IOException",e);
        }finally {
           /* try {
                FileUtils.deleteDirectory(new File(percorso)); //.deleteDirectory(new File(percorso));
            } catch (IOException e) {
                LoggingUtils.debug(e.getMessage());
            }*/
        }
    }
}
