package com.fideuram.modello.vgitext;

import java.io.BufferedReader;
import java.io.FileReader;
import com.fideuram.utils.LoggingUtils;


/**
 * Created with
 * User: logan
 * Date: 05/06/13
 * Time: 11.37
 */
public class Parser {


    public static Collettiva getCollettiva() throws Exception {
        Collettiva collettiva = new Collettiva();

        BufferedReader br = new BufferedReader(new FileReader("D://test/nuovi tracciati txt/STATLIQ.2013-03-07-10.04.28.TXT"));
        String line = "";
        int lineNum = 0, tokenNum = 0;

        Gruppo gruppo = new Gruppo();
        while ((line = br.readLine()) != null) {

            Riga riga = new Riga();
            lineNum++;
            //LoggingUtils.debug("posizione Linea del file #" + line);
            if(line.trim().equals("$$$$$")){
                collettiva.getGruppi().add(gruppo);
                gruppo = new Gruppo();
            }
            else{
                String linea = line;
                riga.setLinea(linea);
                LoggingUtils.debug("posizione Linea del file #" + linea);
                gruppo.getRighe().add(riga);
            }

        }
        collettiva.getGruppi().add(gruppo);
        System.out.println("");
        return collettiva;
    }

//    public static File generateScartiTDPWithFreemarker(byte[] template, Collettiva collettiva) throws CollettiveFileDataReadException, Exception {
//        File documento=null;
//        try{
//            InputStream in=  new ByteArrayInputStream(template);
//            IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Freemarker );
//            IContext context = report.createContext();
//            context.put( "collettive", collettiva );
//
//            documento=new File(CrmProperties.getProperty("crm.services.temp.path")+new Date().getTime());
//            LoggingUtils.info("generateScartiTDPWithFreemarker method: documentoPath["+documento.getPath()+"]");
//            OutputStream out = new FileOutputStream( documento );
//            report.process(context, out);
//            out.close();
//            LoggingUtils.info("Generato >>");
//        } catch (XDocReportException e) {
//            LoggingUtils.error(e.getMessage());
//            throw new CollettiveFileDataReadException("OdtFactory.generateScartiTDPWithFreemarker: XDocReportException",e);
//        } catch (IOException e) {
//            LoggingUtils.error(e.getMessage());
//            throw new CollettiveFileDataReadException("OdtFactory.generateScartiTDPWithFreemarker: IOException",e);
//        } catch (Exception e){
//            LoggingUtils.error("Eccezione generica: ["+e.getMessage()+"]");
//            throw new Exception("OdtFactory.generateScartiTDPWithFreemarker: Exception",e);
//        }
//        return documento;
//    }
}
