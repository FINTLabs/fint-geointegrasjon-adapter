package no.fint.geointegrasjon.model.noark;

import no.novari.fint.model.arkiv.kodeverk.Skjermingshjemmel;
import no.novari.fint.model.arkiv.kodeverk.Tilgangsrestriksjon;
import no.novari.fint.model.resource.Link;
import no.novari.fint.model.resource.arkiv.noark.SkjermingResource;
import no.geointegrasjon.arkiv.innsyn.Skjerming;
import org.springframework.stereotype.Service;

import java.util.function.Function;

import static no.fint.geointegrasjon.utils.FintUtils.ifPresent;
import static no.fint.geointegrasjon.utils.FintUtils.linkTo;

@Service
public class SkjermingMapper implements Function<Skjerming, SkjermingResource> {
    @Override
    public SkjermingResource apply(Skjerming skjerming) {
        SkjermingResource resource = new SkjermingResource();
        ifPresent(skjerming.getTilgangsrestriksjon(),
                resource::addTilgangsrestriksjon,
                linkTo(Link.apply(Tilgangsrestriksjon.class, "systemid")));
        ifPresent(skjerming.getSkjermingshjemmel(),
                resource::addSkjermingshjemmel,
                Link.apply(Skjermingshjemmel.class, "systemid"));
        return resource;
    }
}
