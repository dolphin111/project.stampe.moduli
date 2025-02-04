package com.fideuram.template.manager;

import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.factory.TemplateLoaderFactory;

/**
 * Created by 
 * User: logan
 * Date: 06/02/12
 * Time: 17.20
 */
public class TemplateManager {

    public byte[] getTemplateByNome(String nome) throws TemplateLoaderExcepion {
        TemplateLoader tl = TemplateLoaderFactory.getLoader();
        return tl.getTemplateByNome(nome);
    }
}
