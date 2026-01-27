package no.novari.fint.geointegrasjon.model.samferdsel;

import no.novari.fint.model.resource.arkiv.samferdsel.SoknadDrosjeloyveResource;
import no.geointegrasjon.arkiv.innsyn.Saksmappe;
import org.jooq.lambda.function.Consumer2;
import org.springframework.stereotype.Service;

@Service
public class SoknadDrosjeloyveImporter implements Consumer2<Saksmappe, SoknadDrosjeloyveResource> {

    @Override
    public void accept(Saksmappe saksmappe, SoknadDrosjeloyveResource resource) {}
}
