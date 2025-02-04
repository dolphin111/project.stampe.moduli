package com.fideuram.processo.rendiconti;

import com.fideuram.exception.RendicontiException;
import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.processi.ProcessoBase;
import com.fideuram.processo.grafici.GraficiRendiconti;
import com.fideuram.stampe.modello.rendiconti.prodotto.NormativaProdottoAllegato;
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
 * Created with
 * User: V801068
 * Date: 10/01/14
 * Time: 15.24
 */
public class ProcessoGenericoRendiconti extends ProcessoBase {
    protected String                     nomeFileOdt="RendicontoFgp.odt";
    protected NormativaProdottoAllegato  normativaProdottoAllegato;
    protected GraficiRendiconti          graficiRendiconti;

    protected ProcessoGenericoRendiconti() {
        super();
        graficiRendiconti=new GraficiRendiconti();
    }



    protected byte[] start(String template, boolean grafici) throws RendicontiException {
        File odt=null;
        byte[] stream;
        try{
            InputStream in= getTemplate(template);
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Freemarker );

            FieldsMetadata metadata = report.createFieldsMetadata();
            metadata.addFieldAsImage( "isin.graficoRendimentoAnnuale" );
            metadata.addFieldAsImage( "isin.graficoRendimentoMensile" );
                //AVVIO GENERAZIONE GRAFICI
                graficiRendiconti.generaGrafici(normativaProdottoAllegato,percorso);
            IContext context = report.createContext();
            context.put( "rendiconto", normativaProdottoAllegato );
            odt=new File(percorso+nomeFileOdt);
            OutputStream out = new FileOutputStream( odt );
            report.process(context, out);
            out.close();
            LoggingUtils.debug("Generato >>"+percorso+nomeFileOdt);
            stream = new byte[0];
            stream = StreamerFactory.getStreamFromFile(odt);
            return stream;
        } catch (TemplateLoaderExcepion templateLoaderExcepion) {
            LoggingUtils.error(templateLoaderExcepion);
            throw new RendicontiException("ProcessoGenericoRendiconti.start: TemplateLoaderExcepion",templateLoaderExcepion);
        } catch (FileNotFoundException e) {
            LoggingUtils.error(e);
            throw new RendicontiException("ProcessoGenericoRendiconti.start: FileNotFoundException",e);
        } catch (XDocReportException e) {
            LoggingUtils.error(e);
            throw new RendicontiException("ProcessoGenericoRendiconti.start.generateDocument: XDocReportException",e);
        } catch (IOException e) {
            LoggingUtils.error(e);
            throw new RendicontiException("ProcessoGenericoRendiconti.start.generateDocument: IOException",e);
        } finally {
            try {
                FileUtils.deleteDirectory(new File(percorso)); //.deleteDirectory(new File(percorso));
            } catch (IOException e) {
                LoggingUtils.error(e);
            }
        }

    }



}
