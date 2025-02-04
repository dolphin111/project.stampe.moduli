package com.fideuram.stampe.modello.redditi.d2025.datiPrevidenziali;

import com.fideuram.stampe.modello.redditi.AbstractQBase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 15/01/16
 * Time: 11.07
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Q15  extends AbstractQBase {

	private Double  c481;		//2019:Totale redditi					ex:Totale redditi
    private Double  c482;		//2019:Totale ritenute Irpef			ex:Totale ritenute Irpef
    private Double  c483;		//2019:Totale ritenute Irpef sospese	ex:Totale ritenute Irpef sospese
    private String  c484;		//2019: NO								ex:Causale
    private Double  c485;		//2019: NO								ex:Redditi
    private String  c486;		//2019: NO								ex:Titolo
    private Double  c487;		//2019: NO								ex:Ritenute Irpef
    private Double  c488;		//2019: NO								ex:Ritenute Irpef sospese
    private String  c489;       //2019: NO								ex:anni mesi
    private Double  c490;		//2019: NO
    private Double  c491;		//2019: NO
    private String  c492;		//2019: NO

    private Double  c496;		//2019:Quota esente
    //GIO::: 2020
    private Double  c497;		//2019:Quota imponibile
    private Double  c498;		//2019:Ritenute irpef
    private Double  c499;       //2019:Addizionale regionale all'irpef	ex:anni mesi
    private Double  c500;		//2019:Totale ritenute irpef sospese
    private Double  c501;		//2019:Totale addizionale regionale dell'irpef sospesa

    public String getC481() {return  formattedDouble2String(c481);}
    public String getC482() {return  formattedDouble2String(c482);}
    public String getC483() {return  formattedDouble2String(c483);}
    public String getC484() {return  c484!=null?c484:"";}
    public String getC485() {return  formattedDouble2String(c485);}
    public String getC486() {return  c486!=null?c486:"";}
    public String getC487() {return  formattedDouble2String(c487);}
    public String getC488() {return  formattedDouble2String(c488);}
    public String getC489() {return  c489!=null?c489:"";}
    public String getC490() {return  formattedDouble2String(c490);}
    public String getC491() {return  formattedDouble2String(c491);}
    public String getC492() {return  c492!=null?c492:"";}
    public String getC496() {return  formattedDouble2String(c496);}
    public String getC497() {return  formattedDouble2String(c497);}
    public String getC498() {return  formattedDouble2String(c498);}
    public String getC499() {return  formattedDouble2String(c499);}
    public String getC500() {return  formattedDouble2String(c500);}
    public String getC501() {return  formattedDouble2String(c501);}


    public void setC481(Double c481) {
        this.c481 = c481;
    }

    public void setC482(Double c482) {
        this.c482 = c482;
    }

    public void setC483(Double c483) {
        this.c483 = c483;
    }

    public void setC484(String c484) {
        this.c484 = c484;
    }

    public void setC485(Double c485) {
        this.c485 = c485;
    }

    public void setC486(String c486) {
        this.c486 = c486;
    }

    public void setC487(Double c487) {
        this.c487 = c487;
    }

    public void setC488(Double c488) {
        this.c488 = c488;
    }

    public void setC489(int anni, int mesi) {
        this.c489 = anni+"     "+mesi;
    }

    public void setC490(Double c490) {
        this.c490 = c490;
    }

    public void setC491(Double c491) {
        this.c491 = c491;
    }

    public void setC492(String c492) {
        this.c492 = c492;
    }

    public void setC489(String c489) {
        this.c489 = c489;
    }

    public void setC496(Double c496) {
        this.c496 = c496;
    }

    public void setC497(Double c497) {
        this.c497 = c497;
    }

    public void setC498(Double c498) {
        this.c498 = c498;
    }

    public void setC499(Double c499) {
        this.c499 = c499;
    }

    public void setC500(Double c500) {
        this.c500 = c500;
    }

    public void setC501(Double c501) {
        this.c501 = c501;
    }
}
