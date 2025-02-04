package com.fideuram.dao.metodiPagamento;

import java.io.File;
import java.io.IOException;

import com.fideuram.exception.CollettiveFileDataReadException;
import com.fideuram.modello.metodiPagamento.ListMetodiPagamento;

public class MetodiPagamentoDAO {

	
	public ListMetodiPagamento getMetodiPagamento(File file) throws CollettiveFileDataReadException, IOException {
        return MetodiPagamentoParseCsv.parseMetodiPagamento(file.getAbsolutePath());
    }

}
