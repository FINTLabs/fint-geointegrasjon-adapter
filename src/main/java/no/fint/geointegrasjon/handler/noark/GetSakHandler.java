package no.fint.geointegrasjon.handler.noark;

import lombok.extern.slf4j.Slf4j;
import no.fint.arkiv.CaseProperties;
import no.fint.event.model.Event;
import no.fint.event.model.ResponseStatus;
import no.fint.geointegrasjon.handler.Handler;
import no.fint.geointegrasjon.model.noark.SakImporter;
import no.fint.geointegrasjon.model.noark.SaksmappeMapper;
import no.fint.geointegrasjon.service.fint.CaseQueryService;
import no.fint.geointegrasjon.service.fint.JournalpostService;
import no.fint.model.arkiv.noark.NoarkActions;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.arkiv.noark.SakResource;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Set;

@Service
@Slf4j
public class GetSakHandler implements Handler {

    private final CaseQueryService caseQueryService;
    private final SaksmappeMapper saksmappeMapper;
    private final JournalpostService journalpostService;
    private final SakImporter sakImporter;

    public GetSakHandler(CaseQueryService caseQueryService,
                         SaksmappeMapper saksmappeMapper,
                         JournalpostService journalpostService,
                         SakImporter sakImporter) {
        this.caseQueryService = caseQueryService;
        this.saksmappeMapper = saksmappeMapper;
        this.journalpostService = journalpostService;
        this.sakImporter = sakImporter;
    }

    @Override
    public void accept(Event<FintLinks> response) {
        String query = response.getQuery();
        log.debug("Currently dealing with this query: {}", query);

        if (!caseQueryService.isValidQuery(query)) {
            response.setResponseStatus(ResponseStatus.REJECTED);
            response.setStatusCode("BAD_REQUEST");
            response.setMessage("Invalid query: " + query);
            return;
        }
        response.setData(new LinkedList<>());
        caseQueryService.query(query)
                .map(saksmappeMapper.toFintResource(new CaseProperties(), SakResource::new, sakImporter))
                .peek(sak -> {
                    if (!query.contains("$filter")) {
                        journalpostService.addJournalpost(sak);
                    }
                })
                .forEach(response::addData);
        response.setResponseStatus(ResponseStatus.ACCEPTED);
    }

    @Override
    public Set<String> actions() {
        return Collections.singleton(NoarkActions.GET_SAK.name());
    }
}
