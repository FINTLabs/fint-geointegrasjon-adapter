package no.fint.geointegrasjon.utils;

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
        String[] uriParts = uri.split("/");
        return uriParts[uriParts.length - 1];
    }
}
