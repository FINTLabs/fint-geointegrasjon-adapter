package no.fint.geointegrasjon.handler.samferdsel;

import lombok.extern.slf4j.Slf4j;
import no.fint.arkiv.CaseDefaults;
import no.fint.event.model.Event;
import no.fint.event.model.ResponseStatus;
import no.fint.geointegrasjon.handler.Handler;
import no.fint.geointegrasjon.model.noark.SaksmappeMapper;
import no.fint.geointegrasjon.model.samferdsel.SoknadDrosjeloyveImporter;
import no.fint.geointegrasjon.service.fint.CaseQueryService;
import no.fint.geointegrasjon.service.fint.JournalpostService;
import no.novari.fint.model.arkiv.samferdsel.SamferdselActions;
import no.novari.fint.model.resource.FintLinks;
import no.novari.fint.model.resource.arkiv.samferdsel.SoknadDrosjeloyveResource;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Set;

@Service
@Slf4j
public class GetSoknadDrosjeloyveHandler implements Handler {

    private CaseQueryService caseQueryService;
    private SaksmappeMapper saksmappeMapper;
    private JournalpostService journalpostService;
    private CaseDefaults caseDefaults;
    private SoknadDrosjeloyveImporter soknadDrosjeloyveImporter;

    public GetSoknadDrosjeloyveHandler(CaseQueryService caseQueryService, SaksmappeMapper saksmappeMapper,
        JournalpostService journalpostService, CaseDefaults caseDefaults, SoknadDrosjeloyveImporter soknadDrosjeloyveImporter) {
        this.caseQueryService = caseQueryService;
        this.saksmappeMapper = saksmappeMapper;
        this.journalpostService = journalpostService;
        this.caseDefaults = caseDefaults;
        this.soknadDrosjeloyveImporter = soknadDrosjeloyveImporter;
    }

    @Override
    public void accept(Event<FintLinks> response) {
        String query = response.getQuery();
        log.info("Lé query, monsieur: {}", query);

        if (!caseQueryService.isValidQuery(query)) {
            response.setResponseStatus(ResponseStatus.REJECTED);
            response.setStatusCode("BAD_REQUEST");
            response.setMessage("Invalid query: " + query);
            return;
        }

        response.setData(new LinkedList<>());

        caseQueryService
                .query(query)
                .map(saksmappeMapper.toFintResource(caseDefaults.getSoknaddrosjeloyve(), SoknadDrosjeloyveResource::new, soknadDrosjeloyveImporter))
                .peek(journalpostService::addJournalpost)
                .forEach(response::addData);

        response.setResponseStatus(ResponseStatus.ACCEPTED);
    }

    @Override
    public Set<String> actions() {
        return Collections.singleton(SamferdselActions.GET_SOKNADDROSJELOYVE.name());
    }
}
