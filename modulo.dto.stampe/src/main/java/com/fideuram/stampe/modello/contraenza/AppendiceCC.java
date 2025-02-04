package com.fideuram.stampe.modello.contraenza;

import com.fideuram.stampe.modello.attori.Individuo;
import com.fideuram.stampe.modello.attori.Recapito;
import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by V801068 on 19/05/14.
 */
@XmlRootElement(name="AppendiceCC", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class AppendiceCC extends CambioContraenza{
    private Date         dataEmissioneAppendice;
    private Individuo    nuovoContraente;
    private Date         dataEffettoCC;

    public String getDataEmissioneAppendice() {
        return FormattatoreDate.formatDate(dataEmissioneAppendice!=null?dataEmissioneAppendice:new Date(),FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    public Contratto getPolizza() {
        return polizza;
    }

    public Individuo getNuovoContraente() {
        return nuovoContraente;
    }

    public String getDataEffettoCC() {
        return FormattatoreDate.formatDate(dataEffettoCC,FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    public void setDataEmissioneAppendice(Date dataEmissioneAppendice) {
        this.dataEmissioneAppendice = dataEmissioneAppendice;
    }

    public void setPolizza(Contratto polizza) {
        this.polizza = polizza;
    }

    public void setNuovoContraente(Individuo nuovoContraente) {
        this.nuovoContraente = nuovoContraente;
    }

    public void setDataEffettoCC(Date dataEffettoCC) {
        this.dataEffettoCC = dataEffettoCC;
    }

    public List<CopiaAppendice> getCopieAppendice(){
        List<CopiaAppendice> copiaAppendices = new ArrayList<CopiaAppendice>();
        copiaAppendices.add(new CopiaAppendice(this,"Copia per il Private Banker"));
        if(getCausale().getCausale()!=1)  //caso non decesso
           copiaAppendices.add(new CopiaAppendice(this,"Copia per il Cedente"));
        copiaAppendices.add(new CopiaAppendice(this,"Copia per il Cessionario\n(da riceversi unitamente all'informativa in materia di\ntrattamento dei dati personali)"));
        return copiaAppendices;
    }

    public static AppendiceCC getMockContrentePersonaFisica(){
        Recapito recapito= new Recapito();
        recapito.setCap("00100");
        recapito.setProvincia("RM");
        recapito.setComune("Roma");
        recapito.setVia("Via della navicella 32");

        Individuo individuo=new Individuo();
        individuo.setCognome("Neckens");
        individuo.setNome("Joahn");
        individuo.setIndirizzo(recapito);


        Contratto contratto = new Contratto();
        contratto.setNumeroID("123456789");
        contratto.setDescrizioneProdotto("Fideuram Vita Insieme");
        contratto.setDecorrenza(new Date());                         // LA DATA DI DECORRENZA DEL CONTRATTO
        contratto.setContraente(new Individuo("Peppa", "Pippa"));




        AppendiceCC appendiceCC = new AppendiceCC();
        appendiceCC.setDataEffettoCC(new Date());                    // LA DATA DI EFFETO DELLA VARIAZIONE AL CONTRATTO
        appendiceCC.setDataEmissioneAppendice(new Date());           // LA DATA DI EMISSIONE DEL DOC APPENDICE
        appendiceCC.setPolizza(contratto);
        appendiceCC.setNuovoContraente( new Individuo("Peppa","Giovanna"));
        return appendiceCC;
    }


}
