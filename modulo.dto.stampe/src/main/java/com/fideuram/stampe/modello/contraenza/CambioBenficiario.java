package com.fideuram.stampe.modello.contraenza;

import com.fideuram.stampe.modello.attori.Individuo;
import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: V801068
 * Date: 17/06/15
 * Time: 8.23
 */
@XmlRootElement(name="CambioBenficiario", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class CambioBenficiario extends RichiestaVariazione{
    private Date dataDecorrenza;
    private List<Individuo> nuoviBeneficiari;

    public String getDataDecorrenza() {
        if(null==dataDecorrenza)
            dataDecorrenza=new Date();
        return FormattatoreDate.formatDate(dataDecorrenza, FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    /**
     * Restituisce sempre una Lista di beneficiari anche se vuota e mai NULL
     * @return List<Individuo>
     */
    public List<Individuo> getNuoviBeneficiari() {
        return nuoviBeneficiari!=null?nuoviBeneficiari:new ArrayList<Individuo>();
    }

    public void setNuoviBeneficiari(List<Individuo> nuoviBeneficiari) {
        this.nuoviBeneficiari = nuoviBeneficiari;
    }

    public void addNuovoBeneficiario(Individuo nb) {
        if(null==nuoviBeneficiari)
            nuoviBeneficiari=new ArrayList<Individuo>();
        nuoviBeneficiari.add(nb);
    }

    public void setDataDecorrenza(Date dataDecorrenza) {
        this.dataDecorrenza = dataDecorrenza;
    }
}
