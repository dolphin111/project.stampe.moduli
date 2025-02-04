package com.fideuram.chart.grafici.test;

import com.fideuram.chart.configuration.Colore;
import com.fideuram.chart.configuration.Configurazione;
import com.fideuram.chart.configuration.Gruppo;
import com.fideuram.chart.grafici.istogramma.SempliceMulticolor;
import com.fideuram.chart.grafici.istogramma.bean.BarElement;
import com.fideuram.chart.grafici.istogramma.bean.Istogramma;
import com.fideuram.chart.mock.generici.istogramma.IstogrammaGenerico;
import com.fideuram.utils.Streamer;

import java.io.IOException;

/**
 * Created with
 * User: logan
 * Date: 31/07/13
 * Time: 10.40
 */
public class TestBarSempliceMulticolorVerticale {
    public static void main(String args[]) throws Exception {
       TestBarSempliceMulticolorVerticale t=new TestBarSempliceMulticolorVerticale();
       t.testGenerico();
    }


    private void testGenerico() throws Exception {
        Configurazione configurazione = new Configurazione();
        configurazione.setxPixelDimension(800);
        configurazione.setyPixelDimension(450);
        configurazione.setLegenda(false);
        configurazione.setFontSize(7);
        configurazione.setFontObliquo(true);
        configurazione.setPercentualeUpDowngridRange(5);
        Istogramma istogramma = new Istogramma();
        istogramma.setConfigurazione(configurazione);

        istogramma.setHeader("Andamento Finanziario");
        istogramma.setYaxis("Controvalore");
        Gruppo gruppo =new Gruppo(istogramma.getYaxis(),new Colore(69,114,167));

        istogramma.addBarElement(new BarElement(gruppo, 2027367.36, "APRILE 13"));
        istogramma.addBarElement(new BarElement(gruppo, 3322697.92, "MAGGIO 13"));
        istogramma.addBarElement(new BarElement(gruppo, 3185114.18, "GIUGNO 13"));
        istogramma.addBarElement(new BarElement(gruppo, 3207902.61, "LUGLIO 13"));

        byte[] grafico = new SempliceMulticolor().generate(istogramma);
        Streamer.saveToFile(grafico, "/tmp/", "BarraVerticale.png");

    }
}
