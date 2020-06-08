package no.fint.geointegrasjon.model.noark;

import lombok.extern.slf4j.Slf4j;
import no.fint.geointegrasjon.utils.FintUtils;
import no.fint.model.administrasjon.arkiv.Arkivdel;
import no.fint.model.administrasjon.arkiv.Saksstatus;
import no.fint.model.administrasjon.arkiv.*;
import no.fint.model.resource.Link;
import no.fint.model.resource.administrasjon.arkiv.MerknadResource;
import no.fint.model.resource.administrasjon.arkiv.PartsinformasjonResource;
import no.fint.model.resource.administrasjon.arkiv.SaksmappeResource;
import no.geointegrasjon.arkiv.innsyn.Merknad;
import no.geointegrasjon.arkiv.innsyn.Saksmappe;
import no.geointegrasjon.arkiv.innsyn.*;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static no.fint.geointegrasjon.utils.FintUtils.*;

@Service
@Slf4j
public class SaksmappeMapper {
    public <R extends SaksmappeResource> Function<Saksmappe, R> toFintResource(Supplier<R> supplier) {
        return saksmappe -> {
            R resource = supplier.get();
            log.info("Sak SystemID {}", saksmappe.getSystemID());
            ifPresent(saksmappe.getTittel(), resource::setTittel);
            ifPresent(saksmappe.getOffentligTittel(), resource::setOffentligTittel);
            ifPresent(saksmappe.getSaksdato(), resource::setSaksdato, FintUtils::fromXmlDate);
            setIdentifikator(saksmappe.getSystemID(), resource::setSystemId);
            setIdentifikator(saksmappe.getSaksnr(), resource::setMappeId, s -> String.format("%d/%d", s.getSaksaar(), s.getSakssekvensnummer()));
            ifPresent(saksmappe.getSaksnr(), resource::setSaksaar, s -> s.getSaksaar().toString());
            ifPresent(saksmappe.getSaksnr(), resource::setSakssekvensnummer, s -> s.getSakssekvensnummer().toString());

            ifPresent(saksmappe.getAdministrativEnhet(), resource::addAdministrativEnhet, Link.apply(AdministrativEnhet.class, "systemid"));
            ifPresent(saksmappe.getSaksstatus(), resource::addSaksstatus, Link.apply(Saksstatus.class, "systemid").compose(Kode::getKodeverdi));
            ifPresent(saksmappe.getReferanseArkivdel(), resource::addArkivdel, Link.apply(Arkivdel.class, "systemid").compose(Kode::getKodeverdi));

            ifPresent(saksmappe.getMerknader(), resource::setMerknad, l -> l.getListe().stream().map(SaksmappeMapper::merknad).collect(Collectors.toList()));
            ifPresent(saksmappe.getSakspart(), resource::setPart, p -> p.getListe().stream().map(this::part).collect(Collectors.toList()));
            return resource;
        };
    }

    private PartsinformasjonResource part(Sakspart sakspart) {
        PartsinformasjonResource r = new PartsinformasjonResource();
        ifPresent(sakspart.getSakspartRolle(), r::addPartRolle, linkTo(Link.apply(PartRolle.class, "systemid")));
        ifPresent(sakspart.getKontakt(), r::addPart, Link.apply(Part.class, "partid").compose(SaksmappeMapper::kontakt));
        return r;
    }

    public static String kontakt(Kontakt kontakt) {
        return kontakt instanceof Person
                ? ((Person) kontakt).getPersonid().getPersonidentifikatorNr()
                : ((Organisasjon) kontakt).getOrganisasjonsnummer();
    }

    public static MerknadResource merknad(Merknad merknad) {
        MerknadResource r = new MerknadResource();
        ifPresent(merknad.getMerknadRegistrertAv(), r::addMerknadRegistrertAv, Link.apply(Arkivressurs.class, "systemid"));
        ifPresent(merknad.getMerknadstype(), r::addMerknadstype, Link.apply(Merknadstype.class, "systemid"));
        ifPresent(merknad.getMerknadstekst(), r::setMerknadstekst);
        ifPresent(merknad.getMerknadsdato(), r::setMerknadsdato, FintUtils::fromXmlDate);
        return r;
    }
}
