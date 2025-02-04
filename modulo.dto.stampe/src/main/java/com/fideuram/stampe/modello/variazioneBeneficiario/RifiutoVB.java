package com.fideuram.stampe.modello.variazioneBeneficiario;

import com.fideuram.dto.costanti.Costanti;
import com.fideuram.stampe.modello.contraenza.Contratto;
import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by V801098 on 09/05/14.
 */
@XmlRootElement(name="RifiutoVB", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class RifiutoVB {

    private Date           dataRichiesta;
    protected boolean      vincolo=false;
    protected String       codiceMotivoVincolo;
    protected boolean      pegno=false;
    protected boolean      fip80=false;
    protected boolean      polizzaScaduta=false;
    protected boolean      beneficiarioAssicurato=false;
    protected boolean      conflittoInteressi=false;
    protected boolean      prodottoNuovo=false;
    private Date           dataVincolo;
    protected Contratto    polizza;
    protected String       descrizioneMotivoRifiuto;
    protected String       bancaVincolataria;

    public void setDataRichiesta(Date dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }

    public String getDataRichiesta() {
        if(null==dataRichiesta)
            dataRichiesta=new Date();
        return FormattatoreDate.formatDate(dataRichiesta,FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    public void setPolizza(Contratto polizza) {
        this.polizza = polizza;
    }

    public Contratto getPolizza() {
        return polizza;
    }

    public void setDataVincolo(Date dataVincolo) {
        this.dataVincolo = dataVincolo;
    }

    public String getDataVincolo() {
        if(null==dataVincolo)
            dataVincolo=new Date();
        return FormattatoreDate.formatDate(dataVincolo,FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    public void setVincolo(boolean vincolo) {
        this.vincolo = vincolo;
    }

    public void setFip80(boolean fip80) {
        this.fip80 = fip80;
    }

    public void setPolizzaScaduta(boolean polizzaScaduta) {
        this.polizzaScaduta = polizzaScaduta;
    }

    public void setBeneficiarioAssicurato(boolean beneficiarioAssicurato) {
        this.beneficiarioAssicurato = beneficiarioAssicurato;
    }

    public void setConflittoInteressi(boolean conflittoInteressi) {
        this.conflittoInteressi = conflittoInteressi;
    }

    public void setProdottoNuovo(boolean prodottoNuovo) {
        this.prodottoNuovo = prodottoNuovo;
    }

    public void setCodiceMotivoVincolo(String codiceMotivoVincolo) {
        this.codiceMotivoVincolo = codiceMotivoVincolo;
    }

    public void setPegno(boolean pegno) {
        this.pegno = pegno;
    }

    public void setBancaVincolataria(String bancaVincolataria) {
        this.bancaVincolataria = bancaVincolataria;
    }

    public String getDescrizioneMotivoRifiuto() {

        if(vincolo ||  pegno)
        {
            if(bancaVincolataria != null && !bancaVincolataria.equalsIgnoreCase(""))
                bancaVincolataria = "a favore di "+bancaVincolataria;
            else
                bancaVincolataria = "";

            String descrizioneVP = Costanti.RIFIUTO_BENEFICIARIO_VINCOLO_PEGNO.replaceAll("#", this.getDataVincolo());

            if(vincolo) {
                if (codiceMotivoVincolo.equalsIgnoreCase(Costanti.CODICE_MOTIVO_VINCOLO_SEQUESTRO))
                    descrizioneVP = descrizioneVP.replaceAll("@", Costanti.DESCRIZIONE_MOTIVO_VINCOLO_SEQUESTRO);
                else if (codiceMotivoVincolo.equalsIgnoreCase(Costanti.CODICE_MOTIVO_VINCOLO_FALLIMENTO))
                    descrizioneVP = descrizioneVP.replaceAll("@", Costanti.DESCRIZIONE_MOTIVO_VINCOLO_FALLIMENTO);
                else if (codiceMotivoVincolo.equalsIgnoreCase(Costanti.CODICE_MOTIVO_VINCOLO_FAG))
                    descrizioneVP = descrizioneVP.replaceAll("@", Costanti.DESCRIZIONE_MOTIVO_VINCOLO_FAG);
            }

            return descrizioneVP.replaceAll("@", "").replaceAll("%", bancaVincolataria) ;
    }
        if(fip80)
            return Costanti.RIFIUTO_BENEFICIARIO_FIP80;
        if(polizzaScaduta)
            return  Costanti.RIFIUTO_BENEFICIARIO_POLIZZA_SCADUTA;
        if(beneficiarioAssicurato)
            return Costanti.RIFIUTO_BENEFICIARIO_BENEFICIARIO_ASSICURATO;
        if(conflittoInteressi)
            return Costanti.RIFIUTO_BENEFICIARIO_CONFLITTO_INTERESSI;
        if(prodottoNuovo)
            return Costanti.RIFIUTO_BENEFICIARIO_PRODOTTO_NUOVO;
       /* if(pegno)
        {
            if(bancaVincolataria != null && !bancaVincolataria.equalsIgnoreCase(""))
                bancaVincolataria = "a favore di "+bancaVincolataria;
            else
                bancaVincolataria = "";

            return Costanti.RIFIUTO_BENEFICIARIO_PEGNO.replaceAll("#", this.getDataVincolo()).replaceAll("%", bancaVincolataria);
        }*/

        return "";
    }
}
