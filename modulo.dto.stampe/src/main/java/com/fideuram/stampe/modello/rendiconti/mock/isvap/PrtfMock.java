package com.fideuram.stampe.modello.rendiconti.mock.isvap;

import com.fideuram.stampe.modello.rendiconti.mock.BaseMock;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.FapIsvap;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.PrtfIsvap;

import java.util.Date;

/**
 * Created
 * User: v801068
 * Date: 11/02/14
 * Time: 15.06
 */
public class PrtfMock extends BaseMock {
    public static PrtfIsvap getMock(){
        PrtfIsvap fap3 = new PrtfIsvap();
        fap3.setDataRiferimento(new Date());
        fap3.setFondi(getFondi("PRTF"));
        return fap3;
    }
}
