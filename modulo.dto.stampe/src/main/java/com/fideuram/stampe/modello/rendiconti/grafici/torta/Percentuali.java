package com.fideuram.stampe.modello.rendiconti.grafici.torta;

import com.fideuram.stampe.modello.rendiconti.grafici.Grafico;
import com.fideuram.stampe.modello.utils.FormattatorePerc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * User: v801068
 * Date: 31/10/14
 * Time: 8.45
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Percentuali extends Grafico {

    protected List<EelementoTorta> percentuali;
    protected Boolean nd=false;
    protected Boolean valoriNegativi=false;

    public Percentuali() {
        percentuali =new ArrayList<EelementoTorta>();
    }

    public void addElement(EelementoTorta fettina){
        percentuali.add(fettina);
    }

    public List<EelementoTorta> getPercentuali() {
        return percentuali;
    }


    public List<EelementoTorta> getPercentualiCleaaned() {
        List l= new ArrayList<EelementoTorta>();
        for(int i=0;i<percentuali.size();i++){
            EelementoTorta e = percentuali.get(i);
            if (e.getValue()>0){l.add(e);}

        }
        if(l.isEmpty()){
            l.add(new EelementoTorta("n.d.",0.0));
            nd=true;
        }
        percentuali=l;
        return l;
    }

    public Boolean isNd() {
        return nd;
    }
    public Boolean hasNegativi() {
        return valoriNegativi;
    }

    public String getTotale(){
        double totale=0;
        for(int i=0; i<percentuali.size();i++){
            EelementoTorta b=  percentuali.get(i);
            totale=totale+b.getValue();
        }

        String totalePercentuale = FormattatorePerc.percentualeStandard(totale, true);
        totale = Double.parseDouble(totalePercentuale.replace('%', ' ').replace(',', '.'));
        if(totale > 100 )
            valoriNegativi = true;

        return totalePercentuale;
    }


    //Gestione separata delle percentuali negative
    private double totaleNegativo;
    public String getTotaleNegativo(){
        for(int i=0;i<percentuali.size();i++){
            EelementoTorta e = percentuali.get(i);
            if (e.getValue()<0){totaleNegativo=totaleNegativo+e.getValue();}
        }
        return FormattatorePerc.percentualeStandard(totaleNegativo, true);
    }
   /* public boolean hasNegativi(){
        for(int i=0;i<percentuali.size();i++){
            EelementoTorta e = percentuali.get(i);
            if (e.getValue()<0){return true;}
        }
        return false;
    }*/
}
