package com.fideuram.chart.grafici.istogramma;

import org.jfree.chart.renderer.category.BarRenderer;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: logan
 * Date: 16/07/13
 * Time: 22.53
 */
public class CustomRender extends BarRenderer {

    /** The colors. */
    private Paint[] colors;

    /**
     * Creates a new renderer.
     *
     * @param colors  the colors.
     */
    public CustomRender(final Paint[] colors) {
        this.colors = colors;
    }

    /**
     * Returns the paint for an item.  Overrides the default behaviour inherited from
     * AbstractSeriesRenderer.
     *
     * @param row  the series.
     * @param column  the category.
     *
     * @return The item color.
     */
    public Paint getItemPaint(final int row, final int column) {
        return this.colors[column % this.colors.length];
    }
}

