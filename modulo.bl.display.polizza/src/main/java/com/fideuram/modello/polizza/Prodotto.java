package com.fideuram.modello.polizza;

import com.fideuram.factory.FormatterFactory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by
 * User: logan
 * Date: 10/04/13
 * Time: 14.57
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Prodotto {
    private String  codice;
    private String  descrizione;
    private Date    dataValidita;
    private String  tipoRamoLayout="";
    private Integer macroFamigliaID;

    /**
     * Indica la macrofamiglia cui appartiene questo prodotto
     * @return
     */
    public Integer getMacroFamigliaID() {
        return macroFamigliaID;
    }

    /**
     * Indica il codice prodotto. Ad es : RB0U1......
     * @return
     */
    public String getCodice() {
        return codice;
    }


    public String getDescrizione() {
        return descrizione;
    }


    public String getDataValidita() {

             if(null==dataValidita)
                 return "";
             else
                 return FormatterFactory.getStandardDate(dataValidita);
    }

    /**
     * Indica il ramo ministeriale
     * @return
     */
    public String getTipoRamoLayout() {
        return tipoRamoLayout;
    }

    @Override
    public String toString() {
        return codice + " - " + descrizione ;
    }
}
