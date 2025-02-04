package com.fideuram.modello.tdp.scarti;

import java.util.Date;

import com.fideuram.factory.FormatterFactory;
import com.fideuram.modello.tdp.Tdp;

/**
 * Created by
 * User: logan
 * Date: 09/05/13
 * Time: 9.36
 *
 * Questo Bean rappresenta le informazioni riconducibili <br>
 * alla SINGOLA Emissione scartata del Titolo di Perfezionamento
 */
public class ScartoTDP extends Tdp{

	private String polizza;
    private String appendice;
    private String tariffa;
    private String codiceIngresso;

    private Date dataScadenza;
    private String descrizione;



    public String getPolizza() {
        return polizza;
    }

    public void setPolizza(String polizza) {
        this.polizza = polizza;
    }

    public String getAppendice() {
        return appendice;
    }

    public void setAppendice(String appendice) {
        this.appendice = appendice;
    }

    public String getTariffa() {
        return tariffa;
    }

    public void setTariffa(String tariffa) {
        this.tariffa = tariffa;
    }

    public String getIngresso() {
        return codiceIngresso;
    }

    public void setIngresso(String in) {
        this.codiceIngresso = in;
    }


    public String getCodiceIngresso() {
        return codiceIngresso;
    }



    public String getDataScadenza() {
        return FormatterFactory.getStandardDate(dataScadenza);
    }

    public void setDataScadenza(Date dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    
    @Override
	public String toString() {
		return "ScartoTDP [polizza=" + polizza + ", appendice=" + appendice
				+ ", tariffa=" + tariffa + ", codiceIngresso=" + codiceIngresso
				+ ", dataScadenza=" + dataScadenza + ", descrizione="
				+ descrizione + "]";
	}

}
