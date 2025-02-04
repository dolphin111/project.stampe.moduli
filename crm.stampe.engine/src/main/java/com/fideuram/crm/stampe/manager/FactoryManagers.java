package com.fideuram.crm.stampe.manager;

import com.fideuram.crm.stampe.interfacce.IComunicazioneDatiInputManager;

/**
 * Created by
 * User: logan
 * Date: 12/12/11
 * Time: 14.53
 */
public class FactoryManagers {
    public static IComunicazioneDatiInputManager getComunicazioneInputManager(){
        return new ComunicazioneDatiInputManager();
    }
}
