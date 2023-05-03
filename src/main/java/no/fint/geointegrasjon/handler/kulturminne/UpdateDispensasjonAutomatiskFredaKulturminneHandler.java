package no.fint.geointegrasjon.handler.kulturminne;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import no.fint.arkiv.CaseDefaults;
import no.fint.event.model.Event;
import no.fint.event.model.Operation;
import no.fint.event.model.ResponseStatus;
import no.fint.geointegrasjon.handler.Handler;
import no.fint.geointegrasjon.model.kulturminne.DispensasjonAutomatiskFredaKulturminneExporter;
import no.fint.geointegrasjon.service.fint.*;
import no.fint.geointegrasjon.service.geointegrasjon.GeoIntegrasjonFactory;
import no.fint.model.arkiv.kulturminnevern.KulturminnevernActions;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.arkiv.kulturminnevern.DispensasjonAutomatiskFredaKulturminneResource;
import no.geointegrasjon.arkiv.innsyn.Saksmappe;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static no.fint.geointegrasjon.utils.FintUtils.*;

@Service
@Slf4j
public class UpdateDispensasjonAutomatiskFredaKulturminneHandler implements Handler {

    private final ObjectMapper objectMapper;
    private final ValidationService validationService;
    private final CaseQueryService caseQueryService;
    private final GeoIntegrasjonFactory geoIntegrasjonFactory;
    private final JournalpostCreator journalpostCreator;
    private final JournalpostService journalpostService;
    private final GeointegrasjonCaseDefaultsService caseDefaultsService;
    private final DispensasjonAutomatiskFredaKulturminneExporter dispensasjonAutomatiskFredaKulturminneExporter;
    private final CaseDefaults caseDefaults;

    public UpdateDispensasjonAutomatiskFredaKulturminneHandler(ObjectMapper objectMapper,
                                                               ValidationService validationService,
                                                               CaseQueryService caseQueryService,
                                                               GeoIntegrasjonFactory geoIntegrasjonFactory,
                                                               JournalpostCreator journalpostCreator,
                                                               JournalpostService journalpostService,
                                                               GeointegrasjonCaseDefaultsService caseDefaultsService,
                                                               DispensasjonAutomatiskFredaKulturminneExporter dispensasjonAutomatiskFredaKulturminneExporter,
                                                               CaseDefaults caseDefaults) {

        this.objectMapper = objectMapper;
        this.validationService = validationService;
        this.caseQueryService = caseQueryService;
        this.geoIntegrasjonFactory = geoIntegrasjonFactory;
        this.journalpostCreator = journalpostCreator;
        this.journalpostService = journalpostService;
        this.caseDefaultsService = caseDefaultsService;
        this.dispensasjonAutomatiskFredaKulturminneExporter = dispensasjonAutomatiskFredaKulturminneExporter;
        this.caseDefaults = caseDefaults;
    }

    @Override
    public void accept(Event<FintLinks> response) {
        if (response.getData().size() != 1) {
            response.setResponseStatus(ResponseStatus.REJECTED);
            response.setStatusCode("BAD_REQUEST");
            return;
        }

        Operation operation = response.getOperation();

        DispensasjonAutomatiskFredaKulturminneResource resource =
                objectMapper.convertValue(response.getData().get(0), DispensasjonAutomatiskFredaKulturminneResource.class);

        if (operation == Operation.CREATE) {
            caseDefaultsService.applyDefaultsForCreation(caseDefaults.getDispensasjonautomatiskfredakulturminne(), resource);
            log.debug("Case: {}", resource);

            if (!validationService.validate(response, resource)) {
                return;
            }
            createCase(response, resource);
        } else if (operation == Operation.UPDATE) {
            caseDefaultsService.applyDefaultsForUpdate(caseDefaults.getDispensasjonautomatiskfredakulturminne(), resource);
            if (!validationService.validate(response, resource.getJournalpost())) {
                return;
            }
            updateCase(response, response.getQuery(), resource);
        } else {
            throw new IllegalArgumentException("Invalid operation: " + operation);
        }

        response.setResponseStatus(ResponseStatus.ACCEPTED);
        response.setData(Collections.singletonList(resource));
    }

    private void updateCase(Event<FintLinks> event, String query, DispensasjonAutomatiskFredaKulturminneResource resource) {
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

    private void createCase(Event<FintLinks> event, DispensasjonAutomatiskFredaKulturminneResource resource) {
        final no.geointegrasjon.arkiv.oppdatering.Saksmappe saksmappe = journalpostCreator.createSaksmappe(
                geoIntegrasjonFactory.newSak(
                        caseDefaults.getDispensasjonautomatiskfredakulturminne(),
                        resource,
                        externalId(resource.getSoknadsnummer()),
                        dispensasjonAutomatiskFredaKulturminneExporter));

        final String caseId = saksmappe.getSystemID();
        log.info("Case IDs: {} {}", caseId, saksmappe.getSaksnr());

        resource.setSystemId(createIdentifikator(caseId));
        resource.setSaksaar(String.valueOf(saksmappe.getSaksnr().getSaksaar()));
        resource.setSakssekvensnummer(String.valueOf(saksmappe.getSaksnr().getSakssekvensnummer()));
        resource.setMappeId(createIdentifikator(String.format("%d/%d", saksmappe.getSaksnr().getSaksaar(), saksmappe.getSaksnr().getSakssekvensnummer())));
        resource.setSaksdato(fromXmlDate(saksmappe.getSaksdato()));

        if (resource.getJournalpost() != null) {
            journalpostService.createJournalpostForCase(caseId, resource);
        }
    }

    @Override
    public Set<String> actions() {
        return Collections.singleton(KulturminnevernActions.UPDATE_DISPENSASJONAUTOMATISKFREDAKULTURMINNE.name());
    }
}
