package com.fideuram.chart.grafici.test;

import com.fideuram.chart.configuration.Colore;
import com.fideuram.chart.configuration.Configurazione;
import com.fideuram.chart.grafici.linea.LineaSemplice;
import com.fideuram.chart.grafici.linea.bean.Linea;
import com.fideuram.chart.grafici.linea.bean.Punto;
import com.fideuram.utils.Streamer;

import java.util.GregorianCalendar;

/**
 * Created with IntelliJ IDEA.
 * User: logan
 * Date: 31/07/13
 * Time: 12.07
 */
public class TestLineaSemplice {
    public static void main(String[] args) throws Exception {
        Configurazione configurazione=new Configurazione();
        configurazione.setBackColor(new Colore(255,255,255));
        configurazione.setGridColor(new Colore(0, 0, 0));
        configurazione.setFontObliquo(true);
        configurazione.setCurvedLine(true);
        configurazione.setPercentualeUpDowngridRange(15);
        configurazione.setLegenda(false);
        configurazione.setFontSize(10);
        Linea l = new Linea();
        l.setConfigurazione(configurazione);
        l.setHeader("Header");
        l.setYaxis("ASSE Y");
        l.setXaxis("");
        l.setColore(new Colore(69,114,167));
        l.addPunto(new Punto(new GregorianCalendar(2013,01,01).getTime(), new Double(0.0)));
        l.addPunto(new Punto(new GregorianCalendar(2013,02,01).getTime(), new Double(-0.65)));
        l.addPunto(new Punto(new GregorianCalendar(2013,03,01).getTime(), new Double(-4.30)));

        /*
        l.addPunto(new Punto(new GregorianCalendar(2013,01,01).getTime(), new Double(0.0)));
        l.addPunto(new Punto(new GregorianCalendar(2013,02,01).getTime(), new Double(1.80)));
        l.addPunto(new Punto(new GregorianCalendar(2013,03,01).getTime(), new Double(0.20)));
        l.addPunto(new Punto(new GregorianCalendar(2013,04,01).getTime(), new Double(0.10)));
        l.addPunto(new Punto(new GregorianCalendar(2013,05,01).getTime(), new Double(3.00)));
        l.addPunto(new Punto(new GregorianCalendar(2013,05,01).getTime(), new Double(6.00)));
        l.addPunto(new Punto(new GregorianCalendar().getTime(), new Double(2.65)));
        */

        byte[] grafico1= new LineaSemplice().generateToDelete(l);
        Streamer.saveToFile(grafico1, "C:/Stampe/out/tmp/", "curvasemplice1.png");
        byte[] grafico2= new LineaSemplice().generate(l);
        Streamer.saveToFile(grafico2, "C:\\Stampe\\out\\tmp\\", "curvasemplice2.png");
    }
}
