package com.fideuram.stampe.modello.redditi.d2024.datiFiscali;

import com.fideuram.stampe.modello.redditi.AbstractQBase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 13/01/16
 * Time: 15.40
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Q11 extends AbstractQBase {
    private Double  c361;		//IMPOSTA LORDA
    private Double  c362;		//DETRAZIONI CARICHI FAM
    private Double  c363;		//DETRAZIONI FAM NUM
    private Double  c364;		//CREDITO PER FAM NUM
    private Double  c365;		//CREDITO NON RIC PER FAM NUM
    private Double  c366;		//CREDITO PER FAM NUM RECUP
    private Double  c367;//VP
    private Double  c368;//VP
    private Double  c369;
    private Double  c370;
    private Double  c371;
    private Double  c372;
    private Double  c373;
    private Double  c374;
    //GIO:::
    private String  c375;		//2021 IMPOSTA NETTA
    private String  c376;		//CREDITO DI IMPOSTA
    private Double  c377;		//COD STATO ESTERO
//    private Double  c378;		//2020 Imposta estera definitiva
//    private String  c378;		//2021 Anno di percezione reddito estero

    private String  c390;		//2023 CODICE TRATTAMENTO
    
	private String  c391;		//TRATTAMENTO EROGATO
    private Double  c392;		//TRATTAMENTO NON EROGATO
    private Double  c393;
    private Double  c394;
    private String  c395;
    private Double  c396;
    private Double  c397;
    private String  c399;
    
    /////GIO::: 2021 - TRATTAMENTO INTEGRATIVO
    private String c400;//Nx
    private Double c401;//VP
    private Double c402;//VP
    

    public String getC361() {return  formattedDouble2String(c361);}
    public String getC362() {return  formattedDouble2String(c362);}
    public String getC363() {return  formattedDouble2String(c363);}
    public String getC364() {return  formattedDouble2String(c364);}
    public String getC365() {return  formattedDouble2String(c365);}
    public String getC366() {return  formattedDouble2String(c366);}
    public String getC367() {return  formattedDouble2String(c367);}//VP
    public String getC368() {return  formattedDouble2String(c368);}//VP
    public String getC369() {return  formattedDouble2String(c369);}
    public String getC370() {return  formattedDouble2String(c370);}
    public String getC371() {return  formattedDouble2String(c371);}
    public String getC372() {return  formattedDouble2String(c372);}
    public String getC373() {return  formattedDouble2String(c373);}
    public String getC374() {return  formattedDouble2String(c374);}
    public String getC375() {return  c375!=null?c375:"";}
    public String getC376() {return  c376!=null?c376:"";}
    public String getC377() {return  formattedDouble2String(c377);}
    //public String getC378() {return  formattedDouble2String(c378);}//2020 - Imposta estera definitiva
    public String getC391() {return  c391!=null?c391:"";}
    public String getC392() {return  formattedDouble2String(c392);}
    public String getC393() {return  formattedDouble2String(c393);}
    public String getC394() {return  formattedDouble2String(c394);}
    public String getC395() {return   c395!=null?c395:"";}
    public String getC396() {return  formattedDouble2String(c396);}
    public String getC397() {return  formattedDouble2String(c397);}
    public String getC399() {return   c399!=null?c399:"";}
    
	//GIO::: 2021 28/02/2021 - TRATTAMENTO INTEGRATIVO
    public String getC400() {return c400!=null?c400:"";}
	public String getC401() {return  formattedDouble2String(c401);}
	public String getC402() {return  formattedDouble2String(c402);}
	//GIO::: 2021 28/02/2021 - Anno di percezione reddito estero
	//public String getC378() {return  c378!=null?c378:"";}
	
	//GIO::: 2023 - CODICE TRATTAMENTO
	 public String getC390() {
			return c390;
		}

    public void setC361(Double c361) {
        this.c361 = c361;
    }

    public void setC362(Double c362) {
        this.c362 = c362;
    }

    public void setC363(Double c363) {
        this.c363 = c363;
    }

    public void setC364(Double c364) {
        this.c364 = c364;
    }

    public void setC365(Double c365) {
        this.c365 = c365;
    }

    public void setC366(Double c366) {
        this.c366 = c366;
    }

    public void setC367(Double c367) {
        this.c367 = c367;
    }

    public void setC368(Double c368) {
        this.c368 = c368;
    }

    public void setC369(Double c369) {
        this.c369 = c369;
    }

    public void setC370(Double c370) {
        this.c370 = c370;
    }

    public void setC371(Double c371) {
        this.c371 = c371;
    }

    public void setC372(Double c372) {
        this.c372 = c372;
    }

    public void setC373(Double c373) {
        this.c373 = c373;
    }

    public void setC374(Double c374) {
        this.c374 = c374;
    }

    public void setC375(String c375) {
        this.c375 = c375;
    }

    public void setC376(String c376) {
        this.c376 = c376;
    }

    public void setC377(Double c377) {
        this.c377 = c377;
    }
    //GIO::: 2021 - 
//	public void getC378(String c378) {
//		this.c378 = c378;
//	}

//    public void setC378(Double c378) {//2020 - Imposta estera definitiva
//        this.c378 = c378;
//    }

    public void setC391(String c391) {
        this.c391 = c391;
    }

    public void setC392(Double c392) {
        this.c392 = c392;
    }

    public void setC393(Double c393) {
        this.c393 = c393;
    }

    public void setC394(Double c394) {
        this.c394 = c394;
    }

    public void setC395(String c395) {
        this.c395 = c395;
    }

    public void setC396(Double c396) {
        this.c396 = c396;
    }

    public void setC397(Double c397) {
        this.c397 = c397;
    }

    public void setC399(String c399) {
        this.c399 = c399;
    }
    
    //GIO::: 2021 28/02/2021 - TRATTAMENTO INTEGRATIVO
	public void setC400(String c400) {
		this.c400 = c400;
	}
	 public void setC401(Double c401) {
	        this.c401 = c401;
	    }
	 public void setC402(Double c402) {
	        this.c402 = c402;
	    }
	//GIO::: 2021 28/02/2021 - Anno di percezione reddito estero
//	public void setC378(String c378) {
//		this.c378 = c378;
//	}

		public void setC390(String c390) {
			this.c390 = c390;
		}
}
