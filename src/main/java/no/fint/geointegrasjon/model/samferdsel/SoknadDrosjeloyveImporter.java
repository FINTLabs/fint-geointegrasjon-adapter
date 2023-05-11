package no.fint.geointegrasjon.model.samferdsel;

import no.fint.model.resource.arkiv.samferdsel.SoknadDrosjeloyveResource;
import no.geointegrasjon.arkiv.innsyn.Saksmappe;
import org.jooq.lambda.function.Consumer2;
import org.springframework.stereotype.Service;

import static no.fint.geointegrasjon.utils.FintUtils.createIdentifikator;
import static no.fint.geointegrasjon.utils.FintUtils.ifPresent;

@Service
public class SoknadDrosjeloyveImporter implements Consumer2<Saksmappe, SoknadDrosjeloyveResource> {

    @Override
    public void accept(Saksmappe saksmappe, SoknadDrosjeloyveResource resource) {
        ifPresent(saksmappe.getReferanseEksternNoekkel(), resource::setSystemId, r -> createIdentifikator(r.getNoekkel()));
    }
}
