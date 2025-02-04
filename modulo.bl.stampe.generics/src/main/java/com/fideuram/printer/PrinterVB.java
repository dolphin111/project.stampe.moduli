package com.fideuram.printer;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fideuram.exception.PrinterFreemarkerException;
import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.factory.TemplateFactory;
import com.fideuram.file.io.OdtMerge;
import com.fideuram.freemarker.Printer;
import com.fideuram.stampe.modello.variazioneBeneficiario.AppendiceVB;
import com.fideuram.stampe.modello.variazioneBeneficiario.RifiutoVB;
import com.fideuram.stampe.modello.variazioneBeneficiario.SollecitoVB;
import com.fideuram.stampe.modello.variazioneBeneficiario.VariazioneBeneficiario;
import com.fideuram.utils.LoggingUtils;

import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;


/**
 * Created by V801098 on 14/05/14.
 */
public class PrinterVB extends Printer {

	
    public PrinterVB(int richiesta) {
		super(richiesta);
	}

	public PrinterVB(VariazioneBeneficiario variazioneBeneficiario, int richiesta) throws TemplateLoaderExcepion {
        super(richiesta);
        this.object = variazioneBeneficiario;
    }

    public PrinterVB(SollecitoVB sollecitoVB, int richiesta) throws TemplateLoaderExcepion {
        super(richiesta);
        this.object = sollecitoVB;
    }

    public PrinterVB(AppendiceVB appendiceVB, int richiesta) {
    	
    	super(richiesta);
        this.object = appendiceVB;
        
    }

    public PrinterVB(RifiutoVB rifiutoVB, int richiesta) {
        super(richiesta);
        this.object = rifiutoVB;
    }
    
    
    IXDocReport report;
    File odt=null;
    public byte[] startAppendiceVB() throws PrinterFreemarkerException {
    	
    	
    	ArrayList<Integer> action = new ArrayList<Integer>();
    	AppendiceVB avb = (AppendiceVB)object;
    	LoggingUtils.debug("Tipo Operazione" + avb.getTipoOperazione());
    	if(avb.getTipoOperazione().equalsIgnoreCase("VB")){
    		action.add(1022);
    	} else if(avb.getTipoOperazione().equalsIgnoreCase("BA")){
    		action.add(10221);
    	} else if(avb.getTipoOperazione().equalsIgnoreCase("VBBA")){
    		action.add(1022);
    		action.add(10221);
    	}

    	
            List <File> files= new ArrayList<File>();
            try{
                for(int i=0;i<action.size();i++){
                    byte[] template= TemplateFactory.getTemplateFromRichiesta(action.get(i));
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
                throw new PrinterFreemarkerException("PrinterVB.start: TemplateLoaderExcepion",e);
            } catch (FileNotFoundException e) {
                LoggingUtils.debug(e.getMessage());
                throw new PrinterFreemarkerException("Printer.start:  FileNotFoundException",e);
            } catch (XDocReportException e) {
                LoggingUtils.debug(e.getMessage());
                throw new PrinterFreemarkerException("PrinterVB.start.generateDocument: XDocReportException",e);
            } catch (IOException e) {
                LoggingUtils.debug(e.getMessage());
                throw new PrinterFreemarkerException("PrinterVB.start.generateDocument: IOException",e);
            } catch (DocGeneratorException e) {
                LoggingUtils.debug(e.getMessage());
                throw new PrinterFreemarkerException("PrinterVB.start.generateDocument: Errore durante la fase di merge",e);
            } finally {
                    try {
                        FileUtils.deleteDirectory(new File(percorso));
                    } catch (IOException e) {
                        LoggingUtils.debug(e.getMessage());
                    }
            }
    }

}
