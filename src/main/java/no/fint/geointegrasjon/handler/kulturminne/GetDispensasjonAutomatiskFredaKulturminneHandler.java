package no.fint.geointegrasjon.handler.kulturminne;

import no.fint.arkiv.CaseDefaults;
import no.fint.event.model.Event;
import no.fint.event.model.ResponseStatus;
import no.fint.geointegrasjon.handler.Handler;
import no.fint.geointegrasjon.model.kulturminne.DispensasjonAutomatiskFredaKulturminneImporter;
import no.fint.geointegrasjon.model.noark.SaksmappeMapper;
import no.fint.geointegrasjon.service.fint.CaseQueryService;
import no.fint.geointegrasjon.service.fint.JournalpostService;
import no.novari.fint.model.arkiv.kulturminnevern.KulturminnevernActions;
import no.novari.fint.model.resource.FintLinks;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Set;

@Service
public class GetDispensasjonAutomatiskFredaKulturminneHandler implements Handler {

    private final CaseQueryService caseQueryService;

    private final SaksmappeMapper saksmappeMapper;

    private final JournalpostService journalpostService;

    private final DispensasjonAutomatiskFredaKulturminneImporter dispensasjonAutomatiskFredaKulturminneImporter;

    private final CaseDefaults caseDefaults;

    public GetDispensasjonAutomatiskFredaKulturminneHandler(CaseQueryService caseQueryService,
                                                            SaksmappeMapper saksmappeMapper,
                                                            JournalpostService journalpostService,
                                                            DispensasjonAutomatiskFredaKulturminneImporter dispensasjonAutomatiskFredaKulturminneImporter,
                                                            CaseDefaults caseDefaults) {

        this.caseQueryService = caseQueryService;
        this.saksmappeMapper = saksmappeMapper;
        this.journalpostService = journalpostService;
        this.dispensasjonAutomatiskFredaKulturminneImporter = dispensasjonAutomatiskFredaKulturminneImporter;
        this.caseDefaults = caseDefaults;
    }

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
                .map(saksmappeMapper.toFintResource(caseDefaults.getDispensasjonautomatiskfredakulturminne(),
                        dispensasjonAutomatiskFredaKulturminneImporter, dispensasjonAutomatiskFredaKulturminneImporter))
                .peek(journalpostService::addJournalpost)
                .forEach(response::addData);
        response.setResponseStatus(ResponseStatus.ACCEPTED);
    }

    @Override
    public Set<String> actions() {
        return Collections.singleton(KulturminnevernActions.GET_DISPENSASJONAUTOMATISKFREDAKULTURMINNE.name());
    }
}
