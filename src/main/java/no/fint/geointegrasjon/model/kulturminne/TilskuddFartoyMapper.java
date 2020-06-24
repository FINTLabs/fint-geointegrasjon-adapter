package no.fint.geointegrasjon.model.kulturminne;

import lombok.extern.slf4j.Slf4j;
import no.fint.model.resource.kultur.kulturminnevern.TilskuddFartoyResource;
import no.geointegrasjon.arkiv.innsyn.Saksmappe;
import org.jooq.lambda.function.Consumer2;
import org.springframework.stereotype.Service;

import static no.fint.geointegrasjon.utils.FintUtils.createIdentifikator;
import static no.fint.geointegrasjon.utils.FintUtils.ifPresent;

@Service
@Slf4j
public class TilskuddFartoyMapper implements Consumer2<Saksmappe, TilskuddFartoyResource> {
    @Override
    public void accept(Saksmappe saksmappe, TilskuddFartoyResource resource) {
        ifPresent(saksmappe.getReferanseEksternNoekkel(), resource::setSoknadsnummer, r -> createIdentifikator(r.getNoekkel()));
    }
}
