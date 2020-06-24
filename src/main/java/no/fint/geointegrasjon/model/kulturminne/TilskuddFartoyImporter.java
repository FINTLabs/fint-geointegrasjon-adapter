package no.fint.geointegrasjon.model.kulturminne;

import lombok.extern.slf4j.Slf4j;
import no.fint.model.resource.kultur.kulturminnevern.TilskuddFartoyResource;
import no.geointegrasjon.arkiv.innsyn.Saksmappe;
import no.geointegrasjon.arkiv.innsyn.Tilleggsinformasjon;
import no.geointegrasjon.arkiv.innsyn.TilleggsinformasjonListe;
import org.jooq.lambda.function.Consumer2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static no.fint.geointegrasjon.utils.FintUtils.createIdentifikator;
import static no.fint.geointegrasjon.utils.FintUtils.ifPresent;
import static org.apache.commons.lang3.StringUtils.substringAfter;
import static org.apache.commons.lang3.StringUtils.substringBefore;

@Service
@Slf4j
public class TilskuddFartoyImporter implements Consumer2<Saksmappe, TilskuddFartoyResource> {
    @Override
    public void accept(Saksmappe saksmappe, TilskuddFartoyResource resource) {
        ifPresent(saksmappe.getReferanseEksternNoekkel(), resource::setSoknadsnummer, r -> createIdentifikator(r.getNoekkel()));
        Optional.ofNullable(saksmappe.getTilleggsinformasjon())
                .map(TilleggsinformasjonListe::getListe)
                .map(List::stream)
                .orElse(Stream.empty())
                .map(Tilleggsinformasjon::getInformasjon)
                .forEach(t -> {
                    switch (substringBefore(t, ":")) {
                        case "Fartøy":
                            resource.setFartoyNavn(substringAfter(t, ": "));
                            break;
                        case "Kallesignal":
                            resource.setKallesignal(substringAfter(t, ": "));
                            break;
                        case "KulturminneID":
                            resource.setKulturminneId(substringAfter(t, ": "));
                            break;
                    }
                });
    }
}
