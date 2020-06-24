package no.fint.geointegrasjon.handler.kulturminne;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import no.fint.event.model.Event;
import no.fint.event.model.Operation;
import no.fint.event.model.ResponseStatus;
import no.fint.geointegrasjon.handler.Handler;
import no.fint.geointegrasjon.repository.InternalRepository;
import no.fint.geointegrasjon.service.fint.CaseDefaultsService;
import no.fint.geointegrasjon.service.fint.CaseQueryService;
import no.fint.geointegrasjon.service.fint.JournalpostCreator;
import no.fint.geointegrasjon.service.fint.ValidationService;
import no.fint.geointegrasjon.service.geointegrasjon.GeoIntegrasjonFactory;
import no.fint.geointegrasjon.utils.FintUtils;
import no.fint.model.kultur.kulturminnevern.KulturminnevernActions;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.kultur.kulturminnevern.TilskuddFartoyResource;
import no.geointegrasjon.arkiv.innsyn.Saksmappe;
import no.geointegrasjon.arkiv.oppdatering.Journalpost;
import org.jooq.lambda.tuple.Tuple;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static no.fint.geointegrasjon.utils.FintUtils.createIdentifikator;
import static no.fint.geointegrasjon.utils.FintUtils.externalId;

@Service
@Slf4j
public class UpdateTilskuddFartoyHandler implements Handler {

    private final ObjectMapper objectMapper;
    private final ValidationService validationService;
    private final CaseQueryService caseQueryService;
    private final GeoIntegrasjonFactory geoIntegrasjonFactory;
    private final JournalpostCreator journalpostCreator;
    private final InternalRepository internalRepository;
    private final CaseDefaultsService caseDefaultsService;

    public UpdateTilskuddFartoyHandler(ObjectMapper objectMapper,
                                       ValidationService validationService,
                                       CaseQueryService caseQueryService,
                                       GeoIntegrasjonFactory geoIntegrasjonFactory,
                                       JournalpostCreator journalpostCreator,
                                       InternalRepository internalRepository,
                                       CaseDefaultsService caseDefaultsService) {
        this.objectMapper = objectMapper;
        this.validationService = validationService;
        this.caseQueryService = caseQueryService;
        this.geoIntegrasjonFactory = geoIntegrasjonFactory;
        this.journalpostCreator = journalpostCreator;
        this.internalRepository = internalRepository;
        this.caseDefaultsService = caseDefaultsService;
    }

    @Override
    public void accept(Event<FintLinks> response) {
        if (response.getData().size() != 1) {
            response.setResponseStatus(ResponseStatus.REJECTED);
            response.setStatusCode("BAD_REQUEST");
            return;
        }

        Operation operation = response.getOperation();

        TilskuddFartoyResource tilskuddFartoyResource = objectMapper.convertValue(response.getData().get(0), TilskuddFartoyResource.class);

        if (operation == Operation.CREATE) {
            caseDefaultsService.applyDefaultsForCreation("tilskudd-fartoy", tilskuddFartoyResource);

            log.info("Case: {}", tilskuddFartoyResource);

            /*
            if (!validationService.validate(response, tilskuddFartoyResource)) {
                return;
            }

             */
            createCase(response, tilskuddFartoyResource);
        } else if (operation == Operation.UPDATE) {
            caseDefaultsService.applyDefaultsForUpdate("tilskudd-fartoy", tilskuddFartoyResource);
            if (!validationService.validate(response, tilskuddFartoyResource.getJournalpost())) {
                return;
            }
            updateCase(response, response.getQuery(), tilskuddFartoyResource);
        } else {
            throw new IllegalArgumentException("Invalid operation: " + operation);
        }

        response.setResponseStatus(ResponseStatus.ACCEPTED);
        response.setData(Collections.singletonList(tilskuddFartoyResource));
    }

    private void updateCase(Event<FintLinks> event, String query, TilskuddFartoyResource resource) {
        if (!caseQueryService.isValidQuery(query)) {
            event.setStatusCode("BAD_REQUEST");
            event.setResponseStatus(ResponseStatus.REJECTED);
            event.setMessage("Invalid query: " + query);
            return;
        }
        final List<String> saksnummer = caseQueryService.query(query).map(Saksmappe::getSystemID).distinct().collect(Collectors.toList());
        if (saksnummer.size() != 1) {
            event.setResponseStatus(ResponseStatus.ERROR);
            event.setMessage("Found " + saksnummer.size() + " cases for " + query + " - expected 1");
            return;
        }

        String caseId = saksnummer.get(0);
        resource.setSystemId(createIdentifikator(caseId));
        createJournalpostForCase(caseId, resource);
    }

    private void createJournalpostForCase(String caseId, TilskuddFartoyResource resource) {
        resource
                .getJournalpost()
                .stream()
                .map(jp -> geoIntegrasjonFactory.newJournalpost(caseId, jp))
                .map(t -> t.map1(journalpostCreator::createJournalpost))
                .map(t -> t.map1(Journalpost::getSystemID))
                .flatMap(t -> t.v2.stream().peek(d -> d.v1.setReferanseJournalpostSystemID(t.v1)))
                .map(t -> t.map2(internalRepository::silentGetFile))
                .map(t -> t.map2(geoIntegrasjonFactory::newFil))
                .map(Tuple.function((d, f) -> { d.setFil(f); return d;}))
                .forEach(journalpostCreator::createDokument);
    }

    private void createCase(Event<FintLinks> event, TilskuddFartoyResource resource) {

        final String caseId = journalpostCreator.createSaksmappe(geoIntegrasjonFactory.newSak(resource, externalId(resource.getSoknadsnummer()))).getSystemID();
        resource.setSystemId(createIdentifikator(caseId));
        log.info("Case ID: {}", caseId);

        if (resource.getJournalpost() != null) {
            createJournalpostForCase(caseId, resource);
        }

    }

    @Override
    public Set<String> actions() {
        return Collections.singleton(KulturminnevernActions.UPDATE_TILSKUDDFARTOY.name());
    }
}
