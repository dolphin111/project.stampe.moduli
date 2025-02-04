package com.fideuram.printer.previdenza;

/**
 * Created by V801068 on 05/06/14.
 */
public class Modello12Test extends ModelloTest{
    public static void main(String args[]){
        new ModelloTest().test(1112,Modello12Mock.getPrevidenzaMock());
        //new ModelloTest().test(1112,getMock());
    }


    /*public static Previdenza getMock(){
        Previdenza o = PrevidenzaMock.getPrevidenzaMock();
        o.setRigetto(RigettoMock.getRigetto());
        return o;
    }*/
}
