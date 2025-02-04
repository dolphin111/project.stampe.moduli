package com.fideuram.processo.grafici;

import com.fideuram.chart.configuration.Colore;
import com.fideuram.chart.configuration.Configurazione;
import com.fideuram.chart.configuration.Gruppo;
import com.fideuram.chart.grafici.istogramma.IstogrammaMultiplo;
import com.fideuram.chart.grafici.istogramma.bean.BarElement;
import com.fideuram.chart.grafici.istogramma.bean.Istogramma;
import com.fideuram.chart.grafici.linea.LineaMultipla;
import com.fideuram.chart.grafici.linea.bean.Linea;
import com.fideuram.chart.grafici.linea.bean.LineeChart;
import com.fideuram.chart.grafici.linea.bean.Punto;
import com.fideuram.exception.RendicontiException;
import com.fideuram.stampe.modello.rendiconti.Fondo;
import com.fideuram.stampe.modello.rendiconti.RendimentoAnnuo;
import com.fideuram.stampe.modello.rendiconti.RendimentoMensile;
import com.fideuram.stampe.modello.rendiconti.prodotto.NormativaProdottoAllegato;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.xdocreport.CostruttoreImmagini;
import fr.opensagres.xdocreport.document.images.IImageProvider;

import java.awt.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created
 * User: V801068
 * Date: 15/01/14
 * Time: 11.58
 */
public class GraficiRendiconti {
    private Configurazione configurazione;
    private CostruttoreImmagini costruttoreImmagini;

    public GraficiRendiconti() {
        costruttoreImmagini=new CostruttoreImmagini();
    }

    public void generaGrafici(NormativaProdottoAllegato prodotto, String rootContext) throws RendicontiException {
        for(int i=0; i<prodotto.getFondi().size();i++){
            Fondo fondo =  prodotto.getFondi().get(i);
            fondo.setGraficoRendimentoMensile(getLine(fondo,rootContext));
            fondo.setGraficoRendimentoAnnuale(getBar(fondo, rootContext));
        }
    }

    public IImageProvider getBar(Fondo f, String rootContext) throws RendicontiException {
        List<RendimentoAnnuo> rendimentoAnnuos=f.getRendimentoAnnuo();

        Istogramma barra       = new Istogramma();
        barra.setConfigurazione(getConfigurazioneBarra());

        Gruppo fondo=new Gruppo(f.getDescrizioneFondo(),new Colore(51,51,51));
        Gruppo bm=new Gruppo("Benchmark",new Colore(80,170,150));
        Gruppo oldbm=new Gruppo("Old Benchmark",new Colore(255,0,0));
        List<Gruppo> gruppos = new ArrayList<Gruppo>();
        gruppos.add(fondo);
        gruppos.add(bm);
        gruppos.add(oldbm);
        barra.setGruppi(gruppos);

        //verifico se mi trovo nella condizione di avere un grafico con pochi piloni (deformi)
        int countPiloni=0;
        for (int i=rendimentoAnnuos.size();i>0;i--){
            RendimentoAnnuo r=rendimentoAnnuos.get(i-1);
            if(null!=r.getAnno()){
                if( r.getPercFondo()!=null)
                    countPiloni++;
                else if(r.getPercBM()!=null)
                    countPiloni++;
                else if(r.getPercOldBM()!=null)
                    countPiloni++;
            }
        }

        //for (int i=0;i<rendimentoAnnuos.size();i++){
        for (int i=rendimentoAnnuos.size();i>0;i--){
            RendimentoAnnuo r=rendimentoAnnuos.get(i-1);
            if(null!=r.getAnno()){
                if(countPiloni>3){
                    if( r.getPercFondo()!=null)
                        barra.addBarElement(new BarElement(fondo, r.getPercFondo(), r.getAnno() + ""));
                }else{
                    barra.addBarElement(new BarElement(fondo, r.getPercFondo()!=null?r.getPercFondo():0, r.getAnno() + ""));
                }
                if(r.getPercBM()!=null)
                    barra.addBarElement(new BarElement(bm,r.getPercBM(),r.getAnno()+""));
                if(r.getPercOldBM()!=null)
                    barra.addBarElement(new BarElement(oldbm,r.getPercOldBM(),r.getAnno()+""));
            }
        }
        try {
            byte[] grafico=new IstogrammaMultiplo().generate(barra);
            return costruttoreImmagini.getImageProvider(grafico,rootContext);
        } catch (IOException e) {
            LoggingUtils.error(e);
            throw new RendicontiException(e);
        } catch (Exception e) {
            LoggingUtils.error(e);
            throw new RendicontiException(e);
        }
    }

    public IImageProvider getLine(Fondo f,String rootContext) throws RendicontiException {
        List<RendimentoMensile> rendimentoMensiles=f.getValoreUnitarioQuota();

        List<Linea> linee       =new ArrayList<Linea>();

        Linea lineapercfondo    = new Linea();
        lineapercfondo.setColore(new Colore(51,51,51));
        lineapercfondo.setHeader(f.getDescrizioneFondo());

        Linea lineabm           = new Linea();
        lineabm.setColore(new Colore(80,170,150));
        lineabm.setHeader("Benchmark");

        Linea lineaoldbm        = null;

        for (int i=0;i<rendimentoMensiles.size();i++){
            RendimentoMensile r=rendimentoMensiles.get(i);
            if(r.getPercBM()!=null)
                lineabm.addPunto(new Punto(r.getMese(),r.getAnno(),r.getPercBM()));
            if(r.getPercFondo()!=null)
                lineapercfondo.addPunto(new Punto(r.getMese(),r.getAnno(),r.getPercFondo()));
            if(r.getPercOldBM()!=null){
                if(lineaoldbm==null){
                    lineaoldbm        = new Linea();
                    lineaoldbm.setColore(new Colore(255,0,0));
                    lineaoldbm.setHeader("Old Benchmark");
                }
                lineaoldbm.addPunto(new Punto(r.getMese(),r.getAnno(),r.getPercOldBM()));
            }
        }

        if(lineapercfondo.getPunti()!=null)
            linee.add(lineapercfondo);
        if(lineabm.getPunti()!=null)
            linee.add(lineabm);
        if(lineaoldbm!=null)
            linee.add(lineaoldbm);
        try {
            LineeChart l = new LineeChart();
            l.setConfigurazione(getConfigurazioneLinea());
            l.setLinee(linee);
            //byte[] grafico=new LineaMultipla().generate(linee);
            byte[] grafico=new LineaMultipla().generate(l);
            return costruttoreImmagini.getImageProvider(grafico,rootContext);
        } catch (IOException e) {
            LoggingUtils.error(e);
            throw new RendicontiException(e);
        } catch (Exception e) {
            LoggingUtils.error(e);
            throw new RendicontiException(e);
        }
    }


    private Configurazione getConfigurazioneBarra(){
        Configurazione c = new Configurazione();
        c.setLegenda(true);
        c.setTooltip(true);
        c.setxPixelDimension(600);
        c.setyPixelDimension(400);
        //c.setTickGrid(1.25);
        c.setTickGrid(2.50);
        c.setDecimalFormat(new DecimalFormat("#0,00%")); //configura label ascisse
        c.setTickDecimalFormat(new DecimalFormat("##0.00"));//configura label dei piloni
        //c.setTickDecimalFormat(new DecimalFormat("0.00"));
        c.setViewSingleItemValue(true);
        c.setExtraAxisMargin(true);
        c.setFontTitolo("Times New Roman", 16);
        c.setFontLabels("Times New Roman", 14);
        c.setBackColor(new Colore(255,255,255));
        return c;
    }

    private Configurazione getConfigurazioneLinea(){
        Configurazione c = new Configurazione();
        c.setLegenda(true);
        c.setTooltip(true);
        c.setxPixelDimension(400);
        c.setyPixelDimension(400);
        c.setTickGrid(1.25);
        c.setDecimalFormat(new DecimalFormat("0.00"));
        c.setViewSingleItemValue(true);
        c.setExtraAxisMargin(true);
        c.setFontTitolo("Times New Roman",12);
        //c.setFontSize(9);
        c.setBackColor(new Colore(255,255,255));
        return c;
    }

}
