package com.fideuram.chart.grafici.istogramma;

import com.fideuram.chart.Chart;
import com.fideuram.chart.configuration.Configurazione;
import com.fideuram.chart.grafici.istogramma.bean.BarElement;
import com.fideuram.chart.configuration.Gruppo;
import com.fideuram.chart.grafici.istogramma.bean.Istogramma;
import com.fideuram.chart.mock.generici.istogramma.IstogrammaGenerico;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.Streamer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



/**
 * Created with
 * User: logan
 * Date: 02/07/13
 * Time: 12.37
 */
public class IstogrammaMultiplo extends Chart {
    List gruppi;

    public IstogrammaMultiplo() {
        super();
    }

    public byte[] generate(Istogramma fagiolo) throws IOException{
        Configurazione configurazione=fagiolo.getConfigurazione();
        DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
        loadBarre(categoryDataset,fagiolo);
        JFreeChart chart = ChartFactory.createBarChart
                (fagiolo.getHeader(),                       // Header
                        fagiolo.getXaxis(),                 // X-Axis label
                        fagiolo.getYaxis(),                 // Y-Axis label
                        categoryDataset,                    // Dataset
                        configurazione.getOrientation(),
                        configurazione.isLegenda(),       // Show legend
                        configurazione.isTooltip(),
                        configurazione.isUrl()
                );



        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        if(configurazione.getTickGrid()>0.05){

            NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
            yAxis.setTickUnit(new NumberTickUnit(configurazione.getTickGrid()));
            //yAxis.setTickUnit(new NumberTickUnit((xmassimo+(xminimo*-1)/10)));
        }

        BarRenderer renderer = (BarRenderer) plot.getRenderer();





        renderer.setShadowVisible(fagiolo.getConfigurazione().isOmbra());
        if(fagiolo.getConfigurazione().isFlat2dGraph()){
            renderer.setBarPainter(new StandardBarPainter());
        }

        if(configurazione.isViewSingleItemValue()){
            if(null!=fagiolo.getBarElements()){
                for(int i=0;i<fagiolo.getBarElements().size();i++){
                    renderer.setSeriesItemLabelGenerator(i, new StandardCategoryItemLabelGenerator("{2}", configurazione.getTickDecimalFormat()));
                    renderer.setSeriesItemLabelsVisible(i, true);
                    renderer.setSeriesItemLabelFont(i,new Font("Arial",Font.PLAIN, 8));
                }
            }
            chart.getCategoryPlot().setRenderer(renderer);
        }


        if(configurazione.getFontTitolo()!=null){
            LegendTitle legendTitle = chart.getLegend();
            legendTitle.setItemFont(configurazione.getFontTitolo());
            legendTitle.setNotify(true);
        }


        if(configurazione.getFontLabels()!=null){
            chart.getLegend().setItemFont(configurazione.getFontLabels());
            //renderer.setBaseLegendTextFont(new Font("Arial",Font.PLAIN, 2));
        }

        plot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
        plot.setRangeGridlinePaint(Color.gray);
        plot.setDomainCrosshairPaint(fagiolo.getConfigurazione().getBackColor().getColor());
        plot.setBackgroundPaint(fagiolo.getConfigurazione().getBackColor().getColor());

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        if(null!=fagiolo.getBarElements()&&fagiolo.getBarElements().size()>1){
            xminimo=(xminimo*1.15);
            xmassimo=(xmassimo*1.15);
            rangeAxis.setRange(xminimo, xmassimo);
        }



        if(configurazione.getDecimalFormat()!=null){
            rangeAxis.setNumberFormatOverride(configurazione.getDecimalFormat());
        }

        overrideBarColor(chart);

        //TODO VERIFICARE STA ROBA PER COLORI GRAFICI
        //renderer.setSeriesPaint(0, gp0);
        //renderer.setSeriesPaint(1, gp1);
        //renderer.setSeriesPaint(2, gp2);

        String s = temporaryDirecotry + getAutoGeneratedFileName() + ".png";
        saveChart(chart, temporaryDirecotry, getAutoGeneratedFileName(), configurazione.getxPixelDimension(), configurazione.getyPixelDimension());
        //return Streamer.getFile(temporaryDirecotry + getAutoGeneratedFileName() + ".png");
        byte[] stream = Streamer.getFile(s);
        new File(s).delete();
        return stream;
    }

    private void loadBarre(DefaultCategoryDataset categoryDataset, Istogramma fagiolo){
       /*
        Hashtable h = new Hashtable();
        if(null==gruppi)
            gruppi=new ArrayList<Gruppo>();
       */

        gruppi = (List) fagiolo.getGruppi();
        ArrayList barre= (ArrayList) fagiolo.getBarElements();
        if(null!=barre){
            BarElement prova= (BarElement) barre.get(0);
            LoggingUtils.debug("\nPRIMA BARRA "+prova.getGroup().getNome()+"\n VALORE: "+prova.getValore()+"\n COLORE "+prova.getGroup().getColore().getR()+","+prova.getGroup().getColore().getG()+","+prova.getGroup().getColore().getB());
            for(int i=0; i<barre.size();i++){

                BarElement b= (BarElement) barre.get(i);
                categoryDataset.setValue(b.getValore(),b.getGroup().getNome(),b.getAnno());
                //h.put(b.getGroup().getNome(),b.getGroup());
                if(i==0 && barre.size()>1){
                    xminimo=b.getValore();
                    xmassimo=b.getValore();
                }else if (i>0){
                    if(b.getValore()<xminimo){
                        xminimo=b.getValore();
                    }else if(b.getValore()>xmassimo){
                        xmassimo=b.getValore();
                    }
                }
            }
        }
        /*
        Enumeration e = h.keys();
        while (e.hasMoreElements()){
            String chiave= (String) e.nextElement();
            gruppi.add(h.get(chiave));
        }
        */
    }

    private void overrideBarColor(JFreeChart chart){
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        for (int i=0; i<gruppi.size();i++){
            Gruppo gruppo = (Gruppo) gruppi.get(i);
            if(null!= gruppo.getColore())
              renderer.setSeriesPaint(i, gruppo.getColore().getColor());
        }
    }

    public static void main(String args[]){
        try {
            new IstogrammaMultiplo().generate(IstogrammaGenerico.getMock());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
