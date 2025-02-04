package com.fideuram.crm.stampe.manager;

import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.crm.stampe.interfacce.IComunicazioneDatiInputManager;
import com.fideuram.puc.service.impl.OpzioniRamo3InputVO;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by
 * User: logan
 * Date: 12/12/11
 * Time: 8.31
 */
public class ComunicazioneDatiInputManager implements IComunicazioneDatiInputManager {


    @Override
    public Map getValoriDiInputFromDomanda(DomandaVO domandaVO) {
        return setMap(domandaVO);
    }

    @Override
    public OpzioniRamo3InputVO getOpzioniRamo3InputVO(DomandaVO domandaVO, Long nPolizza) {
        OpzioniRamo3InputVO _valoriInput=new OpzioniRamo3InputVO();
        _valoriInput.setNumeroPolizza(nPolizza);
        Map m = setMap(domandaVO);

        String _percRev=(m.get("setPercentualeReversibilita2Testa")!=null ? m.get("setPercentualeReversibilita2Testa").toString():"");
        if((_percRev != null)  && !_percRev.trim().equals("") )
          _valoriInput.setPercentualeReversibilita2Testa( _percRev.contains("%")? new Integer(_percRev.substring(0,_percRev.indexOf("%")).trim()):new Integer(_percRev));//Percentuale della prima TESTA di moro

        String data=(m.get("setDataNascita2Testa")!=null? m.get("setDataNascita2Testa").toString() : "");
        if(null!=data && !data.trim().equals(""))    {
          if (data.indexOf("T") > 0 )
              _valoriInput.setDataNascita2Testa(data.substring(0,data.indexOf("T")));                                       //Data Nascita della seconda TESTA di moro
          else
              _valoriInput.setDataNascita2Testa(data);                                       //Data Nascita della seconda TESTA di moro
        }

        
        if(m.get("setCertezza1") != null)
        	_valoriInput.getListaCertezze().add(m.get("setCertezza1").toString());                                          //Certezza in anni n 1

        if(m.containsKey("setSesso2Testa"))
            _valoriInput.setSesso2Testa(m.get("setSesso2Testa").toString().toUpperCase());
        if(m.containsKey("setCertezza2"))
            _valoriInput.getListaCertezze().add(m.get("setCertezza2").toString());
        if(m.containsKey("setCertezza3"))
            _valoriInput.getListaCertezze().add(m.get("setCertezza3").toString());
        if(m.containsKey("setCertezza4"))
            _valoriInput.getListaCertezze().add(m.get("setCertezza4").toString());
        return _valoriInput;
    }


    private Map setMap(DomandaVO domanda) {
        Map _m = new HashMap();
        for (int i = 0; i < domanda.getValoriInput().size(); i++) {
            int id_input = domanda.getValoriInput().get(i).getDatoInput().getId();
            switch (id_input) {
                case 26:
                    _m.put("setPercentualeReversibilita1Testa", domanda.getValoriInput().get(i).getValore());
                    break;
                case 27:
                    _m.put("setDataNascita1Testa", domanda.getValoriInput().get(i).getValore());
                    break;
                case 28:
                    _m.put("setSesso1Testa", domanda.getValoriInput().get(i).getValore().toUpperCase());
                    break;
                case 29:
                    _m.put("setPercentualeReversibilita2Testa", domanda.getValoriInput().get(i).getValore());
                    break;
                case 30:
                    _m.put("setDataNascita2Testa", domanda.getValoriInput().get(i).getValore());
                    break;
                case 32:
                    _m.put("setCertezza1", domanda.getValoriInput().get(i).getValore());                    
                    break;
                case 33:
                    if(!domanda.getValoriInput().get(i).getValore().trim().equals(""))
                        _m.put("setCertezza2", domanda.getValoriInput().get(i).getValore());
                    break;
                case 34:
                    if(!domanda.getValoriInput().get(i).getValore().trim().equals(""))
                        _m.put("setCertezza3", domanda.getValoriInput().get(i).getValore());
                    break;
                case 35:
                    if(!domanda.getValoriInput().get(i).getValore().trim().equals(""))
                        _m.put("setCertezza4", domanda.getValoriInput().get(i).getValore());
                    break;
                case 31:
                    _m.put("setSesso2Testa", domanda.getValoriInput().get(i).getValore().toUpperCase());
                    break;
            }
        }        
        return _m;
    }
}

