package com.fideuram.modello.vgitext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with
 * User: logan
 * Date: 05/06/13
 * Time: 11.37
 */
public class Gruppo {

    private List<Riga> righe;

    public List<Riga> getRighe() {
        if(righe ==null){
            righe =new ArrayList();
        }
        return righe;
    }

    public void setRighe(List<Riga> righe) {

        this.righe = righe;
    }
}
