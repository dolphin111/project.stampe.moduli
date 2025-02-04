package com.fideuram.crm.stampe.model;

import com.fideuram.utils.DateUtils;
import com.fideuram.utils.LoggingUtils;

import java.text.ParseException;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: logan
 * Date: 23/10/13
 * Time: 10.22
 */
public class Differimento {
    private String dataInizio;
    private String dataFine;
    private boolean maggiore10anni;

    public void setDataInizio(String dataInizio) {
        this.dataInizio = dataInizio;
    }

    public void setDataFine(String dataFine) {
        this.dataFine = dataFine;
    }   

    public String getDataInizio() {
		return dataInizio;
	}

	public String getDataFine() {
		return dataFine;
	}

	public boolean isMaggioreAnni(int anni) throws ParseException {
        try {

            boolean b= DateUtils.isDateDiffMajorOfQuanto(dataInizio, dataFine, "dd-MM-yyyy", Calendar.YEAR, anni);
            LoggingUtils.info("differimento > 10 anni " + b);
            return b;

        } catch (ParseException e) {
            LoggingUtils.error(e);
            throw e;
        }
    }
    
    public boolean isMinoreAnni(int anni) throws ParseException {
        try {
            return DateUtils.isDateDiffMinorEqOfQuanto(dataInizio, dataFine, "dd-MM-yyyy", Calendar.YEAR, anni);
        } catch (ParseException e) {
            LoggingUtils.error(e);
            throw e;
        }
    }
}
