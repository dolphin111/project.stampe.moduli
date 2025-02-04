package com.fideuram.modello.selection.investimenti;

import com.fideuram.modello.selection.Fundhouse;

import java.util.ArrayList;
import java.util.List;

/**
 * User: V801068
 * Date: 26/01/16
 * Time: 17.29
 */
public abstract class SelezioneInvestimenti {
    private String nome;          //OICR APPARTENENTI ALLA SELECTION FIDEURAM
    private String puntatore;
    private List<Fundhouse> fundhouses;

    public String getPuntatore() {
        return puntatore;
    }

    public String getNome() {
        return nome;
    }

    public abstract String getProvenienza();


    public Boolean isFondoInterno() {
        return false;
    }

    public Boolean isFondoEsterno() {
        return false;
    }

    public Boolean isPropostaInvestimento() {
        return false;
    }

    public String getTipo() {
        return  nome.startsWith("ETF")?"ETF":"OICR";
    }


    /**
     * Restituisce true se contiene almento un elemento Fundhouse
     * @return
     */
    public boolean hasFundhouse(){
        return getFundhouses().size()>0?true:false;
    }

    public void addFundhouses( Fundhouse  fundhouse) {
        getFundhouses().add(fundhouse);
    }

    public List<Fundhouse> getFundhouses() {
        if(null==fundhouses)
            fundhouses=new ArrayList<Fundhouse>();
        return fundhouses;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setPuntatore(String puntatore) {
        this.puntatore = puntatore;
    }


}
