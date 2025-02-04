package com.fideuram.stampe.modello.rendiconti.mock.ante551;

import com.fideuram.stampe.modello.rendiconti.mock.BaseMock;
import com.fideuram.stampe.modello.rendiconti.prodotto.ante551.Fulaa;

import java.util.Date;

/**
 * Created
 * User: v801068
 * Date: 28/01/14
 * Time: 10.42
 */
public class Ante551FulaaMock extends BaseMock {
    public static Fulaa getFulaaMock(){
        Fulaa fulaa = new Fulaa();
        fulaa.setDataRiferimento(new Date());
        fulaa.setFondi(getFondi("FUL.AA"));
        return fulaa;
    }
}
