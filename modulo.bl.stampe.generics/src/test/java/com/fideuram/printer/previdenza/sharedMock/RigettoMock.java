package com.fideuram.printer.previdenza.sharedMock;

import com.fideuram.stampe.modello.previdenza.Rigetto;

/**
 * Created by V801068 on 04/06/14.
 */
public class RigettoMock {
    public static Rigetto getRigetto(){
        Rigetto r = new Rigetto();
    r.addCausa("che ti sei scordado di avvisare");
    r.addCausa("che ti sei scordado di chiudere la porta");
    r.addCausa("che ti sei scordado anche il tuo nome");
    return r;
}
}
