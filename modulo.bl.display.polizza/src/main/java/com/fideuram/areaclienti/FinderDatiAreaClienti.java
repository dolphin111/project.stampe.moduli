package com.fideuram.areaclienti;


import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.jaxb.Converter;
import com.fideuram.modello.attori.AreaCliente;
import com.fideuram.modello.attori.Contraente;
import com.fideuram.modello.attori.Indirizzo;
import com.fideuram.modello.attori.Persona;
import com.fideuram.modello.polizza.DatiTecnici;
import com.fideuram.modello.polizza.FigureContrattuali;
import com.fideuram.modello.polizza.Polizza;
import com.fideuram.modello.polizza.TipoRichiesta;
import com.fideuram.utils.LoggingUtils;

import javax.xml.bind.JAXBException;

/**
 * Questa classe comverte i dati in arrivo nel xml in formato standard usato dal display polizza
 * Created
 * User: logan
 * Date: 16/09/13
 * Time: 20.14
 *
 */
@Deprecated
public class FinderDatiAreaClienti {

    public Polizza getXmFromData(String data) throws DocGeneratorException {
        try {
            DatiLetteraPinPVO vo = (DatiLetteraPinPVO) Converter.xml2Object(new DatiLetteraPinPVO(), data);
            LoggingUtils.info("conversione in corso di DatiLetteraPinPVO: cognome  " + vo.getCognome());
            LoggingUtils.info("conversione in corso di DatiLetteraPinPVO: ragione sociale " + vo.getRagioneSociale());

            Polizza polizza  = new Polizza();
            Persona persona   = new Persona();
            Indirizzo indirizzo=new Indirizzo();
            Contraente contraente=new Contraente();
            FigureContrattuali fg = new FigureContrattuali();
            DatiTecnici datiTecnici = new DatiTecnici();
            AreaCliente areaClienti = new AreaCliente();
            TipoRichiesta tipoRichiesta = new TipoRichiesta();

            datiTecnici.setNumeroPolizza(vo.getPolizza());

            areaClienti.setUserId(vo.getUser());
            areaClienti.setPasswd(vo.getPassword());

            persona.setCognome(vo.getCognome());
            persona.setNome(vo.getNome());
            persona.setRagioneSociale(vo.getRagioneSociale());
            persona.setSesso(vo.getSesso());
            persona.setAreaCliente(areaClienti);

            indirizzo.setIndirizzo(vo.getIndirizzo());
            indirizzo.setNazione(vo.getNazione());
            indirizzo.setProvincia(vo.getProvincia());
            indirizzo.setComune(vo.getCitta());
            indirizzo.setCap(vo.getCap());


            tipoRichiesta.setMail(vo.isMail());



            if(vo.getDiscriminator().equalsIgnoreCase("PF")){
               contraente.setPersonaFisica(persona);
            }else{
                contraente.setPersonaGiuridica(persona);
            }

            fg.setIndirizzoContratto(indirizzo);
            fg.setContraente(contraente);

            polizza.setFigureContrattuali(fg);
            polizza.setDatiTecnici(datiTecnici);
            polizza.setTipoRichiesta(tipoRichiesta);
            return polizza;
            //String xml = Converter.objectToXml(polizza);
            //LoggingUtils.info("XML POLIZZA OTTENUTO " +  xml);
            //return xml;
        } catch (JAXBException e) {
            LoggingUtils.error(e);
            throw new DocGeneratorException(e.getMessage());
        } catch (ClassNotFoundException e) {
            LoggingUtils.error(e);
            throw new DocGeneratorException(e.getMessage());
        } catch (IllegalAccessException e) {
            LoggingUtils.error(e);
            throw new DocGeneratorException(e.getMessage());
        } catch (InstantiationException e) {
            LoggingUtils.error(e);
            throw new DocGeneratorException(e.getMessage());
        }
    }

   public static void main(String args[]) {
       //new FinderDatiAreaClienti().getXmlData("7647374");
   }
}
