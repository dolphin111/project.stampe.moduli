package com.fideuram.stampe.dao;

import com.fideuram.crm.stampe.model.Polizza;

/**
 * Created with
 * User: v801068
 * Date: 21/11/13
 * Time: 7.46
 */
public class ValidatoreRichieste {
    /**
     * <br>Questo metodo restituisce true se lo stato della polizza è valido per richiedere ad
     * <br>Universo le Prestazioni Asicurate
     * @return
     */
    public static boolean validaPolizzaPerPrestaioniAssicurate(Polizza p){
        String stato   = p.getStato().toUpperCase();
        String substato= p.getCodiceSottostato().toUpperCase();
        if(!p.getCodiceGruppo().equalsIgnoreCase("GV")){
            if (stato.equals("AT")){
                if(substato.equals("AF"))
                    return true;
                if(substato.equals("AT"))
                    return true;
                if(substato.equals("PR"))
                    return true;
                if(substato.equals("RD"))
                    return true;
                if(substato.equals("TP"))
                    return true;
                if(substato.equals("GR")){
                    if(p.getRamoMinisteriale().equalsIgnoreCase("1"))
                        return true;
                }
            }
        }
        return false;
    }

    /**
     * <br>Questo metodo restituisce true se lo stato della polizza è valido per richiedere il Riscatto
     * @return
     */
    public static boolean validaPolizzaPerRichiestaRiscatto(Polizza p){
        String codiceGruppo =p.getCodiceGruppo();
        if(codiceGruppo.equalsIgnoreCase("SP"))
            return true;

        return false;
    }

    /**
     * <br>Questo metodo restituisce true se la polizza è stata riscattata con "ECCEDENZA CASO MORTE"
     * <br>NB: CONDIZINONI:
     * <br>La polizza deve essere di RAMO I
     * <br>IL sottostato della polizza deve essere
     * @return
     */
    public static boolean PolizzaRiscattataConEccedenzaCasoMorte(Polizza p){
        if(p.getRamoMinisteriale().equals(1)){
            if(p.getCodiceSottostato().equalsIgnoreCase("RE"));
            return true;
        }
        return false;
    }

    /**
     * <br>Questo metodo restituisce true se la polizza prevede il "CASO MORTE"
     * NB: CONDIZINONI:
     * La polizza deve essere di RAMO I
     * IL sottostato della polizza deve essere
     * @return
     */
    public static boolean PolizzaRiscattaBileConEccedenzaCasoMorte(Polizza p){
        if(p.getRamoMinisteriale().equals(1)){
            if(p.getTipoFormaAssicurazione().equalsIgnoreCase("M"));
            return true;
        }
        return false;
    }
}
