package com.fideuram.stampe.modello.variazioneBeneficiario;

import com.fideuram.stampe.modello.attori.Individuo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User: V801068
 * Date: 04/02/16
 * Time: 11.13
 */
@XmlRootElement(name="BeneficiarioVB", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class BeneficiarioVB implements Serializable{
    private String descrizioneCV;
    private boolean  isGenericoCV=false;
    private String descrizioneCM;
    private boolean  isGenericoCM=false;
    private boolean  isBeneficiariCV=false;
    private boolean  isBeneficiariCM=false;
    private  List<Individuo>  beneficiarioVita;
    private  List<Individuo>  beneficiarioMorte;
    private  List<String>  listaBeneficiariVita;
    private  List<String>  listaBeneficiariMorte;


    public boolean isGenericoCV() {
        return isGenericoCV;
    }

    public List<String> getListaBeneficiariVita()
    {
        listaBeneficiariVita = new ArrayList<String>();

        if(isGenericoCV())
        {
            listaBeneficiariVita.add(descrizioneCV);
        }
        else
        {
            for (int i = 0; beneficiarioVita != null && i<beneficiarioVita.size(); i++)
            {
                Individuo ind =  beneficiarioVita.get(i);
                listaBeneficiariVita.add(ind.getCognome() +" "+ ind.getNome() +" " +ind.getCf() + " " + ind.getPercentualeBeneficiario()+"%");
            }
        }

        return listaBeneficiariVita;
    }

    public void setDescrizioneCV(String descrizioneCV) {
        this.descrizioneCV = descrizioneCV;
    }

    public boolean isGenericoCM() {
        return isGenericoCM;
    }

    public List<String>  getListaBeneficiariMorte() {

        listaBeneficiariMorte = new ArrayList<String>();

        if(isGenericoCM())
        {
            listaBeneficiariMorte.add(descrizioneCM);
        }
        else{
            for (int i = 0; beneficiarioMorte != null && i<beneficiarioMorte.size(); i++)
            {
                Individuo ind =  beneficiarioMorte.get(i);
                listaBeneficiariMorte.add(ind.getCognome() +" "+ ind.getNome() +" " +ind.getCf() + " " + ind.getPercentualeBeneficiario()+"%");
            }
         }

        return listaBeneficiariMorte;
    }

    public void setDescrizioneCM(String descrizioneCM) {
        this.descrizioneCM = descrizioneCM;
    }

    public void setBeneficiarioVita(List<Individuo> beneficiarioVita) {
        this.beneficiarioVita = beneficiarioVita;
    }
    public void setBeneficiarioMorte(List<Individuo> beneficiarioMorte) {
        this.beneficiarioMorte = beneficiarioMorte;
    }

    public void setListaBeneficiariVita(List<String> listaBeneficiariVita) {
        this.listaBeneficiariVita = listaBeneficiariVita;
    }

    public void setListaBeneficiariMorte(List<String> listaBeneficiariMorte) {
        this.listaBeneficiariMorte = listaBeneficiariMorte;
    }

    public void setGenericoCV(boolean genericoCV) {
        isGenericoCV = genericoCV;
    }

    public void setGenericoCM(boolean genericoCM) {
        isGenericoCM = genericoCM;
    }

    public boolean isBeneficiariCV()
    {
        if((beneficiarioVita != null && beneficiarioVita.size()>0) || isGenericoCV())
            isBeneficiariCV = true;

        return isBeneficiariCV;
    }

    public boolean isBeneficiariCM()
    {
        if((beneficiarioMorte != null && beneficiarioMorte.size()>0) || isGenericoCM())
            isBeneficiariCM = true;

        return isBeneficiariCM;
    }
}
