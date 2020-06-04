package no.fint.geointegrasjon.service.geointegrasjon;

import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import no.fint.geointegrasjon.AdapterProps;
import no.fint.geointegrasjon.state.FaxShipmentState;
import no.geointegrasjon.arkiv.innsyn.*;
import no.geointegrasjon.arkiv.oppdatering.OppdateringService;
import no.geointegrasjon.arkiv.oppdatering.SakArkivOppdateringPort;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.message.Message;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.security.auth.callback.CallbackHandler;
import java.math.BigInteger;
import java.util.Arrays;

@Slf4j
@Service
public class GeoIntegrasjonService {

    @Autowired
    private FaxShipmentState faxShipmentState;

    @Autowired
    private AdapterProps adapterProps;

    @Autowired
    private GeoIntegrasjonFactory geointegrasjonFactory;

    @Value("${fint.geointegrasjon.innsyn:/ArkivInnsynService.svc/ArkivInnsynService}")
    private String innsynLocation;

    @Value("${fint.geointegrasjon.oppdatering:/ArkivOppdateringService.svc/ArkivOppdateringService}")
    private String oppdateringLocation;

    private ArkivInnsynPort arkivInnsyn;
    private SakArkivOppdateringPort sakArkivOppdatering;

    @PostConstruct
    private void init() {
        arkivInnsyn = new InnsynService().getArkivInnsyn();
        sakArkivOppdatering = new OppdateringService().getSakArkivOppdatering();
        setupEndpoint(arkivInnsyn, adapterProps.getServiceUrl() + innsynLocation, adapterProps.getUsername(), adapterProps.getPassword());
        setupEndpoint(sakArkivOppdatering, adapterProps.getServiceUrl() + oppdateringLocation, adapterProps.getUsername(), adapterProps.getPassword());

    }

    public KodeListe hentKodeliste(String kodelistenavn) {
        try {
            return arkivInnsyn.hentKodeliste(kodelistenavn, null);
        } catch (SystemException | ImplementationException | FinderException | ValidationException | OperationalException | ApplicationException e) {
            throw new RuntimeException(e);
        }
    }

    public SaksmappeListe finnSaksmapperGittSystemId(String id) {
        try {
            final ObjectFactory objectFactory = new ObjectFactory();
            SakSystemId nokkel = objectFactory.createSakSystemId();
            SystemID systemID = objectFactory.createSystemID();
            systemID.setId(id);
            nokkel.setSystemID(systemID);
            return getSaksmappeListeBySaksnoekkel(nokkel);
        } catch (SystemException | ImplementationException | FinderException | ValidationException | OperationalException | ApplicationException e) {
            throw new RuntimeException(e);
        }
    }

    public SaksmappeListe finnSaksmapperGittSaksnummer(String saksaar, String sakssekvensnummer) {
        try {
            final ObjectFactory objectFactory = new ObjectFactory();
            Saksnummer nokkel = objectFactory.createSaksnummer();
            nokkel.setSaksaar(new BigInteger(saksaar));
            nokkel.setSakssekvensnummer(new BigInteger(sakssekvensnummer));
            return getSaksmappeListeBySaksnoekkel(nokkel);
        } catch (SystemException | ImplementationException | FinderException | ValidationException | OperationalException | ApplicationException e) {
            throw new RuntimeException(e);
        }
    }

    private SaksmappeListe getSaksmappeListeBySaksnoekkel(Saksnoekkel nokkel) throws SystemException, ImplementationException, FinderException, ValidationException, OperationalException, ApplicationException {
        boolean returnerMerknad = true;
        boolean returnerTilleggsinformasjon = true;
        boolean returnerSakspart = true;
        boolean returnerKlasse = true;
        ArkivKontekst kontekst = null;
        return arkivInnsyn.finnSaksmapperGittNoekkel(nokkel, returnerMerknad, returnerTilleggsinformasjon, returnerSakspart, returnerKlasse, kontekst);
    }

    public SaksmappeListe finnSaksmapperGittTittel(String tittel) {
        try {
            final ObjectFactory objectFactory = new ObjectFactory();
            SoekskriterieListe sok = objectFactory.createSoekskriterieListe();
            final Soekskriterie soekskriterie = objectFactory.createSoekskriterie();
            soekskriterie.setOperator(SoekeOperatorEnum.EQ);
            final Soekefelt soekefelt = objectFactory.createSoekefelt();
            soekefelt.setFeltnavn("tittel");
            soekefelt.setFeltverdi(tittel);
            soekskriterie.setKriterie(soekefelt);
            sok.getListe().add(soekskriterie);
            boolean returnerMerknad = false;
            boolean returnerTilleggsinformasjon = false;
            boolean returnerSakspart = false;
            boolean returnerKlasse = false;
            ArkivKontekst kontekst = null;
            return arkivInnsyn.finnSaksmapper(sok, returnerMerknad, returnerTilleggsinformasjon, returnerSakspart, returnerKlasse, kontekst);
        } catch (SystemException | ImplementationException | FinderException | ValidationException | OperationalException | ApplicationException e) {
            throw new RuntimeException(e);
        }
    }

    public JournalpostListe finnJournalposterGittSaksnummer(String saksaar, String sakssekvensnummer) {
        final ObjectFactory objectFactory = new ObjectFactory();
        Saksnummer nokkel = objectFactory.createSaksnummer();
        nokkel.setSaksaar(new BigInteger(saksaar));
        nokkel.setSakssekvensnummer(new BigInteger(sakssekvensnummer));
        return finnJournalposterGittSaksmappeNoekkel(nokkel);
    }

    private JournalpostListe finnJournalposterGittSaksmappeNoekkel(Saksnoekkel nokkel) {
        try {
            Boolean returnerMerknad = true;
            Boolean returnerTilleggsinformasjon = true;
            Boolean returnerKorrespondansepart = true;
            Boolean returnerAvskrivning = true;
            ArkivKontekst kontekst = null;
            return arkivInnsyn.finnJournalposterGittSaksmappeNoekkel(nokkel, returnerMerknad, returnerTilleggsinformasjon, returnerKorrespondansepart, returnerAvskrivning, kontekst);
        } catch (SystemException | ImplementationException | FinderException | ValidationException | OperationalException | ApplicationException e) {
            throw new RuntimeException(e);
        }
    }

    public JournalpostListe finnJournalposterGittSystemID(String id) {
        final ObjectFactory objectFactory = new ObjectFactory();
        JournpostSystemID noekkel = objectFactory.createJournpostSystemID();
        SystemID systemID = objectFactory.createSystemID();
        systemID.setId(id);
        noekkel.setSystemID(systemID);
        return finnJournalposterGittNoekkel(noekkel);
    }

    private JournalpostListe finnJournalposterGittNoekkel(Journpostnoekkel nokkel) {
        try {
            Boolean returnerMerknad = true;
            Boolean returnerTilleggsinformasjon = true;
            Boolean returnerKorrespondansepart = true;
            Boolean returnerAvskrivning = true;
            ArkivKontekst kontekst = null;
            return arkivInnsyn.finnJournalposterGittNoekkel(nokkel, returnerMerknad, returnerTilleggsinformasjon, returnerKorrespondansepart, returnerAvskrivning, kontekst);
        } catch (SystemException | ImplementationException | FinderException | ValidationException | OperationalException | ApplicationException e) {
            throw new RuntimeException(e);
        }
    }

    public DokumentListe finnDokumenterGittSaksnummer(String saksaar, String sakssekvensnummer) {
        final ObjectFactory objectFactory = new ObjectFactory();
        Saksnummer nokkel = objectFactory.createSaksnummer();
        nokkel.setSaksaar(new BigInteger(saksaar));
        nokkel.setSakssekvensnummer(new BigInteger(sakssekvensnummer));
        return finnDokumenterGittSaksnoekkel(nokkel);
    }

    public DokumentListe finnDokumenterGittSaksnoekkel(Saksnoekkel saksnokkel) {
        try {
            Boolean returnerFil = false;
            ArkivKontekst kontekst = null;
            return arkivInnsyn.finnDokumenterGittSaksnoekkel(saksnokkel, returnerFil, kontekst);
        } catch (SystemException | ImplementationException | FinderException | ValidationException | OperationalException | ApplicationException e) {
            throw new RuntimeException(e);
        }
    }

    public DokumentListe finnDokumenterGittJournalnummer(String journalaar, String journalsekvensnummer) {
        final ObjectFactory objectFactory = new ObjectFactory();
        Journalnummer journalnummer = objectFactory.createJournalnummer();
        journalnummer.setJournalaar(new BigInteger(journalaar));
        journalnummer.setJournalsekvensnummer(new BigInteger(journalsekvensnummer));
        return finnDokumenterGittJournalpostnoekkel(journalnummer);
    }

    public DokumentListe finnDokumenterGittJournalSystemID(String id) {
        final ObjectFactory objectFactory = new ObjectFactory();
        JournpostSystemID noekkel = objectFactory.createJournpostSystemID();
        SystemID systemID = objectFactory.createSystemID();
        systemID.setId(id);
        noekkel.setSystemID(systemID);
        return finnDokumenterGittJournalpostnoekkel(noekkel);
    }

    private DokumentListe finnDokumenterGittJournalpostnoekkel(Journpostnoekkel journpostnokkel) {
        try {
            Boolean returnerFil = false;
            ArkivKontekst kontekst = null;
            return arkivInnsyn.finnDokumenterGittJournalpostnoekkel(journpostnokkel, returnerFil, kontekst);
        } catch (SystemException | ImplementationException | FinderException | ValidationException | OperationalException | ApplicationException e) {
            throw new RuntimeException(e);
        }
    }

    public Fil hentFil(String id) {
        try {
            final ObjectFactory objectFactory = new ObjectFactory();
            SystemID systemid = objectFactory.createSystemID();
            systemid.setId(id);
            ArkivKontekst kontekst = null;
            return arkivInnsyn.hentFil(systemid, kontekst);
        } catch (SystemException | ImplementationException | FinderException | ValidationException | OperationalException | ApplicationException e) {
            throw new RuntimeException(e);
        }
    }

    private void setupEndpoint(Object port, String address, String username, String password) {
        final Client client = ClientProxy.getClient(port);
        client.getRequestContext().put(Message.ENDPOINT_ADDRESS, address);
        client
                .getEndpoint()
                .getOutInterceptors()
                .add(
                        new WSS4JOutInterceptor(
                                ImmutableMap.of(
                                        WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN,
                                        WSHandlerConstants.USER, username,
                                        WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT,
                                        WSHandlerConstants.PW_CALLBACK_REF, passwordCallbackHandler(password)
                                )));
    }

    private CallbackHandler passwordCallbackHandler(String password) {
        return callbacks -> Arrays
                .stream(callbacks)
                .filter(WSPasswordCallback.class::isInstance)
                .map(WSPasswordCallback.class::cast)
                .forEach(c -> c.setPassword(password));
    }

/*
    private <T> T createServiceProxy(Class<T> serviceClass, String address) {
        T port;
        Map<String, Object> props = new HashMap<>();
        //props.put("mtom-enabled", Boolean.TRUE);

        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(serviceClass);
        factory.setAddress(address);
        factory.setUsername(adapterProps.getUsername());
        factory.setPassword(adapterProps.getPassword());
        //factory.setProperties(props);
        //factory.getFeatures().add(new WSAddressingFeature());
        port = serviceClass.cast(factory.create());
        Client proxy = ClientProxy.getClient(port);
        HTTPConduit conduit = (HTTPConduit) proxy.getConduit();

        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setConnectionTimeout(adapterProps.getConnectionTimeout());
        httpClientPolicy.setReceiveTimeout(adapterProps.getReceiveTimeout());
        conduit.setClient(httpClientPolicy);
        return port;
    }
*/

}
