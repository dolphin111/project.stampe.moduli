package com.fideuram.stampe.modello.asset;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by
 * User: logan
 * Date: 29/03/12
 * Time: 14.57
 */
@XmlRootElement(name="FondoInvestimentoGlobale")
@XmlAccessorType(XmlAccessType.FIELD)
public class FondoInvestimentoGlobale implements Serializable {
    private String idCategoria;                                 //01 || 02 || 03 else 04
    private String categoria;                                   //01 || 02 || 03 else 04
    private String idNomeFondo;                                 //01 || 02 || 03 .....
    private String nome;                                        //Fap 2012
    private String anno;                                        //2012 costruisce il titolo
    private String data;                                        //30 gennaio 2012
    List <FondoInvestimentoAnnuale> fondoInvestimentoAnnuales;
    private String descrizioneSintetica;

    public String getDescrizioneSintetica() {
        return descrizioneSintetica;
    }

    public void setDescrizioneSintetica(String descrizioneSintetica) {
        this.descrizioneSintetica = descrizioneSintetica;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
        categoria=getCategoria();
    }

    public String getIdNomeFondo() {
        return idNomeFondo;
    }

    public void setIdNomeFondo(String idNomeFondo) {
        this.idNomeFondo = idNomeFondo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<FondoInvestimentoAnnuale> getFondoInvestimentoAnnuales() {
        return fondoInvestimentoAnnuales;
    }

    public void setFondoInvestimentoAnnuales(List<FondoInvestimentoAnnuale> fondoInvestimentoAnnuales) {
        this.fondoInvestimentoAnnuales = fondoInvestimentoAnnuales;
    }

    public void addFondoInvestimentoAnnuale(FondoInvestimentoAnnuale fondoInvestimentoAnnuale){
        if(fondoInvestimentoAnnuales==null)
            this.fondoInvestimentoAnnuales=new ArrayList<FondoInvestimentoAnnuale>();
        this.fondoInvestimentoAnnuales.add(fondoInvestimentoAnnuale);
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    public String getCategoria(){
        int id= Integer.decode(idCategoria).intValue();
        switch (id){
            case 1:
                return "DESCRIZIONE";          //EX ISIN
            case 2:
                return "DESCRIZIONE";
            case 3:
                return "Nazione/Settore Merceologico";
            case 4:
                return "DESCRIZIONE";
            default:
                return "DESCRIZIONE";
        }
    }
}
