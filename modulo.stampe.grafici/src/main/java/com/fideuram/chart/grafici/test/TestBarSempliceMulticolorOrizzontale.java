package com.fideuram.chart.grafici.test;

import com.fideuram.chart.configuration.Colore;
import com.fideuram.chart.configuration.Configurazione;
import com.fideuram.chart.configuration.Gruppo;
import com.fideuram.chart.grafici.istogramma.SempliceMulticolor;
import com.fideuram.chart.grafici.istogramma.bean.BarElement;
import com.fideuram.chart.grafici.istogramma.bean.Istogramma;
import com.fideuram.utils.Streamer;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: logan
 * Date: 31/07/13
 * Time: 10.39
 */
public class TestBarSempliceMulticolorOrizzontale {
    public static void main(String args[]) throws Exception {
        TestBarSempliceMulticolorOrizzontale t= new TestBarSempliceMulticolorOrizzontale();
        t.testSoloNegativi();
    }


    private void testSoloNegativi() throws Exception {
        Configurazione configurazione=getConfigurazione();

        Istogramma istogramma = new Istogramma();
        istogramma.setConfigurazione(configurazione);

        istogramma.setHeader("Rendimenti consolidati per fondo da inizio gestione");
        istogramma.setYaxis("Rendimento %");

        Gruppo gruppo =new Gruppo(istogramma.getYaxis(),new Colore(0,102,51));
        istogramma.addBarElement(new BarElement(gruppo,-3.94032,"FONDITALIA FLEXIBLE BOND \"T\""));
        istogramma.addBarElement(new BarElement(gruppo,-7.38374,"PIMCO DIVERSIFIED INCOME INST (EUR HDG)"));
        istogramma.addBarElement(new BarElement(gruppo,-6.16013,"INVESCO BALANCED RISK ALLOCATION \"C\""));
        istogramma.addBarElement(new BarElement(gruppo,-6.25954,"PIMCO TOTAL RETURN BOND \"I\" (EURO HDG)"));
        istogramma.addBarElement(new BarElement(gruppo,-3.48189,"TEMPLETON GLB TOT RETURN \"I\" ACC (EUR H1)"));
        istogramma.addBarElement(new BarElement(gruppo,-4.50658,"TEMPLETON GLOBAL BOND \"I\" (EUR HDG)"));


        byte[] grafico = new SempliceMulticolor().generate(istogramma);
        Streamer.saveToFile(grafico, "/tmp/", "BarraSoloNegativiOrizzontale.png");

    }

    private void testValoriMisti() throws Exception {
        Configurazione configurazione=getConfigurazione();

        Istogramma istogramma = new Istogramma();
        istogramma.setConfigurazione(configurazione);

        istogramma.setHeader("Andamento Finanziario");
        istogramma.setYaxis("Controvalore");
        //Gruppo gruppo =new Gruppo(istogramma.getYaxis(),new Colore(31,53,124));
        Gruppo gruppo =new Gruppo(istogramma.getYaxis(),new Colore(0,102,51));
        istogramma.addBarElement(new BarElement(gruppo,-2.5488,"Gennaio 12"));
        istogramma.addBarElement(new BarElement(gruppo,-3.129,"Febbraio 12"));
        istogramma.addBarElement(new BarElement(gruppo,-5.7151, "Marzo 12"));
        istogramma.addBarElement(new BarElement(gruppo,-2.6793,"Aprile 12"));
        istogramma.addBarElement(new BarElement(gruppo,-2.005,"Maggio 12"));
        istogramma.addBarElement(new BarElement(gruppo,-11.2632,"Giugno 12"));
        istogramma.addBarElement(new BarElement(gruppo,-0.9972,"Luglio 12"));
        istogramma.addBarElement(new BarElement(gruppo,-0.9043,"Agosto 12"));
        istogramma.addBarElement(new BarElement(gruppo,-11.1239,"Settembre 12"));
        istogramma.addBarElement(new BarElement(gruppo,81.00,"Ottobbre 12"));
        istogramma.addBarElement(new BarElement(gruppo, -75.00,"Novembre 12"));
        istogramma.addBarElement(new BarElement(gruppo,80.00,"Dicembre 12"));
        byte[] grafico = new SempliceMulticolor().generate(istogramma);
        Streamer.saveToFile(grafico, "/tmp/", "SempliceMulticoloOrizzontale.png");
    }

    private Configurazione getConfigurazione(){
        Configurazione configurazione = new Configurazione();
        configurazione.setyPixelDimension(500);
        configurazione.setOrientation(1);
        configurazione.setBackColor(new Colore(255, 255, 255));
        configurazione.setAlarmed(true);
        configurazione.setLegenda(false);
        return configurazione;
    }

}
