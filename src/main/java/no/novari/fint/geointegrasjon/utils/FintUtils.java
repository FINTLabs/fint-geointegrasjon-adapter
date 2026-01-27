package no.novari.fint.geointegrasjon.utils;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import no.novari.fint.model.FintMainObject;
import no.novari.fint.model.felles.kompleksedatatyper.Identifikator;
import no.novari.fint.model.resource.FintLinks;
import no.novari.fint.model.resource.Link;
import no.novari.fint.model.resource.arkiv.noark.SkjermingResource;
import no.geointegrasjon.arkiv.innsyn.Kode;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

@Slf4j
public enum FintUtils {
    ;

    public static Identifikator createIdentifikator(String value) {
        Identifikator identifikator = new Identifikator();
        identifikator.setIdentifikatorverdi(value);
        return identifikator;
    }

    public static <T extends FintMainObject> T initializeIdentifiers(T object) {
        for (PropertyDescriptor pd : PropertyUtils.getPropertyDescriptors(object)) {
            if (pd.getPropertyType().isAssignableFrom(Identifikator.class)) {
                try {
                    PropertyUtils.setProperty(object, pd.getName(), new Identifikator());
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ignore) {
                }
            }
        }
        return object;
    }

    public static Date fromXmlDate(XMLGregorianCalendar xmlGregorianCalendar) {
        return Optional.ofNullable(xmlGregorianCalendar)
                .map(XMLGregorianCalendar::toGregorianCalendar)
                .map(GregorianCalendar::getTime)
                .orElse(null);
    }

    @SneakyThrows
    public static XMLGregorianCalendar toXmlDate(Date date) {
        if (date == null) {
            return null;
        }
        DatatypeFactory dtf = DatatypeFactory.newInstance();
        final GregorianCalendar gcal = new GregorianCalendar();
        gcal.setTime(date);
        return dtf.newXMLGregorianCalendar(gcal);
    }

    public static <T> void ifPresent(T value, Consumer<T> setter) {
        Optional.ofNullable(value).ifPresent(setter);
    }

    public static <T, U> void ifPresent(T value, Consumer<U> setter, Function<T, U> mapper) {
        Optional.ofNullable(value).map(mapper).ifPresent(setter);
    }

    public static void setIdentifikator(String value, Consumer<Identifikator> setter) {
        Optional.ofNullable(value).map(FintUtils::createIdentifikator).ifPresent(setter);
    }

    public static <T> void setIdentifikator(T value, Consumer<Identifikator> setter, Function<T, String> mapper) {
        Optional.ofNullable(value).map(mapper).map(FintUtils::createIdentifikator).ifPresent(setter);
    }

    public static Function<Kode, Link> linkTo(Function<String, Link> linker) {
        return kode -> linker.apply(kode.getKodeverdi());
    }

    public static Function<Kode, Link> linkTo(Class<? extends FintLinks> type, String attribute) {
        return kode -> Link.with(type, attribute, kode.getKodeverdi());
    }

    public static String externalId(Identifikator identifikator) {
        if (identifikator == null || StringUtils.isBlank(identifikator.getIdentifikatorverdi())) {
            return null;
        }
        return identifikator.getIdentifikatorverdi();
    }

    public static boolean hasTilgangsrestriksjon(SkjermingResource skjermingResource) {
        if (skjermingResource == null || skjermingResource.getTilgangsrestriksjon() == null) {
            return false;
        }
        return getIdFromLink(skjermingResource.getTilgangsrestriksjon()).isPresent();
    }

    public static Optional<String> getIdFromLink(List<Link> links) {
        return links.stream()
                .filter(Objects::nonNull)
                .map(Link::getHref)
                .filter(StringUtils::isNotBlank)
                .map(s -> StringUtils.substringAfterLast(s, "/"))
                .findFirst();
    }

}
