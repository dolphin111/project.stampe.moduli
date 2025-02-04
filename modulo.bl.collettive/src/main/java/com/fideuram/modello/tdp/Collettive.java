package com.fideuram.modello.tdp;

import java.util.Date;
import java.util.List;

import com.fideuram.factory.FormatterFactory;
import com.fideuram.modello.tdp.elaborati.RiepilogoTDP;
import com.fideuram.modello.tdp.scarti.ScartoTDP;

/**
 * Created by
 * User: logan
 * Date: 09/05/13
 * Time: 15.19
 */
public class Collettive {
	
    private Date dataElaborazione;
    private Date dataDecorrenza;                  //la data decorrenza è comune a tutte le collettive aggregate NB salvo info contraria
    private List<ScartoTDP> scarti;
    private List<RiepilogoTDP> riepiloghi;

    public Collettive() {
        dataElaborazione=new Date();
    }

    public List<ScartoTDP> getScarti() {
        return scarti;
    }

    public void setScarti(List<ScartoTDP> scarti) {
        //todo attendere da ricciotto il valore di data Decorrenza - che ora nn viene passato
        dataDecorrenza=FormatterFactory.getDate(scarti.get(0).getDataDecorrenza());
        this.scarti = scarti;
    }

    public List<RiepilogoTDP> getRiepiloghi() {
        return riepiloghi;
    }

    public void setRiepiloghi(List<RiepilogoTDP> riepiloghi) {
        //todo attendere da ricciotto il valore di data Decorrenza - che ora nn viene passato
        dataDecorrenza=FormatterFactory.getDate(riepiloghi.get(0).getDataDecorrenza());
        this.riepiloghi = riepiloghi;
    }

    public String getDataDecorrenza() {
        return FormatterFactory.getStandardDate(dataDecorrenza);
    }

    public String getDataElaborazione() {
        return FormatterFactory.getStandardDate(dataElaborazione);
    }
    
}
