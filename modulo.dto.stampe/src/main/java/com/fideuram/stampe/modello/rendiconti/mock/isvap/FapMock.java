package com.fideuram.stampe.modello.rendiconti.mock.isvap;

import com.fideuram.stampe.modello.rendiconti.mock.BaseMock;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.FapIsvap;
import java.util.Date;

/**
 * Created with
 * User: v801068
 * Date: 11/02/14
 * Time: 11.19
 */
public class FapMock extends BaseMock {

    public static FapIsvap getMock(){
        FapIsvap fap3 = new FapIsvap();
        fap3.setDataRiferimento(new Date());
        fap3.setFondi(getFondi("F.A.P"));
        fap3.setPeriodo("16-22");
        return fap3;
    }


}
