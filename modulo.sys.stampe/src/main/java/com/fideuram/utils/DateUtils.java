package com.fideuram.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.XMLGregorianCalendar;

import com.fideuram.costanti.Costanti;

public abstract class DateUtils {

    public static GregorianCalendar toGregorian(String date, String dateFormat){
        return getGregorio(date,dateFormat);
    }

    private static GregorianCalendar getGregorio(String date,String dateFormat){
        int dd= dateFormat.indexOf('d');
        int MM= dateFormat.indexOf('M');
        int yy= dateFormat.indexOf('y');

        return  new GregorianCalendar(    Integer.parseInt(date.substring(yy,yy+4)),
                Integer.parseInt(date.substring(MM,MM+2))-1,
                Integer.parseInt(date.substring(dd,dd+2)));
    }


    /**
     * <br>Questo metodo fa la diff tra data 1 e data 2
     * <br>e verifica se il risultato è maggiore di un periodo richiesto
     *
     * <br>Requisito specificato da CIA con eMail del 23Ott2013
     * <br>Decorrenza 30/12/2003 scadenza 31/12/2013 durata > 10 anni (rendita certa all’85° anno)
     * <br>Decorrenza 31/12/2003 scadenza 31/12/2013 durata = 10 anni (rendita vitalizia)
     * <br>
     * <br>ad es:
     * <br>vogliamo sapere se il differimento tra due date è maggiore di 10 anni
     * <br>isDateDiffMajorAsTime("01-11-2001","01-11-2011","dd-MM-yyyy",Calendar.YEAR,10);
     * <br>restituisce false
     *
     * @param date1       la data più remota        es: 01-01-2001
     * @param date2       la data meno remota       es: 01-01-2010
     * @param dateFormat  il formato                es: dd-MM-yyyy
     * @param field       l'unità di confronto      es: Calendar.YEAR
     * @param quanto      il valore di confronto    es: 10
     * @return
     */
    public static boolean isDateDiffMajorOfQuanto(String date1, String date2, String dateFormat,
                                                  int field,
                                                  int quanto) throws ParseException {

        GregorianCalendar d1= getGregorio(date1,dateFormat);
        GregorianCalendar d2= getGregorio(date2,dateFormat);

        switch (field){
            case(Calendar.YEAR):
                int anno1= d1.get(Calendar.YEAR);
                int anno2= d2.get(Calendar.YEAR);
                int x=anno2-anno1;
                if(x>quanto)
                    return true;
                else if ((x==quanto)&&(d2.get(Calendar.DAY_OF_YEAR)>d1.get(Calendar.DAY_OF_YEAR))){
                    return true;
                }
                break;
            default:
        }
        return false;
    }




    public static boolean isDateDiffMinorEqOfQuanto(String date1,String date2,String dateFormat,int field,int quanto) throws ParseException {

            GregorianCalendar d1= getGregorio(date1, dateFormat);
            GregorianCalendar d2= getGregorio(date2,dateFormat);

            switch (field) {
                case (Calendar.YEAR):
                    int anno1 = d1.get(Calendar.YEAR);
                    int anno2 = d2.get(Calendar.YEAR);
                    int x = anno2 - anno1;
                    if (x < quanto)
                        return true;
                    else if ((x == quanto) && (d2.get(Calendar.DAY_OF_YEAR) < d1.get(Calendar.DAY_OF_YEAR))) {
                        return true;
                    }
                    break;
                default:
            }
            return false;
    }


	private static final String FORMATO_DATA_CRM = "yyyy-MM-dd";

	/**
	 * Permette di conoscere quanti <i>field</i> ci sono tra una data e l'altra
	 * 
	 * @param date1
	 *            Data di partenza formato testo
	 * @param date2
	 *            Data da sottrarre formato testo
	 * @param dateFormat
	 *            Formato delle due date
	 * @param field
	 *            Tipo di campo<BR>
	 *            Per questo parametro far riferimento alle costanti della
	 *            classe java.util.Calendar<BR>
	 *            I possibili valori ammessi sono:
	 *            <UL>
	 *            <LI>java.util.Calendar.MILLISECOND</LI>
	 *            <LI>java.util.Calendar.SECOND</LI>
	 *            <LI>java.util.Calendar.MINUTE</LI>
	 *            <LI>java.util.Calendar.HOUR</LI>
	 *            <LI>java.util.Calendar.DAY_OF_YEAR</LI>
	 *            </UL>
	 *            Se <i>field</i> non e' uno dei valori sopra elencati sara'
	 *            generata una IllegalArgumentException.
	 * @return Il numero di <i>field</i> compresi tra le due date.<BR>
	 *         Se <i>date1</i> e' maggiore di <i>date2</i> il risultato sara'
	 *         negarivo.
	 */
	public static double dateDiff(String date1, String date2,
			String dateFormat, int field) throws java.text.ParseException {
		Date d1 = getDate(date1, dateFormat);
		Date d2 = getDate(date2, dateFormat);
		return dateDiff(d1, d2, field);
	}

	/**
	 * Permette di conoscere quanti <i>field</i> ci sono tra una data e l'altra
	 * 
	 * @param date1
	 *            Data di partenza
	 * @param date2
	 *            Data da sottrarre
	 * @param field
	 *            Tipo di campo<BR>
	 *            Per questo parametro far riferimento alle costanti della
	 *            classe java.util.Calendar<BR>
	 *            I possibili valori ammessi sono:
	 *            <UL>
	 *            <LI>java.util.Calendar.MILLISECOND</LI>
	 *            <LI>java.util.Calendar.SECOND</LI>
	 *            <LI>java.util.Calendar.MINUTE</LI>
	 *            <LI>java.util.Calendar.HOUR</LI>
	 *            <LI>java.util.Calendar.DAY_OF_YEAR</LI>
	 *            </UL>
	 *            Se <i>field</i> non e' uno dei valori sopra elencati sara'
	 *            generata una IllegalArgumentException.
	 * @return Il numero di <i>field</i> compresi tra le due date.<BR>
	 *         Se <i>date1</i> e' maggiore di <i>date2</i> il risultato sara'
	 *         negarivo.
	 */
	public static double dateDiff(Date date1, Date date2, int field) {
		double diff = date2.getTime() - date1.getTime();
		if (field == Calendar.MILLISECOND)
			return diff;
		diff /= 1000;
		if (field == Calendar.SECOND)
			return diff;
		diff /= 60;
		if (field == Calendar.MINUTE)
			return diff;
		diff /= 60;
		if (field == Calendar.HOUR)
			return diff;
		diff /= 24;
		if (field == Calendar.DAY_OF_YEAR)
			return diff;

		throw new IllegalArgumentException("Parametro non valido");
	}

	public static String formatNow(String strFormato) {
		return formatDate(new Date(), strFormato);
	}

	public static String formatDate(Calendar date, String strFormato) {
		return formatDate(date.getTime(), strFormato);
	}

	public static String formatDate(Date date, String strFormato) {
		SimpleDateFormat sdf = new SimpleDateFormat(strFormato);
		return sdf.format(date);
	}

	public static Date getCrmDate(String strDate)
			throws java.text.ParseException {
		if (strDate != null && strDate.indexOf("T") > -1) {
			strDate = strDate.substring(0, strDate.indexOf("T"));
		}
		SimpleDateFormat fmt = new SimpleDateFormat(FORMATO_DATA_CRM);
		return fmt.parse(strDate);
	}

	public static Date getDate(String strDate, String strFormato)
			throws java.text.ParseException {
		SimpleDateFormat fmt = new SimpleDateFormat(strFormato);
		return fmt.parse(strDate);
	}

	public static Date addYears(Date d, int years) {
		Calendar c = getCalendar(d);
		c.add(Calendar.YEAR, years);
		return c.getTime();
	}

	public static Date addMonths(Date d, int months) {
		Calendar c = getCalendar(d);
		c.add(Calendar.MONTH, months);
		return c.getTime();
	}

	public static Date addDays(Date d, int days) {
		Calendar c = getCalendar(d);
		c.add(Calendar.DAY_OF_YEAR, days);
		return c.getTime();
	}

	public static Calendar getCalendar(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		return c;
	}

	/**
	 * @param data
	 * @param formato
	 * @return
	 */
	public static String formatDate(XMLGregorianCalendar data, String formato) {
		String rv = "";

		if (data != null)
			rv = DateUtils.formatDate(data.toGregorianCalendar(), formato);

		return rv;
	}

	/**
	 * Esegue il parsing della stringa riportante la data, e la trasforma in oggetto
	 * java.util.Date
	 * 
	 * @param data
	 * 			data da trasformare
	 * 
	 * @param formato
	 * 			formato della data. Se <code>null</code> viene utilizzato il formato di default
	 * 
	 * @return
	 * 		{@linkplain java.util.Date}
	 */
	public static Date parseDate(String data, String formato) {
		Date _date = null;
		
		try {
			if(formato == null)
				formato = FORMATO_DATA_CRM;
			
			SimpleDateFormat sdf = new SimpleDateFormat(formato);
			_date = sdf.parse(data);
			
		} catch (ParseException e) {
			LoggingUtils.error(e, e);
		}
		
		return _date;
	}
	
	/**
	 * @param d
	 * @return
	 */
	public static String getNullSefeCalendar(XMLGregorianCalendar d) {
		String rv = "";

		if (d != null)
			rv = DateUtils.formatDate(d.toGregorianCalendar(),
					Costanti.FORMATO_DATA);

		return rv;
	}



}
