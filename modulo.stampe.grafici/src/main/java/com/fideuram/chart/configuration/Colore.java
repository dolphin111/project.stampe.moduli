package com.fideuram.chart.configuration;

import java.awt.*;

/**
 * Created by
 * User: logan
 * Date: 25/02/13
 * Time: 8.14
 */
public class Colore {
    private int R=255;
    private int G=255;
    private int B=255;

    public Colore() {}

    public Colore(int r, int g, int b) {
        R = r;
        G = g;
        B = b;
    }

    public int getR() {
        return R;
    }

    public int getG() {
        return G;
    }

    public int getB() {
        return B;
    }

    public Color getColor(){
        return new Color(R,G,B);
    }
}
