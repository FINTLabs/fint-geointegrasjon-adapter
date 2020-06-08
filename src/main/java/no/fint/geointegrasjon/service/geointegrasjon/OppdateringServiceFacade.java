package no.fint.geointegrasjon.service.geointegrasjon;

import no.geointegrasjon.arkiv.oppdatering.*;
import org.springframework.stereotype.Service;

@Service
public class OppdateringServiceFacade {
    private final SakArkivOppdateringPort sakArkivOppdatering;

    public OppdateringServiceFacade(SakArkivOppdateringPort sakArkivOppdatering) {
        this.sakArkivOppdatering = sakArkivOppdatering;
    }

    public Saksmappe nySaksmappe(Saksmappe mappe, ArkivKontekst kontekst)  {
        try {
            return sakArkivOppdatering.nySaksmappe(mappe, kontekst);
        } catch (ValidationException | FinderException | SystemException | ImplementationException | OperationalException | ApplicationException e) {
            throw new RuntimeException(e);
        }
    }

    public Journalpost nyJournalpost(Journalpost journalpost, ArkivKontekst kontekst)  {
        try {
            return sakArkivOppdatering.nyJournalpost(journalpost, kontekst);
        } catch (ValidationException | FinderException | SystemException | ImplementationException | OperationalException | ApplicationException e) {
            throw new RuntimeException(e);
        }
    }

    public Dokument nyDokument(Dokument dokument, Boolean returnerFil, ArkivKontekst kontekst)  {
        try {
            return sakArkivOppdatering.nyDokument(dokument, returnerFil, kontekst);
        } catch (ValidationException | FinderException | SystemException | ImplementationException | OperationalException | ApplicationException e) {
            throw new RuntimeException(e);
        }
    }
}
