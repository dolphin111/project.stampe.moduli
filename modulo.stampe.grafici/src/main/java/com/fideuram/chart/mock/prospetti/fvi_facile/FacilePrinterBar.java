package com.fideuram.chart.mock.prospetti.fvi_facile;

import com.fideuram.chart.lab.ConfigurationGraph;
import com.fideuram.chart.lab.bar.IstogrammaEngine;
import com.fideuram.chart.mock.MockBase;
import com.fideuram.chart.mock.prospetti.grafici2015.barra.*;
import com.fideuram.chart.mock.prospetti.grafici2015.barra.CL03RA_B;
import com.fideuram.config.CrmProperties;
import com.fideuram.utils.LoggingUtils;

import java.io.IOException;

/**
 * User: V801068
 * Date: 02/03/15
 * Time: 15.44
 */
public class FacilePrinterBar {
    public static void main(String args[]){
        ConfigurationGraph cb= MockBase.getConfigurationBar(false);
        try {

            new IstogrammaEngine().generate(LG01UA_B.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_FACILE\\","LG01UA_B",cb);
            new IstogrammaEngine().generate(LG01RA_B.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_FACILE\\","LG01RA_B",cb);
            new IstogrammaEngine().generate(LG02UA_B.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_FACILE\\","LG02UA_B",cb);
            new IstogrammaEngine().generate(LG02RA_B.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_FACILE\\","LG02RA_B",cb);
            new IstogrammaEngine().generate(LG03UA_B.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_FACILE\\","LG03UA_B",cb);
            new IstogrammaEngine().generate(LG03RA_B.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_FACILE\\","LG03RA_B",cb);
            new IstogrammaEngine().generate(LG04UA_B.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_FACILE\\","LG04UA_B",cb);
            new IstogrammaEngine().generate(LG04RA_B.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_FACILE\\","LG04RA_B",cb);
            new IstogrammaEngine().generate(CL01UA_B.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_FACILE\\","CL01UA_B",cb);
            new IstogrammaEngine().generate(CL01RA_B.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_FACILE\\","CL01RA_B",cb);
            new IstogrammaEngine().generate(CL02UA_B.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_FACILE\\","CL02UA_B",cb);
            new IstogrammaEngine().generate(CL02RA_B.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_FACILE\\","CL02RA_B",cb);
            new IstogrammaEngine().generate(CL03UA_B.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_FACILE\\","CL03UA_B",cb);
            new IstogrammaEngine().generate(CL03RA_B.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_FACILE\\","CL03RA_B",cb);

        } catch (IOException e) {
            LoggingUtils.error(e);
        }
    }
}
