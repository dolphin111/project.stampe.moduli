package com.fideuram.dao.elenchiufficiali;

import java.io.File;
import java.io.IOException;

import com.fideuram.exception.CollettiveFileDataReadException;
import com.fideuram.modello.elenchiufficiali.ElenchiUfficiali;

public class ElenchiUfficialiDAO {

	
	public ElenchiUfficiali getElenchiUfficiali(File file) throws CollettiveFileDataReadException, IOException {
        return ElenchiUfficialiParseCsv.parseElenchiUfficiali(file.getAbsolutePath());
    }

}
