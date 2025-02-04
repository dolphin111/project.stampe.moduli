package com.fideuram.chart.mock;

import com.fideuram.chart.configuration.Colore;
import com.fideuram.chart.lab.ConfigurationGraph;
import com.fideuram.chart.lab.Colori;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by
 * User: logan
 * Date: 22/02/13
 * Time: 11.22
 */
public class MockBase {
    public static ConfigurationGraph getConfigurationBar(boolean invertiColori){
        ConfigurationGraph cb = new ConfigurationGraph();

        Colori colori = new Colori();
        ArrayList colorList = new ArrayList();
        //colorList.add(new Color(80,170,150));
        //colorList.add(new Color(51,51,51));
        if(invertiColori){
            colorList.add(new Colore(51,51,51));
            colorList.add(new Colore(80,170,150));
        }else{
            colorList.add(new Colore(80,170,150));
            colorList.add(new Colore(51,51,51));
        }
        colori.setPantoni(colorList);
        cb.setColori(colori);

        cb.setxPixelDimension(500);
        cb.setyPixelDimension(300);
        cb.setOrientation(ConfigurationGraph.ORIENTATION_VERTICALE);
        //cb.setOrientation(ConfigurationBar.ORIENTATION_ORIZZONTALE);


        //cb.setTagItemValue(true); //true se vuoi vedere il valore esatto di ogni singola barra
        cb.setOmbraSulleBarre(false);
        cb.setLegenda(true);
        cb.setTooltip(true);
        return cb;
    }

    public static ConfigurationGraph getConfigurationLine(boolean invertiColori){
        ConfigurationGraph cb = new ConfigurationGraph();
        //cb.setGridTick(5.0);
        Colori colori = new Colori();
        ArrayList colorList = new ArrayList();
        if(invertiColori){
            colorList.add(new Colore(51,51,51));
            colorList.add(new Colore(80,170,150));
        }else{
            colorList.add(new Colore(80,170,150));
            colorList.add(new Colore(51,51,51));
        }
        colori.setPantoni(colorList);
        cb.setColori(colori);

        cb.setxPixelDimension(500);
        cb.setyPixelDimension(300);
        cb.setOrientation(ConfigurationGraph.ORIENTATION_VERTICALE);
        //cb.setOrientation(ConfigurationBar.ORIENTATION_ORIZZONTALE);

        //cb.setTagItemValue(true); //true se vuoi vedere il valore esatto di ogni singola barra
        cb.setOmbraSulleBarre(false);
        cb.setLegenda(true);
        cb.setTooltip(true);
        return cb;
    }


}
