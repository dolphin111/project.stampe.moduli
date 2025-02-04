package com.fideuram.crm.stampe.engine.dataLoader;

import com.fideuram.crm.stampe.engine.modello.bean.Polizza;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.puc.service.impl.AvvisidiScadenzaRamoIIIVO;
import com.fideuram.puc.service.impl.PolizzaVO;
import com.fideuram.utils.LoggingUtils;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;

// Referenced classes of package com.fideuram.crm.stampe.engine.dataLoader:
//            InfoPolizza, Inseminatore

public class AvvisiLoader
{

    public AvvisiLoader()
    {
    }

    public HashMap populateAvvisi(String numeroPolizza)
        throws DocGeneratorException
    {
        HashMap map = new HashMap();
        Polizza polizza = new Polizza();
        polizza.setId(numeroPolizza);
        InfoPolizza localizzatore = new InfoPolizza();
        PolizzaVO _polizzaVo = localizzatore.getPolizzaByPolizza(new Long(numeroPolizza));
        polizza = Inseminatore.mashUpPolizza(polizza, _polizzaVo);
        SimpleDateFormat dateFormat = null;
        dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        long startTimeMillisStart = System.currentTimeMillis();
        Date startDateStart = new Date(startTimeMillisStart);
        LoggingUtils.debug((new StringBuilder("  INIZIO chiamata al motore RAMO 3      -> ")).append(dateFormat.format(startDateStart)).append("\n").toString());
        AvvisidiScadenzaRamoIIIVO vo = localizzatore.opzioniAvvisi(polizza.getId());
        long startTimeMillisEnd = System.currentTimeMillis();
        Date startDateEnd = new Date(startTimeMillisEnd);
        LoggingUtils.debug((new StringBuilder("  FINE chiamata al motore RAMO 3      -> ")).append(dateFormat.format(startDateEnd)).append("\n").toString());
        try
        {
            polizza = Inseminatore.mashUpAvvisi(vo, polizza);
        }
        catch(InvocationTargetException e)
        {
            e.printStackTrace();
        }
        catch(IllegalAccessException e)
        {
            e.printStackTrace();
        }
        map.put("polizza", polizza);
        return map;
    }
}