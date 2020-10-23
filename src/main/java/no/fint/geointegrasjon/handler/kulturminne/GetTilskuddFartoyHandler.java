package no.fint.geointegrasjon.handler.kulturminne;

import no.fint.event.model.Event;
import no.fint.event.model.ResponseStatus;
import no.fint.geointegrasjon.handler.Handler;
import no.fint.geointegrasjon.model.kulturminne.TilskuddFartoyImporter;
import no.fint.geointegrasjon.model.noark.SaksmappeMapper;
import no.fint.geointegrasjon.service.fint.CaseQueryService;
import no.fint.geointegrasjon.service.fint.JournalpostService;
import no.fint.model.arkiv.kulturminnevern.KulturminnevernActions;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.arkiv.kulturminnevern.TilskuddFartoyResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Set;

@Service
public class GetTilskuddFartoyHandler implements Handler {

    @Autowired
    private CaseQueryService caseQueryService;

    @Autowired
    private SaksmappeMapper saksmappeMapper;

    @Autowired
    private JournalpostService journalpostService;

    @Autowired
    private TilskuddFartoyImporter tilskuddFartoyImporter;

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
        caseQueryService.query(query).map(saksmappeMapper.toFintResource(TilskuddFartoyResource::new, tilskuddFartoyImporter)).peek(journalpostService::addJournalpost).forEach(response::addData);
        response.setResponseStatus(ResponseStatus.ACCEPTED);
    }

    @Override
    public Set<String> actions() {
        return Collections.singleton(KulturminnevernActions.GET_TILSKUDDFARTOY.name());
    }
}
