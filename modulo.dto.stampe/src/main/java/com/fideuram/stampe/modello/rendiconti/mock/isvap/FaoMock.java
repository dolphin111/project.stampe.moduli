package com.fideuram.stampe.modello.rendiconti.mock.isvap;

import com.fideuram.stampe.modello.rendiconti.mock.BaseMock;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.FaoIsvap;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.FapIsvap;

import java.util.Date;

/**
 * Created with
 * User: v801068
 * Date: 11/02/14
 * Time: 18.57
 */
public class FaoMock extends BaseMock {
    public static FaoIsvap getMock(){
        FaoIsvap fap3 = new FaoIsvap();
        fap3.setDataRiferimento(new Date());
        fap3.setFondi(getFondi("F.A.O."));
        return fap3;
    }
}
