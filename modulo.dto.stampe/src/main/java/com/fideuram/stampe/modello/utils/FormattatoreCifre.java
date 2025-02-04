package com.fideuram.stampe.modello.utils;



import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public abstract class FormattatoreCifre extends FormattatoreBase{

	private static final double EURO = 1936.27;

    
	public static String format(double value, String thou_sep, String dec_sep, int maxDecimalDigits) {
    	return format(value, thou_sep, dec_sep, 0, 0, maxDecimalDigits);
    }
    
    public static String formatQuota(Double value, String thou_sep, String dec_sep) {
        if(null==value)
            return "---";
    	return format(value, thou_sep, dec_sep, 1, 3, 3);
    }
	




    public static String formatImporto(Double value, String thou_sep, String dec_sep) {
        if(null==value)
            return "---";
        return format(value, thou_sep, dec_sep, 1, 2, 2);
    }
	

	


    public static double parseDouble(String value, String thou_sep, String dec_sep) throws NumberFormatException {
        if (value == null || value.trim().length() == 0) {
            throw new NumberFormatException("null String");
        }
        String val = value.trim();
        if (thou_sep != null && thou_sep.length() > 0) {
            String sep = thou_sep.substring(0, 1);
            StringBuffer b = new StringBuffer(val);
            int i;
            while ((i = b.indexOf(sep)) > -1) {
                b.deleteCharAt(i);
            }
            val = b.toString();
        }
        if (dec_sep != null && dec_sep.length() > 0) {
            String sep = dec_sep.substring(0, 1);
            StringBuffer b = new StringBuffer(val);
            int i = -1;
            while ((i = b.indexOf(sep, i + 1)) > -1) {
                b.setCharAt(i, '.');
            }
            val = b.toString();
        }

        return Double.parseDouble(val);

    }



    public static String formatDouble(String  toBeFormatted, int fractionDigits){
		double beFormatted = new Double(toBeFormatted).doubleValue();
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator(',');
		dfs.setGroupingSeparator('.');
		DecimalFormat df = new DecimalFormat();
		df.setDecimalFormatSymbols(dfs);
		df.setMaximumFractionDigits(fractionDigits);
		df.setMinimumFractionDigits(fractionDigits);
		return df.format(beFormatted);
	}

	

}
