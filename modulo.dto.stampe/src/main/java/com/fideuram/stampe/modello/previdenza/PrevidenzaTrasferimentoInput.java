package com.fideuram.stampe.modello.previdenza;

import com.fideuram.stampe.modello.attori.Compagnia;
import com.fideuram.stampe.modello.attori.Individuo;
import com.fideuram.stampe.modello.comunicazionecrm.Comunicazione;
import com.fideuram.stampe.modello.contraenza.Valuta;
import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * User: V801068
 * Date: 01/07/15
 * Time: 15.25
 */
@XmlRootElement(name="PrevidenzaTrasferimentoInput", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class PrevidenzaTrasferimentoInput {
    private Comunicazione richiesta;
    private Compagnia compagniaDiProvenienza;
    private Individuo aderente;
    private Valuta    valuta;

    public Comunicazione getRichiesta() {
        return richiesta;
    }

    public Compagnia getCompagniaDiProvenienza() {
        return compagniaDiProvenienza;
    }

    public Valuta getValuta() {
        return valuta;
    }

    public Individuo getAderente() {
        return aderente;
    }

    public String getDataStampa(){
        return FormattatoreDate.formatDate(new Date(), FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    public void setRichiesta(Comunicazione richiesta) {
        this.richiesta = richiesta;
    }

    public void setCompagniaDiProvenienza(Compagnia compagniaDiProvenienza) {
        this.compagniaDiProvenienza = compagniaDiProvenienza;
    }

    public void setAderente(Individuo aderente) {
        this.aderente = aderente;
    }

    public void setValuta(Valuta valuta) {
        this.valuta = valuta;
    }
}
