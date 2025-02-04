package com.fideuram.stampe.modello.utils;

/**
 * User: v801068
 * Date: 31/10/14
 * Time: 11.14
 */
public class FormattatorePerc extends FormattatoreBase{
    public static String percentualeStandard(Double value, boolean simbolo){
         return value!=null?formatPercentuale(value,".", ",",simbolo):"---";
    }

    /**
     * Se il valure è null restituisce ND
     * @param value
     * @param simbolo
     * @return
     */
    public static String percentualeStandardNDnoZero(Double value, boolean simbolo){
        return value!=null?formatPercentuale(value,".", ",",simbolo):"n.d.";
    }

    private static String formatPercentuale(Double value, String thou_sep, String dec_sep, boolean simbolo) {
        return percentualeNonStandard(value,thou_sep,dec_sep,2,simbolo);
    }

    public static String percentualeNonStandard(Double value, String thou_sep, String dec_sep, int numeroDecimale, boolean simbolo) {
        String perc=format(value, thou_sep, dec_sep, 1, numeroDecimale, numeroDecimale);
        if(simbolo)
            perc=perc+"%";
        return perc;
    }



}
