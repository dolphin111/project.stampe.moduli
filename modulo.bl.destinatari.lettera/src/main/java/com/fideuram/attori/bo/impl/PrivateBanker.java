package com.fideuram.attori.bo.impl;


import com.fideuram.attori.bo.IPrivateBanker;

/**
 * Created by
 * User: logan
 * Date: 30/09/11
 * Time: 11.04
 */
public class PrivateBanker extends Persona implements IPrivateBanker {
    protected String reteVendita = "";

    /**
	 * @param reteVendita the reteVendita to set
	 */
	public void setReteVendita(String reteVendita) {
		this.reteVendita = reteVendita;
	}

	/**
	 * @return the reteVendita
	 */
	public String getReteVendita() {
		return reteVendita;
	}

    /* (non-Javadoc)
      * @see java.lang.Object#hashCode()
      */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((dataNascita == null) ? 0 : dataNascita.hashCode());
        result = prime * result
                + ((denominazione == null) ? 0 : denominazione.hashCode());
        result = prime * result
                + ((indirizzo == null) ? 0 : indirizzo.hashCode());
        result = prime * result
                + ((reteVendita == null) ? 0 : reteVendita.hashCode());
        result = prime * result + ((sesso == null) ? 0 : sesso.hashCode());
        result = prime * result + ((titolo == null) ? 0 : titolo.hashCode());
        return result;
    }

    /* (non-Javadoc)
    * @see java.lang.Object#equals(java.lang.Object)
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PrivateBanker other = (PrivateBanker) obj;
        if (dataNascita == null) {
            if (other.dataNascita != null)
                return false;
        } else if (!dataNascita.equals(other.dataNascita))
            return false;
        if (denominazione == null) {
            if (other.denominazione != null)
                return false;
        } else if (!denominazione.equals(other.denominazione))
            return false;
        if (indirizzo == null) {
            if (other.indirizzo != null)
                return false;
        } else if (!indirizzo.equals(other.indirizzo))
            return false;
        if (reteVendita == null) {
            if (other.reteVendita != null)
                return false;
        } else if (!reteVendita.equals(other.reteVendita))
            return false;
        if (sesso == null) {
            if (other.sesso != null)
                return false;
        } else if (!sesso.equals(other.sesso))
            return false;
        if (titolo == null) {
            if (other.titolo != null)
                return false;
        } else if (!titolo.equals(other.titolo))
            return false;
        return true;
    }

}
