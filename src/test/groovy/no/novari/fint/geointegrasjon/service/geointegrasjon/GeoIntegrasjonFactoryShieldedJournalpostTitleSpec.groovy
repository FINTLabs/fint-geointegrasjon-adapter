package no.novari.fint.geointegrasjon.service.geointegrasjon

import no.novari.fint.arkiv.AdditionalFieldService
import no.novari.fint.arkiv.TitleService
import no.novari.fint.geointegrasjon.service.geointegrasjon.GeoIntegrasjonFactory
import no.novari.fint.model.resource.arkiv.noark.JournalpostResource
import spock.lang.Specification

import java.util.stream.Stream

class GeoIntegrasjonFactoryShieldedJournalpostTitleSpec extends Specification {

    def titleService = Mock(TitleService)
    def additionalFieldService = Mock(AdditionalFieldService)

    def geoIntegrasjonFactory = new GeoIntegrasjonFactory(
            "",
            "",
            "",
            titleService,
            additionalFieldService)

    def "newJournalpost should shield title"() {
        given:
        def resource = Mock(JournalpostResource)
        resource.getTittel() >> "Dokument Ola Nordmann"
        resource.getOffentligTittel() >> "Dokument @Ola Nordmann@"
        resource.getKlasse() >> []
        resource.getAdministrativEnhet() >> []
        resource.getArkivdel() >> []
        resource.getJournalenhet() >> []
        resource.getKorrespondansepart() >> []
        resource.getSaksbehandler() >> []
        resource.getJournalposttype() >> []
        resource.getJournalstatus() >> []
        resource.getDokumentbeskrivelse() >> []

        def consumer = { r, s ->  }
        additionalFieldService.getFieldsForResource(_, _) >> Stream.empty()

        when:
        def journalpost = geoIntegrasjonFactory.newJournalpost("caseId", resource)

        then:
        journalpost.v1.getTittel() == "Dokument Ola Nordmann"
        journalpost.v1.getOffentligTittel() == "Dokument"
        journalpost.v1.isSkjermetTittel() == true
    }

}