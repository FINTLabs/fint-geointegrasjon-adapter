package no.fint.geointegrasjon.service.fint;

import lombok.extern.slf4j.Slf4j;
import no.fint.geointegrasjon.service.geointegrasjon.OppdateringServiceFacade;
import no.geointegrasjon.arkiv.oppdatering.Dokument;
import no.geointegrasjon.arkiv.oppdatering.Journalpost;
import no.geointegrasjon.arkiv.oppdatering.Saksmappe;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JournalpostCreator {
    private final OppdateringServiceFacade oppdateringService;

    public JournalpostCreator(OppdateringServiceFacade oppdateringService) {
        this.oppdateringService = oppdateringService;
    }

    public Journalpost createJournalpost(Journalpost journalpost) {
        return oppdateringService.nyJournalpost(journalpost, null);
    }

    public Dokument createDokument(Dokument dokument) {
        return oppdateringService.nyDokument(dokument, false, null);
    }

    public Saksmappe createSaksmappe(Saksmappe saksmappe) {
        return oppdateringService.nySaksmappe(saksmappe, null);
    }
}
