package com.fideuram.crm.stampe.serviceclient.universo;

import com.fideuram.exception.ws.UniversoException;
import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.serviceclient.bi.*;
import com.fideuram.config.CrmProperties;
import org.tempuri.PrestInfoNew;
import org.tempuri.UniversoManagerPortWS;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * Created by
 * User: logan
 * Date: 02/08/11
 * Time: 14.14
 */
public class NuovoUniversoClientWS extends ClientUniverso {
    URL wsdlLocation = null;
    String ambiente = null;
    UniversoManagerPortWS ws = null;


    @Override
    public WSPrestazioniAssicurateBean getPrestazioniAssicurate(String numeroPolizza, String dataValutazione) throws UniversoException {
        String xml = ws.prestazioniAssicurate(ambiente, "S", Long.parseLong(numeroPolizza.trim()), 0, dataValutazione, 0);
        return popolaBean(WSPrestazioniAssicurateBean.class, xml);
    }

    @Override
    public WSRiscattoBean getRiscattoPolizzeAperte(String polizza, String dataValutazione, int indicatoreTipoRisc) throws UniversoException {
        String xml = ws.ipotesiRiscattoPA(ambiente, "S", Long.parseLong(polizza.trim()), 0, dataValutazione, 0, indicatoreTipoRisc);
        return popolaBean(WSRiscattoBean.class, xml);
    }

    @Override
    public WSRiscattoPolizzeChiuseBean getRiscattoPolizzeChiuse(String polizza, String dataValutazione) throws UniversoException {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeInMillis(System.currentTimeMillis());
        XMLGregorianCalendar xgcal = null;
        try {
            xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        } catch (DatatypeConfigurationException e) {
            //todo valutare un gestione ottimale di questa eventuale quanto rara possibilità di eccezione
            e.printStackTrace();
        }
        String xml = ws.ipotesiRiscatto(ambiente, "S", Long.parseLong(polizza.trim()), xgcal);
        return popolaBean(WSRiscattoPolizzeChiuseBean.class, xml);
    }

    @Override
    public WSConversioneinRenditaBean getConversioneInRendita(String polizza, String dataValutazione) throws UniversoException {
        String xml = ws.getConversioneInRendita(ambiente, "S",Long.parseLong(polizza.trim()), 0, dataValutazione, 0);
        return popolaBean(WSConversioneinRenditaBean.class, xml);
    }

    @Override
    public WSRiduzioneBean getRiduzione(String polizza, String dataValutazione) throws UniversoException {
        String xml = ws.ipotesiRidotte(ambiente, "S", Long.parseLong(polizza.trim()), 0, dataValutazione, 0);
        return popolaBean(WSRiduzioneBean.class, xml);
    }

    @Override
    public WSOpzioniBean getOpzReversibilita(String polizza, String frazionamento, String reversibilita, String dataNascita, String sesso, String anticipata) throws UniversoException {
        WSOpzioniBean bean = new WSOpzioniBean();
        String xml = ws.ipotesiOpzioneRenditaReversibile(ambiente, "S", Long.parseLong(polizza.trim()), 0, frazionamento, Integer.parseInt(reversibilita), dataNascita, sesso, anticipata, "N");
        bean = popolaBean(WSOpzioniBean.class, xml);
        bean.setFrazionamento(frazionamento);
	    bean.setSesso(sesso);
	    trascodificaInput(bean);
		bean.setAnticipata(anticipata);
		bean.setReversibilita(reversibilita);
		bean.setDataNascita(dataNascita);
        return bean;
    }

    @Override
    public WSOpzioniBean getOpzCertezza(String polizza, String frazionamento, String anniRendita, String anticipata) throws UniversoException {
        WSOpzioniBean bean = new WSOpzioniBean();
        String xml = ws.ipotesiOpzioneRenditaCerta(ambiente, "S", Long.parseLong(polizza.trim()), 0, frazionamento, Integer.parseInt(anniRendita), anticipata, "N");

        bean = popolaBean(WSOpzioniBean.class, xml);
        bean.setFrazionamento(frazionamento);
		trascodificaInput(bean);
		bean.setAnticipata(anticipata);
		bean.setAnniRendita(anniRendita);
        return bean;
    }

    @Override
    public WSOpzioniBean getOpzProroga(String polizza, String anniProroga, String mesiProroga, String dataProroga, String polizzaProroga) throws UniversoException {
        WSOpzioniBean bean = new WSOpzioniBean();
        int anniPro = 0;
        int mesiPro = 0;
        int polizzaPro = 0;
        if (anniProroga != null)
            anniPro = Integer.parseInt(anniProroga);

        if (mesiProroga != null)
            mesiPro = Integer.parseInt(mesiProroga);

        if (polizzaProroga != null)
            polizzaPro = Integer.parseInt(polizzaProroga);
        String xml = ws.ipotesiOpzioneRenditaProrogata(ambiente, "S", Long.parseLong(polizza.trim()), 0, anniPro, mesiPro, dataProroga, polizzaPro, "N");
        bean = popolaBean(WSOpzioniBean.class, xml);
        bean.setAnniProroga(anniProroga);
		bean.setMesiProroga(mesiProroga);
		bean.setDataProroga(dataProroga);
		bean.setPolizzaProroga(polizzaProroga);
        return bean;
    }

    @Override
    public WSOpzioniBean getOpzCambioFraz(String polizza, String frazionamento, String anticipata) throws UniversoException {
        WSOpzioniBean bean = new WSOpzioniBean();
        String xml = ws.ipotesiOpzioneRenditaFrazionata(ambiente, "S", Long.parseLong(polizza.trim()), 0, frazionamento, anticipata, "N");
        bean = popolaBean(WSOpzioniBean.class, xml);
        bean.setFrazionamento(frazionamento);
		trascodificaInput(bean);
		bean.setAnticipata(anticipata);
        return bean;
    }

   /* public UniversoWS getEffectiveWs() throws UniversoException {
        if(ws!=null)
           return ws;
        else
           return createClient().getPort();
    }*/

    /**
     * @throws UniversoException
     */
    public NuovoUniversoClientWS(String url) throws UniversoException {
        ambiente = CrmProperties.getProperty(Costanti.AMBIENTE_UNIVERSO);
        try {
            wsdlLocation = new URL(url);
        } catch (MalformedURLException e) {
            throw new UniversoException("Universo Malformed URL "+e.getMessage());
        }
        //ws = (UniversoWS) createClient().getPort();
        ws = (UniversoManagerPortWS) createClient();
    }

    public UniversoManagerPortWS createClient() throws UniversoException {
            try {
                return (UniversoManagerPortWS) new PrestInfoNew( this.wsdlLocation , new QName("http://tempuri.org/", "PrestInfoNew")).getPrestInfoNewSoap();
            } catch (Exception e) {
                throw new UniversoException("Errore durante la connessione a << UNIVERSO>>.", e.getCause());
            }
    }

  /*  private WsClientUniverso createClient() throws UniversoException {
        try {
            this.wsdlLocation = new URL(CrmProperties.getProperty(Costanti.BI_SERVICES_URL));
        } catch (MalformedURLException e) {
            throw new UniversoException("Errore durante la connessione a << UNIVERSO>>.", e.getCause());
        }

        return new WsClientUniverso(wsdlLocation, new QName("http://tempuri.org/", "PrestInfoNew"));
    }*/
    
    public WSRiscattoParzialeTendenzaBean getRiscattoParziale(String polizza, BigDecimal importoRichiesto) throws UniversoException{
    	WSRiscattoParzialeTendenzaBean riscattoParziale = new WSRiscattoParzialeTendenzaBean();
    	GregorianCalendar cal = new GregorianCalendar();
    	cal.setTimeInMillis(System.currentTimeMillis());
    	XMLGregorianCalendar xgcal = null;
    	try {
    		xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
    	} catch (DatatypeConfigurationException e) {             
    		e.printStackTrace(); 
    	}
    	String xml = ws.ipotesiRiscattoParziale(ambiente, "S", Long.parseLong(polizza.trim()), xgcal, importoRichiesto);
    	riscattoParziale = popolaBean(WSRiscattoParzialeTendenzaBean.class, xml);    	
    	return riscattoParziale;
    }
    
    public WSRiscattoParzialePuntualeBean getRiscattoParzialePA(String polizza, BigDecimal importoRichiesto, String quotaFondo, int discriminator) throws UniversoException{
    	WSRiscattoParzialePuntualeBean riscattoParzialePA = new WSRiscattoParzialePuntualeBean();  	
    	
    	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    	Date date = new Date();
    	String today = format.format(date);
    	
    	String xml = ws.ipotesiRiscattoParzialePA(ambiente, "S", Long.parseLong(polizza.trim()), 0, today, 0, importoRichiesto, quotaFondo, discriminator);//15 tendenza e 16 puntuale
    	riscattoParzialePA = popolaBean(WSRiscattoParzialePuntualeBean.class, xml);    	
    	return riscattoParzialePA;
    }
    
}