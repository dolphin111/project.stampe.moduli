package com.fideuram.decoder;

import com.fideuram.utils.LoggingUtils;
import java.util.Hashtable;

/**
 * User: V801068
 * Date: 02/09/14
 * Time: 15.44
 */
public  class MapperProcessiCrm {
    public static Hashtable tabProcessi;

    public static String ANTICIPAZIONI_PER_SPESE_SANITARIE="4.A";
    public static String ANTICIPAZIONI_PER_ACQUISTO_PRIMA_CASA_DA_COSTEUZIONE_IN_PROPRIO="4.BI";
    public static String ANTICIPAZIONI_PER_ACQUISTO_PRIMA_CASA_DA_COOPERATIVA="4.BC";
    public static String ANTICIPAZIONI_PER_ACQUISTO_PRIMA_CASA_DA_TERZI="4.BT";
    public static String ANTICIPAZIONI_PER_INTERVENTI_DI_RISTRUTTURAZIONE="4.C";
    public static String ANTICIPAZIONI_PER_ESIGENZE_PERSONALI="4.D";
    public static String RISCATTO_PARZIALE_PER_MOBILITA="4.AP";

    //public static String RISCATTO_PARZIALE_PER_SOSPENSIONE_LAVORO="4.B";
    //public static String RISCATTO_PARZIALE_PER_CESSAZIONE_ATTIVITA="4.CP";
    public static String RISCATTO_PARZIALE_PER_SOSPENSIONE_LAVORO_NO_VOL="4.B1";
    public static String RISCATTO_PARZIALE_PER_SOSPENSIONE_LAVORO_VOL="4.B2";
    public static String RISCATTO_PARZIALE_PER_CESSAZIONE_ATTIVITA_VOL="4.C1";
    public static String RISCATTO_PARZIALE_PER_CESSAZIONE_ATTIVITA_NO_VOL="4.C2";

    public static String PENSIONAMENTO="5.A";
    public static String PENSIONAMENTO_ANTICIPAZIONE_PER_INVALIDITA_PERMANENTE="5.B";
    public static String PENSIONAMENTO_ANTICIPAZIONE_PER_CESSAZIONE_ATTIVITA="5.C";
    public static String EROGAZIONE_PRESTAZIONE_PENSIONISTTCA="5.D";

    public static String RISCATTO_TOTALE_PER_INVALIDITA="6.D";
    //public static String RISCATTO_TOTALE_PER_CESSAZIONE_ATTIVITA="6.E";
    public static String RISCATTO_TOTALE_PER_CESSAZIONE_ATTIVITA_VOL="6.E1";
    public static String RISCATTO_TOTALE_PER_CESSAZIONE_ATTIVITA_NO_VOL="6.E2";
    public static String RISCATTO_TOTALE_PER_ALTRE_CAUSE="6.E3";
    public static String RISCATTO_TOTALE_PERDITA_STATUS_LAVORATORE_VOLONTARIO="6.E4";
    public static String RISCATTO_TOTALE_PERDITA_STATUS_LAVORATORE_NON_VOLONTARIO="6.E5";

    public static String _TRASFERIMENTO_OUT_AD_ALTRA_FORMA_PENSIONISTICA="7.A";
    public static String TRASFERIMENTO_VOLONTARIO="7.A";
    public static String TRASFERIMENTO_PER_CAMBIO_ATTIVITA_LAVORATIVA="7.B";
    public static String TRASFERIMENTO_PER_PERDITA_ECONOMICA_FONDO="7.C";
    public static String TRASFERIMENTO_ADERENTE_GIA_PENSIONABILE="7.D";
    public static String SINISTRO="8.A";

    public static String SOLLECITO_POST_PAGAMENTO="9.A";
    





    /**
     *
     * @param codiceProcessoCRM
     * @return
     */
    public static Integer decodeProcess(String codiceProcessoCRM){
        if(tabProcessi==null)
            loadMappaProcessi();
        return (Integer) tabProcessi.get(codiceProcessoCRM);
    }

    public static void loadMappaProcessi(){
        tabProcessi=new Hashtable();
        tabProcessi.put(ANTICIPAZIONI_PER_INTERVENTI_DI_RISTRUTTURAZIONE,1104);
        tabProcessi.put(ANTICIPAZIONI_PER_ACQUISTO_PRIMA_CASA_DA_COSTEUZIONE_IN_PROPRIO,1105);
        tabProcessi.put(ANTICIPAZIONI_PER_ACQUISTO_PRIMA_CASA_DA_COOPERATIVA,1105);
        tabProcessi.put(ANTICIPAZIONI_PER_ACQUISTO_PRIMA_CASA_DA_TERZI,1105);
        tabProcessi.put(ANTICIPAZIONI_PER_SPESE_SANITARIE,1106);
        tabProcessi.put(ANTICIPAZIONI_PER_ESIGENZE_PERSONALI,1107);
        tabProcessi.put(EROGAZIONE_PRESTAZIONE_PENSIONISTTCA,1115);
        tabProcessi.put(PENSIONAMENTO,1115);

        tabProcessi.put(PENSIONAMENTO_ANTICIPAZIONE_PER_INVALIDITA_PERMANENTE,1110);
        tabProcessi.put(PENSIONAMENTO_ANTICIPAZIONE_PER_CESSAZIONE_ATTIVITA,1110);
        tabProcessi.put(RISCATTO_PARZIALE_PER_MOBILITA,1110);
        //tabProcessi.put(RISCATTO_PARZIALE_PER_SOSPENSIONE_LAVORO,1110);
        //tabProcessi.put(RISCATTO_PARZIALE_PER_CESSAZIONE_ATTIVITA,1110);
        tabProcessi.put(RISCATTO_PARZIALE_PER_SOSPENSIONE_LAVORO_NO_VOL,1110);
        tabProcessi.put(RISCATTO_PARZIALE_PER_SOSPENSIONE_LAVORO_VOL,1110);
        tabProcessi.put(RISCATTO_PARZIALE_PER_CESSAZIONE_ATTIVITA_VOL,1110);
        tabProcessi.put(RISCATTO_PARZIALE_PER_CESSAZIONE_ATTIVITA_NO_VOL,1110);
        tabProcessi.put(RISCATTO_TOTALE_PER_INVALIDITA,1110);
        //tabProcessi.put(RISCATTO_TOTALE_PER_CESSAZIONE_ATTIVITA,1110);
        tabProcessi.put(RISCATTO_TOTALE_PER_CESSAZIONE_ATTIVITA_VOL,1110);
        tabProcessi.put(RISCATTO_TOTALE_PER_CESSAZIONE_ATTIVITA_NO_VOL,1110);
        tabProcessi.put(RISCATTO_TOTALE_PER_ALTRE_CAUSE,1110);
        tabProcessi.put(RISCATTO_TOTALE_PERDITA_STATUS_LAVORATORE_VOLONTARIO,1110);
        tabProcessi.put(RISCATTO_TOTALE_PERDITA_STATUS_LAVORATORE_NON_VOLONTARIO,1110);

        tabProcessi.put(TRASFERIMENTO_VOLONTARIO,1118);
        tabProcessi.put(TRASFERIMENTO_PER_CAMBIO_ATTIVITA_LAVORATIVA,1118);
        tabProcessi.put(TRASFERIMENTO_PER_PERDITA_ECONOMICA_FONDO,1118);
        tabProcessi.put(TRASFERIMENTO_ADERENTE_GIA_PENSIONABILE,1118);

        tabProcessi.put(SINISTRO,1119);
        tabProcessi.put(SOLLECITO_POST_PAGAMENTO,1120);
        
    }
}
