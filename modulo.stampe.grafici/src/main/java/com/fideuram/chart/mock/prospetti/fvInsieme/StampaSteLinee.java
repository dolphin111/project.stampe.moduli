package com.fideuram.chart.mock.prospetti.fvInsieme;

import com.fideuram.chart.exception.GraphException;
import com.fideuram.chart.lab.ConfigurationGraph;
import com.fideuram.chart.lab.line.LineaMonthEngine;
import com.fideuram.chart.mock.prospetti.fvInsieme.linea.*;
import com.fideuram.chart.mock.prospetti.grafici2015.linea.*;
import com.fideuram.config.CrmProperties;
import com.fideuram.utils.LoggingUtils;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 04/03/15
 * Time: 8.11
 * To change this template use File | Settings | File Templates.
 */
public class StampaSteLinee {
    public static void main(String args[]){
        ConfigurationGraph cb= BMKCORE15_L.getConfigurationLine(false);
        try {
            new LineaMonthEngine().generate(LG01RA_L_D.getMockSommavillaFvInsieme("LG01RA"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","LG01RA_L_D",cb);
            new LineaMonthEngine().generate(LG01UD_L_D.getMockSommavillaFvInsieme("LG01UD"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","LG01UD_L_D",cb);
            new LineaMonthEngine().generate(LG02RA_L_D.getMockSommavillaFvInsieme("LG02RA"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","LG02RA_L_D",cb);
            new LineaMonthEngine().generate(LG02UD_L_D.getMockSommavillaFvInsieme("LG02UD"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","LG02UD_L_D",cb);
            new LineaMonthEngine().generate(LG03RA_L_D.getMockSommavillaFvInsieme("LG03RA"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","LG03RA_L_D",cb);
            new LineaMonthEngine().generate(LG03UD_L_D.getMockSommavillaFvInsieme("LG03UD"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","LG03UD_L_D",cb);
            new LineaMonthEngine().generate(LG04RA_L_D.getMockSommavillaFvInsieme("LG04RA"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","LG04RA_L_D",cb);
            new LineaMonthEngine().generate(LG04UD_L_D.getMockSommavillaFvInsieme("LG04UD"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","LG04UD_L_D",cb);
            new LineaMonthEngine().generate(CL01RA_L_D.getMockSommavillaFvInsieme("CL01RA"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","CL01RA_L_D",cb);
            new LineaMonthEngine().generate(CL01UD_L_D.getMockSommavillaFvInsieme("CL01UD"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","CL01UD_L_D",cb);
            new LineaMonthEngine().generate(CL02RA_L_D.getMockSommavillaFvInsieme("CL02RA"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","CL02RA_L_D",cb);
            new LineaMonthEngine().generate(CL02UD_L_D.getMockSommavillaFvInsieme("CL02UD"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","CL02UD_L_D",cb);
            new LineaMonthEngine().generate(CL03RA_L_D.getMockSommavillaFvInsieme("CL03RA"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","CL03RA_L_D",cb);
            new LineaMonthEngine().generate(CL03UD_L_D.getMockSommavillaFvInsieme("CL03UD"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","CL03UD_L_D",cb);
            new LineaMonthEngine().generate(CL04RA_L_D.getMockSommavillaFvInsieme("CL04RA"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","CL04RA_L_D",cb);
            new LineaMonthEngine().generate(CL04UD_L_D.getMockSommavillaFvInsieme("CL04UD"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","CL04UD_L_D",cb);
            new LineaMonthEngine().generate(CL05RA_L_D.getMockSommavillaFvInsieme("CL05RA"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","CL05RA_L_D",cb);
            new LineaMonthEngine().generate(CL05UD_L_D.getMockSommavillaFvInsieme("CL05UD"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","CL05UD_L_D",cb);
            new LineaMonthEngine().generate(CL06RA_L_D.getMockSommavillaFvInsieme("CL06RA"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","CL06RA_L_D",cb);
            new LineaMonthEngine().generate(CL06UD_L_D.getMockSommavillaFvInsieme("CL06UD"),    CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","CL06UD_L_D",cb);

        } catch (IOException e) {
            LoggingUtils.error(e);
        } catch (GraphException e) {
            LoggingUtils.error(e);
        }
    }
}
