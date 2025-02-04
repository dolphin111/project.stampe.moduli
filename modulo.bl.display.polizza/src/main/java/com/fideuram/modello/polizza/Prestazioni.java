package com.fideuram.modello.polizza;

import com.fideuram.factory.FormatterFactory;
import com.fideuram.modello.polizza.prestazioni.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by
 * User: logan
 * Date: 09/04/13
 * Time: 18.45
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Prestazioni {
    private Double prestazioneGarantitaUltimaRivalutazione;
    @XmlElement(name = "importoBonus")
    private Double importoBonusFvInsieme;
    private Double valoreRiscattoScadenzaGarantito;
    private Double ipotesiValoreRiscattoScadenza;
    private Double valoreRiscattoAnticipato;
    private Double eccedenza;
    @XmlElement(name = "Bonus")
    private Bonus bonus;
    private PrestazioniCalcolateNav prestazioniCalcolateNav;
    private PrestazioniMinimoGarantito prestazioniMinimoGarantito;
    private SimulazioniPrestazioniAssicurate simulazioniPrestazioniAssicurate;
    private Double renditaACLS75Anno;
    private Double renditaACLS80Anno;
    private Double renditaACLS85Anno;
    private Double totalePrestazioniCV;
    private Date   dataUltimaRivalutazione;
    private Rendita rendita;
    private Capitale capitale;
    private Double valorePrestazioniControvalore;
    private Double totalePrestazioniBase;


    public boolean hasDataUltimaRivalutazione(){

        return dataUltimaRivalutazione!=null?true:false;
    }
    public String getTotalePrestazioniBase() {
		return FormatterFactory.getStandardImporto(totalePrestazioniBase);
	}

	public SimulazioniPrestazioniAssicurate getSimulazioniPrestazioniAssicurate() {
        return simulazioniPrestazioniAssicurate;
    }

    public PrestazioniMinimoGarantito getPrestazioniMinimoGarantito() {
        return prestazioniMinimoGarantito;
    }

    public PrestazioniCalcolateNav getPrestazioniCalcolateNav() {
        return prestazioniCalcolateNav;
    }

    public String getPrestazioneGarantitaUltimaRivalutazione() {
        return FormatterFactory.getStandardImporto(prestazioneGarantitaUltimaRivalutazione);
    }

    public String getImportoBonusFvInsieme() {
        return FormatterFactory.getStandardImporto(importoBonusFvInsieme);
    }

    public String getValoreRiscattoScadenzaGarantito() {
        return FormatterFactory.getStandardImporto(valoreRiscattoScadenzaGarantito);
    }

    public String getIpotesiValoreRiscattoScadenza() {
        return FormatterFactory.getStandardImporto(ipotesiValoreRiscattoScadenza);
    }

    public String getValoreRiscattoAnticipato() {
        return FormatterFactory.getStandardImporto(valoreRiscattoAnticipato);
    }

    public String getEccedenza() {
        return FormatterFactory.getStandardImporto(eccedenza);
    }

    public Bonus getBonus() {
        return bonus;
    }

    public Double getRenditaACLS75Anno() {
        return renditaACLS75Anno;
    }

    public Double getRenditaACLS80Anno() {
        return renditaACLS80Anno;
    }

    public Double getRenditaACLS85Anno() {
        return renditaACLS85Anno;
    }

    public Double getTotalePrestazioniCV() {
        return totalePrestazioniCV;
    }

    public String getDataUltimaRivalutazione() {
        return FormatterFactory.getStandardDate(dataUltimaRivalutazione);
    }

    public Rendita getRendita() {
        return rendita;
    }

    public Capitale getCapitale() {
        return capitale;
    }

    public String getValorePrestazioniControvalore() {
        return FormatterFactory.getStandardImporto(valorePrestazioniControvalore);
    }

    /**
     * Questo metodo restituisce true se il  TotalePrestazioniRendita è maggiore di 0
     * @return
     */
    public boolean isTotalePrestazioniRenditaUp0() {
        if (rendita != null) {
            if (rendita.getTotalePrestazioniRendita() != null) {
                if (rendita.getTotalePrestazioniRenditaDoubleFormat() > 0)
                    return true;
            }
        }
        return false;
    }
}
