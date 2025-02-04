package com.fideuram.chart.lab.bar;

import com.fideuram.chart.Chart;
import com.fideuram.chart.lab.ConfigurationGraph;
import com.fideuram.chart.lab.bar.bean.Barra;
import com.fideuram.chart.lab.bar.bean.Barre;
import com.fideuram.chart.configuration.Colore;
import com.fideuram.utils.LoggingUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by
 * User: logan
 * Date: 04/02/13
 * Time: 11.56
 */
public class IstogrammaEngine extends Chart {
    private double puntoMax=0.00;

    public IstogrammaEngine() {
        super();
    }


    public void generate(Barre fagiolo,String tmpDir, String destinationFileName, ConfigurationGraph configurationBar) throws IOException {
        DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
        loadBarre(categoryDataset,fagiolo);
        JFreeChart chart = ChartFactory.createBarChart
                (       fagiolo.getHeader(),                 // Header
                        fagiolo.getXaxis(),                  // X-Axis label
                        fagiolo.getYaxis(),                  // Y-Axis label
                        categoryDataset,                     // Dataset
                        configurationBar.getOrientation(),
                        configurationBar.isLegenda(),                       // Show legend
                        configurationBar.isTooltip(),
                        configurationBar.isUrl()
                );

                applyChartTheme(chart);
                CategoryPlot plot = (CategoryPlot) chart.getPlot();

                final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
                rangeAxis.setLabelAngle(0 * Math.PI / 2.0);
                if(configurationBar.getGridTick()!=null){
                    LoggingUtils.debug(">>>> settato GridTick: "+configurationBar.getGridTick() );
                    if(!(puntoMax<0)&&puntoMax>configurationBar.getGridTick()){
                        rangeAxis.setTickUnit(new NumberTickUnit(configurationBar.getGridTick()));
                    }else{
                        rangeAxis.setTickUnit(new NumberTickUnit(configurationBar.getGridTick()/4));
                    }
                }else{
                    if(!(puntoMax<0)&&puntoMax >= rangeAxis.getTickUnit().getSize()){
                        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
                    }else{
                        rangeAxis.setTickUnit(new NumberTickUnit(rangeAxis.getTickUnit().getSize()/4));
                    }


                }

                //chart.setBackgroundPaint(getPaint());
                chart.setBackgroundPaint(getGradientPaint());

                Colore cbase =configurationBar.getColori().getBackGroundColor();
                Colore cgrid =configurationBar.getColori().getBackGroundColor();
                plot.setBackgroundPaint(new Color(cbase.getR(),cbase.getG(),cbase.getB()));
                plot.setRangeGridlinePaint(new Color(cgrid.getR(),cgrid.getG(),cgrid.getB()));

                BarRenderer renderer = (BarRenderer) plot.getRenderer();
                for (int i=0; i<configurationBar.getColori().getPantoni().size();i++){
                    try{
                        renderer.setSeriesPaint(i, configurationBar.getColori().getPantoni().get(i).getColor());
                    }catch (Exception e){
                        //stando in debug su idea interpreta male il type Colore e lo vede come java.axt.Color
                        //ovviamente va in class clast... ecco il xkè di questa catch che non serve ad altro che a permettermi
                        //di andare in debug stand alone
                        renderer.setSeriesPaint(i, (Paint) configurationBar.getColori().getPantoni().get(i));
                    }
                }

                renderer.setDrawBarOutline(false);
                renderer.setShadowVisible(configurationBar.isOmbraSulleBarre());
                renderer.setItemMargin(0.0);
                renderer.setItemLabelsVisible(configurationBar.isTagItemValue());

                saveChart(chart, tmpDir, destinationFileName, configurationBar.getxPixelDimension(), configurationBar.getyPixelDimension());
    }


    private void loadBarre( DefaultCategoryDataset categoryDataset, Barre fagiolo){

        ArrayList barre= (ArrayList) fagiolo.getBarre();
        for(int i=0; i<barre.size();i++){
            Barra b= (Barra) barre.get(i);
            categoryDataset.setValue(b.getValore(),b.getEtichetta(),b.getAnno());
            if(b.getValore()>puntoMax)
                puntoMax=b.getValore();
        }
        //modifica fatta per risolvere il problema del sovraffollamento dei punti della linea verticale
        if(puntoMax < 1)
            puntoMax = 1;
    }



    public static void main(String args []) throws IOException {
        //new IstogrammaEngine().generate(LG01RA_B.getMock(), "",  "LG01RAbarra", LG01RA_B.getConfigurationBar());
        //new IstogrammaEngine().generate(COREK_B.getMock(), "", "COREKbarra", COREK_B.getConfigurationBar());
        //new IstogrammaEngine().generate(CL01RA_B.getMock(),"", "CL01RAbarra", CL01RA_B.getConfigurationBar());
        //new IstogrammaEngine().generate(CL02RA_B.getMock(), "","CL02RAbarra", CL02RA_B.getConfigurationBar());
        //new IstogrammaEngine().generate(CL03RA_B.getMock(), "" ,"CL03RAbarra", CL03RA_B.getConfigurationBar());
        //
        //new IstogrammaEngine().generate(BMKCORE15_B.getMock(), "","BenchmarkCoreBeta15barra", BMKCORE15_B.getConfigurationBar());
        //new IstogrammaEngine().generate(BMKCORE30_B.getMock(), "","BenchmarkCoreBeta30barra", BMKCORE30_B.getConfigurationBar());
    }

}
