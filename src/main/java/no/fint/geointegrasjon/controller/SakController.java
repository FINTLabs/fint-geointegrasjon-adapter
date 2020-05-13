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

    @GetMapping("/sak/{title}")
    public SaksmappeListe getSak(@PathVariable String title) {
        return geoIntegrasjonService.finnSaksmapper(title);
    }
}
