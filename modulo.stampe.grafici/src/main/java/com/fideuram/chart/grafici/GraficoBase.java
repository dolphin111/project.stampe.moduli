package com.fideuram.chart.grafici;

import com.fideuram.chart.configuration.Configurazione;
import com.fideuram.chart.configuration.Gruppo;

import java.util.List;

/**
 * Created with
 * User: logan
 * Date: 02/07/13
 * Time: 16.04
 */
public class GraficoBase {
    private List<Gruppo> gruppi;

    private Configurazione configurazione;
    private String header="";
    private String xaxis ="";
    private String yaxis ="";

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getXaxis() {
        return xaxis;
    }

    public void setXaxis(String xaxis) {
        this.xaxis = xaxis;
    }

    public String getYaxis() {
        return yaxis;
    }

    public void setYaxis(String yaxis) {
        this.yaxis = yaxis;
    }

    public List<Gruppo> getGruppi() {
        return gruppi;
    }

    public void setGruppi(List<Gruppo> gruppi) {
        this.gruppi = gruppi;
    }

    public Configurazione getConfigurazione() {
        if(null== configurazione)
            return new Configurazione();
        return configurazione;
    }

    public void setConfigurazione(Configurazione configurazione) {
        this.configurazione = configurazione;
    }
}
