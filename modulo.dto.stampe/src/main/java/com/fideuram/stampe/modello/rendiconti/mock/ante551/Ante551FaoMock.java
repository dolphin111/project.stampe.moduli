package com.fideuram.stampe.modello.rendiconti.mock.ante551;

import com.fideuram.stampe.modello.rendiconti.mock.BaseMock;
import com.fideuram.stampe.modello.rendiconti.prodotto.ante551.Fao;

import java.util.Date;

/**
 * Created with
 * User: v801068
 * Date: 28/01/14
 * Time: 10.40
 */
public class Ante551FaoMock extends BaseMock {
    public static Fao getFaoMock(){
        Fao fao = new Fao();
        fao.setDataRiferimento(new Date());
        fao.setFondi(getFondi("F.A.O"));
        return fao;
    }

}
