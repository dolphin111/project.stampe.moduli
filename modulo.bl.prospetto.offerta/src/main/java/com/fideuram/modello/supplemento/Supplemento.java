package com.fideuram.modello.supplemento;

import com.fideuram.modello.selection.Isin;
import com.fideuram.utils.LoggingUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by
 * User: v801068
 * Date: 11/11/13
 * Time: 10.41
 */
    public class Supplemento {
    private boolean parte1;
    private boolean parte2;
    private boolean parte3;

    private String premessaParte1="";
    private String premessaParte1A="";
    private String premessaParte2="";
    private String premessaParte3="";
    private String premessaParte3b="";
    private String premessaParte3c="";
    private String aggiornamento = "";

    private List<Isin> isinFuoriusciti;
    private List<Isin> isinModificatiParte1;
    private List<Isin> isinModificatiParte2;
    private List<Isin> isinModificatiParte3;
    private String art=""; //riferimento agli Srticoli contrattuali
    private boolean premium = false;
    private boolean isPrivateMix = false;
    	
    


    /**
	 * @return the isPrivateMix
	 */
	public boolean isPrivateMix() {
		return isPrivateMix;
	}

	/**
	 * @param isPrivateMix the isPrivateMix to set
	 */
	public void setPrivateMix(boolean isPrivateMix) {
		this.isPrivateMix = isPrivateMix;
	}

	/**
	 * @return the premessaParte3c
	 */
	public String getPremessaParte3c() {
		return premessaParte3c;
	}

	/**
	 * @param premessaParte3c the premessaParte3c to set
	 */
	public void setPremessaParte3c(String premessaParte3c) {
		this.premessaParte3c = premessaParte3c;
	}

	/**
	 * @return the aggiornamento
	 */
	public String getAggiornamento() {
		return aggiornamento;
	}

	/**
	 * @param aggiornamento the aggiornamento to set
	 */
	public void setAggiornamento(String aggiornamento) {
		this.aggiornamento = aggiornamento;
	}

	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

	/**
     * <br>questo metodo serve a caricare il testo che
     * <br>accompagna e descrive la la parte 1 del supplemento
     * @param premessaParte1
     */
    public void setPremessaParte1(String premessaParte1) {
        this.premessaParte1 = premessaParte1;
    }

    /**
     * <br>questo metodo serve a caricare il testo che
     * <br>accompagna e descrive l'allegato A alla parte 1 del supplemento
     * @param premessaParte1A
     */
    public void setPremessaParte1A(String premessaParte1A) {
        this.premessaParte1A = premessaParte1A;
    }

    /**
     * <br>questo metodo serve a caricare il testo che
     * <br>accompagna e descrive la la parte 2 del supplemento
     * @param premessaParte2
     */
    public void setPremessaParte2(String premessaParte2) {
        this.premessaParte2 = premessaParte2;
    }

    /**
     * <br>questo metodo serve a caricare il testo che
     * <br>accompagna e descrive la  parte 3 del supplemento
     * @param premessaParte3
     */
    public void setPremessaParte3(String premessaParte3) {
        this.premessaParte3 = premessaParte3;
    }


    /**
     * <br>questo metodo serve a caricare il testo che
     * <br>accompagna e descrive la  parte 3 del supplemento
     * @param premessaParte3b
     */
    public void setPremessaParte3b(String premessaParte3b) {
        this.premessaParte3b = premessaParte3b;
    }

    public String getPremessaParte1() {return premessaParte1; }
    public String getPremessaParte1A() {return premessaParte1A!=null?premessaParte1A:"";}
    public String getPremessaParte2() {return premessaParte2;}
    public String getPremessaParte3() {return premessaParte3;}
    public String getPremessaParte3b() {return premessaParte3b;}


    /**
     * Questo metodo configura il sistema per stampare la parte 1 del supplemento
     * @param parte1
     */
    public void setParte1(boolean parte1) {
        this.parte1 = parte1;
    }

   /**
     * Questo metodo configura il sistema per stampare la parte 2 del supplemento
     * @param parte2
     */
    public void setParte2(boolean parte2) {
        this.parte2 = parte2;
    }

    /**
     * Questo metodo configura il sistema per stampare la parte 3 del supplemento
     * @param parte3
     */
    public void setParte3(boolean parte3) {
        this.parte3 = parte3;
    }


    public boolean isParte3() {return parte3;}
    public boolean isParte2() {return parte2;}
    public boolean isParte1() {return parte1;}



    /**
     * <br>Configura la lista degli Isin che vanno segnalati nel suppplemento
     * <br>perchè fuoriusciti dal contratto
     * @param isin
     */
    public void addIsinFuoriusciti(Isin isin) {
        if(null==isinFuoriusciti)
            isinFuoriusciti=new ArrayList<Isin>();
        isinFuoriusciti.add(isin);
    }


    public List<Isin> getIsinFuoriusciti() {
        return isinFuoriusciti;
    }

    /**
     * ritorna ture se ci sono isin fuoriusciti dal contratto
     * @return
     */
    public boolean hasFuoriusciti(){
        boolean _fuoriusciti=false;
        if (null!=getIsinFuoriusciti()&&getIsinFuoriusciti().size()>0)
            _fuoriusciti=true;

        LoggingUtils.debug("hasFuoriusciti() return " + _fuoriusciti);
        return _fuoriusciti;
    }



    /**
     * <br>Configura la lista degli Isin che vanno segnalati nel suppplemento
     * <br>perchè modificati in qualche loro parte
     * @param isinModificatiParte1
     */
    public void setIsinModificatiParte1(List<Isin> isinModificatiParte1) {
        this.isinModificatiParte1 = isinModificatiParte1;
    }

    /**
     * <br>Configura la lista degli Isin che vanno segnalati nel suppplemento
     * <br>perchè modificati in qualche loro parte
     * @param isinModificatiParte2
     */
    public void setIsinModificatiParte2(List<Isin> isinModificatiParte2) {
        this.isinModificatiParte2 = isinModificatiParte2;
    }

    /**
     * <br>Configura la lista degli Isin che vanno segnalati nel suppplemento
     * <br>perchè modificati in qualche loro parte
     * @param isinModificatiParte3
     */
    public void setIsinModificatiParte3(List<Isin> isinModificatiParte3) {
        this.isinModificatiParte3 = isinModificatiParte3;
    }

    public List<Isin> getIsinModificatiParte3() {
        if(null==isinModificatiParte3)
            return new ArrayList<Isin>();
        return isinModificatiParte3;
    }

    public List<Isin> getIsinModificatiParte2() {
        if(null==isinModificatiParte2)
            return new ArrayList<Isin>();
        return isinModificatiParte2;
    }

    public List<Isin> getIsinModificatiParte1() {
        if(null==isinModificatiParte1)
            return new ArrayList<Isin>();
        return isinModificatiParte1;
    }



    /**
     * Restiruisce tru se isinModificatiParte1 non è null e contiene almento un Isin
     */
    public boolean isIsinModificatiParte1(){
        if(null!=isinModificatiParte1&&isinModificatiParte1.size()>0)
            return true;
        return false;
    }


    /**
     * Restiruisce tru se isinModificatiParte2 non è null e contiene almento un Isin
     */
    public boolean isIsinModificatiParte2(){
        if(null!=isinModificatiParte2&&isinModificatiParte2.size()>0)
            return true;
        return false;
    }

    /**
     * Restiruisce tru se isinModificatiParte3 non è null e contiene almento un Isin
     */
    public boolean isIsinModificatiParte3(){
        if(null!=isinModificatiParte3&&isinModificatiParte3.size()>0)
            return true;
        return false;
    }


    public String getArt() {
        //return art!=null?art:"art. 8";
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }
}
