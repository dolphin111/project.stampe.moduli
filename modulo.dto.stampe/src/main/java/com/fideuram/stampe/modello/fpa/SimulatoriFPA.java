package com.fideuram.stampe.modello.fpa;

import com.fideuram.stampe.modello.attori.Individuo;
import com.fideuram.stampe.modello.comunicazionecrm.Comunicazione;
import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;
import java.util.List;

/**
 * Created
 * User: V801068
 * Date: 17/07/14
 * Time: 14.53
 */
@XmlRootElement(name="dettaglioCoefficienteRenditaFrazionataPVO", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class SimulatoriFPA {
    
	private Date dataElaborazione;
	private Date dataNavRiferimento;
	private String fondoPensione;
	private String ammontarePosizioneIndividualeMaturata;
	private String prospettoLiquidativo;
	private String numeroPosizione;
	private String aderente;
	private String tipologiaAderente;
	private Date dataPrimaIscrizioneFormePensionisticheComplementari;
	private Date dataAdesioneFondo;
	private String totaleContributiVersatiNettiFondoGenerale;
	private String numeroQuote;
	private String valoreQuota;
	private String controvalore;
	private String controvaloreReale;
	private String controvaloreGarantito;
	private String valoreLordoPrestazionePensionistica100;
	private String valoreLordoPrestazionePensionistica50;
	private DettaglioRendita renditaImmediata100;
	private DettaglioRendita renditaImmediata50;
	private DettaglioRendita renditaGarantita5Anni;
	private DettaglioRendita renditaGarantita10Anni;
	private Boolean riscattabilita100;
	private List<DettaglioComparto> listaComparti;
	private String tabellaDemografica;
	private Integer etaCalcolo;
	private Integer etaCalcoloEffettiva;
	
	public String getValoreQuota() {
		return valoreQuota;
	}
	public void setValoreQuota(String valoreQuota) {
		this.valoreQuota = valoreQuota;
	}
	public String getTabellaDemografica() {
		return tabellaDemografica;
	}
	public void setTabellaDemografica(String tabellaDemografica) {
		this.tabellaDemografica = tabellaDemografica;
	}
	public Date getDataElaborazione() {
		return dataElaborazione;
	}
	public void setDataElaborazione(Date dataElaborazione) {
		this.dataElaborazione = dataElaborazione;
	}
	public Date getDataNavRiferimento() {
		return dataNavRiferimento;
	}
	public void setDataNavRiferimento(Date dataNavRiferimento) {
		this.dataNavRiferimento = dataNavRiferimento;
	}
	public String getFondoPensione() {
		return fondoPensione;
	}
	public void setFondoPensione(String fondoPensione) {
		this.fondoPensione = fondoPensione;
	}
	public String getAmmontarePosizioneIndividualeMaturata() {
		return ammontarePosizioneIndividualeMaturata;
	}
	public void setAmmontarePosizioneIndividualeMaturata(
			String ammontarePosizioneIndividualeMaturata) {
		this.ammontarePosizioneIndividualeMaturata = ammontarePosizioneIndividualeMaturata;
	}
	public String getProspettoLiquidativo() {
		return prospettoLiquidativo;
	}
	public void setProspettoLiquidativo(String prospettoLiquidativo) {
		this.prospettoLiquidativo = prospettoLiquidativo;
	}
	public String getNumeroPosizione() {
		return numeroPosizione;
	}
	public void setNumeroPosizione(String numeroPosizione) {
		this.numeroPosizione = numeroPosizione;
	}
	public String getAderente() {
		return aderente;
	}
	public void setAderente(String aderente) {
		this.aderente = aderente;
	}
	public String getTipologiaAderente() {
		return tipologiaAderente;
	}
	public void setTipologiaAderente(String tipologiaAderente) {
		this.tipologiaAderente = tipologiaAderente;
	}
	public Date getDataPrimaIscrizioneFormePensionisticheComplementari() {
		return dataPrimaIscrizioneFormePensionisticheComplementari;
	}
	public void setDataPrimaIscrizioneFormePensionisticheComplementari(
			Date dataPrimaIscrizioneFormePensionisticheComplementari) {
		this.dataPrimaIscrizioneFormePensionisticheComplementari = dataPrimaIscrizioneFormePensionisticheComplementari;
	}
	public Date getDataAdesioneFondo() {
		return dataAdesioneFondo;
	}
	public void setDataAdesioneFondo(Date dataAdesioneFondo) {
		this.dataAdesioneFondo = dataAdesioneFondo;
	}
	public String getTotaleContributiVersatiNettiFondoGenerale() {
		return totaleContributiVersatiNettiFondoGenerale;
	}
	public void setTotaleContributiVersatiNettiFondoGenerale(
			String totaleContributiVersatiNettiFondoGenerale) {
		this.totaleContributiVersatiNettiFondoGenerale = totaleContributiVersatiNettiFondoGenerale;
	}
	public String getNumeroQuote() {
		return numeroQuote;
	}
	public void setNumeroQuote(String numeroQuote) {
		this.numeroQuote = numeroQuote;
	}
	public String getControvalore() {
		return controvalore;
	}
	public void setControvalore(String controvalore) {
		this.controvalore = controvalore;
	}
	public String getControvaloreReale() {
		return controvaloreReale;
	}
	public void setControvaloreReale(String controvaloreReale) {
		this.controvaloreReale = controvaloreReale;
	}
	public String getControvaloreGarantito() {
		return controvaloreGarantito;
	}
	public void setControvaloreGarantito(String controvaloreGarantito) {
		this.controvaloreGarantito = controvaloreGarantito;
	}
	public String getValoreLordoPrestazionePensionistica100() {
		return valoreLordoPrestazionePensionistica100;
	}
	public void setValoreLordoPrestazionePensionistica100(
			String valoreLordoPrestazionePensionistica100) {
		this.valoreLordoPrestazionePensionistica100 = valoreLordoPrestazionePensionistica100;
	}
	public String getValoreLordoPrestazionePensionistica50() {
		return valoreLordoPrestazionePensionistica50;
	}
	public void setValoreLordoPrestazionePensionistica50(
			String valoreLordoPrestazionePensionistica50) {
		this.valoreLordoPrestazionePensionistica50 = valoreLordoPrestazionePensionistica50;
	}
	public DettaglioRendita getRenditaImmediata100() {
		return renditaImmediata100;
	}
	public void setRenditaImmediata100(DettaglioRendita renditaImmediata100) {
		this.renditaImmediata100 = renditaImmediata100;
	}
	public DettaglioRendita getRenditaImmediata50() {
		return renditaImmediata50;
	}
	public void setRenditaImmediata50(DettaglioRendita renditaImmediata50) {
		this.renditaImmediata50 = renditaImmediata50;
	}
	public DettaglioRendita getRenditaGarantita5Anni() {
		return renditaGarantita5Anni;
	}
	public void setRenditaGarantita5Anni(DettaglioRendita renditaGarantita5Anni) {
		this.renditaGarantita5Anni = renditaGarantita5Anni;
	}
	public DettaglioRendita getRenditaGarantita10Anni() {
		return renditaGarantita10Anni;
	}
	public void setRenditaGarantita10Anni(DettaglioRendita renditaGarantita10Anni) {
		this.renditaGarantita10Anni = renditaGarantita10Anni;
	}
	public Boolean getRiscattabilita100() {
		return riscattabilita100;
	}
	public void setRiscattabilita100(Boolean riscattabilita100) {
		this.riscattabilita100 = riscattabilita100;
	}
	public List<DettaglioComparto> getListaComparti() {
		return listaComparti;
	}
	public void setListaComparti(List<DettaglioComparto> listaComparti) {
		this.listaComparti = listaComparti;
	}
	public Integer getEtaCalcolo() {
		return etaCalcolo;
	}
	public void setEtaCalcolo(Integer etaCalcolo) {
		this.etaCalcolo = etaCalcolo;
	}
	public Integer getEtaCalcoloEffettiva() {
		return etaCalcoloEffettiva;
	}
	public void setEtaCalcoloEffettiva(Integer etaCalcoloEffettiva) {
		this.etaCalcoloEffettiva = etaCalcoloEffettiva;
	}
	
}
