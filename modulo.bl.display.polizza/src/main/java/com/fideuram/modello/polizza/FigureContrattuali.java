package com.fideuram.modello.polizza;


import com.fideuram.factory.FormatterFactory;
import com.fideuram.modello.attori.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by
 * User: logan
 * Date: 09/04/13
 * Time: 18.45
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class FigureContrattuali {
    private Contraente      contraente;
    private DatoreDiLavoro  datoreDiLavoro;
    private Rol             rol;
    private Banker          banker;
    private Assicurato      primoAssicurato;
    private Assicurato      secondoAssicurato;
    private Indirizzo       indirizzoContratto;
    private String          beneficiarioVita="";
    private String          beneficiarioMorte="";
    private boolean         isAttivoBeneficiarioVita;
    private boolean         isAttivoBeneficiarioMorte;
    private Date            dataFineBeneficiarioMorte;
    private Date            dataFineBeneficiarioVita;


    public Contraente getContraente() {
        return contraente;
    }

    public void setContraente(Contraente contraente) {
        this.contraente = contraente;
    }

   // public void setDataFineBeneficiarioMorte(Date dataFineBeneficiarioMorte) {
   //     this.dataFineBeneficiarioMorte = dataFineBeneficiarioMorte;
   // }
   //
   // public void setDataFineBeneficiarioVita(Date dataFineBeneficiarioVita) {
   //     this.dataFineBeneficiarioVita = dataFineBeneficiarioVita;
   // }
   //
   // public void setAttivoBeneficiarioVita(boolean attivoBeneficiarioVita) {
   //     isAttivoBeneficiarioVita = attivoBeneficiarioVita;
   // }
   //
   // public void setAttivoBeneficiarioMorte(boolean attivoBeneficiarioMorte) {
   //     isAttivoBeneficiarioMorte = attivoBeneficiarioMorte;
   // }

    public String getDataFineBeneficiarioMorte() {
        return dataFineBeneficiarioMorte!=null?FormatterFactory.getStandardDate(dataFineBeneficiarioMorte):"";
    }

    public String getDataFineBeneficiarioVita() {
        return dataFineBeneficiarioVita!=null?FormatterFactory.getStandardDate(dataFineBeneficiarioVita):"";
    }

    public boolean isAttivoBeneficiarioVita() {
        return isAttivoBeneficiarioVita;
    }

    public boolean isAttivoBeneficiarioMorte() {
        return isAttivoBeneficiarioMorte;
    }

    public DatoreDiLavoro getDatoreDiLavoro() {
        if(null==datoreDiLavoro){
            datoreDiLavoro=new DatoreDiLavoro();
            datoreDiLavoro.setPersonaFisica(new Persona());
        }
        return datoreDiLavoro;
    }

    public Rol getRol() {
        return rol;
    }

    public Banker getBanker() {
        return banker;
    }

    public Assicurato getPrimoAssicurato() {
        return primoAssicurato;
    }

    public Assicurato getSecondoAssicurato() {
        if(null==secondoAssicurato.getPersonaFisica()&&null==secondoAssicurato.getPersonaGiuridica()){
            secondoAssicurato=null;
            return null;
        }else{
           return secondoAssicurato;
        }
    }

    public Indirizzo getIndirizzoContratto() {
        return indirizzoContratto;
    }

    public void setIndirizzoContratto(Indirizzo indirizzoContratto) {
        this.indirizzoContratto = indirizzoContratto;
    }

    public String getBeneficiarioVita() {
        //if(null==beneficiarioVita)
        //    return "";
        //return beneficiarioVita;
        if(beneficiarioVita==null||beneficiarioVita.trim().equals(""))
            return "";
        return isAttivoBeneficiarioVita()?beneficiarioVita:beneficiarioVita +" (scaduto il "+ getDataFineBeneficiarioVita()+ ")" ;
    }

    public String getBeneficiarioMorte() {
        //if(null==beneficiarioMorte)
        //    return "";
        //return beneficiarioMorte;
        if(beneficiarioMorte==null||beneficiarioMorte.trim().equals(""))
            return "";
        return isAttivoBeneficiarioMorte()?beneficiarioMorte:beneficiarioMorte +" (scaduto il "+ getDataFineBeneficiarioMorte()+ ")" ;
    }


}
