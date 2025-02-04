package com.fideuram.modello;

import javax.xml.bind.annotation.XmlTransient;

/**
 * <br>Questo bean mappa i dati relativi alla operazione di richiesta din un documento
 * <br>in termini di Data e descrizione della richiesta.
 *
 * Created with
 * User: logan
 * Date: 14/07/13
 * Time: 10.56
 */
@XmlTransient
public class RichiestaDocumento {
    private int richiesta;
    private String descizioneRichiesta;

    public RichiestaDocumento(int richiesta, String descizioneRichiesta) {
        this.richiesta = richiesta;
        this.descizioneRichiesta = descizioneRichiesta;
    }

    public int getRichiesta() {
        return richiesta;
    }

    public String getDescizioneRichiesta() {
        return descizioneRichiesta;
    }
}
