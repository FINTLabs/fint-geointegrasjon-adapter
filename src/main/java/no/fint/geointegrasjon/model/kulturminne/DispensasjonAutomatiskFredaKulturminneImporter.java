package no.fint.geointegrasjon.model.kulturminne;

import lombok.extern.slf4j.Slf4j;
import no.novari.fint.model.resource.arkiv.kulturminnevern.DispensasjonAutomatiskFredaKulturminneResource;
import no.novari.fint.model.resource.felles.kompleksedatatyper.MatrikkelnummerResource;
import no.geointegrasjon.arkiv.innsyn.Saksmappe;
import org.jooq.lambda.function.Consumer2;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

import static no.fint.geointegrasjon.utils.FintUtils.createIdentifikator;
import static no.fint.geointegrasjon.utils.FintUtils.ifPresent;

@Service
@Slf4j
public class DispensasjonAutomatiskFredaKulturminneImporter implements Consumer2<Saksmappe, DispensasjonAutomatiskFredaKulturminneResource>, Supplier<DispensasjonAutomatiskFredaKulturminneResource> {

    @Override
    public void accept(Saksmappe saksmappe, DispensasjonAutomatiskFredaKulturminneResource resource) {
        ifPresent(saksmappe.getReferanseEksternNoekkel(), resource::setSoknadsnummer, r -> createIdentifikator(r.getNoekkel()));
    }

    @Override
    public DispensasjonAutomatiskFredaKulturminneResource get() {
        final DispensasjonAutomatiskFredaKulturminneResource resource = new DispensasjonAutomatiskFredaKulturminneResource();
        resource.setMatrikkelnummer(new MatrikkelnummerResource());
        return resource;
    }
}
