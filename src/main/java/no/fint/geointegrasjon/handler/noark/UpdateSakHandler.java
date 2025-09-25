package no.fint.geointegrasjon.handler.noark;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.extern.slf4j.Slf4j;
import no.fint.arkiv.CaseDefaults;
import no.fint.event.model.Event;
import no.fint.event.model.Operation;
import no.fint.event.model.ResponseStatus;
import no.fint.geointegrasjon.handler.Handler;
import no.fint.geointegrasjon.model.noark.SakExporter;
import no.fint.geointegrasjon.service.fint.*;
import no.fint.geointegrasjon.service.geointegrasjon.GeoIntegrasjonFactory;
import no.novari.fint.model.arkiv.noark.NoarkActions;
import no.novari.fint.model.resource.FintLinks;
import no.novari.fint.model.resource.arkiv.noark.SakResource;
import no.geointegrasjon.arkiv.innsyn.Saksmappe;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static no.fint.geointegrasjon.utils.FintUtils.createIdentifikator;

@Service
@Slf4j
public class UpdateSakHandler implements Handler {

    private final ObjectMapper objectMapper;
    private final ValidationService validationService;
    private final CaseQueryService caseQueryService;
    private final GeoIntegrasjonFactory geoIntegrasjonFactory;
    private final JournalpostCreator journalpostCreator;
    private final JournalpostService journalpostService;
    private final GeointegrasjonCaseDefaultsService caseDefaultsService;
    private final SakExporter sakExporter;
    private CaseDefaults caseDefaults;

    private final MeterRegistry meterRegistry;
    private final Timer.Builder updateSakTimer;


    public UpdateSakHandler(ObjectMapper objectMapper,
                            ValidationService validationService,
                            CaseQueryService caseQueryService,
                            GeoIntegrasjonFactory geoIntegrasjonFactory,
                            JournalpostCreator journalpostCreator,
                            JournalpostService journalpostService,
                            GeointegrasjonCaseDefaultsService caseDefaultsService,
                            SakExporter sakExporter,
                            CaseDefaults caseDefaults, MeterRegistry meterRegistry) {
        this.objectMapper = objectMapper;
        this.validationService = validationService;
        this.caseQueryService = caseQueryService;
        this.geoIntegrasjonFactory = geoIntegrasjonFactory;
        this.journalpostCreator = journalpostCreator;
        this.journalpostService = journalpostService;
        this.caseDefaultsService = caseDefaultsService;
        this.sakExporter = sakExporter;
        this.caseDefaults = caseDefaults;
        this.meterRegistry = meterRegistry;

        updateSakTimer = Timer.builder("fint.arkiv.update-sak.timer")
                .description("The P360 Archive Update Timer");
    }

    @Override
    public void accept(Event<FintLinks> response) {
        if (response.getData().size() != 1) {
            response.setResponseStatus(ResponseStatus.REJECTED);
            response.setStatusCode("BAD_REQUEST");
            return;
        }

        Timer.Sample sample = Timer.start(meterRegistry);

        Operation operation = response.getOperation();

        SakResource sakResource = objectMapper.convertValue(response.getData().get(0),
                SakResource.class);

        if (operation == Operation.CREATE) {
            caseDefaultsService.applyDefaultsForCreation(caseDefaults.getSak(), sakResource);
            log.debug("Case: {}", sakResource);

            if (!validationService.validate(response, sakResource)) {
                return;
            }
            createCase(response, sakResource);
        } else if (operation == Operation.UPDATE) {
            caseDefaultsService.applyDefaultsForUpdate(caseDefaults.getSak(), sakResource);
            if (!validationService.validate(response, sakResource.getJournalpost())) {
                return;
            }
            updateCase(response, response.getQuery(), sakResource);
        } else {
            throw new IllegalArgumentException("Invalid operation: " + operation);
        }

        response.setResponseStatus(ResponseStatus.ACCEPTED);
        response.setData(Collections.singletonList(sakResource));

        sample.stop(updateSakTimer.tag("request", "updateCase")
                .tag("status", response.getStatus().name())
                .tag("statusCode", response.getStatusCode() != null ? response.getStatusCode() : "N/A")
                .register(meterRegistry));
    }

    private void updateCase(Event<FintLinks> event, String query, SakResource resource) {
        if (!caseQueryService.isValidQuery(query)) {
            event.setStatusCode("BAD_REQUEST");
            event.setResponseStatus(ResponseStatus.REJECTED);
            event.setMessage("Invalid query: " + query);
            return;
        }
        final List<String> saksnummer = caseQueryService.query(query)
                .map(Saksmappe::getSystemID)
                .distinct()
                .collect(Collectors.toList());
        if (saksnummer.size() != 1) {
            event.setResponseStatus(ResponseStatus.ERROR);
            event.setMessage("Found " + saksnummer.size() + " cases for " + query + " - expected 1");
            return;
        }

        String caseId = saksnummer.get(0);
        resource.setSystemId(createIdentifikator(caseId));
        journalpostService.createJournalpostForCase(caseId, resource);
    }

    private void createCase(Event<FintLinks> event, SakResource resource) {

        final String caseId = journalpostCreator.createSaksmappe(geoIntegrasjonFactory
                .newSak(caseDefaults.getSak(),
                        resource,
                        null,
                        sakExporter)).getSystemID();
        resource.setSystemId(createIdentifikator(caseId));
        log.info("Case ID: {}", caseId);

        if (resource.getJournalpost() != null) {
            journalpostService.createJournalpostForCase(caseId, resource);
        }

    }

    @Override
    public Set<String> actions() {
        return Collections.singleton(NoarkActions.UPDATE_SAK.name());
    }
}
