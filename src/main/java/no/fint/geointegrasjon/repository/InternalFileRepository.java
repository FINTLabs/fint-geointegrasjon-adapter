package no.fint.geointegrasjon.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import no.fint.event.model.Event;
import no.fint.geointegrasjon.utils.FintUtils;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.arkiv.noark.DokumentfilResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Repository
@Slf4j
@ConditionalOnProperty(name = "fint.internal-files.type", havingValue = "FILE")
public class InternalFileRepository extends InternalRepository {

    @Value("${fint.internal-files.directory:file-cache}")
    private Path rootDirectory;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void putFile(Event<FintLinks> orgId, DokumentfilResource resource) throws IOException {
        String systemId = getNextSystemId();
        resource.setSystemId(FintUtils.createIdentifikator(systemId));
        Path path = rootDirectory.resolve(systemId + ".json");
        objectMapper.writeValue(Files.newOutputStream(path), resource);
        log.debug("File saved as {}", path);
    }

    @Override
    public DokumentfilResource getFile(String id) throws IOException {
        Path path = rootDirectory.resolve(id + ".json");
        return objectMapper.readValue(Files.newInputStream(path), DokumentfilResource.class);
    }

    @Override
    public DokumentfilResource silentGetFile(String id) {
        try {
            return getFile(id);
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public boolean health() {
        return Files.isDirectory(rootDirectory);
    }

    @Override
    public boolean exists(String recNo) {
        return Files.isReadable(rootDirectory.resolve(recNo + ".json"));
    }
}
