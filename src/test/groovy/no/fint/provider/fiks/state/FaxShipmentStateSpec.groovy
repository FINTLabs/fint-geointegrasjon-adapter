package no.fint.geointegrasjon.state

import com.fasterxml.jackson.databind.ObjectMapper
import no.fint.model.felles.kompleksedatatyper.Identifikator
import no.fint.model.resource.administrasjon.arkiv.JournalpostResource
import no.fint.model.resource.kultur.kulturminnevern.TilskuddFartoyResource
import no.fint.provider.geointegrasjon.AdapterProps
import no.fint.provider.geointegrasjon.service.fint.TitleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import spock.lang.Specification

@DataMongoTest
class FaxShipmentStateSpec extends Specification {

    @Autowired
    private FaxShipmentRepository faxShipmentRepository

    private FaxShipmentState state

    void setup() {
        TitleService titleService = Mock {
            _ * getTitle(_ as Object) >> "The Test Title"
        }
        state = new FaxShipmentState(
                adapterProps: new AdapterProps(orgId: "test.no"),
                faxShipmentFactory: new FaxShipmentFactory(
                        objectMapper: new ObjectMapper(),
                        titleService: titleService),
                faxShipmentRepository: faxShipmentRepository)

        state.createFaxShipment(new TilskuddFartoyResource(
                soknadsnummer: new Identifikator(identifikatorverdi: "12345"),
                journalpost: [new JournalpostResource(dokumentbeskrivelse: [])],
                tittel: "Test title",
                fartoyNavn: "Johanne Karine",
                kallesignal: "LKQD",
                kulturminneId: "1"
        ))
        state.createFaxShipment(new TilskuddFartoyResource(
                soknadsnummer: new Identifikator(identifikatorverdi: "56789"),
                journalpost: [new JournalpostResource(dokumentbeskrivelse: [])],
                tittel: "Test title",
                fartoyNavn: "Kaia",
                kallesignal: "LM2374",
                kulturminneId: "2"
        ))

    }

    def "Get all should return a list of 2 states"() {
        when:
        def size = state.getAll().size()

        then:
        size == 2
    }

    def "Add should increase state size by 1"() {
        given:
        def beforeSize = state.getAll().size()
        state.createFaxShipment(new TilskuddFartoyResource(
                soknadsnummer: new Identifikator(identifikatorverdi: "2222"),
                journalpost: [new JournalpostResource(dokumentbeskrivelse: [])],
                tittel: "Test title",
                fartoyNavn: "Båten",
                kallesignal: "LM000",
                kulturminneId: "3"
        ))


        when:
        def afterSize = state.getAll().size()
        then:
        afterSize - beforeSize == 1
    }

    def "Get by application id should return 1 state"() {
        when:
        def applicationId = state.getByApplicationId("12345")

        then:
        applicationId
        applicationId.metadata['kallesignal'] == 'LKQD'


    }
}
