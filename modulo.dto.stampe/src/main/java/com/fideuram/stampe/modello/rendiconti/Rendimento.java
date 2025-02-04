package com.fideuram.stampe.modello.rendiconti;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created
 * User: V801068
 * Date: 15/01/14
 * Time: 10.51
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Rendimento {
    protected Integer anno;
    protected Double  percFondo;
    protected Double  percBM;
    protected Double  percOldBM;


    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    public Double getPercFondo() {
        return percFondo;
    }

    public void setPercFondo(Double percFondo) {
        this.percFondo = percFondo;
    }

    public Double getPercBM() {
        return percBM;
    }

    public void setPercBM(Double percBM) {
        this.percBM = percBM;
    }

    public Double getPercOldBM() {
        return percOldBM;
    }

    public void setPercOldBM(Double percOldBM) {
        this.percOldBM = percOldBM;
    }

    public boolean isValido(){
        boolean valido=false;
        if(null!=percFondo)
            valido=true;
        if(null!=percBM)
            valido=true;
        if(null!=percOldBM)
            valido=true;
        return valido;
    }
}
