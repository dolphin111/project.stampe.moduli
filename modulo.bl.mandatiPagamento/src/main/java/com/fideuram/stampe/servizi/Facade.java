package com.fideuram.stampe.servizi;

import java.io.File;
import java.util.List;
import com.fideuram.stampe.costanti.Costanti;
import com.fideuram.config.CrmProperties;
import com.fideuram.stampe.printer.EsitoStampaMandati;
import com.fideuram.stampe.printer.Printer;
import com.fideuram.utils.LoggingUtils;

/**
 *
 *  Vengono Prodotti i mandati sia verso Banca e sia per Banca
 *  I Mandati sono interni e quindi non hanno bisogno di essere archiviati su Iside o postalizzati tramite Bucap
 */

public class Facade extends Costanti {

    public static String pathFilesMandati= "";
    public static String pathFileErrori = "";
    public static String pathFileGenerati = "";
    public static String pathFileArchiviati = "";
    public static String pathFileLavorate="";
    public static String pathTemplate = "";


    public Facade(){
        super();
        serviziGenerici=new ServiziGenerici();
        printer=new Printer();
    	pathFilesMandati = CrmProperties.getProperty(Costanti.MANDATIPAGAMENTO_DIR);
		pathFileErrori = CrmProperties.getProperty(Costanti.MANDATIPAGAMENTO_ERRORI_DIR );
		pathFileGenerati = CrmProperties.getProperty(Costanti.MANDATIPAGAMENTO_GENERATI);
		pathFileArchiviati = CrmProperties.getProperty(Costanti.MANDATIPAGAMENTO_ARCHIVIATE);
		pathTemplate = CrmProperties.getProperty(Costanti.MANDATIPAGAMENTO_TEMPLATE_DIR);
        pathFileLavorate = CrmProperties.getProperty(Costanti.MANDATIPAGAMENTO_LAVORATE_DIR);
    }


    /**
     *
     */
    public EsitoStampaMandati generaMandati(String param) {
        Facade facade=new Facade();
        String mandati ="";
        EsitoStampaMandati esito = new EsitoStampaMandati();

        if(param.equalsIgnoreCase("mandatiPagamento"))
            mandati=Facade.pathFilesMandati;


        File f = new File(mandati);
        if (f.isDirectory()) {
            String files[] = f.list();
            for (int i = 0; i < files.length; i++) {
                File file = new File(mandati+ File.separator + files[i]);
                if (!file.isDirectory()) {
                    try {
                        printer.printMandatiPagamentoBase(file, esito);
                        saveFile(file, pathFileLavorate);
                    } catch (Exception e) {
                        saveFile(file, pathFileErrori);
                        e.printStackTrace();
                    }
                    removeFile(file);
                }
            }
        }
      //  LoggingUtils.info("Esito " + esito.getListaMandatiPagamento().size());
        return esito;
    }

    //test main transfer FTP
    public static void main(String args[]) {
//
         Facade facade = new Facade();
        List<String> list = facade.listaFile("mandatiPagamento");
        facade.generaMandati("mandatiPagamento");

        String file[] = new String[1];
        file[0] = "MandatiPagamento_08102014_170732.zip";
        ServiziGenerici archivia = new ServiziGenerici();

    }
}
