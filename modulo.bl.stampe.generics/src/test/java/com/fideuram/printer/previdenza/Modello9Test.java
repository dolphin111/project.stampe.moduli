package com.fideuram.printer.previdenza;

import com.fideuram.printer.mock.*;
import com.fideuram.printer.previdenza.sharedMock.RigettoMock;
import com.fideuram.stampe.modello.previdenza.Previdenza;

/**
 * Created by V801068 on 04/06/14.
 */
public class Modello9Test  extends ModelloTest{
    public static void main(String args[]){
        new ModelloTest().test(1109, Modello9Mock.getPrevidenzaMock());
    }
}
