package com.fideuram.chart.mock.prospetti.fvi_facile;

import com.fideuram.chart.exception.GraphException;
import com.fideuram.chart.lab.ConfigurationGraph;
import com.fideuram.chart.lab.line.LineaMonthEngine;
import com.fideuram.chart.mock.prospetti.grafici2015.linea.*;
import com.fideuram.config.CrmProperties;
import com.fideuram.utils.LoggingUtils;

import java.io.IOException;

/**
 * Created
 * User: v801068
 * Date: 28/02/14
 * Time: 20.48
 */
public class FacilePrinterLine {
    public static void main(String args[]){
        ConfigurationGraph cb= BMKCORE15_L.getConfigurationLine(false);
        try {
            new LineaMonthEngine().generate(LG01RA_L.getMockSommavillaFvInsieme("LG01RA"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_FACILE\\","LG01RA_L",cb);
            new LineaMonthEngine().generate(LG01UA_L.getMockSommavillaFvInsieme("LG01UA"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_FACILE\\","LG01UA_L",cb);
            new LineaMonthEngine().generate(LG02RA_L.getMockSommavillaFvInsieme("LG02RA"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_FACILE\\","LG02RA_L",cb);
            new LineaMonthEngine().generate(LG02UA_L.getMockSommavillaFvInsieme("LG02UA"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_FACILE\\","LG02UA_L",cb);
            new LineaMonthEngine().generate(LG03RA_L.getMockSommavillaFvInsieme("LG03RA"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_FACILE\\","LG03RA_L",cb);
            new LineaMonthEngine().generate(LG03UA_L.getMockSommavillaFvInsieme("LG03UA"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_FACILE\\","LG03UA_L",cb);
            new LineaMonthEngine().generate(LG04RA_L.getMockSommavillaFvInsieme("LG04RA"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_FACILE\\","LG04RA_L",cb);
            new LineaMonthEngine().generate(LG04UA_L.getMockSommavillaFvInsieme("LG04UA"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_FACILE\\","LG04UA_L",cb);
            new LineaMonthEngine().generate(CL01RA_L.getMockSommavillaFvInsieme("CL01RA"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_FACILE\\","CL01RA_L",cb);
            new LineaMonthEngine().generate(CL01UA_L.getMockSommavillaFvInsieme("CL01UA"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_FACILE\\","CL01UA_L",cb);
            new LineaMonthEngine().generate(CL02RA_L.getMockSommavillaFvInsieme("CL02RA"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_FACILE\\","CL02RA_L",cb);
            new LineaMonthEngine().generate(CL02UA_L.getMockSommavillaFvInsieme("CL02UA"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_FACILE\\","CL02UA_L",cb);
            new LineaMonthEngine().generate(CL03RA_L.getMockSommavillaFvInsieme("CL03RA"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_FACILE\\","CL03RA_L",cb);
            new LineaMonthEngine().generate(CL03UA_L.getMockSommavillaFvInsieme("CL03UA"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_FACILE\\","CL03UA_L",cb);

        } catch (IOException e) {
            LoggingUtils.error(e);
        } catch (GraphException e) {
            LoggingUtils.error(e);
        }
    }
}
