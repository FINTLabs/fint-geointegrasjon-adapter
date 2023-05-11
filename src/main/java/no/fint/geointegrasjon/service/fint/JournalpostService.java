package no.fint.geointegrasjon.service.fint;

import lombok.extern.slf4j.Slf4j;
import no.fint.geointegrasjon.model.noark.JournalpostMapper;
import no.fint.geointegrasjon.repository.InternalRepository;
import no.fint.geointegrasjon.service.geointegrasjon.GeoIntegrasjonFactory;
import no.fint.geointegrasjon.service.geointegrasjon.InnsynServiceFacade;
import no.fint.model.resource.arkiv.noark.DokumentfilResource;
import no.fint.model.resource.arkiv.noark.JournalpostResource;
import no.fint.model.resource.arkiv.noark.SaksmappeResource;
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
        sakResource.setJournalpost(new LinkedList<>());
        innsynServiceFacade
                .finnJournalposterGittSaksmappeSystemID(sakResource.getSystemId().getIdentifikatorverdi())
                .getListe()
                .stream()
                .map(journalpostMapper.toFintResource(JournalpostResource::new))
                .forEach(sakResource.getJournalpost()::add);
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
}
