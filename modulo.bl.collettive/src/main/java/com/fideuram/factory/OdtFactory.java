package com.fideuram.factory;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import com.fideuram.bean.Immagini;
import com.fideuram.exception.CollettiveFileDataReadException;
import com.fideuram.modello.elenchiufficiali.ElenchiUfficiali;
import com.fideuram.modello.metodiPagamento.ListMetodiPagamento;
import com.fideuram.modello.tdp.Collettive;
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
 * Date: 09/05/13
 * Time: 12.26
 */
public class OdtFactory {
    public static File generateScartiTDPWithFreemarker(byte[] template, Collettive collettive) throws CollettiveFileDataReadException, Exception {
        Immagini immagini = new Immagini();
        File documento=null;
        InputStream in = null;
        OutputStream out = null;
        try{
            in=  new ByteArrayInputStream(template);
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Freemarker );
            IContext context = report.createContext();

            FieldsMetadata metadata = report.createFieldsMetadata();
            metadata.addFieldAsImage( "immagine.piedino" );
            context.put( "immagine", immagini );
            context.put( "collettive", collettive );

            documento=new File(CrmProperties.getProperty("crm.services.temp.path")+new Date().getTime());
            LoggingUtils.info("generateScartiTDPWithFreemarker method: documentoPath["+documento.getPath()+"]");
            out = new FileOutputStream( documento );
            report.process(context, out);
            report.removeAllPreprocessors();
            LoggingUtils.info("Generato >>");
            
        } catch (XDocReportException e) {
            LoggingUtils.error(e.getMessage());
            throw new CollettiveFileDataReadException("OdtFactory.generateScartiTDPWithFreemarker: XDocReportException",e);
        } catch (IOException e) {
            LoggingUtils.error(e.getMessage());
            throw new CollettiveFileDataReadException("OdtFactory.generateScartiTDPWithFreemarker: IOException",e);
        } catch (Exception e){
        	LoggingUtils.error("Eccezione generica: ["+e.getMessage()+"]");
            throw new Exception("OdtFactory.generateScartiTDPWithFreemarker: Exception",e);
        }
        finally{
        	if(in!=null)
        		in.close();
        	if(out!=null)
        		out.close();
        }
        return documento;
    }
    
    public static File generateMetodiPagamento(byte[] template, ListMetodiPagamento metodiPagamento) throws CollettiveFileDataReadException, Exception {
        File documento=null;
        InputStream in = null;
        OutputStream out = null;
        try{
            in=  new ByteArrayInputStream(template);
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Freemarker );
            
            IContext context = report.createContext();
            context.put( "metodiPagamento", metodiPagamento );

            documento=new File(CrmProperties.getProperty("crm.services.temp.path")+new Date().getTime()+".pdf");
            LoggingUtils.info("generateMetodiScarti method: documentoPath["+documento.getPath()+"]");
            out = new FileOutputStream( documento );
            report.process(context, out);
            //report.removeAllPreprocessors();
            LoggingUtils.info("Generato >>");
            
        } catch (XDocReportException e) {
            LoggingUtils.error(e.getMessage());
            throw new CollettiveFileDataReadException("OdtFactory.generateMetodiScarti: XDocReportException",e);
        } catch (IOException e) {
            LoggingUtils.error(e.getMessage());
            throw new CollettiveFileDataReadException("OdtFactory.generateMetodiScarti: IOException",e);
        } catch (Exception e){
        	LoggingUtils.error("Eccezione generica: ["+e.getMessage()+"]");
            throw new Exception("OdtFactory.generateMetodiScarti: Exception",e);
        }
        finally{
        	if(in!=null)
        		in.close();
        	if(out!=null)
        		out.close();
        }
        return documento;
    }
    
    public static File generateElenchiUfficiali(byte[] template, ElenchiUfficiali elenchiUfficiali) throws CollettiveFileDataReadException, Exception {
        File documento=null;
        InputStream in = null;
        OutputStream out = null;
        try{
            in=  new ByteArrayInputStream(template);
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Freemarker );
            
            IContext context = report.createContext();
            context.put( "elUff", elenchiUfficiali );

            documento=new File(CrmProperties.getProperty("crm.services.temp.path")+new Date().getTime()+".pdf");
            LoggingUtils.info("generateElenchiUfficiali method: documentoPath["+documento.getPath()+"]");
            out = new FileOutputStream( documento );
            report.process(context, out);
            //report.removeAllPreprocessors();
            LoggingUtils.info("Generato >>");
            
        } catch (XDocReportException e) {
            LoggingUtils.error(e.getMessage());
            throw new CollettiveFileDataReadException("OdtFactory.generateMetodiScarti: XDocReportException",e);
        } catch (IOException e) {
            LoggingUtils.error(e.getMessage());
            throw new CollettiveFileDataReadException("OdtFactory.generateMetodiScarti: IOException",e);
        } catch (Exception e){
        	LoggingUtils.error("Eccezione generica: ["+e.getMessage()+"]");
            throw new Exception("OdtFactory.generateMetodiScarti: Exception",e);
        }
        finally{
        	if(in!=null)
        		in.close();
        	if(out!=null)
        		out.close();
        }
        return documento;
    }
    
    
}
