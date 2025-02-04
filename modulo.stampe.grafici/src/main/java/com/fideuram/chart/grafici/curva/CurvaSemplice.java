package com.fideuram.chart.grafici.curva;

import java.awt.Color;
import java.awt.Font;
import java.awt.geom.*;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.*;
import org.jfree.chart.renderer.xy.*;
import org.jfree.data.Range;
import org.jfree.data.category.*;

/**
 * Created with
 * User: logan
 * Date: 30/07/13
 * Time: 9.27
 */
public class CurvaSemplice {
    public static void main(String args[]) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.5, "Row 1", "Column 1");
        dataset.addValue(7.5, "Row 1", "Column 2");
        dataset.addValue(3.5, "Row 1", "Column 3");
        dataset.addValue(3.5, "Row 2", "Column 1");
        dataset.addValue(2.5, "Row 2", "Column 2");
        dataset.addValue(8.5, "Row 2", "Column 3");



        CategoryAxis xAxis = new CategoryAxis("Categories");
        xAxis.setLowerMargin(0.0);
        xAxis.setUpperMargin(0.0);
        NumberAxis yAxis = new NumberAxis("Values");
        yAxis.setTickUnit(new NumberTickUnit(2.0));
        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        renderer.setDrawOutlines(true);
        renderer.setUseOutlinePaint(true);
        renderer.setSeriesPaint(0, Color.YELLOW);
        renderer.setSeriesOutlinePaint(0, Color.BLACK);
        renderer.setSeriesPaint(1, Color.GREEN);
        renderer.setSeriesOutlinePaint(1, Color.BLACK);
        renderer.setSeriesShape(0, new Ellipse2D.Double(-5, -5, 10, 10));
        renderer.setSeriesShape(1, new Rectangle2D.Double(-5, -5, 10, 10));
        CategoryPlot plot = new CategoryPlot(dataset, xAxis, yAxis, renderer);
        JFreeChart chart = new JFreeChart("CategoryPlot Demo", new Font("Tahoma", 2, 18), plot, true);


        JFrame frame = new JFrame("");
        frame.setContentPane(new ChartPanel(chart));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

     /*
        SymbolAxis sAxis = new SymbolAxis("Categories", new String[]{"Column 1","Column 2","Column 3"});
        sAxis.setRange(new Range(0.0, 2.0));
        XYItemRenderer r = new XYLineAndShapeRenderer();
        r.setSeriesPaint(0, Color.YELLOW);
        r.setSeriesOutlinePaint(0, Color.BLACK);
        r.setSeriesPaint(1, Color.GREEN);
        r.setSeriesOutlinePaint(1, Color.BLACK);
        r.setSeriesShape(0, new Ellipse2D.Double(-5, -5, 10, 10));
        r.setSeriesShape(1, new Rectangle2D.Double(-5, -5, 10, 10));


        XYPlot xplot = new XYPlot(new XYCategoryDataset(dataset), sAxis, new NumberAxis("Values"), r);
        JFreeChart xchart = new JFreeChart("XYPlot Demo", new Font("Tahoma", 2, 18), xplot, true);
        JFrame xframe = new JFrame("Category Plot Demo");
        xframe.setContentPane(new ChartPanel(xchart));
        xframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        xframe.pack();
        xframe.setVisible(true);*/
    }


}
