package com.fideuram.printer.previdenza.sharedMock;

import com.fideuram.stampe.modello.previdenza.Convenzione;

/**
 * Created by V801068 on 04/06/14.
 */
public class ConvenzioneMock {
    public static Convenzione getConvenzione(){
        Convenzione c = new Convenzione();
        c.setTitolo("Fondo Pensione Fideuram");
        return c;
    }
}