package no.fint.geointegrasjon.handler.kulturminne;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import no.novari.fint.arkiv.CaseDefaults;
import no.fint.event.model.Event;
import no.fint.event.model.Operation;
import no.fint.event.model.ResponseStatus;
import no.fint.geointegrasjon.handler.Handler;
import no.fint.geointegrasjon.model.kulturminne.TilskuddFartoyExporter;
import no.fint.geointegrasjon.service.fint.*;
import no.fint.geointegrasjon.service.geointegrasjon.GeoIntegrasjonFactory;
import no.novari.fint.model.arkiv.kulturminnevern.KulturminnevernActions;
import no.novari.fint.model.resource.FintLinks;
import no.novari.fint.model.resource.arkiv.kulturminnevern.TilskuddFartoyResource;
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
public class UpdateTilskuddFartoyHandler implements Handler {

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
    private TilskuddFartoyExporter tilskuddFartoyExporter;
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

        TilskuddFartoyResource tilskuddFartoyResource = objectMapper.convertValue(response.getData().get(0), TilskuddFartoyResource.class);

        if (operation == Operation.CREATE) {
            caseDefaultsService.applyDefaultsForCreation(caseDefaults.getTilskuddfartoy(), tilskuddFartoyResource);
            log.debug("Case: {}", tilskuddFartoyResource);
            if (!validationService.validate(response, tilskuddFartoyResource)) {
                return;
            }
            createCase(response, tilskuddFartoyResource);
        } else if (operation == Operation.UPDATE) {
            caseDefaultsService.applyDefaultsForUpdate(caseDefaults.getTilskuddfartoy(), tilskuddFartoyResource);
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
        journalpostService.createJournalpostForCase(caseId, resource);
    }

    private void createCase(Event<FintLinks> event, TilskuddFartoyResource resource) {

        final String caseId = journalpostCreator.createSaksmappe(geoIntegrasjonFactory.newSak(caseDefaults.getTilskuddfartoy(), resource, externalId(resource.getSoknadsnummer()), tilskuddFartoyExporter)).getSystemID();
        resource.setSystemId(createIdentifikator(caseId));
        log.info("Case ID: {}", caseId);

        if (resource.getJournalpost() != null) {
            journalpostService.createJournalpostForCase(caseId, resource);
        }

    }

    @Override
    public Set<String> actions() {
        return Collections.singleton(KulturminnevernActions.UPDATE_TILSKUDDFARTOY.name());
    }
}
