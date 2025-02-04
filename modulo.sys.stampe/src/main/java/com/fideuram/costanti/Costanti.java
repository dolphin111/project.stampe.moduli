package com.fideuram.costanti;

/**
 * Contiene esclusivamente delle costanti di uso comune sulle stampe
 */
public abstract class Costanti {
    //COSTANTI PER COLLETTIVE .... SE SARANNO MAI USATE
   /*
    public static final String MAIL_FROM_COLLETTIVE        ="mail.from.collettive";
    public static final String MAIL_TO_COLLETTIVE          ="mail.to.collettive";
    public static final String MAIL_CC_COLLETTIVE          ="mail.cc.collettive";
    public static final String MAIL_SMTP_HOST              ="mail.smtp.host";
    public static final String MAIL_SMTP_PORT              ="mail.smtp.port";
    public static final String PATH_COLLETTIVE             ="path.collettive";
    public static final String PRINTER_NAME                ="printer.name";
    public static final String PRINTER_NAME_STAMPATI       ="printer.name.stampati";
   */

    //UPGRADE PER INTRODUZIONE SERVIZI SPI
    public static final String CODICE_LIQUIDAZIONI_SPI                  = "y1100";
    public static final String CODICE_RISCATTO_A_TERMINE_SPI            = "b2100";
    public static final String CODICE_OPZIONE_REVERSIBILITA_SPI         = "e5100";
    public static final String CODICE_AVVISI_SCADENZA_SPI               = "e131";

    public static final String CODICE_AVVISI_SCADENZA_PA                = "e132";
    public static final String CODICE_OPZIONE_RAMO_III                  = "e5101";


    //FORMATI
    public static final String FORMATO_DATA                             = "dd/MM/yyyy";
    public static final String SEPARATORE_MIGLIAIA                      = ".";
    public static final String SEPARATORE_DECIMALI                      = ",";

    public static final String BI_SERVICES_URL                          = "bi.services.url";
    public static final String CRM_SERVICES_TEMP_PATH                   = "crm.services.temp.path";
    public static final String CRM_STAMPE_TEST                          = "crm.test";
    public static final String LOG4J_FILE                               = "log4j.config.file";
    
    //TRIPLETTE
    public static final String CODICE_LETTERA_GENERICA                  = "A11";
    public static final String CODICE_LETTERA_RECLAMO                   = "KB32";
	public static final String CODICE_LETTERA_PREVIDENZA                = "000";
    public static final String CODICE_RISCHI_COMUNI                     = "A21";
    public static final String CODICE_RISCATTO_ANTICIPATO               = "B11";
    public static final String CODICE_RISCATTO_ANTICIPATO_AL            = "B14";
	public static final String CODICE_RISCATTO_PARZIALE_TENDENZA 	    = "B17";
	public static final String CODICE_RISCATTO_PARZIALE_PUNTUALE 	    = "B118";
    public static final String CODICE_RISCATTO_TERMINE                  = "B28";
    public static final String CODICE_RISCATTO_TERMINE_PU_AGG           = "B24";
    public static final String CODICE_RISCATTO_TERMINE_AMPLIAMENTO      = "B25";
    public static final String CODICE_RISCATTO_TERMINE_RIATTIVAZIONE    = "B26";
    public static final String CODICE_PRESTAZIONI_ASSICURATE            = "E11";
    public static final String CODICE_CONVERSIONE_RENDITA               = "E41";
    public static final String CODICE_PREVENTIVO_CONVERSIONE_RENDITA    = "E43";
    public static final String CODICE_ECCEDENZA                         = "B19";
    public static final String CODICE_CARICAMENTI_CPP                   = "F11";
    public static final String CODICE_SINISTRO                          = "B61";
    public static final String CODICE_DISPONIBILITA                     = "E71";
    public static final String CODICE_RIDUZIONE                         = "E21";
    public static final String CODICE_OPZIONE_REVERSIBILITA             = "E51";
    public static final String CODICE_OPZIONE_CERTEZZA                  = "E52";
    public static final String CODICE_OPZIONE_PROROGA                   = "E53";
    public static final String CODICE_OPZIONE_CAMBIOFRAZ                = "E54";
    public static final String CODICE_OPZIONE_ANTICIPATA                = "E55";
    public static final String CODICE_PREMI_PAGATI                      = "G12";
    public static final String CODICE_SPIEGAZIONE_CONTEGGI              = "Y11";
    public static final String CODICE_SPIEGAZIONE_CONTEGGI_R1           = "Y12";
    public static final String CODICE_PREVIDENZA                        = "000";
    //public static final String CODICE_RISCATTO_PARZIALE = "B17";
	public static final String CODICE_DECUMULO                          = "B131";
    public static final String COMMISSIONI_FONDI_ESTERNI                = "f15";
    public static final String VALORE_PRESTITO                          = "B51";
    public static final String STATO_PRATICA_STORNATA                   = "STORNATA";
    public static final int    ID_LETTERA_GENERICA                      = 263;
    public static final int    ID_PREVIDENZA                            = 279;
    public static final String CODICE_SIMULAZIONEFPA                    = "e5102";
    
    public static final String CODICE_CREDIT_LINE                       = "q11";
    public static final String CODICE_MASSIMO_VALORE_UL					= "f213";

    public static final String CODICE_PRATICHELEGALI_SEQUESTRO = "pl28";
    public static final String CODICE_PRATICHELEGALI_ACCERTAMENTO = "pl25";
    public static final String CODICE_PRATICHELEGALI_DISSEQUESTRO = "pl24";
    public static final String CODICE_PRATICHELEGALI_PIGNORAMENTO_PRIVATO = "pl21";
    public static final String CODICE_PRATICHELEGALI_PIGNORAMENTO_AE = "pl22";
    public static final String CODICE_PRATICHELEGALI_ACCESSI = "pl13";

    //INPUT
    public static final int[] SPIEGAZIONI_CONTEGGI_PREVIDENZA			= {71};
    public static final int[] INPUT_DATA_VALUTAZIONE                    = {1};
    public static final int[] INPUT_ANTICIPATA                          = {2, 7};
    public static final int[] INPUT_DATA_NASCITA                        = {3};
    public static final int[] INPUT_FRAZIONAMENTO                       = {4, 8, 15, 16, 18, 54};
    public static final int[] INPUT_REVERSIBILITA                       = {5};
    public static final int[] INPUT_SESSO                               = {6};
    public static final int[] INPUT_RENDITA_CERTA_ANNI                  = {9, 20};
    public static final int[] INPUT_ANNI_PROROGA                        = {10};
    public static final int[] INPUT_MESI_PROROGA                        = {11};
    public static final int[] INPUT_DATA_PROROGA                        = {12};
    public static final int[] INPUT_POLIZZA_PROROGA                     = {13};
    public static final int[] INPUT_VALORE_RISCATTO                     = {14, 24};
    public static final int[] INPUT_ANNI_ANTICIPAZIONE                  = {17};
    public static final int[] INPUT_RENDITA_ANTICIPATA                  = {19};
    public static final int[] INPUT_PRATICHE_LIQUIDAZIONE               = {25};
    public static final int[] INPUT_REVERSIBILITA_DATA_TESTA_2          = {21};
    public static final int[] INPUT_REVERSIBILITA_PERCENTUALE_TESTA_2   = {22};
    public static final int[] INPUT_REVERSIBILITA_SESSO_TESTA_2         = {23};
    public static final int[] INPUT_DATA_VALUTA               		    = {37};
	public static final int[] INPUT_RISCATTO_PARZIALE_TENDENZA          = {39};
	public static final int[] INPUT_RISCATTO_PARZIALE_PUNTUALE          = {40};
	public static final int[] INPUT_DECUMULO                            = {41};
    public static final int[] INPUT_RENDITA_CERTA_ANNI85                = {69};
    public static final int[] INPUT_ETA_CALCOLO                         = {72};

    public static final String INPUT_VALORE_SI = "Si";
    public static final String INPUT_VALORE_NO = "No";
	public static final String ZERO_STRING_FORMATTED = "0,00";



    //AMBIENTE DI LAVORO
    public static final String AMBIENTE_UNIVERSO="AMBIENTE_UNIVERSO";
    
    //QUIETANZE
    public static final String QUIETANZE_DIR                            = "quietanze.dir";
    public static final String QUIETANZE_BONIFICI_DIR                   = "quietanze.bonifici.dir";
    public static final String QUIETANZE_ASSEGNI_ISIDE_DIR              = "quietanze.assegni.iside.dir";
    public static final String QUIETANZE_ASSEGNI_STORICO_DIR            = "quietanze.stato.storico.dir";
    public static final String QUIETANZE_STATO_STAMPATI_DIR             = "quietanze.stato.stampati.dir";
    public static final String QUIETANZE_TEMP_FILE_LAVORAZIONE_DIR      = "quietanze.temp.file.lavorazione.dir";
    public static final String QUIETANZE_STATO_ERRORI_DIR               = "quietanze.stato.errori.dir";
 	public static final String QUIETANZE_ZIP_GENERATI_BON               = "quietanze.stato.zipgenerati.bonifici.dir";
 	public static final String QUIETANZE_ZIP_GENERATI_ASS               = "quietanze.stato.zipgenerati.assegni.dir";
	public static final String QUIETANZE_ARCHIVIATE                     = "quietanze.stato.archiviate.dir";
	public static final String QUIETANZE_MAIL_TO                        = "quietanze.bucap.mail.to";
	public static final String QUIETANZE_MAIL_FROM                      = "quietanze.bucap.mail.from";
	public static final String QUIETANZE_MAIL_CC                        = "quietanze.bucap.mail.cc";
	public static final String QUIETANZE_MAIL_HOST                      = "quietanze.bucap.mail.host";
	public static final String QUIETANZE_MAIL_OBJECT                    = "quietanze.bucap.mail.object";
	
	
    //CORRISPONDENZE
	public static final String CORRISPONDENZE_TEMPLATE_DIR                   = "corrispondenze.template.dir";
	public static final String CORRISPONDENZE_XML_DIR                        = "corrispondenze.xml.dir";
    public static final String CORRISPONDENZE_DIR                            = "corrispondenze.dir";
    public static final String CORRISPONDENZEB_ISIDE_DIR              		 = "corrispondenzeB.iside.dir";
    public static final String CORRISPONDENZECB_ISIDE_DIR              		 = "corrispondenzeCB.iside.dir";
    public static final String CORRISPONDENZE_STORICO_DIR            		 = "corrispondenze.stato.storico.dir";
    public static final String CORRISPONDENZE_STAMPATI_DIR            		 = "corrispondenze.stato.stampati.dir";
    public static final String CORRISPONDENZE_TEMP_FILE_LAVORAZIONE_DIR      = "corrispondenze.temp.file.lavorazione.dir";
    public static final String CORRISPONDENZE_ERRORI_DIR               		 = "corrispondenze.stato.errori.dir";
 	public static final String CORRISPONDENZE_ZIP_GENERATI               	 = "corrispondenze.stato.zipgenerati.dir";
 	public static final String CORRISPONDENZE_GENERATI               	     = "corrispondenze.stato.generati.dir";
	public static final String CORRISPONDENZE_ARCHIVIATE                     = "corrispondenze.stato.archiviate.dir";
	public static final String CORRISPONDENZE_MAIL_TO                        = "corrispondenze.bucap.mail.to";
	public static final String CORRISPONDENZE_MAIL_FROM                      = "corrispondenze.bucap.mail.from";
	public static final String CORRISPONDENZE_MAIL_CC                        = "corrispondenze.bucap.mail.cc";
	public static final String CORRISPONDENZE_MAIL_HOST                      = "corrispondenze.bucap.mail.host";
	public static final String CORRISPONDENZE_MAIL_OBJECT                    = "corrispondenze.bucap.mail.object";
	public static final String CORRISPONDENZE_BUCAP_FTP                      = "corrispondenze.bucap.invio.dir";
	public static final String CORRISPONDENZE_GEN_MAIL_CC                        = "corrispondenze.gen.mail.cc";
	public static final String CORRISPONDENZE_GEN_MAIL_TO                        = "corrispondenze.gen.mail.to";


    //MANDATI PAGAMENTO
    public static final String MANDATIPAGAMENTO_TEMPLATE_DIR                 = "mandatiPagamento.template.dir";
    public static final String MANDATIPAGAMENTO_XML_DIR                      = "mandatiPagamento.xml.dir";
    public static final String MANDATIPAGAMENTO_DIR                          = "mandatiPagamento.dir";
    public static final String MANDATIPAGAMENTO_STORICO_DIR            		 = "mandatiPagamento.stato.storico.dir";
    public static final String MANDATIPAGAMENTO_STAMPATI_DIR            	 = "mandatiPagamento.stato.stampati.dir";
    public static final String MANDATIPAGAMENTO_ERRORI_DIR               	 = "mandatiPagamento.stato.errori.dir";
    public static final String MANDATIPAGAMENTO_ZIP_GENERATI               	 = "mandatiPagamento.stato.zipgenerati.dir";
    public static final String MANDATIPAGAMENTO_GENERATI               	     = "mandatiPagamento.stato.generati.dir";
    public static final String MANDATIPAGAMENTO_ARCHIVIATE                   = "mandatiPagamento.stato.archiviate.dir";


    //FTP BUCAP
	public static final String BUCAP_FTP                                = "bucap.invio.dir";
	public static final String BUCAP_HOST                               = "bucap.invio.host";
	public static final String BUCAP_USER                               = "bucap.credential.user";
	public static final String BUCAP_PSW                                = "bucap.credential.psw";
	
	//FTP ISIDE
	public static final String ISIDE_FTP                                = "iside.invio.dir";
	
	
	
	
	public static final String MAIL_SMTP_HOST                      						= "mail.smtp.host";
	public static final String MAIL_SMTP_PORT                      						= "mail.smtp.port";
	
	public static final String STAMPE_DELETE_DIRECTORY_MAIL_FROM                      	= "stampe.delete.directory.mail.from";
	public static final String STAMPE_DELETE_DIRECTORY_MAIL_TO                    		= "stampe.delete.directory.mail.to";
	public static final String STAMPE_DELETE_DIRECTORY_MAIL_CC                      	= "stampe.delete.directory.mail.cc";
	public static final String STAMPE_DELETE_DIRECTORY_MAIL_TEXT                      	= "stampe.delete.directory.mail.text";
	
	//Nuovo WSDL Simulatori Riscatto
	public static final String STAMPE_SIMULATORI_END_POINT                              = "wsdl.soapEndpointUrlSimulatori";
	public static final String STAMPE_SIMULATORI_ACTION                                 = "wsdl.soapActionSimulatori";
	public static final String STAMPE_SIMULATORI_NAMESPACE                              = "wsdl.namespaceSimulatori";
	public static final String STAMPE_SIMULATORI_NAMESPACE_URI                          = "wsdl.namespaceURISimulatori";
	public static final String STAMPE_SIMULATORI_PREFIX                                 = "wsdl.prefixCom";
	
    // Tipi Comunicazione

    public static final String TIPO_COMUNICAZIONE_LEGALE = "CL";
    public static final String TIPO_COMUNICAZIONE_SEGUITO_LEGALE = "SCL";
}
