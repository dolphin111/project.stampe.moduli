package com.fideuram.stampe.modello.redditi;

import com.fideuram.stampe.modello.utils.FormattatoreCifre;
import com.fideuram.stampe.modello.utils.FormattatoreDate;

import java.util.Date;

/**
 * User: V801068
 * Date: 26/01/15
 * Time: 11.37
 */
public abstract class AbstractQBase {
    protected String formattedInteger2String(Integer c){
        return c!=null&&c>0?c.toString():"";
    }

    protected String formattedDouble2String(Double c){
        return c!=null&&c>0?FormattatoreCifre.formatImporto(c, ".", ","):"";
    }

    protected String formattedData2String(Date d) {
        return d!=null?FormattatoreDate.formatDate(d, FormattatoreDate.FORMATO_DATA_dd___MM___YYYY):"";
    }

    protected String splitGGMMFromDate(Date c){
        String data=formattedData2String(c);
        return !data.equals("")?data.substring(0,8):"";
    }
}
