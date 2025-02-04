package com.fideuram.stampe.modello.cud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="CUD")
@XmlAccessorType(XmlAccessType.FIELD)
public class CUD {
    private Boolean rettifica;
	private LetteraAccompagnamento letteraAccompagnamento;
	private AnagraficaDatoreLavoro anagraficaDatLav;
	private AnagraficaDipendente anagraficaDip;
	private DatiFiscali datiFiscali;
	private AltriDatiFiscali altriDatiFis;
	private DatiConguagli datiConguagli;
	private SommeIncrementoProduttivita sommeIncrProd;
	private RedditiImponibili redditiImponibili;
	private CompensiAnniPrecedenti compensiAnniPrec;
	private TFR tfr;
	private DatiINPS datiINPS;
	private String annotazioni;
	private String data;

    public Boolean isRettifica() {
        if(null==rettifica)
            return false;
        return rettifica;
    }

    public void setRettifica(Boolean rettifica) {
        this.rettifica = rettifica;
    }

    public LetteraAccompagnamento getLetteraAccompagnamento() {
        if(null==letteraAccompagnamento)
            return new LetteraAccompagnamento();
        return letteraAccompagnamento;
    }

    public void setLetteraAccompagnamento(LetteraAccompagnamento letteraAccompagnamento) {
        this.letteraAccompagnamento = letteraAccompagnamento;
    }

    public String getAnnotazioni() {
		return annotazioni;
	}
	public void setAnnotazioni(String annotazioni) {
		this.annotazioni = annotazioni;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public AnagraficaDatoreLavoro getAnagraficaDatLav() {
		return anagraficaDatLav;
	}
	public void setAnagraficaDatLav(AnagraficaDatoreLavoro anagraficaDatLav) {
		this.anagraficaDatLav = anagraficaDatLav;
	}
	
	public AnagraficaDipendente getAnagraficaDip() {
		return anagraficaDip;
	}
	public void setAnagraficaDip(AnagraficaDipendente anagraficaDip) {
		this.anagraficaDip = anagraficaDip;
	}
	
	public DatiFiscali getDatiFiscali() {
		return datiFiscali;
	}
	public void setDatiFiscali(DatiFiscali datiFiscali) {
		this.datiFiscali = datiFiscali;
	}
	
	public AltriDatiFiscali getAltriDatiFis() {
		return altriDatiFis;
	}
	public void setAltriDatiFis(AltriDatiFiscali altriDatiFis) {
		this.altriDatiFis = altriDatiFis;
	}
	
	public DatiConguagli getDatiConguagli() {
		return datiConguagli;
	}
	public void setDatiConguagli(DatiConguagli datiConguagli) {
		this.datiConguagli = datiConguagli;
	}
	
	public SommeIncrementoProduttivita getSommeIncrProd() {
		return sommeIncrProd;
	}
	public void setSommeIncrProd(SommeIncrementoProduttivita sommeIncrProd) {
		this.sommeIncrProd = sommeIncrProd;
	}
	
	public RedditiImponibili getRedditiImponibili() {
		return redditiImponibili;
	}
	public void setRedditiImponibili(RedditiImponibili redditiImponibili) {
		this.redditiImponibili = redditiImponibili;
	}
	
	public CompensiAnniPrecedenti getCompensiAnniPrec() {
		return compensiAnniPrec;
	}
	public void setCompensiAnniPrec(CompensiAnniPrecedenti compensiAnniPrec) {
		this.compensiAnniPrec = compensiAnniPrec;
	}
	
	public TFR getTfr() {
		return tfr;
	}
	public void setTfr(TFR tfr) {
		this.tfr = tfr;
	}
	
	public DatiINPS getDatiINPS() {
		return datiINPS;
	}
	public void setDatiINPS(DatiINPS datiINPS) {
		this.datiINPS = datiINPS;
	}


}
