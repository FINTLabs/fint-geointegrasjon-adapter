package no.fint.geointegrasjon.service.geointegrasjon

import no.geointegrasjon.arkiv.innsyn.ArkivInnsynPort
import no.geointegrasjon.arkiv.innsyn.SaksmappeListe
import no.geointegrasjon.arkiv.innsyn.SoekskriterieListe
import spock.lang.Specification

class InnsynServiceFacadeODataFilterSpec extends Specification {
    def arkivInnsyn = Mock(ArkivInnsynPort)

    def "odata klassifikasjon test"() {
        given:
        def query = "klassifikasjon/primar/verdi eq '123456789'"
        def capturedValue = null

        def facade = new InnsynServiceFacade(arkivInnsyn)

        arkivInnsyn.finnSaksmapper(_, _, _, _, _, _) >> { sok, _1, _2, _3, _4, _5 ->
            capturedValue = sok
            return new SaksmappeListe()
        }

        when:
        facade.finnSaksmapperGittOdataFilter(query)

        then:
        assert capturedValue.getListe().get(0).getKriterie().toString().contains("klasse.klasseID")
        assert capturedValue.getListe().get(0).getKriterie().toString().contains("123456789")
        assert !capturedValue.getListe().get(0).getKriterie().toString().contains("klassifikasjon/primar/verdi")
    }

    def "odata filter test"() {
        given:
        def capturedValue = null
        def facade = new InnsynServiceFacade(arkivInnsyn)

        arkivInnsyn.finnSaksmapper(_, _, _, _, _, _) >> { SoekskriterieListe sok, _1, _2, _3, _4, _5 ->
            capturedValue = sok
            return new SaksmappeListe()
        }
        when:
        facade.finnSaksmapperGittOdataFilter(odataFilter)

        then:
        assert capturedValue.getListe().get(0).getKriterie().toString().contains(websakFilterFeltnnavn)
        assert capturedValue.getListe().get(0).getKriterie().toString().contains(websakFilterFeltverdi)

        where:
        odataFilter                                  || websakFilterFeltnnavn || websakFilterFeltverdi
        "tittel eq 'Opplæringsmappe Ola Nordmann'"   || "tittel"              || "Opplæringsmappe Ola Nordmann"
        "klassifikasjon/primar/verdi eq '123456789'" || "klasse.klasseID"     || "123456789"
        "saksdato eq '31-12-1999'"                   || "saksdato"            || "31-12-1999"
    }
}
