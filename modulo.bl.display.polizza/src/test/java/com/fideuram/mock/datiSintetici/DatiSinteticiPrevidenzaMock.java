package com.fideuram.mock.datiSintetici;

/**
 * Created by
 * User: logan
 * Date: 10/04/13
 * Time: 19.14
 */
public class DatiSinteticiPrevidenzaMock {
    public static String getXml(){
       String s = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
               "<polizza>\n" +
               "<dataElaborazione>2015-05-06</dataElaborazione>\n" +
               "<datiTecnici>\n" +
               "<numeroPolizza>70019829603</numeroPolizza>\n" +
               "<codiceConferimento>00114590203</codiceConferimento>\n" +
               "<stato>Attiva</stato>\n" +
               "<sottostato>Migrata IP</sottostato>\n" +
               "<prodotto>\n" +
               "<codice>90</codice>\n" +
               "<descrizione>Fondo Pensione Fideuram</descrizione>\n" +
               "<tipoRamoLayout>6</tipoRamoLayout>\n" +
               "<garantito>false</garantito>\n" +
               "<macroFamigliaID>4</macroFamigliaID>\n" +
               "<descrizioneMacroFamiglia>Fondo Pensione</descrizioneMacroFamiglia>\n" +
               "</prodotto>\n" +
               "<tariffa>\n" +
               "<codice>F60</codice>\n" +
               "<descrizione>Previdenza</descrizione>\n" +
               "</tariffa>\n" +
               "<ramoMinisteriale>6</ramoMinisteriale>\n" +
               "<tipoPrestazione>R</tipoPrestazione>\n" +
               "<tipoPolizza>C</tipoPolizza>\n" +
               "<dataEmissione>2014-12-16</dataEmissione>\n" +
               "<dataScadenza>2100-12-31</dataScadenza>\n" +
               "<reteVendita>BFI</reteVendita>\n" +
               "<tipoSistemaProvenienza>4</tipoSistemaProvenienza>\n" +
               "<divisa>EUR</divisa>\n" +
               "<premioDiTariffa>0.0</premioDiTariffa>\n" +
               "<importoRataBaseIniziale>0.0</importoRataBaseIniziale>\n" +
               "<pianoVersamentoIniziale>0.0</pianoVersamentoIniziale>\n" +
               "<durata>0</durata>\n" +
               "</datiTecnici>\n" +
               "<figureContrattuali>\n" +
               "<contraente>\n" +
               "<personaFisica>\n" +
               "<cognome>BOBBA</cognome>\n" +
               "<nome>EDOARDO</nome>\n" +
               "<codicefiscale>BBBDRD84A23B563X</codicefiscale>\n" +
               "<datanascita>1984-01-23</datanascita>\n" +
               "<sesso>M</sesso>\n" +
               "<professione/>\n" +
               "<titolo/>\n" +
               "<vip>true</vip>\n" +
               "<datiSupplementariAnagraficiPrevidenza>\n" +
               "<anzianitaIscrizione>0/4</anzianitaIscrizione>\n" +
               "<codiceIscritto>63109329</codiceIscritto>\n" +
               "<isVecchioIscritto>false</isVecchioIscritto>\n" +
               "<categoriaIscritto/>\n" +
               "</datiSupplementariAnagraficiPrevidenza>\n" +
               "</personaFisica>\n" +
               "</contraente>\n" +
               "<primoAssicurato>\n" +
               "<personaFisica>\n" +
               "<cognome>BOBBA</cognome>\n" +
               "<nome>EDOARDO</nome>\n" +
               "<codicefiscale>BBBDRD84A23B563X</codicefiscale>\n" +
               "<datanascita>1984-01-23</datanascita>\n" +
               "<sesso>M</sesso>\n" +
               "<professione/>\n" +
               "<titolo/>\n" +
               "<vip>true</vip>\n" +
               "</personaFisica>\n" +
               "</primoAssicurato>\n" +
               "<secondoAssicurato/>\n" +
               "<datoreDiLavoro>\n" +
               "<personaGiuridica>\n" +
               "<formaSocietaria>Previdenza</formaSocietaria>\n" +
               "<partitaIva>PV990720000</partitaIva>\n" +
               "<ragioneSociale>-- </ragioneSociale>\n" +
               "</personaGiuridica>\n" +
               "</datoreDiLavoro>\n" +
               "<indirizzoContratto>\n" +
               "<tipoIndirizzo>POSTALE</tipoIndirizzo>\n" +
               "<indirizzo>VIA DEI LIVELLO 41</indirizzo>\n" +
               "<cap>35139</cap>\n" +
               "<comune>PADOVA</comune>\n" +
               "<provincia>PD</provincia>\n" +
               "<regione>VENETO </regione>\n" +
               "<nazione>ITALIA</nazione>\n" +
               "<dataAggiornamento>2014-12-21</dataAggiornamento>\n" +
               "</indirizzoContratto>\n" +
               "<rol>\n" +
               "<codiceStato>1</codiceStato>\n" +
               "<dataAttivazione>2015-03-16</dataAttivazione>\n" +
               "<descrizioneTipoFruitore>Area Clienti</descrizioneTipoFruitore>\n" +
               "</rol>\n" +
               "<banker>\n" +
               "<privateBanker>\n" +
               "<cognome>BOBBA</cognome>\n" +
               "<nome>EDOARDO</nome>\n" +
               "<codicefiscale>BBBDRD84A23B563X</codicefiscale>\n" +
               "<datanascita>1984-01-23</datanascita>\n" +
               "<sesso>M</sesso>\n" +
               "<professione/>\n" +
               "<titolo/>\n" +
               "<vip>true</vip>\n" +
               "</privateBanker>\n" +
               "<agenzia>\n" +
               "<indirizzoFiliale>VLE FELICE CAVALLOTTI, 4</indirizzoFiliale>\n" +
               "<localita>PADOVA</localita>\n" +
               "<cap>35124</cap>\n" +
               "<provincia>PD</provincia>\n" +
               "</agenzia>\n" +
               "<dataInizio>2014-03-06</dataInizio>\n" +
               "<stato>Attivo</stato>\n" +
               "<livello>Private Banker</livello>\n" +
               "<rete>BFI</rete>\n" +
               "<strutturaGerarchica>\n" +
               "<banker>\n" +
               "<id>BBBDRD84A23B563X</id>\n" +
               "<cognome>BOBBA</cognome>\n" +
               "<nome>EDOARDO</nome>\n" +
               "<livello>Private Banker</livello>\n" +
               "<superioreID>VLNTZN69H09H823L</superioreID>\n" +
               "</banker>\n" +
               "<banker>\n" +
               "<id>VLNTZN69H09H823L</id>\n" +
               "<cognome>VALENTE</cognome>\n" +
               "<nome>TIZIANO</nome>\n" +
               "<livello>Superiore Banker</livello>\n" +
               "<superioreID>BSSMRC62L05I531G</superioreID>\n" +
               "</banker>\n" +
               "<banker>\n" +
               "<id>BSSMRC62L05I531G</id>\n" +
               "<cognome>BASSETTO</cognome>\n" +
               "<nome>MARCO</nome>\n" +
               "<livello>Regional Manager</livello>\n" +
               "<superioreID>VNNFLV66C29L407D</superioreID>\n" +
               "</banker>\n" +
               "<banker>\n" +
               "<id>VNNFLV66C29L407D</id>\n" +
               "<cognome>VANIN</cognome>\n" +
               "<nome>FLAVIO</nome>\n" +
               "<livello>Divisional Manager</livello>\n" +
               "<superioreID>RCCGRL56D14L736S</superioreID>\n" +
               "</banker>\n" +
               "<banker>\n" +
               "<id>RCCGRL56D14L736S</id>\n" +
               "<cognome>ROCCATO</cognome>\n" +
               "<nome>GABRIELE</nome>\n" +
               "<livello>Area Manager</livello>\n" +
               "</banker>\n" +
               "</strutturaGerarchica>\n" +
               "</banker>\n" +
               "<isAttivoBeneficiarioVita>true</isAttivoBeneficiarioVita>\n" +
               "<isAttivoBeneficiarioMorte>true</isAttivoBeneficiarioMorte>\n" +
               "<legaleRappresentante/>\n" +
               "</figureContrattuali>\n" +
               "<prestazioni>\n" +
               "<prestazioneGarantitaUltimaRivalutazione>0.0</prestazioneGarantitaUltimaRivalutazione>\n" +
               "<importoBonus>0.0</importoBonus>\n" +
               "<valoreRiscattoScadenzaGarantito>0.0</valoreRiscattoScadenzaGarantito>\n" +
               "<ipotesiValoreRiscattoScadenza>0.0</ipotesiValoreRiscattoScadenza>\n" +
               "<valoreRiscattoAnticipato>0.0</valoreRiscattoAnticipato>\n" +
               "<valorePrestazioniControvalore>0.0</valorePrestazioniControvalore>\n" +
               "<eccedenza>0.0</eccedenza>\n" +
               "<opzioni xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:nil=\"true\"/>\n" +
               "<renditaACLS75Anno>0.0</renditaACLS75Anno>\n" +
               "<renditaACLS80Anno>0.0</renditaACLS80Anno>\n" +
               "<renditaACLS85Anno>0.0</renditaACLS85Anno>\n" +
               "<totalePrestazioniCV>0.0</totalePrestazioniCV>\n" +
               "<capitaleComplementareIncidentePrimoAss>0.0</capitaleComplementareIncidentePrimoAss>\n" +
               "<capitaleComplementareInfortunioPrimoAss>0.0</capitaleComplementareInfortunioPrimoAss>\n" +
               "<capitaleComplementareMalattiaPrimoAss>0.0</capitaleComplementareMalattiaPrimoAss>\n" +
               "<capitaleComplementareDecessoSecondoAss>0.0</capitaleComplementareDecessoSecondoAss>\n" +
               "<prestazioneGarantita>0.0</prestazioneGarantita>\n" +
               "<totalePrestazioniBase>0.0</totalePrestazioniBase>\n" +
               "</prestazioni>\n" +
               "<finanziario>\n" +
               "<quoteTotali>402.432</quoteTotali>\n" +
               "<controvaloreTotale>6634.327644</controvaloreTotale>\n" +
               "<dataRiferimentoNAV>2015-04-30</dataRiferimentoNAV>\n" +
               "<isETF>false</isETF>\n" +
               "<isCustom>false</isCustom>\n" +
               "<ctvCommissioniNegoziazioni>0.0</ctvCommissioniNegoziazioni>\n" +
               "</finanziario>\n" +
               "<contabile>\n" +
               "<totalePremiAnnuiIncassati>6500.0</totalePremiAnnuiIncassati>\n" +
               "<totalePremiDaTrasformazioni>0.0</totalePremiDaTrasformazioni>\n" +
               "<totalePremiAnnuiIncassatiConTrasformate>6500.0</totalePremiAnnuiIncassatiConTrasformate>\n" +
               "<totalePremiAggiuntiviOggi>0.0</totalePremiAggiuntiviOggi>\n" +
               "<sommaPremiResiduiDaVersare>0.0</sommaPremiResiduiDaVersare>\n" +
               "</contabile>\n" +
               "<altriDati>\n" +
               "<vincolo>\n" +
               "<attivo>false</attivo>\n" +
               "</vincolo>\n" +
               "<decumuloCedola>\n" +
               "<attivo>false</attivo>\n" +
               "<dettagli>\n" +
               "<imponibile>0.0</imponibile>\n" +
               "<importoPagato>0.0</importoPagato>\n" +
               "<cvn>0.0</cvn>\n" +
               "<percentuale>0.0</percentuale>\n" +
               "<importoRata>0.0</importoRata>\n" +
               "</dettagli>\n" +
               "</decumuloCedola>\n" +
               "<imponibileCongelamento>0.0</imponibileCongelamento>\n" +
               "<percentualeCaricamentoCPP>0.0</percentualeCaricamentoCPP>\n" +
               "<importoPianoProgrammatoVersamenti>0.0</importoPianoProgrammatoVersamenti>\n" +
               "<detraibilitaFiscale>\n" +
               "<stato>false</stato>\n" +
               "</detraibilitaFiscale>\n" +
               "<polizzaDerivanteDaTrasformazione>false</polizzaDerivanteDaTrasformazione>\n" +
               "<polizzaScudata>false</polizzaScudata>\n" +
               "<impostaBolloMaturata>0.0</impostaBolloMaturata>\n" +
               "<pegno>false</pegno>\n" +
               "<isVariazioneContrattuale>false</isVariazioneContrattuale>\n" +
               "<tipoClasseBonus/>\n" +
               "<isRiallocazioneGuidata>false</isRiallocazioneGuidata>\n" +
               "</altriDati>\n" +
               "<previdenza>\n" +
               "<importoContributi>6410.0</importoContributi>\n" +
               "<importoContributiLordi>6500.0</importoContributiLordi>\n" +
               "<importoAnticipazione>0.0</importoAnticipazione>\n" +
               "<valorePosizioneIndividuale>6634.3276</valorePosizioneIndividuale>\n" +
               "<contributiNonDedotti>0.0</contributiNonDedotti>\n" +
               "<dataIngressoSistemaPrevidenziale>2014-12-16</dataIngressoSistemaPrevidenziale>\n" +
               "<dataAdesioneFondo>2014-12-16</dataAdesioneFondo>\n" +
               "<beneficiarioVita>Aderente</beneficiarioVita>\n" +
               "<movimentiEventiPrevidenza>\n" +
               "<movimentoPrevidenza>\n" +
               "<dataOperazione>2015-05-04</dataOperazione>\n" +
               "<dataQuota>2015-05-04</dataQuota>\n" +
               "<causale>Contributo</causale>\n" +
               "<costi>0.0</costi>\n" +
               "<iscritto>250.0</iscritto>\n" +
               "<datore>0.0</datore>\n" +
               "<tfr>0.0</tfr>\n" +
               "<totale>250.0</totale>\n" +
               "</movimentoPrevidenza>\n" +
               "<movimentoPrevidenza>\n" +
               "<dataOperazione>2015-04-01</dataOperazione>\n" +
               "<dataQuota>2015-04-01</dataQuota>\n" +
               "<causale>Contributo</causale>\n" +
               "<costi>0.0</costi>\n" +
               "<iscritto>250.0</iscritto>\n" +
               "<datore>0.0</datore>\n" +
               "<tfr>0.0</tfr>\n" +
               "<totale>250.0</totale>\n" +
               "</movimentoPrevidenza>\n" +
               "<movimentoPrevidenza>\n" +
               "<dataOperazione>2015-03-02</dataOperazione>\n" +
               "<dataQuota>2015-03-02</dataQuota>\n" +
               "<causale>Contributo</causale>\n" +
               "<costi>0.0</costi>\n" +
               "<iscritto>750.0</iscritto>\n" +
               "<datore>0.0</datore>\n" +
               "<tfr>0.0</tfr>\n" +
               "<totale>750.0</totale>\n" +
               "</movimentoPrevidenza>\n" +
               "<movimentoPrevidenza>\n" +
               "<dataOperazione>2015-02-02</dataOperazione>\n" +
               "<dataQuota>2015-02-02</dataQuota>\n" +
               "<causale>Contributo</causale>\n" +
               "<costi>20.0</costi>\n" +
               "<iscritto>250.0</iscritto>\n" +
               "<datore>0.0</datore>\n" +
               "<tfr>0.0</tfr>\n" +
               "<totale>250.0</totale>\n" +
               "</movimentoPrevidenza>\n" +
               "<movimentoPrevidenza>\n" +
               "<dataOperazione>2014-12-18</dataOperazione>\n" +
               "<dataQuota>2014-12-18</dataQuota>\n" +
               "<causale>Contributo</causale>\n" +
               "<costi>70.0</costi>\n" +
               "<iscritto>5000.0</iscritto>\n" +
               "<datore>0.0</datore>\n" +
               "<tfr>0.0</tfr>\n" +
               "<totale>5000.0</totale>\n" +
               "</movimentoPrevidenza>\n" +
               "</movimentiEventiPrevidenza>\n" +
               "<riepilogoPrevidenza>\n" +
               "<riepilogo>\n" +
               "<idComparto>30073</idComparto>\n" +
               "<descrizioneComparto>FIDEURAM VALORE</descrizioneComparto>\n" +
               "<importoContributi>3205.0</importoContributi>\n" +
               "<importoAnticipazione>0.0</importoAnticipazione>\n" +
               "<importoSwitch>0.0</importoSwitch>\n" +
               "<numeroQuote>203.234</numeroQuote>\n" +
               "<valoreQuota>16.316</valoreQuota>\n" +
               "<valorePosizioneIndividuale>3315.9659</valorePosizioneIndividuale>\n" +
               "</riepilogo>\n" +
               "<riepilogo>\n" +
               "<idComparto>30072</idComparto>\n" +
               "<descrizioneComparto>FIDEURAM EQUILIBRIO</descrizioneComparto>\n" +
               "<importoContributi>1602.5</importoContributi>\n" +
               "<importoAnticipazione>0.0</importoAnticipazione>\n" +
               "<importoSwitch>0.0</importoSwitch>\n" +
               "<numeroQuote>87.518</numeroQuote>\n" +
               "<valoreQuota>18.83</valoreQuota>\n" +
               "<valorePosizioneIndividuale>1647.9639</valorePosizioneIndividuale>\n" +
               "</riepilogo>\n" +
               "<riepilogo>\n" +
               "<idComparto>30074</idComparto>\n" +
               "<descrizioneComparto>FIDEURAM CRESCITA</descrizioneComparto>\n" +
               "<importoContributi>1602.5</importoContributi>\n" +
               "<importoAnticipazione>0.0</importoAnticipazione>\n" +
               "<importoSwitch>0.0</importoSwitch>\n" +
               "<numeroQuote>111.68</numeroQuote>\n" +
               "<valoreQuota>14.957</valoreQuota>\n" +
               "<valorePosizioneIndividuale>1670.3978</valorePosizioneIndividuale>\n" +
               "</riepilogo>\n" +
               "</riepilogoPrevidenza>\n" +
               "<beneficiariMorte>\n" +
               "    <beneficiarioMorte> PATRIZIA LONGONI</beneficiarioMorte>\n" +
               "    <beneficiarioMorte>CAROLA BOBBA </beneficiarioMorte>\n" +
               "    <beneficiarioMorte>ELENA SORAVIA</beneficiarioMorte>\n" +
               "</beneficiariMorte>\n" +
               "</previdenza>\n" +
               "<trasformabile>false</trasformabile>\n" +
               "<trasformazioneDiFatto>false</trasformazioneDiFatto>\n" +
               "<isOperazioneFinanzInVolo>false</isOperazioneFinanzInVolo>\n" +
               "</polizza>\n"  ;

        return s;
    }


    public static String getXmlAnomalia(){
        String s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><polizza>\n" +
                " <dataElaborazione>2016-11-07</dataElaborazione>\n" +
                " <datiTecnici>\n" +
                " <numeroPolizza>70005429512</numeroPolizza>\n" +
                " <codiceConferimento>066897RS012</codiceConferimento>\n" +
                " <stato>Attiva</stato>\n" +
                " <sottostato>ATTIVA</sottostato>\n" +
                " <prodotto>\n" +
                " <codice>RS0U1</codice>\n" +
                " <descrizione>Fideuram Vita Insieme</descrizione>\n" +
                " <tipoRamoLayout>3</tipoRamoLayout>\n" +
                " <garantito>false</garantito>\n" +
                " <macroFamigliaID>1</macroFamigliaID>\n" +
                " <descrizioneMacroFamiglia>Fideuram Vita Insieme</descrizioneMacroFamiglia>\n" +
                " </prodotto>\n" +
                " <tariffa>\n" +
                " <codice>930</codice>\n" +
                " <descrizione>Fideuram Vita Insieme</descrizione>\n" +
                " </tariffa>\n" +
                " <ramoMinisteriale>3</ramoMinisteriale>\n" +
                " <tipoPrestazione>C</tipoPrestazione>\n" +
                " <tipoPolizza>A</tipoPolizza>\n" +
                " <dataEmissione>2012-03-21</dataEmissione>\n" +
                " <dataScadenza>2050-12-31</dataScadenza>\n" +
                " <reteVendita>BFI</reteVendita>\n" +
                " <tipoSistemaProvenienza>1</tipoSistemaProvenienza>\n" +
                " <divisa>EUR</divisa>\n" +
                " <premioDiTariffa>0.0</premioDiTariffa>\n" +
                " <importoRataBaseIniziale>500.0</importoRataBaseIniziale>\n" +
                " <pianoVersamentoIniziale>500.0</pianoVersamentoIniziale>\n" +
                " <durata>38</durata>\n" +
                " </datiTecnici>\n" +
                " <figureContrattuali>\n" +
                " <contraente>\n" +
                " <personaFisica>\n" +
                " <cognome>IACOZZI</cognome>\n" +
                " <nome>SIMONA</nome>\n" +
                " <codicefiscale>CZZSMN77T55G141M</codicefiscale>\n" +
                " <datanascita>1977-12-15</datanascita>\n" +
                " <sesso>F</sesso>\n" +
                " <vip>false</vip>\n" +
                " </personaFisica>\n" +
                " </contraente>\n" +
                " <primoAssicurato>\n" +
                " <personaFisica>\n" +
                " <cognome>IACOZZI</cognome>\n" +
                " <nome>SIMONA</nome>\n" +
                " <codicefiscale>CZZSMN77T55G141M</codicefiscale>\n" +
                " <datanascita>1977-12-15</datanascita>\n" +
                " <sesso>F</sesso>\n" +
                " <vip>false</vip>\n" +
                " </personaFisica>\n" +
                " </primoAssicurato>\n" +
                " <secondoAssicurato/>\n" +
                " <datoreDiLavoro/>\n" +
                " <beneficiarioMorte>Gli eredi testamentari dell'Assicurato, o in mancanza gli eredi legittimi, in parti uguali</beneficiarioMorte>\n" +
                " <indirizzoContratto>\n" +
                " <tipoIndirizzo>POSTALE</tipoIndirizzo>\n" +
                " <indirizzo>CONT MORTELLA, 50</indirizzo>\n" +
                " <cap>66030</cap>\n" +
                " <comune>POGGIOFIORITO</comune>\n" +
                " <provincia>CH</provincia>\n" +
                " <regione>Abruzzo</regione>\n" +
                " <nazione>Italia </nazione>\n" +
                " <dataAggiornamento>2012-03-21</dataAggiornamento>\n" +
                " </indirizzoContratto>\n" +
                " <rol>\n" +
                " <codiceStato>1</codiceStato>\n" +
                " <dataAttivazione>2013-08-16</dataAttivazione>\n" +
                " <descrizioneTipoFruitore>Banca Fideuram</descrizioneTipoFruitore>\n" +
                " </rol>\n" +
                " <banker>\n" +
                " <privateBanker>\n" +
                " <cognome>IACOZZI</cognome>\n" +
                " <nome>MAURIZIO</nome>\n" +
                " <codicefiscale>CZZMRZ63L12G760A</codicefiscale>\n" +
                " <datanascita>1963-07-12</datanascita>\n" +
                " <sesso>M</sesso>\n" +
                " <professione>LAVORATORI AUTONOMI E LIBERI PROFESSIONISTI</professione>\n" +
                " <vip>false</vip>\n" +
                " </privateBanker>\n" +
                " <agenzia>\n" +
                " <indirizzoFiliale>VIA VENEZIA 52</indirizzoFiliale>\n" +
                " <localita>PESCARA</localita>\n" +
                " <cap>65121</cap>\n" +
                " <provincia>PE</provincia>\n" +
                " </agenzia>\n" +
                " <dataInizio>1989-04-20</dataInizio>\n" +
                " <stato>Attivo</stato>\n" +
                " <livello>Superiore Banker</livello>\n" +
                " <rete>BFI</rete>\n" +
                " <strutturaGerarchica>\n" +
                " <banker>\n" +
                " <id>CZZMRZ63L12G760A</id>\n" +
                " <cognome>IACOZZI</cognome>\n" +
                " <nome>MAURIZIO</nome>\n" +
                " <livello>Superiore Banker</livello>\n" +
                " <superioreID>LMNNFR58E29F376K</superioreID>\n" +
                " </banker>\n" +
                " <banker>\n" +
                " <id>LMNNFR58E29F376K</id>\n" +
                " <cognome>LAMANNA</cognome>\n" +
                " <nome>ONOFRIO</nome>\n" +
                " <livello>Regional Manager</livello>\n" +
                " <superioreID>MGLGPP64D28B963E</superioreID>\n" +
                " </banker>\n" +
                " <banker>\n" +
                " <id>MGLGPP64D28B963E</id>\n" +
                " <cognome>MAGLIULO</cognome>\n" +
                " <nome>GIUSEPPE</nome>\n" +
                " <livello>Divisional Manager</livello>\n" +
                " <superioreID>PTNGRG54D16F205V</superioreID>\n" +
                " </banker>\n" +
                " <banker>\n" +
                " <id>PTNGRG54D16F205V</id>\n" +
                " <cognome>PIETANESI</cognome>\n" +
                " <nome>GIORGIO</nome>\n" +
                " <livello>Area Manager</livello>\n" +
                " </banker>\n" +
                " </strutturaGerarchica>\n" +
                " </banker>\n" +
                " <isAttivoBeneficiarioVita>true</isAttivoBeneficiarioVita>\n" +
                " <isAttivoBeneficiarioMorte>true</isAttivoBeneficiarioMorte>\n" +
                " <legaleRappresentante/>\n" +
                " </figureContrattuali>\n" +
                " <prestazioni>\n" +
                " <prestazioneGarantitaUltimaRivalutazione>0.0</prestazioneGarantitaUltimaRivalutazione>\n" +
                " <importoBonus>0.0</importoBonus>\n" +
                " <valoreRiscattoScadenzaGarantito>0.0</valoreRiscattoScadenzaGarantito>\n" +
                " <ipotesiValoreRiscattoScadenza>0.0</ipotesiValoreRiscattoScadenza>\n" +
                " <valoreRiscattoAnticipato>0.0</valoreRiscattoAnticipato>\n" +
                " <valorePrestazioniControvalore>0.0</valorePrestazioniControvalore>\n" +
                " <eccedenza>0.0</eccedenza>\n" +
                " <opzioni xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:nil=\"true\"/>\n" +
                " <renditaACLS75Anno>0.0</renditaACLS75Anno>\n" +
                " <renditaACLS80Anno>0.0</renditaACLS80Anno>\n" +
                " <renditaACLS85Anno>0.0</renditaACLS85Anno>\n" +
                " <totalePrestazioniCV>0.0</totalePrestazioniCV>\n" +
                " <capitaleComplementareIncidentePrimoAss>0.0</capitaleComplementareIncidentePrimoAss>\n" +
                " <capitaleComplementareInfortunioPrimoAss>0.0</capitaleComplementareInfortunioPrimoAss>\n" +
                " <capitaleComplementareMalattiaPrimoAss>0.0</capitaleComplementareMalattiaPrimoAss>\n" +
                " <capitaleComplementareDecessoSecondoAss>0.0</capitaleComplementareDecessoSecondoAss>\n" +
                " <prestazioneGarantita>0.0</prestazioneGarantita>\n" +
                " <totalePrestazioniBase>0.0</totalePrestazioniBase>\n" +
                " </prestazioni>\n" +
                " <finanziario>\n" +
                " <quoteTotali>2657.66794</quoteTotali>\n" +
                " <controvaloreTotale>32809.0634</controvaloreTotale>\n" +
                " <dataRiferimentoNAV>2016-10-24</dataRiferimentoNAV>\n" +
                " <isETF>false</isETF>\n" +
                " <isCustom>false</isCustom>\n" +
                " <ctvCommissioniNegoziazioni>0.0</ctvCommissioniNegoziazioni>\n" +
                " <lineaInvestimento>Multilinea FV Insieme</lineaInvestimento>\n" +
                " </finanziario>\n" +
                " <contabile>\n" +
                " <totalePremiAnnuiIncassati>35250.0</totalePremiAnnuiIncassati>\n" +
                " <totalePremiDaTrasformazioni>0.0</totalePremiDaTrasformazioni>\n" +
                " <totalePremiAnnuiIncassatiConTrasformate>35250.0</totalePremiAnnuiIncassatiConTrasformate>\n" +
                " <totalePremiAggiuntiviOggi>0.0</totalePremiAggiuntiviOggi>\n" +
                " <sommaPremiResiduiDaVersare>0.0</sommaPremiResiduiDaVersare>\n" +
                " <dataFinePagamentoPremi>2022-03-21</dataFinePagamentoPremi>\n" +
                " <premiTrasferimentoDaAltriFondi>0.0</premiTrasferimentoDaAltriFondi>\n" +
                " </contabile>\n" +
                " <altriDati>\n" +
                " <vincolo>\n" +
                " <attivo>false</attivo>\n" +
                " </vincolo>\n" +
                " <decumuloCedola>\n" +
                " <attivo>false</attivo>\n" +
                " <dettagli>\n" +
                " <imponibile>0.0</imponibile>\n" +
                " <importoPagato>0.0</importoPagato>\n" +
                " <cvn>0.0</cvn>\n" +
                " <percentuale>0.0</percentuale>\n" +
                " <importoRata>0.0</importoRata>\n" +
                " </dettagli>\n" +
                " </decumuloCedola>\n" +
                " <imponibileCongelamento>0.0</imponibileCongelamento>\n" +
                " <classeCPP>C</classeCPP>\n" +
                " <percentualeCaricamentoCPP>0.0</percentualeCaricamentoCPP>\n" +
                " <caricamentiCPP>\n" +
                " <caricamentoCPPR3>\n" +
                " <descrizione>Prima rata di prima annualita'</descrizione>\n" +
                " <tipoTitolo>01</tipoTitolo>\n" +
                " <percentualeCaricamento>2.0</percentualeCaricamento>\n" +
                " </caricamentoCPPR3>\n" +
                " <caricamentoCPPR3>\n" +
                " <descrizione>Rata di prima annualita'</descrizione>\n" +
                " <tipoTitolo>03</tipoTitolo>\n" +
                " <percentualeCaricamento>2.0</percentualeCaricamento>\n" +
                " </caricamentoCPPR3>\n" +
                " <caricamentoCPPR3>\n" +
                " <descrizione>Rata di annualita' successive</descrizione>\n" +
                " <tipoTitolo>04</tipoTitolo>\n" +
                " <percentualeCaricamento>1.6</percentualeCaricamento>\n" +
                " </caricamentoCPPR3>\n" +
                " <caricamentoCPPR3>\n" +
                " <descrizione>Rata estemporanea di prima annualita'</descrizione>\n" +
                " <tipoTitolo>05</tipoTitolo>\n" +
                " <percentualeCaricamento>2.0</percentualeCaricamento>\n" +
                " </caricamentoCPPR3>\n" +
                " </caricamentiCPP>\n" +
                " <importoPianoProgrammatoVersamenti>60000.0</importoPianoProgrammatoVersamenti>\n" +
                " <detraibilitaFiscale>\n" +
                " <stato>false</stato>\n" +
                " </detraibilitaFiscale>\n" +
                " <polizzaDerivanteDaTrasformazione>false</polizzaDerivanteDaTrasformazione>\n" +
                " <polizzaScudata>false</polizzaScudata>\n" +
                " <impostaBolloMaturata>0.0</impostaBolloMaturata>\n" +
                " <pegno>false</pegno>\n" +
                " <isVariazioneContrattuale>false</isVariazioneContrattuale>\n" +
                " <tipoClasseBonus/>\n" +
                " <isRiallocazioneGuidata>false</isRiallocazioneGuidata>\n" +
                " <isNoteBloccanti>false</isNoteBloccanti>\n" +
                " </altriDati>\n" +
                " <trasformabile>true</trasformabile>\n" +
                " <trasformazioneDiFatto>false</trasformazioneDiFatto>\n" +
                " <isOperazioneFinanzInVolo>false</isOperazioneFinanzInVolo>\n" +
                " <dettaglioLinea>\n" +
                " <codiceLinea>FP</codiceLinea>\n" +
                " <descrizioneLinea>Linea MultiSelection</descrizioneLinea>\n" +
                " <isProtetta>NO</isProtetta>\n" +
                " <controValoreNav>32809.0634</controValoreNav>\n" +
                " <controvaloreProtetto>0.0</controvaloreProtetto>\n" +
                " <percentualeMonetari>0.0</percentualeMonetari>\n" +
                " <controvaloreMonetari>0.0</controvaloreMonetari>\n" +
                " <percentualeFondiSelezionatiCliente>0.0</percentualeFondiSelezionatiCliente>\n" +
                " <controvaloreFondiSelezionatiCliente>0.0</controvaloreFondiSelezionatiCliente>\n" +
                " <dataRiferimentoNav>2016-02-15</dataRiferimentoNav>\n" +
                " <versatoNetto>35000.0</versatoNetto>\n" +
                " <controvaloreInProtezione>0.0</controvaloreInProtezione>\n" +
                " </dettaglioLinea>\n" +
                "</polizza>"  ;

        return s;
    }


}
