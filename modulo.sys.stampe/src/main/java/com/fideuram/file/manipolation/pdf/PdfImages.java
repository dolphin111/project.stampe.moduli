package com.fideuram.file.manipolation.pdf;

import com.fideuram.utils.Streamer;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by
 * User: logan
 * Date: 22/05/12
 * Time: 10.20
 */
public class PdfImages  {
   private String titolo;
   private String fileOut;
   private PdfStamper pdfOut;
   private Image img[];

    public PdfImages(String outputpath) {
        super();
        this.titolo = "ProspettoDofferta"+new Date().toString()+".pdf";
        this.fileOut=  outputpath +titolo;
    }

    public   void addImages(String pdfDestinazione, String img, float imgX, float imgY)
           throws DocumentException,
                  IOException,
                  MalformedURLException {

               Document document=new Document();
               PdfWriter.getInstance(document,new FileOutputStream(pdfDestinazione));
               //PdfWriter.getInstance(document,new FileOutputStream("imagesPDF.pdf"));
               document.open();
               //Image image = Image.getInstance ("devi.jpg");
               Image image = Image.getInstance (img);
               //image.setAbsolutePosition(300f, 600f);
               image.setAbsolutePosition(imgX, imgY);
               document.add(new Paragraph("Roseindia"));
               document.add(image);
               document.close();
    }


    /**
     * @param pdfOrigine
     * @param newchart
     * @param oldchart   List<String> Lista di nomi delle immaggini attese nel pdf
     * @return
     * @throws IOException
     * @throws DocumentException
     * @deprecated
     */
    public byte[] replaceImmaginiByListNames(byte[] pdfOrigine, List<String> newchart, List<String> oldchart)
            throws IOException, DocumentException {
        PdfReader pdfIn = new PdfReader(pdfOrigine);
        PdfStamper pdfOut = new PdfStamper(pdfIn, new FileOutputStream(fileOut));
        PdfWriter writer = pdfOut.getWriter();
        setImageSet(newchart);
        PdfDictionary catalog = pdfIn.getPageN(1);
        PdfDictionary res =  (PdfDictionary)PdfReader.getPdfObject(catalog.get(PdfName.RESOURCES));
        PdfDictionary xobj = (PdfDictionary)PdfReader.getPdfObject(res.get(PdfName.XOBJECT));
        for (int i = 0; i < oldchart.size(); ++i) {
            PdfName curKey = new PdfName(oldchart.get(i));
            PdfIndirectReference ref = xobj.getAsIndirectObject(curKey);
            PdfReader.killIndirect( ref );
            Image maskImage = img[i].getImageMask();
            if (maskImage != null) {
                writer.addDirectImageSimple(maskImage);
            }
            writer.addDirectImageSimple(img[i], (PRIndirectReference)ref);
        }
        pdfOut.close();
        return getStreamer();
    }


    /**
     * sostituisce tutte le immaggini del PDF.
     * <br> Il metodo si aspetta un elenco di stringhe o di null</br>
     * <br>che rappresentano rispettivamente:</br>
     * <br>la posizione esatta delle immagini da sotituire o da lasciare</br>
     *
     * @param pdfOrigine
     * @param newchart  Lista ordinata delle immagini che si vuole andare a sostituire
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    public  byte[] replaceAllImmagini(byte[] pdfOrigine, List<String> newchart)
            throws IOException, DocumentException {

        PdfReader pdfIn = new PdfReader(pdfOrigine);
        PdfStamper pdfOut = new PdfStamper(pdfIn, new FileOutputStream(fileOut));
        PdfWriter writer = pdfOut.getWriter();

        setImageSet(newchart);

        PdfDictionary catalog = pdfIn.getPageN(1);
        PdfDictionary res =  (PdfDictionary)PdfReader.getPdfObject(catalog.get(PdfName.RESOURCES));
        PdfDictionary xobj = (PdfDictionary)PdfReader.getPdfObject(res.get(PdfName.XOBJECT));

        Iterator set = xobj.getKeys().iterator();
        List<PdfName> lista = gerOrderedName(set);
        for (int i=0; i<lista.size();i++){
            PdfIndirectReference ref = xobj.getAsIndirectObject(lista.get(i));
            PdfReader.killIndirect( ref );
            Image maskImage = img[i].getImageMask();
            if (maskImage != null) {
                writer.addDirectImageSimple(maskImage);
            }
            writer.addDirectImageSimple(img[i], (PRIndirectReference)ref);
        }
        pdfOut.close();
        return getStreamer();
    }

    /**
     * Questo metodo ha lo scopo di preparare loi stream delle immagini da importare per la replace nel PDF
     * @param newchart
     * @throws IOException
     * @throws BadElementException
     */
    private void setImageSet(List<String> newchart) throws IOException, BadElementException {
        img = new Image[newchart.size()];
        for (int i=0; i<newchart.size();i++){
            img[i] = Image.getInstance(newchart.get(i));
        }
    }

    private byte[] getStreamer() throws IOException {
        return Streamer.getFile(pdfOut+titolo);
    }


    /**
     * Questo metodo ha lo scopo di ordinare in maniera crescente la lista di immagini trovate nel pdf
     * @param set
     * @return List<PdfName>  opportunamente riordinate
     */
    private List<PdfName> gerOrderedName(Iterator set) {
        List<PdfName> lista = new ArrayList<PdfName>();
        PdfName schema[] = new PdfName[500];
        while (set.hasNext()) {
            PdfName pdfName = (PdfName) set.next();
            System.out.println(pdfName.toString() + "----" + pdfName.toString().substring(3));
            int x = Integer.decode(pdfName.toString().substring(3));
            schema[x] = pdfName;
        }
        for (int i = 0; i < schema.length; i++) {
            if (schema[i] != null)
                lista.add((PdfName) schema[i]);
        }

        return lista;
    }



    /*public HashMap getImmaggini(byte[] pdfOrigine) throws Exception, DocumentException, URISyntaxException {
        int immaginiTrovate=0;
        PdfReader pdfIn = new PdfReader(pdfOrigine);
        int numeroPagine=pdfIn.getNumberOfPages();   //ottengo la dimensione delle pagine:
        for(int i=0; i<440; i++){
            PdfDictionary pg  =pdfIn.getPageN(i + 1);
            PdfDictionary res =(PdfDictionary)PdfReader.getPdfObject(pg.get(PdfName.RESOURCES));
            PdfDictionary xobj=(PdfDictionary)PdfReader.getPdfObject(res.get(PdfName.XOBJECT));
            byte[] imageData = null;

            if (xobj != null) {
                for (Iterator it = xobj.getKeys().iterator(); it.hasNext();) {
                    int x=0;
                    PdfObject obj = xobj.get((PdfName)it.next());
                    if (obj.isIndirect()) {
                        PdfDictionary tg = (PdfDictionary)PdfReader.getPdfObject(obj);
                        PdfName type = (PdfName)PdfReader.getPdfObject(tg.get(PdfName.SUBTYPE));
                        if (PdfName.IMAGE.equals(type)) {
                            //imageData = PdfReader.getStreamBytesRaw((PRStream) obj);


                            Streamer.saveToFile(obj.getBytes(),new URI("/tmp/"),"pag:"+i+"-img:"+x++);
                        }
                    }
                }
            }
        }
        System.out.println("IMMAGINI TROVATE NEL PDF-->" + immaginiTrovate);
        return null;
    }*/




   /* public HashMap getImmaggini(byte[] pdfOrigine) throws IOException {
        PdfReader reader;

        File file = new File("/develop/Fideuram/out/tmp/Prospetto_d'offerta_+_Glossario.PDF");
        reader = new PdfReader(file.getAbsolutePath());
        for (int i = 0; i < reader.getXrefSize(); i++) {
            PdfObject pdfobj = reader.getPdfObject(i);
            if (pdfobj == null || !pdfobj.isStream()) {
                continue;
            }
            PdfStream stream = (PdfStream) pdfobj;
            PdfObject pdfsubtype = stream.get(PdfName.SUBTYPE);
            if (pdfsubtype != null && pdfsubtype.toString().equals(PdfName.IMAGE.toString())) {
                byte[] img = PdfReader.getStreamBytesRaw((PRStream) stream);
                //FileOutputStream out = new FileOutputStream(new File(file.getParentFile(), String.format("%1$05d", i) + ".jpg"));
                FileOutputStream out = new FileOutputStream(new File("/tmp/"+String.format("%1$05d", i) + ".jpg"));
                out.write(img);
                out.flush();
                out.close();
            }
        }
        return null;
    }*/



    public static void main(String args[]) throws Exception, DocumentException {
        //FileInputStream fin = new FileInputStream("/tmp/odtOfferta.pdf");
        FileInputStream fin = new FileInputStream("/develop/Fideuram/out/tmp/Offerta.pdf");
        FileInputStream fin2 = new FileInputStream("/develop/Fideuram/out/tmp/Prospetto_d'offerta_+_Glossario.PDF");
        byte[] pdfIn= Streamer.getByteArray(fin);
        byte[] pdfIn2= Streamer.getByteArray(fin2);
        List<String> oldGraph=new ArrayList();
        oldGraph.add("Im4");
        oldGraph.add("Im8");
        oldGraph.add("Im12");
        // oldGraph.add("grafico1");
        // oldGraph.add("grafico2");
        List<String> newGraph=new ArrayList();
        newGraph.add("/develop/Fideuram/out/tmp/Torta.jpg");
        newGraph.add("/develop/Fideuram/out/tmp/Linea.jpg");
        newGraph.add("/develop/Fideuram/out/tmp/Linee.jpg");


        //new PdfImages().replaceImmaginiByListNames(pdfIn,newGraph,oldGraph);
        new PdfImages("/tmp/").replaceAllImmagini(pdfIn, newGraph);
       // new PdfImages().getImmaggini(pdfIn2);
    }
}




