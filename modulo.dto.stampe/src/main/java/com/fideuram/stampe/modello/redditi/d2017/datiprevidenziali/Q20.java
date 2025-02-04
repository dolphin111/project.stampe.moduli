package com.fideuram.stampe.modello.redditi.d2017.datiprevidenziali;

import com.fideuram.stampe.modello.redditi.AbstractQBase;

import javax.xml.bind.ValidationException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 18/01/16
 * Time: 17.11
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Q20 extends AbstractQBase {
    private String c9;
    private String c10;
    private String c11;
    private String c12;
    private String c13;
    private String c14;
    private String c15;
    private String c16;
    private String c17;
    private Double c18;
    private Double c19;
    private Double c20;
    private Double c21;
    private Double c22;
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
    private Double c33;
    private Double c34;
    private char   c35;
    private char[] c36;  // 12 posizioni
    private String c37;
    private char[] c38;
    private String c39;
    private Double c40;

    public String getC9 ()   {return c9 ;}
    public String getC10 ()  {return c10 ;}
    public String getC11 ()  {return c11 ;}
    public String getC12 ()  {return c12 ;}
    public String getC18 ()  {return formattedDouble2String(c18 );}
    public String getC19 ()  {return formattedDouble2String(c19 );}
    public String getC20 ()  {return formattedDouble2String(c20 );}
    public String getC21 ()  {return formattedDouble2String(c21 );}
    public String getC22 ()  {return formattedDouble2String(c22 );}
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
    public String getC33 ()  {return formattedDouble2String(c33 );}
    public String getC34 ()  {return formattedDouble2String(c34 );}
    public char getC35() 	 {return c35;}
    public char[] getC36() 	 {return c36;}
    public String getC37 ()  {return c37;}
    public char[] getC38 ()  {return c38;}
    public String getC39 ()  {return c39;}
    public String getC40 ()  {return formattedDouble2String(c40 );}

    public Q20() {}

//    /**
//     * Costruttore da usare nel caso la denuncia riguardi tutti i mesi dell'anno
//     * @param c13
//     */
//    public Q20(char c13) {
//        this.c13 = c13;
//    }
//
    /**
     * Costruttore da usare nel caso si debbano specificare i mesi dell'anno escludi daslla denuncia
     * @param c36
     */
    public Q20(char[] c36) throws ValidationException {
        if (c36.length<12)
            throw new ValidationException("Q20 - Character[] c36 --- deve essere di docici elementi non uno di pi\u00F9 non uno di meno");
        this.c36 = c36;
    }

    /**
     * restuisce tutto l'anno = true
     * @return
     */
    public boolean isT(){
        return c36!=null?false:true;
    }

    public void setC9(String c9) {
        this.c9 = c9;
    }

    public void setC10(String c10) {
        this.c10 = c10;
    }

    public void setC11(String c11) {
        this.c11 = c11;
    }

    public void setC12(String c12) {
        this.c12 = c12;
    }
	public String getC15() {
		return c15;
	}
	public void setC15(String c15) {
		this.c15 = c15;
	}
	public String getC16() {
		return c16;
	}
	public void setC16(String c16) {
		this.c16 = c16;
	}
	public String getC17() {
		return c17;
	}
	public void setC17(String c17) {
		this.c17 = c17;
	}

	public String getC13() {
		return c13;
	}
	public void setC13(String c13) {
		this.c13 = c13;
	}
	public String getC14() {
		return c14;
	}
	public void setC14(String c14) {
		this.c14 = c14;
	}
	public void setC18(Double c18) {
		this.c18 = c18;
	}
	public void setC19(Double c19) {
		this.c19 = c19;
	}
	public void setC20(Double c20) {
		this.c20 = c20;
	}
	public void setC21(Double c21) {
		this.c21 = c21;
	}
	public void setC22(Double c22) {
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
	public void setC33(Double c33) {
		this.c33 = c33;
	}
	public void setC34(Double c34) {
		this.c34 = c34;
	}
	public void setC35(char c35) {
		this.c35 = c35;
	}
	public void setC36(char[] c36) {
		this.c36 = c36;
	}
	public void setC37(String c37) {
		this.c37 = c37;
	}
	public void setC38(char[] c38) {
		this.c38 = c38;
	}
	public void setC39(String c39) {
		this.c39 = c39;
	}
	public void setC40(Double c40) {
		this.c40 = c40;
	}
    
}
