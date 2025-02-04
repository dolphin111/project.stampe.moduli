package com.fideuram.stampe.modello.rendiconti;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: v801068
 * Date: 30/10/14
 * Time: 16.39
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Benchmark {
    private String  previsto;

    public String getPrevisto() {
        return previsto!=null?previsto:"non previsto";
    }

    public void setPrevisto(String previsto) {
        this.previsto = previsto;
    }
}
