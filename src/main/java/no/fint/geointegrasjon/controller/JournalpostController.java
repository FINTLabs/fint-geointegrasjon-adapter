package no.fint.geointegrasjon.controller;

import lombok.extern.slf4j.Slf4j;
import no.fint.geointegrasjon.service.geointegrasjon.GeoIntegrasjonService;
import no.geointegrasjon.arkiv.innsyn.JournalpostListe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class JournalpostController {

    @Autowired
    private GeoIntegrasjonService geoIntegrasjonService;

    /*

    @GetMapping("/journalpost/title/{title}")
    public JournalpostsmappeListe getJournalpost(@PathVariable String title) {
        return geoIntegrasjonService.finnJournalpostsmapperGittTittel(title);
    }
     */

    @GetMapping("/journalpost/id/{id}")
    public JournalpostListe getJournalpostById(@PathVariable String id) {
        return geoIntegrasjonService.finnJournalposterGittSystemID(id);
    }

    @GetMapping("/journalpost/{year}/{sequence}")
    public JournalpostListe getJournalpostByCaseNumber(@PathVariable String year, @PathVariable String sequence) {
        return geoIntegrasjonService.finnJournalposterGittSaksnummer(year, sequence);
    }
}
