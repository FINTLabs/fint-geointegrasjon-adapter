package no.fint.geointegrasjon.controller;

import lombok.extern.slf4j.Slf4j;
import no.fint.geointegrasjon.service.handler.noark.KodeverkHandler;
import no.fint.model.resource.FintLinks;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class KodeverkController {

    @Autowired
    private KodeverkHandler kodeverkHandler;

    @GetMapping("/kodeverk/{name}")
    public List<? extends FintLinks> getKodeverk(@PathVariable String name) {
        Enum<?> action = kodeverkHandler
                .getSuppliers()
                .keySet()
                .stream()
                .filter(a -> StringUtils.containsIgnoreCase(a.name(), name))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
        return kodeverkHandler.getSuppliers().get(action).get().collect(Collectors.toList());
    }
}
