package com.fideuram.stampe.modello.rendita;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: v801092
 * Date: 01/12/15
 * Time: 17.33
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name="prestazioni", namespace= "")
@XmlAccessorType(XmlAccessType.FIELD)
public class Prestazioni {

    @XmlElement(name = "prestazione")
    private java.util.List<Prestazione> prestazione;

    @XmlElement(name = "tipo")    /**Prestazione o a debito o a credito**/
    private String tipo;

    public List<Prestazione> getPrestazione() {
        return prestazione;
    }

    public void setPrestazione(List<Prestazione> prestazione) {
        this.prestazione = prestazione;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
