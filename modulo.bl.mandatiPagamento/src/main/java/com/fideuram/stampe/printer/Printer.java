package com.fideuram.stampe.printer;


import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.jaxb.Converter;
import com.fideuram.stampe.costanti.Costanti;
import com.fideuram.stampe.exeption.MandatiPagamentoException;
import com.fideuram.stampe.modello.mandatiPagamento.DettaglioPagamenti;
import com.fideuram.stampe.modello.mandatiPagamento.MandatiPagamento;
import com.fideuram.stampe.modello.mandatiPagamento.Pagamento;
import com.fideuram.stampe.modello.mandatiPagamento.RiepilogoPagamenti;
import com.fideuram.stampe.servizi.Facade;
import com.fideuram.stampe.servizi.ServiziGenerici;
import com.fideuram.utils.LoggingUtils;
import org.apache.commons.io.FileUtils;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Printer extends ServiziGenerici{

    public void printMandatiPagamento(Pagamento pagamento, String nameXML)throws MandatiPagamentoException, Exception {
        // //LoggingUtils.info("Inizio generazione PDF");
        byte[] lbyte = new MandatiPagamentoGenerator(Costanti.DISTINTAMANDATOPAGAMENTOTEMPLATE).generateDocument(pagamento,pagamento.numeroDistinta);
        savePdf(lbyte, Facade.pathFilesMandati + File.separator + nameXML, pagamento.numeroDistinta.trim() + ".pdf");

    }

     public void printMandatiPagamentoRiepilogo(RiepilogoPagamenti riepilogo, String nameXML)throws MandatiPagamentoException, Exception {
        //   //LoggingUtils.info("Inizio generazione Riepilogo PDF");
        byte[] lbyte = new MandatiPagamentoGenerator(Costanti.RIEPILOGOMANDATOPAGAMENTOTEMPLATE).generateDocument(riepilogo,"riepilogoPagamenti");
        savePdf(lbyte,  Facade.pathFilesMandati+ File.separator + nameXML, "totaleBonifici.pdf");

    }


    public void printDettDistintaPagamento(Pagamento distinta, String nameXML,String numeroDistinta)throws MandatiPagamentoException, Exception {
        // //LoggingUtils.info("Inizio generazione PDF");
        byte[] lbyte = new MandatiPagamentoGenerator(Costanti.DETTDISTINTAPAGAMENTOTEMPLATE).generateDocument(distinta,numeroDistinta);
        savePdf(lbyte,  Facade.pathFilesMandati+ File.separator + nameXML, new String("DETT_"+numeroDistinta+".pdf"));

    }

    public void printMandatiPagamentoBase(File xml,	EsitoStampaMandati esitoStampaMandati) throws Exception {
        //	LoggingUtils.info("------------INIZIO CARICAMENTO MANDATI DI PAGAMENTO");

        String tipoMandato="";
        String nameXML = xml.getName().substring(0, xml.getName().indexOf("."));
        if (nameXML.contains("BF"))
            tipoMandato="BF";
        else if (nameXML.contains("BA"))
            tipoMandato="BA";




        MandatiPagamento beanMandati =null;
        String zipFileName ="";
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_HHmmss");
        String nomeZipMandati= "MandatiPagamento_"+sdf.format(new Date())+tipoMandato+".zip";
        String identificativoPagamento= "";
        try {
            if (nameXML.contains("BONIFICI") || nameXML.contains("ASSEGNI")) {
                nomeZipMandati= "MandatiPagamento_"+xml.getName().substring(0, 10) + "_" +sdf.format(new Date())+tipoMandato+".zip";
                creaDistintePagamento(xml,esitoStampaMandati,nameXML);
            }
            else{

                //	LoggingUtils.info("Inizio conversione oggetto xml nel relativo bean");
                beanMandati = (MandatiPagamento) Converter.xml2Object(new MandatiPagamento(), xml);
                if (beanMandati.getPagamento().size() > 0){
                    String numeroPezzi= beanMandati.getNumeropezzi();

                    RiepilogoPagamenti riepilogoPagamenti=new RiepilogoPagamenti();
                    riepilogoPagamenti.setSommaPagamenti(beanMandati.getTotaleImportoComplessivo());

                    List<Pagamento> listaPagamenti=new ArrayList<Pagamento>();
                    int progressivo=1;
                    for (int i = 0; i < beanMandati.getPagamento().size(); i++) {
                        Pagamento beanPagamento = beanMandati.getPagamento().get(i);
                        identificativoPagamento=beanPagamento.getNumeroDistinta().trim();
                        beanPagamento.setProgressivo(progressivo);
                        printMandatiPagamento(beanPagamento, nameXML);
                        listaPagamenti.add(beanPagamento);
                        riepilogoPagamenti.setPagamenti(listaPagamenti);
                        esitoStampaMandati.getListaMandatiPagamento().add(identificativoPagamento);
                        progressivo++;
                    }
                    //Produco nella cartella anche il riepilogo
                    printMandatiPagamentoRiepilogo(riepilogoPagamenti, nameXML);


                }



                LoggingUtils.info("nome XML " + nameXML);


            }

            zipFiles(Facade.pathFilesMandati + File.separator + nameXML, Facade.pathFileGenerati + File.separator
                    + nomeZipMandati);

            //Cancello xml
            FileUtils.deleteDirectory(new File(Facade.pathFilesMandati + File.separator + nameXML));


        } catch (MandatiPagamentoException e) {
            LoggingUtils.error(e);
            esitoStampaMandati.getListaErrori().add(identificativoPagamento + "-" + xml.getName());
            throw new MandatiPagamentoException("ERRORE" +e.getMessage(),e);
        } catch (JAXBException e) {
            LoggingUtils.error(e);
            esitoStampaMandati.getListaErrori().add(identificativoPagamento + "-" + xml.getName());
            throw new MandatiPagamentoException(Costanti.ERROR_XML +e.getMessage(),e);
        } catch (ClassNotFoundException e) {
            LoggingUtils.error(e);
            esitoStampaMandati.getListaErrori().add(identificativoPagamento + "-" + xml.getName());
            throw new MandatiPagamentoException(Costanti.ERROR_NOTFOUND +e.getMessage(),e);
        } catch (InstantiationException e) {
            LoggingUtils.error(e);
            esitoStampaMandati.getListaErrori().add(identificativoPagamento + "-" + xml.getName());
            throw new MandatiPagamentoException(Costanti.ERROR_INSTANCE +e.getMessage(),e);
        } catch (IllegalAccessException e) {
            LoggingUtils.error(e);
            esitoStampaMandati.getListaErrori().add(identificativoPagamento + "-" + xml.getName());
            throw new MandatiPagamentoException(Costanti.ERROR_ILLEGAL + e.getMessage(),e);
        } catch (TemplateLoaderExcepion e) {
            LoggingUtils.error(e);
            esitoStampaMandati.getListaErrori().add(identificativoPagamento + "-" + xml.getName());
            throw new MandatiPagamentoException(Costanti.ERROR_TEMPLATE + e.getMessage(),e);
        }

    }







    public void creaDistintePagamento(File xml,EsitoStampaMandati esitoStampaMandati,String nomeXML)throws MandatiPagamentoException, Exception {


        DettaglioPagamenti beanMandati = (DettaglioPagamenti) Converter.xml2Object(new DettaglioPagamenti(), xml);
        if (beanMandati.getPagamento().size() > 0){
            String numeroPezzi= beanMandati.getNumeroComplessivo();

            String identificativoPagamento="";
            int progressivo=1;
            for (int i = 0; i <beanMandati.getPagamento().size(); i++) {
                Pagamento beanPagamento = beanMandati.getPagamento().get(i);
                identificativoPagamento=beanPagamento.getNumeroDistinta().trim();
                beanPagamento.setProgressivo(progressivo);
                printDettDistintaPagamento (beanPagamento,nomeXML,identificativoPagamento) ;
                esitoStampaMandati.getListaMandatiPagamento().add("DETT" +identificativoPagamento);
                progressivo++;
            }

        }



    }

}
