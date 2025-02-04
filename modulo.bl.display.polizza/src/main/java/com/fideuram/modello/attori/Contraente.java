package com.fideuram.modello.attori;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by
 * User: logan
 * Date: 11/04/13
 * Time: 14.11
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Contraente {
    private Persona personaFisica;
    private Persona personaGiuridica;

    public Persona getPersonaFisica() {
        return personaFisica;
    }

    public void setPersonaFisica(Persona personaFisica) {
        this.personaFisica = personaFisica;
    }

    public Persona getPersonaGiuridica() {
        return personaGiuridica;
    }

    public void setPersonaGiuridica(Persona personaGiuridica) {
        this.personaGiuridica = personaGiuridica;
    }

    public Boolean isPersonaFisica(){
        if(personaFisica!=null)
            return true;
        else
            return false;
    }
}
