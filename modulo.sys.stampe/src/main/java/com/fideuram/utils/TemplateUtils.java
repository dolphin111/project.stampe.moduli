/**
 * 
 */
package com.fideuram.utils;

import java.io.UnsupportedEncodingException;

/**
 * @author kallsu
 *
 */
public class TemplateUtils {

	/**
	 * Prefisso statico dello scenario
	 */
	private static final String scenarioPrefix = "Scenario";
	
	/**
	 * Scenari possibili
	 */
	private static final String[] scenariPossibili = {"A", "B",
		"C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
		"N", "O", "P", "Q", "R", "S", "T", "U", "V", "X", "Y", "Z"};
	
	
	/**
	 * @param original
	 * @return
	 */
	public static byte[] convertTemplate(byte[] original) {
		byte[] result = null;
		
		try {
			String _tmp = new String(original, "ISO-8859-1");
			result = _tmp.getBytes("UTF-8");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * @param numeroDomande
	 * @return
	 */
	public static String getScenario(int numeroDomande) {
		if(numeroDomande == 1)
			return "IPOTESI CONSIDERATE:";
		
		String suffix = scenariPossibili[(numeroDomande-1)];
		
		return scenarioPrefix + suffix;
	}
}
