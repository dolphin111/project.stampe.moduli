package com.fideuram.chart.lab;

import org.jfree.chart.plot.PlotOrientation;

/**
 * Created by 
 * User: logan
 * Date: 04/02/13
 * Time: 12.33
 */
public class ConfigurationGraph {
    
    public static int ORIENTATION_VERTICALE=0;
    public static int ORIENTATION_ORIZZONTALE=1;
    
    private Colori colori;

    private int orientation=0;
    private boolean ombraSulleBarre=false;

    private boolean legenda=true;
    private boolean tooltip=true;
    private boolean url=false;
    private boolean tagItemValue=false;
    private int xPixelDimension;
    private int yPixelDimension;
    private Double GridTick;
    private boolean voglioHeader=false;

  /*  public ConfigurationGraph() {
        backGroundColor=Color.white;
        gridLineColor=Color.black;
    }*/

    public Colori getColori() {
        if(null==colori)
            colori=new Colori();
        return colori;
    }

    public void setColori(Colori colori) {
        this.colori = colori;
    }

    public PlotOrientation getOrientation() {
        switch (orientation){
            case 0:
                return PlotOrientation.VERTICAL;
            case 1:
                return PlotOrientation.HORIZONTAL;
            default:
                return PlotOrientation.VERTICAL;
        }
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }
   

    public boolean isOmbraSulleBarre() {
        return ombraSulleBarre;
    }

    public void setOmbraSulleBarre(boolean ombraSulleBarre) {
        this.ombraSulleBarre = ombraSulleBarre;
    }

    public boolean isLegenda() {
        return legenda;
    }

    public void setLegenda(boolean legenda) {
        this.legenda = legenda;
    }

    public boolean isTooltip() {
        return tooltip;
    }

    public void setTooltip(boolean tooltip) {
        this.tooltip = tooltip;
    }

    public boolean isUrl() {
        return url;
    }

    public void setUrl(boolean url) {
        this.url = url;
    }

    public int getxPixelDimension() {
        if(xPixelDimension==0)
            xPixelDimension=500;
        return xPixelDimension;
    }

    public void setxPixelDimension(int xPixelDimension) {
        this.xPixelDimension = xPixelDimension;
    }

    public int getyPixelDimension() {
        if(yPixelDimension==0)
            yPixelDimension=300;
        return yPixelDimension;
    }

    public void setyPixelDimension(int yPixelDimension) {
        this.yPixelDimension = yPixelDimension;
    }

    public boolean isTagItemValue() {
        return tagItemValue;
    }

    public void setTagItemValue(boolean tagItemValue) {
        this.tagItemValue = tagItemValue;
    }

    public Double getGridTick() {
        return GridTick;
    }

    /**
     * Determina la precisione di visualizzazione della griglia del grafico
     * @param gridTick
     */
    public void setGridTick(Double gridTick) {
        GridTick = gridTick;
    }

    public boolean isVoglioHeader() {
        return voglioHeader;
    }

    public void setVoglioHeader(boolean voglioHeader) {
        this.voglioHeader = voglioHeader;
    }
}
