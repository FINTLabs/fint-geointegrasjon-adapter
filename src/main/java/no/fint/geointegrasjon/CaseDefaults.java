package no.fint.geointegrasjon;

import lombok.Data;
import no.fint.geointegrasjon.model.CaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "fint.case.defaults")
public class CaseDefaults {
    private Map<String, CaseProperties> casetype;
}
