import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.stampeservice.controller.ControllerAction;

/**
 * Created by V801068 on 11/04/14.
 */
public class B28_4555 {

    public static void main(String args[]) throws DocGeneratorException {
        new ControllerAction().elaborazioneODT(B28_4555.getMock(),4555);
    }

    public static String getMock(){
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?><polizza desc=\"Risultati Simulazione\" order=\"1\"><id desc=\"Numero Polizza\" order=\"1.1\">7619865</id><dettaglio desc=\"Informazioni Generali Polizza\" order=\"1.2\">\n" +
                "  <datiPolizza order=\"1.2.1\" desc=\"Dati Polizza\">\n" +
                "    <numeroPolizza desc=\"Polizza n.\" order=\"1.2.1.1\">7619865</numeroPolizza>\n" +
                "    <codiceConferimento desc=\"Codice Conferimento\" order=\"1.2.1.2\">63490035006</codiceConferimento>\n" +
                "    <prodotto desc=\"Prodotto\" order=\"1.2.1.3\">35007 - Financial Age Protection</prodotto>\n" +
                "    <tariffa desc=\"Tariffa\" order=\"1.2.1.4\">951 - Capitale differito con controassicurazione a premio unico di tipo Unit Linked</tariffa>\n" +
                "    <stato desc=\"Stato\" order=\"1.2.1.5\">AT</stato>\n" +
                "    <dataEmissione desc=\"Data Emissione\" order=\"1.2.1.6\">2003-03-19</dataEmissione>\n" +
                "    <dataScadenza desc=\"Data Scadenza Polizza\" order=\"1.2.1.7\">2014-12-31</dataScadenza>\n" +
                "    <dataRichiesta desc=\"Data Elaborazione\" order=\"1.2.1.8\">2014-04-10</dataRichiesta>\n" +
                "    <premiVersati desc=\"Premi Versati\" order=\"1.2.1.11\">38.961,00</premiVersati>\n" +
                "    <ramoMinisteriale desc=\"Ramo Ministeriale\" order=\"1.2.1.9\">3</ramoMinisteriale>\n" +
                "    <tipoPrestazione desc=\"TipoPrestazione\" order=\"1.2.1.10\">C</tipoPrestazione>\n" +
                "  </datiPolizza>\n" +
                "  <contraente desc=\"Dati Contraente\" order=\"1.2.2\">\n" +
                "    <nominativo desc=\"Nominativo\" order=\"1.2.2.1\">null null</nominativo>\n" +
                "    <dataNascita desc=\"Data Nascita\" order=\"1.2.2.2\"/>\n" +
                "    <codiceFiscale desc=\"Codice Fiscale\" order=\"1.2.3.3\">07573820581</codiceFiscale>\n" +
                "  </contraente>\n" +
                "  <primoAssicurato desc=\"Dati Primo Assicurato\" order=\"1.2.3\">\n" +
                "    <nominativo desc=\"Nominativo\" order=\"1.2.3.1\">PAOLA D&apos;ANGELO</nominativo>\n" +
                "    <dataNascita desc=\"Data Nascita\" order=\"1.2.3.2\">14/04/1949</dataNascita>\n" +
                "    <codiceFiscale desc=\"Codice Fiscale\" order=\"1.2.3.3\">DNGPLA49D54C933W</codiceFiscale>\n" +
                "  </primoAssicurato>\n" +
                "</dettaglio><valoreRiscattoScadenzaMinGarantito desc=\"Valore di riscatto lordo a scadenza\" order=\"1.3.1.1\">45.650,39</valoreRiscattoScadenzaMinGarantito><quote desc=\"QUOTE AL 07/04/2014\" order=\"1.3.2.1\">4.565,04</quote><ipotesiControvaloreQuoteNav desc=\"Ipotesi di CONTROVALORE AL 07/04/2014\" order=\"1.3.2.2\">46.609,05</ipotesiControvaloreQuoteNav><valoreRiscattoScadenzaNav desc=\"Valore di riscatto lordo a scadenza (*)\" order=\"1.3.2.3\">46.609,05</valoreRiscattoScadenzaNav><premiVersatiNav desc=\"Premi Versati al 07/04/2014\" order=\"1.3.2.4\">38.961,00</premiVersatiNav><dataRiferimentoNav desc=\"Data Riferimento NAV\" order=\"1.3.2.5\">07/04/2014</dataRiferimentoNav><note desc=\"Note\" order=\"1.3.4.1\">(*) Il valore di riscatto a scadenza &#232; stato calcolato in base al valore delle quote presenti in polizza al nav del  07/04/2014Come da Condizioni Contrattuali la Societ&#224; si impegna in caso di sopravvivenza dell&#039;Assicurato al termine del periodo del differimento, a corrispondere un capitale di importo pari al controvalore delle quote dei Fondi interni, accreditate e presenti sul contratto a quella data, determinato sulla base del valore unitario delle quote calcolato al 07/04/2014.</note></polizza>";
    }
}
