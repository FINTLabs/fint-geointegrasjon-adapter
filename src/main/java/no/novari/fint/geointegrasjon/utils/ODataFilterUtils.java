package no.novari.fint.geointegrasjon.utils;

import lombok.extern.slf4j.Slf4j;
import no.fint.antlr.ODataLexer;
import no.fint.antlr.ODataParser;
import no.novari.fint.geointegrasjon.exception.IllegalOdataFilter;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class ODataFilterUtils {

    // Due to Java 8, in Java 9+ you would use List.of()
    private final List<String> supportedODataProperties = Collections.unmodifiableList(Arrays.asList(
            "arkivdel", "klassifikasjon/primar/verdi", "saksdato"));

    public Object methodName(String query) {
        Map<String, String> oDataFilter = parseQuery(query);

        return "OData";
    }

    public Map<String, String> parseQuery(String query) {
        ODataLexer lexer = new ODataLexer(CharStreams.fromString(query));
        CommonTokenStream commonToken = new CommonTokenStream(lexer);
        ODataParser oDataParser = new ODataParser(commonToken);

        return oDataParser.filter().comparison().stream()
                .map(this::fromODataToGeoIntegrasjonSoekskriterie)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private Map.Entry<String, String> fromODataToGeoIntegrasjonSoekskriterie(ODataParser.ComparisonContext context) throws IllegalOdataFilter {
        String oDataProperty = context.property().getText();
        String oDataOperator = context.comparisonOperator().getText();
        String oDataValue = context.value().getText().replaceAll("'", "");

        if (!"eq".equals(oDataOperator)) {
            throw new IllegalOdataFilter(String.format("OData operator %s is not supported. Currently only support for 'eq' operator.", oDataOperator));
        }

        if (!supportedODataProperties.contains(oDataProperty)) {
            throw new IllegalOdataFilter(String.format("OData property %s is not supported", oDataProperty));
        }

        // Due to Java 8, in Java 9+ you would use Map.entry()
        return new AbstractMap.SimpleImmutableEntry<>(oDataProperty, oDataValue);
    }
}
