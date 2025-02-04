package com.fideuram.utils;

import java.util.Locale;

/**
 * User: V801068
 * Date: 11/11/14
 * Time: 10.00
 */
public class ContextLocale {

    public static void setDefaultLocale(){
        if(!Locale.getDefault().toString().trim().equals("it_IT")){
            LoggingUtils.info("Loc pre : "+ Locale.getDefault().toString());
            Locale.setDefault(new Locale("it", "IT"));
            LoggingUtils.info("Loc post: "+Locale.getDefault().toString());
        }
    }
}
