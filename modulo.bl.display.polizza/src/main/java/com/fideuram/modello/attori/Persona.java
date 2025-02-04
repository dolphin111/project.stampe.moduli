package com.fideuram.modello.attori;

import com.fideuram.modello.ElementdiFormattazione;
import com.fideuram.utils.DateUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by
 * User: logan
 * Date: 10/04/13
 * Time: 16.17
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Persona {

    private String cognome="";
    private String nome="";
    private String codicefiscale;
    private String codiceFiscaleSocieta;
    private Date   datanascita;
    private String sesso;
    private String vip;
    private String partitaIva;
    private String ragioneSociale="";
    private String appellativo="";
    private AreaCliente areaCliente;

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodicefiscale() {
        if(null==codicefiscale&&null!=codiceFiscaleSocieta)
            return codiceFiscaleSocieta;
        return codicefiscale;
    }

    public void setCodicefiscale(String codicefiscale) {
        this.codicefiscale = codicefiscale;
    }

    public String getDatanascita() {
        if(null==datanascita)
            return "";
        return DateUtils.formatDate(datanascita, ElementdiFormattazione.DATA);
    }

    public void setDatanascita(Date datanascita) {
        this.datanascita = datanascita;
    }

    public String getSesso() {
        if (sesso.equalsIgnoreCase("M"))
            return "Maschio";
        else
            return "Femmina";
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    @Override
    public String toString() {
        if(ragioneSociale.length()>0)
            return ragioneSociale;
        return cognome+' '+nome;
    }

    public String getAppellativo(){
           if(null!=cognome&&!cognome.equals("")){
                if(sesso.equalsIgnoreCase("M"))
                    return "Gentile Signore";
                else if((sesso.equalsIgnoreCase("F")))
                    return "Gentile Signora";
           }
           return "Spett.le";

    }

    public AreaCliente getAreaCliente() {
        if(null==areaCliente)
            return new AreaCliente();
        return areaCliente;
    }

    public void setAreaCliente(AreaCliente areaCliente) {
        this.areaCliente = areaCliente;
    }
}
