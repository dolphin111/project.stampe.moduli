package scampoli;

import com.fideuram.config.CrmProperties;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.stampeservice.Stampe;

/**
 * User: V801068
 * Date: 09/10/15
 * Time: 12.16
 */
public class IpotesiOpzioneTest {
    public  static void main(String args[]) throws Exception {
        byte[]   prova  = new Stampe().getOdtFromXml(getXml(),"opzioniRamo3");
        StreamerFactory.saveFile(prova, CrmProperties.getProperty("crm.services.temp.path"), "IpotesiOpzione.odt");
    }
    private static String getXml(){
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<polizza desc=\"Ipotesi di Opzione\">\n" +
                "  <id desc=\"ID Polizza di Riferimento\">7510344</id>\n" +
                "  <dettaglio desc=\"Informazioni Generali Polizza\">\n" +
                "    <datiPolizza desc=\"Dati Polizza\">\n" +
                "      <numeroPolizza desc=\"Polizza n.\">7510344</numeroPolizza>\n" +
                "      <reteVendita desc=\"Rete Vendita\">BFI</reteVendita>\n" +
                "      <codiceConferimento desc=\"Codice Conferimento\">31763135002</codiceConferimento>\n" +
                "      <prodotto desc=\"Prodotto\">35002 - Fideuram Unit Linked</prodotto>\n" +
                "      <tariffa desc=\"Tariffa\">900 - Fideuram Unit Linked</tariffa>\n" +
                "      <stato desc=\"Stato\">AT</stato>\n" +
                "      <dataEmissione desc=\"Data Emissione\">20/12/2000</dataEmissione>\n" +
                "      <dataScadenza desc=\"Data Scadenza Polizza\">31/12/2025</dataScadenza>\n" +
                "      <dataRichiesta desc=\"Data Elaborazione\">09/10/2015</dataRichiesta>\n" +
                "      <premiVersati desc=\"Premi Versati\">70.178,82</premiVersati>\n" +
                "      <ramoMinisteriale desc=\"Ramo Misteriale\">3</ramoMinisteriale>\n" +
                "      <tipoPrestazione desc=\"Tipo Prestazione\">R</tipoPrestazione>\n" +
                "    </datiPolizza>\n" +
                "    <contraente desc=\"Dati Contraente\">\n" +
                "      <nominativo desc=\"Nominativo\">MATTEO BELLI</nominativo>\n" +
                "      <dataNascita desc=\"Data Nascita\">21/01/1974</dataNascita>\n" +
                "      <codiceFiscale desc=\"Codice Fiscale\">BLLMTT74A21F257M</codiceFiscale>\n" +
                "    </contraente>\n" +
                "    <primoAssicurato desc=\"Dati Primo Assicurato\">\n" +
                "      <nominativo desc=\"Nominativo\">MATTEO BELLI</nominativo>\n" +
                "      <dataNascita desc=\"Data Nascita\">21/01/1974</dataNascita>\n" +
                "      <codiceFiscale desc=\"Codice Fiscale\">BLLMTT74A21F257M</codiceFiscale>\n" +
                "    </primoAssicurato>\n" +
                "  </dettaglio>\n" +
                "  <renditaOpzioneFrazionamento desc=\"RENDITA CON OPZIONE DI FRAZIONAMENTO su base annua\">\n" +
                "    <annualePosticipata desc=\"Annuale Posticipata\"></annualePosticipata>\n" +
                "    <semestralePosticipata desc=\"Semestrale Posticipata\">1.701,52</semestralePosticipata>\n" +
                "    <trimestralePosticipata desc=\"Trimestrale Posticipata\"></trimestralePosticipata>\n" +
                "    <mensilePosticipata desc=\"Mensile Posticipata\"></mensilePosticipata>\n" +
                "  </renditaOpzioneFrazionamento>\n" +
                "  <renditaOpzioniCertezze desc=\"RENDITA CON OPZIONE DI CERTEZZA su base annua\">\n" +
                "    <renditaOpzioneCertezza desc=\"5 anni\">\n" +
                "      <annualePosticipata desc=\"Annuale Posticipata\"></annualePosticipata>\n" +
                "      <semestralePosticipata desc=\"Semestrale Posticipata\">1.699,47</semestralePosticipata>\n" +
                "      <trimestralePosticipata desc=\"Trimestrale Posticipata\"></trimestralePosticipata>\n" +
                "      <mensilePosticipata desc=\"Mensile Posticipata\"></mensilePosticipata>\n" +
                "    </renditaOpzioneCertezza>\n" +
                "  </renditaOpzioniCertezze>\n" +
                "  <note desc=\"Note\"/>\n" +
                "  <dataRiferimentoNav desc=\"dataRiferimentoNav\">05/10/2015</dataRiferimentoNav>\n" +
                "</polizza>\n";
    }
}
