package com.fideuram.stampe.modello.previdenza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by V801068 on 04/06/14.
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Rigetto {
    private List<String> causa;

    public List<String> getCausa() {
        if(null==causa)
            causa=new ArrayList<String>();
        return causa;
    }

    public void addCausa(String c){
        if(null==causa)
            causa=new ArrayList<String>();
         causa.add(c);
    }
}
