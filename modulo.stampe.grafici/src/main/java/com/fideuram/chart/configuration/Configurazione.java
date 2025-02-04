package com.fideuram.chart.configuration;

import org.jfree.chart.plot.PlotOrientation;

import java.awt.*;
import java.text.DecimalFormat;

/**
 * Created with
 * User: logan
 * Date: 02/07/13
 * Time: 15.59
 */
public class Configurazione {
    public static int ORIENTATION_VERTICALE=0;
    public static int ORIENTATION_ORIZZONTALE=1;

    private boolean         evidenziaIlPunto=true;
    private boolean         _3D=false;

    private int             orientation=0;
    private int             xPixelDimension     =500;
    private int             yPixelDimension     =300;
    private boolean         valoriOverTheeTop   =false;
    private boolean         valoriOverTheeTopSymbolPercent   =false;
    private boolean         legenda             =true;
    private boolean         tooltip             =true;
    private boolean         url                 =false;
    private int             fontSize            =8;
    private boolean         fontObliquo         =false;
    private int             percentualeUpDowngridRange=5;
    private boolean         flat2dGraph         =true;
    private boolean         ombra               =false;
    private boolean         curvedLine          =false;
    private Colore          backColor           =new Colore(255,255,255);
    private Colore          gridColor           =new Colore(0,0,0);
    private boolean         sempliceMulticolor  =false;
    private boolean         autogeneratelabel   =false;
    private boolean         alarmed             =false;
    private Double          tickGrid;
    private DecimalFormat   decimalFormat;
    private DecimalFormat   tickDecimalFormat;
    private boolean         viewSingleItemValue =false;
    private boolean         extraAxisMargin     =false;
    private Font            fontTitolo;
    private Font            fontLabels;
    private Colore          fontLabelColor      =new Colore(255,255,255);

    public boolean isEvidenziaIlPunto() {
        return evidenziaIlPunto;
    }

    public void setEvidenziaIlPunto(boolean evidenziaIlPunto) {
        this.evidenziaIlPunto = evidenziaIlPunto;
    }

    public Font getFontTitolo() {
        return fontTitolo;
    }


    public void setFontTitolo(String font, int size) {
        this.fontTitolo = new Font(font, Font.BOLD, size);
    }


    public boolean isValoriOverTheeTop() {
        return valoriOverTheeTop;
    }

    public void setValoriOverTheeTop(boolean valoriOverTheeTop) {
        this.valoriOverTheeTop = valoriOverTheeTop;
    }

    public boolean isValoriOverTheeTopSymbolPercent() {
        return valoriOverTheeTopSymbolPercent;
    }

    public void setValoriOverTheeTopSymbolPercent(boolean valoriOverTheeTopSymbolPercent) {
        this.valoriOverTheeTopSymbolPercent = valoriOverTheeTopSymbolPercent;
    }

    public Font getFontLabels() {
        return fontLabels;
    }

    public void setFontLabels(String font, int size) {
        this.fontLabels = new Font(font, Font.PLAIN, size);
    }

    public Colore getFontLabelColor() {
        return fontLabelColor;
    }

    public void setFontLabelColor(Colore fontLabelColor) {
        this.fontLabelColor = fontLabelColor;
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


    public void setOrientation(int orientation) {
        this.orientation = orientation;
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
    public int getOrientationToIntValue() {
       return orientation;
    }

    public void set_3D(boolean _3D) {
        this._3D = _3D;
    }

    public boolean is_3D() {
        return _3D;
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

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public void setFontObliquo(boolean fontObliquo) {
        this.fontObliquo = fontObliquo;
    }

    public boolean isFontObliquo() {
        return fontObliquo;
    }

    public int getPercentualeUpDowngridRange() {
        return percentualeUpDowngridRange;
    }

    public void setPercentualeUpDowngridRange(int percentualeUpDowngridRange) {
        this.percentualeUpDowngridRange = percentualeUpDowngridRange;
    }

    public boolean isFlat2dGraph() {
        return flat2dGraph;
    }

    public void setFlat2dGraph(boolean flat2dGraph) {
        this.flat2dGraph = flat2dGraph;
    }

    public boolean isOmbra() {
        return ombra;
    }

    public void setOmbra(boolean ombra) {
        this.ombra = ombra;
    }

    public boolean isCurvedLine() {
        return curvedLine;
    }

    public void setCurvedLine(boolean curvedLine) {
        this.curvedLine = curvedLine;
    }

    public Colore getBackColor() {
        return backColor;
    }

    public void setBackColor(Colore backColor) {
        this.backColor = backColor;
    }

    public Colore getGridColor() {
        return gridColor;
    }

    public void setGridColor(Colore gridColor) {
        this.gridColor = gridColor;
    }

    public boolean isSempliceMulticolor() {
        return sempliceMulticolor;
    }

    public void setSempliceMulticolor(boolean sempliceMulticolor) {
        this.sempliceMulticolor = sempliceMulticolor;
    }

    public boolean isAutogeneratelabel() {
        return autogeneratelabel;
    }

    public void setAutogeneratelabel(boolean autogeneratelabel) {
        this.autogeneratelabel = autogeneratelabel;
    }

    /**
     * se true indica che si vuole la colorazione verde per i positivi rossa per i valori negatici
     * @return
     */
    public boolean isAlarmed() {
        return alarmed;
    }


    /**
     * se true indica che si vuole la colorazione verde per i positivi rossa per i valori negatici
     * default is = false
     * @return
     */
    public void setAlarmed(boolean alarmed) {
        this.alarmed = alarmed;
    }

    public Double getTickGrid() {
        return tickGrid;
    }

    public void setTickGrid(Double tickGrid) {
        this.tickGrid = tickGrid;
    }



    public DecimalFormat getDecimalFormat() {
        return decimalFormat;
    }

    public void setDecimalFormat(DecimalFormat decimalFormat) {
        this.decimalFormat = decimalFormat;
    }


    public DecimalFormat getTickDecimalFormat() {
        return tickDecimalFormat;
    }

    public void setTickDecimalFormat(DecimalFormat tickDecimalFormat) {
        this.tickDecimalFormat = tickDecimalFormat;
    }

    public boolean isViewSingleItemValue() {
        return viewSingleItemValue;
    }

    public void setViewSingleItemValue(boolean viewSingleItemValue) {
        this.viewSingleItemValue = viewSingleItemValue;
    }

    public boolean isExtraAxisMargin() {
        return extraAxisMargin;
    }

    public void setExtraAxisMargin(boolean extraAxisMargin) {
        this.extraAxisMargin = extraAxisMargin;
    }
}
