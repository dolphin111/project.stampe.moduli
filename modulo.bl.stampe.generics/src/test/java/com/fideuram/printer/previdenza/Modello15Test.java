package com.fideuram.printer.previdenza;

import com.fideuram.printer.mock.PrevidenzaMock;
import com.fideuram.printer.previdenza.sharedMock.DocumentazioneMock;
import com.fideuram.stampe.modello.previdenza.Previdenza;

/**
 * Created by V801068 on 05/06/14.
 */
public class Modello15Test extends ModelloTest{

    public static void main(String args[]){
        //new ModelloTest().test(1115,getMock());
        new ModelloTest().test(1115,Modello10Mock.getPrevidenzaMock());
    }

}
