package no.fint.geointegrasjon.model.noark;

import lombok.extern.slf4j.Slf4j;
import no.fint.model.resource.arkiv.noark.SakResource;
import no.geointegrasjon.arkiv.innsyn.Saksmappe;
import org.jooq.lambda.function.Consumer2;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SakImporter implements Consumer2<Saksmappe, SakResource> {
    @Override
    public void accept(Saksmappe saksmappe, SakResource resource) {
        /*
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

         */
    }
}
