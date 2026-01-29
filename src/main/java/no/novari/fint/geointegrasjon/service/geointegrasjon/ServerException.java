package no.novari.fint.geointegrasjon.service.geointegrasjon;

import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

@Getter
@ToString
public class ServerException extends RuntimeException {
    private final String code;
    private final String description;
    private final List<String> details;

    public ServerException(String code, String description, List<String> details) {
        super("[" + Objects.toString(code, "") + "]: " + description);
        this.code = code;
        this.description = description;
        this.details = details;
    }
}
