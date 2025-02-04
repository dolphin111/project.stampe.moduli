package com.fideuram.factory;

import com.fideuram.modello.ElementdiFormattazione;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.NumberUtils;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: logan
 * Date: 16/04/13
 * Time: 14.29
 */
public class FormatterFactory {
    public static Date getDate(String data){
        return DateUtils.parseDate(data, ElementdiFormattazione.DATA);
    }

    public static String getStandardDate(Date date){
        return DateUtils.formatDate(date, ElementdiFormattazione.DATA);
    }

    public static String getStandardImporto(Double importo){
        return NumberUtils.formatImporto(importo, ".", ",");
        //return NumberUtils.format(importo, ".", ",", 2);
    }

    public static String getStandardQuote(Double importo){
        return NumberUtils.formatQuote(importo, ".", ",");
    }

    public static String getStandardPercentuale(Double importo){
        return NumberUtils.formatImporto(importo, ".", ",");
    }

    /**
     * questo metodo fornisce formattazione con 4 decimali: 0,0000
     * @param tasso
     * @return
     */
    public static String getStandardTasso(Double tasso){
        return NumberUtils.format(tasso, ".", ",", 4);
    }

}
