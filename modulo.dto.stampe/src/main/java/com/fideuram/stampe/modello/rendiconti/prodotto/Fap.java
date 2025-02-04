package com.fideuram.stampe.modello.rendiconti.prodotto;

import com.fideuram.stampe.modello.rendiconti.rendimento.RendimentoMedioAnnuo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with
 * User: v801068
 * Date: 29/01/14
 * Time: 17.24
 */
@XmlRootElement(name="Fap", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Fap extends NormativaProdottoAllegato{


    protected String periodo="";


    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }


}
