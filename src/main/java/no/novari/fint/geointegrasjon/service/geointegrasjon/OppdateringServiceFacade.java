package no.novari.fint.geointegrasjon.service.geointegrasjon;

import lombok.extern.slf4j.Slf4j;
import no.geointegrasjon.arkiv.oppdatering.*;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OppdateringServiceFacade {
    private final SakArkivOppdateringPort sakArkivOppdatering;

    public OppdateringServiceFacade(SakArkivOppdateringPort sakArkivOppdatering) {
        this.sakArkivOppdatering = sakArkivOppdatering;
    }

    public Saksmappe nySaksmappe(Saksmappe mappe, ArkivKontekst kontekst) {
        try {
            log.debug("Ny saksmappe: {}", mappe);
            final Saksmappe result = sakArkivOppdatering.nySaksmappe(mappe, kontekst);
            log.debug("Resultat: {}", result);
            return result;
        } catch (ApplicationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (ValidationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (SystemException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (FinderException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (ImplementationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (OperationalException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        }
    }

    public Journalpost nyJournalpost(Journalpost journalpost, ArkivKontekst kontekst) {
        try {
            log.debug("Ny journalpost: {}", journalpost);
            final Journalpost result = sakArkivOppdatering.nyJournalpost(journalpost, kontekst);
            log.debug("Resultat: {}", result);
            return result;
        } catch (ApplicationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (ValidationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (SystemException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (FinderException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (ImplementationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (OperationalException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        }
    }

    public Dokument nyDokument(Dokument dokument, Boolean returnerFil, ArkivKontekst kontekst) {
        try {
            log.debug("Nytt dokument: {}", dokument);
            final Dokument result = sakArkivOppdatering.nyDokument(dokument, returnerFil, kontekst);
            log.debug("Resultat: {}", result);
            return result;
        } catch (ApplicationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (ValidationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (SystemException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (FinderException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (ImplementationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (OperationalException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        }
    }

    public void oppdaterJournalpostStatus(Journalstatus journalstatus, Journpostnoekkel journalpostnokkel, ArkivKontekst kontekst)  {
        try {
            sakArkivOppdatering.oppdaterJournalpostStatus(journalstatus, journalpostnokkel, kontekst);
        } catch (ValidationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (FinderException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (SystemException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (ImplementationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (OperationalException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        } catch (ApplicationException e) {
            throw FaultHandler.handleFault(e.getFaultInfo());
        }
    }
}
