package com.fideuram.stampe.modello.redditi.d2025.annotazioni;



import javax.xml.bind.ValidationException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801092
 * Date: 21/01/16
 * Time: 11.26
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Annotazioni {
    private String[] annotazioni;

    public Annotazioni() { }

    /**
     * Costruttore da usare nel caso si debbano specificare annotazioni
     * @param annotazioni
     */
    public Annotazioni(String[] annotazioni) throws ValidationException {
        if (annotazioni.length<43)
            throw new ValidationException("Q21 - Character[] c34 --- deve essere di docici elementi non uno di piu' non uno di meno");
        this.annotazioni = annotazioni;
    }

    public String[] getAnnotazioni() {
        return annotazioni;
    }

    public boolean hasAnnotazioni(){
        return annotazioni!=null&&annotazioni.length==43?true:false;
    }

}
