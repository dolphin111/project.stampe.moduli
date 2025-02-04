package com.fideuram.stampe.modello.rendiconti.grafici;

import fr.opensagres.xdocreport.document.images.IImageProvider;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * User: v801068
 * Date: 03/11/14
 * Time: 10.37
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Grafico {
    @XmlTransient
    protected IImageProvider grafico;

    public IImageProvider getGrafico() {
        return grafico;
    }

    public void setGrafico(IImageProvider grafico) {
        this.grafico = grafico;
    }
}
