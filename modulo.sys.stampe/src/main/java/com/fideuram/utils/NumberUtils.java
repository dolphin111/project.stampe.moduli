package com.fideuram.utils;

import com.fideuram.costanti.Costanti;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public abstract class NumberUtils {

	private static final double EURO = 1936.27;

    
	public static String format(double value, String thou_sep, String dec_sep, int maxDecimalDigits) {
    	return format(value, thou_sep, dec_sep, 0, 0, maxDecimalDigits);
    }
    
    public static String formatCurrency(double value, String thou_sep, String dec_sep) {
    	return format(value, thou_sep, dec_sep, 1, 2, 2);
    }
	
    public static String formatQuote(double value, String thou_sep, String dec_sep) {
        return format(value, thou_sep, dec_sep, 1, 3, 3);
    }

    public static String formatImporto(double value, String thou_sep, String dec_sep) {
        return format(value, thou_sep, dec_sep, 1, 2, 2);
    }
	
	public static String formatCoefficiente(double value, String thou_sep, String dec_sep) {
		return format(value, thou_sep, dec_sep, 1, 4, 4);
	}

    public static String formatCoefficienteB(double value, String thou_sep, String dec_sep) {
        return format(value, thou_sep, dec_sep, 1, 4, 6);
    }
	
	public static String formatCoefficienteLiquidazioni(double value, String thou_sep, String dec_sep) {
		return format(value, thou_sep, dec_sep, 1, 6, 6);
	}
	
    private static String format(double value, String thou_sep, String dec_sep, int minIntegerDigits, int minDecimalDigits, int maxDecimalDigits) {

        if (minIntegerDigits < 0)
            throw new IllegalArgumentException("[" + minIntegerDigits + " < 0]");
        if (minDecimalDigits < 0)
            throw new IllegalArgumentException("[" + minDecimalDigits + " < 0]");
        if (maxDecimalDigits < 0)
            throw new IllegalArgumentException("[" + maxDecimalDigits + " < 0]");

        DecimalFormatSymbols s = new DecimalFormatSymbols();
        if (thou_sep != null && thou_sep.length() > 0) {
            s.setGroupingSeparator(thou_sep.trim().charAt(0));
        }
        if (dec_sep != null && dec_sep.length() > 0) {
            s.setDecimalSeparator(dec_sep.trim().charAt(0));
        }
        DecimalFormat f = new DecimalFormat();
        f.setDecimalFormatSymbols(s);
        if (thou_sep == null || thou_sep.length() == 0) {
            f.setGroupingUsed(false);
        }
        f.setMinimumIntegerDigits(minIntegerDigits);
        f.setMaximumIntegerDigits(Integer.MAX_VALUE);
        f.setMinimumFractionDigits(minDecimalDigits);
        f.setMaximumFractionDigits(maxDecimalDigits);
        String formattedNumber = f.format(value);
        return ("-0".equals(formattedNumber)) ? "0" : formattedNumber;
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

    public static double conversioneLireEuro(String lire) {
		double euro = 0;
		
		if(lire != ""){
			try {
				double euroDouble = 0;
				try {
					euroDouble = Double.parseDouble(lire);
				} catch(NumberFormatException nfe){
					LoggingUtils.error(nfe);
				} 
				euro = euroDouble/EURO;
			} catch (Exception e) {
				LoggingUtils.error(e);
			}
		}
		return euro;
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

	
	public static String formatGenericDouble(String doubleString, int fractionDigits, String groupSeparator, String decimalSeparator) {
		double doubleValue = parseDouble(doubleString, groupSeparator, decimalSeparator);
		
		String result = formatDouble(String.valueOf(doubleValue), fractionDigits);
		
		return result;
	}

	/**
	 * @param d
	 * @return
	 */
	public static String getNullSefeCurrency(Double d) {
		String rv = "";

		if (d != null)
			rv = NumberUtils.formatCurrency(d, Costanti.SEPARATORE_MIGLIAIA,
					Costanti.SEPARATORE_DECIMALI);

		return rv;
	}
}
