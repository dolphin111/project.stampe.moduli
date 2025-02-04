package com.fideuram.dao.tdp;

import java.io.File;
import java.io.IOException;

import com.fideuram.exception.CollettiveFileDataReadException;
import com.fideuram.modello.tdp.Collettive;

/**
 * Created by IntelliJ IDEA.
 * User: logan
 * Date: 09/05/13
 * Time: 9.28
 */
public class TdpDao {
    /**
     * Questo metodo restituisce lo ScartoTitoloDiPerfezionamento a partire dal file in formato CSV
     *
     *
     * @param file
     * @return
     * @throws CollettiveFileDataReadException
     */
    public Collettive getScartoTDP(File file) throws CollettiveFileDataReadException,IOException  {
        return TdpParserCsv.parseScartoTDP(file.getAbsolutePath());
    }

    public Collettive getRiepilogoTDP(File file) throws CollettiveFileDataReadException, IOException {
        return TdpParserCsv.parseRiepilogoTDP(file.getAbsolutePath());
    }




}
