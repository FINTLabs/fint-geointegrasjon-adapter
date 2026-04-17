package no.novari.fint.geointegrasjon.service.geointegrasjon;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Throwable cause) {
        super(cause.getMessage(), cause);
    }
}
