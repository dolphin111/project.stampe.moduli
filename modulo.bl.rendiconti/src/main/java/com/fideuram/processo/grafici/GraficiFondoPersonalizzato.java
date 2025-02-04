package com.fideuram.processo.grafici;

import com.fideuram.chart.configuration.Colore;
import com.fideuram.chart.configuration.Configurazione;
import com.fideuram.chart.exception.GraphException;
import com.fideuram.chart.grafici.linea.LineaFondoCustom;
import com.fideuram.chart.grafici.linea.LineaSemplice;
import com.fideuram.chart.grafici.linea.bean.Linea;
import com.fideuram.chart.grafici.linea.bean.Punto;
import com.fideuram.chart.grafici.torta.TortaChartEngine;
import com.fideuram.chart.grafici.torta.TortaFondiCustom;
import com.fideuram.chart.grafici.torta.bean.Fetta;
import com.fideuram.chart.grafici.torta.bean.Torta;
import com.fideuram.exception.RendicontiException;
import com.fideuram.stampe.modello.rendiconti.grafici.linea.ElementoLinea;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.*;
import com.fideuram.stampe.modello.rendiconti.grafici.torta.EelementoTorta;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.andamento.AndamentoGrafico;
import com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.gestione.*;
import com.fideuram.xdocreport.CostruttoreImmagini;
import fr.opensagres.xdocreport.document.images.IImageProvider;

import java.awt.*;
import java.io.IOException;
import java.util.List;

/**
 * User: v801068
 * Date: 30/10/14
 * Time: 17.57
 */
public class GraficiFondoPersonalizzato {
    private  String percorso="";

    public void generaGrafici(FondoInternoPersonalizzato prodotto, String rootContext) throws RendicontiException {
         percorso=rootContext;
         tortaMacroAsset(prodotto.getMacroAsset());
         //tortaBluerating(prodotto.getBluerating());
         //tortaAssogestioni(prodotto.getAssogestioni());
         tortaScompGeo(prodotto.getScompGeo());
         tortaComposizioneObbligazionaria(prodotto.getCompoObblg());
         //tortaStrumentiFinanziari(prodotto.getStrumentiFinanziari());
         //tortaGestoriOicr(prodotto.getGestoriOicr());
         lineaAndamento(prodotto.getPerformance().getAndamentoGrafico());
    }

    public void tortaBluerating(Bluerating ma) throws RendicontiException {
        byte[] tortina = tortaGenerica(ma.getPercentualiCleaaned());
        ma.setGrafico(getImmagine(tortina));
    }

    public void tortaMacroAsset(MacroAsset ma) throws RendicontiException {
        byte[] tortina = tortaGenerica(ma.getPercentualiCleaaned());
        ma.setGrafico(getImmagine(tortina));
    }

    public void tortaAssogestioni(Assogestioni ma) throws RendicontiException {
        byte[] tortina = tortaGenerica(ma.getPercentualiCleaaned());
        ma.setGrafico(getImmagine(tortina));
    }

    public void tortaScompGeo(ScomposizioneGeografica ma) throws RendicontiException {
        byte[] tortina = tortaGenerica(ma.getPercentualiCleaaned());
        ma.setGrafico(getImmagine(tortina));
    }

    public void tortaComposizioneObbligazionaria(ComposizioneObbligazionaria ma) throws RendicontiException {
        byte[] tortina = tortaGenerica(ma.getPercentualiCleaaned());
        ma.setGrafico(getImmagine(tortina));
    }

    public void tortaStrumentiFinanziari(StrumentiFinanziari ma) throws RendicontiException {
        byte[] tortina = tortaGenerica(ma.getPercentualiCleaaned());
        ma.setGrafico(getImmagine(tortina));
    }

    public void tortaGestoriOicr(GestoriOicr ma) throws RendicontiException {
        byte[] tortina = tortaGenerica(ma.getPercentualiCleaaned());
        ma.setGrafico(getImmagine(tortina));
    }



    public byte[] tortaGenerica(List assets) throws RendicontiException {
         Torta torta = new Torta();

         for(int i=0; i<assets.size();i++){
             EelementoTorta b= (EelementoTorta) assets.get(i);
             //questa gestione dei colori dovrebbe permettere
             //la sostituzione dei colori di tutte le fettine, di nessuna o solo di alcune.
             //todo verificare se effettivamente funziona così:
             if(null!=b.getCodiceColore()){
               Color  c = Color.decode(b.getCodiceColore());
               Colore colore =  new Colore(c.getRed(), c.getGreen(), c.getBlue());
               torta.addFettas(new Fetta(b.getKey(),b.getValue(),colore));
             }else{
               torta.addFettas(new Fetta(b.getKey(),b.getValue()));
             }

         }
        torta.setConfigurazione(getConfigurazioneTorta());
        try {
            //return new TortaChartEngine().generate(torta);
            return new TortaFondiCustom().generate(torta);
        } catch (IOException e) {
            throw new RendicontiException(e);
        }
    }

    /**
     * Grafico Linea
     * @param ma
     * @throws RendicontiException
     */
    public void lineaAndamento(AndamentoGrafico ma) throws RendicontiException {
        byte[] linietta = lineaGenerica(ma.getAndamento());
        ma.setGrafico(getImmagine(linietta));
    }

    public byte[] lineaGenerica(List periodoOsservazione) throws RendicontiException {
        Linea linea = new Linea();
        linea.setConfigurazione(getConfigurazionLinea());
        //linea.setColore(new Colore(99,151,208));
        linea.setColore(new Colore(146,144,132));
        linea.setHeader(" Prezzo netto Quote ");
        for(int i=0; i<periodoOsservazione.size();i++){
            try {
                ElementoLinea el = (ElementoLinea) periodoOsservazione.get(i);
                linea.addPunto(new Punto(el.getData(),el.getValue()));

            } catch (GraphException e) {
                throw new RendicontiException(e);
            }

        }
        try {
            //return new LineaSemplice().generate(linea);
            return new LineaFondoCustom().generate(linea);
        } catch (IOException e) {
            throw new RendicontiException(e);
        }
    }


    private Configurazione getConfigurazioneTorta(){
        Configurazione configurazione = new Configurazione();
        configurazione.setFontLabelColor(new Colore(146,144,132));
        configurazione.setFontLabels("HelveticaNeueLT Std Lt",15);
        configurazione.setValoriOverTheeTop(true);
        configurazione.setValoriOverTheeTopSymbolPercent(true);
        configurazione.set_3D(false);
        configurazione.setOmbra(false);
        configurazione.setBackColor(new Colore(55,55,55));
        configurazione.setGridColor(new Colore(0, 0, 0));

        return configurazione;
    }
    private Configurazione getConfigurazionLinea(){

        Configurazione configurazione=new Configurazione();
        configurazione.setBackColor(new Colore(255,255,255));
        configurazione.setGridColor(new Colore(0, 0, 0));
        configurazione.setFontLabelColor(new Colore(146,144,132));
        configurazione.setFontLabels("HelveticaNeueLT Std Lt",16);
        configurazione.setFontTitolo("HelveticaNeueLT Std Lt",18);
        configurazione.setFontObliquo(true);
        configurazione.setCurvedLine(true);
        configurazione.setPercentualeUpDowngridRange(15);
        configurazione.setTooltip(false);
        configurazione.setLegenda(false);
        configurazione.setEvidenziaIlPunto(false);
        configurazione.setyPixelDimension(500);
        configurazione.setxPixelDimension(1000);
        //configurazione.setFontSize(12);
        configurazione.setTickGrid(10.00);
        return configurazione;
    }
    private IImageProvider getImmagine(byte[] tortina) throws RendicontiException {
        CostruttoreImmagini costruttoreImmagini=new CostruttoreImmagini();
        try {
            return costruttoreImmagini.getImageProvider(tortina,percorso);
        } catch (Exception e) {
            throw new RendicontiException(e);
        }
    }
}
