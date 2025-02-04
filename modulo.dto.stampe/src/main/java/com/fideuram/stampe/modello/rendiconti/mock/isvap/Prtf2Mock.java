package com.fideuram.stampe.modello.rendiconti.mock.isvap;

import com.fideuram.stampe.modello.rendiconti.mock.BaseMock;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.Prtf2Isvap;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.PrtfIsvap;

import java.util.Date;

/**
 * Created
 * User: v801068
 * Date: 11/02/14
 * Time: 16.16
 */
public class Prtf2Mock extends BaseMock {
    public static Prtf2Isvap getMock(){
        Prtf2Isvap fap3 = new Prtf2Isvap();
        fap3.setDataRiferimento(new Date());
        fap3.setFondi(getFondi("PRTF2"));
        return fap3;
    }
}
