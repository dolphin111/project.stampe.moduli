package com.fideuram.dao.vgitext;

import java.io.File;
import java.io.IOException;

import com.fideuram.exception.CollettiveFileDataReadException;
import com.fideuram.modello.vgitext.Collettiva;

public class VgITextDao {

	
	  public Collettiva getCollettivaIText(File filePathInput) throws CollettiveFileDataReadException,IOException  {
	        return VgITextParseTxt.getCollettivaIText(filePathInput.getAbsolutePath());
	    }
}
