package com.fideuram.modello.polizza;

import com.fideuram.factory.FormatterFactory;
import com.fideuram.modello.RichiestaDocumento;
import com.fideuram.modello.polizza.altridati.AltriDati;
import com.fideuram.modello.polizza.avvisi.StimaScadenza;
import com.fideuram.modello.polizza.contabile.Contabile;
import com.fideuram.modello.polizza.finanziario.Finanziario;
import com.fideuram.modello.polizza.protetta.LineaInvestimento;
import com.fideuram.modello.polizza.variazioni.VariazioniContrattuali;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

/**
 * Created by
 * User: logan
 * Date: 09/04/13
 * Time: 18.44
 */
//@XmlTransient
@XmlRootElement(name="polizza", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Polizza {
    private TipoRichiesta           tipoRichiesta;
    private RichiestaDocumento      richiestaDocumento;
    private Date                    dataElaborazione;
    private DatiTecnici             datiTecnici;
    private FigureContrattuali      figureContrattuali;
    private Prestazioni             prestazioni;
    private Previdenza              previdenza;
    private AltriDati               altriDati;
    private Contabile               contabile;
    private Finanziario             finanziario;
    private Boolean                 trasformabile;
    private StimaScadenza           stimeScadenza;
    private VariazioniContrattuali  variazioniContrattuali;
    private List<LineaInvestimento> dettaglioLinea;

    public boolean hasClasseBonus(){
        if(datiTecnici.getProdotto().getCodice().equals("RB0U1")) //PRODOTTO FV_INSIEME_PREMIUM
            return true;
        if(datiTecnici.getProdotto().getCodice().equals("RB0U2")) //PRODOTTO FV_INSIEME_PREMIUM 4+4
            return true;
        return false;
    }

    public boolean hasRiallocazioneGuidata(){
        switch (datiTecnici.getProdotto().getMacroFamigliaID()){
            case 1:            //MACROFAMIGLIA FV INSIEME
                return true;
            default:
                return false;
        }
    }

    /**
     * questo metodo restituisce true se il datiTecnici.prodotto.tipoRamoLayout.equals(x .or. 1)
     * @return
     */
    public boolean isRamo3orX(){
        String tipo = datiTecnici.getProdotto().getTipoRamoLayout();
        if((tipo.equalsIgnoreCase("X"))||(tipo.equalsIgnoreCase("3")))
                return true;
        return false;
    }

    /**
     * questo metodo restituisce true se il datiTecnici.prodotto.tipoRamoLayout.equals(x .or. 1)
     * @return
     */
    public boolean isRamo3(){
        String tipo = datiTecnici.getProdotto().getTipoRamoLayout();
        if(tipo.equalsIgnoreCase("3"))
            return true;
        return false;
    }

    public boolean hasDettaglioLinea(){

        return dettaglioLinea!=null?true:false;
    }

    public List<LineaInvestimento> getDettaglioLinea() {
        return dettaglioLinea;
    }

    public RichiestaDocumento getRichiestaDocumento() {
        return richiestaDocumento;
    }

    public void setRichiestaDocumento(RichiestaDocumento richiestaDocumento) {
        this.richiestaDocumento = richiestaDocumento;
    }

    public String getDataElaborazione() {
        if(dataElaborazione==null)
            return "";
        return FormatterFactory.getStandardDate(dataElaborazione);
    }

    public DatiTecnici getDatiTecnici() {
        return datiTecnici;
    }

    public void setDatiTecnici(DatiTecnici datiTecnici) {
        this.datiTecnici = datiTecnici;
    }

    public void setFigureContrattuali(FigureContrattuali figureContrattuali) {
        this.figureContrattuali = figureContrattuali;
    }

    public VariazioniContrattuali getVariazioniContrattuali() {
        return variazioniContrattuali;
    }

    public void setVariazioniContrattuali(VariazioniContrattuali variazioniContrattuali) {
        this.variazioniContrattuali = variazioniContrattuali;
    }

    public FigureContrattuali getFigureContrattuali() {
        return figureContrattuali;
    }


    public Prestazioni getPrestazioni() {
        return prestazioni;
    }


    public Previdenza getPrevidenza() {
        return previdenza;
    }

    public AltriDati getAltriDati() {
        return altriDati;
    }

    public Contabile getContabile() {
        return contabile;
    }

    public Finanziario getFinanziario() {
        return finanziario;
    }

    public StimaScadenza getStimeScadenza() {
        return stimeScadenza;
    }

    public String getTrasformabile() {
        if(null==trasformabile)
            return "--";
        else if(trasformabile)
            return "SI";
        else
            return "NO";

    }

    public TipoRichiesta getTipoRichiesta() {
        if(null==tipoRichiesta)
            return new TipoRichiesta();
        return tipoRichiesta;
    }

    public void setTipoRichiesta(TipoRichiesta tipoRichiesta) {
        this.tipoRichiesta = tipoRichiesta;
    }

    @Deprecated
    public boolean isPrevidenza() {
        if(null==previdenza)
            return false;
        else
            return true;
    }


    //usato nel template DatiSinteticiPrevidenza: se lo trova prende la dataRiferimentoNav
    public boolean hasFinanziario() {
        if(null==finanziario)
            return false;
        else
            return true;
    }

}
