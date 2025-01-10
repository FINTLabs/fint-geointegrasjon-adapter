
package no.geointegrasjon.arkiv.innsyn;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.5.5
 * 2024-12-18T13:51:13.532+01:00
 * Generated source version: 3.5.5
 *
 */
public final class ArkivInnsynPort_ArkivInnsyn_Client {

    private static final QName SERVICE_NAME = new QName("http://rep.geointegrasjon.no/Arkiv/Innsyn/xml.wsdl/2012.01.31", "InnsynService");

    private ArkivInnsynPort_ArkivInnsyn_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = InnsynService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        InnsynService ss = new InnsynService(wsdlURL, SERVICE_NAME);
        ArkivInnsynPort port = ss.getArkivInnsyn();

        {
        System.out.println("Invoking finnDokumenter...");
        no.geointegrasjon.arkiv.innsyn.SoekskriterieListe _finnDokumenter_sok = null;
        java.lang.Boolean _finnDokumenter_returnerFil = null;
        no.geointegrasjon.arkiv.innsyn.ArkivKontekst _finnDokumenter_kontekst = null;
        try {
            no.geointegrasjon.arkiv.innsyn.DokumentListe _finnDokumenter__return = port.finnDokumenter(_finnDokumenter_sok, _finnDokumenter_returnerFil, _finnDokumenter_kontekst);
            System.out.println("finnDokumenter.result=" + _finnDokumenter__return);

        } catch (SystemException e) {
            System.out.println("Expected exception: SystemException has occurred.");
            System.out.println(e.toString());
        } catch (ImplementationException e) {
            System.out.println("Expected exception: ImplementationException has occurred.");
            System.out.println(e.toString());
        } catch (FinderException e) {
            System.out.println("Expected exception: FinderException has occurred.");
            System.out.println(e.toString());
        } catch (ValidationException e) {
            System.out.println("Expected exception: ValidationException has occurred.");
            System.out.println(e.toString());
        } catch (OperationalException e) {
            System.out.println("Expected exception: OperationalException has occurred.");
            System.out.println(e.toString());
        } catch (ApplicationException e) {
            System.out.println("Expected exception: ApplicationException has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking finnJournalposter...");
        no.geointegrasjon.arkiv.innsyn.SoekskriterieListe _finnJournalposter_sok = null;
        java.lang.Boolean _finnJournalposter_returnerMerknad = null;
        java.lang.Boolean _finnJournalposter_returnerTilleggsinformasjon = null;
        java.lang.Boolean _finnJournalposter_returnerKorrespondansepart = null;
        java.lang.Boolean _finnJournalposter_returnerAvskrivning = null;
        no.geointegrasjon.arkiv.innsyn.ArkivKontekst _finnJournalposter_kontekst = null;
        try {
            no.geointegrasjon.arkiv.innsyn.JournalpostListe _finnJournalposter__return = port.finnJournalposter(_finnJournalposter_sok, _finnJournalposter_returnerMerknad, _finnJournalposter_returnerTilleggsinformasjon, _finnJournalposter_returnerKorrespondansepart, _finnJournalposter_returnerAvskrivning, _finnJournalposter_kontekst);
            System.out.println("finnJournalposter.result=" + _finnJournalposter__return);

        } catch (SystemException e) {
            System.out.println("Expected exception: SystemException has occurred.");
            System.out.println(e.toString());
        } catch (ImplementationException e) {
            System.out.println("Expected exception: ImplementationException has occurred.");
            System.out.println(e.toString());
        } catch (FinderException e) {
            System.out.println("Expected exception: FinderException has occurred.");
            System.out.println(e.toString());
        } catch (ValidationException e) {
            System.out.println("Expected exception: ValidationException has occurred.");
            System.out.println(e.toString());
        } catch (OperationalException e) {
            System.out.println("Expected exception: OperationalException has occurred.");
            System.out.println(e.toString());
        } catch (ApplicationException e) {
            System.out.println("Expected exception: ApplicationException has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking finnSaksmapperGittNoekkel...");
        no.geointegrasjon.arkiv.innsyn.Saksnoekkel _finnSaksmapperGittNoekkel_nokkel = null;
        java.lang.Boolean _finnSaksmapperGittNoekkel_returnerMerknad = null;
        java.lang.Boolean _finnSaksmapperGittNoekkel_returnerTilleggsinformasjon = null;
        java.lang.Boolean _finnSaksmapperGittNoekkel_returnerSakspart = null;
        java.lang.Boolean _finnSaksmapperGittNoekkel_returnerKlasse = null;
        no.geointegrasjon.arkiv.innsyn.ArkivKontekst _finnSaksmapperGittNoekkel_kontekst = null;
        try {
            no.geointegrasjon.arkiv.innsyn.SaksmappeListe _finnSaksmapperGittNoekkel__return = port.finnSaksmapperGittNoekkel(_finnSaksmapperGittNoekkel_nokkel, _finnSaksmapperGittNoekkel_returnerMerknad, _finnSaksmapperGittNoekkel_returnerTilleggsinformasjon, _finnSaksmapperGittNoekkel_returnerSakspart, _finnSaksmapperGittNoekkel_returnerKlasse, _finnSaksmapperGittNoekkel_kontekst);
            System.out.println("finnSaksmapperGittNoekkel.result=" + _finnSaksmapperGittNoekkel__return);

        } catch (SystemException e) {
            System.out.println("Expected exception: SystemException has occurred.");
            System.out.println(e.toString());
        } catch (ImplementationException e) {
            System.out.println("Expected exception: ImplementationException has occurred.");
            System.out.println(e.toString());
        } catch (FinderException e) {
            System.out.println("Expected exception: FinderException has occurred.");
            System.out.println(e.toString());
        } catch (ValidationException e) {
            System.out.println("Expected exception: ValidationException has occurred.");
            System.out.println(e.toString());
        } catch (OperationalException e) {
            System.out.println("Expected exception: OperationalException has occurred.");
            System.out.println(e.toString());
        } catch (ApplicationException e) {
            System.out.println("Expected exception: ApplicationException has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking finnJournalposterGittSaksmappeNoekkel...");
        no.geointegrasjon.arkiv.innsyn.Saksnoekkel _finnJournalposterGittSaksmappeNoekkel_nokkel = null;
        java.lang.Boolean _finnJournalposterGittSaksmappeNoekkel_returnerMerknad = null;
        java.lang.Boolean _finnJournalposterGittSaksmappeNoekkel_returnerTilleggsinformasjon = null;
        java.lang.Boolean _finnJournalposterGittSaksmappeNoekkel_returnerKorrespondansepart = null;
        java.lang.Boolean _finnJournalposterGittSaksmappeNoekkel_returnerAvskrivning = null;
        no.geointegrasjon.arkiv.innsyn.ArkivKontekst _finnJournalposterGittSaksmappeNoekkel_kontekst = null;
        try {
            no.geointegrasjon.arkiv.innsyn.JournalpostListe _finnJournalposterGittSaksmappeNoekkel__return = port.finnJournalposterGittSaksmappeNoekkel(_finnJournalposterGittSaksmappeNoekkel_nokkel, _finnJournalposterGittSaksmappeNoekkel_returnerMerknad, _finnJournalposterGittSaksmappeNoekkel_returnerTilleggsinformasjon, _finnJournalposterGittSaksmappeNoekkel_returnerKorrespondansepart, _finnJournalposterGittSaksmappeNoekkel_returnerAvskrivning, _finnJournalposterGittSaksmappeNoekkel_kontekst);
            System.out.println("finnJournalposterGittSaksmappeNoekkel.result=" + _finnJournalposterGittSaksmappeNoekkel__return);

        } catch (SystemException e) {
            System.out.println("Expected exception: SystemException has occurred.");
            System.out.println(e.toString());
        } catch (ImplementationException e) {
            System.out.println("Expected exception: ImplementationException has occurred.");
            System.out.println(e.toString());
        } catch (FinderException e) {
            System.out.println("Expected exception: FinderException has occurred.");
            System.out.println(e.toString());
        } catch (ValidationException e) {
            System.out.println("Expected exception: ValidationException has occurred.");
            System.out.println(e.toString());
        } catch (OperationalException e) {
            System.out.println("Expected exception: OperationalException has occurred.");
            System.out.println(e.toString());
        } catch (ApplicationException e) {
            System.out.println("Expected exception: ApplicationException has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking finnJournalposterGittNoekkel...");
        no.geointegrasjon.arkiv.innsyn.Journpostnoekkel _finnJournalposterGittNoekkel_nokkel = null;
        java.lang.Boolean _finnJournalposterGittNoekkel_returnerMerknad = null;
        java.lang.Boolean _finnJournalposterGittNoekkel_returnerTilleggsinformasjon = null;
        java.lang.Boolean _finnJournalposterGittNoekkel_returnerKorrespondansepart = null;
        java.lang.Boolean _finnJournalposterGittNoekkel_returnerAvskrivning = null;
        no.geointegrasjon.arkiv.innsyn.ArkivKontekst _finnJournalposterGittNoekkel_kontekst = null;
        try {
            no.geointegrasjon.arkiv.innsyn.JournalpostListe _finnJournalposterGittNoekkel__return = port.finnJournalposterGittNoekkel(_finnJournalposterGittNoekkel_nokkel, _finnJournalposterGittNoekkel_returnerMerknad, _finnJournalposterGittNoekkel_returnerTilleggsinformasjon, _finnJournalposterGittNoekkel_returnerKorrespondansepart, _finnJournalposterGittNoekkel_returnerAvskrivning, _finnJournalposterGittNoekkel_kontekst);
            System.out.println("finnJournalposterGittNoekkel.result=" + _finnJournalposterGittNoekkel__return);

        } catch (SystemException e) {
            System.out.println("Expected exception: SystemException has occurred.");
            System.out.println(e.toString());
        } catch (ImplementationException e) {
            System.out.println("Expected exception: ImplementationException has occurred.");
            System.out.println(e.toString());
        } catch (FinderException e) {
            System.out.println("Expected exception: FinderException has occurred.");
            System.out.println(e.toString());
        } catch (ValidationException e) {
            System.out.println("Expected exception: ValidationException has occurred.");
            System.out.println(e.toString());
        } catch (OperationalException e) {
            System.out.println("Expected exception: OperationalException has occurred.");
            System.out.println(e.toString());
        } catch (ApplicationException e) {
            System.out.println("Expected exception: ApplicationException has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking finnDokumenterGittSaksnoekkel...");
        no.geointegrasjon.arkiv.innsyn.Saksnoekkel _finnDokumenterGittSaksnoekkel_saksnokkel = null;
        java.lang.Boolean _finnDokumenterGittSaksnoekkel_returnerFil = null;
        no.geointegrasjon.arkiv.innsyn.ArkivKontekst _finnDokumenterGittSaksnoekkel_kontekst = null;
        try {
            no.geointegrasjon.arkiv.innsyn.DokumentListe _finnDokumenterGittSaksnoekkel__return = port.finnDokumenterGittSaksnoekkel(_finnDokumenterGittSaksnoekkel_saksnokkel, _finnDokumenterGittSaksnoekkel_returnerFil, _finnDokumenterGittSaksnoekkel_kontekst);
            System.out.println("finnDokumenterGittSaksnoekkel.result=" + _finnDokumenterGittSaksnoekkel__return);

        } catch (SystemException e) {
            System.out.println("Expected exception: SystemException has occurred.");
            System.out.println(e.toString());
        } catch (ImplementationException e) {
            System.out.println("Expected exception: ImplementationException has occurred.");
            System.out.println(e.toString());
        } catch (FinderException e) {
            System.out.println("Expected exception: FinderException has occurred.");
            System.out.println(e.toString());
        } catch (ValidationException e) {
            System.out.println("Expected exception: ValidationException has occurred.");
            System.out.println(e.toString());
        } catch (OperationalException e) {
            System.out.println("Expected exception: OperationalException has occurred.");
            System.out.println(e.toString());
        } catch (ApplicationException e) {
            System.out.println("Expected exception: ApplicationException has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking finnDokumenterGittJournalpostnoekkel...");
        no.geointegrasjon.arkiv.innsyn.Journpostnoekkel _finnDokumenterGittJournalpostnoekkel_journpostnokkel = null;
        java.lang.Boolean _finnDokumenterGittJournalpostnoekkel_returnerFil = null;
        no.geointegrasjon.arkiv.innsyn.ArkivKontekst _finnDokumenterGittJournalpostnoekkel_kontekst = null;
        try {
            no.geointegrasjon.arkiv.innsyn.DokumentListe _finnDokumenterGittJournalpostnoekkel__return = port.finnDokumenterGittJournalpostnoekkel(_finnDokumenterGittJournalpostnoekkel_journpostnokkel, _finnDokumenterGittJournalpostnoekkel_returnerFil, _finnDokumenterGittJournalpostnoekkel_kontekst);
            System.out.println("finnDokumenterGittJournalpostnoekkel.result=" + _finnDokumenterGittJournalpostnoekkel__return);

        } catch (SystemException e) {
            System.out.println("Expected exception: SystemException has occurred.");
            System.out.println(e.toString());
        } catch (ImplementationException e) {
            System.out.println("Expected exception: ImplementationException has occurred.");
            System.out.println(e.toString());
        } catch (FinderException e) {
            System.out.println("Expected exception: FinderException has occurred.");
            System.out.println(e.toString());
        } catch (ValidationException e) {
            System.out.println("Expected exception: ValidationException has occurred.");
            System.out.println(e.toString());
        } catch (OperationalException e) {
            System.out.println("Expected exception: OperationalException has occurred.");
            System.out.println(e.toString());
        } catch (ApplicationException e) {
            System.out.println("Expected exception: ApplicationException has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking finnSaksmapper...");
        no.geointegrasjon.arkiv.innsyn.SoekskriterieListe _finnSaksmapper_sok = null;
        java.lang.Boolean _finnSaksmapper_returnerMerknad = null;
        java.lang.Boolean _finnSaksmapper_returnerTilleggsinformasjon = null;
        java.lang.Boolean _finnSaksmapper_returnerSakspart = null;
        java.lang.Boolean _finnSaksmapper_returnerKlasse = null;
        no.geointegrasjon.arkiv.innsyn.ArkivKontekst _finnSaksmapper_kontekst = null;
        try {
            no.geointegrasjon.arkiv.innsyn.SaksmappeListe _finnSaksmapper__return = port.finnSaksmapper(_finnSaksmapper_sok, _finnSaksmapper_returnerMerknad, _finnSaksmapper_returnerTilleggsinformasjon, _finnSaksmapper_returnerSakspart, _finnSaksmapper_returnerKlasse, _finnSaksmapper_kontekst);
            System.out.println("finnSaksmapper.result=" + _finnSaksmapper__return);

        } catch (SystemException e) {
            System.out.println("Expected exception: SystemException has occurred.");
            System.out.println(e.toString());
        } catch (ImplementationException e) {
            System.out.println("Expected exception: ImplementationException has occurred.");
            System.out.println(e.toString());
        } catch (FinderException e) {
            System.out.println("Expected exception: FinderException has occurred.");
            System.out.println(e.toString());
        } catch (ValidationException e) {
            System.out.println("Expected exception: ValidationException has occurred.");
            System.out.println(e.toString());
        } catch (OperationalException e) {
            System.out.println("Expected exception: OperationalException has occurred.");
            System.out.println(e.toString());
        } catch (ApplicationException e) {
            System.out.println("Expected exception: ApplicationException has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking finnDokumenttyper...");
        no.geointegrasjon.arkiv.innsyn.Saksnoekkel _finnDokumenttyper_saksnokkel = null;
        no.geointegrasjon.arkiv.innsyn.ArkivKontekst _finnDokumenttyper_kontekst = null;
        try {
            no.geointegrasjon.arkiv.innsyn.DokumenttypeListe _finnDokumenttyper__return = port.finnDokumenttyper(_finnDokumenttyper_saksnokkel, _finnDokumenttyper_kontekst);
            System.out.println("finnDokumenttyper.result=" + _finnDokumenttyper__return);

        } catch (SystemException e) {
            System.out.println("Expected exception: SystemException has occurred.");
            System.out.println(e.toString());
        } catch (ImplementationException e) {
            System.out.println("Expected exception: ImplementationException has occurred.");
            System.out.println(e.toString());
        } catch (FinderException e) {
            System.out.println("Expected exception: FinderException has occurred.");
            System.out.println(e.toString());
        } catch (ValidationException e) {
            System.out.println("Expected exception: ValidationException has occurred.");
            System.out.println(e.toString());
        } catch (OperationalException e) {
            System.out.println("Expected exception: OperationalException has occurred.");
            System.out.println(e.toString());
        } catch (ApplicationException e) {
            System.out.println("Expected exception: ApplicationException has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking hentKodeliste...");
        java.lang.String _hentKodeliste_kodelistenavn = "";
        no.geointegrasjon.arkiv.innsyn.ArkivKontekst _hentKodeliste_kontekst = null;
        try {
            no.geointegrasjon.arkiv.innsyn.KodeListe _hentKodeliste__return = port.hentKodeliste(_hentKodeliste_kodelistenavn, _hentKodeliste_kontekst);
            System.out.println("hentKodeliste.result=" + _hentKodeliste__return);

        } catch (SystemException e) {
            System.out.println("Expected exception: SystemException has occurred.");
            System.out.println(e.toString());
        } catch (ImplementationException e) {
            System.out.println("Expected exception: ImplementationException has occurred.");
            System.out.println(e.toString());
        } catch (FinderException e) {
            System.out.println("Expected exception: FinderException has occurred.");
            System.out.println(e.toString());
        } catch (ValidationException e) {
            System.out.println("Expected exception: ValidationException has occurred.");
            System.out.println(e.toString());
        } catch (OperationalException e) {
            System.out.println("Expected exception: OperationalException has occurred.");
            System.out.println(e.toString());
        } catch (ApplicationException e) {
            System.out.println("Expected exception: ApplicationException has occurred.");
            System.out.println(e.toString());
        }

            }
        {
        System.out.println("Invoking hentFil...");
        no.geointegrasjon.arkiv.innsyn.SystemID _hentFil_systemid = null;
        no.geointegrasjon.arkiv.innsyn.ArkivKontekst _hentFil_kontekst = null;
        try {
            no.geointegrasjon.arkiv.innsyn.Fil _hentFil__return = port.hentFil(_hentFil_systemid, _hentFil_kontekst);
            System.out.println("hentFil.result=" + _hentFil__return);

        } catch (SystemException e) {
            System.out.println("Expected exception: SystemException has occurred.");
            System.out.println(e.toString());
        } catch (ImplementationException e) {
            System.out.println("Expected exception: ImplementationException has occurred.");
            System.out.println(e.toString());
        } catch (FinderException e) {
            System.out.println("Expected exception: FinderException has occurred.");
            System.out.println(e.toString());
        } catch (ValidationException e) {
            System.out.println("Expected exception: ValidationException has occurred.");
            System.out.println(e.toString());
        } catch (OperationalException e) {
            System.out.println("Expected exception: OperationalException has occurred.");
            System.out.println(e.toString());
        } catch (ApplicationException e) {
            System.out.println("Expected exception: ApplicationException has occurred.");
            System.out.println(e.toString());
        }

            }

        System.exit(0);
    }

}