package com.fideuram.stampe.modello.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public abstract class FormattatoreDate {

    public static final String FORMATO_DATA_dd___MM___YYYY     = "dd    MM    yyyy";
	public static final String FORMATO_DATA_ITALIANA           = "dd-MM-yyyy";
    public static final String FORMATO_DATA_ITALIANA_SLASH     = "dd/MM/yyyy";
	public static final String FORMATO_DATA_ESTESA_ITALIANA    = "dd MMMMM yyyy";

    public static final String FORMATO_DATA_ITALIANA_CON_ORA   = "dd-MM-yyyy HH:mm:ss";
	public static final String FORMATO_DATA_ITALIANA_CON_SLASH = "dd/MM/yyyy";




	public static String formatDate(Date date, String strFormato) {
        if(null==date)
            return "---";
		SimpleDateFormat sdf = new SimpleDateFormat(strFormato, Locale.ITALIAN);
		return sdf.format(date);
	}



}
