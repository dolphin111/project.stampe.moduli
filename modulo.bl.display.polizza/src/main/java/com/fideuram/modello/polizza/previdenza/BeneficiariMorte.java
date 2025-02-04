package com.fideuram.modello.polizza.previdenza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * User: V801068
 * Date: 07/05/15
 * Time: 10.12
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class BeneficiariMorte {
    private List<String> beneficiarioMorte;


    public List<String> getBeneficiarioMorte() {
        return beneficiarioMorte!=null?beneficiarioMorte:new ArrayList<String>();
    }
}
