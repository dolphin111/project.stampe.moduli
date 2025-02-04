package com.fideuram.modello.selection;

import com.fideuram.costanti.Frasi;

import java.io.Serializable;

/**
 * Created by
 * User: logan
 * Date: 15/06/12
 * Time: 12.21
 */
public class Benchmark implements Serializable {
    private String denominazioneCompleta;
    private String descrizioneBenchmark;
    private String ulterioriInformazioniBenchmark;
    private String volatilitaAnnuaAttesaCompartoClasseQuota = "";
    private String denominazioneSintetica;
    private String codiceBloombergBenchmark;
    private String valutaBenchmark;

    public void setDescrizioneBenchmark(String descrizioneBenchmark) {
		this.descrizioneBenchmark = descrizioneBenchmark;
	}

	public Benchmark(String denominazioneCompleta, String descrizioneBenchmark, String ulterioriInformazioniBenchmark, String volatilita) {

        this.denominazioneCompleta = denominazioneCompleta.trim().equals("")?null:denominazioneCompleta;

        if(null==denominazioneCompleta||denominazioneCompleta.trim().equals("")){
            if((volatilita!=null)&&(!volatilita.trim().equalsIgnoreCase(""))){
                this.volatilitaAnnuaAttesaCompartoClasseQuota = Frasi.getFrase("bk.vol.classe.quota")+" "+volatilita;
            }
        }

        this.descrizioneBenchmark = descrizioneBenchmark;
        setUlterioriInformazioniBenchmark(ulterioriInformazioniBenchmark);

    }

    public void setUlterioriInformazioniBenchmark(String ulterioriInformazioniBenchmark) {
        if(ulterioriInformazioniBenchmark.trim().equals(""))
            return;
        this.ulterioriInformazioniBenchmark = ulterioriInformazioniBenchmark;
    }

    public String getDenominazioneCompleta() {
        //19 Giugno 2014: richiedente Pietro: oggetto Prospetti  tolgo  i 3 trattini
        //20 Giugno 2014: richiedente Pietro: oggetto Sintetico ri-metto i 3 trattini
        //? mi sa che li avevo tolti e non l'ho commentato
        //18 Sett   2014: richiedente Pietro: oggetto Sintetico Supplemento ri-metto i 3 trattini
        return denominazioneCompleta!=null?denominazioneCompleta:"---";
        //return denominazioneCompleta!=null||!denominazioneCompleta.trim().equals("")?denominazioneCompleta:"---";
    }

    /**
     *    Usato nei template ProspettoGenericoFvParteI e  ProspettoGenericoFvSupplemento
     */
    public boolean hasTabellaBenchmarck(){
        return denominazioneCompleta!=null&&!denominazioneCompleta.trim().equals("")?true:false;
    }

    public String getDescrizioneBenchmark() {
        return descrizioneBenchmark;
    }

    public String getUlterioriInformazioniBenchmark() {
        return ulterioriInformazioniBenchmark;
    }

    public String getVolatilitaAnnuaAttesaCompartoClasseQuota() {
        return volatilitaAnnuaAttesaCompartoClasseQuota;
    }

    public String getCodiceBloombergBenchmark() {
        return codiceBloombergBenchmark;
    }

    public void setCodiceBloombergBenchmark(String codiceBloombergBenchmark) {
        this.codiceBloombergBenchmark = codiceBloombergBenchmark;
    }

    public String getValutaBenchmark() {
        return valutaBenchmark;
    }

    public void setValutaBenchmark(String valutaBenchmark) {
        this.valutaBenchmark = valutaBenchmark;
    }

    public String getDenominazioneSintetica() {
        return denominazioneSintetica;
    }

    public void setDenominazioneSintetica(String denominazioneSintetica) {
        this.denominazioneSintetica = denominazioneSintetica;
    }
}
