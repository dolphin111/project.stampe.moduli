package com.fideuram.printer.previdenza;

import com.fideuram.printer.mock.PrevidenzaMock;
import com.fideuram.stampe.modello.previdenza.Previdenza;

/**
 * Created by V801068 on 05/06/14.
 */
public class Modello14Test  extends ModelloTest{
    public static void main(String args[]){
        new ModelloTest().test(1114,getMock());
    }

    public static Previdenza getMock(){
        Previdenza o = PrevidenzaMock.getPrevidenzaMock();
        return o;
    }
}
