package com.fideuram.processo.prospetti;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.fideuram.costanti.Templates;
import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.processo.GraficiGenerator;
import com.fideuram.template.TemplateFinder;
import com.fideuram.utils.LoggingUtils;

import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

/**
 * Created by
 * User: logan
 * Date: 11/06/12
 * Time: 11.15
 */
public abstract class ProspettoBase {
    protected String                nomeFileOdt;
    protected PubblicazioneConsob   pubblicazioneConsob;
    protected String                percorso;


    //definizione dei processi
    protected  static int FV_GENERICO_PART_I                 =10;
    protected  static int FV_PROSPETTO_SISNTETICO_GENERICO   =11;
    protected  static int FV_GENERICO_PARTE_II               =20;

    protected  static int FV_INSIEME_PART_II                 =21;
    protected  static int FV_FACILE_PART_II                  =23;
    protected  static int FV_PREMIUN44_PART_II               =24;
    protected  static int FV_PREMIUN_PART_II               	 =51;
    protected  static int FV_GENERICO_PART_III               =30;

    protected  static int FV_SUPPLEMENTO_GENERICO            =40;
    protected  static int FV_SUPPLEMENTO_SINTETICO_GENERICO  =41;

    //processi di rendiconto
    protected  static int RENDICONTO_PROSPETTO =50;
    //scheda sintesi gemini
    protected static int FV_GEMINI_DDENDUM = 642;
    protected static int FV_GEMINI_SCHEDA_SINTETICA = 640;
    protected static int FV_GEMINI_NOTA_INFORMATIVA = 64;
    protected static int FV_GEMINI_ADDENDUM = 642;
    protected static int FV_SINTONIA_ADDENDUM = 662;
    protected static int FV_SINTONIA_SCHEDA_SINTETICA = 660;
    protected static int FV_SINTONIA_NOTA_INFORMATIVA =66;
    protected static int FV_GEMINI_RENDICONTO = 641;
    protected static int FV_SINTONIA_RENDICONTO = 661;

    protected InputStream getTemplate(int template) throws TemplateLoaderExcepion {
        switch (template){
            case 10:
                nomeFileOdt=Templates.PROSPETTO_GENERICO_PARTE_I;
                break;
            case 11:
                nomeFileOdt=Templates.PROSPETTO_GENERICO_SINTETICO;
                break;
            case 20:
                nomeFileOdt=Templates.PROSPETTO_GENERICO_PARTE_II;
                break;
            case 21:
                nomeFileOdt=Templates.PROSPETTO_DI_OFFERTA_FV_INSIEME_PARTE_II;
                break;
            case 23:
                nomeFileOdt=Templates.PROSPETTO_DI_OFFERTA_FV_FACILE_PARTE_II;
                break;
            case 24:
                nomeFileOdt=Templates.PROSPETTO_DI_OFFERTA_FV_PREMIUN44_PARTE_II;
                break;
            case 30:
                nomeFileOdt=Templates.PROSPETTO_GENERICO_PARTE_III;
                break;
            case 40:
                nomeFileOdt=Templates.PROSPETTO_DI_OFFERTA_FV_SUPPLEMENTO_GENERICO;
                break;
            case 41:
                nomeFileOdt=Templates.PROSPETTO_GENERICO_SINTETICO_SUPPLEMENTO;
                break;
            case 50:
                nomeFileOdt=Templates.PROSPETTO_GENERICO_RENDICONTOO;
                break;
            case 51:
            	nomeFileOdt = Templates.PROSPETTO_DI_OFFERTA_FV_INSIEME_PREMIUM_PARTE_II;
            	break;
            case 640:
            	nomeFileOdt = Templates.SCHEDA_SINTESI_FV_INSIEME;
            	break;
            case 642:
            	nomeFileOdt = Templates.ADDENDUM_GEMINI;
            	break;
            case 662:
            	nomeFileOdt = Templates.ADDENDUM_MULTIRAMO;
            	break;
            case 64:
            	nomeFileOdt = Templates.NOTA_INFORMATIVA_FV_INSIEME;
            	break;
            case 660:
            	nomeFileOdt = Templates.SCHEDA_SINTESI_FV_SINTONIA;
            	break;
            case 66:
            	nomeFileOdt = Templates.NOTA_INFORMATIVA_FV_SINTONIA;
            	break;
            case 661:
            case 641:
            	nomeFileOdt = Templates.RENDICONTO_MULTIRAMO;
            	break;
            default:
                break;
        }
        return new ByteArrayInputStream(TemplateFinder.getTemplate("Prospetti/onLine/"+nomeFileOdt));
    }

    public abstract File generateDocument(PubblicazioneConsob doc, String dir) throws ProspettoDiOffertaException;

    protected File  start(int template, boolean grafici) throws ProspettoDiOffertaException {
        File allegatoA=null;
        try{
            InputStream in= getTemplate(template);
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Freemarker );

            if(grafici){
                FieldsMetadata metadata = report.createFieldsMetadata();
                metadata.addFieldAsImage( "isin.barra" );
                metadata.addFieldAsImage( "isin.linea" );
                metadata.addFieldAsImage( "isin.cloneDiLinea" );
                metadata.addFieldAsImage( "isin.linea2" );
                PubblicazioneConsob documentoOffertaPremium= new GraficiGenerator().generaIGraphici(pubblicazioneConsob,percorso);
            }

            IContext context = report.createContext();
            context.put( "asset", pubblicazioneConsob );
            LoggingUtils.debug("In Generazione >>" + percorso + nomeFileOdt);
            allegatoA=new File(percorso+nomeFileOdt);
            OutputStream out = new FileOutputStream( allegatoA );
            report.process(context, out);
            out.close();
            LoggingUtils.debug("Generato >>"+percorso+nomeFileOdt);
        } catch (TemplateLoaderExcepion templateLoaderExcepion) {
            LoggingUtils.debug(templateLoaderExcepion.getMessage());
            throw new ProspettoDiOffertaException("Prospetto.start: TemplateLoaderExcepion",templateLoaderExcepion);
        } catch (FileNotFoundException e) {
            LoggingUtils.debug(e.getMessage());
            throw new ProspettoDiOffertaException("Prospetto.start: FileNotFoundException",e);
        } catch (XDocReportException e) {
            LoggingUtils.debug(e.getMessage());
            throw new ProspettoDiOffertaException("Prospetto.start.generateDocument: XDocReportException",e);
        } catch (IOException e) {
            LoggingUtils.debug(e.getMessage());
            throw new ProspettoDiOffertaException("Prospetto.start.generateDocument: IOException",e);
        }
        return allegatoA;
    }



}
