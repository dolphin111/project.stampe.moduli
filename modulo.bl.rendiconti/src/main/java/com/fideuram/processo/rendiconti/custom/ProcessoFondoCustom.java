package com.fideuram.processo.rendiconti.custom;

import com.fideuram.config.CrmProperties;
import com.fideuram.exception.RendicontiException;
import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.jaxb.Converter;
import com.fideuram.processi.ProcessoBase;
import com.fideuram.processo.grafici.GraficiFondoPersonalizzato;
import com.fideuram.stampe.modello.rendiconti.mock.personalizzato.AzzurraMock;
import com.fideuram.stampe.modello.rendiconti.mock.personalizzato.BrasilMock;
import com.fideuram.stampe.modello.rendiconti.mock.personalizzato.ProdottoCustomMock;
import com.fideuram.stampe.modello.rendiconti.prodotto.consob.RtfConsob;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.FondoInternoPersonalizzato;
import com.fideuram.utils.LoggingUtils;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

import java.io.*;

/**
 * User: v801068
 * Date: 30/10/14
 * Time: 10.22
 */
public class ProcessoFondoCustom extends ProcessoBase {
    protected String                     nomeFileOdt;
    protected FondoInternoPersonalizzato fondoInternoPersonalizzato;


    public ProcessoFondoCustom() {
        super();
    }

    public byte[] stampa(FondoInternoPersonalizzato fi) throws RendicontiException {
        nomeFileOdt=fi.getNomeProdotto()+".odt";
        fondoInternoPersonalizzato=fi;
        return start("RendicontoFVI_PERSONALIZZATO_VIP.odt",false);     //TODO MAKE DINAMIC FROM PROPS
    }

    protected byte[] start(String template, boolean grafici) throws RendicontiException {
        GraficiFondoPersonalizzato graficiFondoPersonalizzato=new GraficiFondoPersonalizzato();
        File odt=null;
        byte[] stream;
        try{
            InputStream in= getTemplate(template);
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Freemarker );

            FieldsMetadata metadata = report.createFieldsMetadata();
            metadata.addFieldAsImage( "rendiconto.macroAsset.grafico" );
            //metadata.addFieldAsImage( "rendiconto.bluerating.grafico" );
            //metadata.addFieldAsImage( "rendiconto.assogestioni.grafico" );
            metadata.addFieldAsImage( "rendiconto.scompGeo.grafico" );
            metadata.addFieldAsImage( "rendiconto.compoObblg.grafico" );
            //metadata.addFieldAsImage( "rendiconto.strumentiFinanziari.grafico" );
            //metadata.addFieldAsImage( "rendiconto.gestoriOicr.grafico" );
            metadata.addFieldAsImage( "rendiconto.performance.andamentoGrafico.grafico" );
            //AVVIO GENERAZIONE GRAFICI
            graficiFondoPersonalizzato.generaGrafici(fondoInternoPersonalizzato, percorso);

            IContext context = report.createContext();
            context.put( "rendiconto", fondoInternoPersonalizzato );
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

                //FileUtils.deleteDirectory(new File(percorso));
                LoggingUtils.error("cancellazione della dir " + percorso + "DISATTIVATA");

        }
    }

    public static void main(String args[]) throws Exception {
        //File f= new File(CrmProperties.getProperty("rendiconti.mensili.input")+"CARDI.XML");
        //FondoInternoPersonalizzato fondo = (FondoInternoPersonalizzato) Converter.xml2Object(new FondoInternoPersonalizzato(), f);
        //StreamerFactory.saveFile(new ProcessoFondoCustom().stampa(fondo),CrmProperties.getProperty("rendiconti.mensili.output"),"FVI_CARDIVID.odt");

        File f= new File(CrmProperties.getProperty("rendiconti.mensili.input")+"garda.XML");
        FondoInternoPersonalizzato fondo = (FondoInternoPersonalizzato) Converter.xml2Object(new FondoInternoPersonalizzato(), f);
        StreamerFactory.saveFile(new ProcessoFondoCustom().stampa(fondo),CrmProperties.getProperty("rendiconti.mensili.output"),"FVI_GARDA.odt");
   //      LoggingUtils.info(BrasilMock.getXml());
       // FondoInternoPersonalizzato f= new FondoInternoPersonalizzato();
       // StreamerFactory.saveFile(new ProcessoFondoCustom().stampa(new BrasilMock().getMockBrasil("BRASIL")), CrmProperties.getProperty("rendiconti.mensili.output"),"ANACARDO.odt");

    }
}
