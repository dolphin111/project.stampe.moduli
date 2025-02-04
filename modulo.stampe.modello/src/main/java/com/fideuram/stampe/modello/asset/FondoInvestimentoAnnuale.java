package com.fideuram.stampe.modello.asset;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: logan
 * Date: 29/03/12
 * Time: 14.36
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class FondoInvestimentoAnnuale implements Serializable {

    private List<CompartoAzioni> compartoAzionis;
    private String totalePercentuale="";                 //Lo calcoliamo noi
    private String totaleValore="";                      //Lo calcoliamo noi


    public boolean hasValore(){
           if(!totaleValore.equals("0,00"))
               return true;
           return false;
    }

    public List<CompartoAzioni> getCompartoAzionis() {
        return compartoAzionis;
    }

    public void setCompartoAzionis(List<CompartoAzioni> compartoAzionis) {
        this.compartoAzionis = compartoAzionis;
    }

    public void addCompartoAzioni(CompartoAzioni compartoAzioni){
        if(compartoAzionis==null)
           this.compartoAzionis= new ArrayList<CompartoAzioni>();
        this.compartoAzionis.add(compartoAzioni);
    }

    public String getTotalePercentuale() {
        return totalePercentuale;
    }

    public void setTotalePercentuale(String totalePercentuale) {
        this.totalePercentuale = totalePercentuale;
    }

    public String getTotaleValore() {
        return totaleValore;
    }

    public void setTotaleValore(String totaleValore) {
        this.totaleValore = totaleValore;
    }
}
