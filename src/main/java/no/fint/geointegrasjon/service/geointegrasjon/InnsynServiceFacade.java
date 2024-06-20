package no.fint.geointegrasjon.service.geointegrasjon;

import lombok.extern.slf4j.Slf4j;
import no.fint.geointegrasjon.utils.ODataFilterUtils;
import no.geointegrasjon.arkiv.innsyn.*;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
@Slf4j
public class InnsynServiceFacade {
    private final ArkivInnsynPort arkivInnsyn;

    public InnsynServiceFacade(ArkivInnsynPort arkivInnsyn) {
        this.arkivInnsyn = arkivInnsyn;
    }

    public KodeListe hentKodeliste(String kodelistenavn) {
        try {
            return arkivInnsyn.hentKodeliste(kodelistenavn, null);
        } catch (ApplicationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (ValidationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (SystemException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (FinderException e) {
            throw new NotFoundException(FaultHandler.handleFault(e.getFaultInfo()));
        } catch (ImplementationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (OperationalException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
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
        } catch (ApplicationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (ValidationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (SystemException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (FinderException e) {
            throw new NotFoundException(FaultHandler.handleFault(e.getFaultInfo()));
        } catch (ImplementationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (OperationalException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        }
    }

    public SaksmappeListe finnSaksmapperGittSaksnummer(String saksaar, String sakssekvensnummer) {
        try {
            final ObjectFactory objectFactory = new ObjectFactory();
            Saksnummer nokkel = objectFactory.createSaksnummer();
            nokkel.setSaksaar(new BigInteger(saksaar));
            nokkel.setSakssekvensnummer(new BigInteger(sakssekvensnummer));
            return getSaksmappeListeBySaksnoekkel(nokkel);
        } catch (ApplicationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (ValidationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (SystemException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (FinderException e) {
            throw new NotFoundException(FaultHandler.handleFault(e.getFaultInfo()));
        } catch (ImplementationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (OperationalException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        }
    }

    public SaksmappeListe finnSaksmapperGittEksternNokkel(String fagsystem, String noekkel) {
        try {
            final ObjectFactory objectFactory = new ObjectFactory();
            final EksternNoekkel eksternNoekkel = objectFactory.createEksternNoekkel();
            eksternNoekkel.setFagsystem(fagsystem);
            eksternNoekkel.setNoekkel(noekkel);
            SakEksternNoekkel sakEksternNoekkel = objectFactory.createSakEksternNoekkel();
            sakEksternNoekkel.setEksternnoekkel(eksternNoekkel);
            return getSaksmappeListeBySaksnoekkel(sakEksternNoekkel);
        } catch (ApplicationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (ValidationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (SystemException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (FinderException e) {
            throw new NotFoundException(FaultHandler.handleFault(e.getFaultInfo()));
        } catch (ImplementationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (OperationalException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        }
    }

    private SaksmappeListe getSaksmappeListeBySaksnoekkel(Saksnoekkel nokkel) throws SystemException, ImplementationException, FinderException, ValidationException, OperationalException, ApplicationException {
        log.info("Finn saksmapper gitt {}", nokkel);
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
        } catch (ApplicationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (ValidationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (SystemException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (FinderException e) {
            throw new NotFoundException(FaultHandler.handleFault(e.getFaultInfo()));
        } catch (ImplementationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (OperationalException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        }
    }

    public SaksmappeListe finnSaksmapperGittOdataFilter(String query) {
        ODataFilterUtils oDataFilterUtils = new ODataFilterUtils();

        return finnSaksmapperGittTittel(query);
    }

    public JournalpostListe finnJournalposterGittSaksnummer(String saksaar, String sakssekvensnummer) {
        final ObjectFactory objectFactory = new ObjectFactory();
        Saksnummer nokkel = objectFactory.createSaksnummer();
        nokkel.setSaksaar(new BigInteger(saksaar));
        nokkel.setSakssekvensnummer(new BigInteger(sakssekvensnummer));
        return finnJournalposterGittSaksmappeNoekkel(nokkel);
    }

    public JournalpostListe finnJournalposterGittSaksmappeSystemID(String id) {
        final ObjectFactory objectFactory = new ObjectFactory();
        SakSystemId nokkel = objectFactory.createSakSystemId();
        SystemID systemID = objectFactory.createSystemID();
        systemID.setId(id);
        nokkel.setSystemID(systemID);
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
        } catch (ApplicationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (ValidationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (SystemException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (FinderException e) {
            throw new NotFoundException(FaultHandler.handleFault(e.getFaultInfo()));
        } catch (ImplementationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (OperationalException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
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
        } catch (ApplicationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (ValidationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (SystemException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (FinderException e) {
            throw new NotFoundException(FaultHandler.handleFault(e.getFaultInfo()));
        } catch (ImplementationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (OperationalException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
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
        } catch (ApplicationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (ValidationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (SystemException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (FinderException e) {
            throw new NotFoundException(FaultHandler.handleFault(e.getFaultInfo()));
        } catch (ImplementationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (OperationalException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
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
        } catch (ApplicationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (ValidationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (SystemException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (FinderException e) {
            throw new NotFoundException(FaultHandler.handleFault(e.getFaultInfo()));
        } catch (ImplementationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (OperationalException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        }
    }

    public Fil hentFil(String id) {
        try {
            final ObjectFactory objectFactory = new ObjectFactory();
            SystemID systemid = objectFactory.createSystemID();
            systemid.setId(id);
            ArkivKontekst kontekst = null;
            return arkivInnsyn.hentFil(systemid, kontekst);
        } catch (ApplicationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (ValidationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (SystemException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (FinderException e) {
            throw new NotFoundException(FaultHandler.handleFault(e.getFaultInfo()));
        } catch (ImplementationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (OperationalException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        }
    }

}
