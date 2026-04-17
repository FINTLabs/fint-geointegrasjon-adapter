package no.novari.fint.geointegrasjon.controller;

import no.novari.fint.geointegrasjon.service.geointegrasjon.InnsynServiceFacade;
import no.geointegrasjon.arkiv.innsyn.Fil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilController {
    @Autowired
    private InnsynServiceFacade innsynServiceFacade;

    @GetMapping("/fil/{systemID}")
    public Fil getFileBySystemId(@PathVariable String systemID) {
        return innsynServiceFacade.hentFil(systemID);
    }
}
