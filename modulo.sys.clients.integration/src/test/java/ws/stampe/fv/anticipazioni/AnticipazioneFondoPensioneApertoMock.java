package ws.stampe.fv.anticipazioni;

/**
 * Created
 * User: logan
 * Date: 05/09/13
 * Time: 12.38
 */
public class AnticipazioneFondoPensioneApertoMock {
    public static String getXml(){
        String s="<?xml version=\"1.0\" encoding=\"UTF-8\"?><polizza>\n" +
                "    <datiTecnici>\n" +
                "        <numeroPolizza>7003841</numeroPolizza>\n" +
                "        <codiceConferimento>00686636276</codiceConferimento>\n" +
                "        <stato>Rendita</stato>\n" +
                "        <sottostato>IN GODIMENTO RENDITA</sottostato>\n" +
                "        <prodotto>\n" +
                "            <codice>36000</codice>\n" +
                "            <descrizione>Piano Pensione Fideuram - Viva</descrizione>\n" +
                "        </prodotto>\n" +
                "        <tariffa>\n" +
                "            <codice>048</codice>\n" +
                "            <descrizione>Rendita vitalizia differita con controassicurazione a premio annuo</descrizione>\n" +
                "        </tariffa>\n" +
                "        <ramoMinisteriale>1</ramoMinisteriale>\n" +
                "        <tipoPrestazione>R</tipoPrestazione>\n" +
                "        <tipoPolizza>A</tipoPolizza>\n" +
                "        <dataEmissione>1984-12-28</dataEmissione>\n" +
                "        <dataScadenza>1999-12-28</dataScadenza>\n" +
                "        <reteVendita>BFI</reteVendita>\n" +
                "    </datiTecnici>\n" +
                "</polizza>";

        return s;
    }
}
