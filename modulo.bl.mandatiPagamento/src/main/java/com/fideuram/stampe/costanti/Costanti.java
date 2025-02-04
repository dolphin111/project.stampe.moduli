package com.fideuram.stampe.costanti;


import com.fideuram.stampe.servizi.ServiziGenerici;
import com.fideuram.stampe.printer.Printer;
public class Costanti extends ServiziGenerici{


    public Costanti() {
        super();
    }

    public static ServiziGenerici serviziGenerici=null;
    public static Printer printer=null;

    //MANDATI PAGAMENTO
    //Due odt interessati uno è il modello singolo l'altro è il ripielogo con la lista di tutti i bonifici
    public static String DISTINTAMANDATOPAGAMENTOTEMPLATE                    = "MANDATI_PAGAMENTO_Distinta";
    public static String RIEPILOGOMANDATOPAGAMENTOTEMPLATE                   = "MANDATI_PAGAMENTO_Riepilogo";
    public static String DETTDISTINTAPAGAMENTOTEMPLATE                       = "MANDATI_PAGAMENTO_DettDistinta";
    public static final String MANDATIPAGAMENTO_TEMPLATE_DIR                 = "mandatiPagamento.template.dir";
    public static final String MANDATIPAGAMENTO_DIR                          = "mandatiPagamento.dir";
    public static final String MANDATIPAGAMENTO_LAVORATE_DIR            	 = "mandatiPagamento.stato.lavorate.dir";
    public static final String MANDATIPAGAMENTO_ERRORI_DIR               	 = "mandatiPagamento.stato.errori.dir";
    public static final String MANDATIPAGAMENTO_GENERATI               	     = "mandatiPagamento.stato.generati.dir";
    public static final String MANDATIPAGAMENTO_ARCHIVIATE                   = "mandatiPagamento.stato.archiviate.dir";

    public static final String  ERROR_XML                                    ="Errore durante la fase di conversione xml dei Rendiconti ";
    public static final String  ERROR_NOTFOUND                               ="Errore di ClassNotFoundException durante la fase di conversione xml dei Rendiconti ";
    public static final String  ERROR_INSTANCE                               ="Errore di InstantiationException durante la fase di conversione xml dei Rendiconti ";
    public static final String  ERROR_ILLEGAL                                ="Errore di IllegalAccessException durante la fase di conversione xml dei Rendiconti ";
    public static final String  ERROR_TEMPLATE                               ="Errore  di caricamento del template";


}
