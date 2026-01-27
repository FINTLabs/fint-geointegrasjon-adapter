package no.fint.geointegrasjon.handler.kulturminne;

import no.novari.fint.arkiv.CaseDefaults;
import no.fint.event.model.Event;
import no.fint.event.model.ResponseStatus;
import no.fint.geointegrasjon.handler.Handler;
import no.fint.geointegrasjon.model.kulturminne.TilskuddFredaBygningPrivatEieImporter;
import no.fint.geointegrasjon.model.noark.SaksmappeMapper;
import no.fint.geointegrasjon.service.fint.CaseQueryService;
import no.fint.geointegrasjon.service.fint.JournalpostService;
import no.novari.fint.model.arkiv.kulturminnevern.KulturminnevernActions;
import no.novari.fint.model.resource.FintLinks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Set;

@Service
public class GetTilskuddFredaBygningPrivatEieHandler implements Handler {

    @Autowired
    private CaseQueryService caseQueryService;

    @Autowired
    private SaksmappeMapper saksmappeMapper;

    @Autowired
    private JournalpostService journalpostService;

    @Autowired
    private TilskuddFredaBygningPrivatEieImporter tilskuddFredaBygningPrivatEieImporter;

    @Autowired
    private CaseDefaults caseDefaults;

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
        caseQueryService
                .query(query)
                .map(saksmappeMapper.toFintResource(caseDefaults.getTilskuddfredabygningprivateie(), tilskuddFredaBygningPrivatEieImporter, tilskuddFredaBygningPrivatEieImporter))
                .peek(journalpostService::addJournalpost)
                .forEach(response::addData);
        response.setResponseStatus(ResponseStatus.ACCEPTED);
    }

    @Override
    public Set<String> actions() {
        return Collections.singleton(KulturminnevernActions.GET_TILSKUDDFREDABYGNINGPRIVATEIE.name());
    }
}
