package com.fideuram.chart.mock.prospetti.fvi_4x4;

import com.fideuram.chart.exception.GraphException;
import com.fideuram.chart.lab.ConfigurationGraph;
import com.fideuram.chart.lab.line.LineaMonthEngine;
import com.fideuram.chart.mock.prospetti.grafici2015.linea.*;
import com.fideuram.config.CrmProperties;
import com.fideuram.utils.LoggingUtils;

import java.io.IOException;

/**
 * User: V801068
 * Date: 03/03/15
 * Time: 8.40
 */
public class Premium44Line {
    public static void main(String args[]){
        ConfigurationGraph cb= BMKCORE15_L.getConfigurationLine(false);
        try {
            new LineaMonthEngine().generate(LG01_L.getMockSommavillaFvInsieme("LG01"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_PREMIUM44\\","LG01_L",cb);
            new LineaMonthEngine().generate(LG02_L.getMockSommavillaFvInsieme("LG02"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_PREMIUM44\\","LG02_L",cb);
            new LineaMonthEngine().generate(LG03_L.getMockSommavillaFvInsieme("LG03"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_PREMIUM44\\","LG03_L",cb);
            new LineaMonthEngine().generate(LG04_L.getMockSommavillaFvInsieme("LG04"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_PREMIUM44\\","LG04_L",cb);
            new LineaMonthEngine().generate(CL01_L.getMockSommavillaFvInsieme("CL01"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_PREMIUM44\\","CL01_L",cb);
            new LineaMonthEngine().generate(CL02_L.getMockSommavillaFvInsieme("CL02"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_PREMIUM44\\","CL02_L",cb);
            new LineaMonthEngine().generate(CL03_L.getMockSommavillaFvInsieme("CL03"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_PREMIUM44\\","CL03_L",cb);
            new LineaMonthEngine().generate(CL04_L.getMockSommavillaFvInsieme("CL04"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_PREMIUM44\\","CL04_L",cb);


        } catch (IOException e) {
            LoggingUtils.error(e);
        } catch (GraphException e) {
            LoggingUtils.error(e);
        }
    }
}
