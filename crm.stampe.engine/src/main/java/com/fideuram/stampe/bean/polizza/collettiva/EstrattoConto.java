package com.fideuram.stampe.bean.polizza.collettiva;

import com.fideuram.factory.FormatterFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with
 * User: V801068
 * Date: 07/07/14
 * Time: 14.48
 */
public class EstrattoConto {
   private Double       totale;
   private List<Premio> premios;

    public String getTotale() {
        return FormatterFactory.getStandardImporto(totale);
    }

    public List<Premio> getPremios() {
        if(null==premios)
            return new ArrayList<Premio>();
        return premios;
    }

    public void setTotale(Double totale) {
        this.totale = totale;
    }

    public void setPremios(List<Premio> premios) {
        this.premios = premios;
    }
}
