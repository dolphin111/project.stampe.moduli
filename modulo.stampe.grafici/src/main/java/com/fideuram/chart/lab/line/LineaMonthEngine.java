package com.fideuram.chart.lab.line;

import com.fideuram.chart.Chart;
import com.fideuram.chart.exception.GraphException;
import com.fideuram.chart.lab.ConfigurationGraph;
import com.fideuram.chart.configuration.Colore;
import com.fideuram.chart.lab.line.bean.Linea;
import com.fideuram.chart.lab.line.bean.Linee;
import com.fideuram.chart.lab.line.bean.PuntoLinea;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by
 * User: logan
 * Date: 06/02/13
 * Time: 11.27
 */
public class LineaMonthEngine extends Chart {
    public void generate(Linee linee,String path, String destinationFileName, ConfigurationGraph configurationBar) throws IOException {
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        for (int i=0; i<linee.getLineas().size();i++){
            Linea linea=linee.getLineas().get(i);
            TimeSeries serie = new TimeSeries(linea.getCategoria().toString());
            for (int y=0; y<linea.getPuntoLineas().size();y++){
                PuntoLinea p =linea.getPuntoLineas().get(y);
                serie.add(getMonth(p.getData()),p.getValore());
            }
            dataset.addSeries(serie);
        }

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                configurationBar.isVoglioHeader()?linee.getHeader():"",    //titolo
                linee.getYaxis(),    //y-label
                linee.getXaxis(),    //x-label
                dataset,
                configurationBar.isLegenda(),                       // Show legend
                configurationBar.isTooltip(),
                configurationBar.isUrl());
        applyChartTheme(chart);
        XYPlot plot = chart.getXYPlot();
        DateAxis axis = (DateAxis) plot.getDomainAxis();

        //GESTIONE COLORI
        //chart.setBackgroundPaint(getPaint());
        chart.setBackgroundPaint(getGradientPaint());
        Colore cbase =configurationBar.getColori().getBackGroundColor();
        Colore cgrid =configurationBar.getColori().getBackGroundColor();
        plot.setBackgroundPaint(new Color(cbase.getR(),cbase.getG(),cbase.getB()));
        plot.setRangeGridlinePaint(new Color(cgrid.getR(),cgrid.getG(),cgrid.getB()));


        XYItemRenderer r = plot.getRenderer();
        if(r instanceof XYLineAndShapeRenderer) {
            XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
            renderer.setBaseShapesVisible(true);
            renderer.setBaseShapesFilled(true);
            for (int i=0; i<configurationBar.getColori().getPantoni().size();i++){
                //Colore colore =  configurationBar.getColori().getPantoni().get(i);
                // renderer.setSeriesPaint(i,new Color(colore.getR(),colore.getG(),colore.getB()));
                try{
                    renderer.setSeriesPaint(i, configurationBar.getColori().getPantoni().get(i).getColor());
                }catch (Exception e){
                    //stando in debug su idea interpreta male il type Colore e lo vede come java.axt.Color
                    //ovviamente va in class clast... ecco il xkè di questa catch che non serve ad altro che a permettermi
                    //di andare in debug stand alone
                    renderer.setSeriesPaint(i, (Paint) configurationBar.getColori().getPantoni().get(i));
                }
            }
        }
        //axis.setDateFormatOverride(new SimpleDateFormat("MMM-yy"));
        axis.setDateFormatOverride(new SimpleDateFormat("MMM"));
        //axis.setDateFormatOverride(new SimpleDateFormat("dd-MMM"));
        //axis.setDateFormatOverride(new SimpleDateFormat("dd-MM-yy"));



        try {
            if(path!=null&&!path.trim().equals(""))
                ChartUtilities.saveChartAsPNG(new File(path + destinationFileName + "linea.png"), chart, 500, 300);
            else
                ChartUtilities.saveChartAsPNG(new File(temporaryDirecotry + destinationFileName + "linea.png"), chart, 500, 300);
        } catch (IOException e) {
            System.err.println("Problem occurred creating chart.");
        }
    }

    private Month getMonth(String data){
        data=data.replace("/","-");
        data=data.substring(3);
        return Month.parseMonth(data);
    }
    
    public static void main(String args[]) throws GraphException, IOException {
        //CARELLA
        //new LineaMonthEngine().generate(LG01RA_L.getMockCarellaPremium(),"","LG01RA_LINEA_CARELLA",LG01RA_L.getConfigurationBar());

        //SOMMAVILLA

        //new LineaMonthEngine().generate(LG01RA_L.getMockSommavillaFvInsieme(),"","LG01RA_LINEA_SOMMAVILLA", LG01RA_L.getConfigurationBar());
        //new LineaMonthEngine().generate(COREK_L.getMockSommavillaFvInsieme(),"","COREK_LINEA_SOMMAVILLA", COREK_L.getConfigurationBar());
        //new LineaMonthEngine().generate(BMKCORE15_L.getMockSommavillaFvInsieme(),"","BMKCORE15_LINEA_SOMMAVILLA", BMKCORE15_L.getConfigurationBar());
        //new LineaMonthEngine().generate(BMKCORE30_L.getMockSommavillaFvInsieme(),"","BMKCORE30_LINEA_SOMMAVILLA", BMKCORE30_L.getConfigurationBar());
        //new LineaMonthEngine().generate(CL01RA_L.getMockSommavillaFvInsieme(),"","CL01RA_LINEA_SOMMAVILLA", CL01RA_L.getConfigurationBar());
        //new LineaMonthEngine().generate(CL02RA_L.getMockSommavillaFvInsieme(),"","CL02RA_LINEA_SOMMAVILLA", CL02RA_L.getConfigurationBar());
        //new LineaMonthEngine().generate(CL03RA_L.getMockSommavillaFvInsieme(),"","CL03RA_LINEA_SOMMAVILLA", CL03RA_L.getConfigurationBar());

    }
}
