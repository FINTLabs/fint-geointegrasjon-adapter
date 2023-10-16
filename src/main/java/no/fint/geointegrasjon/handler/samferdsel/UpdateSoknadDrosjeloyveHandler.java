package no.fint.geointegrasjon.handler.samferdsel;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import no.fint.arkiv.CaseDefaults;
import no.fint.event.model.Event;
import no.fint.event.model.Operation;
import no.fint.event.model.ResponseStatus;
import no.fint.geointegrasjon.handler.Handler;
import no.fint.geointegrasjon.model.samferdsel.SoknadDrosjeloyveExporter;
import no.fint.geointegrasjon.service.fint.*;
import no.fint.geointegrasjon.service.geointegrasjon.GeoIntegrasjonFactory;
import no.fint.model.arkiv.samferdsel.SamferdselActions;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.arkiv.samferdsel.SoknadDrosjeloyveResource;
import no.geointegrasjon.arkiv.innsyn.Saksmappe;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static no.fint.geointegrasjon.utils.FintUtils.createIdentifikator;
import static no.fint.geointegrasjon.utils.FintUtils.fromXmlDate;

@Service
@Slf4j
public class UpdateSoknadDrosjeloyveHandler implements Handler {

    private ObjectMapper objectMapper;
    private ValidationService validationService;
    private CaseQueryService caseQueryService;
    private GeoIntegrasjonFactory geoIntegrasjonFactory;
    private JournalpostCreator journalpostCreator;
    private JournalpostService journalpostService;
    private GeointegrasjonCaseDefaultsService caseDefaultsService;
    private SoknadDrosjeloyveExporter soknadDrosjeloyveExporter;
    private CaseDefaults caseDefaults;


    public UpdateSoknadDrosjeloyveHandler(ObjectMapper objectMapper, ValidationService validationService,
        CaseQueryService caseQueryService, GeoIntegrasjonFactory geoIntegrasjonFactory, JournalpostCreator journalpostCreator,
        JournalpostService journalpostService, GeointegrasjonCaseDefaultsService caseDefaultsService, CaseDefaults caseDefaults,
        SoknadDrosjeloyveExporter soknadDrosjeloyveExporter) {
        this.objectMapper = objectMapper;
        this.validationService = validationService;
        this.caseQueryService = caseQueryService;
        this.geoIntegrasjonFactory = geoIntegrasjonFactory;
        this.journalpostCreator = journalpostCreator;
        this.journalpostService = journalpostService;
        this.caseDefaultsService = caseDefaultsService;
        this.caseDefaults = caseDefaults;
        this.soknadDrosjeloyveExporter = soknadDrosjeloyveExporter;
    }

    @Override
    public void accept(Event<FintLinks> response) {
        if (response.getData().size() != 1) {
            response.setResponseStatus(ResponseStatus.REJECTED);
            response.setStatusCode("BAD_REQUEST");
            return;
        }

        Operation operation = response.getOperation();
        SoknadDrosjeloyveResource soknadDrosjeloyveResource = objectMapper.convertValue(response.getData().get(0), SoknadDrosjeloyveResource.class);

        if (operation == Operation.CREATE) {
            caseDefaultsService.applyDefaultsForCreation(caseDefaults.getSoknaddrosjeloyve(), soknadDrosjeloyveResource);
            log.debug("Case prepared for creation: {}", soknadDrosjeloyveResource);
            if (!validationService.validate(response, soknadDrosjeloyveResource)) {
                log.warn("Validation failed!");
                return;
            }
            createCase(response, soknadDrosjeloyveResource);
        } else if (operation == Operation.UPDATE){
            caseDefaultsService.applyDefaultsForUpdate(caseDefaults.getSoknaddrosjeloyve(), soknadDrosjeloyveResource);
            log.debug("Case prepared for update: {}", soknadDrosjeloyveResource);
            if (!validationService.validate(response, soknadDrosjeloyveResource.getJournalpost())) {
                return;
            }
            updateCase(response, response.getQuery(), soknadDrosjeloyveResource);
        } else {
            throw new IllegalArgumentException("Invalid operation: "  + operation);
        }

        response.setResponseStatus(ResponseStatus.ACCEPTED);
        response.setData(Collections.singletonList(soknadDrosjeloyveResource));
    }

    private void createCase(Event<FintLinks> event, SoknadDrosjeloyveResource resource) {
        final no.geointegrasjon.arkiv.oppdatering.Saksmappe saksmappe = journalpostCreator
                .createSaksmappe(geoIntegrasjonFactory
                        .newSak(caseDefaults.getSoknaddrosjeloyve(),
                                resource,
                                resource.getOrganisasjonsnummer(),
                                soknadDrosjeloyveExporter));

        final String caseId = saksmappe.getSystemID();
        resource.setSystemId(createIdentifikator(caseId));
        resource.setSaksaar(String.valueOf(saksmappe.getSaksnr().getSaksaar()));
        resource.setSakssekvensnummer(String.valueOf(saksmappe.getSaksnr().getSakssekvensnummer()));
        resource.setMappeId(createIdentifikator(String.format("%d/%d", saksmappe.getSaksnr().getSaksaar(), saksmappe.getSaksnr().getSakssekvensnummer())));
        resource.setSaksdato(fromXmlDate(saksmappe.getSaksdato()));
        log.info("System ID: {}, MappeID: {}", resource.getSystemId(), resource.getMappeId());

        if (resource.getJournalpost() != null) {
            journalpostService.createJournalpostForCase(caseId, resource);
        }
    }

    private void updateCase(Event<FintLinks> event, String query, SoknadDrosjeloyveResource soknadDrosjeloyveResource) {
        if (!caseQueryService.isValidQuery(query)) {
            event.setStatusCode("BAD_REQUEST");
            event.setResponseStatus(ResponseStatus.REJECTED);
            event.setMessage("Invalid query: " + query);
            return;
        }

        final List<String> saksnummer = caseQueryService.query(query).map(Saksmappe::getSystemID).distinct().collect(Collectors.toList());
        if (saksnummer.size() != 1) {
            event.setResponseStatus(ResponseStatus.ERROR);
            event.setMessage(String.format("Found %s cases for %s. Expected 1 and only 1.", saksnummer.size(), query));
        }

        String caseId = saksnummer.get(0);
        log.info("About to update {}", caseId);
        soknadDrosjeloyveResource.setSystemId(createIdentifikator(caseId));
        journalpostService.createJournalpostForCase(caseId, soknadDrosjeloyveResource);
    }

    @Override
    public Set<String> actions() {
        return Collections.singleton(SamferdselActions.UPDATE_SOKNADDROSJELOYVE.name());
    }
}
