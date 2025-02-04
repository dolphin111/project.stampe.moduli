package com.fideuram.stampe.modello.redditi.d2024.datiPrevidenziali;

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
  
    private Double c41;
    private Double c42;
    private Double c43;
    private Double c44;
    private char[] c46;  // 12 posizioni
    private String c47;
    private String c48;

    public Q21() {
    }

    /**
     * Costruttore da usare nel caso si debbano specificare i mesi dell'anno escludi daslla denuncia
     * @param c34
     */
    public Q21(char[] c46) throws ValidationException {
        if (c46.length<12)
            throw new ValidationException("Q21 - Character[] c46 --- deve essere di docici elementi non uno di piu non uno di meno");
        this.c46 = c46;
    }

    public String getC41 ()  {return formattedDouble2String(c41 );}
    public String getC42 ()  {return formattedDouble2String(c42 );}
    public String getC43 ()  {return formattedDouble2String(c43 );}
    public String getC44 ()  {return formattedDouble2String(c44 );}
    public char[] getC46()   {return c46;}
    public String getC47 ()  {return c47!=null?c47:"" ;}
    public String getC48 ()  {return c48!=null?c48:"" ;}

    /**
     * restuisce tutto l'anno = true
     * @return
     */
    public boolean isT(){
        return c46!=null?false:true;
    }
    
	public void setC41(Double c41) {
		this.c41 = c41;
	}

	public void setC42(Double c42) {
		this.c42 = c42;
	}

	public void setC43(Double c43) {
		this.c43 = c43;
	}

	public void setC44(Double c44) {
		this.c44 = c44;
	}

	public void setC46(char[] c46) {
		this.c46 = c46;
	}

	public void setC47(String c47) {
		this.c47 = c47;
	}

	public void setC48(String c48) {
		this.c48 = c48;
	}

    
}
