package com.fideuram.processo.rendiconti.ante;

import com.fideuram.exception.RendicontiException;
import com.fideuram.jaxb.Converter;
import com.fideuram.processo.rendiconti.ProcessoGenericoRendiconti;
import com.fideuram.stampe.modello.rendiconti.mock.ante551.Ante551FaoMock;
import com.fideuram.stampe.modello.rendiconti.prodotto.ante551.Fao;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

/**
 * Created with
 * User: V801068
 * Date: 10/01/14
 * Time: 15.40
 */
public class ProcessoAnte551Fao extends ProcessoGenericoRendiconti {
    public ProcessoAnte551Fao() {
        super();
    }

    public byte[] stampa(Fao fao) throws RendicontiException {
        normativaProdottoAllegato=fao;
        return start("RendicontoAnte551Fao.odt",false);
    }

    public static void main(String arga[]) throws RendicontiException, JAXBException, IOException {
        //String xml=Converter.objectToXml(Ante551FaoMock.getFaoMock());
        try {
            Fao fao= (Fao)Converter.xml2Object(new Fao(), getxml());
            new ProcessoAnte551Fao().stampa(fao);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

      //  new ProcessoAnte551Fao().stampa(Ante551FaoMock.getFaoMock());
    }



     public static String getxml(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<Fao>\n" +
                "    <dataRiferimento>2014-02-06T12:14:13.662+01:00</dataRiferimento>\n" +
                "    <fondi>\n" +
                "        <codiceFondo>AO001</codiceFondo>\n" +
                "        <descrizioneFondo>F.A.O. 1               </descrizioneFondo>\n" +
                "        <volatilitaProspettica/>\n" +
                "        <rendimentoAnnuo>\n" +
                "            <anno>2012</anno>\n" +
                "        </rendimentoAnnuo>\n" +
                "    </fondi>\n" +
                "    <fondi>\n" +
                "        <codiceFondo>AO002</codiceFondo>\n" +
                "        <descrizioneFondo>F.A.O. 2</descrizioneFondo>\n" +
                "        <volatilitaProspettica>\n" +
                "            <percVolatilitaProspettica>From 0,0160 To 0,0399</percVolatilitaProspettica>\n" +
                "            <percVolatilitaEffettiva>2.56</percVolatilitaEffettiva>\n" +
                "        </volatilitaProspettica>\n" +
                "        <rendimentoAnnuo>\n" +
                "            <anno>2003</anno>\n" +
                "            <percBM>1.65</percBM>\n" +
                "        </rendimentoAnnuo>\n" +
                "        <rendimentoAnnuo>\n" +
                "            <anno>2004</anno>\n" +
                "            <percBM>-13.62</percBM>\n" +
                "        </rendimentoAnnuo>\n" +
                "        <rendimentoAnnuo>\n" +
                "            <anno>2005</anno>\n" +
                "            <percBM>6.25</percBM>\n" +
                "        </rendimentoAnnuo>\n" +
                "        <rendimentoAnnuo>\n" +
                "            <anno>2006</anno>\n" +
                "            <percFondo>0.14</percFondo>\n" +
                "            <percBM>0.05</percBM>\n" +
                "        </rendimentoAnnuo>\n" +
                "        <rendimentoAnnuo>\n" +
                "            <anno>2007</anno>\n" +
                "            <percFondo>0.31</percFondo>\n" +
                "            <percBM>1.56</percBM>\n" +
                "        </rendimentoAnnuo>\n" +
                "        <rendimentoAnnuo>\n" +
                "            <anno>2008</anno>\n" +
                "            <percFondo>-0.71</percFondo>\n" +
                "            <percBM>5.65</percBM>\n" +
                "        </rendimentoAnnuo>\n" +
                "        <rendimentoAnnuo>\n" +
                "            <anno>2009</anno>\n" +
                "            <percFondo>4.93</percFondo>\n" +
                "            <percBM>4.83</percBM>\n" +
                "        </rendimentoAnnuo>\n" +
                "        <rendimentoAnnuo>\n" +
                "            <anno>2010</anno>\n" +
                "            <percFondo>2.31</percFondo>\n" +
                "            <percBM>5.69</percBM>\n" +
                "        </rendimentoAnnuo>\n" +
                "        <rendimentoAnnuo>\n" +
                "            <anno>2011</anno>\n" +
                "            <percFondo>-0.69</percFondo>\n" +
                "            <percBM>3.67</percBM>\n" +
                "        </rendimentoAnnuo>\n" +
                "        <rendimentoAnnuo>\n" +
                "            <anno>2012</anno>\n" +
                "            <percFondo>4.42</percFondo>\n" +
                "            <percBM>4.6</percBM>\n" +
                "        </rendimentoAnnuo>\n" +
                "    </fondi>\n" +
                "    <inflazione/>\n" +
                "    <hasUltimoAnnoElement>false</hasUltimoAnnoElement>\n" +
                "    <hasBiennioElemnt>false</hasBiennioElemnt>\n" +
                "    <hasTriennioElemnt>false</hasTriennioElemnt>\n" +
                "    <hasQuinquennioElemnt>false</hasQuinquennioElemnt>\n" +
                "    <hasDecennioElemnt>false</hasDecennioElemnt>\n" +
                "</Fao>\n" +
                "\n";
    }
}

