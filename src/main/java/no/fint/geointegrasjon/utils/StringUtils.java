package no.fint.geointegrasjon.utils;

import java.util.function.Predicate;

public class StringUtils {

    public static Predicate<String> endsWith(String suffix) {
        return str -> org.apache.commons.lang3.StringUtils.endsWith(str, suffix);
    }

    public static Predicate<String> stringEquals(String value) {
        return str -> org.apache.commons.lang3.StringUtils.equals(str, value);
    }
}
