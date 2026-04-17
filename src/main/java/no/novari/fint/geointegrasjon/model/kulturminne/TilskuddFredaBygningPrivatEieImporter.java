package no.novari.fint.geointegrasjon.model.kulturminne;

import lombok.extern.slf4j.Slf4j;
import no.novari.fint.model.resource.arkiv.kulturminnevern.TilskuddFredaBygningPrivatEieResource;
import no.novari.fint.model.resource.felles.kompleksedatatyper.MatrikkelnummerResource;
import no.geointegrasjon.arkiv.innsyn.Saksmappe;
import org.jooq.lambda.function.Consumer2;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

import static no.novari.fint.geointegrasjon.utils.FintUtils.createIdentifikator;
import static no.novari.fint.geointegrasjon.utils.FintUtils.ifPresent;

@Service
@Slf4j
public class TilskuddFredaBygningPrivatEieImporter implements Consumer2<Saksmappe, TilskuddFredaBygningPrivatEieResource>, Supplier<TilskuddFredaBygningPrivatEieResource> {
    @Override
    public void accept(Saksmappe saksmappe, TilskuddFredaBygningPrivatEieResource resource) {
        ifPresent(saksmappe.getReferanseEksternNoekkel(), resource::setSoknadsnummer, r -> createIdentifikator(r.getNoekkel()));

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

    @Override
    public TilskuddFredaBygningPrivatEieResource get() {
        final TilskuddFredaBygningPrivatEieResource resource = new TilskuddFredaBygningPrivatEieResource();
        resource.setMatrikkelnummer(new MatrikkelnummerResource());
        return resource;
    }
}
