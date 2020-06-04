package no.fint.geointegrasjon.controller;

import no.fint.geointegrasjon.service.geointegrasjon.GeoIntegrasjonService;
import no.geointegrasjon.arkiv.innsyn.Fil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilController {
    @Autowired
    private GeoIntegrasjonService geoIntegrasjonService;

    @GetMapping("/fil/{systemID}")
    public Fil getFileBySystemId(@PathVariable String systemID) {
        return geoIntegrasjonService.hentFil(systemID);
    }
}
