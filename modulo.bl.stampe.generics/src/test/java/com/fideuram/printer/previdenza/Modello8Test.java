package com.fideuram.printer.previdenza;

import com.fideuram.printer.mock.PrevidenzaMock;
import com.fideuram.stampe.modello.previdenza.Previdenza;

/**
 * Created by V801068 on 04/06/14.
 */
public class Modello8Test extends ModelloTest{
    public static void main(String args[]){
        new ModelloTest().test(1108, Modello8Mock.getPrevidenzaMock());
    }
}
