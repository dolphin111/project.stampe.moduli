package com.fideuram.utils;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 19/06/14
 * Time: 17.13
 */
public class SerigrafiaStringhe {



	  public static boolean isNumerico(String munnezza){
	        try {
	        	if(munnezza.startsWith("\u20AC")){
	        		munnezza = munnezza.substring(1).trim();
	        	}
	            String num=munnezza.replace(".","");
	            num=num.replace(",","");
	            Double.parseDouble(num);
	            return true;
	        }catch (Exception e){
	            return false;
	        }
	    }

    public static String getNdOrAppendPercentuale(String munnezza, String appendi){
        if(munnezza.toUpperCase().contains("N.D"))
            return munnezza;
        else
            return munnezza+appendi;
    }

}

