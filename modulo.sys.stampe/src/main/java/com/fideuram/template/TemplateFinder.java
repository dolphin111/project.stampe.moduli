
package com.fideuram.template;

import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.template.manager.TemplateManager;
import com.fideuram.utils.LoggingUtils;

import java.nio.charset.Charset;

/**
 * Created by
 * User: logan
 * Date: 25/09/12
 * Time: 12.11
 */
public class TemplateFinder {
    public static byte[] getTemplate(String template) throws TemplateLoaderExcepion {
        LoggingUtils.debug("RICHIESTO IL SEGUENTE TEMPLATE:         " + template);
        return new TemplateManager().getTemplateByNome(template);
    }
}
