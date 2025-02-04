package com.fideuram.processo;

import com.fideuram.chart.lab.ConfigurationGraph;
import com.fideuram.chart.lab.bar.IstogrammaEngine;
import com.fideuram.chart.configuration.Colore;
import com.fideuram.chart.lab.Colori;
import com.fideuram.chart.lab.line.LineaMonthEngine;
import com.fideuram.config.CrmProperties;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.modello.chart.BarraBean;
import com.fideuram.modello.chart.LineaTimeBean;
import com.fideuram.modello.selection.Fundhouse;
import com.fideuram.modello.selection.Isin;
import com.fideuram.modello.selection.SelectionFund;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.xdocreport.HackPathImageProvider;
import fr.opensagres.xdocreport.document.images.IImageProvider;
import org.jfree.data.general.SeriesException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import com.fideuram.chart.lab.line.LineaDay;

/**
 * Created by
 * User: logan
 * Date: 13/02/13
 * Time: 11.51
 */
public class GraficiGenerator {
    public PubblicazioneConsob generaIGraphici(PubblicazioneConsob doc, String dir){
        List houses = doc.getSelectionFunds()!=null?doc.getSelectionFunds():new ArrayList();
        for (int i=0; i<houses.size(); i++){
            SelectionFund selectionFund = (SelectionFund) houses.get(i);
            List packs = selectionFund.getFundhouses();
            for (int x=0; x<packs.size(); x++){
                Fundhouse pack = (Fundhouse) packs.get(x);
                List isins = pack.getIsins();
                for(int y=0; y<isins.size();y++){
                    Isin isin = (Isin) isins.get(y);
                    if(isin.getStampaGrafico().equalsIgnoreCase("SI")){
                        if(isin.getBarraGraph()!=null){  //verifico che i dati per il grafico a barre ci siano
                            IImageProvider iImageProviderBarra =getBarraImageProvider(dir,isin.getBarraGraph(), isin.getCodiceIsin()+"g1");
                            isin.setBarra(iImageProviderBarra);

                            //prendo la seconda immagine
                            try{
                                if((isin.getLineaGraph()!=null)&&(isin.getLineaGraph().size()>0)){
                                    //if((isin.getLineaGraph()!=null)&&(isin.getLineaGraph().size()>0)&&(isin.getLineaGraph().get(0).getLinee()!=null)){ //verifico che i dati per il grafico linee ci siano
                                    IImageProvider iImageProviderLInnee =getLineImageProvider(dir,isin.getLineaGraph().get(0), isin.getCodiceIsin()+"g21");
                                    isin.setLinea(iImageProviderLInnee);

                                    if(isin.getLineaGraph().size()>1){
                                        iImageProviderLInnee =getLineImageProvider(dir,isin.getLineaGraph().get(1), isin.getCodiceIsin()+"g22");
                                        isin.setLinea2(iImageProviderLInnee);
                                    }
                                }
                            }catch (Exception e){
                                LoggingUtils.error(e);
                            }
                        }
                    }
                }
            }
        }
        return doc;
    }

    protected IImageProvider getBarraImageProvider(String dir, BarraBean barraGraph,String nome){
        barraGraph.getBarre().setYaxis("Valori %");
        try {
            ConfigurationGraph cb = new ConfigurationGraph();
            //cb.setGridTick(5.0);
            Colori colori = new Colori();
            ArrayList colorList = new ArrayList();
            if(!barraGraph.isOnlyBmkValue())
               colorList.add(new Colore(80,170,150));
            colorList.add(new Colore(51,51,51));
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
            new IstogrammaEngine().generate(barraGraph.getBarre(),dir,nome,cb);
        } catch (IOException e) {
            LoggingUtils.error(e);
            e.printStackTrace();
            return new HackPathImageProvider(CrmProperties.getProperty("stampe.fs.images")+"Prospetti"+File.separator+"GraficoVuoto.gif");
        } catch (Exception e) {
                LoggingUtils.error(e);
                e.printStackTrace();
                return new HackPathImageProvider(CrmProperties.getProperty("stampe.fs.images")+"Prospetti"+File.separator+"GraficoVuoto.gif");
        }
        return new HackPathImageProvider(dir+nome+".png");
    }

    protected IImageProvider getLineImageProvider(String dir, LineaTimeBean lineBean,String nome){
        ConfigurationGraph cb = new ConfigurationGraph();
        //cb.setGridTick(5.0);
        Colori colori = new Colori();
        ArrayList colorList = new ArrayList();
        if(!lineBean.isHasOicr()){
            colorList.add(new Colore(51,51,51));
            colorList.add(new Colore(80,170,150));
        }else {
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
        try {
            new LineaMonthEngine().generate(lineBean,dir, nome,cb); //.generateGrafico(dir,lineBean,nome);
        } catch (SeriesException e) {
            LoggingUtils.error(e);
            return new HackPathImageProvider(CrmProperties.getProperty("stampe.fs.images")+"Prospetti"+File.separator+"GraficoVuoto.gif");
        } catch (IOException e) {
            LoggingUtils.error(e);
            return new HackPathImageProvider(CrmProperties.getProperty("stampe.fs.images")+"Prospetti"+File.separator+"GraficoVuoto.gif");
        }catch (Exception e) {
            LoggingUtils.error(e);
            e.printStackTrace();
            return new HackPathImageProvider(CrmProperties.getProperty("stampe.fs.images")+"Prospetti"+File.separator+"GraficoVuoto.gif");
        }
        return new HackPathImageProvider(dir+nome+"linea.png");
    }
}
