package no.fint.geointegrasjon.handler.noark;

import lombok.extern.slf4j.Slf4j;
import no.fint.event.model.Event;
import no.fint.event.model.ResponseStatus;
import no.fint.geointegrasjon.handler.Handler;
import no.fint.geointegrasjon.model.noark.SaksmappeMapper;
import no.fint.geointegrasjon.service.fint.CaseQueryService;
import no.fint.geointegrasjon.service.fint.JournalpostService;
import no.fint.model.administrasjon.arkiv.ArkivActions;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.administrasjon.arkiv.SakResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Set;

@Slf4j
@Service
public class GetSakHandler implements Handler {

    @Autowired
    private SaksmappeMapper saksmappeMapper;

    @Autowired
    private JournalpostService journalpostService;

    @Autowired
    private CaseQueryService caseQueryService;

    @Override
    public void accept(Event<FintLinks> response) {
        String query = response.getQuery();
        if (!caseQueryService.isValidQuery(query)) {
            response.setResponseStatus(ResponseStatus.REJECTED);
            response.setStatusCode("BAD_REQUEST");
            response.setMessage("Invalid query: " + query);
            return;
        }
        response.setData(new LinkedList<>());
        caseQueryService.query(query).map(saksmappeMapper.toFintResource(SakResource::new, (a,b) -> {})).peek(journalpostService::addJournalpost).forEach(response::addData);
        response.setResponseStatus(ResponseStatus.ACCEPTED);
    }

    @Override
    public Set<String> actions() {
        return Collections.singleton(ArkivActions.GET_SAK.name());
    }

}
