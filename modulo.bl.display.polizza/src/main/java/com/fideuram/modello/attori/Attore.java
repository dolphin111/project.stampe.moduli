package com.fideuram.modello.attori;

import javax.xml.bind.annotation.XmlType;

/**
 * Created with
 * User: logan
 * Date: 18/07/13
 * Time: 11.54
 */
@XmlType(name="Attore")
public class Attore {
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
}
