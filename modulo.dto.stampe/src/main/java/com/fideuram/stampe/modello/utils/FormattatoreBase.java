package com.fideuram.stampe.modello.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * User: v801068
 * Date: 31/10/14
 * Time: 11.16
 */
public class FormattatoreBase {
    protected static String format(double value, String thou_sep, String dec_sep, int minIntegerDigits, int minDecimalDigits, int maxDecimalDigits) {

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
        //DecimalFormat f = (DecimalFormat) DecimalFormat.getCurrencyInstance(Locale.ITALY);
        //DecimalFormat f = (DecimalFormat) DecimalFormat.getCurrencyInstance(Locale.UK);
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
}
