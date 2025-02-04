package com.fideuram.stampe.modello.redditi.d2016.datiprevidenziali;

import com.fideuram.stampe.modello.redditi.AbstractQBase;

import javax.xml.bind.ValidationException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 18/01/16
 * Time: 17.57
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Q21 extends AbstractQBase {
    private String c15;
    private String c16;
    private String c17;
    private String c18;
    private String c19;
    private String c20;
    private String c21;
    private String c22;
    private Double c23;
    private Double c24;
    private Double c25;
    private Double c26;
    private Double c27;
    private Double c28;
    private Double c29;
    private Double c30;
    private Double c31;
    private Double c32;
    private char   c33;
    private char[] c34;  // 12 posizioni

    public Q21() {
    }

    /**
     * Costruttore da usare nel caso la denuncia riguardi tutti i mesi dell'anno
     * @param c33
     */
    public Q21(char c33) {
        this.c33 = c33;
    }

    /**
     * Costruttore da usare nel caso si debbano specificare i mesi dell'anno escludi daslla denuncia
     * @param c34
     */
    public Q21(char[] c34) throws ValidationException {
        if (c34.length<12)
            throw new ValidationException("Q21 - Character[] c34 --- deve essere di docici elementi non uno di più non uno di meno");
        this.c34 = c34;
    }

    public String getC15 ()  {return c15!=null?c15:"" ;}
    public String getC16 ()  {return c16!=null?c16:"" ;}
    public String getC17 ()  {return c17!=null?c17:"" ;}
    public String getC18 ()  {return c18!=null?c18:"" ;}
    public String getC19 ()  {return c19!=null?c19:"" ;}
    public String getC20 ()  {return c20!=null?c20:"" ;}
    public String getC21 ()  {return c21!=null?c21:"" ;}
    public String getC22 ()  {return c22!=null?c22:"" ;}

    public String getC23 ()  {return formattedDouble2String(c23 );}
    public String getC24 ()  {return formattedDouble2String(c24 );}
    public String getC25 ()  {return formattedDouble2String(c25 );}
    public String getC26 ()  {return formattedDouble2String(c26 );}
    public String getC27 ()  {return formattedDouble2String(c27 );}
    public String getC28 ()  {return formattedDouble2String(c28 );}
    public String getC29 ()  {return formattedDouble2String(c29 );}
    public String getC30 ()  {return formattedDouble2String(c30 );}
    public String getC31 ()  {return formattedDouble2String(c31 );}
    public String getC32 ()  {return formattedDouble2String(c32 );}
    public char[] getC34()   {return c34;}
    /**
     * restuisce tutto l'anno = true
     * @return
     */
    public boolean isT(){
        return c34!=null?false:true;
    }

    public void setC15(String c15) {
        this.c15 = c15;
    }

    public void setC16(String c16) {
        this.c16 = c16;
    }

    public void setC17(String c17) {
        this.c17 = c17;
    }

    public void setC18(String c18) {
        this.c18 = c18;
    }

    public void setC19(String c19) {
        this.c19 = c19;
    }

    public void setC20(String c20) {
        this.c20 = c20;
    }

    public void setC21(String c21) {
        this.c21 = c21;
    }

    public void setC22(String c22) {
        this.c22 = c22;
    }

    public void setC23(Double c23) {
        this.c23 = c23;
    }

    public void setC24(Double c24) {
        this.c24 = c24;
    }

    public void setC25(Double c25) {
        this.c25 = c25;
    }

    public void setC26(Double c26) {
        this.c26 = c26;
    }

    public void setC27(Double c27) {
        this.c27 = c27;
    }

    public void setC28(Double c28) {
        this.c28 = c28;
    }

    public void setC29(Double c29) {
        this.c29 = c29;
    }

    public void setC30(Double c30) {
        this.c30 = c30;
    }

    public void setC31(Double c31) {
        this.c31 = c31;
    }

    public void setC32(Double c32) {
        this.c32 = c32;
    }
}
