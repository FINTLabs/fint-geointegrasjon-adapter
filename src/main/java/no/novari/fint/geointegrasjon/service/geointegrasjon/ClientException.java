package no.novari.fint.geointegrasjon.service.geointegrasjon;

import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

@ToString
@Getter
public class ClientException extends RuntimeException {
    private final String code;
    private final String description;
    private final List<String> details;

    public ClientException(String code, String description, List<String> details) {
        super("[" + Objects.toString(code, "") + "]: " + description);
        this.code = code;
        this.description = description;
        this.details = details;
    }
}
