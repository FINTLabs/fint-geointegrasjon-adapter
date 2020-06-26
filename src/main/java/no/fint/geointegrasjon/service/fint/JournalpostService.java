package no.fint.geointegrasjon.service.fint;

import lombok.extern.slf4j.Slf4j;
import no.fint.geointegrasjon.model.noark.JournalpostMapper;
import no.fint.geointegrasjon.service.geointegrasjon.InnsynServiceFacade;
import no.fint.model.resource.administrasjon.arkiv.JournalpostResource;
import no.fint.model.resource.administrasjon.arkiv.SaksmappeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
@Slf4j
public class JournalpostService {

    @Autowired
    private InnsynServiceFacade innsynServiceFacade;

    @Autowired
    private JournalpostMapper journalpostMapper;

    @Autowired
    private DokumentbeskrivelseService dokumentbeskrivelseService;

    public void addJournalpost(SaksmappeResource sakResource) {
        sakResource.setJournalpost(new LinkedList<>());
        innsynServiceFacade
                .finnJournalposterGittSaksmappeSystemID(sakResource.getSystemId().getIdentifikatorverdi())
                .getListe()
                .stream()
                .map(journalpostMapper.toFintResource(JournalpostResource::new))
                .forEach(sakResource.getJournalpost()::add);
    }
}
