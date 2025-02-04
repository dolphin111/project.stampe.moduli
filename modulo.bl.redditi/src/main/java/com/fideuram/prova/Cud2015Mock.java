package com.fideuram.prova;

import com.fideuram.file.io.writer.XmlWriter;
import com.fideuram.jaxb.Converter;
import com.fideuram.stampe.modello.attori.Individuo;
import com.fideuram.stampe.modello.attori.Recapito;
import com.fideuram.stampe.modello.redditi.anagrafica.DomicilioFiscale;
import com.fideuram.stampe.modello.redditi.anagrafica.PercettoreSomme;
import com.fideuram.stampe.modello.redditi.anagrafica.ResidenzaEstero;
import com.fideuram.stampe.modello.redditi.anagrafica.SostitutoImposta;
import com.fideuram.stampe.modello.redditi.d2015.Cud2015;
import com.fideuram.stampe.modello.redditi.anagrafica.familiari.Familiare;
import com.fideuram.stampe.modello.redditi.anagrafica.familiari.FamiliariACarico;
import com.fideuram.stampe.modello.redditi.d2015.datifiscali.*;
import com.fideuram.stampe.modello.redditi.d2015.datiprevidenziali.*;
import com.fideuram.utils.LoggingUtils;

import javax.xml.bind.JAXBException;
import javax.xml.bind.ValidationException;
import java.io.IOException;
import java.util.Date;

/**
 * User: V801068
 * Date: 18/11/14
 * Time: 17.37
 */
public class Cud2015Mock extends AnagraficaMock{
    public static String getXmlMock(Cud2015 c) throws JAXBException, IOException {
        String xml=  Converter.objectToXml(c);
        return xml;
    }




    public static String getXmlMock() throws JAXBException, IOException {
        return getXmlMock(getMock());
    }


    public static Cud2015 getMock(){
        Cud2015 c=new Cud2015();
        Recapito r=new Recapito();
        r.setComune("VERCELLI");
        r.setProvincia("VC");
        r.setVia(" VIA salvate mandrà 20");
        r.setCap("00183");
        c.setIndirizzoLettera(r);
        try {
            c.setTipodichiarazione(0); //prima
            //c.setTipodichiarazione(1); //rettifica
            //c.setTipodichiarazione(2);   //annullla
        } catch (ValidationException e) {
            e.printStackTrace();
        }
        c.setDataEleaborazione(new Date());
        c.setProgressivoCertificazione("12x36f");
        c.setDatoreLavoro(getDL());
        c.setPercettoreSomme(getPS());
        c.setDatiFiscali(getDF());
        c.setNumCertDip(1);
        c.setNumCertPro(2);
        try {
            c.setDatiPrevidenziali(getPrevidenziali());
        } catch (ValidationException e) {
            e.printStackTrace();
        }
        return  c;
    }



    private static DatiFiscali getDF(){
        DatiFiscali df = new DatiFiscali();
        Q5 q5= new Q5();
        q5.setC1(1.00);
        q5.setC2(2);
        q5.setC3(3.00);
        q5.setC4(4.00);
        q5.setC5(5.00);
        q5.setC6(6);
        q5.setC7(7.00);
        q5.setC8(new Date());
        q5.setC9(new Date());
        q5.setC10(10.00);
        df.setQ5(q5);
        Q6 q6= new Q6();
        q6.setC11(11.00);
        q6.setC12(12.00);
        q6.setC16(16.00);
        q6.setC17(17.00);
        q6.setC19(19.00);
        q6.setC20(20.00);
        q6.setC21(21.00);
        q6.setC23(23.00);
        q6.setC24(24.00);
        df.setQ6(q6);
        Q7 q7= new Q7();
        q7.setC31(31.00);
        q7.setC32(32.00);
        q7.setC33(33.00);
        q7.setC34(34.00);
        q7.setC35(35.00);
        q7.setC36(36.00);
        q7.setC37(37.00);
        q7.setC38(38.00);
        df.setQ7(q7);
        Q8 q8= new Q8();
        q8.setC51(51.00);
        q8.setC52(52.00);
        q8.setC53(53.00);
        q8.setC54(54.00);
        q8.setC55(55.00);
        q8.setC56(56.00);
        q8.setC57(57.00);
        q8.setC58(58.00);
        df.setQ8(q8);
        Q9 q9= new Q9();
        q9.setC61(61.00);
        q9.setC62(62.00);
        q9.setC63(63.00);
        q9.setC64(64.00);
        df.setQ9(q9);
        Q10 q10= new Q10();
        q10.setC65(65.00);
        q10.setC66(66.00);
        q10.setC67(67.00);
        q10.setC68(68.00);
        df.setQ10(q10);
        Q11 q11= new Q11();
        q11.setC71(71.00);
        q11.setC72(72.00);
        q11.setC73(73.00);
        q11.setC74(74.00);
        q11.setC75(75.00);
        q11.setC76(76.00);
        q11.setC77(77.00);
        q11.setC78(78.00);
        q11.setC79(79.00);
        q11.setC80(80.00);
        q11.setC81(81.00);
        q11.setC82(82.00);
        df.setQ11(q11);
        Q12 q12= new Q12();
        q12.setC101(101.00);
        q12.setC102(102.00);
        q12.setC103(103.00);
        q12.setC104(104.00);
        q12.setC105(105.00);
        q12.setC106(106.00);
        q12.setC107(107.00);
        q12.setC108(108.00);
        q12.setC109(109.00);
        q12.setC110(110.00);
        q12.setC111(111.00);
        q12.setC112(112.00);
        q12.setC113(113.00);
        q12.setC114(114.00);
        q12.setC115(115.00);
        q12.setC116(116.00);
        q12.setC117(117.00);
        q12.setC118(118.00);
        q12.setC119(119);
        q12.setC120(120.00);
        q12.setC121(121.00);
        df.setQ12(q12);
        Q13 q13= new Q13();
        q13.setC141(141.00);
        q13.setC142(142.00);
        q13.setC143(143.00);
        q13.setC144(144.00);
        q13.setC146(146.00);
        q13.setC147(147.00);
        q13.setC148(148.00);
        q13.setC149(149.00);
        q13.setC150(150.00);
        q13.setC151(151.00);
        q13.setC152(152.00);
        q13.setC153(153.00);
        df.setQ13(q13);
        Q14 q14= new Q14();
        q14.setC161(161.00);
        q14.setC162(162.00);
        q14.setC163(163.00);
        q14.setC164(164.00);
        q14.setC166(166.00);
        df.setQ14(q14);
        Q15 q15= new Q15();
        q15.setC171(171.00);
        q15.setC172(172.00);
        q15.setC173(173.00);
        q15.setC174(174.00);
        q15.setC175(175.00);
        q15.setC184(184.00);
        q15.setC186(186.00);
        q15.setC191(191.00);
        q15.setC192(192.00);
        df.setQ15(q15);
        df.setQ14(q14);
        Q16 q16= new Q16();
        q16.setC201(201.00);
        q16.setC202(202.00);
        q16.setC203(203.00);
        q16.setC204(204.00);
        q16.setC205(205.00);
        df.setQ16(q16);
        Q17 q17= new Q17();
        q17.setC221(221.00);
        q17.setC222(222.00);
        q17.setC223(223.00);
        q17.setC241(241.00);
        q17.setC242(242.00);
        q17.setC243(243.00);
        q17.setC244(244.00);
        q17.setC245(245.00);
        q17.setC246(246.00);
        df.setQ17(q17);
        Q18 q18= new Q18();
        q18.setC261(261.00);
        q18.setC262(262.00);
        q18.setC263(263.00);
        q18.setC264(264.00);
        df.setQ18(q18);
        Q19 q19= new Q19();
        q19.setC301(301.00);
        q19.setC302(302.00);
        q19.setC303(303.00);
        q19.setC304(304.00);
        q19.setC305("305 : CF di chi?");
        q19.setC308(308.00);
        q19.setC309(309.00);
        q19.setC310(310.00);
        q19.setC311(311.00);
        q19.setC312(312.00);
        q19.setC313(313.00);
        q19.setC314(314.00);
        q19.setC315(315.00);
        q19.setC316(316.00);
        q19.setC317(317.00);
        q19.setC323(323.00);
        q19.setC324(324.00);
        q19.setC326(326.00);
        q19.setC327(327.00);
        q19.setC328(328.00);
        q19.setC329(329.00);
        q19.setC330(330.00);
        q19.setC331(331.00);
        df.setQ19(q19);
        Q20 q20= new Q20();
        q20.setC401(401.00);
        q20.setC402(402.00);
        q20.setC403(403.00);
        q20.setC404(404.00);
        q20.setC405(405.00);
        q20.setC406(406.00);
        q20.setC407(407.00);
        q20.setC408(408.00);
        q20.setC409(409.00);
        q20.setC410(410.00);
        q20.setC411(411.00);
        q20.setC412(412.00);
        q20.setC413(413.00);
        df.setQ20(q20);
        return df;
    }

    private static DatiPrevidenziali getPrevidenziali() throws ValidationException {
        DatiPrevidenziali dp= new DatiPrevidenziali();
        Q22 q22=new Q22();
        q22.setC1("1 uno");
        q22.setC2("2 due");
        q22.setC3("3 tre");
        q22.setC4(4.00);
        q22.setC5(5.00);
        q22.setC6(6.00);
        dp.setQ22(q22);

        Q23 q23=new Q23(new char[]{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'});
        dp.setQ23(q23);

        Q24 q24=new Q24();
        q24.setC9(9.00);
        q24.setC10(10.00);
        q24.setC11(11.00);
        q24.setC12(12.00);
        dp.setQ24(q24);


        Q25 q25=new Q25(new char[]{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'});
        q25.setC15("15 alfa");
        q25.setC16("16 alfa");
        q25.setC17("17 alfa");
        q25.setC18("18x");
        q25.setC19("19x");
        q25.setC20("20x");
        q25.setC21("21x");
        q25.setC22("22x");
        q25.setC23(23.00);
        q25.setC24(24.00);
        q25.setC25(25.00);
        q25.setC26(26.00);
        q25.setC27(27.00);
        q25.setC28(28.00);
        q25.setC29(29.00);
        q25.setC30(30.00);
        dp.setQ25(q25);

        Q26 q26=new Q26();
        q26.setC35("35-Q-");
        q26.setC36("36 ABCDEFGHICC");
        q26.setC37(new Date());
        q26.setC38(new Date());
        q26.setC39("39 cod");
        q26.setC40("??");
        dp.setQ26(q26);
        dp.addAnnotazioni("1234567890-1234567890-1234567890-1234567890-1234567890-1234567890-1234567890-1234567890-1234567890-1234567890-100    aria    1234567890-1234567890-1234567890-1234567890-1234567890-1234567890-1234567890-1234567890-1234567890-1234567890-100");
        dp.addAnnotazioni("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        dp.addAnnotazioni("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        dp.addAnnotazioni("Prova prova notenote");
        dp.addAnnotazioni("Nota bene");
        return dp;
    }


    public static void main(String args[]) throws JAXBException, IOException {
        LoggingUtils.info(getXmlMock());
        Cud2015 c=getMock();
        String cf10    ="000000000000000";
        String cf100   ="00000000000000";
        String cf1000  ="0000000000000";
        String cf10000 ="000000000000";
        String cf100000="00000000000";
        for(int i=0;i<1;i++){
            String _tmpcf=i+"";
            if(i<10)
              c.getPercettoreSomme().setCf(cf10+i);
            if(i>9&&i<100)
              c.getPercettoreSomme().setCf(cf100+i);
            if(i>99&&i<1000)
              c.getPercettoreSomme().setCf(cf1000+i);
            if(i>999&&i<10000)
                c.getPercettoreSomme().setCf(cf10000+i);
            if(i>9999&&i<100000)
                c.getPercettoreSomme().setCf(cf100000+i);
            String xml=getXmlMock(c);
            XmlWriter.scriviStoXml(xml,c.getPercettoreSomme().getCf()+".xml","C:\\Users\\v801068\\Dropbox\\Public\\Fideuram\\TEMP\\Cud\\Input");
        }
    }
}
