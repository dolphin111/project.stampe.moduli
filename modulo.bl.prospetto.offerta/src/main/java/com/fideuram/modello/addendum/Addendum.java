package com.fideuram.modello.addendum;

import java.util.ArrayList;
import java.util.List;

import com.fideuram.modello.selection.Isin;
import com.fideuram.utils.LoggingUtils;

public class Addendum {

	private String premessaParte1="";
	private String premessaParte2="";
	private String premessaNotaInformativa1="";
	private String premessaNotaInformativa2="";
	private String premessaNotaInformativa3="";
	private List<Isin> isinFuoriusciti;
	private List<Isin> isinModificatiParte1;
	
	
	
	  /**
	 * @return the premessaNotaInformativa3
	 */
	public String getPremessaNotaInformativa3() {
		return premessaNotaInformativa3;
	}

	/**
	 * @param premessaNotaInformativa3 the premessaNotaInformativa3 to set
	 */
	public void setPremessaNotaInformativa3(String premessaNotaInformativa3) {
		this.premessaNotaInformativa3 = premessaNotaInformativa3;
	}

	/**
	 * @return the premessaNotaInformativa2
	 */
	public String getPremessaNotaInformativa2() {
		return premessaNotaInformativa2;
	}

	/**
	 * @param premessaNotaInformativa2 the premessaNotaInformativa2 to set
	 */
	public void setPremessaNotaInformativa2(String premessaNotaInformativa2) {
		this.premessaNotaInformativa2 = premessaNotaInformativa2;
	}

	/**
	 * @return the premessaNotaInformativa1
	 */
	public String getPremessaNotaInformativa1() {
		return premessaNotaInformativa1;
	}

	/**
	 * @param premessaNotaInformativa1 the premessaNotaInformativa1 to set
	 */
	public void setPremessaNotaInformativa1(String premessaNotaInformativa1) {
		this.premessaNotaInformativa1 = premessaNotaInformativa1;
	}

	/**
	 * @return the premessaParte2
	 */
	public String getPremessaParte2() {
		return premessaParte2;
	}

	/**
	 * @param premessaParte2 the premessaParte2 to set
	 */
	public void setPremessaParte2(String premessaParte2) {
		this.premessaParte2 = premessaParte2;
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
	 * @return the isinFuoriusciti
	 */
	public List<Isin> getIsinFuoriusciti() {
		return isinFuoriusciti;
	}

	/**
	 * @param isinFuoriusciti the isinFuoriusciti to set
	 */
	public void setIsinFuoriusciti(List<Isin> isinFuoriusciti) {
		this.isinFuoriusciti = isinFuoriusciti;
	}

	/**
	 * @return the isinModificatiParte1
	 */
	public List<Isin> getIsinModificatiParte1() {
		return isinModificatiParte1;
	}

	/**
	 * @param isinModificatiParte1 the isinModificatiParte1 to set
	 */
	public void setIsinModificatiParte1(List<Isin> isinModificatiParte1) {
		this.isinModificatiParte1 = isinModificatiParte1;
	}

	/**
	 * @return the premessaParte1
	 */
	public String getPremessaParte1() {
		return premessaParte1;
	}

	/**
	 * @param premessaParte1 the premessaParte1 to set
	 */
	public void setPremessaParte1(String premessaParte1) {
		this.premessaParte1 = premessaParte1;
	}
	
	/**
     * <br>Configura la lista degli Isin che vanno segnalati nel addendum
     * <br>perchè fuoriusciti dal contratto
     * @param isin
     */
    public void addIsinFuoriusciti(Isin isin) {
        if(null==isinFuoriusciti)
            isinFuoriusciti=new ArrayList<Isin>();
        isinFuoriusciti.add(isin);
    }
	
}
