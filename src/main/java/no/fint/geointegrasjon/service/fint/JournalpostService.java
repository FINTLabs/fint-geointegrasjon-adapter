package no.fint.geointegrasjon.service.fint;

import lombok.extern.slf4j.Slf4j;
import no.fint.geointegrasjon.model.noark.JournalpostMapper;
import no.fint.geointegrasjon.repository.InternalRepository;
import no.fint.geointegrasjon.service.geointegrasjon.GeoIntegrasjonFactory;
import no.fint.geointegrasjon.service.geointegrasjon.InnsynServiceFacade;
import no.fint.model.resource.arkiv.noark.JournalpostResource;
import no.fint.model.resource.arkiv.noark.SaksmappeResource;
import no.geointegrasjon.arkiv.oppdatering.Journalpost;
import org.jooq.lambda.tuple.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

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
        resource
                .getJournalpost()
                .stream()
                .map(jp -> geoIntegrasjonFactory.newJournalpost(caseId, jp))
                .map(t -> t.map1(journalpostCreator::createJournalpost))
                .map(t -> t.map1(Journalpost::getSystemID))
                .flatMap(t -> t.v2.stream().peek(d -> d.v1.setReferanseJournalpostSystemID(t.v1)))
                .map(t -> t.map2(internalRepository::silentGetFile))
                .map(t -> t.map2(geoIntegrasjonFactory::newFil))
                .map(Tuple.function((d, f) -> {
                    d.setFil(f);
                    return d;
                }))
                .forEach(journalpostCreator::createDokument);
    }

}
