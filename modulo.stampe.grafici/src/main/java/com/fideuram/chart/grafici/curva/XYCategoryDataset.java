package com.fideuram.chart.grafici.curva;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.xy.AbstractXYDataset;

/**
 * Created with
 * User: logan
 * Date: 30/07/13
 * Time: 9.29
 */
public class XYCategoryDataset extends AbstractXYDataset {
    private CategoryDataset dataset;
    public XYCategoryDataset(CategoryDataset dataset){
        this.dataset = dataset;
    }
    public int getSeriesCount(){
        return dataset.getRowCount();
    }
    public Comparable getSeriesKey(int series){
        return dataset.getRowKey(series);
    }
    public int getItemCount(int series){
        return dataset.getColumnCount();
    }
    public Number getX(int series, int item){
        return new Double(item);
    }
    public Number getY(int series, int item){
        return dataset.getValue(series, item);
    }

}
