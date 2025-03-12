package no.fint.geointegrasjon.model.noark;

import lombok.extern.slf4j.Slf4j;
import no.fint.model.arkiv.kodeverk.DokumentStatus;
import no.fint.model.arkiv.kodeverk.DokumentType;
import no.fint.model.arkiv.kodeverk.TilknyttetRegistreringSom;
import no.fint.model.arkiv.kodeverk.Variantformat;
import no.fint.model.arkiv.noark.Dokumentfil;
import no.fint.model.resource.Link;
import no.fint.model.resource.arkiv.noark.DokumentbeskrivelseResource;
import no.fint.model.resource.arkiv.noark.DokumentobjektResource;
import no.geointegrasjon.arkiv.innsyn.Dokument;
import no.geointegrasjon.arkiv.innsyn.Kode;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.function.Function;
import java.util.function.Supplier;

import static no.fint.geointegrasjon.utils.FintUtils.ifPresent;

@Service
@Slf4j
public class DokumentbeskrivelseMapper {
    public Function<Dokument, DokumentbeskrivelseResource> toFintResource(Supplier<DokumentbeskrivelseResource> supplier) {
        return dokument -> {
            DokumentbeskrivelseResource resource = supplier.get();
            log.debug("Dokument {} for journalpost {}", dokument.getSystemID(), dokument.getReferanseJournalpostSystemID());
            log.trace("Dokument: {}", dokument);
            ifPresent(dokument.getTittel(), resource::setTittel);
            ifPresent(dokument.getDokumentnummer(), resource::setDokumentnummer, Long::valueOf);

            ifPresent(dokument.getTilknyttetRegistreringSom(), resource::addTilknyttetRegistreringSom, Link.apply(TilknyttetRegistreringSom.class, "systemid").compose(Kode::getKodeverdi));
            ifPresent(dokument.getDokumenttype(), resource::addDokumentType, Link.apply(DokumentType.class, "systemid").compose(Kode::getKodeverdi));
            ifPresent(dokument.getDokumentstatus(), resource::addDokumentstatus, Link.apply(DokumentStatus.class, "systemid").compose(Kode::getKodeverdi));

            DokumentobjektResource o = new DokumentobjektResource();
            ifPresent(dokument.getFormat(), o::setFormat, Kode::getKodeverdi);
            ifPresent(dokument.getVariantformat(), o::addVariantFormat, Link.apply(Variantformat.class, "systemid").compose(Kode::getKodeverdi));
            ifPresent(dokument.getSystemID(), o::addReferanseDokumentfil, Link.apply(Dokumentfil.class, "systemid"));

            resource.setDokumentobjekt(Collections.singletonList(o));

            return resource;
        };
    }
}
