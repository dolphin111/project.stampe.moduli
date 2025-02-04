package com.fideuram.crm.stampe.generatori;

import com.fideuram.attori.bo.IPersona;
import com.fideuram.attori.bo.impl.Contraente;
import com.fideuram.attori.bo.impl.PrivateBanker;

/**
 * Created by
 * User: logan
 * Date: 19/12/11
 * Time: 18.22
 */
public class DescrizioniAssemblate {
    public static String getCapolettera(IPersona proponente){
       if(proponente instanceof PrivateBanker){
			return "Private Banker";
	   }else if(proponente instanceof Contraente){
            return "Cliente";
	   }
	   return proponente.getDenominazione();
    }
}
