package no.fint.provider.geointegrasjon.service.fint;

import lombok.extern.slf4j.Slf4j;
import no.fint.provider.geointegrasjon.TitleFormats;
import no.fint.provider.geointegrasjon.utils.BeanPropertyLookup;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringSubstitutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TitleService {

    @Autowired
    private TitleFormats titleFormats;

    public <T> String getTitle(T object) {
        String type = StringUtils.removeEnd(StringUtils.lowerCase(object.getClass().getSimpleName()), "resource");
        if (!titleFormats.getFormat().containsKey(type)) {
            throw new IllegalArgumentException("No format defined for " + type);
        }
        String title = new StringSubstitutor(new BeanPropertyLookup<>(object)).replace(titleFormats.getFormat().get(type));
        log.info("Title: '{}'", title);
        return title;
    }
}
