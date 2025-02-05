package com.fideuram.stampe.modello.redditi;


import com.fideuram.stampe.modello.attori.Recapito;
import com.fideuram.stampe.modello.redditi.anagrafica.PercettoreSomme;
import com.fideuram.stampe.modello.redditi.anagrafica.SostitutoImposta;
import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.ValidationException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * User: V801068
 * Date: 18/11/14
 * Time: 17.24
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class CudBase {
    public static int TIPO_DICHIARAZIONE_PRIMA_DICHIARAZIONE = 0;
    public static int TIPO_DICHIARAZIONE_SOSTITUZIONE = 1;
    public static int TIPO_DICHIARAZIONE_ANNULLAMENTO = 2;

    /** &Egrave; una chiave del file di configurazione.  */
    public static final String CHIAVE_NOME_FILE_MODELLO_ANNULLAMENTO = "12023";

    protected int               tipodichiarazione=0;
    protected Date              dataElaborazione;
    protected String            annoFiscale;
    protected SostitutoImposta  datoreLavoro;
    protected PercettoreSomme   percettoreSomme;
    protected Integer           numCertDip; //numero certificazioni lavoro dipendente o assimilati
    protected Integer           numCertPro; //numero certificazioni lavoro autonomo e provvigioni
    protected Recapito          indirizzoLettera;

    public CudBase() {}

    public boolean isAnnullamento() {
        return tipodichiarazione == 2 ? true : false;
    }

    public boolean isSostituzione() {
        return tipodichiarazione== 1 ? true : false;
    }

    public boolean isPrimaDichiarazione(){
        return tipodichiarazione == 0 ? true : false;
    }

    public String getAnnoFiscale() {
        return annoFiscale;
    }

    public Recapito getIndirizzoLettera() {
        return indirizzoLettera;
    }

    /**
     * default FormattatoreDate.FORMATO_DATA_dd___MM___YYYY
     * @return
     */
    public String getDataEleaborazione(String formato) {
        return FormattatoreDate.formatDate(dataElaborazione,formato!=null?formato:FormattatoreDate.FORMATO_DATA_dd___MM___YYYY);
    }

    public String getDataEleaborazione(){return getDataEleaborazione("dd  MM   yyyy");}

    public SostitutoImposta getDatoreLavoro() {
        return datoreLavoro;
    }

    public PercettoreSomme getPercettoreSomme() {
        return percettoreSomme;
    }

    public String getNumCertDip() {
        return numCertDip!=null?numCertDip+"":"";
    }

    public String getNumCertPro() {
        return numCertPro!=null?numCertPro+"":"";
    }

    public void setPercettoreSomme(PercettoreSomme percettoreSomme) {
        this.percettoreSomme = percettoreSomme;
    }

    public void setDatoreLavoro(SostitutoImposta datoreLavoro) {
        this.datoreLavoro = datoreLavoro;
    }
    public void setDataEleaborazione(Date dataEleaborazione) {
        this.dataElaborazione = dataEleaborazione;
    }

    /**
     * numero certificazioni lavoro dipendente o assimilati
     * @param numCertDip
     */
    public void setNumCertDip(Integer numCertDip) {
        this.numCertDip = numCertDip;
    }


    /**
     * numero certificazioni lavoro autonomo e provvigioni
     * @param numCertPro
     */
    public void setNumCertPro(Integer numCertPro) {
        this.numCertPro = numCertPro;
    }

    // Aprile 2023 (Engineering)
    /** @return {@link #tipodichiarazione} */
    public int getTipoDichiarazione() {
        return tipodichiarazione;
    }

    /**
     * setTipodichiarazione(Cud.PRIMA_DICHIARAZIONE)
     * setTipodichiarazione(Cud.RETTIFICA_DICHIARAZIONE)
     * setTipodichiarazione(Cud.ANNULLA_DICHIARAZIONE)
     * @param tipodichiarazione
     */
    public void setTipodichiarazione(int tipodichiarazione) throws ValidationException{
        if(tipodichiarazione>2||tipodichiarazione<0)
            throw new ValidationException("la prop tipoDichiarazione deve valere 0, 1 o 2");
        this.tipodichiarazione = tipodichiarazione;
    }

    public void setIndirizzoLettera(Recapito indirizzoLettera) {
        this.indirizzoLettera = indirizzoLettera;
    }
}
