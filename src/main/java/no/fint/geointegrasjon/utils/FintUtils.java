package no.fint.geointegrasjon.utils;

import lombok.extern.slf4j.Slf4j;
import no.fint.model.felles.kompleksedatatyper.Identifikator;

@Slf4j
public enum FintUtils {
    ;

    public static Identifikator createIdentifikator(String value) {
        Identifikator identifikator = new Identifikator();
        identifikator.setIdentifikatorverdi(value);
        return identifikator;
    }
}
