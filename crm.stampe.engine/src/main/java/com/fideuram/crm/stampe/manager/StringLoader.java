package com.fideuram.crm.stampe.manager;

import com.fideuram.crm.stampe.interfacce.IStringLoader;

/**
 * Questa classe ha il soloo scopo di caricare le Stringhe o label utilizzate nei diversi template di crm stampe
 * Created by
 * User: logan
 * Date: 28/12/11
 * Time: 14.51
 */
public class StringLoader implements IStringLoader{


    @Override
    public String getLabel(String name) {
        return _temporaryFinder(name);
    }

    /**
     * Da sostituire con un property loader. <br>
     * Preferibilmente il property loader dovrebbe essere invocato direttamante da getLabel()
     * @return
     */
    private String _temporaryFinder(String name){
        if(OPZIONI_R3_PRESTAZIONI_TITOLO_CG.equalsIgnoreCase(name))
            return "PRODOTTO DI CAPITALE PRODOTTO GARANTITO";
        if(OPZIONI_R3_PRESTAZIONI_TITOLO_CNG.equalsIgnoreCase(name))
             return "PRODOTTO DI CAPITALE PRODOTTO NON GARANTITO";
        if(OPZIONI_R3_PRESTAZIONI_TITOLO_R.equalsIgnoreCase(name))
            return "PRODOTTO DI RENDITA";
        if(OPZIONI_R3_PRESTAZIONI_CATENACCIO.equalsIgnoreCase(name))
            return "Prestazioni Calcolate sul minimo garantito ipotizzando il completamento del piano dei versamenti";
        return "";
    }


    public static String OPZIONI_R3_PRESTAZIONI_TITOLO_CG  ="opzioni.r3.prestazioni.titolo.cg";                         //PRESTAZIONI A CG=CAPITALE GARANTITO
    public static String OPZIONI_R3_PRESTAZIONI_TITOLO_CNG ="opzioni.r3.prestazioni.titolo.cng";                        //PRESTAZIONI A CNG=CAPITALE NON_GARANTITO
    public static String OPZIONI_R3_PRESTAZIONI_TITOLO_R   ="opzioni.r3.prestazioni.titolo.r";                          //PRESTAZIONI A R=RENDITA
    public static String OPZIONI_R3_PRESTAZIONI_CATENACCIO ="opzioni.r3.prestazioni.catenaccio";
}
