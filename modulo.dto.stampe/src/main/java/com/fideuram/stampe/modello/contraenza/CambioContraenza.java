package com.fideuram.stampe.modello.contraenza;

import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by V801068 on 09/05/14.
 */
@XmlRootElement(name="CambioContraenza", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class CambioContraenza {

    private Date           dataRichiesta;
    protected boolean      sollecito=false;
    protected CausaleCC    causale;                                 // es: per decesso
    protected Contratto    polizza;
    protected List<String> docIntgrativa;
    protected boolean      passaggioAutomaticoContraenza=false;
    protected boolean      assicuratoMinorenne=false;
    //protected DestinatarioComunicazioneCC destinatarioCC;


    public String getDataRichiesta() {
        if(null==dataRichiesta)
            dataRichiesta=new Date();
        return FormattatoreDate.formatDate(dataRichiesta,FormattatoreDate.FORMATO_DATA_ITALIANA);
    }

    public boolean isSollecito() {
        return sollecito;
    }

    public CausaleCC getCausale() {return causale!=null?causale:new CausaleCC();}

    public DestinatarioComunicazioneCC getDestinatarioCC(){
        return new DestinatarioComunicazioneCC(causale,polizza);
    }

    public Contratto getPolizza() {
        return polizza;
    }

    public List<String> getDocIntgrativa() {
        return docIntgrativa!=null?docIntgrativa:new ArrayList<String>();
    }

    public boolean isPassaggioAutomaticoContraenza() {
        return passaggioAutomaticoContraenza;
    }

    public boolean isAssicuratoMinorenne() {
        return assicuratoMinorenne;
    }

    public void setDataRichiesta(Date dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }

    public void setCausale(CausaleCC causale) {
        this.causale = causale;
    }

    public void setPolizza(Contratto polizza) {
        this.polizza = polizza;
    }

    public void setDocIntgrativa(List<String> docIntgrativa) {
        this.docIntgrativa = docIntgrativa;
    }

    public void addDocIntegrativa(String doc){
        if(null==docIntgrativa)
            docIntgrativa=new ArrayList<String>();
        docIntgrativa.add(doc);
    }

    public void setPassaggioAutomaticoContraenza(boolean passaggioAutomaticoContraenza) {
        this.passaggioAutomaticoContraenza = passaggioAutomaticoContraenza;
    }

    public void setAssicuratoMinorenne(boolean assicuratoMinorenne) {
        this.assicuratoMinorenne = assicuratoMinorenne;
    }

    /**
     * Questo metodo oltre a verificare che ci siano TUTTE le seguenti 3 condizioni:
     *
     *   isAssicuratoMinorenne()==true
     *   isPassaggioAutomaticoContraenza()==false
     *   getCausale==CAMBIO_CONTRAENZA_PER_DECESSO
     *
     *
     * @return
     */
    public boolean hasRestrizioniMinorenne(){
        if(isAssicuratoMinorenne()&&!isPassaggioAutomaticoContraenza()&&getCausale().isDecesso())
             return true;
        return false;
    }
}
