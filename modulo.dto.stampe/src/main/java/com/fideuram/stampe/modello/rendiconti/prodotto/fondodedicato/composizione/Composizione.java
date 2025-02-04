package com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.composizione;

import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: v801068
 * Date: 07/11/14
 * Time: 11.14
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Composizione {
    private Date dataRiferimento;
    private List<Posizione> posizioni;

    public Composizione() {
        posizioni=new ArrayList<Posizione>();
    }

    public void addPosizione(Posizione p){
        posizioni.add(p);
    }

    public List<Posizione> getPosizioni() {
        return posizioni;
    }

    public String getDataRiferimento() {
        return FormattatoreDate.formatDate(dataRiferimento,FormattatoreDate.FORMATO_DATA_ESTESA_ITALIANA);
    }

    public void setDataRiferimento(Date dataRiferimento) {
        this.dataRiferimento = dataRiferimento;
    }

    public boolean hasPosizioni(){
        return posizioni.isEmpty()?true:false;
    }
}
