package com.fideuram.chart.mock.prospetti.fvInsieme;

import com.fideuram.chart.lab.ConfigurationGraph;
import com.fideuram.chart.lab.bar.IstogrammaEngine;
import com.fideuram.chart.mock.MockBase;
import com.fideuram.chart.mock.prospetti.fvInsieme.barra.*;
import com.fideuram.config.CrmProperties;
import com.fideuram.utils.LoggingUtils;

import java.io.IOException;

/**
 * User: V801068
 * Date: 04/03/15
 * Time: 10.14
 */
public class StampaSteBarre {
    public static void main(String args[]){
        ConfigurationGraph cb= MockBase.getConfigurationBar(false);
        try {
            new IstogrammaEngine().generate(LG01UD_B_D.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","LG01UA_B_D",cb);
            new IstogrammaEngine().generate(LG01RA_B_D.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","LG01RA_B_D",cb);
            new IstogrammaEngine().generate(LG02UD_B_D.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","LG02UA_B_D",cb);
            new IstogrammaEngine().generate(LG02RA_B_D.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","LG02RA_B_D",cb);
            new IstogrammaEngine().generate(LG03UD_B_D.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","LG03UA_B_D",cb);
            new IstogrammaEngine().generate(LG03RA_B_D.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","LG03RA_B_D",cb);
            new IstogrammaEngine().generate(LG04UD_B_D.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","LG04UA_B_D",cb);
            new IstogrammaEngine().generate(LG04RA_B_D.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","LG04RA_B_D",cb);
            new IstogrammaEngine().generate(CL01UD_B_D.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","CL01UA_B_D",cb);
            new IstogrammaEngine().generate(CL01RA_B_D.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","CL01RA_B_D",cb);
            new IstogrammaEngine().generate(CL02UD_B_D.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","CL02UA_B_D",cb);
            new IstogrammaEngine().generate(CL02RA_B_D.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","CL02RA_B_D",cb);
            new IstogrammaEngine().generate(CL03UD_B_D.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","CL03UA_B_D",cb);
            new IstogrammaEngine().generate(CL03RA_B_D.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","CL03RA_B_D",cb);
            new IstogrammaEngine().generate(CL04UD_B_D.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","CL04UA_B_D",cb);
            new IstogrammaEngine().generate(CL04RA_B_D.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","CL04RA_B_D",cb);
            new IstogrammaEngine().generate(CL05UD_B_D.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","CL05UA_B_D",cb);
            new IstogrammaEngine().generate(CL05RA_B_D.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","CL05RA_B_D",cb);
            new IstogrammaEngine().generate(CL06UD_B_D.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","CL06UA_B_D",cb);
            new IstogrammaEngine().generate(CL06RA_B_D.getMock(), CrmProperties.getProperty("crm.services.temp.path")+"\\GRAFICI_INSIEME\\","CL06RA_B_D",cb);
        } catch (IOException e) {
            LoggingUtils.error(e);
        }
    }
}
