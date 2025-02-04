package com.fideuram.crm.stampe.engine.dataLoader;

import com.fideuram.crm.stampe.engine.modello.bean.Polizza;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.stampe.modello.attori.Assicurato;
import com.fideuram.stampe.modello.attori.Contraente;

import java.util.HashMap;

public class StatoPraticaLoader
{

    public StatoPraticaLoader(){
    }
    
    public HashMap populateStatoPratica(HashMap map)throws DocGeneratorException {
        map = new AnagraficaLoader().recuperaAnagrafica(map);        
        Polizza polizza = (Polizza)map.get("polizza");        
        Contraente contraente = polizza.getContraente();
        Assicurato primoAssicurato = polizza.getPrimoassicurato();
        
        if(contraente.getCodiceFiscale().equalsIgnoreCase(primoAssicurato.getCodiceFiscale()))
        	primoAssicurato.setCodiceFiscale("Contraente");
        
        polizza.setPrimoassicurato(primoAssicurato);        
        map.put("polizza", polizza);
        return map;
    }
}