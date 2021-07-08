package no.fint.geointegrasjon.utils;

import no.fint.model.resource.Link;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Stream;

public class UrlUtils {

    private UrlUtils() {
    }

    /*
    public static String getFilenameFromUri(String uri) {
        String[] uriParts = uri.split("/");
        return String.format("%s.json", uriParts[uriParts.length - 1]);
    }
     */

    public static String getFileIdFromUri(String uri) {
        return StringUtils.substringAfterLast(uri, "/");
    }

    public static Stream<String> getHrefsFromLinks(Collection<Link> collection) {
        if (collection == null) {
            return Stream.empty();
        }
        return collection.stream().filter(Objects::nonNull).map(Link::getHref).filter(StringUtils::isNotBlank);
    }
}
