package com.fideuram.crm.stampe.engine.modello;

import com.fideuram.puc.service.impl.DatiTrasformazionePolizzaVO;
import com.thoughtworks.xstream.XStream;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by
 * User: logan
 * Date: 14/06/11
 * Time: 10.58
 */
public class Trasformazione {


    private  DatiTrasformazionePolizzaVO  datiTrasformazionePolizzaVO;

        /**
         * @return String
         */
        public String toXml() {
            XStream xstream = new XStreamUtils().readXStream();

            xstream.alias("model", Trasformazione.class);
            xstream.alias("datiTrasformazionePolizzaVO", com.fideuram.puc.service.impl.DatiTrasformazionePolizzaVO.class);

            String xml = xstream.toXML(this);
            return xml;
        }

       /**
         * @param xml
         * @return Map
         */
        public static Map<String, Object> fromXml(String xml) {
            XStream xstream = new XStreamUtils().readXStream();
            xstream.alias("model", Trasformazione.class);
            xstream.alias("datiTrasformazionePolizzaVO", com.fideuram.puc.service.impl.DatiTrasformazionePolizzaVO.class);

            Trasformazione modello = (Trasformazione) xstream.fromXML(xml);

            Map<String, Object> map = new HashMap<String, Object>();

            map.put("datiTrasformazionePolizzaVO", modello.getDatiTrasformazionePolizzaVO());
            return map;
        }


    public DatiTrasformazionePolizzaVO getDatiTrasformazionePolizzaVO() {
        return datiTrasformazionePolizzaVO;
    }

    public void setDatiTrasformazionePolizzaVO(DatiTrasformazionePolizzaVO datiTrasformazionePolizzaVO) {
        this.datiTrasformazionePolizzaVO = datiTrasformazionePolizzaVO;
    }
}
