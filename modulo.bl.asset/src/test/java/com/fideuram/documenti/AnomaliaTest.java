package com.fideuram.documenti;

import com.fideuram.exception.AssetException;
import com.fideuram.facade.AssetFacade;
import com.fideuram.iside.IsideResponce;
import com.fideuram.mock.AssetXmlMock;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * User: V801068
 * Date: 14/01/15
 * Time: 14.20
 */
public class AnomaliaTest extends TestCase {
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AnomaliaTest.class );
    }

    public void testGenerazioneDocumento()  {
        try {
            for (int i=0;i<10;i++){
                IsideResponce documento= new AssetFacade().elaboraOdt(getXml() , 0);
                assertNotNull(documento);
                assertTrue(documento.getMimetype().equalsIgnoreCase("text/pdf"));
            }
        } catch (AssetException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getXml(){
        return "<FondoInvestimentoGlobale>\n" +
                "    <idCategoria>2</idCategoria>\n" +
                "    <categoria>DESCRIZIONE</categoria>\n" +
                "    <idNomeFondo>70</idNomeFondo>\n" +
                "    <nome>FUL 2006</nome>\n" +
                "    <anno>1151900</anno>\n" +
                "    <data>02/02/2015</data>\n" +
                "    <fondoInvestimentoAnnuales>\n" +
                "        <compartoAzionis>\n" +
                "            <tipo>Comparto OICR ZeroCoupon</tipo>\n" +
                "            <comparto>ZERO COUPON</comparto>\n" +
                "            <percentuale>74,26</percentuale>\n" +
                "            <valore>0</valore>\n" +
                "            <fondoInvestimento>F.U.L. 2006/2024</fondoInvestimento>\n" +
                "            <subTotalePerc>74,26</subTotalePerc>\n" +
                "            <subTotaleVal>0,00</subTotaleVal>\n" +
                "        </compartoAzionis>\n" +
                "        <compartoAzionis>\n" +
                "            <tipo>Fondi Azionari</tipo>\n" +
                "            <comparto>FF Eq. Europe Growth </comparto>\n" +
                "            <percentuale>1,04</percentuale>\n" +
                "            <valore>0</valore>\n" +
                "            <fondoInvestimento>F.U.L. 2006/2024</fondoInvestimento>\n" +
                "            <subTotalePerc>-1</subTotalePerc>\n" +
                "            <subTotaleVal>-1</subTotaleVal>\n" +
                "        </compartoAzionis>\n" +
                "        <compartoAzionis>\n" +
                "            <tipo></tipo>\n" +
                "            <comparto>FF Eq. Global Emerg. Markets </comparto>\n" +
                "            <percentuale>2,92</percentuale>\n" +
                "            <valore>0</valore>\n" +
                "            <fondoInvestimento></fondoInvestimento>\n" +
                "            <subTotalePerc>-1</subTotalePerc>\n" +
                "            <subTotaleVal>-1</subTotaleVal>\n" +
                "        </compartoAzionis>\n" +
                "        <compartoAzionis>\n" +
                "            <tipo></tipo>\n" +
                "            <comparto>FF Equity USA</comparto>\n" +
                "            <percentuale>6,44</percentuale>\n" +
                "            <valore>0</valore>\n" +
                "            <fondoInvestimento></fondoInvestimento>\n" +
                "            <subTotalePerc>-1</subTotalePerc>\n" +
                "            <subTotaleVal>-1</subTotaleVal>\n" +
                "        </compartoAzionis>\n" +
                "        <compartoAzionis>\n" +
                "            <tipo></tipo>\n" +
                "            <comparto>FF Eq. Europe Value </comparto>\n" +
                "            <percentuale>0,67</percentuale>\n" +
                "            <valore>0</valore>\n" +
                "            <fondoInvestimento></fondoInvestimento>\n" +
                "            <subTotalePerc>-1</subTotalePerc>\n" +
                "            <subTotaleVal>-1</subTotaleVal>\n" +
                "        </compartoAzionis>\n" +
                "        <compartoAzionis>\n" +
                "            <tipo></tipo>\n" +
                "            <comparto>FF Eq. Europe </comparto>\n" +
                "            <percentuale>3,89</percentuale>\n" +
                "            <valore>0</valore>\n" +
                "            <fondoInvestimento></fondoInvestimento>\n" +
                "            <subTotalePerc>-1</subTotalePerc>\n" +
                "            <subTotaleVal>-1</subTotaleVal>\n" +
                "        </compartoAzionis>\n" +
                "        <compartoAzionis>\n" +
                "            <tipo></tipo>\n" +
                "            <comparto>FF Eq. Italy </comparto>\n" +
                "            <percentuale>1,47</percentuale>\n" +
                "            <valore>0</valore>\n" +
                "            <fondoInvestimento></fondoInvestimento>\n" +
                "            <subTotalePerc>-1</subTotalePerc>\n" +
                "            <subTotaleVal>-1</subTotaleVal>\n" +
                "        </compartoAzionis>\n" +
                "        <compartoAzionis>\n" +
                "            <tipo></tipo>\n" +
                "            <comparto>FF Equity Japan</comparto>\n" +
                "            <percentuale>0,86</percentuale>\n" +
                "            <valore>0</valore>\n" +
                "            <fondoInvestimento></fondoInvestimento>\n" +
                "            <subTotalePerc>-1</subTotalePerc>\n" +
                "            <subTotaleVal>-1</subTotaleVal>\n" +
                "        </compartoAzionis>\n" +
                "        <compartoAzionis>\n" +
                "            <tipo></tipo>\n" +
                "            <comparto>FF Eq. Japan H </comparto>\n" +
                "            <percentuale>0,8</percentuale>\n" +
                "            <valore>0</valore>\n" +
                "            <fondoInvestimento></fondoInvestimento>\n" +
                "            <subTotalePerc>-1</subTotalePerc>\n" +
                "            <subTotaleVal>-1</subTotaleVal>\n" +
                "        </compartoAzionis>\n" +
                "        <compartoAzionis>\n" +
                "            <tipo></tipo>\n" +
                "            <comparto>FF Eq. USA Value </comparto>\n" +
                "            <percentuale>2,28</percentuale>\n" +
                "            <valore>0</valore>\n" +
                "            <fondoInvestimento></fondoInvestimento>\n" +
                "            <subTotalePerc>-1</subTotalePerc>\n" +
                "            <subTotaleVal>-1</subTotaleVal>\n" +
                "        </compartoAzionis>\n" +
                "        <compartoAzionis>\n" +
                "            <tipo></tipo>\n" +
                "            <comparto>FF Eq. Pacific ex Japan </comparto>\n" +
                "            <percentuale>1,42</percentuale>\n" +
                "            <valore>0</valore>\n" +
                "            <fondoInvestimento></fondoInvestimento>\n" +
                "            <subTotalePerc>-1</subTotalePerc>\n" +
                "            <subTotaleVal>-1</subTotaleVal>\n" +
                "        </compartoAzionis>\n" +
                "        <compartoAzionis>\n" +
                "            <tipo></tipo>\n" +
                "            <comparto>FF Eq. USA Growth </comparto>\n" +
                "            <percentuale>3,95</percentuale>\n" +
                "            <valore>0</valore>\n" +
                "            <fondoInvestimento></fondoInvestimento>\n" +
                "            <subTotalePerc>25,74</subTotalePerc>\n" +
                "            <subTotaleVal>0,00</subTotaleVal>\n" +
                "        </compartoAzionis>\n" +
                "        <totalePercentuale>100</totalePercentuale>\n" +
                "        <totaleValore>0,00</totaleValore>\n" +
                "    </fondoInvestimentoAnnuales>\n" +
                "    <descrizioneSintetica>F.U.L. 2006/2024</descrizioneSintetica>\n" +
                "</FondoInvestimentoGlobale>\n";
    }
}
