package com.fideuram.prova;

import java.io.IOException;
import java.util.Date;

import javax.xml.bind.JAXBException;
import javax.xml.bind.ValidationException;

import com.fideuram.jaxb.Converter;
import com.fideuram.stampe.modello.attori.Recapito;
//import com.fideuram.stampe.modello.redditi.d2018.Cud2018;
//import com.fideuram.stampe.modello.redditi.d2018.annotazioni.Annotazioni;
//import com.fideuram.stampe.modello.redditi.d2018.datiFiscali.DatiFiscali;
//import com.fideuram.stampe.modello.redditi.d2018.datiFiscali.Q10;
//import com.fideuram.stampe.modello.redditi.d2018.datiFiscali.Q11;
//import com.fideuram.stampe.modello.redditi.d2018.datiFiscali.Q5;
//import com.fideuram.stampe.modello.redditi.d2018.datiFiscali.Q6;
//import com.fideuram.stampe.modello.redditi.d2018.datiFiscali.Q7;
//import com.fideuram.stampe.modello.redditi.d2018.datiFiscali.Q8;
//import com.fideuram.stampe.modello.redditi.d2018.datiFiscali.Q9;
//import com.fideuram.stampe.modello.redditi.d2018.datiPrevidenziali.DatiPrevidenziali;
//import com.fideuram.stampe.modello.redditi.d2018.datiPrevidenziali.Q12;
//import com.fideuram.stampe.modello.redditi.d2018.datiPrevidenziali.Q13;
//import com.fideuram.stampe.modello.redditi.d2018.datiPrevidenziali.Q14;
//import com.fideuram.stampe.modello.redditi.d2018.datiPrevidenziali.Q15;
//import com.fideuram.stampe.modello.redditi.d2018.datiPrevidenziali.Q16;
//import com.fideuram.stampe.modello.redditi.d2018.datiPrevidenziali.Q17;
//import com.fideuram.stampe.modello.redditi.d2018.datiPrevidenziali.Q18;
//import com.fideuram.stampe.modello.redditi.d2018.datiPrevidenziali.Q19;
//import com.fideuram.stampe.modello.redditi.d2018.datiPrevidenziali.Q20;
//import com.fideuram.stampe.modello.redditi.d2018.datiPrevidenziali.Q21;
//import com.fideuram.stampe.modello.redditi.d2018.datiPrevidenziali.Q22;
//import com.fideuram.stampe.modello.redditi.d2018.datiPrevidenziali.Q23;
//import com.fideuram.stampe.modello.redditi.d2018.redditidiversi.GestioneSeparata;
//import com.fideuram.stampe.modello.redditi.d2018.redditidiversi.Q24;
import com.fideuram.stampe.modello.redditi.d2019.Cud2019;
import com.fideuram.stampe.modello.redditi.d2019.annotazioni.Annotazioni;
import com.fideuram.stampe.modello.redditi.d2019.datiFiscali.DatiFiscali;
import com.fideuram.stampe.modello.redditi.d2019.datiFiscali.Q10;
import com.fideuram.stampe.modello.redditi.d2019.datiFiscali.Q11;
import com.fideuram.stampe.modello.redditi.d2019.datiFiscali.Q5;
import com.fideuram.stampe.modello.redditi.d2019.datiFiscali.Q6;
import com.fideuram.stampe.modello.redditi.d2019.datiFiscali.Q7;
import com.fideuram.stampe.modello.redditi.d2019.datiFiscali.Q8;
import com.fideuram.stampe.modello.redditi.d2019.datiFiscali.Q9;
import com.fideuram.stampe.modello.redditi.d2019.datiPrevidenziali.DatiPrevidenziali;
import com.fideuram.stampe.modello.redditi.d2019.datiPrevidenziali.Q12;
import com.fideuram.stampe.modello.redditi.d2019.datiPrevidenziali.Q13;
import com.fideuram.stampe.modello.redditi.d2019.datiPrevidenziali.Q14;
import com.fideuram.stampe.modello.redditi.d2019.datiPrevidenziali.Q15;
import com.fideuram.stampe.modello.redditi.d2019.datiPrevidenziali.Q16;
import com.fideuram.stampe.modello.redditi.d2019.datiPrevidenziali.Q17;
import com.fideuram.stampe.modello.redditi.d2019.datiPrevidenziali.Q18;
import com.fideuram.stampe.modello.redditi.d2019.datiPrevidenziali.Q19;
import com.fideuram.stampe.modello.redditi.d2019.datiPrevidenziali.Q20;
import com.fideuram.stampe.modello.redditi.d2019.datiPrevidenziali.Q21;
import com.fideuram.stampe.modello.redditi.d2019.datiPrevidenziali.Q22;
import com.fideuram.stampe.modello.redditi.d2019.datiPrevidenziali.Q23;
import com.fideuram.stampe.modello.redditi.d2019.redditidiversi.GestioneSeparata;
import com.fideuram.stampe.modello.redditi.d2019.redditidiversi.Q24;



public class Cud2019Mock  extends AnagraficaMock{
	    public static String getXmlMock() throws JAXBException, IOException {
	        String xml=  Converter.objectToXml(getMock());
	        return xml;
	    }

	    public static Cud2019 getMock(){
	        Cud2019 c=new Cud2019();
	        Recapito r=new Recapito();
	        r.setComune("VERCELLI");
	        r.setProvincia("VC");
	        r.setVia(" VIA salvate mandrà 20");
	        r.setCap("00183");
	        c.setIndirizzoLettera(r);
	        try {
	            c.setTipodichiarazione(0);      //prima
	            //c.setTipodichiarazione(1);    //rettiFica
	            //c.setTipodichiarazione(2);    //annulla
	        } catch (ValidationException e) {
	            e.printStackTrace();
	        }
	        c.setDataEleaborazione(new Date());
	        c.setProgressivoCertificazione("12x36f");
	        c.setDatoreLavoro(getDL());
	        c.setPercettoreSomme(getPS());
	        c.setDatiFiscali(getDF());
	        c.setDatiPrevidenziali(getPrevidenziali());
	        c.setGestioneSeparata(getGestioneSeparata());
	        c.setNumCertDip(1);
	        c.setNumCertPro(2);
	        c.setAnnotazioni(getAnnotazioni());
	        return  c;
	    }

	    private static Annotazioni getAnnotazioni(){
	        Annotazioni a=null;
	       try {
	            a= new Annotazioni(new String[]{"1", "2", "X3", "4", " 5", "6001", "7 ", "8", "9", "10", "X11", "X12","X13", "X14", "X15", "X16", "X17",
	                    "X18", "X19", "20", "21", "22", "23", "24", "X25","26", "27", "X28", "X29", "X30","X31", "X32", "X33", "X34", "X35","X36", "X37", "X38", "39", "40", "41", "42", "43"});
	        } catch (ValidationException e) {
	            e.printStackTrace(); 
	        }
	        return a;
	    }
	    private static GestioneSeparata getGestioneSeparata(){
	        GestioneSeparata g = new GestioneSeparata();
	        Q24 q27=new Q24();
	        q27.setC801(801.00);
	        q27.setC802(802.00);
	        q27.setC803(803.00);
	        q27.setC804(804.00);
	        q27.setC805(805.00);
	        q27.setC806(806.00);
	        q27.setC807(807.00);
	        q27.setC808(808.00);
	        q27.setC809(809.00);
	        q27.setC810(810.00);
	        q27.setC811(811.00);
	        q27.setC812(812.00);
	        q27.setC813(813.00);
	        q27.setC920(920.00);
	        g.setQ24(q27);
	        return g;
	    }

	    private static DatiPrevidenziali getPrevidenziali(){
	        DatiPrevidenziali datiPrevidenziali=new DatiPrevidenziali();
	        Q12 q12= new Q12();
	        q12.setC411(411.00);
	        q12.setC412(412.00);
	        q12.setC413(413.00);
	        q12.setC414(414.00);
	        q12.setC415(new Date());
	        q12.setC416(416.00);
	        q12.setC417(417.00);
	        q12.setC418(418.00);
	        q12.setC419(419.00);
	        q12.setC420(420);
	        q12.setC421(421.00);
	        q12.setC422(422.00);
	        q12.setC423(423.00);
	        q12.setC424("CF 424");
	        q12.setC425("CF 425");
	        q12.setC426("CF 426");
	        q12.setC427("CF 427");
	        datiPrevidenziali.setQ12(q12);

	        Q13 q13 = new Q13();
	        q13.setC431(431.00);
	        q13.setC432("c432");
	        q13.setC433(433.00);
	        q13.setC434("c434");
	        q13.setC435(435.00);
	        q13.setC436("c436");
	        q13.setC437(437.00);
	        q13.setC438(438.00);
	        q13.setC439(439.00);
	        q13.setC440(440.00);
	        q13.setC441(441.00);
	        q13.setC442(442.00);
	        q13.setC443("CF 443");
	        q13.setC444("as444");
	        datiPrevidenziali.setQ13(q13);

	        Q14 q14= new Q14();
	        q14.setC451(451.00);
	        q14.setC452(452.00);
	        q14.setC453(453.00);
	        q14.setC454(454.00);
	        q14.setC455(455.00);
	        q14.setC456(456.00);
	        q14.setC457(457.00);
	        q14.setC458(458.00);
	        q14.setC459(459.00);
	        q14.setC460(460.00);
	        q14.setC461(461.00);
	        q14.setC462(462.00);
	        q14.setC465(465);
	        q14.setC466("c466");
	        q14.setC467(467.00);
	        q14.setC468("c468");
	        q14.setC469(469.00);
	        q14.setC470(470);
	        q14.setC471(471.00);
	        q14.setC472(472.00);
	        q14.setC473(473.00);
	        q14.setC474(474.00);
	        q14.setC475("x475");
	        q14.setC476("x476");
	        q14.setC477(477.00);
	        q14.setC478(478.00);
	        datiPrevidenziali.setQ14(q14);

	        Q15 q15=new Q15();
	        q15.setC481(481.00);
	        q15.setC482(482.00);
	        q15.setC483(483.00);
	        q15.setC484("c484");
	        q15.setC485(485.00);
	        q15.setC486("t456");
	        q15.setC487(487.00);
	        q15.setC488(488.00);
	        q15.setC489(4, 11);
	        q15.setC490(490.00);
	        q15.setC491(491.00);
	        q15.setC492("CF .....");
	        q15.setC496(496.00);
	        q15.setC497(497.00);
	        q15.setC498(498.00);
	        q15.setC499(499.00);
	        q15.setC500(500.00);
	        q15.setC501(501.00);
	        datiPrevidenziali.setQ15(q15);

	        Q16 q16 = new Q16();
	        q16.setC511(511.00);
	        q16.setC512(512.00);
	        q16.setC513(513.00);
	        q16.setC514(514.00);
	        datiPrevidenziali.setQ16(q16);

	        Q17 q17=new Q17();
	        q17.setC531(531.00);
	        q17.setC532(532.00);
	        q17.setC533(533.00);
	        q17.setC534(534.00);
	        q17.setC535(535.00);
	        q17.setC536("CF 536");
	        q17.setC537("x537");
	        q17.setC538(538.00);
	        q17.setC539(539.00);
	        q17.setC540(540.00);
	        q17.setC541(541.00);
	        q17.setC542(542.00);
	        q17.setC543(543.00);
	        q17.setC544(544.00);
	        q17.setC545(545.00);
	        q17.setC546(546.00);
	        q17.setC547(547.00);
	        q17.setC548(548.00);
	        q17.setC549(549.00);
	        q17.setC550(550.00);
	        q17.setC551("x551");
	        q17.setC552(552.00);
	        q17.setC553("x553");
	        q17.setC554(554.00);
	        q17.setC560(560.00);
	        q17.setC561(561.00);
	        q17.setC562(562.00);
	        q17.setC563(563.00);
	        q17.setC564(564.00);
	        
	       // q17.setC701("2017");
	        q17.setC702("702");
	        q17.setC703("703");
	        q17.setC704(704.00);
	        q17.setC705("CF 705");
	        q17.setC706(706.00);
	        datiPrevidenziali.setQ17(q17);

	        Q18 q18=new Q18();
	        q18.setC571(571.00);
	        q18.setC572(572.00);
	        q18.setC573(573.00);
	        q18.setC574(574.00);
	        q18.setC575(575.00);
	        q18.setC576(576.00);
	        q18.setC577(577.00);
	        q18.setC578(578.00);
	        q18.setC579(579.00);
	        q18.setC581(581.00);
	        q18.setC582(582.00);
	        q18.setC583(583.00);
	        q18.setC584(584.00);
	        q18.setC585(585.00);
	        q18.setC586(586.00);
	        q18.setC587(587.00);
	        q18.setC588(588.00);
	        q18.setC589(589.00);
	        datiPrevidenziali.setQ18(q18);

	        datiPrevidenziali.addAnnotazioni("1234567890-1234567890-1234567890-1234567890-1234567890-1234567890-1234567890-1234567890-1234567890-1234567890-100    aria    1234567890-1234567890-1234567890-1234567890-1234567890-1234567890-1234567890-1234567890-1234567890-1234567890-100");
	        datiPrevidenziali.addAnnotazioni("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	        datiPrevidenziali.addAnnotazioni("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
	        datiPrevidenziali.addAnnotazioni("Prova prova notenote");
	        datiPrevidenziali.addAnnotazioni("Nota bene");

	       /* Q18 q18= new Q18();
	        q18.setC571("CF 571");
	        q18.setC572("i572");
	        datiPrevidenziali.setQ18(q18);*/

	        Q19 q19 = null;//= new Q19();
	        try {
	            q19 = new Q19(new char[]{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'});
	        	//q19 = new Q19();
	        } catch (ValidationException e) {
	            e.printStackTrace();
	        }
	        q19.setC1("1");
	        q19.setC2("2");
	        q19.setC3("3");
	        q19.setC4(4.00);
	        q19.setC5(5.00);
	        q19.setC6(6.00);
	        datiPrevidenziali.setQ19(q19);

	        Q20 q20= null;
	        try {
	        	q20 = new Q20(new char[]{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'});
	        } catch (ValidationException e) {
	            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
	        }

	        q20.setC9("CF 9");
	        q20.setC10("10 alfa");
	        q20.setC11("11 alfa");
	        q20.setC12("12x");
	        q20.setC13("13x");
	        q20.setC14("14x");
	        q20.setC15("15x");
	        q20.setC16("16x");
	        q20.setC17("17x");
	        q20.setC18(18.00);
	        q20.setC19(19.00);
	        q20.setC20(20.00);
	        q20.setC21(21.00);
	        q20.setC22(22.00);
	        q20.setC23(23.00);
	        q20.setC24(24.00);
	        q20.setC25(25.00);
	        q20.setC26(26.00);
	        q20.setC27(27.00);
	        q20.setC28(28.00);
	        q20.setC29(29.00);
	        q20.setC30(30.00);
	        q20.setC31(31.00);
	        q20.setC32(32.00);
	        q20.setC33(33.00);
	        q20.setC34(34.00);
	        
	        q20.setC37("CF 37");
	        q20.setC38(new char[]{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'});
	        q20.setC39("CF 39");
	        q20.setC40(40.00);
	        q20.setC41("CF 41");
	        q20.setC42(new char[]{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'});
	        
	        datiPrevidenziali.setQ20(q20);

	        Q21 q21= null;
	        try {
	            q21 = new Q21(new char[]{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'});
	        } catch (ValidationException e) {
	            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
	        }

	        q21.setC41(43.00);
	        q21.setC42(44.00);
	        q21.setC43(45.00);
	        q21.setC44(46.00);
	        q21.setC47("49");
	        q21.setC48("CF 49");
	        datiPrevidenziali.setQ21(q21);

	        Q22 q22=new Q22();
	        q22.setC49("X49 CF");
	        q22.setC50("X50 DENOMINAZIONE ACME");
	        q22.setC52("X52");
	        q22.setC53("X53");
	        q22.setC54(54.00);
	        q22.setC55(55.00);
	        q22.setC56(56.00);
	        q22.setC57(57.00);
	        q22.setC58(58.00);
	        q22.setC59(59.00);
	        datiPrevidenziali.setQ22(q22);

	        Q23 q23=new Q23();
	        q23.setC71("71-Q-");
	        q23.setC72("72 ABCDEFGHICC");
	        q23.setC73(new Date());
	        q23.setC74(new Date());
	        q23.setC75("c75");
	        q23.setC76("??");
	        datiPrevidenziali.setQ23(q23);
	        return datiPrevidenziali;
	    }

	    private static DatiFiscali getDF(){
	        DatiFiscali datiFiscali= new DatiFiscali();
	        Q5 q5=  new Q5();
	        q5.setC1(1.00);
	        q5.setC2(2);
	        q5.setC3(3.00);
	        q5.setC4(4.00);
	        q5.setC5(5.00);
	        q5.setC6(6);
	        q5.setC7(7.00);
	        q5.setC8(new Date());
	        q5.setC9(new Date());
	        q5.setC10(1.0);
	        q5.setC11(11.00);
	        datiFiscali.setQ5(q5);
	        Q6 q6= new Q6();
	        q6.setC21(21.00);
	        q6.setC22(22.00);
	        q6.setC23(23.00);
	        q6.setC24(24.00);
	        q6.setC25(25.00);
	        q6.setC26(26.00);
	        q6.setC27(27.00);
	        q6.setC28(28.00);
	        q6.setC29(29.00);
	        q6.setC30(30.00);
	        q6.setC31(31.00);
	        q6.setC32(32.00);
	        q6.setC33(33.00);
	        q6.setC34(34.00);
	        q6.setC35(35.00);
	        q6.setC36(36.00);
	        datiFiscali.setQ6(q6);
	        Q7 q7= new Q7();
	        q7.setC53("53");
	        q7.setC54("54");
	        q7.setC61(61.00);
	        q7.setC62(62.00);
	        q7.setC63(63.00);
	        q7.setC64(64.00);
	        q7.setC71(71.00);
	        q7.setC72(72.00);
	        q7.setC73(73.00);
	        q7.setC74(74.00);
	        q7.setC75("c75");
	        q7.setC81(81.00);
	        q7.setC82(82.00);
	        q7.setC83(83.00);
	        q7.setC84(84.00);
	        q7.setC85("c85");
	        q7.setC91(91.00);
	        q7.setC92(92.00);
	        q7.setC93(93.00);
	        q7.setC94(94.00);
	        q7.setC101(101.00);
	        q7.setC102(102.00);
	        q7.setC106(106.00);
	        q7.setC107(107.00);
	        q7.setC111(111.00);
	        q7.setC112(112.00);
	        q7.setC121(121.00);
	        q7.setC122(122.00);
	        q7.setC123("x123");
	        q7.setC124(124.00);
	        q7.setC125("c125");
	        q7.setC126(126.00);
	        q7.setC127(127.00);
	        q7.setC128("x128");
	        q7.setC131(131.00);
	        q7.setC132(132.00);
	        q7.setC133(133.00);
	        q7.setC141(141.00);
	        q7.setC142(142.00);
	        q7.setC143(143.00);
	        q7.setC151(151.00);
	        q7.setC152(152.00);
	        q7.setC153(153.00);
	        datiFiscali.setQ7(q7);

	        Q8 q8 = new Q8();
	        q8.setC161(161.00);
	        q8.setC162(162.00);
	        q8.setC163(163.00);
	        q8.setC164(164.00);
	        q8.setC165(165.00);
	        q8.setC166(166.00);
	        q8.setC167(167.00);
	        datiFiscali.setQ8(q8);

	        Q9 q9 = new Q9();
	        q9.setC261(261.00);
	        q9.setC262(262.00);
	        q9.setC263(263.00);
	        q9.setC264(264.00);
	        q9.setC271(271.00);
	        q9.setC272(272.00);
	        q9.setC273(273.00);
	        q9.setC274(274.00);
	        q9.setC275("c275");
	        q9.setC281(281.00);
	        q9.setC282(282.00);
	        q9.setC283(283.00);
	        q9.setC284(284.00);
	        q9.setC285("c285");
	        q9.setC291(291.00);
	        q9.setC292(292.00);
	        q9.setC293(293.00);
	        q9.setC294(294.00);

	        q9.setC301(301.00);
	        q9.setC302(302.00);
	        q9.setC306(306.00);
	        q9.setC307(307.00);
	        q9.setC311(311.00);
	        q9.setC312(312.00);
	        q9.setC321(321.00);
	        q9.setC322(322.00);
	        q9.setC323("X");
	        q9.setC324(324.00);
	        q9.setC325("c325");
	        q9.setC326(326.00);
	        q9.setC327(327.00);
	        q9.setC328("X");
	        q9.setC331(331.00);
	        q9.setC332(332.00);
	        q9.setC333(333.00);
	        datiFiscali.setQ9(q9);

	        Q10 q10= new Q10();
	        q10.setC341("c341");
	        q10.setC342(342.00);
	        q10.setC343("c343");
	        q10.setC344(344.00);
	        q10.setC345("c345");
	        q10.setC346(346.00);
	        q10.setC347("c347");
	        q10.setC348(348.00);
	        q10.setC349("c349");
	        q10.setC350(350.00);
	        q10.setC351("c351");
	        q10.setC352(352.00);
	        datiFiscali.setQ10(q10);

	        Q11 q11= new Q11();
	        q11.setC361(361.00);
	        q11.setC362(362.00);
	        q11.setC363(363.00);
	        q11.setC364(364.00);
	        q11.setC365(365.00);
	        q11.setC366(366.00);
	        q11.setC367(367.00);
	        q11.setC368(368.00);
	        q11.setC369(369.00);
	        q11.setC370(370.00);
	        q11.setC371(371.00);
	        q11.setC372(372.00);
	        q11.setC373(373.00);
	        q11.setC374(374.00);
	        q11.setC375("c375");
	        q11.setC376("c376");
	        q11.setC377(377.00);
	        q11.setC378(378.00);

	        q11.setC391("c391");
	        q11.setC392(392.00);
	        q11.setC393(393.00);
	        q11.setC394(394.00);
	        q11.setC395("c395");
	        q11.setC396(396.00);
	        q11.setC397(397.00);
	        q11.setC399("CF sotituto");
	        datiFiscali.setQ11(q11);
	        return datiFiscali;
	    }



	}