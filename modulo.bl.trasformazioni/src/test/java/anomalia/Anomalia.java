package anomalia;

import com.fideuram.config.CrmProperties;
import com.fideuram.exception.TrasformazioneException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.factory.PdfFactory;
import com.fideuram.jaxb.Converter;
import com.fideuram.modello.PolizzaTrasformabile;
import com.fideuram.pdfconverter.ConverterException;
import com.fideuram.processo.FacadeTrasformazioni;
import com.fideuram.utils.Streamer;
import mock.From35007PU2FvInsieme;

import javax.xml.bind.JAXBException;

/**
 * User: V801068
 * Date: 12/06/15
 * Time: 12.05
 */
public class Anomalia {

    public static void main(String args[]) throws Exception {
        FacadeTrasformazioni facadeTrasformazioni = new FacadeTrasformazioni();
        PolizzaTrasformabile anomalia = (PolizzaTrasformabile) Converter.xml2Object(new PolizzaTrasformabile(), xml3());
        Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(anomalia, 801)), CrmProperties.getProperty("crm.services.temp.path"), "Anomalia.pdf");

    }

    public static String xml3(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<polizzaTrasformabile>\n" +
                " <canale>0</canale>\n" +
                " <polizza>\n" +
                " <numero>7730753</numero>\n" +
                " <nomeCommercialeProdotto>Financial Age Protection 2</nomeCommercialeProdotto>\n" +
                " <tipoPremio>A</tipoPremio>\n" +
                " <privateBanker>\n" +
                " <cognome>BRUNETTI BALDI</cognome>\n" +
                " <nome>GIUSEPPE</nome>\n" +
                " <rete>BFI</rete>\n" +
                " </privateBanker>\n" +
                " <contraente>\n" +
                " <cognome>TIRANTELLO</cognome>\n" +
                " <nome>MASSIMO</nome>\n" +
                " </contraente>\n" +
                " <assicurato>\n" +
                " <cognome>TIRANTELLO</cognome>\n" +
                " <nome>MASSIMO</nome>\n" +
                " <livello>0</livello>\n" +
                " </assicurato>\n" +
                " </polizza>\n" +
                " <nomeCommercialeProdottoDestinazione>Fideuram Vita Insieme Premium</nomeCommercialeProdottoDestinazione>\n" +
                " <decorrenza>21/11/2005</decorrenza>\n" +
                " <scadenza>31/12/2020</scadenza>\n" +
                " <durata>15 anni e 1 mesi</durata>\n" +
                " <dataProposta>19/07/2016</dataProposta>\n" +
                " <origine>\n" +
                " <codiceDestinazionene>803</codiceDestinazionene>\n" +
                " <descrizioneProdottoOrigine>Assicurazione di Capitale Differito con contro assicurazione a premio unico ricorrente, collegata a Fondi Interni (Unit Linked) </descrizioneProdottoOrigine>\n" +
                " <premi>Premio Unico Ricorrente di importo minimo annuo pari a â‚¬ 1.800, frazionabile in rate semestrali, trimestrali o mensili con possibilitÃ  di Premi Unici Aggiuntivi, di importo minimo pari a â‚¬ 500, alla sottoscrizione del contratto o dopo aver completato il Piano Programmato dei Versamenti.</premi>\n" +
                " <prestazioniSopravvivenza>\n" +
                "\n" +
                "Nel caso in cui al termine del periodo di differimento del contratto non siano stati corrisposti tutti i premi pattuiti, verrÃ  corrisposto il valore di riscatto del contratto.</prestazioniSopravvivenza>\n" +
                " <minimoGarantito0>e siano stati versati i premi pattuiti</minimoGarantito0>\n" +
                " <minimoGarantito>In caso di proroga o anticipazione del termine del periodo di differimento verrÃ  effettuato il ricalcolo dellâ€™importo del capitale minimo garantito che risulterÃ  pari allâ€™importo che si ottiene sommando allâ€™importo trasferito lâ€™ammontare complessivo dei premi programmati ancora da versare al netto dei relativi caricamenti; tale capitale Ã¨ dovuto a condizione che non vengano effettuati riscatti e vengano corrisposti tutti i premi pattuiti.</minimoGarantito>\n" +
                " <tipo>PR</tipo>\n" +
                " <descrizioneTipo>premio unico ricorrente</descrizioneTipo>\n" +
                " <opzioneTroncone>decorrenza del contratto per la quota relativa ai premi unici ricorrenti e alla data di versamento del premio per la quota relativa a ciascun premio aggiuntivo versato. Per lâ€™opzione b1) se la durata del differimento Ã¨ superiore a 20 anni, per i premi corrispondenti alle annualitÃ  di premio successive alla 10Â° e per i premi unici aggiuntivi versati dopo 10 anni dalla decorrenza del contratto verranno utilizzati i coefficienti in vigore al termine del periodo di differimento. In caso di modifica del termine del periodo di differimento verranno utilizzati i coefficienti in vigore alla data di effetto della modifica;</opzioneTroncone>\n" +
                " <opzioneTroncone3>-Â Â in caso di interruzione del pagamento dei premi per un periodo superiore a 24 mesi: alla data di ripresa dei versamenti.</opzioneTroncone3>\n" +
                " <commissioneGest>2</commissioneGest>\n" +
                " <coefficienteRiscatto>0,537</coefficienteRiscatto>\n" +
                " <fondoInterno>F.A.P.</fondoInterno>\n" +
                " <cppG>si</cppG>\n" +
                " <cppH>3.500.000 </cppH>\n" +
                " <cvnG>CPP G = 1,65% </cvnG>\n" +
                " <cvnG>CPP G = 1,35% </cvnG>\n" +
                " <cvnG>CPP G = 0,90% </cvnG>\n" +
                " <cvnG>CPP G = 0,75% </cvnG>\n" +
                " </origine>\n" +
                "</polizzaTrasformabile>";
    }

    public static String xml2(){
        return "<polizzaTrasformabile>\n" +
                " <canale>1</canale>\n" +
                " <polizza>\n" +
                " <numero>124312432</numero>\n" +
                " <nomeCommercialeProdotto>QUALCOSA</nomeCommercialeProdotto>\n" +
                " <tipoPremio>U</tipoPremio>\n" +
                " <privateBanker>\n" +
                " <cognome>Peppiniello</cognome>\n" +
                " <nome>Casatiello</nome>\n" +
                " <rete>SPI</rete>\n" +
                " </privateBanker>\n" +
                " <contraente>\n" +
                " <cognome>Sempronio</cognome>\n" +
                " <nome>Pallo</nome>\n" +
                " </contraente>\n" +
                " <assicurato>\n" +
                " <cognome>Caio</cognome>\n" +
                " <nome>Pinco</nome>\n" +
                " <livello>0</livello>\n" +
                " </assicurato>\n" +
                " </polizza>\n" +
                " <nomeCommercialeProdottoDestinazione>TBD</nomeCommercialeProdottoDestinazione>\n" +
                " <decorrenza>01-01-2012</decorrenza>\n" +
                " <scadenza>01-01-2022</scadenza>\n" +
                " <durata>180</durata>\n" +
                " <dataProposta>11/06/2015</dataProposta>\n" +
                " <origine/>\n" +
                "</polizzaTrasformabile>";
    }

    public static String xml(){
        return "<polizzaTrasformabile>\n" +
                " <canale>0</canale>\n" +
                " <polizza>\n" +
                " <numero>7459008</numero>\n" +
                " <nomeCommercialeProdotto>Fideuram Unit Linked</nomeCommercialeProdotto>\n" +
                " <tipoPremio>A</tipoPremio>\n" +
                " <privateBanker>\n" +
                " <cognome>COCCI</cognome>\n" +
                " <nome>LUISA</nome>\n" +
                " <rete>BFI</rete>\n" +
                " </privateBanker>\n" +
                " <contraente>\n" +
                " <cognome>BENEDETTINI</cognome>\n" +
                " <nome>LUCA</nome>\n" +
                " </contraente>\n" +
                " <assicurato>\n" +
                " <cognome>BENEDETTINI</cognome>\n" +
                " <nome>LUCA</nome>\n" +
                " <livello>0</livello>\n" +
                " </assicurato>\n" +
                " </polizza>\n" +
                " <nomeCommercialeProdottoDestinazione>Fideuram Vita Insieme</nomeCommercialeProdottoDestinazione>\n" +
                " <decorrenza>11/06/1999</decorrenza>\n" +
                " <scadenza>31/12/2025</scadenza>\n" +
                " <durata>26 anni e 6 mesi</durata>\n" +
                " <dataProposta>11/06/2015</dataProposta>\n" +
                " <origine/>\n"+
                "</polizzaTrasformabile>";
    }
}
