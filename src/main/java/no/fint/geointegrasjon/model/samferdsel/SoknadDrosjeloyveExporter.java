package no.fint.geointegrasjon.model.samferdsel;

import lombok.extern.slf4j.Slf4j;
import no.fint.geointegrasjon.utils.UrlUtils;
import no.novari.fint.model.resource.Link;
import no.novari.fint.model.resource.arkiv.samferdsel.SoknadDrosjeloyveResource;
import no.geointegrasjon.arkiv.oppdatering.Saksmappe;
import no.geointegrasjon.arkiv.oppdatering.Skjerming;
import no.geointegrasjon.arkiv.oppdatering.Tilgangsrestriksjon;
import org.jooq.lambda.function.Consumer2;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SoknadDrosjeloyveExporter implements Consumer2<SoknadDrosjeloyveResource, Saksmappe> {

    @Override
    public void accept(SoknadDrosjeloyveResource resource, Saksmappe saksmappe) {
        if (resource.getSkjerming() != null && saksmappe.getSkjerming() == null) {
            Skjerming skjerming = new Skjerming();
            skjerming.setSkjermingshjemmel(resource.getSkjerming().getSkjermingshjemmel()
                    .stream().map(Link::getHref).map(UrlUtils::getFileIdFromUri).findFirst().get());
            log.debug("Exporting some Skjerming goodies from the SoknadDrosjeloyveResource to the Saksmappe; '{}' (hjemmel)",
                    skjerming.getSkjermingshjemmel());

            Tilgangsrestriksjon tilgangsrestriksjon = new Tilgangsrestriksjon();
            tilgangsrestriksjon.setKodeverdi(resource.getSkjerming().getTilgangsrestriksjon()
                    .stream().map(Link::getHref).map(UrlUtils::getFileIdFromUri).findFirst().get());
            skjerming.setTilgangsrestriksjon(tilgangsrestriksjon);
            log.debug("Exporting some Skjerming goodies from the SoknadDrosjeloyveResource to the Saksmappe; '{}' (tilgangsrestriksjon)",
                    skjerming.getTilgangsrestriksjon().getKodeverdi());

            saksmappe.setSkjerming(skjerming);
        }
    }
}
