package no.fint.geointegrasjon.controller;

import lombok.extern.slf4j.Slf4j;
import no.fint.geointegrasjon.service.geointegrasjon.GeoIntegrasjonService;
import no.geointegrasjon.arkiv.innsyn.SaksmappeListe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SakController {

    @Autowired
    private GeoIntegrasjonService geoIntegrasjonService;

    @GetMapping("/sak/title/{title}")
    public SaksmappeListe getSak(@PathVariable String title) {
        return geoIntegrasjonService.finnSaksmapperGittTittel(title);
    }

    @GetMapping("/sak/id/{id}")
    public SaksmappeListe getSakById(@PathVariable String id) {
        return geoIntegrasjonService.finnSaksmapperGittSystemId(id);
    }

    @GetMapping("/sak/{year}/{sequence}")
    public SaksmappeListe getSakByCaseNumber(@PathVariable String year, @PathVariable String sequence) {
        return geoIntegrasjonService.finnSaksmapperGittSaksnummer(year, sequence);
    }
}
