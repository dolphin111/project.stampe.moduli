package com.fideuram.template.manager;

import com.fideuram.exception.TemplateLoaderExcepion;

/**
 * Created by
 * User: logan
 * Date: 06/02/12
 * Time: 16.12
 */
public abstract class TemplateLoader {
       public abstract byte[] getTemplateByNome(String template) throws TemplateLoaderExcepion;
}
