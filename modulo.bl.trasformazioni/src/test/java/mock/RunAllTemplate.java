package mock;

import com.fideuram.config.CrmProperties;
import com.fideuram.exception.TrasformazioneException;
import com.fideuram.factory.PdfFactory;
import com.fideuram.processo.FacadeTrasformazioni;
import com.fideuram.utils.Streamer;

import java.net.URISyntaxException;
import java.text.ParseException;

/**
 * Created by 
 * User: logan
 * Date: 12/03/13
 * Time: 12.44
 */
public class RunAllTemplate {
    public static void main(String args[]){
        FacadeTrasformazioni facadeTrasformazioni = new FacadeTrasformazioni();
        try {
            //facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18001PR2FvInsieme.getMock(),801);
            //Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18001PR2FvInsieme.getMock(),801)),CrmProperties.getProperty("crm.services.temp.path"), "From18001PR2FvInsieme.pdf");




         //  Streamer.saveToFile(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18001PR2FvInsieme.getMock(),801),CrmProperties.getProperty("crm.services.temp.path"), "From18001PR2FvInsieme.odt");
         //  Streamer.saveToFile(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18001PU2FvInsieme.getMock(),801),CrmProperties.getProperty("crm.services.temp.path"), "From18001PU2FvInsieme.odt");
         //  Streamer.saveToFile(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18002PR2FvInsieme.getMock(),801),CrmProperties.getProperty("crm.services.temp.path"), "From18002PR2FvInsieme.odt");
         //  Streamer.saveToFile(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18002PU2FvInsieme.getMock(),801),CrmProperties.getProperty("crm.services.temp.path"), "From18002PU2FvInsieme.odt");
         //  Streamer.saveToFile(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18003PR2FvInsieme.getMock(),801),CrmProperties.getProperty("crm.services.temp.path"), "From18003PR2FvInsieme.odt");
         //  Streamer.saveToFile(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18003PU2FvInsieme.getMock(),801),CrmProperties.getProperty("crm.services.temp.path"), "From18003PU2FvInsieme.odt");
         //  Streamer.saveToFile(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18005PR2FvInsieme.getMock(),801),CrmProperties.getProperty("crm.services.temp.path"), "From18005PR2FvInsieme.odt");
         //  Streamer.saveToFile(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18005PU2FvInsieme.getMock(),801),CrmProperties.getProperty("crm.services.temp.path"), "From18005PU2FvInsieme.odt");
         //  Streamer.saveToFile(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From35005PR2FvInsieme.getMock(),801),CrmProperties.getProperty("crm.services.temp.path"), "From35005PR2FvInsieme.odt");
         //  Streamer.saveToFile(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From35005PU2FvInsieme.getMock(),801),CrmProperties.getProperty("crm.services.temp.path"), "From35005PU2FvInsieme.odt");
         //  Streamer.saveToFile(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From35006PR2FvInsieme.getMock(),801),CrmProperties.getProperty("crm.services.temp.path"), "From35006PR2FvInsieme.odt");
         //  Streamer.saveToFile(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From35006PU2FvInsieme.getMock(),801),CrmProperties.getProperty("crm.services.temp.path"), "From35006PU2FvInsieme.odt");
         //  Streamer.saveToFile(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From35007PR2FvInsieme.getMock(),801),CrmProperties.getProperty("crm.services.temp.path"), "From35007PR2FvInsieme.odt");
         //  Streamer.saveToFile(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From35007PU2FvInsieme.getMock(),801),CrmProperties.getProperty("crm.services.temp.path"), "From35007PU2FvInsieme.odt");

          // Streamer.saveToFile(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18001PR2FvFacile.getMock() ,802),CrmProperties.getProperty("crm.services.temp.path"), "FvFacile18001PR.odt");
          // Streamer.saveToFile(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18001PU2FvFacile.getMock() ,802),CrmProperties.getProperty("crm.services.temp.path"), "FvFacile18001PU.odt");
          // Streamer.saveToFile(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18002PR2FvFacile.getMock() ,802),CrmProperties.getProperty("crm.services.temp.path"), "FvFacile18002PR.odt");
          // Streamer.saveToFile(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18002PU2FvFacile.getMock() ,802),CrmProperties.getProperty("crm.services.temp.path"), "FvFacile18002PU.odt");
          // Streamer.saveToFile(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18003PR2FvFacile.getMock() ,802),CrmProperties.getProperty("crm.services.temp.path"), "FvFacile18003PR.odt");
          // Streamer.saveToFile(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18003PU2FvFacile.getMock() ,802),CrmProperties.getProperty("crm.services.temp.path"), "FvFacile18003PU.odt");
          // Streamer.saveToFile(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18005PR2FvFacile.getMock() ,802),CrmProperties.getProperty("crm.services.temp.path"), "FvFacile18005PR.odt");
          // Streamer.saveToFile(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18005PU2FvFacile.getMock() ,802),CrmProperties.getProperty("crm.services.temp.path"), "FvFacile18005PU.odt");
          // Streamer.saveToFile(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From35005PR2FvFacile.getMock() ,802),CrmProperties.getProperty("crm.services.temp.path"), "FvFacile35005PR.odt");
          // Streamer.saveToFile(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From35005PU2FvFacile.getMock() ,802),CrmProperties.getProperty("crm.services.temp.path"), "FvFacile35005PU.odt");
          // Streamer.saveToFile(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From35006PR2FvFacile.getMock() ,802),CrmProperties.getProperty("crm.services.temp.path"), "FvFacile35006PR.odt");
          // Streamer.saveToFile(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From35006PU2FvFacile.getMock() ,802),CrmProperties.getProperty("crm.services.temp.path"), "FvFacile35006PU.odt");
          // Streamer.saveToFile(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From35007PR2FvFacile.getMock() ,802),CrmProperties.getProperty("crm.services.temp.path"), "FvFacile35007PR.odt");
          // Streamer.saveToFile(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From35007PU2FvFacile.getMock() ,802),CrmProperties.getProperty("crm.services.temp.path"), "FvFacile35007PU.odt");


         // Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18001PR2FvInsieme.getMock(),801)),CrmProperties.getProperty("crm.services.temp.path"), "From18001PR2FvInsieme.pdf");
         // Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18001PU2FvInsieme.getMock(),801)),CrmProperties.getProperty("crm.services.temp.path"), "From18001PU2FvInsieme.pdf");
         // Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18002PR2FvInsieme.getMock(),801)),CrmProperties.getProperty("crm.services.temp.path"), "From18002PR2FvInsieme.pdf");
         // Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18002PU2FvInsieme.getMock(),801)),CrmProperties.getProperty("crm.services.temp.path"), "From18002PU2FvInsieme.pdf");
         // Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18003PR2FvInsieme.getMock(),801)),CrmProperties.getProperty("crm.services.temp.path"), "From18003PR2FvInsieme.pdf");
         // Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18003PU2FvInsieme.getMock(),801)),CrmProperties.getProperty("crm.services.temp.path"), "From18003PU2FvInsieme.pdf");
         // Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18005PR2FvInsieme.getMock(),801)),CrmProperties.getProperty("crm.services.temp.path"), "From18005PR2FvInsieme.pdf");
         // Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18005PU2FvInsieme.getMock(),801)),CrmProperties.getProperty("crm.services.temp.path"), "From18005PU2FvInsieme.pdf");
         // Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From35005PR2FvInsieme.getMock(),801)),CrmProperties.getProperty("crm.services.temp.path"), "From35005PR2FvInsieme.pdf");
         // Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From35005PU2FvInsieme.getMock(),801)),CrmProperties.getProperty("crm.services.temp.path"), "From35005PU2FvInsieme.pdf");
         // Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From35006PR2FvInsieme.getMock(),801)),CrmProperties.getProperty("crm.services.temp.path"), "From35006PR2FvInsieme.pdf");
         // Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From35006PU2FvInsieme.getMock(),801)),CrmProperties.getProperty("crm.services.temp.path"), "From35006PU2FvInsieme.pdf");
         // Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From35007PR2FvInsieme.getMock(),801)),CrmProperties.getProperty("crm.services.temp.path"), "From35007PR2FvInsieme.pdf");
         Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From35007PU2FvInsieme.getMock(),801)),CrmProperties.getProperty("crm.services.temp.path"), "From35007PU2FvInsieme.pdf");

         // Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18001PR2FvFacile.getMock() ,802)),CrmProperties.getProperty("crm.services.temp.path"), "From18001PR2FvFacile.pdf");
         //Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18001PU2FvFacile.getMock() ,802)),CrmProperties.getProperty("crm.services.temp.path"), "From18001PU2FvFacile.pdf");
         //Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18002PR2FvFacile.getMock() ,802)),CrmProperties.getProperty("crm.services.temp.path"), "From18002PR2FvFacile.pdf");
         //Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18002PU2FvFacile.getMock() ,802)),CrmProperties.getProperty("crm.services.temp.path"), "From18002PU2FvFacile.pdf");
         //Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18003PR2FvFacile.getMock() ,802)),CrmProperties.getProperty("crm.services.temp.path"), "From18003PR2FvFacile.pdf");
         //Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18003PU2FvFacile.getMock() ,802)),CrmProperties.getProperty("crm.services.temp.path"), "From18003PU2FvFacile.pdf");
         //Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18005PR2FvFacile.getMock() ,802)),CrmProperties.getProperty("crm.services.temp.path"), "From18005PR2FvFacile.pdf");
         //Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From18005PU2FvFacile.getMock() ,802)),CrmProperties.getProperty("crm.services.temp.path"), "From18005PU2FvFacile.pdf");
         //Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From35005PR2FvFacile.getMock() ,802)),CrmProperties.getProperty("crm.services.temp.path"), "From35005PR2FvFacile.pdf");
         //Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From35005PU2FvFacile.getMock() ,802)),CrmProperties.getProperty("crm.services.temp.path"), "From35005PU2FvFacile.pdf");
         //Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From35006PR2FvFacile.getMock() ,802)),CrmProperties.getProperty("crm.services.temp.path"), "From35006PR2FvFacile.pdf");
         //Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From35006PU2FvFacile.getMock() ,802)),CrmProperties.getProperty("crm.services.temp.path"), "From35006PU2FvFacile.pdf");
         //Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From35007PR2FvFacile.getMock() ,802)),CrmProperties.getProperty("crm.services.temp.path"), "From35007PR2FvFacile.pdf");
         //Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From35007PU2FvFacile.getMock() ,802)),CrmProperties.getProperty("crm.services.temp.path"), "From35007PU2FvFacile.pdf");

        } catch (TrasformazioneException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
