package com.fideuram.utils;


/**
 * @author Giorgio Desideri
 *
 */
public abstract class StringUtils {

	/**
	 * Restituisce una stringa ottenuta sostituendo una serie di caratteri con
	 * un'altra serie di caratteri all'interno di una stringa di partenza.
	 * <p>
	 * 
	 * Note: Il parametro <CODE>Old</CODE> viene ricercato all'interno del
	 * parametro <CODE>Stringa</CODE> attraverso un confronto binario.
	 * 
	 * @param Stringa
	 *            Stringa di partenza
	 * @param Old
	 *            Stringa da sostituire
	 * @param New
	 *            Stringa con cui sostituire
	 * 
	 * @return stringa ottenuta dopo la sostituzione
	 * 
	 * @since 1.0
	 */
	public static String replaceString(String Stringa, String Old, String New) {
		return replaceString(Stringa, Old, New, true);
	}

	/**
	 * Restituisce una stringa ottenuta sostituendo una serie di caratteri con
	 * un'altra serie di caratteri all'interno di una stringa di partenza.
	 * 
	 * @param Stringa
	 *            Stringa di partenza
	 * @param Old
	 *            Stringa da sostituire
	 * @param New
	 *            Stringa con cui sostituire
	 * @param cs
	 *            Indica se il parametro Old deve essere ricercato all'interno
	 *            del parametro Stringa attraverso un confronto binario oppure
	 *            no.
	 *            
	 * @return stringa ottenuta dopo la sostituzione
	 * 
	 * @since 1.0
	 */
	public static String replaceString(String Stringa, String Old, String New, boolean cs) {

		int partenza = 0;
		if (Stringa == null || Stringa.equals("") || Old == null
				|| Old.equals(""))
			return "";

		String s1 = Stringa;
		String o1 = Old;
		if (!cs) {
			s1 = s1.toLowerCase();
			o1 = o1.toLowerCase();
		}
		while (s1.indexOf(o1, partenza) > -1) {
			int posizione = s1.indexOf(o1, partenza);
			Stringa = Stringa.substring(0, posizione) + New
					+ Stringa.substring(posizione + Old.length());
			s1 = s1.substring(0, posizione) + New
					+ s1.substring(posizione + o1.length());
			partenza = posizione + New.length();
		}
		return Stringa;
	}

	
	/**
	 * @param pCampo
	 * @return
	 */
	public static String blankString(String pCampo) {
    	if(pCampo != null) {
    		return pCampo;
    	} else {
    		return "";
    	}
	}
	   

}
