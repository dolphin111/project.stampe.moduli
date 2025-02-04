package com.fideuram.stampe.modello.attori;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by
 * User: logan
 * Date: 23/06/11
 * Time: 12.06
 */
public class PrivateBanker extends Persona implements Serializable {
	private static final long serialVersionUID = -8148832237299784406L;

    private List<Character> codice;
    private String  rete;

    public PrivateBanker() {
        codice=new ArrayList<Character>();
        for(int i=0;i<8;i++){
            codice.add(Character.valueOf(' '));
        }
    }

    public List<Character> getCodice() {
        return codice;
    }

    public void setCodice(String codicePb) {
        codicePb=codicePb.trim();
        char[] c= codicePb.toCharArray();
        for(int i=0;i<c.length;i++){
            this.codice.set(i,c[i]);
        }
    }

    public String getRete() {
        return rete;
    }

    public void setRete(String rete) {
        this.rete = rete;
    }

    @Override
    public String toString() {
        return getNome() + " " + getCognome();
    }
}
