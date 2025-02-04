package com.fideuram.factory;

import com.fideuram.costanti.TemplateSystem;
import com.fideuram.template.manager.TemplateDBLoader;
import com.fideuram.template.manager.TemplateFSLoader;
import com.fideuram.template.manager.TemplateLoader;
import com.fideuram.config.CrmProperties;

/**
 * Created by IntelliJ IDEA.
 * User: logan
 * Date: 06/02/12
 * Time: 17.12
 */
public class TemplateLoaderFactory {
     public static TemplateLoader getLoader(){
         String _sistema = CrmProperties.getProperty(TemplateSystem.TEMPLATE_SYSTEM_STORAGE);
         switch (new Integer(_sistema)){
             case(0):
                 return new TemplateFSLoader();
             case(1):
                 return new TemplateDBLoader();
             default:
                 return new TemplateFSLoader();
         }
     }

}
