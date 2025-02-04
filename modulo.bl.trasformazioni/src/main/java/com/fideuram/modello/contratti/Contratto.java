package com.fideuram.modello.contratti;

import com.fideuram.utils.LoggingUtils;
import com.fideuram.config.CrmProperties;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by
 * User: logan
 * Date: 01/03/13
 * Time: 11.07
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Contratto{
   protected int codiceDestinazionene;
   protected String descrizioneProdottoOrigine;
   protected String premi;
   protected String prestazioniSopravvivenza=""; //i PR aggiungono una frase
   protected String prestazioneDecesso;
   protected String minimoGarantito0="";
   protected String minimoGarantito;
   protected String tipo;
   protected String descrizioneTipo;
   protected String opzioneTroncone;
   protected String opzioneTroncone3="";
   protected String commissioneGest;
   protected String coefficienteRiscatto;
   protected String fondoInterno;


   protected String cppG;
   protected String cppH;
   protected String cvnG[]={"","","",""};
   
   protected String prodotto = "";
   protected String prodottoConTipoPremio = "";

    public Contratto() {
        commissioneGest=getPostilla("commissione.gest.1");
        fondoInterno=getPostilla("fondo.interno.fap");
    }

    //Contratto di destinazione
    public void setCodiceDestinazione(int codiceDestinazionene) {this.codiceDestinazionene = codiceDestinazionene;}
    public int getCodiceDestinazionene() {return codiceDestinazionene;}

    protected void setCVNG(){
        cppG="si";
        cvnG=new String[4];
        cvnG[0]= getPostilla("cvng.1")+new Character((char) 32);
        cvnG[1]= getPostilla("cvng.2")+new Character((char) 32);
        cvnG[2]= getPostilla("cvng.3")+new Character((char) 32);
        cvnG[3]= getPostilla("cvng.4")+new Character((char) 32);
    }

    public String getDescrizioneProdottoOrigine() {return descrizioneProdottoOrigine;}
    public String getPremi() {return premi;}
    public String getPrestazioniSopravvivenza() {return prestazioniSopravvivenza;}
    public String getCppG() {return cppG;}
    public String getCppH() {return cppH;}
    public String[] getCvnG() {return cvnG;}
    public String getPrestazioneDecesso() {return prestazioneDecesso;}
    public String getMinimoGarantito0() {return minimoGarantito0;}
    public String getMinimoGarantito() {return minimoGarantito;}
    public String getTipo() {return tipo;}
    public String getOpzioneTroncone() {return opzioneTroncone;}
    public String getOpzioneTroncone3() {return opzioneTroncone3;}
    public String getDescrizioneTipo() {return descrizioneTipo;}
    public String getCommissioneGest() {return commissioneGest;}
    public String getCoefficienteRiscatto() { return coefficienteRiscatto;}
    public String getFondoInterno() {return fondoInterno;}
    
    public String getProdotto() {return prodotto;}
    public void setProdotto(String prodotto) {this.prodotto = prodotto;}
    public String getProdottoConTipoPremio() {return prodottoConTipoPremio;}
    public void setProdottoConTipoPremio(String prodottoConTipoPremio) {this.prodottoConTipoPremio = prodottoConTipoPremio;}

    private static Properties prop;

    public static String getPostilla(String key)
    {
        if(null==prop){
            setup();
        }
        String p = prop.getProperty(key);
        return p;
    }

    private static void setup()  {
        prop=new Properties();

        String fileFrasi = CrmProperties.getProperty("stampa.origine.trasformate.file");
        try {
            FileInputStream fis = new FileInputStream(fileFrasi);
            InputStreamReader isr = new InputStreamReader(fis, "UTF8");
            prop.load(isr);
        } catch (IOException e) {
            LoggingUtils.debug("errore io <<stampa.origine.trasformate.file>>");
        }
    }


}
