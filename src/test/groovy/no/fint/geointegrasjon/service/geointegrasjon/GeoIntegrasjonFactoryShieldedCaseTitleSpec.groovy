package no.fint.geointegrasjon.service.geointegrasjon

import no.novari.fint.arkiv.AdditionalFieldService
import no.novari.fint.arkiv.CaseProperties
import no.novari.fint.arkiv.TitleService
import no.novari.fint.model.resource.arkiv.noark.SaksmappeResource
import spock.lang.Specification

import java.util.stream.Stream

class GeoIntegrasjonFactoryShieldedCaseTitleSpec extends Specification {

    def titleService = Mock(TitleService)
    def additionalFieldService = Mock(AdditionalFieldService)

    def geoIntegrasjonFactory = new GeoIntegrasjonFactory(
            "",
            "",
            "",
            titleService,
            additionalFieldService)

    def "newSak should shield title"() {
        given:
        def resource = Mock(SaksmappeResource)
        titleService.getCaseTitle(_, _) >> "Opplæringsmappe Ola Nordmann"
        resource.getOffentligTittel() >> "Opplæringsmappe @Ola Nordmann@"
        resource.getKlasse() >> []
        resource.getAdministrativEnhet() >> []
        resource.getSaksansvarlig() >> []
        resource.getArkivdel() >> []
        resource.getJournalenhet() >> []
        resource.getSaksstatus() >> []
        resource.getSaksmappetype() >> []

        def consumer = { r, s ->  }
        additionalFieldService.getFieldsForResource(_, _) >> Stream.empty()

        when:
        def saksmappe = geoIntegrasjonFactory.newSak(new CaseProperties(), resource, "", consumer)

        then:
        saksmappe.getTittel() == "Opplæringsmappe Ola Nordmann"
        saksmappe.getOffentligTittel() == "Opplæringsmappe"
        saksmappe.isSkjermetTittel() == true
    }

    def "newSak without shielding"() {
        given:
        def resource = Mock(SaksmappeResource)
        titleService.getCaseTitle(_, _) >> "Opplæringsmappe Ola Nordmann"
        resource.getOffentligTittel() >> "Opplæringsmappe Ola Nordmann"
        resource.getKlasse() >> []
        resource.getAdministrativEnhet() >> []
        resource.getSaksansvarlig() >> []
        resource.getArkivdel() >> []
        resource.getJournalenhet() >> []
        resource.getSaksstatus() >> []
        resource.getSaksmappetype() >> []

        def consumer = { r, s -> }
        additionalFieldService.getFieldsForResource(_, _) >> Stream.empty()

        when:
        def saksmappe = geoIntegrasjonFactory.newSak(new CaseProperties(), resource, "", consumer)

        then:
        saksmappe.getTittel() == "Opplæringsmappe Ola Nordmann"
        saksmappe.getOffentligTittel() == "Opplæringsmappe Ola Nordmann"
        saksmappe.isSkjermetTittel() == null
    }

    def "newSak accept offentlig title with null value"() {
        given:
        def resource = Mock(SaksmappeResource)
        titleService.getCaseTitle(_, _) >> "Opplæringsmappe Ola Nordmann"
        resource.getOffentligTittel() >> null
        resource.getKlasse() >> []
        resource.getAdministrativEnhet() >> []
        resource.getSaksansvarlig() >> []
        resource.getArkivdel() >> []
        resource.getJournalenhet() >> []
        resource.getSaksstatus() >> []
        resource.getSaksmappetype() >> []

        def consumer = { r, s -> }
        additionalFieldService.getFieldsForResource(_, _) >> Stream.empty()

        when:
        def saksmappe = geoIntegrasjonFactory.newSak(new CaseProperties(), resource, "", consumer)

        then:
        saksmappe.getTittel() == "Opplæringsmappe Ola Nordmann"
        saksmappe.getOffentligTittel() == null
        saksmappe.isSkjermetTittel() == null
    }

    def "newSak accept offentlig title with email adress"() {
        given:
        def resource = Mock(SaksmappeResource)
        titleService.getCaseTitle(_, _) >> "Opplæringsmappe ola@nordmann.no"
        resource.getOffentligTittel() >> "Opplæringsmappe ola@nordmann.no"
        resource.getKlasse() >> []
        resource.getAdministrativEnhet() >> []
        resource.getSaksansvarlig() >> []
        resource.getArkivdel() >> []
        resource.getJournalenhet() >> []
        resource.getSaksstatus() >> []
        resource.getSaksmappetype() >> []

        def consumer = { r, s -> }
        additionalFieldService.getFieldsForResource(_, _) >> Stream.empty()

        when:
        def saksmappe = geoIntegrasjonFactory.newSak(new CaseProperties(), resource, "", consumer)

        then:
        saksmappe.getTittel() == "Opplæringsmappe ola@nordmann.no"
        saksmappe.getOffentligTittel() ==  "Opplæringsmappe ola@nordmann.no"
        saksmappe.isSkjermetTittel() == null
    }

    def "newSak accept offentlig title with two shielded words"() {
        given:
        def resource = Mock(SaksmappeResource)
        titleService.getCaseTitle(_, _) >> "Opplæringsmappe Ola Nordmann - 120188"
        resource.getOffentligTittel() >> "Opplæringsmappe @Ola Nordmann@ - @120188@"
        resource.getKlasse() >> []
        resource.getAdministrativEnhet() >> []
        resource.getSaksansvarlig() >> []
        resource.getArkivdel() >> []
        resource.getJournalenhet() >> []
        resource.getSaksstatus() >> []
        resource.getSaksmappetype() >> []

        def consumer = { r, s -> }
        additionalFieldService.getFieldsForResource(_, _) >> Stream.empty()

        when:
        def saksmappe = geoIntegrasjonFactory.newSak(new CaseProperties(), resource, "", consumer)

        then:
        saksmappe.getTittel() == "Opplæringsmappe Ola Nordmann - 120188"
        saksmappe.getOffentligTittel() ==  "Opplæringsmappe"
        saksmappe.isSkjermetTittel() == true
    }
}