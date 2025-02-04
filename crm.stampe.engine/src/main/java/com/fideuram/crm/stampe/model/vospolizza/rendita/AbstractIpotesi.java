package com.fideuram.crm.stampe.model.vospolizza.rendita;

import com.fideuram.costanti.Costanti;
import com.fideuram.utils.NumberUtils;

/**
 * User: V801068
 * Date: 10/10/14
 * Time: 14.58
 */
public abstract class AbstractIpotesi {
    protected String numToString(Double valore){
        return valore!=null?NumberUtils.formatCurrency(valore, Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI):"";
    }

    protected String numToString(Double valore, String orValuew){
        return valore!=null?NumberUtils.formatCurrency(valore, Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI):orValuew;
    }
}
