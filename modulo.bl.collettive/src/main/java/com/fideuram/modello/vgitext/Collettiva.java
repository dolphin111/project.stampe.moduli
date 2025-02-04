package com.fideuram.modello.vgitext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with
 *
 * User: logan
 * Date: 05/06/13
 * Time: 11.37
 */
public class Collettiva {
    public List<Gruppo> gruppi;

    public List<Gruppo> getGruppi() {
        if(gruppi ==null){
            gruppi =new ArrayList();
        }
        return gruppi;
    }

    public void setGruppi(List<Gruppo> gruppi) {
        this.gruppi = gruppi;
    }
}
