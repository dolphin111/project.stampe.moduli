package com.fideuram.crm.stampe.serviceclient.bi;

import com.fideuram.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Giorgio Desideri
 *
 */
public class CodificaXML {

    private static final Map<String, String> sostituzioni = new HashMap<String, String>();
    static {
        sostituzioni.put("&","&#38;");
        sostituzioni.put("à", "&#224;");
        sostituzioni.put("ì", "&#236;");
        sostituzioni.put("ò", "&#242;");
        sostituzioni.put("ù", "&#249;");
        sostituzioni.put("è", "&#232;");
        sostituzioni.put("é", "&#233;");
        sostituzioni.put("€", "&#128;");
    }

	
	public  static synchronized String replace(String xml){

        for (String k : sostituzioni.keySet()) {
            xml = StringUtils.replaceString(xml, k, sostituzioni.get(k));
        }
	    return xml;
	}
	
}
