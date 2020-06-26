package no.fint.geointegrasjon.service.geointegrasjon;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class ServerException extends RuntimeException {
    private final String code;
    private final String description;
    private final List<String> details;

    public ServerException(String code, String description, List<String> details) {
        this.code = code;
        this.description = description;
        this.details = details;
    }
}
