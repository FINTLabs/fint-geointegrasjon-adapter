package no.novari.fint.geointegrasjon.controller;

import lombok.extern.slf4j.Slf4j;
import no.novari.fint.geointegrasjon.service.geointegrasjon.InnsynServiceFacade;
import no.geointegrasjon.arkiv.innsyn.KodeListe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class KodelisteController {

    @Autowired
    private InnsynServiceFacade innsynServiceFacade;

    @GetMapping("/kodeliste/{name}")
    public KodeListe getKodeverk(@PathVariable String name) {
        return innsynServiceFacade.hentKodeliste(name);
    }
}
