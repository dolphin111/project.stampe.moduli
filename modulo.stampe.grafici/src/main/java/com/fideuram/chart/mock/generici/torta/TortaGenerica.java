package com.fideuram.chart.mock.generici.torta;

import com.fideuram.chart.configuration.Colore;
import com.fideuram.chart.grafici.torta.bean.Fetta;
import com.fideuram.chart.grafici.torta.bean.Torta;

/**
 * Created with
 * User: logan
 * Date: 02/07/13
 * Time: 11.07
 */
public class TortaGenerica {
    public static Torta getMock(){
        Torta torta  = new Torta();
        Fetta fetta1 = new Fetta("ABCDEGFHILMNOPQRSTUVZ",10.00,new Colore(250,0,250));
        Fetta fetta2 = new Fetta("BBCDEGFHILMNOPQRSTUVZ",9.00,new Colore(200,0,250));
        Fetta fetta3 = new Fetta("CBCDEGFHILMNOPQRSTUVZ",3.00,new Colore(150,0,250));
        Fetta fetta4 = new Fetta("DBCDEGFHILMNOPQRSTUVZ",5.00,new Colore(0,100,250));
        Fetta fetta5 = new Fetta("EBCDEGFHILMNOPQRSTUVZ",10.00,new Colore(0,100,200));
        Fetta fetta6 = new Fetta("FBCDEGFHILMNOPQRSTUVZ",10.00,new Colore(0,100,150));
        Fetta fetta7 = new Fetta("GBCDEGFHILMNOPQRSTUVZ",10.00,new Colore(100,0,250));
        Fetta fetta8 = new Fetta("HBCDEGFHILMNOPQRSTUVZ",10.00,new Colore(100,0,200));
        Fetta fetta9 = new Fetta("IBCDEGFHILMNOPQRSTUVZ",10.00,new Colore(100,0,150));
        Fetta fetta0 = new Fetta("LBCDEGFHILMNOPQRSTUVZ",23.00,new Colore(100,250,0));
        torta.addFettas(fetta1);
        torta.addFettas(fetta2);
        torta.addFettas(fetta3);
        torta.addFettas(fetta4);
        torta.addFettas(fetta5);
        torta.addFettas(fetta6);
        torta.addFettas(fetta7);
        torta.addFettas(fetta8);
        torta.addFettas(fetta9);
        torta.addFettas(fetta0);
        torta.setHeader("Torta Generica");
        return torta;
    }
}
