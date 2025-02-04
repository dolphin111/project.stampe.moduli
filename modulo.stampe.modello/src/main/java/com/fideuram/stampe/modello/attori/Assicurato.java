package com.fideuram.stampe.modello.attori;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlType;

/**
 * Created by
 * User: logan
 * Date: 23/06/11
 * Time: 11.20
 */
@XmlType(name="Assicurato")
public class Assicurato  extends Persona implements Serializable {
   	private static final long serialVersionUID = 3952699209920114844L;
	/**
     *  questo parametro specifica se primoAssicurato o secondo o vattelapesca
     *  se livello==1 allora primoAssicurato
     *  se livello==2 allora secondoAssicurato
     *  ....
     */
    private int livello;
    private int etaAssicurativa;


    public int getEtaAssicurativa() {
        return etaAssicurativa;
    }

    public void setEtaAssicurativa(int etaAssicurativa) {
        this.etaAssicurativa = etaAssicurativa;
    }

    public int getLivello() {
        return livello;
    }

    public void setLivello(int livello) {
        this.livello = livello;
    }

    public boolean isPrimoAssicurato(){
         if(livello==1)
             return true;
         return false;
    }
}
