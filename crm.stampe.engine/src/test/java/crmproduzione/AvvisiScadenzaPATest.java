package crmproduzione;

import com.fideuram.crm.stampe.engine.CrmStampeService;

/**
 * Created by V801068 on 07/05/14.
 */
public class AvvisiScadenzaPATest {
    public  static void main(String args[]) {
       /*
       per avere le comunicazioniId appartenenti a questo caso:
       select * from Comunicazione_Domanda where DomandaID in (select ID from Domanda where DescrizioneDomandaID=860)
       */

       //GAMBA
        new CrmStampeService().elaboraMessaggio(8200037);   //Polizza Ramo III   ANNI CERTEZZA 5     TAB CERTEZZA 1 COLONNE
       // new CrmStampeService().elaboraMessaggio(8209156);   //Polizza Ramo I     ANNI CERTEZZA 5     TAB CERTEZZA 1 COLONNE
       // new CrmStampeService().elaboraMessaggio(8226788);   //Polizza Ramo I     ANNI CERTEZZA 5 -10 TAB CERTEZZA 2 COLONNE

        //PRODUZIONE
       //new CrmStampeService().elaboraMessaggio(10136927); //Polizza Ramo III certezza 5 Anni
       //new CrmStampeService().elaboraMessaggio(10294166); //Polizza Ramo III certezza 5 Anni  #TCK 820 #la Tabella rendita con Opzione di Certezza esce 2 volte
       //new CrmStampeService().elaboraMessaggio(10300395); //Polizza Ramo III certezza 17Anni  #TCK 820 #Non Esce la Tabella rendita con Opzione di Certezza
       //new CrmStampeService().elaboraMessaggio(9978431);  //Polizza Ramo III certezza 2 e 5 Anni  deve produrre una tabella con una sola colonna di certezza
    }
}
