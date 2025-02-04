package com.fideuram.crm.stampe.interfacce;

import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.puc.service.impl.OpzioniRamo3InputVO;

import java.util.Map;

/**
 * Created by
 * User: logan
 * Date: 12/12/11
 * Time: 8.33
 */
public interface IComunicazioneDatiInputManager {
    public Map getValoriDiInputFromDomanda(DomandaVO domandaVO);
    public OpzioniRamo3InputVO getOpzioniRamo3InputVO(DomandaVO domandaVO, Long nPolizza);
}
