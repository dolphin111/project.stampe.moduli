package com.fideuram.printer.previdenza;

import com.fideuram.printer.mock.PrevidenzaMock;
import com.fideuram.printer.previdenza.sharedMock.DocumentazioneMock;
import com.fideuram.stampe.modello.previdenza.Previdenza;

/**
 * Created by V801068 on 04/06/14.
 */
public class Modello5Test extends ModelloTest{
    public static void main(String args[]){
        new ModelloTest().test(1105, Modello4_5_6_7Mock.getPrevidenzaMock());
    }
}
