package com.fideuram.modello.selection;

import com.fideuram.utils.LoggingUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 
 * User: logan
 * Date: 06/06/12
 * Time: 14.33
 */
public class Fundhouse implements Serializable {
    //private String fondo;       //OICR
    private String nome;        //:FONDITALIA
    private List<Isin> isins;
   

	public String getNome() {
        LoggingUtils.info("FUNDHOUSE :" + nome);
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Isin> getIsins() {
        return isins;
    }

    public void setIsins(List<Isin> isins) {
        this.isins = isins;
    }

    public void addIsins(Isin isin) {
        if(null==isins)
            isins=new ArrayList<Isin>();
        this.isins.add(isin);
    }
}
