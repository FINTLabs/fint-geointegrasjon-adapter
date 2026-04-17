package no.novari.fint.geointegrasjon.service.fint;

import lombok.extern.slf4j.Slf4j;
import no.novari.fint.geointegrasjon.service.geointegrasjon.OppdateringServiceFacade;
import no.geointegrasjon.arkiv.oppdatering.*;
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

    public void oppdaterJournalpostStatus(Journalstatus journalstatus, String id) {
        SystemID systemID = new SystemID();
        systemID.setId(id);
        JournpostSystemID journpostSystemID = new JournpostSystemID();
        journpostSystemID.setSystemID(systemID);
        oppdateringService.oppdaterJournalpostStatus(journalstatus, journpostSystemID, null);
    }
}
