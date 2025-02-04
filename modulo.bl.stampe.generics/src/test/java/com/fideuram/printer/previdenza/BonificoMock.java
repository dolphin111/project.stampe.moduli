package com.fideuram.printer.previdenza;

import com.fideuram.stampe.modello.previdenza.versamenti.Bonifico;
import com.fideuram.stampe.modello.previdenza.versamenti.VersamentiPrevidenza;

/**
 * User: V801068
 * Date: 24/07/14
 * Time: 15.11
 */
public class BonificoMock {
    public static VersamentiPrevidenza getMock(){

        Bonifico b= new Bonifico();
        b.setCausale("124128415348154132941 / P.IVA 91826946012561");
        b.setImportoDistinta("154");
        b.setImportoDaBonificare("15");
        b.setIban("IT872134851987561294");
        b.setIntestatoA("Fideuram Vita SPA");

        VersamentiPrevidenza vp = new VersamentiPrevidenza();
        vp.setBonifico(b);
        return vp;
    }
}
