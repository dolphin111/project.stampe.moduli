import com.fideuram.stampe.servizi.Facade;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 16/06/14
 * Time: 8.51
 * To change this template use File | Settings | File Templates.
 */
public class AssegniGeneratiTest {
    public static void main(String args[]){
        Facade facade = new Facade();
        List<String> listaFileAssegniGenerati = facade.listaFile("assegniArchiviare");
        String listaFile[]=new String[listaFileAssegniGenerati.size()];
        for(int i=0; i<listaFileAssegniGenerati.size();i++){
            listaFile[i]=listaFileAssegniGenerati.get(i);
        }

        facade.archiviaForStoricoAssegni(listaFile);
    }
}
