package no.novari.fint.geointegrasjon.service.fint;

import lombok.extern.slf4j.Slf4j;
import no.novari.fint.geointegrasjon.model.noark.JournalpostMapper;
import no.novari.fint.geointegrasjon.repository.InternalRepository;
import no.novari.fint.geointegrasjon.service.geointegrasjon.GeoIntegrasjonFactory;
import no.novari.fint.geointegrasjon.service.geointegrasjon.InnsynServiceFacade;
import no.novari.fint.model.resource.arkiv.noark.DokumentfilResource;
import no.novari.fint.model.resource.arkiv.noark.JournalpostResource;
import no.novari.fint.model.resource.arkiv.noark.SaksmappeResource;
import no.geointegrasjon.arkiv.oppdatering.Dokument;
import no.geointegrasjon.arkiv.oppdatering.Filinnhold;
import no.geointegrasjon.arkiv.oppdatering.Journalpost;
import no.geointegrasjon.arkiv.oppdatering.Journalstatus;
import org.jooq.lambda.tuple.Tuple2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Service
@Slf4j
public class JournalpostService {

    @Autowired
    private InnsynServiceFacade innsynServiceFacade;

    @Autowired
    private JournalpostMapper journalpostMapper;

    @Autowired
    private DokumentbeskrivelseService dokumentbeskrivelseService;

    @Autowired
    private GeoIntegrasjonFactory geoIntegrasjonFactory;

    @Autowired
    private JournalpostCreator journalpostCreator;

    @Autowired
    private InternalRepository internalRepository;

    @Value("${fint.geointegrasjon.noark.3.2:true}")
    private boolean noark_3_2;

    public void addJournalpost(SaksmappeResource sakResource) {
        String caseSystemId = getCaseSystemId(sakResource);
        String caseNumber = getCaseNumber(sakResource);
        if (caseSystemId == null) {
            log.error("Kan ikke hente journalposter fordi saksmappe mangler systemId. saksnummer={}, mappeId={}, tittel={}",
                    caseNumber,
                    sakResource != null ? sakResource.getMappeId() : null,
                    sakResource != null ? sakResource.getTittel() : null);
            throw new IllegalStateException("Saksmappe mangler systemId.identifikatorverdi");
        }

        sakResource.setJournalpost(new LinkedList<>());
        no.geointegrasjon.arkiv.innsyn.JournalpostListe journalpostListe =
                innsynServiceFacade.finnJournalposterGittSaksmappeSystemID(caseSystemId);

        List<no.geointegrasjon.arkiv.innsyn.Journalpost> journalposter =
                Objects.requireNonNull(journalpostListe.getListe(),
                        "JournalpostListe.getListe() var null for saksmappe " + caseSystemId);

        log.debug("Hentet {} journalposter for saksmappe systemId={}, saksnummer={}, mappeId={}",
                journalposter.size(),
                caseSystemId,
                caseNumber,
                sakResource.getMappeId());

        for (no.geointegrasjon.arkiv.innsyn.Journalpost journalpost : journalposter) {
            try {
                sakResource.getJournalpost().add(journalpostMapper.toFintResource(JournalpostResource::new).apply(journalpost));
            } catch (Exception e) {
                log.error("Feil ved mapping av journalpost for saksmappe systemId={}, saksnummer={}, mappeId={}, journalpostSystemId={}, referanseSakSystemId={}, tittel={}",
                        caseSystemId,
                        caseNumber,
                        sakResource.getMappeId(),
                        journalpost != null ? journalpost.getSystemID() : null,
                        getReferencedCaseSystemId(journalpost),
                        journalpost != null ? journalpost.getTittel() : null,
                        e);
                throw e;
            }
        }
    }

    public void createJournalpostForCase(String caseId, SaksmappeResource resource) {
        for (JournalpostResource jp : resource.getJournalpost()) {
            final Tuple2<Journalpost, List<Tuple2<Dokument, String>>> t1 = geoIntegrasjonFactory.newJournalpost(caseId, jp);
            final Journalpost journalpost = t1.v1;
            final List<Tuple2<Dokument, String>> dokumentListe = t1.v2;
            boolean updateJournalpost = noark_3_2 && journalpost.getJournalstatus().getKodeverdi().equals("J");
            if (updateJournalpost) {
                journalpost.setJournalstatus(noark32Status(journalpost.getJournalposttype().getKodeverdi().toUpperCase(Locale.ROOT)));
                log.debug("NOARK avsnitt 3.2: Setter journalstatus til {}", journalpost.getJournalstatus());
            }

            final Journalpost createdJournalpost = journalpostCreator.createJournalpost(journalpost);

            for (Tuple2<Dokument, String> t2 : dokumentListe) {
                try {
                    final Dokument dokument = t2.v1;
                    final DokumentfilResource dokumentfilResource = internalRepository.getFile(t2.v2);
                    final Filinnhold filinnhold = geoIntegrasjonFactory.newFil(dokumentfilResource);
                    dokument.setReferanseJournalpostSystemID(createdJournalpost.getSystemID());
                    dokument.setFil(filinnhold);
                    journalpostCreator.createDokument(dokument);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (updateJournalpost) {
                log.debug("NOARK avsnitt 3.2: Oppdaterer journalstatus til J");
                Journalstatus journalstatus = new Journalstatus();
                journalstatus.setKodeverdi("J");
                journalpostCreator.oppdaterJournalpostStatus(journalstatus, createdJournalpost.getSystemID());
            }
        }
    }

    private Journalstatus noark32Status(String journalposttype) {
        Journalstatus journalstatus = new Journalstatus();
        switch (journalposttype) {
            case "I":
                journalstatus.setKodeverdi("M");
                return journalstatus;
            case "U":
            case "N":
            default:
                journalstatus.setKodeverdi("R");
                return journalstatus;
        }

    }

    private String getCaseSystemId(SaksmappeResource sakResource) {
        if (sakResource == null || sakResource.getSystemId() == null) {
            return null;
        }
        return sakResource.getSystemId().getIdentifikatorverdi();
    }

    private String getReferencedCaseSystemId(no.geointegrasjon.arkiv.innsyn.Journalpost journalpost) {
        if (journalpost == null || journalpost.getReferanseSakSystemID() == null ||
                journalpost.getReferanseSakSystemID().getSystemID() == null) {
            return null;
        }
        return journalpost.getReferanseSakSystemID().getSystemID().getId();
    }

    private String getCaseNumber(SaksmappeResource sakResource) {
        if (sakResource == null) {
            return null;
        }
        if (sakResource.getSaksaar() != null && sakResource.getSakssekvensnummer() != null) {
            return sakResource.getSaksaar() + "/" + sakResource.getSakssekvensnummer();
        }
        return sakResource.getMappeId() != null ? sakResource.getMappeId().getIdentifikatorverdi() : null;
    }
}
