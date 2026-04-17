package no.novari.fint.geointegrasjon.controller;

import lombok.extern.slf4j.Slf4j;
import no.novari.fint.geointegrasjon.service.geointegrasjon.InnsynServiceFacade;
import no.geointegrasjon.arkiv.innsyn.DokumentListe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DokumentController {

    @Autowired
    private InnsynServiceFacade innsynServiceFacade;

    @GetMapping("/dokument/sak/{year}/{sequence}")
    public DokumentListe getDocumentsByCaseNumber(@PathVariable String year, @PathVariable String sequence) {
        return innsynServiceFacade.finnDokumenterGittSaksnummer(year, sequence);
    }

    @GetMapping("/dokument/journal/{year}/{sequence}")
    public DokumentListe getDocumentsByRecordNumber(@PathVariable String year, @PathVariable String sequence) {
        return innsynServiceFacade.finnDokumenterGittJournalnummer(year, sequence);
    }

    @GetMapping("/dokument/journal/id/{systemID}")
    public DokumentListe getDocumentsByRecordSystemId(@PathVariable String systemID) {
        return innsynServiceFacade.finnDokumenterGittJournalSystemID(systemID);
    }
}
