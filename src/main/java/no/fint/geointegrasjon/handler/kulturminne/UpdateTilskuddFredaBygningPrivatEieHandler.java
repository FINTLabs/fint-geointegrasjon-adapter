package no.fint.geointegrasjon.handler.kulturminne;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import no.fint.arkiv.CaseDefaults;
import no.fint.event.model.Event;
import no.fint.event.model.Operation;
import no.fint.event.model.ResponseStatus;
import no.fint.geointegrasjon.handler.Handler;
import no.fint.geointegrasjon.model.kulturminne.TilskuddFredaBygningPrivatEieExporter;
import no.fint.geointegrasjon.service.fint.*;
import no.fint.geointegrasjon.service.geointegrasjon.GeoIntegrasjonFactory;
import no.fint.model.arkiv.kulturminnevern.KulturminnevernActions;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.arkiv.kulturminnevern.TilskuddFredaBygningPrivatEieResource;
import no.geointegrasjon.arkiv.innsyn.Saksmappe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static no.fint.geointegrasjon.utils.FintUtils.createIdentifikator;
import static no.fint.geointegrasjon.utils.FintUtils.externalId;

@Service
@Slf4j
public class UpdateTilskuddFredaBygningPrivatEieHandler implements Handler {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ValidationService validationService;
    @Autowired
    private CaseQueryService caseQueryService;
    @Autowired
    private GeoIntegrasjonFactory geoIntegrasjonFactory;
    @Autowired
    private JournalpostCreator journalpostCreator;
    @Autowired
    private JournalpostService journalpostService;
    @Autowired
    private GeointegrasjonCaseDefaultsService caseDefaultsService;
    @Autowired
    private TilskuddFredaBygningPrivatEieExporter tilskuddFredaBygningPrivatEieExporter;
    @Autowired
    private CaseDefaults caseDefaults;

    @Override
    public void accept(Event<FintLinks> response) {
        if (response.getData().size() != 1) {
            response.setResponseStatus(ResponseStatus.REJECTED);
            response.setStatusCode("BAD_REQUEST");
            return;
        }

        Operation operation = response.getOperation();

        TilskuddFredaBygningPrivatEieResource tilskuddFredaBygningPrivatEieResource = objectMapper.convertValue(response.getData().get(0), TilskuddFredaBygningPrivatEieResource.class);

        if (operation == Operation.CREATE) {
            caseDefaultsService.applyDefaultsForCreation(caseDefaults.getTilskuddfredabygningprivateie(), tilskuddFredaBygningPrivatEieResource);
            log.info("Case: {}", tilskuddFredaBygningPrivatEieResource);
            if (!validationService.validate(response, tilskuddFredaBygningPrivatEieResource)) {
                return;
            }
            createCase(response, tilskuddFredaBygningPrivatEieResource);
        } else if (operation == Operation.UPDATE) {
            caseDefaultsService.applyDefaultsForUpdate(caseDefaults.getTilskuddfredabygningprivateie(), tilskuddFredaBygningPrivatEieResource);
            if (!validationService.validate(response, tilskuddFredaBygningPrivatEieResource.getJournalpost())) {
                return;
            }
            updateCase(response, response.getQuery(), tilskuddFredaBygningPrivatEieResource);
        } else {
            throw new IllegalArgumentException("Invalid operation: " + operation);
        }

        response.setResponseStatus(ResponseStatus.ACCEPTED);
        response.setData(Collections.singletonList(tilskuddFredaBygningPrivatEieResource));
    }

    private void updateCase(Event<FintLinks> event, String query, TilskuddFredaBygningPrivatEieResource resource) {
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
        journalpostService.createJournalpostForCase(caseId, resource);
    }

    private void createCase(Event<FintLinks> event, TilskuddFredaBygningPrivatEieResource resource) {

        final String caseId = journalpostCreator.createSaksmappe(geoIntegrasjonFactory.newSak(resource, externalId(resource.getSoknadsnummer()), tilskuddFredaBygningPrivatEieExporter)).getSystemID();
        resource.setSystemId(createIdentifikator(caseId));
        log.info("Case ID: {}", caseId);

        if (resource.getJournalpost() != null) {
            journalpostService.createJournalpostForCase(caseId, resource);
        }

    }

    @Override
    public Set<String> actions() {
        return Collections.singleton(KulturminnevernActions.UPDATE_TILSKUDDFREDABYGNINGPRIVATEIE.name());
    }
}
