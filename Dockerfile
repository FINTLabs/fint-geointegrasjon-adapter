FROM gcr.io/distroless/java:8 AS runtime-base

FROM eclipse-temurin:8-jdk AS certificates
COPY --from=runtime-base /etc/ssl/certs/java/cacerts /tmp/truststore.jks
COPY certs/globalsign-root-r46.crt /tmp/globalsign-root-r46.crt
RUN keytool -importcert -noprompt \
    -alias globalsign-root-r46 \
    -file /tmp/globalsign-root-r46.crt \
    -keystore /tmp/truststore.jks \
    -storetype JKS \
    -storepass changeit

FROM runtime-base
ENV JAVA_TOOL_OPTIONS=-XX:+ExitOnOutOfMemoryError
COPY --from=certificates /tmp/truststore.jks /etc/ssl/certs/java/cacerts
WORKDIR /app
COPY build/deps/external/*.jar /app/
COPY build/deps/fint/*.jar /app/
COPY build/libs/fint-geointegrasjon-adapter-*.jar /app/fint-geointegrasjon-adapter.jar
CMD ["/app/fint-geointegrasjon-adapter.jar"]
