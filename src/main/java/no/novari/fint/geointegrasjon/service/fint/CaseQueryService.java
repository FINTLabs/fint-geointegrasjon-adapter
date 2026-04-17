package no.novari.fint.geointegrasjon.service.fint;

import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import no.novari.fint.geointegrasjon.exception.IllegalOdataFilter;
import no.novari.fint.geointegrasjon.service.geointegrasjon.InnsynServiceFacade;
import no.geointegrasjon.arkiv.innsyn.Saksmappe;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Stream;

@Service
@Slf4j
public class CaseQueryService {

    private final ImmutableMap<String, Function<String, Stream<Saksmappe>>> queryMap;
    private final String[] validQueries;
    private final InnsynServiceFacade innsynServiceFacade;

    public CaseQueryService(
            InnsynServiceFacade innsynServiceFacade,
            @Value("${fint.geointegrasjon.fagsystem}") String fagsystem) {
        this.innsynServiceFacade = innsynServiceFacade;
        queryMap = new ImmutableMap.Builder<String, Function<String, Stream<Saksmappe>>>()
                .put("soknadsnummer/", finnSaksmapperGittEksternNokkel(fagsystem))
                .put("mappeid/", this::finnSaksmapperGittSaksnummer)
                .put("systemid/", this::finnSaksmapperGittSystemId)
                .put("$filter=", this::finnSaksmapperGittODataFilter)
                .put("?", this::finnSaksmapperGittTittel)
                .build();
        validQueries = queryMap.keySet().toArray(new String[0]);
    }

    public boolean isValidQuery(String query) {
        return StringUtils.startsWithAny(StringUtils.lowerCase(query), validQueries);
    }

    public Stream<Saksmappe> query(String query) {
        for (String prefix : validQueries) {
            if (StringUtils.startsWithIgnoreCase(query, prefix)) {
                return queryMap.get(prefix).apply(StringUtils.removeStartIgnoreCase(query, prefix));
            }
        }
        throw new IllegalArgumentException("Invalid query: " + query);
    }

    public Stream<Saksmappe> finnSaksmapperGittSystemId(String id) {
        return innsynServiceFacade.finnSaksmapperGittSystemId(id).getListe().stream();
    }

    public Stream<Saksmappe> finnSaksmapperGittSaksnummer(String saksnummer) {
        final String[] strings = StringUtils.split(saksnummer, '/');
        return innsynServiceFacade.finnSaksmapperGittSaksnummer(strings[0], strings[1]).getListe().stream();
    }

    @Deprecated
    public Stream<Saksmappe> finnSaksmapperGittTittel(String tittel) {
        log.warn("..so you want to use this old deprecated stuff ({})?! We recommend the new fancy OData way.", tittel);

        return innsynServiceFacade.finnSaksmapperGittTittel(tittel).getListe().stream();
    }

    public Function<String, Stream<Saksmappe>> finnSaksmapperGittEksternNokkel(String fagsystem) {
        return noekkel -> innsynServiceFacade.finnSaksmapperGittEksternNokkel(fagsystem, noekkel).getListe().stream();
    }

    public Stream<Saksmappe> finnSaksmapperGittODataFilter(String query) throws IllegalOdataFilter {
        log.debug("The Odata filtered case query, proudly present to you by Paperboiz: {}", query);

        return innsynServiceFacade.finnSaksmapperGittOdataFilter(query).getListe().stream();
    }

}
