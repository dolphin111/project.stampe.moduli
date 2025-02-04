package com.fideuram.chart.mock.prospetti.fvi_4x4;

import com.fideuram.chart.lab.ConfigurationGraph;
import com.fideuram.chart.lab.bar.IstogrammaEngine;
import com.fideuram.chart.mock.MockBase;
import com.fideuram.chart.mock.prospetti.grafici2015.barra.*;
import com.fideuram.config.CrmProperties;
import com.fideuram.utils.LoggingUtils;

import java.io.IOException;

/**
 * User: V801068
 * Date: 03/03/15
 * Time: 10.22
 */
public class Premium44Bar {
    public static void main(String args[]){
        ConfigurationGraph cb= MockBase.getConfigurationBar(false);
        try {

            new IstogrammaEngine().generate(LG01_B.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_PREMIUM44\\","LG01_B",cb);
            new IstogrammaEngine().generate(LG02_B.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_PREMIUM44\\","LG02_B",cb);
            new IstogrammaEngine().generate(LG03_B.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_PREMIUM44\\","LG03_B",cb);
            new IstogrammaEngine().generate(LG04_B.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_PREMIUM44\\","LG04_B",cb);
            new IstogrammaEngine().generate(CL01_B.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_PREMIUM44\\","CL01_B",cb);
            new IstogrammaEngine().generate(CL02_B.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_PREMIUM44\\","CL02_B",cb);
            new IstogrammaEngine().generate(CL03_B.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_PREMIUM44\\","CL03_B",cb);
            new IstogrammaEngine().generate(CL04_B.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_PREMIUM44\\","CL04_B",cb);

        } catch (IOException e) {
            LoggingUtils.error(e);
        }
    }
}
