package no.fint.geointegrasjon.model.noark;

import lombok.extern.slf4j.Slf4j;
import no.fint.geointegrasjon.service.geointegrasjon.InnsynServiceFacade;
import no.fint.geointegrasjon.utils.FintUtils;
import no.fint.model.administrasjon.arkiv.JournalStatus;
import no.fint.model.administrasjon.arkiv.JournalpostType;
import no.fint.model.administrasjon.arkiv.Part;
import no.fint.model.administrasjon.arkiv.PartRolle;
import no.fint.model.resource.Link;
import no.fint.model.resource.administrasjon.arkiv.DokumentbeskrivelseResource;
import no.fint.model.resource.administrasjon.arkiv.JournalpostResource;
import no.fint.model.resource.administrasjon.arkiv.KorrespondanseResource;
import no.geointegrasjon.arkiv.innsyn.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static no.fint.geointegrasjon.utils.FintUtils.ifPresent;
import static no.fint.geointegrasjon.utils.FintUtils.linkTo;

@Service
@Slf4j
public class JournalpostMapper {

    @Autowired
    private InnsynServiceFacade innsynServiceFacade;

    @Autowired
    private DokumentbeskrivelseMapper dokumentbeskrivelseMapper;

    public Function<Journalpost,JournalpostResource> toFintResource(Supplier<JournalpostResource> supplier) {
        return journalpost -> {
            JournalpostResource resource = supplier.get();
            log.info("Journalpost SystemID {} for sak {}", journalpost.getSystemID(), journalpost.getReferanseSakSystemID().getSystemID().getId());
            ifPresent(journalpost.getTittel(), resource::setTittel);
            ifPresent(journalpost.getOffentligTittel(), resource::setOffentligTittel);

            ifPresent(journalpost.getJournaldato(), resource::setJournalDato, FintUtils::fromXmlDate);
            ifPresent(journalpost.getDokumentetsDato(), resource::setDokumentetsDato, FintUtils::fromXmlDate);
            ifPresent(journalpost.getForfallsdato(), resource::setForfallsDato, FintUtils::fromXmlDate);

            ifPresent(journalpost.getAntallVedlegg(), resource::setAntallVedlegg, Long::valueOf);

            ifPresent(journalpost.getJournalnummer(), resource::setJournalAr, j -> j.getJournalaar().toString());
            ifPresent(journalpost.getJournalnummer(), resource::setJournalSekvensnummer, j -> j.getJournalsekvensnummer().longValueExact());
            ifPresent(journalpost.getJournalpostnummer(), resource::setJournalPostnummer, Long::valueOf);

            ifPresent(journalpost.getAntallVedlegg(), resource::setAntallVedlegg, Long::valueOf);

            ifPresent(journalpost.getMerknader(), resource::setMerknad, l -> l.getListe().stream().map(SaksmappeMapper::merknad).collect(Collectors.toList()));

            ifPresent(journalpost.getKorrespondansepart(), resource::setKorrespondansepart, p -> p.getListe().stream().map(this::part).collect(Collectors.toList()));

            ifPresent(journalpost.getJournalposttype(), resource::addJournalposttype, Link.apply(JournalpostType.class, "systemid").compose(Kode::getKodeverdi));
            ifPresent(journalpost.getJournalstatus(), resource::addJournalstatus, Link.apply(JournalStatus.class, "systemid").compose(Kode::getKodeverdi));

            resource.setDokumentbeskrivelse(new LinkedList<>());
            innsynServiceFacade
                    .finnDokumenterGittJournalSystemID(journalpost.getSystemID())
                    .getListe()
                    .stream()
                    .map(dokumentbeskrivelseMapper.toFintResource(DokumentbeskrivelseResource::new))
                    .forEach(resource.getDokumentbeskrivelse()::add);

            Optional
                    .ofNullable(journalpost.getMerknader())
                    .map(MerknadListe::getListe)
                    .map(List::stream)
                    .orElse(Stream.empty())
                    .forEach(m ->
                            log.info("{} : {}", m.getMerknadstype(), m.getMerknadstekst()));

            Optional
                    .ofNullable(journalpost.getTilleggsinformasjon())
                    .map(TilleggsinformasjonListe::getListe)
                    .map(List::stream)
                    .orElse(Stream.empty())
                    .forEach(t ->
                            log.info("{} : \"{}\"", t.getInformasjonstype().getKodeverdi(), t.getInformasjon()));


            return resource;
        };
    }

    private KorrespondanseResource part(Korrespondansepart korrespondansepart) {
        KorrespondanseResource r = new KorrespondanseResource();
        ifPresent(korrespondansepart.getKorrespondanseparttype(), r::addKorrespondanseparttype, linkTo(Link.apply(PartRolle.class, "systemid")));
        ifPresent(korrespondansepart.getKontakt(), r::addKorrespondansepart, Link.apply(Part.class, "partid").compose(SaksmappeMapper::kontakt));
        return r;
    }

}
